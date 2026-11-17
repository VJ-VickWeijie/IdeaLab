"""Validate the Marble research draft and write replayable evidence as JSON."""

import argparse
from collections import Counter, defaultdict
from copy import deepcopy
import hashlib
import importlib.metadata
import json
from pathlib import Path
import sys

from jsonschema import Draft202012Validator

from sample import (
    DEFAULT_UPSTREAM, HERE, SNAPSHOT_DIGESTS, UPSTREAM_COMMIT,
    load_snapshot, read_json, select_topics,
)
from safety_rules import run_cases

# These source themes carry a material risk or unresolved fact in this study.
REQUIRED_MANUAL_REVIEW = {
    "mt_wHN14Unk7h", "mt_TlLE4cZgOr", "mt_BO_AHGLCk0", "mt_4pLvMN8uzL",
    "mt_8FUXG_39-C", "mt_Mf-T-fYRLX", "mt_EWiY8-opdd", "mt_HopZomN12L",
    "mt_pK6QkcKxZT", "mt_e8CZ7E5qW7", "mt_mAschyjZAT", "local:banana-identification",
}
# The experience has no permitted real activity at all for these themes.
NO_ACTIVITY = {"mt_BO_AHGLCk0", "mt_4pLvMN8uzL", "mt_8FUXG_39-C"}
BANDS = [(0, 1), (1, 2), (2, 3), (3, 6), (6, 9), (9, 13)]


def description_digest(topic):
    return hashlib.sha256(topic["description"].encode("utf-8")).hexdigest()


def compare_record(record, source, all_topics, available_ids, dependencies):
    """Check invariants that span records or require source data."""
    issues = []
    node_id = record["id"]
    knowledge = record["knowledge"]
    presentation = record["presentation"]
    activity = presentation["activity"]

    if source:
        exact = {
            "source": {
                "kind": "upstream", "topicId": source["id"], "commit": UPSTREAM_COMMIT,
                "path": "upstream/data/topics.json", "descriptionSha256": description_digest(source),
            },
            "title": source["name"], "subject": source["subject"], "domain": source["domain"],
            "sourceType": source["type"],
            "sourceAge": {"start": source["ageRangeStart"], "end": source["ageRangeEnd"]},
        }
        for key, value in exact.items():
            if knowledge[key] != value:
                issues.append(f"source mismatch: knowledge.{key}")
        if source["ageRangeStart"] > source["ageRangeEnd"]:
            issues.append("invalid upstream age range")
    else:
        if node_id != "local:banana-identification" or knowledge["source"] != {
            "kind": "local", "referenceTopicIds": ["mt_s08-QxASd2"],
        }:
            issues.append("unexpected local identity or related origin")
        if not set(knowledge["source"].get("referenceTopicIds", [])) <= all_topics:
            issues.append("unknown local reference topic")

    bands = [item["ageBand"] for item in record["adaptation"]]
    if len(bands) != len(set(bands)):
        issues.append("duplicate adaptation band")
    if not record["exploration"]:
        issues.append("no optional exploration entry")
    targets = set()
    for link in record["exploration"]:
        target = link["targetId"]
        if target == node_id or target in targets or target not in available_ids:
            issues.append(f"invalid sample exploration target: {target}")
        targets.add(target)
        if link["relation"] == "upstream_dependency" and (node_id, target) not in dependencies:
            issues.append(f"directional upstream dependency not found: {target}")

    if presentation["primaryMedium"] not in {asset["medium"] for asset in presentation["media"]}:
        issues.append("primary medium missing from design inventory")
    if any(asset["availability"] == "available" for asset in presentation["media"]):
        issues.append("research study does not ship reviewed assets")
    fallbacks = [presentation["fallback"]]
    if activity is not None:
        fallbacks.append(activity["fallback"])
        if activity["risk"] == "high" or "unknown" in activity["hazards"]:
            issues.append("this study must omit real activities carrying high/unknown risk")
    if any(fallback["medium"] != "text" for fallback in fallbacks):
        issues.append("research fallback must use actual local text")
    if node_id in NO_ACTIVITY and activity is not None:
        issues.append("high-risk theme must use simulated experience only")
    status = record["safetyQuality"]["status"]
    if node_id in REQUIRED_MANUAL_REVIEW and status != "manual_review_required":
        issues.append("missing manual review for high-risk or disputed theme")
    for evidence in record["safetyQuality"]["evidence"]:
        if not evidence.startswith("https://") and not (HERE / evidence.split("#", 1)[0]).is_file():
            issues.append(f"missing local evidence: {evidence}")
    return issues


def schema_regressions(validator, sample, banana):
    """Mutate valid fixtures one property at a time to check the safety contract."""
    mutants = []
    for name, record, path, value in [
        ("camera_required", sample, ("presentation", "fallback", "requiresCamera"), True),
        ("upload_required", sample, ("presentation", "fallback", "requiresUpload"), True),
        ("network_required", sample, ("presentation", "fallback", "offline"), False),
        ("fake_asset", sample, ("presentation", "media"), [{"medium": "audio", "availability": "available"}]),
        ("bad_taxonomy", sample, ("knowledge", "tags"), ["anything"]),
        ("local_upstream_id", banana, ("id",), sample["id"]),
        ("invented_local_age", banana, ("knowledge", "sourceAge"), {"start": 1, "end": 2}),
    ]:
        record = deepcopy(record)
        parent = record
        for key in path[:-1]:
            parent = parent[key]
        parent[path[-1]] = value
        mutants.append((name, record))
    activity = deepcopy(next(record for record in (sample, banana) if record["presentation"]["activity"]))
    activity["safetyQuality"]["status"] = "research_reviewed"
    for name, key, value in [
        ("mandatory_activity", "optional", False),
        ("high_risk_auto_approved", "risk", "high"),
        ("unknown_hazard_auto_approved", "hazards", ["unknown"]),
    ]:
        record = deepcopy(activity)
        record["presentation"]["activity"][key] = value
        mutants.append((name, record))
    return [{"id": name, "passed": not validator.is_valid(record)} for name, record in mutants]


def coverage_for(records):
    knowledge = [record["knowledge"] for record in records]
    age_counts = {}
    for start, stop in BANDS:
        label = f"{start}-{'12' if stop == 13 else stop}"
        age_counts[label] = sum(
            item["sourceAge"]["start"] < stop and item["sourceAge"]["end"] >= start for item in knowledge
        )
    return {
        "subject": dict(sorted(Counter(item["subject"] for item in knowledge).items())),
        "sourceType": dict(sorted(Counter(item["sourceType"] for item in knowledge).items())),
        "sourceAgeOverlap": age_counts,
        "adaptation": dict(sorted(Counter(
            item["ageBand"] for record in records for item in record["adaptation"]
        ).items())),
        "primaryTags": dict(sorted(Counter(item["tags"][0] for item in knowledge).items())),
        "allTags": dict(sorted(Counter(tag for item in knowledge for tag in item["tags"]).items())),
        "multiLabel": sum(len(item["tags"]) > 1 for item in knowledge),
        "primaryMedium": dict(sorted(Counter(record["presentation"]["primaryMedium"] for record in records).items())),
        "entryMode": dict(sorted(Counter(record["presentation"]["entry"]["mode"] for record in records).items())),
        "activity": dict(sorted(Counter(
            record["presentation"]["activity"]["risk"] if record["presentation"]["activity"] else "none"
            for record in records
        ).items())),
        "reviewStatus": dict(sorted(Counter(record["safetyQuality"]["status"] for record in records).items())),
        "proposedOrMissingMedia": dict(sorted(Counter(
            asset["availability"] for record in records for asset in record["presentation"]["media"]
        ).items())),
        "explorationLinks": dict(sorted(Counter(link["relation"] for record in records for link in record["exploration"]).items())),
    }


def build_evidence(upstream):
    schema = read_json(HERE / "presentation.schema.json")
    Draft202012Validator.check_schema(schema)
    validator = Draft202012Validator(schema)
    snapshot = load_snapshot(upstream)
    topics = snapshot["topics.json"]["topics"]
    dependencies = snapshot["dependencies.json"]["dependencies"]
    if len(dependencies) != 4002:
        raise ValueError("Expected exactly 4,002 upstream dependencies.")
    chosen = select_topics(topics, read_json(HERE / "sample-design.json"))
    selected_ids = [topic["id"] for topic in chosen]
    chosen_by_id = {topic["id"]: topic for topic in chosen}
    records = read_json(HERE / "nodes.json")
    banana = read_json(HERE / "banana.json")
    if not isinstance(records, list) or not isinstance(banana, dict):
        raise ValueError("Expected a nodes.json array and a banana.json object.")
    actual_ids = [record.get("id") if isinstance(record, dict) else None for record in records]
    all_topics = {topic["id"] for topic in topics}
    available = {node_id for node_id in [*actual_ids, banana.get("id")] if isinstance(node_id, str)}
    edges = {(edge["topicId"], edge["prerequisiteId"]) for edge in dependencies}

    checks = []
    well_formed = []
    for number, (node_id, record) in enumerate(zip(
        [*actual_ids, banana.get("id")], [*records, banana], strict=True
    ), start=1):
        issues = [
            f"{'/'.join(str(part) for part in error.absolute_path) or '/'}: {error.message}"
            for error in validator.iter_errors(record)
        ]
        if not issues:
            issues = compare_record(record, chosen_by_id.get(node_id), all_topics, available, edges)
            well_formed.append(record)
        checks.append({"id": node_id if isinstance(node_id, str) else f"row-{number}",
                       "passed": not issues, "failures": issues})

    source_records = [record for record in well_formed if record["knowledge"]["source"]["kind"] == "upstream"]
    coverage = coverage_for(source_records)
    coverage_checks = {
        "roster_matches_exact_order": actual_ids == selected_ids,
        "all_upstream_subjects": set(coverage["subject"]) == {topic["subject"] for topic in topics},
        "all_upstream_types": set(coverage["sourceType"]) == {topic["type"] for topic in topics},
        "all_taxonomy_tags_represented": set(coverage["allTags"]) == set(
            schema["$defs"]["knowledge"]["properties"]["tags"]["items"]["enum"]
        ),
        "all_taxonomy_tags_primary": set(coverage["primaryTags"]) == set(coverage["allTags"]),
        "local_id_not_upstream": banana.get("id") == "local:banana-identification" and banana["id"] not in all_topics,
    }

    synthetic = run_cases(HERE / "safety-cases.json")
    if source_records and any(record is banana for record in well_formed) and (
        source_records[0]["presentation"]["activity"] or banana["presentation"]["activity"]
    ):
        negative = schema_regressions(validator, source_records[0], banana)
    else:
        negative = [{"id": "schema_fixture_unavailable", "passed": False}]
    blind = read_json(HERE / "blind-labels.json")
    if blind["sourceSha256"] != SNAPSHOT_DIGESTS["topics.json"]:
        raise ValueError("Blind labels were recorded against a different source snapshot.")
    records_by_id = {record["id"]: record for record in source_records}
    label_comparison = []
    for node_id, label in blind["labels"].items():
        record = records_by_id.get(node_id)
        author_primary = record["knowledge"]["tags"][0] if record else None
        label_comparison.append({
            "id": node_id, "authorPrimary": author_primary, "blindPrimary": label["primary"],
            "exact": author_primary == label["primary"],
            "withinBlindAlternatives": author_primary in {label["primary"], *label["alternatives"]},
        })

    task_checks = [*checks, *negative, *synthetic]
    failures = [check["id"] for check in task_checks if not check["passed"]]
    failures.extend(name for name, passed in coverage_checks.items() if not passed)
    failures.extend(
        row["id"] + ": blind label outside advance alternatives"
        for row in label_comparison if not row["withinBlindAlternatives"]
    )
    groups = defaultdict(Counter)
    for case in synthetic:
        groups[case["group"]][case["actual"]["decision"]] += 1
    return {
        "result": "pass" if not failures else "fail", "failures": failures,
        "formatVersion": "0.1.0",
        "toolchain": {"python": sys.version.split()[0], "jsonschema": importlib.metadata.version("jsonschema")},
        "source": {"upstreamCommit": UPSTREAM_COMMIT, "sha256": SNAPSHOT_DIGESTS,
                   "topics": len(topics), "dependencies": len(dependencies)},
        "recordChecks": checks, "coverage": coverage, "coverageChecks": coverage_checks,
        "schemaNegativeChecks": negative,
        "blindLabels": label_comparison,
        "manualReviewQueue": [
            {"id": record["id"], "reasons": record["safetyQuality"]["reasons"]}
            for record in well_formed if record["safetyQuality"]["status"] == "manual_review_required"
        ],
        "safetyOutcomeCounts": dict(Counter(row["actual"]["decision"] for row in synthetic)),
        "safetyCasesByGroup": {group: dict(values) for group, values in groups.items()},
        "safetyCases": synthetic,
    }


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--upstream", type=Path, default=DEFAULT_UPSTREAM)
    parser.add_argument("--output", type=Path)
    args = parser.parse_args()
    evidence = build_evidence(args.upstream)
    output = json.dumps(evidence, ensure_ascii=False, indent=2) + "\n"
    if args.output:
        args.output.write_text(output, encoding="utf-8")
    else:
        print(output, end="")
    return 1 if evidence["failures"] else 0


if __name__ == "__main__":
    raise SystemExit(main())

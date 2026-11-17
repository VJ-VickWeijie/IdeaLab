"""Reproduce the deliberate sample from the locked Marble upstream snapshot."""

import argparse
import hashlib
import json
from pathlib import Path

HERE = Path(__file__).resolve().parent
DEFAULT_UPSTREAM = HERE.parents[1] / "upstream"
UPSTREAM_COMMIT = "2926da338fc9db583c2bd1d241957e8b0fe1d4ce"
SNAPSHOT_DIGESTS = {
    "topics.json": "fd96ce5963e24f11dcfb549fee46d3cb6afae5d545dc30f4d01366a406444f35",
    "dependencies.json": "ed38d8a265699d1687a7fa8166c528999e21771d54449a84ea5362dc1d0e7758",
}


def read_json(path):
    return json.loads(path.read_text(encoding="utf-8"))


def load_snapshot(upstream):
    """Check that the input bytes match both the pinned values and the manifest."""
    commit = (upstream / "UPSTREAM_COMMIT.txt").read_text(encoding="utf-8").strip()
    if commit != UPSTREAM_COMMIT:
        raise ValueError(f"Unexpected upstream commit: {commit}")
    manifest = read_json(upstream / "manifest.json")
    snapshot = {}
    for name, expected in SNAPSHOT_DIGESTS.items():
        raw = (upstream / "data" / name).read_bytes()
        digest = hashlib.sha256(raw).hexdigest()
        if digest != expected or manifest["files"][name] != {"bytes": len(raw), "sha256": digest}:
            raise ValueError(f"Snapshot digest/byte count mismatch: {name}")
        snapshot[name] = json.loads(raw)
    return snapshot


def select_topics(topics, design):
    """Use the declared ID roster, with no random draws or dependence on row order."""
    index = {topic["id"]: topic for topic in topics}
    if len(index) != len(topics) or len(index) != 1912:
        raise ValueError("Expected 1,912 uniquely keyed upstream topics.")
    slots = design["selections"]
    ids = [slot["id"] for slot in slots]
    if len(ids) != 30 or len(set(ids)) != 30:
        raise ValueError("Expected exactly 30 unique research IDs.")
    for required in ("mt_wHN14Unk7h", "mt_TlLE4cZgOr"):
        if required not in ids:
            raise ValueError(f"Missing task-book anchor: {required}")
    if not all(isinstance(slot["reason"], str) and slot["reason"].strip() for slot in slots):
        raise ValueError("Each declared sample must carry a selection reason.")
    return [index[topic_id] for topic_id in ids]


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--upstream", type=Path, default=DEFAULT_UPSTREAM)
    args = parser.parse_args()
    snapshot = load_snapshot(args.upstream)
    chosen = select_topics(snapshot["topics.json"]["topics"], read_json(HERE / "sample-design.json"))
    print(json.dumps({"upstreamCommit": UPSTREAM_COMMIT, "topics": chosen}, ensure_ascii=False, indent=2))


if __name__ == "__main__":
    main()

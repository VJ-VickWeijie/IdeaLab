#!/usr/bin/env python3
"""Check the bundled Marble content tables and media before packaging."""

import argparse
from hashlib import sha256
import json
from pathlib import Path, PurePosixPath
import sys


BANDS = {"0-1", "1-2"}
LANGUAGE = "yue-Hant-HK"
TABLES = {"knowledge", "presentations", "relations", "groups", "media", "idAliases"}
MEDIA_FORMATS = {"image": {".jpg", ".jpeg", ".webp", ".png"}, "audio": {".m4a"}}


def require(condition, message):
    if not condition:
        raise ValueError(message)


def text(value):
    return isinstance(value, str) and bool(value.strip())


def object_rows(value, name):
    require(isinstance(value, list), f"{name} must contain a JSON array")
    for row in value:
        require(isinstance(row, dict), f"{name} has a non-object row")
    return value


def path_in_pack(root, value):
    require(text(value), "Asset path must be a nonempty string")
    path = PurePosixPath(value)
    require(
        len(path.parts) > 1
        and path.parts[0] == "content"
        and all(part not in {".", ".."} for part in path.parts)
        and path.as_posix() == value
        and "\\" not in value,
        f"Invalid pack path: {value}",
    )
    result = (root / Path(*path.parts[1:])).resolve()
    require(root in result.parents, f"Asset escapes pack: {value}")
    return result


def verified_file(root, record):
    value = record.get("path")
    path = path_in_pack(root, value)
    raw = path.read_bytes()
    require(raw and sha256(raw).hexdigest() == record.get("sha256"), f"SHA-256 mismatch: {value}")
    return path, raw


def read_tables(root, manifest):
    mapping = manifest.get("tables")
    require(isinstance(mapping, dict) and set(mapping) == TABLES, "Unexpected content table manifest")
    return {
        name: object_rows(json.loads(verified_file(root, record)[1]), name)
        for name, record in mapping.items()
    }


def indexed(rows, label):
    result = {}
    for row in rows:
        key = row.get("id")
        require(text(key) and key not in result, f"Invalid or duplicate {label} ID: {key}")
        result[key] = row
    return result


def check_media(root, rows, release):
    assets = indexed(rows, "media")
    paths = set()
    size = 0
    for key, asset in assets.items():
        kind = asset.get("kind")
        path, raw = verified_file(root, asset)
        require(kind in MEDIA_FORMATS and path.suffix.lower() in MEDIA_FORMATS[kind], f"{key}: wrong media type")
        require(path not in paths and asset.get("bytes") == len(raw), f"{key}: duplicate path or invalid size")
        require(text(asset.get("credit")), f"{key}: missing asset credit")
        paths.add(path)
        size += len(raw)
        if kind == "audio":
            require(raw[4:8] == b"ftyp" and asset.get("durationMs", 0) > 0, f"{key}: invalid M4A")
        elif path.suffix.lower() in {".jpg", ".jpeg"}:
            require(raw[:2] == b"\xff\xd8" and raw[-2:] == b"\xff\xd9", f"{key}: invalid JPEG")
        if kind == "image":
            require(asset.get("width", 0) > 0 and asset.get("height", 0) > 0, f"{key}: missing image dimensions")
        if release:
            require(asset.get("reviewStatus") == "approved" and text(asset.get("approvalRef")),
                    f"{key}: media approval reference required")
            require(text(asset.get("license")) and text(asset.get("sourceUrl")),
                    f"{key}: license or original source missing")
            require(asset.get("captureKind") == ("photo" if kind == "image" else "recorded-speech"),
                    f"{key}: family pack requires actual photos or authorized recordings")
    return assets, size


def check_presentations(rows, nodes, media, release):
    keys = set()
    for row in rows:
        node = row.get("nodeId")
        band = row.get("ageBand")
        key = (node, band)
        require(node in nodes and band in BANDS and key not in keys, f"Invalid or duplicate presentation: {key}")
        require(row.get("language") == LANGUAGE, f"{key}: incorrect locale")
        required = ("name", "answer", "fallbackText", "imageDescription", "transcript", "caregiverText")
        require(all(text(row.get(field)) for field in required), f"{key}: presentation text missing")
        for field, kind in (("imageId", "image"), ("audioId", "audio"), ("caregiverAudioId", "audio")):
            media_id = row.get(field)
            if media_id is None:
                require(not release or field == "caregiverAudioId", f"{key}: missing {field}")
            else:
                require(media_id in media and media[media_id]["kind"] == kind, f"{key}: bad {field}")
        if release:
            require(row.get("reviewStatus") == "approved" and text(row.get("approvalRef")),
                    f"{key}: fact, language, and safety sign-off required")
        keys.add(key)
    require(keys == {(node, band) for node in nodes for band in BANDS}, "A node lacks a presentation for one age band")


def check_relations(rows, nodes):
    from_nodes = {node: {} for node in nodes}
    for row in rows:
        origin, target, order = row.get("fromId"), row.get("toId"), row.get("order")
        require(origin in nodes and target in nodes and target != origin, f"Broken or self relation: {origin} → {target}")
        by_order = from_nodes[origin]
        require(type(order) is int and order >= 0 and order not in by_order, f"{origin}: invalid or duplicate relation order")
        require(target not in by_order.values() and text(row.get("label")), f"{origin}: duplicate target or blank relation")
        by_order[order] = target
    for node, relations in from_nodes.items():
        require(2 <= len(relations) <= 3, f"{node}: map needs two or three distinct related nodes")


def check_groups(rows, nodes):
    seen = set()
    for row in rows:
        key = row.get("id"), row.get("ageBand")
        require(text(key[0]) and key[1] in BANDS and key not in seen, f"Invalid or duplicate group: {key}")
        ids = row.get("nodeIds")
        require(text(row.get("label")) and isinstance(ids, list) and 1 <= len(ids) <= 8, f"{key}: invalid group")
        require(all(node in nodes for node in ids) and len(ids) == len(set(ids)), f"{key}: unknown or repeated card")
        seen.add(key)
    require({band for _, band in seen} == BANDS, "Both age bands need a group")


def check_id_aliases(rows, nodes):
    aliases = {}
    for row in rows:
        old, new = row.get("oldId"), row.get("newId")
        require(text(old) and old not in aliases and old not in nodes, f"Invalid or duplicate old node ID: {old}")
        require(new is None or text(new), f"{old}: invalid replacement ID")
        aliases[old] = new
    for start in aliases:
        path = set()
        current = start
        while current in aliases:
            require(current not in path, f"Alias cycle: {start}")
            path.add(current)
            current = aliases[current]
        require(current is None or current in nodes, f"{start}: replacement ID does not resolve")


def validate(root, release=False):
    root = root.resolve()
    manifest = json.loads((root / "manifest.json").read_bytes())
    require(type(manifest.get("schemaVersion")) is int and manifest["schemaVersion"] == 1, "Unsupported schema")
    require(text(manifest.get("contentVersion")), "Missing content version")
    require(manifest.get("language") == LANGUAGE, "Unexpected pack locale")
    require(manifest.get("status") in {"fixture", "approved"}, "Missing fixture or approved status")
    if release:
        require(manifest["status"] == "approved", "Release requires an approved content pack. Fixtures cannot ship")
        require(text(manifest.get("approvalRef")), "Family pack approval reference required")
    tables = read_tables(root, manifest)
    nodes = indexed(tables["knowledge"], "knowledge")
    require(nodes, "Empty content pack")
    for key, node in nodes.items():
        source = node.get("source")
        aliases = node.get("aliases")
        require(text(node.get("category")) and isinstance(aliases, list) and all(text(a) for a in aliases),
                f"{key}: missing category or valid aliases")
        require(isinstance(source, dict) and source.get("kind") in {"local", "upstream"}, f"{key}: missing source")
        if source["kind"] == "local":
            require(key.startswith("local:"), f"{key}: local knowledge needs the local namespace")
    media, byte_count = check_media(root, tables["media"], release)
    check_presentations(tables["presentations"], nodes, media, release)
    check_relations(tables["relations"], nodes)
    check_groups(tables["groups"], nodes)
    check_id_aliases(tables["idAliases"], nodes)
    return (
        manifest["contentVersion"], len(nodes), len(tables["presentations"]), len(tables["relations"]),
        len(tables["groups"]), len(media), byte_count,
    )


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("pack", type=Path, nargs="?", default=Path("app/src/debug/assets/content"))
    parser.add_argument("--release", action="store_true", help="require approved family-release evidence")
    args = parser.parse_args()
    try:
        version, nodes, cards, links, groups, media, size = validate(args.pack, args.release)
    except (OSError, ValueError, TypeError, KeyError, AttributeError) as error:
        print(f"Content check failed: {error}", file=sys.stderr)
        return 1
    print(f"{version}: {nodes} nodes, {cards} presentations, {links} relations, {groups} age-band groups, "
          f"{media} media assets ({size} bytes)")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())

#!/usr/bin/env python3
"""Preflight a Marble APK replacement using Android SDK tools.

This is a static preflight, NOT proof that settings/history survive a real install.
The device-level test in M5-SIGNING-AND-UPGRADE.md is still mandatory.
"""

import argparse
from dataclasses import dataclass
from pathlib import Path
import re
import subprocess
import sys


@dataclass(frozen=True)
class ApkIdentity:
    application_id: str
    version_code: int
    version_name: str
    certificate_sha256: str


def parse_badging(output: str) -> tuple[str, int, str]:
    package_line = re.search(r"^package:\s+(.+)$", output, re.MULTILINE)
    if package_line is None:
        raise ValueError("aapt2 output has no package line")
    attributes = dict(re.findall(r"(\w+)='([^']*)'", package_line.group(1)))
    if not attributes.get("name") or not attributes.get("versionCode"):
        raise ValueError("aapt2 package line has no name or versionCode")
    try:
        version_code = int(attributes["versionCode"])
    except ValueError as error:
        raise ValueError("Invalid versionCode in aapt2 output") from error
    return attributes["name"], version_code, attributes.get("versionName", "")


def parse_certificates(output: str) -> str:
    hashes = re.findall(
        r"Signer\s+#\d+\s+certificate\s+SHA-256\s+digest:\s*([0-9A-Fa-f:]+)",
        output,
        re.IGNORECASE,
    )
    if len(hashes) != 1:
        raise ValueError(f"Expected one APK signer certificate, found {len(hashes)}")
    fingerprint = hashes[0].replace(":", "").lower()
    if len(fingerprint) != 64:
        raise ValueError("Unexpected SHA-256 certificate fingerprint length")
    return fingerprint


def run_tool(*args: str) -> str:
    result = subprocess.run(args, capture_output=True, text=True, check=True)
    return result.stdout


def inspect(path: Path, aapt2: str, apksigner: str) -> ApkIdentity:
    if not path.is_file():
        raise ValueError(f"APK file not found: {path}")
    app_id, version_code, version_name = parse_badging(
        run_tool(aapt2, "dump", "badging", str(path))
    )
    fingerprint = parse_certificates(run_tool(apksigner, "verify", "--print-certs", str(path)))
    return ApkIdentity(app_id, version_code, version_name, fingerprint)


def compatibility_errors(old: ApkIdentity, new: ApkIdentity, required_id: str) -> list[str]:
    failures = []
    if old.application_id != required_id or new.application_id != required_id:
        failures.append(f"Both APKs must have application ID {required_id}")
    if old.certificate_sha256 != new.certificate_sha256:
        failures.append("Signing certificate SHA-256 differs")
    if new.version_code <= old.version_code:
        failures.append("New versionCode must be greater than the installed versionCode")
    return failures


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("old_apk", type=Path)
    parser.add_argument("new_apk", type=Path)
    parser.add_argument("--aapt2", default="aapt2", help="Android SDK aapt2 executable")
    parser.add_argument("--apksigner", default="apksigner", help="Android SDK apksigner executable")
    parser.add_argument("--application-id", default="com.idealab.marble")
    args = parser.parse_args()

    try:
        old = inspect(args.old_apk, args.aapt2, args.apksigner)
        new = inspect(args.new_apk, args.aapt2, args.apksigner)
    except (ValueError, OSError, subprocess.CalledProcessError) as error:
        print(f"ERROR: APK inspection failed: {error}", file=sys.stderr)
        return 2

    print(f"OLD: {old.application_id} code={old.version_code} name={old.version_name}")
    print(f"NEW: {new.application_id} code={new.version_code} name={new.version_name}")
    print(f"SIGNER OLD: {old.certificate_sha256}")
    print(f"SIGNER NEW: {new.certificate_sha256}")
    failures = compatibility_errors(old, new, args.application_id)
    if failures:
        for issue in failures:
            print(f"FAIL: {issue}", file=sys.stderr)
        return 1
    print("PASS: Static update identity preflight. Device data retention is NOT yet verified.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())

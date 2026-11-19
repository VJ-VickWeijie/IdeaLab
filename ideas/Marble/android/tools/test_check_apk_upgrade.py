"""Offline unit tests for the APK update preflight."""

import unittest

from check_apk_upgrade import ApkIdentity, compatibility_errors, parse_badging, parse_certificates


SHA_A = "a" * 64
SHA_B = "b" * 64


def identity(app_id="com.idealab.marble", code=1, cert=SHA_A):
    return ApkIdentity(app_id, code, "0.2.1-preview", cert)


class UpgradePreflightTest(unittest.TestCase):
    def test_parses_aapt2_package(self):
        self.assertEqual(
            parse_badging("package: name='com.idealab.marble' versionCode='2' versionName='0.2.2-preview'\n"),
            ("com.idealab.marble", 2, "0.2.2-preview"),
        )

    def test_parses_certificate(self):
        self.assertEqual(parse_certificates(f"Signer #1 certificate SHA-256 digest: {SHA_A}\n"), SHA_A)

    def test_rejects_missing_or_multiple_certificates(self):
        with self.assertRaises(ValueError):
            parse_certificates("No certificate information")
        with self.assertRaises(ValueError):
            parse_certificates(f"Signer #1 certificate SHA-256 digest: {SHA_A}\nSigner #2 certificate SHA-256 digest: {SHA_B}")

    def test_accepts_valid_upgrade(self):
        self.assertEqual(compatibility_errors(identity(), identity(code=2), "com.idealab.marble"), [])

    def test_rejects_package_change(self):
        self.assertTrue(compatibility_errors(identity(), identity(app_id="com.idealab.marble.dev", code=2), "com.idealab.marble"))

    def test_rejects_certificate_change(self):
        self.assertTrue(compatibility_errors(identity(), identity(code=2, cert=SHA_B), "com.idealab.marble"))

    def test_rejects_non_increasing_version(self):
        self.assertTrue(compatibility_errors(identity(), identity(code=1), "com.idealab.marble"))
        self.assertTrue(compatibility_errors(identity(code=2), identity(code=1), "com.idealab.marble"))


if __name__ == "__main__":
    unittest.main()

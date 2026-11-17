"""Deterministic fixture evaluation for the Marble research milestone."""

import argparse
import json
from pathlib import Path


# These profiles represent curated research templates. Production approval and
# an authenticated action/asset registry are outside this experiment.
OBSERVATION_SETTINGS = frozenset({"outdoor", "covered_outdoor", "window"})
EXPOSED_SETTINGS = OBSERVATION_SETTINGS | {
    "balcony", "exterior_door", "plumbing", "mains_device",
}
CANDIDATE_FIELDS = {
    "action", "setting", "requiresCamera", "requiresUpload", "requiresNetwork", "optional",
}
FORBIDDEN_ACTIONS = {
    "observe_lightning_live": "live_lightning",
    "record_lightning_live": "live_lightning",
    "mix_cleaners": "chemical_contact",
    "handle_hazardous_chemicals": "chemical_contact",
    "smell_unknown_chemical": "chemical_contact",
    "approach_wildlife": "wildlife_contact",
    "touch_wildlife": "wildlife_contact",
    "feed_wildlife": "wildlife_contact",
    "lure_wildlife": "wildlife_contact",
    "taste_food": "food_ingestion",
    "eat_choking_hazard": "food_ingestion",
    "mouth_small_object": "small_object_ingestion",
    "ignite_fire": "fire",
    "enter_deep_water": "deep_water",
    "use_sharp_blade": "sharp_tools",
}
ACTIVITY_PROFILES = {
    "observe_puddle": {
        "settings": OBSERVATION_SETTINGS, "min_age": 2,
        "supervision": "adult_present", "checks": ("slips_traffic",),
    },
    "observe_birds": {
        "settings": OBSERVATION_SETTINGS | {"safe_indoor"}, "min_age": 1,
        "supervision": "adult_present", "checks": ("wild_animals",),
    },
    "observe_banana_no_tasting": {
        "settings": {"safe_indoor"}, "min_age": 0,
        "supervision": "adult_leads", "checks": ("choking_allergy",),
    },
    "compare_large_objects": {
        "settings": {"safe_indoor"}, "min_age": 1,
        "supervision": "adult_present", "checks": ("small_objects",),
    },
    "observe_demonstration": {
        "settings": {"safe_indoor"}, "min_age": 6,
        "supervision": "adult_leads", "checks": ("demonstration_controls",),
    },
}


def evaluate(candidate, context):
    """Map a typed action and simulated trusted context to decision, reason and route."""
    if not isinstance(context, dict):
        context = {}

    def alternate(decision, reason):
        route = "local_fallback" if context.get("fallbackAvailable") is True else "end"
        return {"decision": decision, "reason": reason, "route": route}

    if not isinstance(candidate, dict):
        return alternate("fallback", "malformed_candidate")
    action = candidate.get("action")
    setting = candidate.get("setting")
    if not isinstance(action, str):
        return alternate("fallback", "malformed_candidate")
    if action in FORBIDDEN_ACTIONS:
        return alternate("block", FORBIDDEN_ACTIONS[action])
    if not isinstance(setting, str):
        return alternate("fallback", "malformed_candidate")

    if setting in EXPOSED_SETTINGS:
        weather = context.get("weather")
        if not isinstance(weather, dict):
            return alternate("fallback", "weather_unverified")
        advisory = weather.get("advisory")
        signal = weather.get("signal")
        minutes = weather.get("minutesSinceLastSignal")
        if advisory == "alert" or signal in ("thunder", "lightning"):
            return alternate("block", "weather_active")
        if type(minutes) is int and 0 <= minutes < 30:
            return alternate("block", "weather_wait")
        if weather.get("current") is not True:
            return alternate("fallback", "weather_unverified")
        if advisory != "clear" or signal not in ("none", "recent"):
            return alternate("fallback", "weather_unverified")
        if signal == "recent" and (type(minutes) is not int or minutes < 0):
            return alternate("fallback", "weather_unverified")
        if signal == "none" and minutes is not None:
            return alternate("fallback", "weather_unverified")

    profile = ACTIVITY_PROFILES.get(action)
    if profile is None:
        return alternate("fallback", "unknown_action")
    if setting not in profile["settings"]:
        return alternate("fallback", "unsupported_setting")
    if set(candidate) - CANDIDATE_FIELDS:
        return alternate("fallback", "unexpected_candidate_fields")
    if candidate.get("requiresCamera") is not False or candidate.get("requiresUpload") is not False:
        return alternate("fallback", "capture_or_upload")
    if candidate.get("requiresNetwork") is not False:
        return alternate("fallback", "network_dependency")
    if candidate.get("optional") is not True:
        return alternate("fallback", "activity_not_optional")

    # Never use approval, safety verdicts, risk, free text or routing supplied by
    # the candidate. The test harness supplies editorial and context facts here.
    editorial = context.get("editorial")
    if not isinstance(editorial, dict) or editorial.get("origin") != "curated":
        return alternate("fallback", "untrusted_candidate")
    if (
        editorial.get("action") != action
        or editorial.get("setting") != setting
    ):
        return alternate("fallback", "registration_mismatch")
    risk = editorial.get("risk")
    if risk == "high":
        return alternate("human_review", "high_risk")
    if risk not in ("low", "moderate"):
        return alternate("fallback", "risk_unknown")
    if editorial.get("review") == "fact_disputed":
        return alternate("human_review", "fact_disputed")
    if editorial.get("review") == "pending":
        return alternate("human_review", "review_pending")
    if editorial.get("review") != "accepted_for_simulation":
        return alternate("fallback", "review_unverified")

    age = context.get("age")
    if type(age) is not int or not profile["min_age"] <= age <= 12:
        return alternate("fallback", "age_unverified_or_ineligible")
    adult = context.get("adult")
    if adult != "leads" and (adult != "present" or profile["supervision"] == "adult_leads"):
        return alternate("fallback", "supervision_missing")
    if context.get("access") is not True:
        return alternate("fallback", "access_unconfirmed")
    if context.get("environment") is not True:
        return alternate("fallback", "environment_unconfirmed")
    checks = context.get("checks")
    if not isinstance(checks, dict):
        return alternate("fallback", "hazard_unconfirmed")
    for hazard in profile["checks"]:
        if checks.get(hazard) == "unsafe":
            return alternate("block", "hazard_present")
        if checks.get(hazard) != "clear":
            return alternate("fallback", "hazard_unconfirmed")
    return {"decision": "allow", "reason": "constraints_satisfied", "route": "real_activity"}


def run_cases(path):
    fixture = json.loads(Path(path).read_text(encoding="utf-8"))
    cases = fixture["cases"]
    ids = [case["id"] for case in cases]
    if not ids or not all(ids) or len(set(ids)) != len(ids):
        raise ValueError("Case IDs must be nonempty and unique.")
    results = []
    for case in cases:
        actual = evaluate(case["candidate"], case["context"])
        results.append({
            "id": case["id"],
            "group": case["group"],
            "expected": case["expected"],
            "actual": actual,
            "passed": actual == case["expected"],
        })
    return results


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("fixtures", nargs="?", type=Path, default=Path(__file__).with_name("safety-cases.json"))
    args = parser.parse_args()
    results = run_cases(args.fixtures)
    print(json.dumps(results, ensure_ascii=False, indent=2))
    return 0 if all(result["passed"] for result in results) else 1


if __name__ == "__main__":
    raise SystemExit(main())

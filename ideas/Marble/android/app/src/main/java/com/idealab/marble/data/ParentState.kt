package com.idealab.marble.data

import java.time.LocalDate

enum class AgeMode { AUTO, INFANT, TODDLER }

enum class Depth { BASIC, MORE }

data class AgeSelection(val band: AgeBand, val outOfRange: Boolean)

data class ResumeAnchor(val nodeId: String, val groupId: String? = null)

data class ParentState(
    val birthDate: LocalDate? = null,
    val ageMode: AgeMode = AgeMode.AUTO,
    val depth: Depth = Depth.BASIC,
    val history: List<String> = emptyList(),
    val resume: ResumeAnchor? = null,
    val generation: Long = 0,
) {
    fun age(today: LocalDate = LocalDate.now()): AgeSelection {
        if (ageMode == AgeMode.INFANT) return AgeSelection(AgeBand.INFANT, false)
        if (ageMode == AgeMode.TODDLER) return AgeSelection(AgeBand.TODDLER, false)
        val birth = birthDate ?: return AgeSelection(AgeBand.INFANT, false)
        if (today < birth.plusYears(1)) return AgeSelection(AgeBand.INFANT, false)
        return AgeSelection(AgeBand.TODDLER, today >= birth.plusYears(2))
    }
}

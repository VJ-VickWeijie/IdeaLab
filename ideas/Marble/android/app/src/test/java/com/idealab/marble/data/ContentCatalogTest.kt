package com.idealab.marble.data

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Test

class ContentCatalogTest {
    @Test
    fun offlineSearchNormalizesAndRanksExactPrefixAndSubstring() {
        val catalogue = PackFixture().load()
        assertEquals(listOf(BANANA, BREAD, APPLE), catalogue.search("  ＢＡＮＡＮＡ　", AgeBand.INFANT).map { it.id })
        assertEquals(listOf(BANANA), catalogue.search("香蕉", AgeBand.TODDLER).map { it.id })
        assertEquals(emptyList<Knowledge>(), catalogue.search("　", AgeBand.INFANT))
        assertEquals(emptyList<Knowledge>(), catalogue.search("missing", AgeBand.TODDLER))
        assertEquals(listOf(APPLE, BREAD), catalogue.related(BANANA).map { it.toId })
    }

    @Test
    fun missingAssetKeepsTranscriptAndCanRecoverOnNextLoad() {
        val fixture = PackFixture()
        val location = "content/media/banana.m4a"
        val original = fixture.files.remove(location)!!
        val degraded = fixture.load()
        val presentation = degraded.presentation(BANANA, AgeBand.INFANT)!!
        assertEquals("睇吓，係香蕉。", presentation.transcript)
        assertNotNull(degraded.asset(presentation.imageId))
        assertNull(degraded.asset(presentation.audioId))
        fixture.files[location] = original
        assertNotNull(fixture.load().asset(presentation.audioId))
    }

    @Test
    fun rejectsUnsupportedSchema() {
        val fixture = PackFixture()
        fixture.manifest.put("schemaVersion", 2)
        assertThrows(IllegalArgumentException::class.java, fixture::load)
    }

    @Test
    fun rejectsChangedTableBytes() {
        val fixture = PackFixture()
        fixture.files["content/groups.json"] = "[]".toByteArray()
        assertThrows(IllegalArgumentException::class.java, fixture::load)
    }

    @Test
    fun rejectsSelfRelationEvenWithValidTableChecksum() {
        val fixture = PackFixture()
        fixture.table("relations", listOf(
            JSONObject().put("fromId", BANANA).put("toId", BANANA).put("label", "self").put("order", 0),
        ))
        assertThrows(IllegalArgumentException::class.java, fixture::load)
    }

    @Test
    fun rejectsAliasCyclesRatherThanRestoringWrongNode() {
        val fixture = PackFixture()
        fixture.table("idAliases", listOf(
            JSONObject().put("oldId", OLD).put("newId", RETIRED),
            JSONObject().put("oldId", RETIRED).put("newId", OLD),
        ))
        assertThrows(IllegalArgumentException::class.java, fixture::load)
    }
}

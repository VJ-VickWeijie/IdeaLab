package com.idealab.marble.data

import com.idealab.marble.data.proto.ParentProfile
import com.idealab.marble.data.proto.StoredResume
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.IOException
import java.time.LocalDate

class ParentStoreTest {
    @get:Rule val files = TemporaryFolder()

    @Test
    fun civilBirthdaysRespectLeapDayAndManualMode() {
        val profile = ParentState(birthDate = LocalDate.of(2024, 2, 29))
        assertEquals(AgeSelection(AgeBand.INFANT, false), profile.age(LocalDate.of(2025, 2, 27)))
        assertEquals(AgeSelection(AgeBand.TODDLER, false), profile.age(LocalDate.of(2025, 2, 28)))
        assertEquals(AgeSelection(AgeBand.TODDLER, true), profile.age(LocalDate.of(2026, 2, 28)))
        assertEquals(AgeSelection(AgeBand.INFANT, false), profile.copy(ageMode = AgeMode.INFANT).age(LocalDate.of(2026, 2, 28)))
        assertEquals(Depth.BASIC, profile.copy(ageMode = AgeMode.TODDLER).depth)
    }

    @Test
    fun historyClearAndFullClearRejectStaleRestoredWrites() = runTest {
        val catalog = PackFixture().load()
        val store = ParentStore(profileDataStore(files.root.resolve("profile.pb"), catalog, backgroundScope), catalog)
        val today = LocalDate.of(2026, 11, 18)
        val date = LocalDate.of(2025, 8, 20)
        val g0 = store.state.first().generation
        assertTrue(runCatching { store.saveSettings(today.plusDays(1), AgeMode.AUTO, Depth.BASIC, g0, today) }.isFailure)
        store.saveSettings(date, AgeMode.INFANT, Depth.MORE, g0, today)
        store.openNode(BANANA, g0)
        store.openNode(BANANA, g0)
        val group = store.continueAt("food", APPLE, g0)
        assertEquals(ResumeAnchor(APPLE, "food"), group.resume)
        assertEquals(listOf(BANANA), group.history)

        val clear = store.clearHistory()
        assertEquals(g0 + 1, clear.generation)
        assertEquals(date, clear.birthDate)
        assertEquals(Depth.MORE, clear.depth)
        assertEquals(clear, store.openNode(APPLE, g0))
        assertEquals(clear, store.continueAt("food", BANANA, g0))
        assertEquals(listOf(APPLE), store.openNode(APPLE, clear.generation).history)

        val full = store.clearEverything()
        assertEquals(ParentState(generation = g0 + 2), full)
        assertEquals(full, store.saveSettings(date, AgeMode.INFANT, Depth.MORE, clear.generation, today))
        assertEquals(full, store.openNode(BANANA, clear.generation))
        assertNull(store.state.first().resume)
    }

    @Test
    fun upgradesAliasAndRetiresUnresolvableNodesWithoutDroppingBirthDate() = runTest {
        val catalog = PackFixture().load()
        val file = files.root.resolve("profile.pb")
        ParentProfile.newBuilder()
            .setBirthDateIso("2025-08-20").setGeneration(7)
            .addAllHistoryNodeIds(listOf(OLD, BANANA, RETIRED, APPLE, "local:unknown"))
            .setResume(StoredResume.newBuilder().setNodeId(OLD).setGroupId("retired").build())
            .build().writeTo(file.outputStream())
        val store = ParentStore(profileDataStore(file, catalog, backgroundScope), catalog)
        val migrated = store.state.first()
        assertEquals(listOf(BANANA, APPLE), migrated.history)
        assertEquals(ResumeAnchor(BANANA), migrated.resume)
        assertEquals(LocalDate.of(2025, 8, 20), migrated.birthDate)
        assertEquals(7L, migrated.generation)
        val written = ParentProfile.parseFrom(file.readBytes())
        assertEquals(1, written.dataVersion)
        assertEquals(listOf(BANANA, APPLE), written.historyNodeIdsList)
    }

    @Test
    fun rejectsUnknownLocalProfileVersionAndPreservesTheStoredBytes() = runTest {
        val catalog = PackFixture().load()
        val file = files.root.resolve("profile.pb")
        val raw = ParentProfile.newBuilder().setDataVersion(50).setBirthDateIso("2025-08-20").build().toByteArray()
        file.writeBytes(raw)
        val store = ParentStore(profileDataStore(file, catalog, backgroundScope), catalog)
        try {
            store.state.first()
            fail("Future profile was accepted")
        } catch (_: IOException) {
            assertArrayEquals(raw, file.readBytes())
        }
    }
}

package com.idealab.marble.data

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.idealab.marble.data.proto.ParentProfile
import com.idealab.marble.data.proto.StoredAgeMode
import com.idealab.marble.data.proto.StoredDepth
import com.idealab.marble.data.proto.StoredResume
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.time.LocalDate
import java.time.format.DateTimeParseException

class ParentStore internal constructor(
    private val storage: DataStore<ParentProfile>,
    private val catalog: ContentCatalog,
) {
    val state: Flow<ParentState> = storage.data.map(ParentProfile::toDomain)

    suspend fun saveSettings(
        birthDate: LocalDate?,
        ageMode: AgeMode,
        depth: Depth,
        generation: Long,
        today: LocalDate = LocalDate.now(),
    ): ParentState {
        require(birthDate == null || birthDate <= today) { "Birth date is in the future" }
        return update(generation) { current ->
            current.toBuilder()
                .setBirthDateIso(birthDate?.toString().orEmpty())
                .setAgeMode(StoredAgeMode.valueOf(ageMode.name))
                .setDepth(StoredDepth.valueOf(depth.name))
                .build()
        }
    }

    suspend fun openNode(nodeId: String, generation: Long): ParentState = update(generation) { current ->
        val resolvedId = requireNotNull(catalog.resolveId(nodeId)) { "Unknown knowledge ID" }
        val history = current.historyNodeIdsList
        val builder = current.toBuilder().setResume(resumeOf(resolvedId))
        if (history.firstOrNull() != resolvedId) {
            builder.clearHistoryNodeIds().addAllHistoryNodeIds(listOf(resolvedId) + history.take(HISTORY_LIMIT - 1))
        }
        builder.build()
    }

    suspend fun continueAt(groupId: String, nodeId: String, generation: Long): ParentState =
        update(generation) { current ->
            val resolvedId = requireNotNull(catalog.resolveId(nodeId)) { "Unknown knowledge ID" }
            require(catalog.groupContains(groupId, resolvedId)) { "Node does not belong to card group" }
            current.toBuilder().setResume(resumeOf(resolvedId, groupId)).build()
        }

    suspend fun clearHistory(): ParentState = storage.updateData { current ->
        current.toBuilder()
            .clearHistoryNodeIds()
            .clearResume()
            .setGeneration(nextGeneration(current))
            .build()
    }.toDomain()

    suspend fun clearEverything(): ParentState = storage.updateData { current ->
        ParentProfile.newBuilder()
            .setDataVersion(DATA_VERSION)
            .setGeneration(nextGeneration(current))
            .build()
    }.toDomain()

    private suspend fun update(
        generation: Long,
        transform: (ParentProfile) -> ParentProfile,
    ): ParentState = storage.updateData { current ->
        if (generation == current.generation) transform(current) else current
    }.toDomain()

    companion object {
        private var singleton: DataStore<ParentProfile>? = null

        @Synchronized
        fun create(context: Context, catalog: ContentCatalog): ParentStore {
            val storage = singleton ?: profileDataStore(
                file = File(context.applicationContext.noBackupFilesDir, "marble/profile.pb"),
                catalog = catalog,
                scope = CoroutineScope(SupervisorJob() + Dispatchers.IO),
            ).also { singleton = it }
            return ParentStore(storage, catalog)
        }
    }
}

private const val DATA_VERSION = 1
private const val HISTORY_LIMIT = 100

internal fun profileDataStore(
    file: File,
    catalog: ContentCatalog,
    scope: CoroutineScope,
): DataStore<ParentProfile> = DataStoreFactory.create(
    serializer = ProfileSerializer,
    migrations = listOf(ProfileMigration(catalog)),
    scope = scope,
    produceFile = { file },
)

private object ProfileSerializer : Serializer<ParentProfile> {
    override val defaultValue: ParentProfile = ParentProfile.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ParentProfile = try {
        ParentProfile.parseFrom(input)
    } catch (e: InvalidProtocolBufferException) {
        throw CorruptionException("Cannot read saved Marble settings", e)
    }

    override suspend fun writeTo(t: ParentProfile, output: OutputStream) = t.writeTo(output)
}

private class ProfileMigration(private val catalog: ContentCatalog) : DataMigration<ParentProfile> {
    override suspend fun shouldMigrate(currentData: ParentProfile): Boolean =
        currentData != migrate(currentData)

    override suspend fun migrate(currentData: ParentProfile): ParentProfile {
        if (currentData.dataVersion !in 0..DATA_VERSION) {
            throw IOException("Unsupported Marble profile version")
        }
        currentData.toDomain()
        val history = buildList {
            for (saved in currentData.historyNodeIdsList) {
                val id = catalog.resolveId(saved) ?: continue
                if (lastOrNull() != id) add(id)
                if (size == HISTORY_LIMIT) break
            }
        }
        val updated = currentData.toBuilder().setDataVersion(DATA_VERSION)
            .clearHistoryNodeIds().addAllHistoryNodeIds(history)
            .clearResume()
        if (currentData.hasResume()) {
            val resume = currentData.resume
            val nodeId = catalog.resolveId(resume.nodeId)
            if (nodeId != null) {
                val groupId = resume.groupId.takeIf { it.isNotEmpty() && catalog.groupContains(it, nodeId) }
                updated.setResume(resumeOf(nodeId, groupId))
            }
        }
        return updated.build()
    }

    override suspend fun cleanUp() = Unit
}

private fun ParentProfile.toDomain(): ParentState {
    if (generation < 0) throw IOException("Invalid Marble profile generation")
    val birthDate = try {
        birthDateIso.takeIf(String::isNotEmpty)?.let(LocalDate::parse)
    } catch (e: DateTimeParseException) {
        throw IOException("Invalid saved Marble date", e)
    }
    val ageMode = AgeMode.entries.find { it.name == this.ageMode.name }
        ?: throw IOException("Invalid saved Marble age mode")
    val depth = Depth.entries.find { it.name == this.depth.name }
        ?: throw IOException("Invalid saved Marble reading depth")
    return ParentState(
        birthDate, ageMode, depth, historyNodeIdsList,
        if (hasResume()) ResumeAnchor(resume.nodeId, resume.groupId.ifEmpty { null }) else null,
        generation,
    )
}

private fun ContentCatalog.groupContains(groupId: String, nodeId: String): Boolean =
    AgeBand.entries.any { band -> group(groupId, band)?.nodeIds?.contains(nodeId) == true }

private fun resumeOf(nodeId: String, groupId: String? = null): StoredResume =
    StoredResume.newBuilder().setNodeId(nodeId).setGroupId(groupId.orEmpty()).build()

private fun nextGeneration(current: ParentProfile): Long {
    if (current.generation == Long.MAX_VALUE) throw IOException("Marble profile generation exhausted")
    return current.generation + 1
}

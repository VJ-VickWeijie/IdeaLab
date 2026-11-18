package com.idealab.marble.data

import android.content.res.AssetManager
import java.text.Normalizer
import java.util.Locale

enum class AgeBand(internal val tag: String) {
    INFANT("0-1"),
    TODDLER("1-2");

    companion object {
        internal fun fromTag(tag: String): AgeBand =
            requireNotNull(entries.find { it.tag == tag }) { "Unsupported age band" }
    }
}

enum class PackStatus { FIXTURE, APPROVED }

data class Knowledge(
    val id: String,
    val category: String,
    val aliases: List<String>,
    val tags: List<String>,
    val facts: List<String>,
    val source: KnowledgeSource,
)

data class KnowledgeSource(val kind: String, val referenceTopicIds: List<String>)

data class Presentation(
    val nodeId: String,
    val ageBand: AgeBand,
    val name: String,
    val answer: String,
    val fallbackText: String,
    val detailText: String?,
    val imageId: String?,
    val imageDescription: String,
    val audioId: String?,
    val transcript: String,
    val caregiverText: String,
    val caregiverAudioId: String?,
    val observation: String?,
    val precaution: String?,
)

data class Relation(val fromId: String, val toId: String, val label: String, val order: Int)

data class CardGroup(val id: String, val label: String, val ageBand: AgeBand, val nodeIds: List<String>)

enum class MediaKind { IMAGE, AUDIO }

data class ContentAsset(
    val id: String,
    val kind: MediaKind,
    val path: String,
    val sha256: String,
    val bytes: Long,
    val credit: String,
    val sourceUrl: String?,
    val license: String?,
    val licenseUrl: String?,
    val changes: String?,
    val reviewStatus: String?,
)

class ContentCatalog internal constructor(
    val contentVersion: String,
    val status: PackStatus,
    val language: String,
    val knowledge: List<Knowledge>,
    private val presentations: Map<Pair<String, AgeBand>, Presentation>,
    groups: List<CardGroup>,
    relations: List<Relation>,
    val media: List<ContentAsset>,
    private val availableMedia: Set<String>,
    private val aliases: Map<String, String?>,
) {
    private val byId = knowledge.associateBy(Knowledge::id)
    private val mediaById = media.associateBy(ContentAsset::id)
    private val groupsByAge = groups.groupBy(CardGroup::ageBand)
    private val bySource = relations.groupBy(Relation::fromId)
        .mapValues { (_, links) -> links.sortedBy(Relation::order) }
    private val searchTerms = presentations.mapValues { (key, item) ->
        val node = byId.getValue(key.first)
        (listOf(item.name) + node.aliases + node.tags)
            .map(::normalized).filter(String::isNotEmpty).distinct()
    }

    fun node(id: String): Knowledge? = byId[id]

    fun presentation(id: String, band: AgeBand): Presentation? = presentations[id to band]

    fun groups(band: AgeBand): List<CardGroup> = groupsByAge[band].orEmpty()

    fun group(id: String, band: AgeBand): CardGroup? = groups(band).find { it.id == id }

    fun related(id: String): List<Relation> = bySource[id].orEmpty()

    fun asset(assetId: String?): ContentAsset? = mediaById[assetId]?.takeIf { it.id in availableMedia }

    fun search(query: String, band: AgeBand): List<Knowledge> {
        val term = normalized(query)
        if (term.isEmpty()) return emptyList()
        return knowledge.mapNotNull { node ->
            val tokens = searchTerms[node.id to band].orEmpty()
            val rank = when {
                term in tokens -> 0
                tokens.any { it.startsWith(term) } -> 1
                tokens.any { term in it } -> 2
                else -> return@mapNotNull null
            }
            rank to node
        }.sortedBy { it.first }.map { it.second }
    }

    internal fun resolveId(id: String): String? {
        var candidate: String? = id
        while (candidate != null && candidate in aliases) candidate = aliases[candidate]
        return candidate?.takeIf { it in byId }
    }

    companion object {
        fun load(assets: AssetManager): ContentCatalog = readContentPack(
            read = { path -> assets.open(path).use { it.readBytes() } },
            isAvailable = { path -> runCatching { assets.open(path).close() }.isSuccess },
        )
    }
}

private val whitespace = Regex("[\\p{Z}\\s]+")

private fun normalized(text: String): String =
    whitespace.replace(Normalizer.normalize(text, Normalizer.Form.NFKC).lowercase(Locale.ROOT), " ").trim()

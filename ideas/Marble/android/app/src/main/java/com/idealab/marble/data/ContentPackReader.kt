package com.idealab.marble.data

import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.security.MessageDigest

private const val MANIFEST = "content/manifest.json"
private const val LANGUAGE = "yue-Hant-HK"
private val localPath = Regex("content/([A-Za-z0-9][A-Za-z0-9_.-]*/)*[A-Za-z0-9][A-Za-z0-9_.-]*")
private val digestPattern = Regex("[a-f0-9]{64}")

internal fun readContentPack(read: (String) -> ByteArray, isAvailable: (String) -> Boolean): ContentCatalog {
    val manifest = JSONObject(read(MANIFEST).toString(Charsets.UTF_8))
    require(manifest.exactInt("schemaVersion") == 1) { "Unsupported Marble content schema" }
    val version = manifest.text("contentVersion")
    val language = manifest.text("language")
    require(language == LANGUAGE) { "Unsupported Marble content language" }
    val status = when (manifest.text("status")) {
        "fixture" -> PackStatus.FIXTURE
        "approved" -> PackStatus.APPROVED
        else -> throw IOException("Unknown Marble content status")
    }
    val tables = manifest.getJSONObject("tables")

    fun table(name: String): List<JSONObject> {
        val descriptor = tables.getJSONObject(name)
        val path = descriptor.assetPath()
        require(path != MANIFEST && path.endsWith(".json")) { "Invalid content table path" }
        val bytes = read(path)
        require(contentSha256(bytes) == descriptor.sha256()) { "Content table checksum mismatch: $name" }
        val array = JSONArray(bytes.toString(Charsets.UTF_8))
        return List(array.length(), array::getJSONObject)
    }

    val knowledge = table("knowledge").map { row ->
        val source = row.getJSONObject("source")
        val kind = source.text("kind")
        val id = row.text("id")
        require(kind == "upstream" || (kind == "local" && id.startsWith("local:"))) {
            "Invalid knowledge source"
        }
        Knowledge(
            id, row.text("category"), row.strings("aliases"), row.strings("tags"),
            row.strings("facts"), KnowledgeSource(kind, source.strings("referenceTopicIds")),
        )
    }
    val nodes = knowledge.uniqueBy("knowledge ID", Knowledge::id)
    require(nodes.isNotEmpty()) { "Marble content is empty" }

    val media = table("media").map { row ->
        val kind = when (row.text("kind")) {
            "image" -> MediaKind.IMAGE
            "audio" -> MediaKind.AUDIO
            else -> throw IOException("Invalid Marble media type")
        }
        val path = row.assetPath()
        val extension = path.substringAfterLast('.').lowercase()
        require(
            when (kind) {
                MediaKind.IMAGE -> extension in setOf("jpg", "jpeg", "png", "webp")
                MediaKind.AUDIO -> extension == "m4a"
            },
        ) { "Invalid Marble media format" }
        ContentAsset(
            row.text("id"), kind, path, row.sha256(), row.positiveLong("bytes"), row.text("credit"),
            row.optionalText("sourceUrl"), row.optionalText("license"), row.optionalText("licenseUrl"),
            row.optionalText("changes"), row.optionalText("reviewStatus"),
        )
    }
    val mediaById = media.uniqueBy("media ID", ContentAsset::id)
    media.uniqueBy("media path", ContentAsset::path)

    val presentations = table("presentations").map { row ->
        require(row.text("language") == language) { "Presentation language differs from pack" }
        val id = row.text("nodeId")
        require(id in nodes) { "Presentation references an unknown knowledge ID" }
        val item = Presentation(
            id, AgeBand.fromTag(row.text("ageBand")), row.text("name"), row.text("answer"),
            row.text("fallbackText"), row.optionalText("detailText"), row.optionalText("imageId"),
            row.text("imageDescription"), row.optionalText("audioId"), row.text("transcript"),
            row.text("caregiverText"), row.optionalText("caregiverAudioId"), row.optionalText("observation"),
            row.optionalText("precaution"),
        )
        require(item.imageId == null || mediaById[item.imageId]?.kind == MediaKind.IMAGE) {
            "Presentation references an invalid image"
        }
        require(item.audioId == null || mediaById[item.audioId]?.kind == MediaKind.AUDIO) {
            "Presentation references an invalid audio track"
        }
        require(item.caregiverAudioId == null || mediaById[item.caregiverAudioId]?.kind == MediaKind.AUDIO) {
            "Presentation references an invalid caregiver audio track"
        }
        if (status == PackStatus.APPROVED) {
            require(item.audioId != null && item.imageId != null) { "Approved content requires principal media" }
        }
        item
    }.uniqueBy("presentation") { it.nodeId to it.ageBand }
    require(presentations.size == nodes.size * AgeBand.entries.size) { "Missing age-band presentation" }

    val relations = table("relations").map { row ->
        val from = row.text("fromId")
        val to = row.text("toId")
        require(from in nodes && to in nodes && from != to) { "Invalid relation endpoints" }
        val order = row.exactInt("order")
        require(order >= 0) { "Invalid relation order" }
        Relation(from, to, row.text("label"), order)
    }
    relations.uniqueBy("relation target") { it.fromId to it.toId }
    relations.uniqueBy("relation order") { it.fromId to it.order }
    val relationsBySource = relations.groupBy(Relation::fromId)
    require(nodes.keys.all { relationsBySource[it].orEmpty().size in 2..3 }) { "Invalid map size" }

    val groups = table("groups").map { row ->
        val ids = row.strings("nodeIds")
        require(ids.size in 1..8 && ids.distinct() == ids && ids.all { it in nodes }) {
            "Invalid card group entries"
        }
        CardGroup(row.text("id"), row.text("label"), AgeBand.fromTag(row.text("ageBand")), ids)
    }
    groups.uniqueBy("age-band card group") { it.id to it.ageBand }
    require(AgeBand.entries.all { band -> groups.any { it.ageBand == band } }) { "Missing age-band card group" }

    val aliases = table("idAliases").uniqueBy("retired knowledge ID") { it.text("oldId") }.mapValues { (_, row) ->
        require(row.has("newId")) { "Missing alias target" }
        row.optionalText("newId")
    }
    require(aliases.keys.none { it in nodes }) { "Alias overrides a current knowledge ID" }
    for (start in aliases.keys) {
        val visited = mutableSetOf<String>()
        var cursor: String? = start
        while (cursor != null && cursor in aliases) {
            require(visited.add(cursor)) { "Cycle in knowledge ID aliases" }
            cursor = aliases[cursor]
        }
        require(cursor == null || cursor in nodes) { "Alias ends at an unknown knowledge ID" }
    }

    val available = media.filter { isAvailable(it.path) }.mapTo(mutableSetOf(), ContentAsset::id)
    return ContentCatalog(version, status, language, knowledge, presentations, groups, relations, media, available, aliases)
}

internal fun contentSha256(value: ByteArray): String =
    MessageDigest.getInstance("SHA-256").digest(value).joinToString("") { byte ->
        val n = byte.toInt() and 0xff
        HEX.substring(n shr 4, (n shr 4) + 1) + HEX.substring(n and 15, (n and 15) + 1)
    }

private const val HEX = "0123456789abcdef"

private fun JSONObject.optionalText(field: String): String? {
    if (isNull(field)) return null
    return (get(field) as? String)?.takeIf(String::isNotBlank)
        ?: throw IOException("Invalid string field: $field")
}

private fun JSONObject.text(field: String): String =
    optionalText(field) ?: throw IOException("Missing string field: $field")

private fun JSONObject.strings(field: String): List<String> {
    if (isNull(field)) return emptyList()
    val array = getJSONArray(field)
    return List(array.length()) { index ->
        (array.get(index) as? String)?.takeIf(String::isNotBlank)
            ?: throw IOException("Invalid string list: $field")
    }
}

private fun JSONObject.exactInt(field: String): Int =
    get(field) as? Int ?: throw IOException("Invalid integer field: $field")

private fun JSONObject.positiveLong(field: String): Long {
    val value = when (val number = get(field)) {
        is Int -> number.toLong()
        is Long -> number
        else -> throw IOException("Invalid integer field: $field")
    }
    require(value > 0) { "Media size must be positive" }
    return value
}

private fun JSONObject.sha256(): String = text("sha256").also {
    require(digestPattern.matches(it)) { "Malformed SHA-256" }
}

private fun JSONObject.assetPath(): String = text("path").also {
    require(localPath.matches(it)) { "Content references a path outside its assets" }
}

private fun <T, K> Iterable<T>.uniqueBy(label: String, key: (T) -> K): Map<K, T> {
    val index = associateBy(key)
    require(index.size == count()) { "Duplicate $label" }
    return index
}

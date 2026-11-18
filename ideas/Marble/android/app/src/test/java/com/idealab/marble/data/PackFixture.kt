package com.idealab.marble.data

import org.json.JSONArray
import org.json.JSONObject

internal const val BANANA = "local:banana"
internal const val APPLE = "local:apple"
internal const val BREAD = "local:bread"
internal const val OLD = "local:old-banana"
internal const val RETIRED = "local:retired"

internal class PackFixture {
    val files = linkedMapOf<String, ByteArray>()
    val manifest = JSONObject()
        .put("schemaVersion", 1)
        .put("contentVersion", "m4-test")
        .put("language", "yue-Hant-HK")
        .put("status", "fixture")
        .put("tables", JSONObject())

    init {
        val ids = listOf(APPLE, BREAD, BANANA)
        val names = listOf("蘋果", "麵包", "香蕉")
        val aliases = listOf("red banana", "banana bread", "banana")
        table("knowledge", ids.mapIndexed { index, id ->
            JSONObject().put("id", id).put("category", "食物").put("aliases", JSONArray(listOf(aliases[index])))
                .put("source", JSONObject().put("kind", "local"))
        })
        table("presentations", ids.flatMapIndexed { index, id ->
            AgeBand.entries.map { band ->
                JSONObject().put("nodeId", id).put("ageBand", band.tag).put("language", "yue-Hant-HK")
                    .put("name", names[index]).put("answer", "一齊睇吓").put("fallbackText", "學吓呢個名")
                    .put("imageDescription", names[index]).put("transcript", "睇吓，係${names[index]}。")
                    .put("caregiverText", "你指一指張相。")
                    .apply {
                        if (id == BANANA) put("imageId", "banana-photo").put("audioId", "banana-clip")
                    }
            }
        })
        table("relations", ids.flatMap { from ->
            ids.filterNot { it == from }.mapIndexed { order, to ->
                JSONObject().put("fromId", from).put("toId", to).put("label", "都可以食").put("order", order)
            }.reversed()
        })
        table("groups", AgeBand.entries.map { band ->
            JSONObject().put("id", "food").put("label", "食物").put("ageBand", band.tag).put("nodeIds", JSONArray(ids))
        })
        val photo = "content/media/banana.jpg"
        val clip = "content/media/banana.m4a"
        val data = byteArrayOf(1, 2, 3)
        files[photo] = data
        files[clip] = data
        table("media", listOf(
            JSONObject().put("id", "banana-photo").put("path", photo).put("kind", "image"),
            JSONObject().put("id", "banana-clip").put("path", clip).put("kind", "audio"),
        ).map {
            it.put("sha256", contentSha256(data)).put("bytes", data.size).put("credit", "Synthetic test clip or photo")
        })
        table("idAliases", listOf(
            JSONObject().put("oldId", OLD).put("newId", BANANA),
            JSONObject().put("oldId", RETIRED).put("newId", JSONObject.NULL),
        ))
    }

    fun table(name: String, rows: List<JSONObject>) {
        val path = "content/$name.json"
        val content = JSONArray(rows).toString().toByteArray()
        files[path] = content
        manifest.getJSONObject("tables").put(name, JSONObject().put("path", path).put("sha256", contentSha256(content)))
    }

    fun load(): ContentCatalog {
        files["content/manifest.json"] = manifest.toString().toByteArray()
        return readContentPack(files::getValue, files::containsKey)
    }
}

package com.idealab.marble.ui

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.idealab.marble.data.AgeBand
import com.idealab.marble.data.AgeMode
import com.idealab.marble.data.AgeSelection
import com.idealab.marble.data.ContentCatalog
import com.idealab.marble.data.Depth
import com.idealab.marble.data.Knowledge
import com.idealab.marble.data.PackStatus
import com.idealab.marble.data.ParentState
import java.time.LocalDate
import java.time.ZoneId

@Composable
internal fun HomePage(
    catalog: ContentCatalog, band: AgeBand, state: ParentState,
    explore: () -> Unit, together: () -> Unit, resume: () -> Unit, search: () -> Unit,
    category: (String) -> Unit, open: (String) -> Unit, settings: () -> Unit,
) {
    val first = catalog.groups(band).firstOrNull()?.nodeIds?.firstOrNull()?.let { catalog.presentation(it, band) }
    Page {
        ForestBanner()
        if (catalog.status == PackStatus.FIXTURE) Text("開發版 · 圖文同錄音供測試", color = Forest)
        Action("搜尋知識", search, Modifier.fillMaxWidth())
        if (first != null) Choice("滑滑認識世界", explore, "睇相、聽粵語、上下滑", catalog.asset(first.imageId), emphasis = true)
        Choice("親子一齊睇", together, "揀一樣，一齊讀")
        state.resume?.nodeId?.let { catalog.presentation(it, band) }?.let { Choice("繼續探索", resume, it.name) }
        Panel(color = Leaf) {
            Label("主題分類")
            catalog.knowledge.map { it.category }.distinct().forEach { name ->
                Action(name, { category(name) }, Modifier.fillMaxWidth())
            }
        }
        val recommendations = catalog.groups(band).mapNotNull { it.nodeIds.firstOrNull() }.distinct().take(3)
        if (recommendations.isNotEmpty()) Label("一齊發現")
        recommendations.forEach { id ->
            catalog.presentation(id, band)?.let { Choice(it.name, { open(id) }, photo = catalog.asset(it.imageId)) }
        }
        Action("家長設定", settings, Modifier.fillMaxWidth())
    }
}

@Composable
internal fun SearchPage(
    catalog: ContentCatalog, band: AgeBand, query: String, onQuery: (String) -> Unit,
    open: (String) -> Unit, back: () -> Unit,
) {
    Page {
        PageTitle("搜尋知識", "返回首頁", back)
        OutlinedTextField(query, { onQuery(it.take(100)) }, Modifier.fillMaxWidth().testTag("search-query"),
            label = { Text("名稱或其他叫法") }, singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search))
        if (query.isNotBlank()) {
            val results = remember(query, band, catalog) { catalog.search(query, band) }
            if (results.isEmpty()) Text("搵唔到。試吓用另一個名稱。")
            NodeChoices(catalog, band, results, open)
        }
    }
}

@Composable
internal fun NodeListPage(
    catalog: ContentCatalog, band: AgeBand, title: String, backLabel: String,
    nodes: List<Knowledge>, open: (String) -> Unit, back: () -> Unit,
) {
    Page {
        PageTitle(title, backLabel, back)
        if (nodes.isEmpty()) Text("暫時未有內容。")
        NodeChoices(catalog, band, nodes, open)
    }
}

@Composable
private fun NodeChoices(catalog: ContentCatalog, band: AgeBand, nodes: List<Knowledge>, open: (String) -> Unit) {
    nodes.forEach { node ->
        catalog.presentation(node.id, band)?.let { item ->
            Choice(item.name, { open(node.id) }, photo = catalog.asset(item.imageId))
        }
    }
}

@Composable
internal fun ParentPage(
    state: ParentState, age: AgeSelection, today: LocalDate,
    save: (LocalDate?, AgeMode, Depth) -> Unit, clear: (Boolean) -> Unit,
    history: () -> Unit, credits: () -> Unit, busy: Boolean, back: () -> Unit,
) {
    val context = LocalContext.current
    var birth by remember(state.birthDate) { mutableStateOf(state.birthDate) }
    var mode by rememberSaveable(state.ageMode) { mutableStateOf(state.ageMode) }
    var depth by rememberSaveable(state.depth) { mutableStateOf(state.depth) }
    var confirm by remember { mutableStateOf<Boolean?>(null) }
    var picker by remember { mutableStateOf<DatePickerDialog?>(null) }
    DisposableEffect(Unit) { onDispose { picker?.dismiss() } }
    Page {
        PageTitle("家長設定", "返回首頁", back)
        Panel {
            Label("體驗年齡")
            Text(if (age.band == AgeBand.INFANT) "目前使用 0–1 歲內容" else "目前使用 1–2 歲內容")
            if (age.outOfRange) Text("已滿 2 歲。可以睇 1–2 歲內容，或者手動揀體驗年齡。")
            Text("生日可以留空，只會儲喺呢部裝置，用嚟計算體驗年齡。")
            Action(if (birth == null) "選擇生日（可留空）" else "更改已設定生日", {
                val initial = birth?.coerceAtMost(today) ?: today
                DatePickerDialog(context, { _, y, m, d -> birth = LocalDate.of(y, m + 1, d) },
                    initial.year, initial.monthValue - 1, initial.dayOfMonth).apply {
                    datePicker.maxDate = today.atTime(23, 59).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                    setOnDismissListener { picker = null }
                    picker = this
                    show()
                }
            }, Modifier.fillMaxWidth(), enabled = !busy)
            if (birth != null) Action("留空生日", { birth = null }, Modifier.fillMaxWidth(), enabled = !busy)
            Column(Modifier.selectableGroup(), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Setting("按生日自動揀", mode == AgeMode.AUTO) { mode = AgeMode.AUTO }
                Setting("手動 · 0–1 歲", mode == AgeMode.INFANT) { mode = AgeMode.INFANT }
                Setting("手動 · 1–2 歲", mode == AgeMode.TODDLER) { mode = AgeMode.TODDLER }
            }
        }
        Panel {
            Label("解釋深度")
            Column(Modifier.selectableGroup(), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Setting("簡短講解", depth == Depth.BASIC) { depth = Depth.BASIC }
                Setting("預先展開補充講解", depth == Depth.MORE) { depth = Depth.MORE }
            }
        }
        Action("儲存設定", { save(birth, mode, depth) }, Modifier.fillMaxWidth(), primary = true, enabled = !busy)
        Panel {
            Label("探索同裝置資料")
            Action("查看探索歷史", history, Modifier.fillMaxWidth())
            Action("清除探索歷史", { confirm = false }, Modifier.fillMaxWidth(), enabled = !busy)
            Action("清除所有本機資料", { confirm = true }, Modifier.fillMaxWidth(), enabled = !busy)
            Action("內容同素材來源", credits, Modifier.fillMaxWidth())
        }
    }
    confirm?.let { all ->
        AlertDialog(onDismissRequest = { confirm = null },
            title = { Text(if (all) "清除所有本機資料？" else "清除探索歷史？") },
            text = { Text(if (all) "生日、體驗設定、歷史同繼續探索位置都會清除。" else "探索歷史同繼續探索位置會清除。家長設定會保留。") },
            confirmButton = { Action("確認清除", { confirm = null; clear(all) }, primary = true) },
            dismissButton = { Action("取消", { confirm = null }) },
        )
    }
}

@Composable
private fun Setting(label: String, selected: Boolean, onClick: () -> Unit) {
    Surface(color = if (selected) Leaf else Paper, shape = Rounded,
        modifier = Modifier.fillMaxWidth().heightIn(min = 56.dp).selectable(selected, role = Role.RadioButton, onClick = onClick)) {
        Text(label, Modifier.padding(14.dp))
    }
}

@Composable
internal fun CreditsPage(catalog: ContentCatalog, back: () -> Unit) {
    Page {
        PageTitle("內容同素材來源", "返回家長設定", back)
        Text("內容版本 ${catalog.contentVersion}")
        for (asset in catalog.media) Panel {
            Label(asset.credit)
            asset.license?.let { Text(it) }
            asset.changes?.takeIf(String::isNotBlank)?.let { Text(it) }
            asset.sourceUrl?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
            asset.licenseUrl?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
        }
    }
}

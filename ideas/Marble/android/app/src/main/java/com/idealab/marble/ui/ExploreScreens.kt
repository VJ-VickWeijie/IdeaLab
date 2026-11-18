package com.idealab.marble.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.hideFromAccessibility
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.idealab.marble.data.AgeBand
import com.idealab.marble.data.CardGroup
import com.idealab.marble.data.ContentCatalog
import com.idealab.marble.data.Depth
import com.idealab.marble.data.Presentation

@Composable
internal fun CardPage(
    catalog: ContentCatalog, band: AgeBand, group: CardGroup, start: String, failedAudio: String?,
    play: (String) -> Unit, stop: () -> Unit, save: (String) -> Unit, details: (String) -> Unit,
    nextGroup: (() -> Unit)?, home: () -> Unit,
) {
    var nodeId by rememberSaveable(group.id) { mutableStateOf(start) }
    var reading by rememberSaveable(group.id) { mutableStateOf(false) }
    val index = group.nodeIds.indexOf(nodeId).coerceAtLeast(0)
    val item = group.nodeIds.getOrNull(index)?.let { catalog.presentation(it, band) }
    if (item == null) {
        InvalidPage(home)
        return
    }

    fun step(next: Int) {
        if (next !in group.nodeIds.indices || next == group.nodeIds.indexOf(nodeId)) return
        stop()
        nodeId = group.nodeIds[next]
        save(nodeId)
    }

    fun closeReading() {
        stop()
        reading = false
    }

    BackHandler(enabled = reading, onBack = ::closeReading)
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val photoHeight = maxHeight * (2f / 3f)
        val audio = catalog.asset(item.audioId)?.path
        val pageNavigation = if (reading) Modifier else Modifier.cardGestures { delta ->
            step(group.nodeIds.indexOf(nodeId).coerceAtLeast(0) + delta)
        }.semantics {
            customActions = buildList {
                if (index > 0) add(CustomAccessibilityAction("上一張") {
                    step(index - 1)
                    true
                })
                if (index < group.nodeIds.lastIndex) add(CustomAccessibilityAction("下一張") {
                    step(index + 1)
                    true
                })
            }
        }
        Box(
            Modifier.fillMaxSize().testTag("card-page").then(pageNavigation).then(underOverlay(reading)),
            contentAlignment = Alignment.TopCenter,
        ) {
            Column(
                Modifier.widthIn(max = 660.dp).fillMaxSize().padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Action("返回首頁", home)
                    Text(group.label, Modifier.weight(1f).semantics { heading() },
                        style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text("${index + 1} / ${group.nodeIds.size}", color = Forest)
                }
                Picture(
                    catalog.asset(item.imageId), item.imageDescription,
                    Modifier.weight(1f, fill = false).fillMaxWidth().height(photoHeight).testTag("card-photo"),
                    play = audio?.takeUnless { reading }?.let { path -> { if (!reading) play(path) } },
                    fit = true,
                )
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(item.name, Modifier.semantics { heading() }, style = MaterialTheme.typography.titleLarge,
                        maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text(item.transcript.ifBlank { item.fallbackText }, style = MaterialTheme.typography.bodyLarge,
                        maxLines = 2, overflow = TextOverflow.Ellipsis)
                    if (audio == null || failedAudio == audio) AudioUnavailable()
                }
                if (index == group.nodeIds.lastIndex) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Action("重睇呢組", { step(0) }, Modifier.weight(1f), primary = true)
                        if (nextGroup != null) Action("換一組", nextGroup, Modifier.weight(1f))
                    }
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Action("睇知識詳情", { details(item.nodeId) }, Modifier.weight(1f), primary = true)
                    Action("家長陪讀", { stop(); reading = true }, Modifier.weight(1f))
                }
            }
        }
        if (reading) CaregiverSheet(catalog, item, failedAudio, play, ::closeReading)
    }
}

@Composable
internal fun DetailPage(
    catalog: ContentCatalog, item: Presentation, depth: Depth, openReading: Boolean, failedAudio: String?,
    backLabel: String, play: (String) -> Unit, stop: () -> Unit, map: () -> Unit, back: () -> Unit,
) {
    var reading by rememberSaveable(item.nodeId) { mutableStateOf(openReading) }
    var zoomed by rememberSaveable(item.nodeId) { mutableStateOf(false) }
    var expanded by rememberSaveable(item.nodeId, depth) { mutableStateOf(depth == Depth.MORE) }
    val audio = catalog.asset(item.audioId)?.path
    val image = catalog.asset(item.imageId)
    fun closeOverlay() {
        stop()
        reading = false
        zoomed = false
    }
    BackHandler(enabled = reading || zoomed, onBack = ::closeOverlay)
    Box(Modifier.fillMaxSize()) {
        Page(modifier = underOverlay(reading || zoomed)) {
            PageTitle(item.name, backLabel, back)
            Picture(image, item.imageDescription, Modifier.fillMaxWidth().heightIn(max = 340.dp).aspectRatio(1.31f),
                play = audio?.takeUnless { reading || zoomed }?.let { path -> { if (!reading && !zoomed) play(path) } })
            if (image != null) Action("放大圖片", { stop(); zoomed = true }, Modifier.fillMaxWidth())
            Panel {
                Text(item.answer.ifBlank { item.fallbackText }, style = MaterialTheme.typography.headlineSmall)
                if (item.transcript.isNotBlank() && item.transcript != item.answer) Text(item.transcript)
                if (audio == null || audio == failedAudio) AudioUnavailable()
                if (!item.detailText.isNullOrBlank()) {
                    Action(if (expanded) "收起補充講解" else "睇多少少", { expanded = !expanded })
                    if (expanded) Text(item.detailText.orEmpty())
                }
            }
            Action("打開知識地圖", map, Modifier.fillMaxWidth(), primary = true)
            Action("家長陪讀", { stop(); reading = true }, Modifier.fillMaxWidth())
        }
        if (reading) CaregiverSheet(catalog, item, failedAudio, play, ::closeOverlay)
        if (zoomed) Page(modifier = Modifier.background(Cream)) {
            PageTitle("放大圖片", "關閉放大", ::closeOverlay)
            Picture(image, item.imageDescription, Modifier.fillMaxWidth().heightIn(max = 500.dp).aspectRatio(.9f), fit = true)
        }
    }
}

@Composable
internal fun MapPage(catalog: ContentCatalog, band: AgeBand, item: Presentation, open: (String) -> Unit, back: () -> Unit) {
    val related = catalog.related(item.nodeId).mapNotNull { catalog.presentation(it.toId, band) }
    val backLabel = "返回${item.name}詳情"
    Page {
        PageTitle("知識地圖 · ${item.name}", backLabel, back)
        Surface(Modifier.fillMaxWidth(), shape = Rounded, color = Leaf) {
            Column(Modifier.padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Panel(Modifier.widthIn(max = 188.dp), color = Cream) {
                    Picture(catalog.asset(item.imageId), item.imageDescription,
                        Modifier.fillMaxWidth().height(127.dp), maxPixels = 360)
                    Label(item.name)
                }
                if (related.isNotEmpty()) {
                    Canvas(Modifier.fillMaxWidth().height(36.dp)) {
                        related.forEachIndexed { i, _ ->
                            drawLine(Moss, Offset(size.width / 2, 0f),
                                Offset(size.width * (i + .5f) / related.size, size.height), 2.dp.toPx())
                        }
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        related.forEach { node ->
                            Column(Modifier.weight(1f).clip(Rounded).background(Paper)
                                .clickable(role = Role.Button, onClickLabel = "打開知識詳情") { open(node.nodeId) }.padding(8.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Picture(catalog.asset(node.imageId), node.imageDescription,
                                    Modifier.fillMaxWidth().heightIn(70.dp, 138.dp).aspectRatio(1.12f), maxPixels = 360)
                                Label(node.name)
                            }
                        }
                    }
                }
            }
        }
        Action(backLabel, back, Modifier.fillMaxWidth(), primary = true)
    }
}

@Composable
private fun CaregiverSheet(
    catalog: ContentCatalog, item: Presentation, failedAudio: String?,
    play: (String) -> Unit, close: () -> Unit,
) {
    val audio = catalog.asset(item.caregiverAudioId)?.path
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(Modifier.fillMaxSize().background(Color(0x800E1B12)).clickable(onClickLabel = "關閉家長陪讀", onClick = close))
        Surface(Modifier.widthIn(max = 660.dp).fillMaxWidth().fillMaxHeight(.83f), shape = Rounded, color = Paper) {
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)) {
                PageTitle("家長陪讀 · ${item.name}", "關閉陪讀", close)
                Panel(color = Cream) {
                    Text(item.caregiverText, style = MaterialTheme.typography.bodyLarge)
                    if (audio != null) {
                        Action("播放陪讀錄音", { play(audio) })
                        if (failedAudio == audio) AudioUnavailable()
                    }
                }
                item.observation?.takeIf(String::isNotBlank)?.let {
                    Panel(color = Leaf) { Label("一齊觀察"); Text(it) }
                }
                item.precaution?.takeIf(String::isNotBlank)?.let {
                    Panel(color = Cream) { Label("留意"); Text(it) }
                }
            }
        }
    }
}

private fun underOverlay(overlay: Boolean): Modifier =
    if (!overlay) Modifier
    else Modifier.clearAndSetSemantics { hideFromAccessibility() }.pointerInput(Unit) {
        awaitEachGesture {
            awaitFirstDown(requireUnconsumed = false, pass = PointerEventPass.Initial).consume()
            do {
                val event = awaitPointerEvent(PointerEventPass.Initial)
                event.changes.forEach { it.consume() }
            } while (event.changes.any { it.pressed })
        }
    }

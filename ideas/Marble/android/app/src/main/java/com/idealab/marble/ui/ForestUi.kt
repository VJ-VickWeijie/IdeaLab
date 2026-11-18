package com.idealab.marble.ui

import android.graphics.BitmapFactory
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.idealab.marble.data.ContentAsset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal val Ink = Color(0xFF382A20)
internal val Forest = Color(0xFF35563C)
internal val Moss = Color(0xFF526849)
internal val Cream = Color(0xFFFFF9EC)
internal val Paper = Color(0xFFFFFCF5)
internal val Honey = Color(0xFFF3D287)
internal val Leaf = Color(0xFFE7EFDC)
internal val Rounded = RoundedCornerShape(24.dp)

@Composable
internal fun MarbleTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Forest, onPrimary = Color.White, secondary = Moss, secondaryContainer = Leaf,
            tertiaryContainer = Honey, onTertiaryContainer = Ink, background = Cream, onBackground = Ink,
            surface = Paper, onSurface = Ink, onSurfaceVariant = Color(0xFF584E43),
            outline = Color(0xFF76775D), error = Color(0xFFA12F28),
        ),
        content = content,
    )
}

@Composable
internal fun ForestWindow(content: @Composable BoxScope.() -> Unit) {
    Box(Modifier.fillMaxSize().background(Cream)) {
        Box(Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing), content = content)
    }
}

@Composable
internal fun Page(
    modifier: Modifier = Modifier,
    scroll: ScrollState = rememberScrollState(),
    content: @Composable ColumnScope.() -> Unit,
) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            Modifier.widthIn(max = 660.dp).fillMaxWidth().verticalScroll(scroll).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            content = content,
        )
    }
}

@Composable
internal fun PageTitle(title: String, backLabel: String = "返回", back: (() -> Unit)? = null) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (back != null) Action(backLabel, back)
        Heading(title)
    }
}

@Composable
internal fun Heading(title: String) {
    Text(title, Modifier.semantics { heading() }, style = MaterialTheme.typography.headlineMedium)
}

@Composable
internal fun Label(title: String) = Text(title, style = MaterialTheme.typography.titleMedium)

@Composable
internal fun Panel(
    modifier: Modifier = Modifier, color: Color = Paper,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(modifier.fillMaxWidth(), shape = Rounded, color = color) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp), content = content)
    }
}

@Composable
internal fun Action(
    label: String, onClick: () -> Unit, modifier: Modifier = Modifier,
    primary: Boolean = false, enabled: Boolean = true,
) {
    val touchTarget = modifier.heightIn(min = 56.dp)
    if (primary) Button(
        onClick, modifier = touchTarget, enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = Honey, contentColor = Ink),
    ) { Text(label) }
    else OutlinedButton(onClick, modifier = touchTarget, enabled = enabled) { Text(label) }
}

@Composable
internal fun Picture(
    asset: ContentAsset?, description: String, modifier: Modifier,
    play: (() -> Unit)? = null, fit: Boolean = false, maxPixels: Int = 960,
) {
    val assets = LocalContext.current.assets
    val path = asset?.path
    val bitmap = key(path, maxPixels) {
        val decoded by produceState<ImageBitmap?>(null, assets) {
            if (path != null) value = withContext(Dispatchers.IO) {
                runCatching {
                    val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
                    assets.open(path).use { BitmapFactory.decodeStream(it, null, bounds) }
                    val dimension = maxOf(bounds.outWidth, bounds.outHeight)
                    var sample = 1
                    while (dimension / (sample * 2) >= maxPixels) sample *= 2
                    val options = BitmapFactory.Options().apply { inSampleSize = sample }
                    assets.open(path).use { BitmapFactory.decodeStream(it, null, options)?.asImageBitmap() }
                }.getOrNull()
            }
        }
        decoded
    }
    val click = if (play == null) Modifier else Modifier.clickable(
        role = Role.Button, onClickLabel = "播放或重播粵語講解", onClick = play,
    )
    Box(modifier.clip(Rounded).background(Leaf).then(click), contentAlignment = Alignment.Center) {
        if (bitmap != null) Image(
            bitmap, description.takeIf { it.isNotEmpty() }, Modifier.fillMaxSize(),
            contentScale = if (fit) ContentScale.Fit else ContentScale.Crop,
        )
        else Text(description, Modifier.padding(12.dp), color = Forest)
        if (play != null) Box(
            Modifier.align(Alignment.BottomEnd).padding(10.dp).size(36.dp)
                .background(Forest.copy(alpha = 0.8f), CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Canvas(Modifier.size(19.dp)) {
                val w = size.width
                val h = size.height
                drawPath(Path().apply {
                    moveTo(w * .1f, h * .38f)
                    lineTo(w * .28f, h * .38f)
                    lineTo(w * .48f, h * .18f)
                    lineTo(w * .48f, h * .82f)
                    lineTo(w * .28f, h * .62f)
                    lineTo(w * .1f, h * .62f)
                    close()
                }, Color.White)
                for (r in listOf(.25f, .43f)) {
                    drawArc(Color.White, -50f, 100f, false,
                        topLeft = Offset(w * (.39f - r / 2), h * (.5f - r)),
                        size = Size(w * r * 1.9f, h * r * 2),
                        style = Stroke(width = 1.4.dp.toPx(), cap = StrokeCap.Round))
                }
            }
        }
    }
}

@Composable
internal fun ForestBanner() {
    Box(Modifier.fillMaxWidth().clip(Rounded).background(
        Brush.verticalGradient(listOf(Color(0xFFDDEDD4), Color(0xFFFFF1C7))),
    )) {
        Canvas(Modifier.matchParentSize()) {
            val w = size.width
            val h = size.height
            drawCircle(Honey, h * .28f, Offset(w * .8f, h * .36f))
            for ((i, color) in listOf(Color(0xFFCFDDA6), Color(0xFFB1CA90), Color(0xFFA0BB86)).withIndex()) {
                drawPath(Path().apply {
                    moveTo(0f, h * (.69f + i * .08f))
                    cubicTo(w * .32f, h * (.30f + i * .19f), w * .72f, h, w, h * (.65f - i * .09f))
                    lineTo(w, h)
                    lineTo(0f, h)
                    close()
                }, color)
            }
            for (i in 0..2) {
                val x = w * (.75f + i * .10f)
                val y = h * (.88f - i * .10f)
                val crown = h * (.10f + i * .028f)
                drawLine(Moss, Offset(x, y), Offset(x, y - crown * 2), 3.dp.toPx())
                drawOval(Color(0xFF749E61), Offset(x - crown, y - crown * 2.65f), Size(crown * 2, crown * 2.35f))
            }
        }
        Column(Modifier.fillMaxWidth(.68f).padding(20.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Heading("Marble")
            Text("一齊認識身邊嘅世界", color = Forest)
        }
    }
}

@Composable
internal fun Choice(
    label: String, onClick: () -> Unit, subtitle: String? = null,
    photo: ContentAsset? = null, emphasis: Boolean = false,
) {
    Row(
        Modifier.fillMaxWidth().heightIn(min = 64.dp).clip(Rounded).background(if (emphasis) Honey else Paper)
            .clickable(role = Role.Button, onClick = onClick).padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (photo != null) Picture(photo, "", Modifier.size(60.dp), maxPixels = 180)
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Label(label)
            subtitle?.let { Text(it) }
        }
        Text("›", color = Forest, style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
internal fun AudioUnavailable() {
    Text("呢段講解暫時播唔到。你可以睇文字。", color = MaterialTheme.colorScheme.error)
}

@Composable
internal fun InvalidPage(back: () -> Unit) {
    Page {
        PageTitle("暫時睇唔到呢項內容", back = back)
        Text("你可以返回，揀另一個知識。")
    }
}

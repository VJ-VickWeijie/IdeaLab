package com.idealab.marble.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.pm.PackageInfoCompat
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.idealab.marble.data.CardGroup
import com.idealab.marble.data.ContentCatalog
import com.idealab.marble.data.ParentState
import com.idealab.marble.data.ParentStore
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

private const val HOME = "home"
private const val PARENT = "parent"

@Composable
internal fun MarbleApp(failedAudio: String?, play: (String) -> Unit, stop: () -> Unit) {
    val context = LocalContext.current.applicationContext
    val version = remember(context) {
        @Suppress("DEPRECATION")
        val info = context.packageManager.getPackageInfo(context.packageName, 0)
        PackageInfoCompat.getLongVersionCode(info)
    }
    var retry by remember { mutableIntStateOf(0) }
    var catalog by remember { mutableStateOf<ContentCatalog?>(null) }
    var store by remember { mutableStateOf<ParentStore?>(null) }
    var state by remember { mutableStateOf<ParentState?>(null) }
    var error by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(context, retry) {
        error = null
        try {
            val loaded = catalog ?: withContext(Dispatchers.IO) { ContentCatalog.load(context.assets) }
            catalog = loaded
            val repository = store ?: ParentStore.create(context, loaded)
            store = repository
            repository.state.collect { state = it }
        } catch (cancelled: CancellationException) {
            throw cancelled
        } catch (_: Exception) {
            state = null
            error = if (catalog == null) "暫時開唔到內置知識。你可以重試，或者安裝修復版本。"
            else "暫時讀唔到本機資料。你可以重試。"
        }
    }
    val loaded = catalog
    val repository = store
    val profile = state
    MarbleTheme {
        ForestWindow {
            when {
                loaded != null && repository != null && profile != null -> {
                    // The store is authoritative before restoring any Android navigation state.
                    key(profile.generation, loaded.contentVersion, version) {
                        Explorer(loaded, repository, profile, failedAudio, play, stop)
                    }
                }
                error != null -> Page {
                    PageTitle("暫時開唔到 Marble")
                    Text(error.orEmpty())
                    Action("重試", { retry++ }, Modifier.fillMaxWidth(), primary = true)
                }
                else -> Page { Text("準備緊知識內容…") }
            }
        }
    }
}

@Composable
private fun Explorer(
    catalog: ContentCatalog, store: ParentStore, state: ParentState,
    failedAudio: String?, play: (String) -> Unit, stop: () -> Unit,
) {
    val context = LocalContext.current
    var today by remember { mutableStateOf(LocalDate.now()) }
    val profile by rememberUpdatedState(state)
    val failure by rememberUpdatedState(failedAudio)
    val startSound by rememberUpdatedState(play)
    val stopSound by rememberUpdatedState(stop)
    val age by rememberUpdatedState(state.age(today))
    val nav = rememberNavController()
    val scope = rememberCoroutineScope()
    var search by remember { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var writeError by remember { mutableStateOf(false) }

    DisposableEffect(context, nav) {
        val dateReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) { today = LocalDate.now() }
        }
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_DATE_CHANGED)
            addAction(Intent.ACTION_TIME_CHANGED)
            addAction(Intent.ACTION_TIMEZONE_CHANGED)
        }
        ContextCompat.registerReceiver(context, dateReceiver, filter, ContextCompat.RECEIVER_NOT_EXPORTED)
        val listener = NavController.OnDestinationChangedListener { _, _, _ -> stopSound() }
        nav.addOnDestinationChangedListener(listener)
        onDispose {
            stopSound()
            nav.removeOnDestinationChangedListener(listener)
            context.unregisterReceiver(dateReceiver)
        }
    }
    LaunchedEffect(age.band) { stopSound() }

    fun persist(block: suspend (Long) -> Unit) {
        val generation = profile.generation
        scope.launch {
            try { block(generation) }
            catch (cancelled: CancellationException) { throw cancelled }
            catch (_: Exception) { writeError = true }
        }
    }

    fun active(entry: NavBackStackEntry) = nav.currentBackStackEntry == entry

    fun back(entry: NavBackStackEntry) {
        if (!active(entry)) return
        stopSound()
        nav.popBackStack()
    }

    fun go(entry: NavBackStackEntry, route: String) {
        if (!active(entry)) return
        stopSound()
        nav.navigate(route) { launchSingleTop = true }
    }

    fun open(entry: NavBackStackEntry, id: String, origin: String, reading: Boolean = false, record: Boolean = true) {
        if (!active(entry) || catalog.presentation(id, age.band) == null) return
        if (record) persist { store.openNode(id, it) }
        go(entry, "detail/${Uri.encode(id)}/$origin/$reading")
    }

    fun cards(entry: NavBackStackEntry, group: CardGroup, id: String, replace: Boolean = false, record: Boolean = true) {
        if (!active(entry) || id !in group.nodeIds) return
        stopSound()
        if (record) persist { store.continueAt(group.id, id, it) }
        nav.navigate("cards/${Uri.encode(group.id)}/${Uri.encode(id)}") {
            if (replace) popUpTo(entry.destination.id) { inclusive = true }
        }
    }

    NavHost(navController = nav, startDestination = HOME) {
        composable(HOME) { entry ->
            HomePage(catalog, age.band, profile,
                explore = {
                    catalog.groups(age.band).firstOrNull()?.let { group ->
                        group.nodeIds.firstOrNull()?.let { cards(entry, group, it) }
                    }
                },
                together = { go(entry, "together") },
                resume = {
                    profile.resume?.let { anchor ->
                        val group = anchor.groupId?.let { catalog.group(it, age.band) }
                        if (group != null && anchor.nodeId in group.nodeIds) cards(entry, group, anchor.nodeId, record = false)
                        else open(entry, anchor.nodeId, HOME, record = false)
                    }
                },
                search = {
                    search = ""
                    go(entry, "search")
                },
                category = { go(entry, "category/${Uri.encode(it)}") },
                open = { open(entry, it, HOME) },
                settings = { go(entry, PARENT) },
            )
        }
        composable("cards/{groupId}/{start}") { entry ->
            val group = catalog.group(entry.arg("groupId"), age.band)
            if (group == null) InvalidPage { back(entry) }
            else {
                val groups = catalog.groups(age.band)
                val next = groups.getOrNull((groups.indexOf(group) + 1) % groups.size)?.takeUnless { it.id == group.id }
                CardPage(catalog, age.band, group, entry.arg("start"), failure,
                    play = { if (active(entry)) startSound(it) },
                    stop = stopSound,
                    save = { node -> if (active(entry)) persist { store.continueAt(group.id, node, it) } },
                    details = { open(entry, it, "cards") },
                    nextGroup = next?.let { target -> { cards(entry, target, target.nodeIds.first(), replace = true) } },
                    home = { back(entry) },
                )
            }
        }
        composable("detail/{nodeId}/{source}/{reading}") { entry ->
            val id = entry.arg("nodeId")
            val item = catalog.presentation(id, age.band)
            if (item == null) InvalidPage { back(entry) }
            else DetailPage(
                catalog, item, profile.depth, entry.arg("reading") == "true", failure,
                backLabel = when (entry.arg("source")) {
                    "map" -> "返回知識地圖"
                    "cards" -> "返回滑滑認識世界"
                    "together" -> "返回親子一齊睇"
                    "history" -> "返回探索歷史"
                    "search" -> "返回搜尋"
                    "category" -> "返回主題分類"
                    else -> "返回首頁"
                },
                play = { if (active(entry)) startSound(it) },
                stop = stopSound,
                map = { go(entry, "map/${Uri.encode(id)}") },
                back = { back(entry) },
            )
        }
        composable("map/{nodeId}") { entry ->
            val item = catalog.presentation(entry.arg("nodeId"), age.band)
            if (item == null) InvalidPage { back(entry) }
            else MapPage(catalog, age.band, item, { open(entry, it, "map") }, { back(entry) })
        }
        composable(PARENT) { entry ->
            ParentPage(profile, age, today,
                save = { birth, mode, depth ->
                    if (!busy) {
                        busy = true
                        persist { generation ->
                            try {
                                store.saveSettings(birth, mode, depth, generation, today)
                                back(entry)
                            } finally { busy = false }
                        }
                    }
                },
                clear = { all ->
                    if (!busy) {
                        busy = true
                        stopSound()
                        persist {
                            try {
                                if (all) store.clearEverything() else store.clearHistory()
                            } finally { busy = false }
                        }
                    }
                },
                history = { go(entry, "history") },
                credits = { go(entry, "credits") },
                busy = busy,
                back = { back(entry) },
            )
        }
        composable("search") { entry ->
            SearchPage(catalog, age.band, search, { search = it }, { open(entry, it, "search") }, { back(entry) })
        }
        composable("together") { entry ->
            NodeListPage(catalog, age.band, "親子一齊睇", "返回首頁", catalog.knowledge,
                { open(entry, it, "together", reading = true) }, { back(entry) })
        }
        composable("category/{name}") { entry ->
            val name = entry.arg("name")
            NodeListPage(catalog, age.band, name, "返回首頁", catalog.knowledge.filter { it.category == name },
                { open(entry, it, "category") }, { back(entry) })
        }
        composable("history") { entry ->
            NodeListPage(catalog, age.band, "探索歷史", "返回家長設定", profile.history.mapNotNull(catalog::node),
                { open(entry, it, "history") }, { back(entry) })
        }
        composable("credits") { entry -> CreditsPage(catalog) { back(entry) } }
    }
    if (writeError) AlertDialog(
        onDismissRequest = { writeError = false },
        title = { Text("暫時儲存唔到") },
        text = { Text("本機資料未能更新。你可以關閉提示後重試。") },
        confirmButton = { Action("關閉提示", { writeError = false }) },
    )
}

private fun NavBackStackEntry.arg(name: String) = arguments?.getString(name).orEmpty()

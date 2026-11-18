package com.idealab.marble

import android.graphics.Bitmap
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.click
import androidx.compose.ui.test.getUnclippedBoundsInRoot
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExploreFlowTest {
    @get:Rule val compose = createAndroidComposeRule<MainActivity>()

    @Before fun clearBeforeTest() {
        tap("家長設定")
        tap("清除所有本機資料")
        compose.onNodeWithText("確認清除").performClick()
        await("Marble")
        compose.onNodeWithText("繼續探索").assertDoesNotExist()
    }

    @Test fun cardGesturesReadingMapAndRestore() {
        snapshot("01-home")
        tap("滑滑認識世界")
        await("1 / 5")
        snapshot("02-cards")
        val photo = compose.onNodeWithTag("card-photo")
        val pageBounds = compose.onNodeWithTag("card-page").getUnclippedBoundsInRoot()
        val photoBounds = photo.getUnclippedBoundsInRoot()
        val photoFraction = (photoBounds.bottom - photoBounds.top) / (pageBounds.bottom - pageBounds.top)
        assertTrue("Expected a photo about two thirds of the viewport, got $photoFraction", photoFraction in 0.57f..0.69f)
        assertTrue(photoBounds.left > pageBounds.left + 8.dp)
        compose.onNodeWithText("上一張").assertDoesNotExist()
        compose.onNodeWithText("下一張").assertDoesNotExist()
        photo.performTouchInput { click(center) }
        photo.performTouchInput {
            down(center)
            moveTo(center - Offset(0f, 20.dp.toPx()))
            up()
        }
        await("1 / 5")
        photo.performTouchInput {
            down(center)
            moveTo(center - Offset(0f, 70.dp.toPx()))
            cancel()
        }
        await("1 / 5")
        swipeMargin(forward = true)
        await("2 / 5")
        swipeMargin(forward = false)
        await("1 / 5")
        tapCard("家長陪讀")
        await("家長陪讀 · 香蕉")
        snapshot("04-caregiver")
        tap("關閉陪讀")
        tapCard("睇知識詳情")
        await("返回滑滑認識世界")
        snapshot("03-detail")
        tap("打開知識地圖")
        await("知識地圖 · 香蕉")
        snapshot("05-map")
        tap("蘋果")
        await("返回知識地圖")
        compose.activityRule.scenario.recreate()
        tap("返回知識地圖")
        await("知識地圖 · 香蕉")
        compose.onAllNodesWithText("返回香蕉詳情").assertCountEquals(2)
        compose.onAllNodesWithText("返回香蕉詳情")[1].performScrollTo().performClick()
        tap("返回滑滑認識世界")
        await("1 / 5")
    }

    @Test fun groupsSearchAndHistoryClear() {
        tap("家長設定")
        tap("手動 · 1–2 歲")
        tap("儲存設定")
        tap("滑滑認識世界")
        await("1 / 6")
        repeat(5) { swipeMargin(forward = true) }
        await("6 / 6")
        tapCard("重睇呢組")
        await("1 / 6")
        repeat(5) { swipeMargin(forward = true) }
        tapCard("換一組")
        await("1 / 6")
        tapCard("返回首頁")
        tap("搜尋知識")
        compose.onNodeWithTag("search-query").performTextInput("banana")
        tap("香蕉")
        tap("返回搜尋")
        await("香蕉")
        tap("返回首頁")
        await("繼續探索")
        tap("家長設定")
        tap("查看探索歷史")
        await("香蕉")
        tap("返回家長設定")
        tap("清除探索歷史")
        compose.onNodeWithText("確認清除").performClick()
        await("Marble")
        compose.activityRule.scenario.recreate()
        await("Marble")
        compose.onNodeWithText("繼續探索").assertDoesNotExist()
        tap("家長設定")
        compose.onNodeWithText("目前使用 1–2 歲內容").performScrollTo().assertIsDisplayed()
    }

    private fun swipeMargin(forward: Boolean) {
        compose.onNodeWithTag("card-page").performTouchInput {
            // The page's 8 dp gutter is outside the photo for the entire gesture.
            val x = 8.dp.toPx()
            val upper = height * .20f
            val lower = height * .80f
            swipe(Offset(x, if (forward) lower else upper), Offset(x, if (forward) upper else lower))
        }
    }

    private fun tapCard(label: String) {
        await(label)
        compose.onNodeWithText(label).performClick()
    }

    private fun snapshot(name: String) {
        compose.waitForIdle()
        val test = InstrumentationRegistry.getInstrumentation()
        val bitmap = test.uiAutomation.takeScreenshot() ?: return
        test.targetContext.filesDir.resolve("m4-$name.png").outputStream().use {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
        }
        bitmap.recycle()
    }

    private fun tap(label: String) {
        await(label)
        compose.onNodeWithText(label).performScrollTo().performClick()
    }

    private fun await(label: String) {
        compose.waitUntil(timeoutMillis = 15_000) {
            compose.onAllNodesWithText(label).fetchSemanticsNodes().isNotEmpty()
        }
    }
}

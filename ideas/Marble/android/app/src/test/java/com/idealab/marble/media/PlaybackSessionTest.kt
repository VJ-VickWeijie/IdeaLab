package com.idealab.marble.media

import java.io.IOException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PlaybackSessionTest {
    private val backend = FakeBackend()
    private val failures = mutableListOf<String>()
    private val session = PlaybackSession(backend) { failures.add(it) }

    @Test
    fun prepareAndErrorCallbacksFromStoppedTrackCannotAffectNextTrack() {
        session.setInteractive(true)
        session.playFromStart("first")
        val first = backend.tracks.single()

        session.stop()
        session.playFromStart("second")
        val second = backend.tracks.last()
        first.callbacks.onPrepared()
        first.callbacks.onFailure()
        first.callbacks.onFocusLost()
        first.callbacks.onCompletion()
        second.callbacks.onPrepared()

        assertEquals(1, first.closes)
        assertEquals(0, first.starts)
        assertEquals(1, second.starts)
        assertEquals(0, second.closes)
        assertTrue(failures.isEmpty())
    }

    @Test
    fun repeatedTapStartsANewClipFromTheBeginning() {
        session.setInteractive(true)
        session.playFromStart("same")
        val first = backend.tracks.single()
        first.callbacks.onPrepared()

        session.playFromStart("same")
        val second = backend.tracks.last()
        second.callbacks.onPrepared()
        second.callbacks.onPrepared()
        second.callbacks.onCompletion()

        assertEquals(listOf("same", "same"), backend.paths)
        assertEquals(1, first.starts)
        assertEquals(1, second.starts)
        assertEquals(1, first.closes)
        assertEquals(1, second.closes)
    }

    @Test
    fun backgroundCancelsPendingPlaybackAndReturningDoesNotResumeIt() {
        session.playFromStart("ignored initially")
        session.setInteractive(true)
        session.playFromStart("first")
        val pending = backend.tracks.single()

        session.setInteractive(false)
        pending.callbacks.onPrepared()
        session.playFromStart("ignored in background")
        session.setInteractive(true)

        assertEquals(listOf("first"), backend.paths)
        assertEquals(1, pending.closes)
        assertEquals(0, pending.starts)
    }

    @Test
    fun focusLossAndNoisyStopReleaseTheActiveTrackWithoutRequestingPlayback() {
        session.setInteractive(true)
        session.playFromStart("first")
        val first = backend.tracks.single()
        first.callbacks.onPrepared()
        first.callbacks.onFocusLost()

        session.playFromStart("second")
        val second = backend.tracks.last()
        second.callbacks.onPrepared()
        session.stop()

        assertEquals(listOf("first", "second"), backend.paths)
        assertEquals(1, first.closes)
        assertEquals(1, second.closes)
        assertTrue(failures.isEmpty())
    }

    @Test
    fun deniedFocusAndUnreadableAssetReleaseTrackAndReportCorrectPath() {
        session.setInteractive(true)
        backend.grantFocus = false
        session.playFromStart("focus denied")
        backend.grantFocus = true
        backend.canPrepare = false
        session.playFromStart("missing")

        assertEquals(listOf("focus denied", "missing"), failures)
        assertEquals(listOf(1, 1), backend.tracks.map { it.closes })
        assertEquals(listOf(0, 1), backend.tracks.map { it.prepares })
        assertEquals(listOf(0, 0), backend.tracks.map { it.starts })
    }

    @Test
    fun closeIsIdempotentAndDiscardsAllFutureTriggers() {
        session.setInteractive(true)
        session.playFromStart("first")
        val first = backend.tracks.single()
        session.close()
        session.close()
        session.setInteractive(true)
        session.playFromStart("ignored")
        first.callbacks.onPrepared()
        first.callbacks.onFailure()

        assertEquals(listOf("first"), backend.paths)
        assertEquals(1, first.closes)
        assertEquals(0, first.starts)
        assertTrue(failures.isEmpty())
    }
}

private class FakeBackend : PlaybackBackend {
    val paths = mutableListOf<String>()
    val tracks = mutableListOf<FakeTrack>()
    var grantFocus = true
    var canPrepare = true

    override fun open(assetPath: String, callbacks: PlaybackCallbacks): PlaybackTrack {
        paths.add(assetPath)
        return FakeTrack(callbacks, grantFocus, canPrepare).also { tracks.add(it) }
    }
}

private class FakeTrack(
    val callbacks: PlaybackCallbacks,
    private val grantFocus: Boolean,
    private val canPrepare: Boolean,
) : PlaybackTrack {
    var prepares = 0
    var starts = 0
    var closes = 0

    override fun requestFocus(): Boolean = grantFocus

    override fun prepare() {
        prepares++
        if (!canPrepare) throw IOException("missing test asset")
    }

    override fun start() {
        starts++
    }

    override fun close() {
        closes++
    }
}

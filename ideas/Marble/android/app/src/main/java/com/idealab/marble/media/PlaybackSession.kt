package com.idealab.marble.media

internal interface PlaybackTrack {
    fun requestFocus(): Boolean
    fun prepare()
    fun start()
    fun close()
}

internal interface PlaybackCallbacks {
    fun onPrepared()
    fun onCompletion()
    fun onFailure()
    fun onFocusLost()
}

internal fun interface PlaybackBackend {
    fun open(assetPath: String, callbacks: PlaybackCallbacks): PlaybackTrack
}

/** A single foreground playback slot. The owner and backend call it on the same thread. */
internal class PlaybackSession(
    private val backend: PlaybackBackend,
    private val onFailure: (String) -> Unit,
) {
    private var interactive = false
    private var closed = false
    private var current: Request? = null

    private class Request(val assetPath: String) {
        var track: PlaybackTrack? = null
        var prepared = false
    }

    fun setInteractive(active: Boolean) {
        if (closed) return
        interactive = active
        if (!active) stop()
    }

    fun playFromStart(assetPath: String) {
        if (closed || !interactive) return
        stop()
        val request = Request(assetPath)
        current = request
        try {
            val track = backend.open(assetPath, callbacksFor(request))
            if (current !== request) {
                track.close()
                return
            }
            request.track = track
            if (!track.requestFocus()) {
                fail(request)
            } else if (current === request) {
                track.prepare()
            }
        } catch (_: Exception) {
            fail(request)
        }
    }

    fun stop() {
        val previous = current
        current = null
        previous?.track?.close()
    }

    fun close() {
        closed = true
        interactive = false
        stop()
    }

    private fun callbacksFor(request: Request): PlaybackCallbacks = object : PlaybackCallbacks {
        override fun onPrepared() {
            if (current !== request || request.prepared) return
            request.prepared = true
            try {
                request.track?.start()
            } catch (_: Exception) {
                fail(request)
            }
        }

        override fun onCompletion() {
            if (current === request) stop()
        }

        override fun onFailure() = fail(request)

        override fun onFocusLost() {
            if (current === request) stop()
        }
    }

    private fun fail(request: Request) {
        if (current !== request) return
        stop()
        onFailure(request.assetPath)
    }
}

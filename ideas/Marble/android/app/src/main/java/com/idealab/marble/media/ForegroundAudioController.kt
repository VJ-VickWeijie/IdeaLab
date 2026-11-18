package com.idealab.marble.media

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat

/** One short, local clip at a time. Call from the Activity's main thread. */
class ForegroundAudioController(context: Context, onFailure: (String) -> Unit) {
    private val app = context.applicationContext
    private val mainHandler = Handler(Looper.getMainLooper())
    private val audioManager = checkNotNull(app.getSystemService(AudioManager::class.java))
    private val session = PlaybackSession(
        PlaybackBackend { path, callbacks ->
            AndroidTrack(app.assets, audioManager, mainHandler, path, callbacks)
        },
        onFailure,
    )
    private var closed = false
    private val noisyReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == AudioManager.ACTION_AUDIO_BECOMING_NOISY) stop()
        }
    }

    init {
        checkMainThread()
        ContextCompat.registerReceiver(
            app,
            noisyReceiver,
            IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY),
            ContextCompat.RECEIVER_NOT_EXPORTED,
        )
    }

    fun setInteractive(active: Boolean) {
        checkMainThread()
        session.setInteractive(active)
    }

    fun playFromStart(assetPath: String) {
        checkMainThread()
        session.playFromStart(assetPath)
    }

    fun stop() {
        checkMainThread()
        session.stop()
    }

    fun close() {
        checkMainThread()
        if (closed) return
        closed = true
        try {
            session.close()
        } finally {
            app.unregisterReceiver(noisyReceiver)
        }
    }

    private fun checkMainThread() {
        check(Looper.myLooper() === mainHandler.looper) { "Playback owner must use the main thread" }
    }
}

private class AndroidTrack(
    private val assets: AssetManager,
    private val audioManager: AudioManager,
    callbackHandler: Handler,
    private val assetPath: String,
    callbacks: PlaybackCallbacks,
) : PlaybackTrack {
    private val attributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_MEDIA)
        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
        .build()
    private val request = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
        .setAudioAttributes(attributes)
        .setAcceptsDelayedFocusGain(false)
        .setWillPauseWhenDucked(true)
        .setOnAudioFocusChangeListener({ change ->
            if (change < 0) callbacks.onFocusLost()
        }, callbackHandler)
        .build()
    private val player = MediaPlayer()
    private var hasFocus = false
    private var closed = false

    init {
        player.setOnPreparedListener { callbacks.onPrepared() }
        player.setOnCompletionListener { callbacks.onCompletion() }
        player.setOnErrorListener { _, _, _ ->
            callbacks.onFailure()
            true
        }
    }

    override fun requestFocus(): Boolean {
        hasFocus = audioManager.requestAudioFocus(request) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
        return hasFocus
    }

    override fun prepare() {
        player.setAudioAttributes(attributes)
        assets.openFd(assetPath).use { source ->
            player.setDataSource(source.fileDescriptor, source.startOffset, source.length)
        }
        player.prepareAsync()
    }

    override fun start() = player.start()

    override fun close() {
        if (closed) return
        closed = true
        try {
            runCatching { player.release() }
        } finally {
            if (hasFocus) runCatching { audioManager.abandonAudioFocusRequest(request) }
            hasFocus = false
        }
    }
}

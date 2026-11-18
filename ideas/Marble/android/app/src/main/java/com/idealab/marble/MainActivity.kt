package com.idealab.marble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.idealab.marble.media.ForegroundAudioController
import com.idealab.marble.ui.MarbleApp

class MainActivity : ComponentActivity() {
    private lateinit var audio: ForegroundAudioController
    private var failedAudio by mutableStateOf<String?>(null)
    private var resumed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        audio = ForegroundAudioController(this) { failedAudio = it }
        setContent {
            MarbleApp(failedAudio, play = {
                failedAudio = null
                audio.playFromStart(it)
            }, stop = {
                audio.stop()
                failedAudio = null
            })
        }
    }

    override fun onResume() {
        super.onResume()
        resumed = true
        audio.setInteractive(hasWindowFocus())
    }

    override fun onPause() {
        resumed = false
        audio.setInteractive(false)
        super.onPause()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (::audio.isInitialized) audio.setInteractive(resumed && hasFocus)
    }

    override fun onDestroy() {
        audio.close()
        super.onDestroy()
    }
}

package com.idealab.marble.ui

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.changedToUp
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.abs

internal enum class Gesture(val step: Int) { TAP(0), DRAG(0), NEXT(1), PREVIOUS(-1) }

internal class GestureTracker(private val slop: Float, private val minimumSwipe: Float) {
    private var moved = false
    private var multiTouch = false

    fun update(x: Float, y: Float, anotherFinger: Boolean): Gesture {
        multiTouch = multiTouch || anotherFinger
        moved = moved || x * x + y * y > slop * slop
        if (!moved && !multiTouch) return Gesture.TAP
        if (multiTouch || abs(y) < minimumSwipe || abs(y) < 1.35f * abs(x)) return Gesture.DRAG
        return if (y < 0) Gesture.NEXT else Gesture.PREVIOUS
    }
}

@Composable
internal fun Modifier.cardGestures(onStep: (Int) -> Unit): Modifier {
    val step by rememberUpdatedState(onStep)
    return pointerInput(Unit) {
        awaitEachGesture {
            val down = awaitFirstDown(requireUnconsumed = false, pass = PointerEventPass.Initial)
            val tracker = GestureTracker(viewConfiguration.touchSlop, 54.dp.toPx())
            do {
                val event = awaitPointerEvent(PointerEventPass.Initial)
                val change = event.changes.firstOrNull { it.id == down.id } ?: break
                val delta = change.position - down.position
                val multiple = event.changes.any { it.id != down.id && (it.pressed || it.previousPressed) }
                val outcome = tracker.update(delta.x, delta.y, multiple)
                // Android dispatches a consumed release when the gesture is cancelled.
                val released = change.changedToUp()
                if (outcome != Gesture.TAP) event.changes.forEach { it.consume() }
                if (released && outcome.step != 0) step(outcome.step)
            } while (change.pressed)
        }
    }
}

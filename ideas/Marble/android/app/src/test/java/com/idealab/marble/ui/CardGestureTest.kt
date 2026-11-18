package com.idealab.marble.ui

import org.junit.Assert.assertEquals
import org.junit.Test

class CardGestureTest {
    private fun tracker() = GestureTracker(8f, 54f)

    @Test fun slopKeepsSmallTap() {
        assertEquals(Gesture.TAP, tracker().update(4f, 5f, false))
    }

    @Test fun shortDragCannotBecomeATapAgain() {
        val gesture = tracker()
        assertEquals(Gesture.DRAG, gesture.update(1f, 20f, false))
        assertEquals(Gesture.DRAG, gesture.update(0f, 0f, false))
    }

    @Test fun slideMustBeVertical() {
        assertEquals(Gesture.DRAG, tracker().update(70f, 65f, false))
        assertEquals(Gesture.NEXT, tracker().update(10f, -69f, false))
        assertEquals(Gesture.PREVIOUS, tracker().update(-10f, 69f, false))
    }

    @Test fun extraFingerDisqualifiesTheEntireGesture() {
        val gesture = tracker()
        assertEquals(Gesture.DRAG, gesture.update(0f, 0f, true))
        assertEquals(Gesture.DRAG, gesture.update(0f, -92f, false))
    }
}

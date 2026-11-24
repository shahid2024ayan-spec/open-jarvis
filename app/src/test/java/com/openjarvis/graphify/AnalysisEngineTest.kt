package com.openjarvis.graphify

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class AnalysisEngineTest {

    @Test
    fun sequenceHashIsStableAndDistinct() {
        val first = AnalysisEngine.hashSequence("open app -> send message")
        val repeated = AnalysisEngine.hashSequence("open app -> send message")
        val different = AnalysisEngine.hashSequence("open app -> close app")

        assertEquals(first, repeated)
        assertNotEquals(first, different)
        assertEquals(16, first.length)
    }

    @Test
    fun fuzzyContactDistanceHandlesSmallTypos() {
        assertEquals(0, AnalysisEngine.levenshteinDistance("john", "john"))
        assertEquals(1, AnalysisEngine.levenshteinDistance("john", "jon"))
        assertEquals(2, AnalysisEngine.levenshteinDistance("john", "jhon"))
    }

    @Test
    fun stalePatternConfidenceDecaysWithFloor() {
        assertEquals(0.72f, AnalysisEngine.decayedConfidence(0.9f), 0.001f)
        assertEquals(0.1f, AnalysisEngine.decayedConfidence(0.1f), 0.001f)
        assertEquals(0.1f, AnalysisEngine.decayedConfidence(0.0f), 0.001f)
    }
}

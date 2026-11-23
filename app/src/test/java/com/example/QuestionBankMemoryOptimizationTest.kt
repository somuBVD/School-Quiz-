package com.example

import com.example.data.QuestionBankCache
import com.example.data.QuizStaticData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class QuestionBankMemoryOptimizationTest {

    @Before
    fun setUp() {
        QuestionBankCache.clear()
    }

    @Test
    fun readingStandardsListOnStartupLoadsZeroQuestionBanks() {
        val standards = QuizStaticData.standardsList
        assertTrue("Standards list must include Std 6..10, Morarji, NMMS", standards.size >= 7)
        assertEquals(
            "Startup Home screen access to standardsList must not eagerly allocate any question banks",
            0,
            QuestionBankCache.cachedBankCount()
        )
    }

    @Test
    fun getQuestionsForUnitLoadsOnlyTargetBankAndRespectsLruCap() {
        val std8Sci = QuizStaticData.getQuestionsForUnit(8, "science", 1, emptyList())
        assertTrue("Std 8 Science Unit 1 should return real questions", std8Sci.isNotEmpty())
        assertTrue(
            "Only CoreStatic and Std8Science should be loaded (actual: ${QuestionBankCache.cachedKeys()})",
            QuestionBankCache.cachedBankCount() <= 2
        )

        // Browse across 6 distinct subjects and verify cache never exceeds MAX_CACHED_BANKS (3)
        val targets = listOf(
            Triple(6, "kannada", 1),
            Triple(7, "english", 1),
            Triple(8, "math", 1),
            Triple(9, "science", 1),
            Triple(10, "social", 1),
            Triple(11, "gk", 1),
            Triple(12, "gmat", 1)
        )
        for ((stdId, subjectId, unitId) in targets) {
            val qs = QuizStaticData.getQuestionsForUnit(stdId, subjectId, unitId, emptyList())
            assertTrue("Expected real questions for std=$stdId subject=$subjectId", qs.isNotEmpty())
            assertTrue(
                "Cache size must stay bounded <= ${QuestionBankCache.MAX_CACHED_BANKS}",
                QuestionBankCache.cachedBankCount() <= QuestionBankCache.MAX_CACHED_BANKS
            )
        }

        // Simulate Android onTrimMemory / onLowMemory eviction
        QuestionBankCache.clear()
        assertEquals(0, QuestionBankCache.cachedBankCount())
    }
}

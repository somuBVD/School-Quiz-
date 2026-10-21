package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test

class QuizRecommendationEngineTest {

    @Test
    fun testWeakCategoryGeneratesNeedsPracticeRecommendation() {
        val userProfile = UserProfile(standard = 6, attendanceStreak = 4)
        // Student scored 45% in Math Unit 1
        val progressList = listOf(
            UnitProgress(stdId = 6, subjectId = "math", unitId = 1, progress = 45, completedQuestions = 4, totalQuestions = 10)
        )

        val recommendations = QuizRecommendationEngine.generateRecommendations(userProfile, progressList, 6)
        val mathRec = recommendations.find { it.subjectId == "math" && it.unitId == 1 }

        assertNotNull("Should recommend practicing weak unit", mathRec)
        assertTrue("Reason should indicate weak area", mathRec?.reason?.isWeakArea == true)
        assertTrue("Priority should be high for weak unit", (mathRec?.priorityScore ?: 0f) > 50f)
        assertTrue("Rationale should mention previous score", mathRec?.rationale?.contains("45%") == true)
    }

    @Test
    fun testCompletedUnitSuggestsNextInSequence() {
        val userProfile = UserProfile(standard = 6)
        // Student completed Kannada Unit 1 with 80%
        val progressList = listOf(
            UnitProgress(stdId = 6, subjectId = "kannada", unitId = 1, progress = 80, completedQuestions = 8, totalQuestions = 10),
            UnitProgress(stdId = 6, subjectId = "kannada", unitId = 2, progress = 0, completedQuestions = 0, totalQuestions = 10)
        )

        val recommendations = QuizRecommendationEngine.generateRecommendations(userProfile, progressList, 6)
        val nextUnitRec = recommendations.find { it.subjectId == "kannada" && it.unitId == 2 }

        assertNotNull("Should suggest next chapter in sequence", nextUnitRec)
        assertEquals(RecommendationReason.NEXT_IN_SEQUENCE, nextUnitRec?.reason)
    }

    @Test
    fun testUnexploredSubjectGeneratesDiscoveryRecommendation() {
        val userProfile = UserProfile(standard = 6)
        // No progress in any subject
        val emptyProgress = emptyList<UnitProgress>()

        val recommendations = QuizRecommendationEngine.generateRecommendations(userProfile, emptyProgress, 6)
        val discoveryRecs = recommendations.filter { it.reason == RecommendationReason.UNEXPLORED_TOPIC }

        assertTrue("Should have discovery recommendations for unattempted subjects", discoveryRecs.isNotEmpty())
        assertEquals(1, discoveryRecs.first().unitId)
    }

    @Test
    fun testCategorySummariesCalculation() {
        val progressList = listOf(
            // Strong subject
            UnitProgress(stdId = 6, subjectId = "science", unitId = 1, progress = 90, completedQuestions = 9, totalQuestions = 10),
            // Weak subject
            UnitProgress(stdId = 6, subjectId = "math", unitId = 1, progress = 40, completedQuestions = 4, totalQuestions = 10)
        )

        val summaries = QuizRecommendationEngine.calculateCategorySummaries(progressList, 6)
        val scienceSummary = summaries.find { it.subjectId == "science" }
        val mathSummary = summaries.find { it.subjectId == "math" }
        val englishSummary = summaries.find { it.subjectId == "english" }

        assertEquals(CategoryStatus.STRONG, scienceSummary?.status)
        assertEquals(90, scienceSummary?.averageScore)

        assertEquals(CategoryStatus.WEAK, mathSummary?.status)
        assertEquals(40, mathSummary?.averageScore)

        assertEquals(CategoryStatus.UNTOUCHED, englishSummary?.status)
        assertEquals(0, englishSummary?.attemptedUnits)
    }

    @Test
    fun testHistoricalScoresCriticalWeakAreaPrioritized() {
        val userProfile = UserProfile(standard = 6)
        val progressList = emptyList<UnitProgress>()

        // Historical scores show 2 failed attempts in Science Unit 1 with 30% and 40%
        val historicalScores = listOf(
            HistoricalScoreEntity(
                id = 1L,
                stdId = 6,
                subjectId = "science",
                unitId = 1,
                unitName = "Food & Components",
                score = 3,
                totalQuestions = 10,
                accuracyPercentage = 30,
                earnedCoins = 5,
                earnedXP = 20,
                earnedStars = 1,
                isPassed = false,
                completedAt = System.currentTimeMillis() - 86400000L
            ),
            HistoricalScoreEntity(
                id = 2L,
                stdId = 6,
                subjectId = "science",
                unitId = 1,
                unitName = "Food & Components",
                score = 4,
                totalQuestions = 10,
                accuracyPercentage = 40,
                earnedCoins = 8,
                earnedXP = 30,
                earnedStars = 1,
                isPassed = false,
                completedAt = System.currentTimeMillis()
            )
        )

        val recommendations = QuizRecommendationEngine.generateRecommendations(
            userProfile = userProfile,
            progressList = progressList,
            historicalScores = historicalScores,
            standard = 6
        )

        val scienceRec = recommendations.find { it.subjectId == "science" && it.unitId == 1 }
        assertNotNull("Should generate recommendation for weak science unit", scienceRec)
        assertEquals(RecommendationReason.CRITICAL_WEAKNESS, scienceRec?.reason)
        assertTrue(scienceRec?.reason?.isWeakArea == true)
        assertEquals(2, scienceRec?.historicalAttemptsCount)
        assertEquals(2, scienceRec?.failedAttemptsCount)
        assertTrue(scienceRec?.roomStatsDiagnostic?.contains("2 attempts") == true)
        // Ensure priority is higher than normal discovery (which is ~65f)
        assertTrue((scienceRec?.priorityScore ?: 0f) > 100f)
    }

    @Test
    fun testIdentifyWeakAreaTopicsFromRoomStats() {
        val progressList = listOf(
            UnitProgress(stdId = 6, subjectId = "math", unitId = 2, progress = 45, completedQuestions = 4, totalQuestions = 10)
        )
        val historicalScores = listOf(
            HistoricalScoreEntity(
                id = 1L,
                stdId = 6,
                subjectId = "math",
                unitId = 2,
                unitName = "Algebra",
                score = 4,
                totalQuestions = 10,
                accuracyPercentage = 40,
                earnedCoins = 5,
                earnedXP = 20,
                earnedStars = 1,
                isPassed = false,
                completedAt = System.currentTimeMillis()
            )
        )

        val weakTopics = QuizRecommendationEngine.identifyWeakAreaTopics(
            progressList = progressList,
            historicalScores = historicalScores,
            standard = 6
        )

        assertTrue("Should detect weak topics", weakTopics.isNotEmpty())
        val mathWeak = weakTopics.find { it.subjectId == "math" && it.unitId == 2 }
        assertNotNull(mathWeak)
        assertEquals(40, mathWeak?.averageAccuracy)
        assertEquals(WeaknessUrgency.CRITICAL, mathWeak?.urgencyLevel)
        assertTrue(mathWeak?.diagnosticSummary?.contains("Critical") == true)
    }
}

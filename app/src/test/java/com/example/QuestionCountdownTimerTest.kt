package com.example

import com.example.ui.quiz.QuestionScoreResult
import com.example.ui.quiz.QuestionTimeStat
import com.example.ui.quiz.TimeThresholdZone
import org.junit.Assert.*
import org.junit.Test

class QuestionCountdownTimerTest {

    @Test
    fun testSpeedBonusZoneThreshold() {
        // <= 30 seconds should award speed bonus
        val zone = TimeThresholdZone.getZoneForElapsed(20)
        assertEquals(TimeThresholdZone.SPEED_BONUS, zone)
        assertEquals(15, zone.speedBonus)
        assertEquals(0, zone.penaltyDeduction)

        val score = TimeThresholdZone.calculateScore(
            isCorrect = true,
            elapsedSecs = 20,
            isTimedOut = false,
            basePoints = 100
        )
        assertEquals(115, score.finalPoints)
        assertEquals(15, score.speedBonus)
        assertEquals(0, score.penaltyDeduction)
        assertEquals(TimeThresholdZone.SPEED_BONUS, score.zone)
    }

    @Test
    fun testStandardPaceZoneThreshold() {
        // 31 - 60 seconds is standard pace (full points, 0 penalty)
        val zone = TimeThresholdZone.getZoneForElapsed(45)
        assertEquals(TimeThresholdZone.STANDARD, zone)
        assertEquals(0, zone.penaltyDeduction)
        assertEquals(0, zone.speedBonus)

        val score = TimeThresholdZone.calculateScore(
            isCorrect = true,
            elapsedSecs = 45,
            isTimedOut = false,
            basePoints = 100
        )
        assertEquals(100, score.finalPoints)
        assertEquals(0, score.penaltyDeduction)
        assertEquals(0, score.speedBonus)
        assertEquals(TimeThresholdZone.STANDARD, score.zone)
    }

    @Test
    fun testThreshold1DeductionForOvertime() {
        // Exceeding 60 seconds (e.g. 75s) should deduct 20 points
        val zone = TimeThresholdZone.getZoneForElapsed(75)
        assertEquals(TimeThresholdZone.THRESHOLD_1_PENALTY, zone)
        assertEquals(20, zone.penaltyDeduction)

        val score = TimeThresholdZone.calculateScore(
            isCorrect = true,
            elapsedSecs = 75,
            isTimedOut = false,
            basePoints = 100
        )
        assertEquals(80, score.finalPoints) // 100 - 20
        assertEquals(20, score.penaltyDeduction)
        assertEquals(TimeThresholdZone.THRESHOLD_1_PENALTY, score.zone)
    }

    @Test
    fun testThreshold2DeductionForCriticalOvertime() {
        // Exceeding 90 seconds (e.g. 105s) should deduct 50 points
        val zone = TimeThresholdZone.getZoneForElapsed(105)
        assertEquals(TimeThresholdZone.THRESHOLD_2_PENALTY, zone)
        assertEquals(50, zone.penaltyDeduction)

        val score = TimeThresholdZone.calculateScore(
            isCorrect = true,
            elapsedSecs = 105,
            isTimedOut = false,
            basePoints = 100
        )
        assertEquals(50, score.finalPoints) // 100 - 50
        assertEquals(50, score.penaltyDeduction)
        assertEquals(TimeThresholdZone.THRESHOLD_2_PENALTY, score.zone)
    }

    @Test
    fun testTimeoutAwardsZeroPoints() {
        val score = TimeThresholdZone.calculateScore(
            isCorrect = true,
            elapsedSecs = 120,
            isTimedOut = true,
            basePoints = 100
        )
        assertEquals(0, score.finalPoints)
        assertEquals(TimeThresholdZone.TIMEOUT, score.zone)
    }

    @Test
    fun testIncorrectAnswerAwardsZeroPoints() {
        val score = TimeThresholdZone.calculateScore(
            isCorrect = false,
            elapsedSecs = 25,
            isTimedOut = false,
            basePoints = 100
        )
        assertEquals(0, score.finalPoints)
        assertFalse(score.isCorrect)
    }

    @Test
    fun testQuestionTimeStatRecording() {
        val stat = QuestionTimeStat(
            questionIndex = 0,
            questionId = "q1",
            questionText = "What is 2 + 2?",
            timeTakenSeconds = 45,
            totalTimeLimitSeconds = 120,
            basePoints = 100,
            speedBonus = 0,
            penaltyDeduction = 0,
            finalPoints = 100,
            isCorrect = true,
            isTimedOut = false,
            zone = TimeThresholdZone.STANDARD
        )
        assertEquals(45, stat.timeTakenSeconds)
        assertEquals(100, stat.finalPoints)
        assertTrue(stat.isCorrect)
        assertEquals(TimeThresholdZone.STANDARD, stat.zone)
    }
}

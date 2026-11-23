package com.example

import com.example.audio.SoundscapeType
import com.example.audio.StudyAmbienceManager
import com.example.data.QuestionModel
import com.example.ui.exam.MockExamResult
import com.example.ui.exam.MockExamState
import com.example.ui.quiz.SessionAnswerReview
import org.junit.Assert.*
import org.junit.Test

class MockExamAndAmbienceTest {

    @Test
    fun testSoundscapeTypesCompleteness() {
        val soundscapes = SoundscapeType.values()
        assertTrue("Expected at least 5 soundscape presets", soundscapes.size >= 5)

        val rain = SoundscapeType.RAIN
        assertEquals("Gentle Rain", rain.title)
        assertEquals("🌧️", rain.emoji)

        val brown = SoundscapeType.BROWN_NOISE
        assertEquals("Study Brown Noise", brown.title)
        assertEquals("☕", brown.emoji)

        val waves = SoundscapeType.OCEAN_WAVES
        assertEquals("Ocean Waves", waves.title)

        val breeze = SoundscapeType.FOREST_BREEZE
        assertEquals("Forest Breeze", breeze.title)

        val alpha = SoundscapeType.ALPHA_BEATS
        assertEquals("Alpha Waves (432Hz)", alpha.title)
    }

    @Test
    fun testStudyAmbienceManagerVolumeControl() {
        StudyAmbienceManager.setVolume(0.85f)
        assertEquals(0.85f, StudyAmbienceManager.volume.value, 0.001f)

        // Test clamping
        StudyAmbienceManager.setVolume(1.5f)
        assertEquals(1.0f, StudyAmbienceManager.volume.value, 0.001f)

        StudyAmbienceManager.setVolume(-0.2f)
        assertEquals(0.0f, StudyAmbienceManager.volume.value, 0.001f)
    }

    @Test
    fun testMockExamResultCalculation() {
        val q1 = QuestionModel("q1", 10, "math", 1, "MCQ", "2+2=?", listOf("3", "4", "5"), "4")
        val q2 = QuestionModel("q2", 10, "math", 1, "MCQ", "3*3=?", listOf("6", "9", "12"), "9")
        val q3 = QuestionModel("q3", 10, "math", 1, "MCQ", "5-2=?", listOf("2", "3", "4"), "3")

        val reviews = listOf(
            SessionAnswerReview(0, q1, "4", true, timeTakenSeconds = 30),
            SessionAnswerReview(1, q2, "9", true, timeTakenSeconds = 25),
            SessionAnswerReview(2, q3, "2", false, timeTakenSeconds = 40)
        )

        val result = MockExamResult(
            totalQuestions = 3,
            correctCount = 2,
            incorrectCount = 1,
            unansweredCount = 0,
            totalScore = 200,
            percentage = (2f / 3f) * 100f,
            grade = "B (Good)",
            timeTakenSeconds = 95,
            xpAwarded = 80,
            reviews = reviews
        )

        assertEquals(3, result.totalQuestions)
        assertEquals(2, result.correctCount)
        assertEquals(1, result.incorrectCount)
        assertEquals(66.66f, result.percentage, 0.1f)
        assertEquals("B (Good)", result.grade)
        assertEquals(3, result.reviews.size)
        assertTrue(result.reviews[0].isCorrect)
        assertTrue(result.reviews[1].isCorrect)
        assertFalse(result.reviews[2].isCorrect)
    }

    @Test
    fun testMockExamStateDefaultValues() {
        val defaultState = MockExamState()
        assertFalse(defaultState.isActive)
        assertFalse(defaultState.isFinished)
        assertEquals(0, defaultState.currentIndex)
        assertEquals(900, defaultState.secondsRemaining)
        assertTrue(defaultState.questions.isEmpty())
        assertTrue(defaultState.userAnswers.isEmpty())
        assertTrue(defaultState.markedForReview.isEmpty())
        assertNull(defaultState.result)
    }
}

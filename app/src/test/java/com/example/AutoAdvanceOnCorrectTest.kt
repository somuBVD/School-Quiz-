package com.example

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLooper

@OptIn(DelicateCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class AutoAdvanceOnCorrectTest {

    private lateinit var application: Application
    private lateinit var database: QuizDatabase
    private lateinit var repository: QuizRepository
    private lateinit var viewModel: QuizViewModel

    @Before
    fun setup() {
        application = ApplicationProvider.getApplicationContext()
        database = QuizDatabase.getDatabase(application, GlobalScope)
        repository = QuizRepository(
            quizDao = database.quizDao(),
            quizQuestionDao = database.quizQuestionDao(),
            studentProgressDao = database.studentProgressDao(),
            historicalScoreDao = database.historicalScoreDao(),
            studentPointDao = database.studentPointDao()
        )
        viewModel = QuizViewModel(application, repository)
    }

    private fun waitForQuizToStart() {
        val start = System.currentTimeMillis()
        while (!viewModel.activeQuizState.value.isPlaying && System.currentTimeMillis() - start < 3000) {
            ShadowLooper.idleMainLooper()
            Thread.sleep(50)
        }
    }

    @Test
    fun testClickingCorrectAnswerImmediatelySubmitsAndAutoAdvancesToNextQuestion() = runBlocking {
        // Start quiz for Standard 6, Math, Unit 1
        viewModel.startQuiz(stdId = 6, subjectId = "math", unitId = 1, unitName = "Numbers (Place Value)")
        waitForQuizToStart()

        val initialState = viewModel.activeQuizState.value
        assertTrue("Quiz should be playing", initialState.isPlaying)
        assertTrue("Questions should be loaded", initialState.questions.isNotEmpty())
        assertEquals(0, initialState.currentIndex)
        assertFalse(initialState.isAnswerSubmitted)

        val firstQuestion = initialState.questions[0]
        val correctAnswer = firstQuestion.correctAnswer

        // Student clicks the correct answer
        viewModel.selectQuizAnswer(correctAnswer)

        // Verify answer is immediately evaluated as submitted and correct before the delay passes
        val submittedState = viewModel.activeQuizState.value
        assertTrue("Answer should be marked submitted immediately on click", submittedState.isAnswerSubmitted)
        assertEquals(correctAnswer, submittedState.selectedAnswer)
        assertEquals(1, submittedState.correctCount)
        assertEquals("Still on question 0 during brief visual feedback", 0, submittedState.currentIndex)

        // Run delayed tasks (the 650ms auto-advance delay)
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks()

        // Verify question automatically moved to next question (currentIndex = 1) without clicking next button
        val nextQuestionState = viewModel.activeQuizState.value
        assertEquals("Should automatically move to index 1 after correct answer", 1, nextQuestionState.currentIndex)
        assertFalse("Next question should not be submitted yet", nextQuestionState.isAnswerSubmitted)
        assertEquals("", nextQuestionState.selectedAnswer)
    }

    @Test
    fun testClickingIncorrectAnswerShowsExplanationWithoutAutoAdvancing() = runBlocking {
        viewModel.startQuiz(stdId = 6, subjectId = "math", unitId = 1, unitName = "Numbers (Place Value)")
        waitForQuizToStart()

        val initialState = viewModel.activeQuizState.value
        assertTrue("Questions should be loaded", initialState.questions.isNotEmpty())

        val firstQuestion = initialState.questions[0]
        val wrongAnswer = firstQuestion.options.first { !it.trim().equals(firstQuestion.correctAnswer.trim(), ignoreCase = true) }

        // Student clicks an incorrect answer
        viewModel.selectQuizAnswer(wrongAnswer)

        val submittedState = viewModel.activeQuizState.value
        assertTrue("Incorrect answer should be submitted for feedback", submittedState.isAnswerSubmitted)
        assertEquals(wrongAnswer, submittedState.selectedAnswer)
        assertEquals(0, submittedState.correctCount)

        // Run any delayed tasks - should NOT advance automatically because answer was incorrect
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks()

        val afterWaitState = viewModel.activeQuizState.value
        assertEquals("Should remain on question 0 for explanation review", 0, afterWaitState.currentIndex)
        assertTrue(afterWaitState.isAnswerSubmitted)

        // Student can manually click Next Question after reviewing mistake
        viewModel.goToNextQuestion()
        ShadowLooper.idleMainLooper()

        val afterManualNext = viewModel.activeQuizState.value
        assertEquals("Moves to next question after manual click", 1, afterManualNext.currentIndex)
        assertFalse(afterManualNext.isAnswerSubmitted)
    }

    @Test
    fun testSubmitCorrectAnswerTriggersAutoAdvance() = runBlocking {
        viewModel.startQuiz(stdId = 6, subjectId = "math", unitId = 1, unitName = "Numbers (Place Value)")
        waitForQuizToStart()

        val firstQ = viewModel.activeQuizState.value.questions[0]
        viewModel.submitQuizAnswer(forcedAnswer = firstQ.correctAnswer)

        val stateAfterSubmit = viewModel.activeQuizState.value
        assertTrue(stateAfterSubmit.isAnswerSubmitted)
        assertEquals(1, stateAfterSubmit.correctCount)
        assertEquals(0, stateAfterSubmit.currentIndex)

        // Advance delayed tasks
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks()

        val stateAfterAutoAdvance = viewModel.activeQuizState.value
        assertEquals("Advanced to next question automatically", 1, stateAfterAutoAdvance.currentIndex)
    }
}

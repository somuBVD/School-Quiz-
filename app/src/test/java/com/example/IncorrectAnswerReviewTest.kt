package com.example

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import com.example.ui.quiz.*
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
class IncorrectAnswerReviewTest {

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
    fun testConceptExtractionForCurriculumSubjects() {
        val mathFractionQ = QuestionModel(
            id = "m1",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "What is 3/4 + 1/2 as a single fraction?",
            options = listOf("5/4", "4/6", "1", "2"),
            correctAnswer = "5/4",
            explanation = "Find common denominator 4: 3/4 + 2/4 = 5/4."
        )
        val mathConcept = getLinkedConcept(mathFractionQ)
        assertTrue("Should link to fraction concept", mathConcept.contains("Fractions") || mathConcept.contains("Number Operations"))

        val scienceQ = QuestionModel(
            id = "s1",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "Which pigment inside plant leaves absorbs sunlight for photosynthesis?",
            options = listOf("Chlorophyll", "Hemoglobin", "Melanin", "Carotene"),
            correctAnswer = "Chlorophyll",
            explanation = "Chlorophyll absorbs red and blue light to synthesize glucose."
        )
        val scienceConcept = getLinkedConcept(scienceQ)
        assertTrue("Should link to botany / photosynthesis concept", scienceConcept.contains("Photosynthesis") || scienceConcept.contains("Botany"))

        val englishQ = QuestionModel(
            id = "e1",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Identify the adjective in the sentence: 'The swift runner won first place.'",
            options = listOf("swift", "runner", "won", "place"),
            correctAnswer = "swift",
            explanation = "Swift describes the noun runner, making it an adjective."
        )
        val englishConcept = getLinkedConcept(englishQ)
        assertTrue("Should link to parts of speech", englishConcept.contains("Parts of Speech") || englishConcept.contains("Grammar"))
    }

    @Test
    fun testEnrichedExplanationFallback() {
        val briefQ = QuestionModel(
            id = "tf1",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "TF",
            questionText = "Light travels in a straight line.",
            options = listOf("True", "False"),
            correctAnswer = "True",
            explanation = ""
        )
        val explanation = getEnrichedExplanation(briefQ)
        assertTrue("Explanation should not be empty", explanation.isNotBlank())
        assertTrue("Should contain answer value", explanation.contains("True"))

        val detailedQ = QuestionModel(
            id = "m2",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the area of a rectangle with length 5 and width 3?",
            options = listOf("15", "16", "8", "10"),
            correctAnswer = "15",
            explanation = "Area of rectangle = length x width = 5 x 3 = 15 square units."
        )
        val expl2 = getEnrichedExplanation(detailedQ)
        assertEquals("Detailed explanation should be preserved", detailedQ.explanation, expl2)
    }

    @Test
    fun testSessionAnswerReviewListRecordsIncorrectAndCorrectAnswers() = runBlocking {
        viewModel.startQuiz(stdId = 6, subjectId = "math", unitId = 1, unitName = "Numbers")
        waitForQuizToStart()

        val state1 = viewModel.activeQuizState.value
        val firstQ = state1.questions.first()

        // Submit a WRONG answer
        val wrongAns = if (firstQ.correctAnswer == "A") "B" else "A"
        viewModel.submitQuizAnswer(forcedAnswer = wrongAns)
        ShadowLooper.idleMainLooper()

        val stateAfterWrong = viewModel.activeQuizState.value
        assertEquals("Should have 1 review record", 1, stateAfterWrong.sessionAnswerReviews.size)
        val firstReview = stateAfterWrong.sessionAnswerReviews.first()
        assertEquals(firstQ.id, firstReview.question.id)
        assertEquals(wrongAns, firstReview.studentAnswer)
        assertFalse("Review must be marked incorrect", firstReview.isCorrect)

        assertEquals("Incorrect review items count should be 1", 1, stateAfterWrong.incorrectReviewItems.size)
        assertEquals("Correct review items count should be 0", 0, stateAfterWrong.correctReviewItems.size)

        // Advance to next question
        viewModel.goToNextQuestion()
        ShadowLooper.idleMainLooper()

        val state2 = viewModel.activeQuizState.value
        val secondQ = state2.questions[state2.currentIndex]

        // Submit CORRECT answer
        viewModel.submitQuizAnswer(forcedAnswer = secondQ.correctAnswer)
        ShadowLooper.idleMainLooper()

        val stateAfterCorrect = viewModel.activeQuizState.value
        assertEquals("Should have 2 review records", 2, stateAfterCorrect.sessionAnswerReviews.size)
        assertEquals("Incorrect items count should remain 1", 1, stateAfterCorrect.incorrectReviewItems.size)
        assertEquals("Correct items count should now be 1", 1, stateAfterCorrect.correctReviewItems.size)
    }

    @Test
    fun testRetrySessionMistakesLaunchesQuizWithOnlyIncorrectQuestions() = runBlocking {
        viewModel.startQuiz(stdId = 6, subjectId = "math", unitId = 1, unitName = "Numbers")
        waitForQuizToStart()

        val state = viewModel.activeQuizState.value
        val q1 = state.questions[0]
        val wrongAns = if (q1.correctAnswer == "Choice 1") "Choice 2" else "Wrong Choice"
        viewModel.submitQuizAnswer(forcedAnswer = wrongAns)
        ShadowLooper.idleMainLooper()

        assertEquals(1, viewModel.activeQuizState.value.incorrectReviewItems.size)

        // Retry mistakes
        viewModel.retrySessionMistakes()
        ShadowLooper.idleMainLooper()

        val retryState = viewModel.activeQuizState.value
        assertTrue("Retry quiz should be playing", retryState.isPlaying)
        assertEquals("Should have exactly 1 question to retry", 1, retryState.questions.size)
        assertEquals(q1.id, retryState.questions.first().id)
        assertEquals(0, retryState.sessionAnswerReviews.size)
    }
}

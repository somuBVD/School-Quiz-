package com.example

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLooper

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class AdminRoomCrudTest {

    private lateinit var context: Context
    private lateinit var db: QuizDatabase
    private lateinit var repository: QuizRepository
    private lateinit var viewModel: QuizViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        context = ApplicationProvider.getApplicationContext<Application>()
        db = Room.inMemoryDatabaseBuilder(context, QuizDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        repository = QuizRepository(
            quizDao = db.quizDao(),
            quizQuestionDao = db.quizQuestionDao(),
            studentProgressDao = db.studentProgressDao(),
            historicalScoreDao = db.historicalScoreDao()
        )

        viewModel = QuizViewModel(context as Application, repository)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun testCreateAndReadQuizQuestionInRoom() = runBlocking {
        val testQuestion = QuizQuestionEntity(
            id = "admin_q_test_1",
            stdId = 8,
            subjectId = "science",
            unitId = 3,
            unitName = "Force and Pressure",
            type = "MCQ",
            questionText = "What is the SI unit of force?",
            optionsString = "Joule|Pascal|Newton|Watt",
            correctAnswer = "Newton",
            explanation = "Newton (N) is the SI unit of force named after Sir Isaac Newton.",
            difficulty = "Easy",
            hint = "Named after a famous British physicist",
            points = 10,
            isCustom = true
        )

        // 1. CREATE
        viewModel.insertRoomQuestion(testQuestion)
        ShadowLooper.idleMainLooper()

        // 2. READ
        val questions = viewModel.allRoomQuestions.first { list ->
            list.any { it.id == "admin_q_test_1" }
        }

        val found = questions.find { it.id == "admin_q_test_1" }
        assertNotNull(found)
        assertEquals("What is the SI unit of force?", found?.questionText)
        assertEquals("Newton", found?.correctAnswer)
        assertEquals(8, found?.stdId)
        assertEquals("science", found?.subjectId)
        assertEquals(3, found?.unitId)
        assertEquals("Easy", found?.difficulty)
        assertEquals(10, found?.points)
    }

    @Test
    fun testUpdateQuizQuestionInRoom() = runBlocking {
        val initialQuestion = QuizQuestionEntity(
            id = "admin_q_test_2",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            unitName = "Numbers",
            type = "MCQ",
            questionText = "What is 10 + 10?",
            optionsString = "10|15|20|25",
            correctAnswer = "20",
            explanation = "Simple addition",
            difficulty = "Easy",
            points = 5,
            isCustom = true
        )

        viewModel.insertRoomQuestion(initialQuestion)
        ShadowLooper.idleMainLooper()

        // 3. UPDATE
        val updatedQuestion = initialQuestion.copy(
            questionText = "What is 10 + 15?",
            optionsString = "20|25|30|35",
            correctAnswer = "25",
            explanation = "Updated addition equation",
            difficulty = "Medium",
            points = 15
        )

        viewModel.updateRoomQuestion(updatedQuestion)
        ShadowLooper.idleMainLooper()

        val questions = viewModel.allRoomQuestions.first { list ->
            list.any { it.id == "admin_q_test_2" && it.correctAnswer == "25" }
        }

        val found = questions.find { it.id == "admin_q_test_2" }
        assertNotNull(found)
        assertEquals("What is 10 + 15?", found?.questionText)
        assertEquals("25", found?.correctAnswer)
        assertEquals("Medium", found?.difficulty)
        assertEquals(15, found?.points)
    }

    @Test
    fun testDeleteQuizQuestionInRoom() = runBlocking {
        val questionToDelete = QuizQuestionEntity(
            id = "admin_q_test_3",
            stdId = 7,
            subjectId = "social",
            unitId = 2,
            unitName = "History",
            type = "TF",
            questionText = "The Ashoka Pillar is in Sarnath.",
            optionsString = "True|False",
            correctAnswer = "True",
            explanation = "The Lion Capital of Ashoka was erected at Sarnath.",
            difficulty = "Medium",
            points = 10,
            isCustom = true
        )

        viewModel.insertRoomQuestion(questionToDelete)
        ShadowLooper.idleMainLooper()

        // Confirm it was inserted
        val insertedList = viewModel.allRoomQuestions.first { list ->
            list.any { it.id == "admin_q_test_3" }
        }
        assertTrue(insertedList.any { it.id == "admin_q_test_3" })

        // 4. DELETE
        viewModel.deleteRoomQuestion("admin_q_test_3")
        ShadowLooper.idleMainLooper()

        val afterDeleteList = viewModel.allRoomQuestions.first { list ->
            list.none { it.id == "admin_q_test_3" }
        }
        assertFalse(afterDeleteList.any { it.id == "admin_q_test_3" })
    }
}

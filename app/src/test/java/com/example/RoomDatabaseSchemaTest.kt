package com.example

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class RoomDatabaseSchemaTest {

    private lateinit var db: QuizDatabase
    private lateinit var questionDao: QuizQuestionDao
    private lateinit var progressDao: StudentProgressDao
    private lateinit var scoreDao: HistoricalScoreDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, QuizDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        questionDao = db.quizQuestionDao()
        progressDao = db.studentProgressDao()
        scoreDao = db.historicalScoreDao()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun testQuizQuestionDaoInsertAndRetrieve() = runBlocking {
        val question = QuizQuestionEntity(
            id = "test_q_1",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            unitName = "Place Value",
            type = "MCQ",
            questionText = "What is the value of 5 in 500?",
            optionsString = "5|50|500|5000",
            correctAnswer = "500",
            explanation = "5 is in hundreds position",
            difficulty = "Easy"
        )

        questionDao.insertQuestion(question)

        val retrieved = questionDao.getQuestionById("test_q_1")
        assertNotNull(retrieved)
        assertEquals("What is the value of 5 in 500?", retrieved?.questionText)
        assertEquals("500", retrieved?.correctAnswer)

        val unitQuestions = questionDao.getQuestionsForUnitDirect(6, "math", 1)
        assertEquals(1, unitQuestions.size)
        assertEquals("test_q_1", unitQuestions[0].id)

        // Convert to UI QuestionModel
        val model = retrieved!!.toQuestionModel()
        assertEquals(4, model.options.size)
        assertEquals("500", model.options[2])
    }

    @Test
    fun testStudentProgressDaoUpdateAndQuery() = runBlocking {
        val initialProgress = UnitProgress(
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            progress = 25,
            completedQuestions = 2,
            totalQuestions = 8,
            difficulty = "Medium"
        )

        progressDao.insertUnitProgress(initialProgress)

        var loaded = progressDao.getUnitProgressDirect(6, "science", 2)
        assertNotNull(loaded)
        assertEquals(25, loaded?.progress)
        assertEquals(2, loaded?.completedQuestions)

        // Update progress
        progressDao.updateProgressValues(6, "science", 2, progress = 100, completed = 8)

        loaded = progressDao.getUnitProgressDirect(6, "science", 2)
        assertEquals(100, loaded?.progress)
        assertEquals(8, loaded?.completedQuestions)

        val completedCount = progressDao.getCompletedUnitsCount(6).first()
        assertEquals(1, completedCount)
    }

    @Test
    fun testHistoricalScoreDaoInsertAndStatistics() = runBlocking {
        val score1 = HistoricalScoreEntity(
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            unitName = "Numbers",
            score = 8,
            totalQuestions = 10,
            accuracyPercentage = 80,
            earnedCoins = 40,
            earnedXP = 120,
            earnedStars = 16,
            timeTakenSeconds = 45,
            isPassed = true,
            completedAt = 1000L
        )

        val score2 = HistoricalScoreEntity(
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            unitName = "Numbers",
            score = 10,
            totalQuestions = 10,
            accuracyPercentage = 100,
            earnedCoins = 100,
            earnedXP = 200,
            earnedStars = 20,
            timeTakenSeconds = 35,
            isPassed = true,
            completedAt = 2000L
        )

        scoreDao.insertHistoricalScore(score1)
        scoreDao.insertHistoricalScore(score2)

        val allScores = scoreDao.getAllHistoricalScores().first()
        assertEquals(2, allScores.size)
        // Ordered by completedAt DESC, so score2 should be first
        assertEquals(2000L, allScores[0].completedAt)
        assertEquals(10, allScores[0].score)

        val highScore = scoreDao.getHighScoreForUnit(6, "math", 1)
        assertEquals(10, highScore)

        val totalQuizzes = scoreDao.getTotalQuizzesTaken().first()
        assertEquals(2, totalQuizzes)
    }
}

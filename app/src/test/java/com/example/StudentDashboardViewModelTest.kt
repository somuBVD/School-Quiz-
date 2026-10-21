package com.example

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import com.example.ui.dashboard.DashboardTimeRange
import com.example.ui.dashboard.StudentDashboardViewModel
import kotlinx.coroutines.Dispatchers
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

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class StudentDashboardViewModelTest {

    private lateinit var db: QuizDatabase
    private lateinit var repository: QuizRepository
    private lateinit var viewModel: StudentDashboardViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, QuizDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        repository = QuizRepository(
            quizDao = db.quizDao(),
            quizQuestionDao = db.quizQuestionDao(),
            studentProgressDao = db.studentProgressDao(),
            historicalScoreDao = db.historicalScoreDao()
        )

        viewModel = StudentDashboardViewModel(repository)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun testDashboardInitialStateWithNoScores() = runBlocking {
        ShadowLooper.idleMainLooper()
        val state = viewModel.uiState.first { !it.isLoading }
        assertEquals(0, state.totalQuizzesAttempted)
        assertEquals(0f, state.overallAverageAccuracy, 0.01f)
        assertEquals(0f, state.passRatePercentage, 0.01f)
        assertTrue(state.subjectStats.isEmpty())
        assertNull(state.strongestSubject)
    }

    @Test
    fun testDashboardCalculatesStatisticsFromRoomScores() = runBlocking {
        // Insert historical quiz attempts
        val attempt1 = HistoricalScoreEntity(
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
            timeTakenSeconds = 60,
            isPassed = true,
            completedAt = System.currentTimeMillis() - 1000
        )

        val attempt2 = HistoricalScoreEntity(
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            unitName = "Living Things",
            score = 5,
            totalQuestions = 10,
            accuracyPercentage = 50,
            earnedCoins = 25,
            earnedXP = 75,
            earnedStars = 10,
            timeTakenSeconds = 90,
            isPassed = true,
            completedAt = System.currentTimeMillis() - 2000
        )

        val attempt3 = HistoricalScoreEntity(
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            unitName = "Plant Parts",
            score = 3,
            totalQuestions = 10,
            accuracyPercentage = 30,
            earnedCoins = 15,
            earnedXP = 45,
            earnedStars = 6,
            timeTakenSeconds = 120,
            isPassed = false,
            completedAt = System.currentTimeMillis() - 3000
        )

        repository.recordHistoricalScore(attempt1)
        repository.recordHistoricalScore(attempt2)
        repository.recordHistoricalScore(attempt3)
        ShadowLooper.idleMainLooper()

        val state = viewModel.uiState.first { it.totalQuizzesAttempted == 3 }

        // General KPI statistics
        assertEquals(3, state.totalQuizzesAttempted)
        assertEquals(2, state.passedQuizzesCount)
        assertEquals(66.66f, state.passRatePercentage, 0.1f)
        assertEquals(53.33f, state.overallAverageAccuracy, 0.1f)
        assertEquals(30, state.totalQuestionsAnswered)
        assertEquals(16, state.totalCorrectAnswers) // 8 + 5 + 3
        assertEquals(240, state.totalXpEarned) // 120 + 75 + 45
        assertEquals(80, state.totalCoinsEarned) // 40 + 25 + 15
        assertEquals(32, state.totalStarsEarned) // 16 + 10 + 6
        assertEquals(270, state.totalTimeSpentSeconds) // 60 + 90 + 120

        // Subject Breakdown
        assertEquals(2, state.subjectStats.size)
        val mathStat = state.subjectStats.first { it.subjectId == "math" }
        assertEquals(1, mathStat.totalAttempts)
        assertEquals(80f, mathStat.averageAccuracy, 0.01f)
        assertEquals(8, mathStat.highScore)
        assertEquals(1, mathStat.passedCount)

        val scienceStat = state.subjectStats.first { it.subjectId == "science" }
        assertEquals(2, scienceStat.totalAttempts)
        assertEquals(40f, scienceStat.averageAccuracy, 0.01f) // (50 + 30) / 2
        assertEquals(5, scienceStat.highScore)
        assertEquals(1, scienceStat.passedCount)

        // Strengths & Focus
        assertNotNull(state.strongestSubject)
        assertEquals("math", state.strongestSubject?.subjectId)
        assertNotNull(state.subjectNeedingFocus)
        assertEquals("science", state.subjectNeedingFocus?.subjectId)
    }

    @Test
    fun testDashboardStandardFilter() = runBlocking {
        val std6Attempt = HistoricalScoreEntity(
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            unitName = "Std 6 Math",
            score = 10,
            totalQuestions = 10,
            accuracyPercentage = 100,
            earnedCoins = 50,
            earnedXP = 150,
            earnedStars = 20,
            isPassed = true
        )
        val std7Attempt = HistoricalScoreEntity(
            stdId = 7,
            subjectId = "math",
            unitId = 1,
            unitName = "Std 7 Math",
            score = 5,
            totalQuestions = 10,
            accuracyPercentage = 50,
            earnedCoins = 25,
            earnedXP = 75,
            earnedStars = 10,
            isPassed = true
        )

        repository.recordHistoricalScore(std6Attempt)
        repository.recordHistoricalScore(std7Attempt)
        ShadowLooper.idleMainLooper()

        // Filter by Standard 6
        viewModel.setStandardFilter(6)
        ShadowLooper.idleMainLooper()
        val stateStd6 = viewModel.uiState.first { it.selectedStandardFilter == 6 && it.totalQuizzesAttempted == 1 }
        assertEquals(1, stateStd6.totalQuizzesAttempted)
        assertEquals(100f, stateStd6.overallAverageAccuracy, 0.01f)
        assertEquals(1, stateStd6.perfectScoresCount)

        // Reset filter
        viewModel.setStandardFilter(null)
        ShadowLooper.idleMainLooper()
        val stateAll = viewModel.uiState.first { it.selectedStandardFilter == null && it.totalQuizzesAttempted == 2 }
        assertEquals(2, stateAll.totalQuizzesAttempted)
        assertEquals(75f, stateAll.overallAverageAccuracy, 0.01f)
    }

    @Test
    fun testDashboardTimeRangeFilter() = runBlocking {
        val now = System.currentTimeMillis()
        val recentAttempt = HistoricalScoreEntity(
            stdId = 6,
            subjectId = "english",
            unitId = 1,
            unitName = "Recent",
            score = 9,
            totalQuestions = 10,
            accuracyPercentage = 90,
            earnedCoins = 45,
            earnedXP = 135,
            earnedStars = 18,
            isPassed = true,
            completedAt = now - (2L * 24 * 60 * 60 * 1000) // 2 days ago
        )
        val oldAttempt = HistoricalScoreEntity(
            stdId = 6,
            subjectId = "english",
            unitId = 1,
            unitName = "Old",
            score = 4,
            totalQuestions = 10,
            accuracyPercentage = 40,
            earnedCoins = 20,
            earnedXP = 60,
            earnedStars = 8,
            isPassed = false,
            completedAt = now - (15L * 24 * 60 * 60 * 1000) // 15 days ago
        )

        repository.recordHistoricalScore(recentAttempt)
        repository.recordHistoricalScore(oldAttempt)
        ShadowLooper.idleMainLooper()

        viewModel.setTimeRangeFilter(DashboardTimeRange.PAST_7_DAYS)
        ShadowLooper.idleMainLooper()
        val stateWeek = viewModel.uiState.first {
            it.selectedTimeRange == DashboardTimeRange.PAST_7_DAYS && it.totalQuizzesAttempted == 1
        }
        assertEquals(1, stateWeek.totalQuizzesAttempted)
        assertEquals(90f, stateWeek.overallAverageAccuracy, 0.01f)

        viewModel.setTimeRangeFilter(DashboardTimeRange.ALL_TIME)
        ShadowLooper.idleMainLooper()
        val stateAll = viewModel.uiState.first {
            it.selectedTimeRange == DashboardTimeRange.ALL_TIME && it.totalQuizzesAttempted == 2
        }
        assertEquals(2, stateAll.totalQuizzesAttempted)
    }
}

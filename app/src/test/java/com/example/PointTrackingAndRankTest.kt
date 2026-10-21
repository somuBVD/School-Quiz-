package com.example

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import com.example.ui.dashboard.StudentDashboardViewModel
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
class PointTrackingAndRankTest {

    private lateinit var context: Context
    private lateinit var db: QuizDatabase
    private lateinit var repository: QuizRepository
    private lateinit var dashboardViewModel: StudentDashboardViewModel
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
            historicalScoreDao = db.historicalScoreDao(),
            studentPointDao = db.studentPointDao()
        )

        dashboardViewModel = StudentDashboardViewModel(repository)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun testQuizRankTierCalculations() {
        val novice = QuizRankTier.calculateRank(100)
        assertEquals(QuizRankTier.NOVICE, novice.tier)
        assertEquals("Novice Explorer", novice.rankTitle)
        assertEquals("Bronze Scholar", novice.nextRankTitle)
        assertEquals(400, novice.pointsToNextRank)

        val bronze = QuizRankTier.calculateRank(750)
        assertEquals(QuizRankTier.BRONZE, bronze.tier)
        assertEquals("Bronze Scholar", bronze.rankTitle)

        val silver = QuizRankTier.calculateRank(1500)
        assertEquals(QuizRankTier.SILVER, silver.tier)
        assertEquals("Silver Achiever", silver.rankTitle)

        val gold = QuizRankTier.calculateRank(2500)
        assertEquals(QuizRankTier.GOLD, gold.tier)
        assertEquals("Gold Master", gold.rankTitle)

        val diamond = QuizRankTier.calculateRank(4000)
        assertEquals(QuizRankTier.DIAMOND, diamond.tier)
        assertEquals("Diamond Champion", diamond.rankTitle)

        val grandmaster = QuizRankTier.calculateRank(5500)
        assertEquals(QuizRankTier.GRANDMASTER, grandmaster.tier)
        assertEquals("Grandmaster Supreme", grandmaster.rankTitle)
        assertNull(grandmaster.nextRankTitle)
    }

    @Test
    fun testPointTrackingSystemInRoomDatabase() = runBlocking {
        // Initial profile setup
        val initialProfile = UserProfile(
            id = 1,
            name = "Test Student",
            nickname = "Scholar",
            standard = 6,
            totalPoints = 0
        )
        repository.saveUserProfile(initialProfile)
        ShadowLooper.idleMainLooper()

        // 1. Simulate quiz completion with 8 correct out of 10
        // Expected: 8 * 10 = 80 points (no perfect bonus)
        repository.handleQuizCompletion(
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            score = 8,
            total = 10
        )
        ShadowLooper.idleMainLooper()

        val profileAfterQuiz1 = repository.getUserProfileDirect()
        assertNotNull(profileAfterQuiz1)
        assertEquals(80, profileAfterQuiz1?.totalPoints)

        // Verify StudentPointEntity record was saved in Room
        val pointRecords = db.studentPointDao().getAllPointRecords().first()
        assertEquals(1, pointRecords.size)
        assertEquals(80, pointRecords[0].points)
        assertEquals("CORRECT_ANSWER", pointRecords[0].source)
        assertEquals(8, pointRecords[0].correctAnswersCount)

        // 2. Simulate perfect score (10 / 10)
        // Expected: 10 * 10 + 50 (perfect bonus) = 150 points
        repository.handleQuizCompletion(
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            score = 10,
            total = 10
        )
        ShadowLooper.idleMainLooper()

        val profileAfterQuiz2 = repository.getUserProfileDirect()
        assertNotNull(profileAfterQuiz2)
        // 80 + 150 = 230 points
        assertEquals(230, profileAfterQuiz2?.totalPoints)

        val updatedPointRecords = db.studentPointDao().getAllPointRecords().first()
        assertEquals(2, updatedPointRecords.size)
        val perfectRecord = updatedPointRecords.first { it.source == "PERFECT_SCORE_BONUS" }
        assertEquals(150, perfectRecord.points)

        // Verify total points flow from Room
        val totalPointsRoom = db.studentPointDao().getTotalPointsDirect()
        assertEquals(230, totalPointsRoom)
    }

    @Test
    fun testStudentDashboardDisplaysPointsAndQuizRank() = runBlocking {
        val highPointProfile = UserProfile(
            id = 1,
            name = "Astro Scholar",
            nickname = "Astro",
            standard = 6,
            totalPoints = 2150 // Gold Master tier (2000 - 3499)
        )
        repository.saveUserProfile(highPointProfile)
        ShadowLooper.idleMainLooper()

        val dashboardState = dashboardViewModel.uiState.first { it.studentName == "Astro Scholar" }
        assertEquals(2150, dashboardState.totalPoints)
        assertEquals(QuizRankTier.GOLD, dashboardState.quizRank.tier)
        assertEquals("Gold Master", dashboardState.quizRank.rankTitle)
        assertEquals("🥇", dashboardState.quizRank.badgeEmoji)
        assertEquals("Diamond Champion", dashboardState.quizRank.nextRankTitle)
        assertEquals(1350, dashboardState.quizRank.pointsToNextRank) // 3500 - 2150
    }
}

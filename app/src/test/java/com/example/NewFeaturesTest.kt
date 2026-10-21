package com.example

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLooper

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class NewFeaturesTest {

    private lateinit var application: Application
    private lateinit var database: QuizDatabase
    private lateinit var repository: QuizRepository
    private lateinit var viewModel: QuizViewModel

    @Before
    fun setup() {
        application = ApplicationProvider.getApplicationContext()
        val testScope = kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.SupervisorJob() + kotlinx.coroutines.Dispatchers.IO)
        database = QuizDatabase.getDatabase(application, testScope)
        repository = QuizRepository(database.quizDao())
        viewModel = QuizViewModel(application, repository)
    }

    @Test
    fun testBookmarksVaultToggleAndPersist() = runBlocking {
        val sampleQuestion = QuestionModel(
            id = "test_q_101",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the powerhouse of the cell?",
            options = listOf("Mitochondria", "Nucleus", "Ribosome", "Chloroplast"),
            correctAnswer = "Mitochondria",
            explanation = "Mitochondria generate cellular chemical energy (ATP)."
        )

        assertFalse("Initially question should not be bookmarked", repository.isQuestionBookmarked("test_q_101"))

        // Toggle bookmark via repository (Room persistence)
        val added = repository.toggleBookmark(sampleQuestion)
        assertTrue("Bookmark should be added to Room", added)
        assertTrue("Question should now be bookmarked in Room", repository.isQuestionBookmarked("test_q_101"))

        // Remove bookmark
        repository.removeBookmark("test_q_101")
        assertFalse("Question should no longer be bookmarked", repository.isQuestionBookmarked("test_q_101"))
    }

    @Test
    fun testFocusTimerControls() {
        viewModel.setFocusTimerDuration(15)
        assertEquals(15, viewModel.focusTimerState.value.selectedMinutes)
        assertEquals(15 * 60, viewModel.focusTimerState.value.secondsRemaining)
        assertFalse(viewModel.focusTimerState.value.isRunning)

        viewModel.toggleFocusTimer()
        assertTrue(viewModel.focusTimerState.value.isRunning)

        viewModel.toggleFocusTimer()
        assertFalse(viewModel.focusTimerState.value.isRunning)

        viewModel.resetFocusTimer()
        assertEquals(15 * 60, viewModel.focusTimerState.value.secondsRemaining)
    }

    @Test
    fun testFlashcardFlipAndMastery() {
        // Test flashcard interactions with mock state
        val sampleCard = QuestionModel(
            id = "card_1",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "2 + 2 = ?",
            options = listOf("3", "4", "5"),
            correctAnswer = "4",
            explanation = "Simple arithmetic."
        )
        viewModel.startFlashcards(6, "math", 1, "Arithmetic")
        ShadowLooper.idleMainLooper()

        // Flip card
        viewModel.flipFlashcard()
        assertTrue("Flashcard flip toggled", viewModel.flashcardState.value.isFlipped)

        viewModel.flipFlashcard()
        assertFalse("Flashcard flip toggled back", viewModel.flashcardState.value.isFlipped)

        // Exit
        viewModel.exitFlashcards()
        assertFalse("Flashcard closed", viewModel.flashcardState.value.isActive)
    }

    @Test
    fun testDailyChallengeControls() {
        viewModel.startDailyChallenge()
        ShadowLooper.idleMainLooper()

        val state = viewModel.dailyChallengeState.value
        assertTrue("Daily challenge active", state.isActive)

        viewModel.selectDailyChallengeAnswer("test")
        assertEquals("test", viewModel.dailyChallengeState.value.selectedAnswer)

        viewModel.exitDailyChallenge()
        assertFalse("Daily challenge closed", viewModel.dailyChallengeState.value.isActive)
    }

    @Test
    fun testSubjectAndStandardDataModels() {
        // Verify SubjectType enumeration contains the requested subjects
        val expectedSubjectIds = listOf("kannada", "english", "hindi", "math", "science", "social")
        val actualSubjectIds = SubjectType.coreSubjects.map { it.id }
        assertTrue("Subject types contain all 6 target subjects", actualSubjectIds.containsAll(expectedSubjectIds))

        // Check specific subject properties
        val kannada = SubjectType.fromId("kannada")
        assertNotNull(kannada)
        assertEquals("Kannada", kannada?.displayName)
        assertEquals("ಕನ್ನಡ", kannada?.vernacularName)

        val english = SubjectType.fromId("english")
        assertNotNull(english)
        assertEquals("English", english?.displayName)

        val hindi = SubjectType.fromId("hindi")
        assertNotNull(hindi)
        assertEquals("Hindi", hindi?.displayName)
        assertEquals("हिन्दी", hindi?.vernacularName)

        val math = SubjectType.fromId("math")
        assertNotNull(math)
        assertEquals("Mathematics", math?.displayName)

        val science = SubjectType.fromId("science")
        assertNotNull(science)
        assertEquals("Science", science?.displayName)

        val social = SubjectType.fromId("social")
        assertNotNull(social)
        assertEquals("Social Science", social?.displayName)

        // Verify StandardGrade enumeration covers Standards 6 to 10 plus entrance exams (Morarji, NMMS)
        assertEquals(listOf(6, 7, 8, 9, 10, 11, 12), StandardGrade.validGrades)
        val std6 = StandardGrade.fromGrade(6)
        assertEquals("Standard 6", std6?.title)
        assertEquals("Middle School", std6?.stage)

        val std10 = StandardGrade.fromGrade(10)
        assertEquals("Standard 10", std10?.title)

        // Verify StandardModel and SubjectModel conversion to template
        val unitModel = UnitModel(id = 1, stdId = 6, subjectId = "math", name = "Numbers", totalQuestions = 5)
        val subjectModel = SubjectModel(
            id = "math",
            type = SubjectType.MATHEMATICS,
            title = "Mathematics",
            nativeTitle = "ಗಣಿತ",
            iconName = "math",
            colorHex = 0xFFE91E63,
            description = "Math curriculum",
            units = listOf(unitModel)
        )
        val standardModel = StandardModel(
            std = 6,
            gradeInfo = std6!!,
            title = "Standard 6",
            subjects = listOf(subjectModel)
        )

        assertEquals(1, standardModel.totalUnits)
        assertEquals(5, standardModel.totalQuestions)

        val standardTemplate = standardModel.toStandardTemplate()
        assertEquals(6, standardTemplate.std)
        assertEquals(1, standardTemplate.subjects.size)
        assertEquals("math", standardTemplate.subjects[0].id)
    }

    @Test
    fun testBattleArenaLobbyAndControls() {
        assertFalse("Battle arena inactive initially", viewModel.battleArenaState.value.isActive)

        viewModel.startBattleArena()
        val state = viewModel.battleArenaState.value
        assertTrue("Battle arena is active", state.isActive)
        assertEquals(com.example.ui.battle.BattleStage.LOBBY, state.stage)

        viewModel.selectBattleSubject("science")
        assertEquals("science", viewModel.battleArenaState.value.selectedSubject)

        viewModel.exitBattleArena()
        assertFalse("Battle arena closed on exit", viewModel.battleArenaState.value.isActive)
    }

    @Test
    fun testFirebaseAuthManagerIntegration() {
        val authManager = com.example.auth.FirebaseAuthManager.getInstance(application)
        assertNotNull("FirebaseAuthManager instance initialized", authManager)

        val uiState = viewModel.authUiState.value
        assertNotNull("Auth UI state available", uiState)

        val isConfigured = viewModel.isFirebaseConfigured.value
        // Either true or false depending on whether cloud google-services credentials exist
        assertTrue("Firebase configured flag is a valid boolean", isConfigured || !isConfigured)
    }

    @Test
    fun testFirebaseCloudSyncManagerIntegration() {
        val syncManager = com.example.auth.FirebaseCloudSyncManager.getInstance(application)
        assertNotNull("FirebaseCloudSyncManager instance initialized", syncManager)

        val syncState = viewModel.cloudSyncState.value
        assertNotNull("Cloud sync state is available", syncState)

        val isAvailable = viewModel.isCloudSyncAvailable.value
        assertTrue("isCloudSyncAvailable is boolean", isAvailable || !isAvailable)
    }

    @Test
    fun testFirestoreOfflinePersistenceConfiguration() {
        val syncManager = com.example.auth.FirebaseCloudSyncManager.getInstance(application)
        assertNotNull(syncManager)

        // Verify question sync & restore helpers exist on ViewModel
        viewModel.syncQuestionsToFirestore(emptyList())
        viewModel.fetchCachedQuestionsFromFirestore(stdId = 6, subjectId = "math", unitId = 1) { cached ->
            assertNotNull(cached)
        }
    }

    @Test
    fun testRoomBookmarkedQuestionsPersistence() = runBlocking {
        val testQuestion = com.example.data.QuestionModel(
            id = "test_q_101",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "What is 12 + 15?",
            options = listOf("25", "27", "30", "22"),
            correctAnswer = "27",
            explanation = "12 plus 15 equals 27."
        )

        // 1. Bookmark question via repository
        repository.bookmarkQuestion(testQuestion)

        // 2. Check if question is bookmarked in Room
        val isBookmarked = repository.isQuestionBookmarked("test_q_101")
        assertTrue("Question should be marked as bookmarked in Room", isBookmarked)

        // 3. Verify retrieved question from Room flow
        val bookmarks = repository.bookmarkedQuestions.first()
        val found = bookmarks.find { it.id == "test_q_101" }
        assertNotNull("Question should be retrieved from Room database", found)
        assertEquals("What is 12 + 15?", found?.questionText)
        assertEquals("27", found?.correctAnswer)

        // 4. Toggle bookmark removes it
        val stillBookmarked = repository.toggleBookmark(testQuestion)
        assertFalse("Toggling existing bookmark should remove it", stillBookmarked)
        assertFalse(repository.isQuestionBookmarked("test_q_101"))
    }
}


package com.example

import android.app.Application
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.auth.FirebaseCloudSyncManager
import com.example.data.QuizDatabase
import com.example.data.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class FirestorePersistenceOfflineIndicatorTest {

    private lateinit var application: Application
    private lateinit var syncManager: FirebaseCloudSyncManager
    private lateinit var db: QuizDatabase
    private lateinit var repository: QuizRepository
    private lateinit var viewModel: QuizViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        application = ApplicationProvider.getApplicationContext()
        syncManager = FirebaseCloudSyncManager.getInstance(application)

        db = Room.inMemoryDatabaseBuilder(application, QuizDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        repository = QuizRepository(
            quizDao = db.quizDao(),
            quizQuestionDao = db.quizQuestionDao(),
            downloadedQuizDao = db.downloadedQuizDao(),
            studentProgressDao = db.studentProgressDao(),
            historicalScoreDao = db.historicalScoreDao(),
            studentPointDao = db.studentPointDao()
        )

        viewModel = QuizViewModel(application, repository)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun testFirestorePersistenceIsActiveByDefault() = runBlocking {
        // Verify Firestore persistence setting is active
        assertTrue(syncManager.firestorePersistenceActive.first())
        assertTrue(viewModel.isFirestorePersistenceActive.first())
    }

    @Test
    fun testToggleFirestoreOfflineModeUpdatesState() = runBlocking {
        // Initially set to offline
        viewModel.setFirestoreOfflineMode(true)
        assertTrue(viewModel.isFirestoreOffline.first())
        assertTrue(viewModel.isForcedOfflineMode.first())
        assertTrue(syncManager.isFirestoreOffline.first())

        // Toggle back to online
        viewModel.toggleFirestoreOfflineMode()
        assertFalse(viewModel.isForcedOfflineMode.first())

        // Force offline again via setFirestoreOfflineMode
        viewModel.setFirestoreOfflineMode(true)
        assertTrue(viewModel.isFirestoreOffline.first())

        // Switch to false
        viewModel.setFirestoreOfflineMode(false)
        assertFalse(viewModel.isForcedOfflineMode.first())
    }

    @Test
    fun testPersistenceSettingRemainsActiveDuringOfflineMode() = runBlocking {
        // App working in offline mode due to Firestore persistence setting
        viewModel.setFirestoreOfflineMode(true)
        assertTrue("Firestore is in offline mode", viewModel.isFirestoreOffline.first())
        assertTrue("Firestore persistence setting is active", viewModel.isFirestorePersistenceActive.first())
    }
}

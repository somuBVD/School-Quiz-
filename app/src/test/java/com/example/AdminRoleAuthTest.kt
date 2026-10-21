package com.example

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.auth.AuthUiState
import com.example.auth.FirebaseAuthManager
import com.example.auth.UserRole
import com.example.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class AdminRoleAuthTest {

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
    fun testStudentSignInRestrictsAdminAccess() = runBlocking {
        viewModel.signInDemoStudent()
        ShadowLooper.idleMainLooper()

        val authState = viewModel.authUiState.value
        assertTrue("User should be authenticated", authState is AuthUiState.Authenticated)

        val user = (authState as AuthUiState.Authenticated).user
        assertEquals("Role must be STUDENT", UserRole.STUDENT, user.role)
        assertFalse("Student must NOT be privileged", user.role.isPrivileged)
        assertFalse("isTeacherOrAdmin must return false for student", viewModel.isTeacherOrAdmin())
    }

    @Test
    fun testTeacherSignInGrantsPrivilegedAccess() = runBlocking {
        viewModel.signInDemoTeacher()
        ShadowLooper.idleMainLooper()

        val authState = viewModel.authUiState.value
        assertTrue("User should be authenticated", authState is AuthUiState.Authenticated)

        val user = (authState as AuthUiState.Authenticated).user
        assertEquals("Role must be TEACHER", UserRole.TEACHER, user.role)
        assertTrue("Teacher must be privileged", user.role.isPrivileged)
        assertTrue("isTeacherOrAdmin must return true for teacher", viewModel.isTeacherOrAdmin())
    }

    @Test
    fun testAdminSignInGrantsPrivilegedAccess() = runBlocking {
        viewModel.signInDemoAdmin()
        ShadowLooper.idleMainLooper()

        val authState = viewModel.authUiState.value
        assertTrue("User should be authenticated", authState is AuthUiState.Authenticated)

        val user = (authState as AuthUiState.Authenticated).user
        assertEquals("Role must be ADMIN", UserRole.ADMIN, user.role)
        assertTrue("Admin must be privileged", user.role.isPrivileged)
        assertTrue("isTeacherOrAdmin must return true for admin", viewModel.isTeacherOrAdmin())
    }

    @Test
    fun testRoleElevationFromStudentToTeacher() = runBlocking {
        viewModel.signInDemoStudent()
        ShadowLooper.idleMainLooper()
        assertFalse("Initially student is not privileged", viewModel.isTeacherOrAdmin())

        // Elevate role to TEACHER
        viewModel.updateUserRole(UserRole.TEACHER)
        ShadowLooper.idleMainLooper()

        val elevatedState = viewModel.authUiState.value as AuthUiState.Authenticated
        assertEquals("Role should be elevated to TEACHER", UserRole.TEACHER, elevatedState.user.role)
        assertTrue("Now privileged", viewModel.isTeacherOrAdmin())
    }

    @Test
    fun testRoleElevationToAdmin() = runBlocking {
        viewModel.signInDemoTeacher()
        ShadowLooper.idleMainLooper()
        assertEquals(UserRole.TEACHER, (viewModel.authUiState.value as AuthUiState.Authenticated).user.role)

        // Elevate to ADMIN
        viewModel.updateUserRole(UserRole.ADMIN)
        ShadowLooper.idleMainLooper()

        val adminState = viewModel.authUiState.value as AuthUiState.Authenticated
        assertEquals("Role should be elevated to ADMIN", UserRole.ADMIN, adminState.user.role)
        assertTrue("Admin is privileged", viewModel.isTeacherOrAdmin())
    }

    @Test
    fun testSignOutClearsPrivileges() = runBlocking {
        viewModel.signInDemoTeacher()
        ShadowLooper.idleMainLooper()
        assertTrue("Teacher is privileged", viewModel.isTeacherOrAdmin())

        viewModel.signOut()
        ShadowLooper.idleMainLooper()

        val state = viewModel.authUiState.value
        assertTrue("State is unauthenticated", state is AuthUiState.Unauthenticated)
        assertFalse("Unauthenticated is not privileged", viewModel.isTeacherOrAdmin())
    }
}

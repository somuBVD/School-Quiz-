package com.example

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.auth.AuthUiState
import com.example.auth.FirebaseAuthManager
import com.example.auth.UserRole
import com.example.auth.findActivity
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
    private lateinit var authManager: FirebaseAuthManager
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        context = ApplicationProvider.getApplicationContext<Application>()
        authManager = FirebaseAuthManager.getInstance(context)
        authManager.signOut()

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
        authManager.signOut()
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
    fun testStudentSchoolEduEmailResolvesAsStudentNotTeacher() = runBlocking {
        val result = authManager.signInWithEmail("student@school.edu", "password123")
        ShadowLooper.idleMainLooper()

        assertTrue("Student email at @school.edu must succeed", result.isSuccess)
        val user = result.getOrThrow()
        assertEquals("student@school.edu must stay STUDENT", UserRole.STUDENT, user.role)
    }

    @Test
    fun testTeacherSignupLoginDemoAndElevationAreLocked() = runBlocking {
        assertTrue("Teacher auth policy lock should be active", FirebaseAuthManager.IS_TEACHER_AUTH_LOCKED)

        // 1. Teacher demo login blocked
        val demoRes = authManager.signInDemoTeacher()
        assertTrue("Teacher demo login must fail while locked", demoRes.isFailure)
        assertFalse("Startup auth must remain incomplete after locked teacher login", authManager.isStartupAuthCompleted())

        // 2. Teacher email signup blocked
        val signUpRes = authManager.signUpWithEmail(
            email = "faculty.new@school.edu",
            pass = "password123",
            displayName = "New Faculty",
            role = UserRole.TEACHER
        )
        assertTrue("Teacher signup must fail while locked", signUpRes.isFailure)

        // 3. Teacher email login blocked
        val signInRes = authManager.signInWithEmail("teacher.sharma@school.edu", "password123")
        assertTrue("Teacher email login must fail while locked", signInRes.isFailure)

        // 4. Teacher Google Sign-In blocked
        val googleTeacherRes = authManager.signInWithGoogle(context, selectedRole = UserRole.TEACHER)
        assertTrue("Teacher Google Sign-In must fail while locked", googleTeacherRes.isFailure)

        // 5. Role elevation from Student to Teacher blocked
        viewModel.signInDemoStudent()
        ShadowLooper.idleMainLooper()
        viewModel.updateUserRole(UserRole.TEACHER)
        ShadowLooper.idleMainLooper()

        val stateAfterElevationAttempt = viewModel.authUiState.value as AuthUiState.Authenticated
        assertEquals("Student must NOT be able to elevate to TEACHER while locked", UserRole.STUDENT, stateAfterElevationAttempt.user.role)
        assertFalse("Student must remain unprivileged", viewModel.isTeacherOrAdmin())
    }

    @Test
    fun testAdminDemoAndElevationAreLocked() = runBlocking {
        assertTrue("Admin auth policy lock should be active", FirebaseAuthManager.IS_ADMIN_AUTH_LOCKED)

        val adminDemoRes = authManager.signInDemoAdmin()
        assertTrue("Admin demo login must fail while locked", adminDemoRes.isFailure)

        viewModel.signInDemoStudent()
        ShadowLooper.idleMainLooper()
        viewModel.updateUserRole(UserRole.ADMIN)
        ShadowLooper.idleMainLooper()

        val state = viewModel.authUiState.value as AuthUiState.Authenticated
        assertEquals("Student must NOT elevate to ADMIN while locked", UserRole.STUDENT, state.user.role)
        assertFalse("Student must remain unprivileged", viewModel.isTeacherOrAdmin())
    }

    @Test
    fun testGoogleSignInResourcesAndContextUnwrappingConfigured() = runBlocking {
        val webClientId = context.getString(R.string.default_web_client_id).trim()
        assertTrue("default_web_client_id must be present for Student Google Sign-In", webClientId.endsWith(".apps.googleusercontent.com"))
        assertTrue("google_app_id must be present", context.getString(R.string.google_app_id).isNotBlank())
        assertTrue("google_api_key must be present", context.getString(R.string.google_api_key).isNotBlank())
        assertTrue("project_id must be present", context.getString(R.string.project_id).isNotBlank())

        // Passing a non-Activity ContextWrapper must return a clear failure instead of crashing
        val wrappedAppContext = ContextWrapper(context)
        assertNull("Application context wrapper has no Activity", wrappedAppContext.findActivity())
        val res = authManager.signInWithGoogle(wrappedAppContext, selectedRole = UserRole.STUDENT)
        assertTrue("Non-Activity context must fail gracefully", res.isFailure)
        assertTrue("AuthUiState must expose visible error message", authManager.uiState.value is AuthUiState.Error)
    }

    @Test
    fun testSignOutClearsSession() = runBlocking {
        viewModel.signInDemoStudent()
        ShadowLooper.idleMainLooper()
        assertTrue("Student should be authenticated", viewModel.authUiState.value is AuthUiState.Authenticated)

        viewModel.signOut()
        ShadowLooper.idleMainLooper()

        val state = viewModel.authUiState.value
        assertTrue("State is unauthenticated after sign out", state is AuthUiState.Unauthenticated)
        assertFalse("Startup auth resets on sign out", authManager.isStartupAuthCompleted())
    }
}

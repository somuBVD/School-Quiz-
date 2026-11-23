package com.example.auth

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.GetCredentialException
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException
import androidx.credentials.exceptions.GetCredentialUnsupportedException
import androidx.credentials.exceptions.NoCredentialException
import com.example.R
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

/**
 * Access levels supported across the quiz application.
 */
enum class UserRole {
    STUDENT,
    TEACHER,
    ADMIN;

    val displayName: String
        get() = when (this) {
            STUDENT -> "Student"
            TEACHER -> "Teacher"
            ADMIN -> "School Administrator"
        }

    val isPrivileged: Boolean
        get() = this == TEACHER || this == ADMIN
}

data class AuthUser(
    val uid: String,
    val email: String? = null,
    val displayName: String? = null,
    val isAnonymous: Boolean = false,
    val photoUrl: String? = null,
    val role: UserRole = UserRole.STUDENT,
    val isFirebaseVerified: Boolean = false
)

sealed class AuthUiState {
    object Initial : AuthUiState()
    object Loading : AuthUiState()
    data class Authenticated(val user: AuthUser) : AuthUiState()
    data class Unauthenticated(val message: String? = null) : AuthUiState()
    data class Error(val message: String) : AuthUiState()
}

/**
 * Unwraps Compose / Dialog [ContextWrapper] chains to find the host [Activity]
 * required by Jetpack [CredentialManager.getCredential].
 */
tailrec fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext?.findActivity()
    else -> null
}

/**
 * Manages Firebase Authentication using Google Sign-In via Jetpack Credential Manager
 * (`GetSignInWithGoogleOption`) alongside local student profile management.
 *
 * Online Cloud Sync and 1 vs 1 Battle Arena require a real Google-authenticated Firebase session.
 */
class FirebaseAuthManager(private val context: Context) {

    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Initial)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    private val _isFirebaseConfigured = MutableStateFlow(false)
    val isFirebaseConfigured: StateFlow<Boolean> = _isFirebaseConfigured.asStateFlow()

    private val _isFirebaseSignedIn = MutableStateFlow(false)
    val isFirebaseSignedIn: StateFlow<Boolean> = _isFirebaseSignedIn.asStateFlow()

    private val rolePrefs = context.getSharedPreferences("firebase_user_roles", Context.MODE_PRIVATE)

    private var firebaseAuth: FirebaseAuth? = null

    @Volatile
    private var isInteractiveGoogleSignInInProgress = false

    private val _isStartupAuthCompleted = MutableStateFlow(false)
    val isStartupAuthCompletedFlow: StateFlow<Boolean> = _isStartupAuthCompleted.asStateFlow()

    init {
        initFirebase()
        _isStartupAuthCompleted.value = isStartupAuthCompleted()
    }

    private fun initFirebase() {
        try {
            val auth = NamedFirestoreProvider.getAuth(context)
            if (auth != null) {
                attachAuthInstance(auth)
            } else {
                _isFirebaseConfigured.value = false
                _isFirebaseSignedIn.value = false
                restorePreviousAuthState("Firebase not initialized")
            }
        } catch (e: Throwable) {
            Log.i(TAG, "Firebase Auth operating in local mode: ${e.message}")
            _isFirebaseConfigured.value = false
            _isFirebaseSignedIn.value = false
            restorePreviousAuthState("Local mode active")
        }
    }

    private fun attachAuthInstance(auth: FirebaseAuth) {
        if (firebaseAuth === auth) return
        firebaseAuth = auth
        _isFirebaseConfigured.value = true
        _isFirebaseSignedIn.value = auth.currentUser != null

        auth.addAuthStateListener { stateAuth ->
            val user = stateAuth.currentUser
            _isFirebaseSignedIn.value = user != null
            // During an interactive signInWithGoogle call, signInWithGoogle itself finalizes
            // role resolution, profile sync, and AuthUiState so there is no race condition.
            if (isInteractiveGoogleSignInInProgress) return@addAuthStateListener

            if (user != null) {
                val authUser = user.toAuthUser()
                persistSession(authUser)
                _isStartupAuthCompleted.value = true
                _uiState.value = AuthUiState.Authenticated(authUser)
            } else {
                val lastUid = rolePrefs.getString("active_session_uid", null)
                if (!lastUid.isNullOrBlank()) {
                    val savedRole = enforceRoleLock(getUserRole(lastUid))
                    val savedEmail = rolePrefs.getString("active_session_email", "student@school.edu")
                    val savedName = rolePrefs.getString("active_session_name", "Student User")
                    val localUser = AuthUser(
                        uid = lastUid,
                        email = savedEmail,
                        displayName = savedName,
                        isAnonymous = false,
                        photoUrl = null,
                        role = savedRole,
                        isFirebaseVerified = false
                    )
                    _uiState.value = AuthUiState.Authenticated(localUser)
                } else {
                    _uiState.value = AuthUiState.Unauthenticated()
                }
            }
        }
    }

    private fun ensureFirebaseAuth(ctx: Context): FirebaseAuth? {
        firebaseAuth?.let { return it }
        val resolved = NamedFirestoreProvider.getAuth(ctx) ?: return null
        attachAuthInstance(resolved)
        return resolved
    }

    fun isFirebaseSessionActive(): Boolean = firebaseAuth?.currentUser != null

    /**
     * Silent auto sign-in for returning students who already authorized Google Sign-In.
     * Uses a dedicated single-option [GetGoogleIdOption] request (Android API 36 safe).
     */
    suspend fun attemptSilentGoogleSignIn(
        activityContext: Context,
        standard: Int = 6
    ): Result<AuthUser> {
        val auth = ensureFirebaseAuth(activityContext)
            ?: return Result.failure(IllegalStateException("Firebase Auth unavailable."))
        val existingUser = auth.currentUser
        if (existingUser != null) {
            val authUser = existingUser.toAuthUser(resolveGoogleRole(existingUser, UserRole.STUDENT))
            persistSession(authUser)
            _isFirebaseSignedIn.value = true
            _isStartupAuthCompleted.value = true
            _uiState.value = AuthUiState.Authenticated(authUser)
            return Result.success(authUser)
        }

        val hostActivity = activityContext.findActivity()
            ?: return Result.failure(IllegalStateException("Activity context unavailable."))
        val webClientId = resolveWebClientId(activityContext)
        if (webClientId.isBlank()) {
            return Result.failure(IllegalStateException("Google Sign-In configuration missing."))
        }

        return try {
            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(true)
                .setServerClientId(webClientId)
                .setAutoSelectEnabled(true)
                .build()
            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val credentialManager = CredentialManager.create(hostActivity)
            val response = credentialManager.getCredential(context = hostActivity, request = request)
            val credential = response.credential
            if (credential is CustomCredential &&
                credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
            ) {
                completeFirebaseGoogleSignIn(auth, credential, UserRole.STUDENT, standard)
            } else {
                Result.failure(IllegalStateException("No authorized Google credential available."))
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.d(TAG, "Silent Google Sign-In skipped: ${e.message}")
            Result.failure(e)
        }
    }

    /**
     * Authenticates a Student with Google Sign-In via Jetpack Credential Manager
     * (`GetSignInWithGoogleOption`) and signs into Firebase Auth so Cloud Sync and
     * 1 vs 1 Battle Arena work reliably.
     */
    suspend fun signInWithGoogle(
        activityContext: Context,
        selectedRole: UserRole = UserRole.STUDENT,
        standard: Int = 6
    ): Result<AuthUser> {
        if (IS_TEACHER_AUTH_LOCKED && selectedRole == UserRole.TEACHER) {
            _uiState.value = AuthUiState.Error(TEACHER_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(TEACHER_LOCKED_MESSAGE))
        }
        if (IS_ADMIN_AUTH_LOCKED && selectedRole == UserRole.ADMIN) {
            _uiState.value = AuthUiState.Error(ADMIN_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(ADMIN_LOCKED_MESSAGE))
        }

        val auth = ensureFirebaseAuth(activityContext)
        if (auth == null) {
            val msg = "Firebase Auth is not initialized on this device. Please restart the app and try again."
            _uiState.value = AuthUiState.Error(msg)
            return Result.failure(IllegalStateException(msg))
        }

        val hostActivity = activityContext.findActivity()
        if (hostActivity == null) {
            val msg = "Unable to open Google Sign-In picker from this screen. Please try again from the main login screen."
            Log.e(TAG, "signInWithGoogle called with non-Activity context: ${activityContext.javaClass.name}")
            _uiState.value = AuthUiState.Error(msg)
            return Result.failure(IllegalStateException(msg))
        }

        val webClientId = resolveWebClientId(activityContext)
        if (webClientId.isBlank()) {
            val msg = "Google Sign-In configuration missing (default_web_client_id)."
            _uiState.value = AuthUiState.Error(msg)
            return Result.failure(IllegalStateException(msg))
        }

        _uiState.value = AuthUiState.Loading
        isInteractiveGoogleSignInInProgress = true
        return try {
            // Single option per GetCredentialRequest keeps the bottom sheet responsive on Android 16 (API 36).
            val signInWithGoogleOption = GetSignInWithGoogleOption.Builder(serverClientId = webClientId).build()
            val request = GetCredentialRequest.Builder()
                .addCredentialOption(signInWithGoogleOption)
                .build()

            val credentialManager = CredentialManager.create(hostActivity)
            val response = credentialManager.getCredential(
                context = hostActivity,
                request = request
            )

            val credential = response.credential
            if (credential !is CustomCredential ||
                credential.type != GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
            ) {
                val msg = "Unexpected credential returned by Google Sign-In."
                _uiState.value = AuthUiState.Error(msg)
                return Result.failure(IllegalStateException(msg))
            }

            completeFirebaseGoogleSignIn(auth, credential, selectedRole, standard)
        } catch (e: GetCredentialCancellationException) {
            Log.w("Auth", "Google Sign-In cancelled or dismissed: ${e.message}", e)
            restorePreviousAuthState("Sign-in cancelled.")
            Result.failure(e)
        } catch (e: NoCredentialException) {
            val msg = "No Google account available for sign-in. Ensure a Google account is added in device Settings and Play Services is up to date."
            Log.w("Auth", "No Google credential available: ${e.message}", e)
            _uiState.value = AuthUiState.Error(msg)
            Result.failure(e)
        } catch (e: GetCredentialProviderConfigurationException) {
            val msg = "Google Play Services Credential Provider is unavailable or outdated on this device. Please update Google Play Services."
            Log.e("Auth", "Credential provider configuration error: ${e.message}", e)
            _uiState.value = AuthUiState.Error(msg)
            Result.failure(e)
        } catch (e: GetCredentialUnsupportedException) {
            val msg = "Google Sign-In is not supported on this device configuration."
            Log.e("Auth", "CredentialManager unsupported: ${e.message}", e)
            _uiState.value = AuthUiState.Error(msg)
            Result.failure(e)
        } catch (e: GetCredentialException) {
            val detail = e.errorMessage?.toString()?.takeIf { it.isNotBlank() } ?: e.localizedMessage
            val msg = sanitizeErrorMessage(detail)
            Log.w("Auth", "CredentialManager error (${e.type}): ${e.message}", e)
            _uiState.value = AuthUiState.Error(msg)
            Result.failure(e)
        } catch (e: FirebaseAuthException) {
            val msg = sanitizeErrorMessage("${e.errorCode}: ${e.localizedMessage ?: e.message}")
            Log.e("Auth", "FirebaseAuthException during Google Sign-In (${e.errorCode}): ${e.message}", e)
            _uiState.value = AuthUiState.Error(msg)
            Result.failure(e)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            val msg = sanitizeErrorMessage(e.localizedMessage ?: e.message)
            Log.e("Auth", "Google Sign-In failed: ${e.message}", e)
            _uiState.value = AuthUiState.Error(msg)
            Result.failure(e)
        } finally {
            isInteractiveGoogleSignInInProgress = false
        }
    }

    private suspend fun completeFirebaseGoogleSignIn(
        auth: FirebaseAuth,
        credential: CustomCredential,
        requestedRole: UserRole,
        standard: Int
    ): Result<AuthUser> {
        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
        val idToken = googleIdTokenCredential.idToken
        if (idToken.isBlank()) {
            val msg = "Google Sign-In returned an empty ID token. Please try again."
            _uiState.value = AuthUiState.Error(msg)
            return Result.failure(IllegalStateException(msg))
        }

        val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
        val authResult = auth.signInWithCredential(firebaseCredential).await()
        val firebaseUser = authResult.user
            ?: throw IllegalStateException("Firebase sign-in returned no user.")

        val safeRole = resolveGoogleRole(firebaseUser, requestedRole)
        val authUser = firebaseUser.toAuthUser(safeRole)
        persistSession(authUser)
        _isFirebaseSignedIn.value = true
        _isStartupAuthCompleted.value = true
        _uiState.value = AuthUiState.Authenticated(authUser)

        syncAuthenticatedUserProfile(authUser, standard.coerceIn(1, 12))
        return Result.success(authUser)
    }

    private fun resolveWebClientId(ctx: Context): String {
        return try {
            ctx.getString(R.string.default_web_client_id).trim()
        } catch (_: Exception) {
            ""
        }
    }

    private fun resolveGoogleRole(firebaseUser: FirebaseUser, requestedRole: UserRole): UserRole {
        if (requestedRole == UserRole.ADMIN &&
            !IS_ADMIN_AUTH_LOCKED &&
            firebaseUser.email.equals(ADMIN_EMAIL, ignoreCase = true) &&
            firebaseUser.isEmailVerified
        ) {
            return UserRole.ADMIN
        }
        if (requestedRole == UserRole.TEACHER && !IS_TEACHER_AUTH_LOCKED) {
            return UserRole.TEACHER
        }
        return UserRole.STUDENT
    }

    private suspend fun syncAuthenticatedUserProfile(user: AuthUser, standard: Int) {
        val db = NamedFirestoreProvider.getDatabase(context) ?: return
        val safeStandard = standard.coerceIn(1, 12)
        val displayName = (user.displayName?.trim()?.ifBlank { null } ?: "Student").take(100)
        val safeEmail = (user.email ?: "").trim().lowercase().take(200)
        val userDocPath = "users/${user.uid}"
        try {
            val existingUserDoc = db.collection("users").document(user.uid).get().await()
            val userPayload = hashMapOf<String, Any>(
                "uid" to user.uid,
                "email" to safeEmail,
                "displayName" to displayName,
                "role" to enforceRoleLock(user.role).name,
                "standard" to safeStandard,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (!existingUserDoc.exists()) {
                userPayload["createdAt"] = FieldValue.serverTimestamp()
                userPayload["trialStartMillis"] = System.currentTimeMillis()
                userPayload["subscriptionActive"] = false
            }
            db.collection("users").document(user.uid).set(userPayload, SetOptions.merge()).await()

            val studentDocPath = "students/${user.uid}"
            try {
                val existingStudentDoc = db.collection("students").document(user.uid).get().await()
                val studentPayload = hashMapOf<String, Any>(
                    "uid" to user.uid,
                    "name" to displayName,
                    "nickname" to displayName,
                    "standard" to safeStandard,
                    "updatedAt" to FieldValue.serverTimestamp()
                )
                if (!existingStudentDoc.exists()) {
                    studentPayload["coins"] = 100
                    studentPayload["stars"] = 5
                    studentPayload["xp"] = 150
                    studentPayload["avatar"] = user.photoUrl ?: "avatar_1"
                    studentPayload["attendanceStreak"] = 1
                    studentPayload["createdAt"] = FieldValue.serverTimestamp()
                }
                db.collection("students").document(user.uid).set(studentPayload, SetOptions.merge()).await()
            } catch (e: CancellationException) {
                throw e
            } catch (t: Throwable) {
                handleFirestoreError(t, OperationType.WRITE, studentDocPath)
            }
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.WRITE, userDocPath)
        }
    }

    private fun restorePreviousAuthState(note: String?) {
        val currentFirebase = firebaseAuth?.currentUser
        if (currentFirebase != null) {
            _uiState.value = AuthUiState.Authenticated(currentFirebase.toAuthUser())
            return
        }
        val lastUid = rolePrefs.getString("active_session_uid", null)
        if (!lastUid.isNullOrBlank()) {
            val savedRole = enforceRoleLock(getUserRole(lastUid))
            _uiState.value = AuthUiState.Authenticated(
                AuthUser(
                    uid = lastUid,
                    email = rolePrefs.getString("active_session_email", null),
                    displayName = rolePrefs.getString("active_session_name", "Student"),
                    role = savedRole,
                    isFirebaseVerified = false
                )
            )
        } else {
            _uiState.value = AuthUiState.Unauthenticated(note)
        }
    }

    fun saveUserRole(uid: String, role: UserRole): Boolean {
        if (IS_TEACHER_AUTH_LOCKED && role == UserRole.TEACHER) {
            Log.i(TAG, "Blocked role switch to TEACHER while IS_TEACHER_AUTH_LOCKED is enabled.")
            return false
        }
        if (IS_ADMIN_AUTH_LOCKED && role == UserRole.ADMIN) {
            Log.i(TAG, "Blocked role switch to ADMIN while IS_ADMIN_AUTH_LOCKED is enabled.")
            return false
        }
        rolePrefs.edit().putString("role_$uid", role.name).apply()
        val current = (_uiState.value as? AuthUiState.Authenticated)?.user
        if (current != null && current.uid == uid) {
            _uiState.value = AuthUiState.Authenticated(current.copy(role = role))
        }
        return true
    }

    fun persistSession(user: AuthUser) {
        val effectiveRole = enforceRoleLock(user.role)
        rolePrefs.edit()
            .putString("active_session_uid", user.uid)
            .putString("active_session_email", user.email ?: "")
            .putString("active_session_name", user.displayName ?: "")
            .putString("role_${user.uid}", effectiveRole.name)
            .putBoolean("startup_auth_completed", true)
            .apply()
    }

    fun isStartupAuthCompleted(): Boolean {
        val uid = rolePrefs.getString("active_session_uid", null)
        val completed = rolePrefs.getBoolean("startup_auth_completed", false)
        return (completed && !uid.isNullOrBlank()) || firebaseAuth?.currentUser != null
    }

    fun getUserRole(uid: String, email: String? = null): UserRole {
        val saved = rolePrefs.getString("role_$uid", null)
        val resolved = if (saved != null) {
            try {
                UserRole.valueOf(saved)
            } catch (_: Exception) {
                inferRoleFromEmail(email)
            }
        } else {
            inferRoleFromEmail(email)
        }
        return enforceRoleLock(resolved)
    }

    private fun enforceRoleLock(role: UserRole): UserRole {
        if (IS_TEACHER_AUTH_LOCKED && role == UserRole.TEACHER) return UserRole.STUDENT
        if (IS_ADMIN_AUTH_LOCKED && role == UserRole.ADMIN) return UserRole.STUDENT
        return role
    }

    private fun isTeacherEmail(email: String?): Boolean {
        if (email.isNullOrBlank()) return false
        val lower = email.trim().lowercase()
        val localPart = lower.substringBefore("@")
        return localPart.contains("teacher") ||
            localPart.contains("staff") ||
            localPart.contains("faculty") ||
            lower.endsWith("@teacher.edu")
    }

    private fun inferRoleFromEmail(email: String?): UserRole {
        if (email.isNullOrBlank()) return UserRole.STUDENT
        val lower = email.trim().lowercase()
        return when {
            lower == ADMIN_EMAIL && !IS_ADMIN_AUTH_LOCKED -> UserRole.ADMIN
            isTeacherEmail(lower) && !IS_TEACHER_AUTH_LOCKED -> UserRole.TEACHER
            else -> UserRole.STUDENT
        }
    }

    fun sanitizeErrorMessage(raw: String?): String {
        if (raw.isNullOrBlank()) return "Google Sign-In could not be completed. Please try again."
        val lower = raw.lowercase()
        return when {
            lower.contains("network") || lower.contains("timeout") || lower.contains("unavailable") ->
                "Network unavailable. Please check your internet connection and try again."
            lower.contains("cancel") ->
                "Sign-in cancelled."
            lower.contains("10:") || lower.contains("developer_error") || lower.contains("reauth") ||
                lower.contains("28444") || lower.contains("cannot find a matching credential") ->
                "Google Sign-In needs this app's SHA-1 fingerprint registered in Firebase Console (Project Settings -> Android App)."
            lower.contains("16:") || lower.contains("disabled") || lower.contains("operation_not_allowed") ->
                "Google Sign-In provider is not enabled in Firebase Authentication Console."
            lower.contains("internal error") || lower.contains("internal_error") ->
                "Google Sign-In encountered a Play Services / Firebase configuration error. Verify internet connection and app SHA-1 in Firebase Console."
            else -> raw
        }
    }

    /**
     * Local offline profile sign-in for students practicing offline without Google Sign-In.
     * Teacher and Admin logins remain locked while [IS_TEACHER_AUTH_LOCKED] / [IS_ADMIN_AUTH_LOCKED] are true.
     */
    suspend fun signInWithEmail(email: String, pass: String, explicitRole: UserRole? = null): Result<AuthUser> {
        val trimmedEmail = email.trim()
        val trimmedPass = pass.trim()

        if (trimmedEmail.isBlank() || !trimmedEmail.contains("@")) {
            val err = "Please enter a valid email address"
            _uiState.value = AuthUiState.Error(err)
            return Result.failure(IllegalArgumentException(err))
        }
        if (trimmedPass.length < 6) {
            val err = "Password must be at least 6 characters"
            _uiState.value = AuthUiState.Error(err)
            return Result.failure(IllegalArgumentException(err))
        }

        if (IS_TEACHER_AUTH_LOCKED && (explicitRole == UserRole.TEACHER || isTeacherEmail(trimmedEmail))) {
            _uiState.value = AuthUiState.Error(TEACHER_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(TEACHER_LOCKED_MESSAGE))
        }
        if (IS_ADMIN_AUTH_LOCKED && (explicitRole == UserRole.ADMIN || trimmedEmail.equals(ADMIN_EMAIL, ignoreCase = true))) {
            _uiState.value = AuthUiState.Error(ADMIN_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(ADMIN_LOCKED_MESSAGE))
        }

        val assignedRole = enforceRoleLock(explicitRole ?: inferRoleFromEmail(trimmedEmail))
        val sanitizedId = trimmedEmail.replace("[^a-zA-Z0-9]".toRegex(), "_").lowercase()
        val localUser = AuthUser(
            uid = "local_$sanitizedId",
            email = trimmedEmail,
            displayName = trimmedEmail.substringBefore("@").replaceFirstChar { it.uppercase() },
            isAnonymous = false,
            photoUrl = null,
            role = assignedRole,
            isFirebaseVerified = false
        )
        persistSession(localUser)
        _isStartupAuthCompleted.value = true
        _uiState.value = AuthUiState.Authenticated(localUser)
        return Result.success(localUser)
    }

    /**
     * Local offline profile registration.
     * Teacher and Admin registrations are locked while [IS_TEACHER_AUTH_LOCKED] / [IS_ADMIN_AUTH_LOCKED] are true.
     */
    suspend fun signUpWithEmail(
        email: String,
        pass: String,
        displayName: String,
        role: UserRole = UserRole.STUDENT,
        standard: Int = 6
    ): Result<AuthUser> {
        val trimmedEmail = email.trim()
        val trimmedPass = pass.trim()
        val trimmedName = displayName.trim()

        if (IS_TEACHER_AUTH_LOCKED && (role == UserRole.TEACHER || isTeacherEmail(trimmedEmail))) {
            _uiState.value = AuthUiState.Error(TEACHER_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(TEACHER_LOCKED_MESSAGE))
        }
        if (IS_ADMIN_AUTH_LOCKED && role == UserRole.ADMIN) {
            _uiState.value = AuthUiState.Error(ADMIN_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(ADMIN_LOCKED_MESSAGE))
        }

        if (trimmedEmail.isBlank() || !trimmedEmail.contains("@")) {
            val err = "Please enter a valid email address (e.g., student@school.edu)"
            _uiState.value = AuthUiState.Error(err)
            return Result.failure(IllegalArgumentException(err))
        }
        if (trimmedPass.length < 6) {
            val err = "Password must be at least 6 characters"
            _uiState.value = AuthUiState.Error(err)
            return Result.failure(IllegalArgumentException(err))
        }

        val safeRole = enforceRoleLock(role)
        val sanitizedId = trimmedEmail.replace("[^a-zA-Z0-9]".toRegex(), "_").lowercase()
        val finalName = trimmedName.ifBlank {
            if (safeRole == UserRole.TEACHER) "School Teacher" else "Student User"
        }

        val localUser = AuthUser(
            uid = "local_${if (safeRole == UserRole.STUDENT) "std_" else "tch_"}$sanitizedId",
            email = trimmedEmail,
            displayName = finalName,
            isAnonymous = false,
            photoUrl = null,
            role = safeRole,
            isFirebaseVerified = false
        )
        persistSession(localUser)
        _isStartupAuthCompleted.value = true
        _uiState.value = AuthUiState.Authenticated(localUser)
        return Result.success(localUser)
    }

    suspend fun signInDemoTeacher(): Result<AuthUser> {
        if (IS_TEACHER_AUTH_LOCKED) {
            _uiState.value = AuthUiState.Error(TEACHER_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(TEACHER_LOCKED_MESSAGE))
        }
        val user = AuthUser(
            uid = "local_demo_teacher_sharma",
            email = "teacher.sharma@school.edu",
            displayName = "Teacher Mrs. Sharma",
            role = UserRole.TEACHER,
            isFirebaseVerified = false
        )
        persistSession(user)
        _isStartupAuthCompleted.value = true
        _uiState.value = AuthUiState.Authenticated(user)
        return Result.success(user)
    }

    suspend fun signInDemoAdmin(): Result<AuthUser> {
        if (IS_ADMIN_AUTH_LOCKED) {
            _uiState.value = AuthUiState.Error(ADMIN_LOCKED_MESSAGE)
            return Result.failure(IllegalStateException(ADMIN_LOCKED_MESSAGE))
        }
        val user = AuthUser(
            uid = "local_demo_admin_principal",
            email = "admin.principal@school.edu",
            displayName = "Principal Administrator",
            role = UserRole.ADMIN,
            isFirebaseVerified = false
        )
        persistSession(user)
        _isStartupAuthCompleted.value = true
        _uiState.value = AuthUiState.Authenticated(user)
        return Result.success(user)
    }

    suspend fun signInDemoStudent(): Result<AuthUser> {
        val user = AuthUser(
            uid = "local_demo_student_aarav",
            email = "student.aarav@school.edu",
            displayName = "Aarav Patel",
            role = UserRole.STUDENT,
            isFirebaseVerified = false
        )
        persistSession(user)
        _isStartupAuthCompleted.value = true
        _uiState.value = AuthUiState.Authenticated(user)
        return Result.success(user)
    }

    suspend fun signOutWithCredentials(appContext: Context = context) {
        withContext(NonCancellable) {
            try {
                if (isFirebaseSessionActive()) {
                    kotlinx.coroutines.withTimeoutOrNull(1500L) {
                        CredentialManager.create(appContext)
                            .clearCredentialState(ClearCredentialStateRequest())
                    }
                }
            } catch (t: Throwable) {
                Log.w(TAG, "Clear credential state note: ${t.message}")
            } finally {
                signOut()
            }
        }
    }

    fun signOut() {
        firebaseAuth?.signOut()
        _isFirebaseSignedIn.value = false
        rolePrefs.edit()
            .remove("active_session_uid")
            .remove("active_session_email")
            .remove("active_session_name")
            .putBoolean("startup_auth_completed", false)
            .apply()
        _isStartupAuthCompleted.value = false
        _uiState.value = AuthUiState.Unauthenticated()
    }

    fun getCurrentUser(): AuthUser? {
        val remoteUser = firebaseAuth?.currentUser?.toAuthUser()
        if (remoteUser != null) return remoteUser
        return (_uiState.value as? AuthUiState.Authenticated)?.user
    }

    private fun FirebaseUser.toAuthUser(roleOverride: UserRole? = null): AuthUser {
        val assignedRole = enforceRoleLock(roleOverride ?: getUserRole(uid, email))
        return AuthUser(
            uid = uid,
            email = email,
            displayName = displayName,
            isAnonymous = false,
            photoUrl = photoUrl?.toString(),
            role = assignedRole,
            isFirebaseVerified = true
        )
    }

    companion object {
        private const val TAG = "FirebaseAuthManager"
        private const val ADMIN_EMAIL = "somas211@gmail.com"

        /**
         * Centralized policy lock for Teacher signup, login, demo login, and role switching.
         * Change to `false` when ready to re-open Teacher access in the future.
         */
        const val IS_TEACHER_AUTH_LOCKED = true

        /**
         * Centralized policy lock for Admin signup, demo login, and role switching.
         */
        const val IS_ADMIN_AUTH_LOCKED = true

        const val TEACHER_LOCKED_MESSAGE =
            "Teacher signup & login are currently locked. Please sign in as a Student."
        const val ADMIN_LOCKED_MESSAGE =
            "Admin signup & login are currently locked."

        @android.annotation.SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: FirebaseAuthManager? = null

        fun getInstance(context: Context): FirebaseAuthManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: FirebaseAuthManager(context.applicationContext).also { INSTANCE = it }
            }
        }
    }
}

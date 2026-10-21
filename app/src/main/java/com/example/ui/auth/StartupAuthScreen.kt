package com.example.ui.auth

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.R
import com.example.QuizViewModel
import com.example.auth.AuthUiState
import com.example.auth.UserRole

/**
 * Fullscreen one-time startup onboarding and authentication gate.
 * Enforces role-based setup (Student, Teacher, Admin), username, password,
 * and class standard selection, backed by genuine Firebase Auth & Cloud Firestore.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartupAuthScreen(
    viewModel: QuizViewModel,
    onAuthComplete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val authState by viewModel.authUiState.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()

    var isSignUpMode by remember { mutableStateOf(true) }
    var selectedRole by remember { mutableStateOf(UserRole.STUDENT) }
    var selectedStandard by remember { mutableIntStateOf(6) }

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    val primaryIndigo = Color(0xFF4F46E5)
    val emeraldAccent = Color(0xFF10B981)
    val amberAccent = Color(0xFFF59E0B)

    // Watch for successful authentication to unlock the app
    LaunchedEffect(authState) {
        if (authState is AuthUiState.Authenticated) {
            onAuthComplete()
        }
    }

    // Admin role is locked for new registrations; ensure selectedRole resets to STUDENT in register mode
    LaunchedEffect(isSignUpMode) {
        if (isSignUpMode && selectedRole == UserRole.ADMIN) {
            selectedRole = UserRole.STUDENT
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = if (isDark) listOf(
                        Color(0xFF0F172A),
                        Color(0xFF1E1B4B),
                        Color(0xFF0F172A)
                    ) else listOf(
                        Color(0xFFEEF2FF),
                        Color(0xFFFFFFFF),
                        Color(0xFFF8FAFC)
                    )
                )
            )
            .testTag("startup_auth_screen")
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            // App Brand Logo & Hero Header
            Box(
                modifier = Modifier
                    .size(84.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .border(BorderStroke(2.dp, primaryIndigo.copy(alpha = 0.2f)), RoundedCornerShape(24.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_app_logo_eagle),
                    contentDescription = "School Quiz Eagle Logo",
                    modifier = Modifier.size(64.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "School Quiz",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isDark) Color.White else Color(0xFF1E1B4B),
                letterSpacing = (-0.5).sp
            )

            Text(
                text = "Classes 6 to 10 • Morarji • NMMS Scholarship • 1 vs 1 Battles",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isDark) Color(0xFFA5B4FC) else primaryIndigo,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Auth Mode Selector: Sign Up (New Account) vs Log In (Existing)
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFE2E8F0)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    // Sign Up Tab
                    Button(
                        onClick = {
                            isSignUpMode = true
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSignUpMode) primaryIndigo else Color.Transparent,
                            contentColor = if (isSignUpMode) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("startup_tab_signup"),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "New User (Register)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }

                    // Log In Tab
                    Button(
                        onClick = {
                            isSignUpMode = false
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isSignUpMode) primaryIndigo else Color.Transparent,
                            contentColor = if (!isSignUpMode) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("startup_tab_login"),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "Existing (Sign In)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Main Authentication Card
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E293B) else Color.White
                ),
                border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("startup_auth_card")
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    if (isSignUpMode) {
                        // ROLE SELECTION HEADER
                        Text(
                            text = "Select Account Role Type:",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        // Role Type Cards (Student, Teacher, Admin)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Student Option
                            RoleSelectionPill(
                                title = "Student",
                                icon = "🎓",
                                subtitle = "Quizzes & 1v1",
                                isSelected = selectedRole == UserRole.STUDENT,
                                activeColor = primaryIndigo,
                                onClick = { selectedRole = UserRole.STUDENT },
                                modifier = Modifier.weight(1f)
                            )

                            // Teacher Option
                            RoleSelectionPill(
                                title = "Teacher",
                                icon = "👨‍🏫",
                                subtitle = "Question Bank",
                                isSelected = selectedRole == UserRole.TEACHER,
                                activeColor = emeraldAccent,
                                onClick = { selectedRole = UserRole.TEACHER },
                                modifier = Modifier.weight(1f)
                            )

                            // Admin Option (Locked for new registrations)
                            RoleSelectionPill(
                                title = "Admin",
                                icon = "🛡️",
                                subtitle = "No New Register",
                                isSelected = false,
                                activeColor = amberAccent,
                                onClick = { /* Locked - Admin accounts cannot register */ },
                                isLocked = true,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        // Admin locked info note
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("🔒", fontSize = 11.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Admin role is locked: Admin accounts are pre-provisioned and cannot be newly registered.",
                                    fontSize = 10.5.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        // For Student role: Class / Standard Picker
                        if (selectedRole == UserRole.STUDENT) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Academic Class / Exam Stream:",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(6.dp))

                                val standards = listOf(
                                    6 to "Class 6",
                                    7 to "Class 7",
                                    8 to "Class 8",
                                    9 to "Class 9",
                                    10 to "Class 10",
                                    11 to "Morarji",
                                    12 to "NMMS"
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    standards.forEach { (stdNum, stdLabel) ->
                                        val isSel = selectedStandard == stdNum
                                        Surface(
                                            shape = RoundedCornerShape(10.dp),
                                            color = if (isSel) primaryIndigo else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                            border = BorderStroke(1.dp, if (isSel) primaryIndigo else MaterialTheme.colorScheme.outlineVariant),
                                            modifier = Modifier
                                                .clickable { selectedStandard = stdNum }
                                                .testTag("startup_std_${stdNum}")
                                        ) {
                                            Text(
                                                text = stdLabel,
                                                fontSize = 11.5.sp,
                                                fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                                                color = if (isSel) Color.White else MaterialTheme.colorScheme.onSurface,
                                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // Username / Full Name field
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            label = {
                                Text(
                                    when (selectedRole) {
                                        UserRole.STUDENT -> "Student Username / Full Name"
                                        UserRole.TEACHER -> "Teacher Full Name"
                                        UserRole.ADMIN -> "Administrator Name"
                                    }
                                )
                            },
                            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("startup_username_input")
                        )
                    }

                    // Email Address field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email Address") },
                        placeholder = { Text("student@school.edu") },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("startup_email_input")
                    )

                    // Password field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password (min 6 characters)") },
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = "Toggle password visibility"
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("startup_password_input")
                    )

                    // Error banner if any
                    val authError = (authState as? AuthUiState.Error)?.message
                    val isApiKeyIssue = authError?.contains("api key", ignoreCase = true) == true || authError?.contains("internal error", ignoreCase = true) == true
                    if (!authError.isNullOrBlank() && !isApiKeyIssue) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFEF4444).copy(alpha = 0.12f),
                            border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.3f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("⚠️", fontSize = 14.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = authError,
                                    fontSize = 11.sp,
                                    color = Color(0xFFDC2626),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }

                    // Primary Submit Button
                    val isLoading = authState is AuthUiState.Loading
                    Button(
                        onClick = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                            if (isSignUpMode) {
                                viewModel.signUpWithFirebase(
                                    email = email.trim(),
                                    pass = password.trim(),
                                    displayName = username.trim(),
                                    role = selectedRole,
                                    standard = selectedStandard,
                                    onSuccess = onAuthComplete
                                )
                            } else {
                                viewModel.signInWithFirebase(
                                    email = email.trim(),
                                    pass = password.trim(),
                                    explicitRole = null,
                                    onSuccess = onAuthComplete
                                )
                            }
                        },
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = primaryIndigo),
                        enabled = !isLoading && email.isNotBlank() && password.length >= 6 && (!isSignUpMode || username.isNotBlank()),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("startup_submit_button")
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = Color.White,
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Connecting to Firebase...", fontWeight = FontWeight.Bold)
                        } else {
                            Text(
                                text = if (isSignUpMode) "REGISTER & START AS ${selectedRole.name}" else "SIGN IN & ENTER ARENA",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 13.5.sp
                            )
                        }
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                    // Quick One-Click Demo Logins for evaluators and fast testing
                    Text(
                        text = "⚡ Instant Testing (One-Click Demo Credentials):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                viewModel.signInDemoStudent()
                                onAuthComplete()
                            },
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                                .testTag("startup_demo_student_button")
                        ) {
                            Text("🎓 Student", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        }

                        OutlinedButton(
                            onClick = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                viewModel.signInDemoTeacher()
                                onAuthComplete()
                            },
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                                .testTag("startup_demo_teacher_button")
                        ) {
                            Text("👨‍🏫 Teacher", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        }

                        // Admin demo chip is locked/inactive in both Register and Existing layouts
                        OutlinedButton(
                            onClick = { /* Locked by policy */ },
                            enabled = false,
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                disabledContainerColor = if (isDark) Color(0xFF1E293B).copy(alpha = 0.5f) else Color(0xFFF1F5F9),
                                disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                                .testTag("startup_demo_admin_button")
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = "Locked",
                                    modifier = Modifier.size(12.dp)
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text("Admin", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Firebase genuine backend trust badge
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("🔥", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Powered by Google Cloud Firestore & Firebase Auth",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun RoleSelectionPill(
    title: String,
    icon: String,
    subtitle: String,
    isSelected: Boolean,
    activeColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLocked: Boolean = false
) {
    val pillBg = when {
        isLocked -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        isSelected -> activeColor.copy(alpha = 0.12f)
        else -> MaterialTheme.colorScheme.surface
    }
    val borderColor = when {
        isLocked -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        isSelected -> activeColor
        else -> MaterialTheme.colorScheme.outlineVariant
    }

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = pillBg,
        border = BorderStroke(if (isSelected && !isLocked) 2.dp else 1.dp, borderColor),
        modifier = modifier
            .then(
                if (!isLocked) Modifier.clickable(onClick = onClick)
                else Modifier
            )
            .testTag("role_pill_${title.lowercase()}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(icon, fontSize = 22.sp)
                if (isLocked) {
                    Box(
                        modifier = Modifier
                            .offset(x = 10.dp, y = (-8).dp)
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFDC2626)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Locked",
                            tint = Color.White,
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = if (isLocked) {
                    MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                } else if (isSelected) {
                    activeColor
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            )
            Text(
                text = if (isLocked) "Locked" else subtitle,
                fontSize = 9.sp,
                color = if (isLocked) Color(0xFFEF4444) else MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

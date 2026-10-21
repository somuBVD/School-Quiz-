@file:OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)

package com.example.ui.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.QuizViewModel
import com.example.auth.AuthUiState
import com.example.auth.AuthUser
import com.example.auth.CloudSyncState
import com.example.auth.UserRole

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthDialog(
    viewModel: QuizViewModel,
    onDismiss: () -> Unit
) {
    val authState by viewModel.authUiState.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val isFirebaseConfigured by viewModel.isFirebaseConfigured.collectAsState()

    var isSignUpMode by remember { mutableStateOf(false) }
    var selectedRole by remember { mutableStateOf(UserRole.STUDENT) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var displayName by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header with icon
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4F46E5).copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🔐", fontSize = 28.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = when (authState) {
                        is AuthUiState.Authenticated -> "Firebase User Profile"
                        else -> if (isSignUpMode) "Create Account & Select Role" else "Firebase Sign In"
                    },
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = if (isFirebaseConfigured) "Google Firebase Authentication • RBAC Enabled" else "Firebase Authentication (Local/Cloud Mode)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(16.dp))

                when (val state = authState) {
                    is AuthUiState.Authenticated -> {
                        // Authenticated view
                        AuthenticatedUserInfo(
                            user = state.user,
                            viewModel = viewModel,
                            onSignOut = { viewModel.signOut() },
                            onRegisterAnother = {
                                viewModel.signOut()
                                isSignUpMode = true
                                selectedRole = UserRole.STUDENT
                            },
                            onDismiss = onDismiss,
                            isDark = isDark
                        )
                    }
                    is AuthUiState.Loading -> {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(color = Color(0xFF4F46E5))
                            Spacer(modifier = Modifier.height(16.dp))
                            Text("Connecting to Firebase Auth...", fontSize = 13.sp)
                        }
                    }
                    else -> {
                        // Sign in / Sign up form
                        if (state is AuthUiState.Error) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFFEF4444).copy(alpha = 0.12f),
                                border = BorderStroke(1.dp, Color(0xFFEF4444)),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 12.dp)
                            ) {
                                Text(
                                    text = state.message,
                                    color = Color(0xFFDC2626),
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }

                        if (isSignUpMode) {
                            Text(
                                text = "Select Account Role:",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp)
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                UserRole.values().forEach { role ->
                                    val isSelected = selectedRole == role
                                    FilterChip(
                                        selected = isSelected,
                                        onClick = { selectedRole = role },
                                        label = {
                                            Text(
                                                text = when (role) {
                                                    UserRole.STUDENT -> "🎓 Student"
                                                    UserRole.TEACHER -> "👨‍🏫 Teacher"
                                                    UserRole.ADMIN -> "🛡️ Admin"
                                                },
                                                fontSize = 11.sp,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                            )
                                        },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = displayName,
                                onValueChange = { displayName = it },
                                label = {
                                    Text(
                                        when (selectedRole) {
                                            UserRole.STUDENT -> "Student Name"
                                            UserRole.TEACHER -> "Teacher / Faculty Name"
                                            UserRole.ADMIN -> "Administrator Name"
                                        }
                                    )
                                },
                                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("auth_display_name_input"),
                                singleLine = true,
                                shape = RoundedCornerShape(12.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email Address") },
                            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("auth_email_input"),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password") },
                            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                            trailingIcon = {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(
                                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = "Toggle password"
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("auth_password_input"),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                if (isSignUpMode) {
                                    viewModel.signUpWithFirebase(email, password, displayName, selectedRole)
                                } else {
                                    viewModel.signInWithFirebase(email, password)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .testTag("auth_primary_button"),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                            enabled = email.isNotBlank() && password.length >= 6
                        ) {
                            Text(
                                text = if (isSignUpMode) "REGISTER AS ${selectedRole.name}" else "LOG IN",
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // --- QUICK DEMO LOGINS FOR RBAC EVALUATION ---
                        Text(
                            text = "⚡ Quick Demo Logins (Role Testing):",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            OutlinedButton(
                                onClick = {
                                    keyboardController?.hide()
                                    focusManager.clearFocus()
                                    viewModel.signInDemoTeacher()
                                    onDismiss()
                                },
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp),
                                modifier = Modifier.weight(1f).height(36.dp)
                            ) {
                                Text("👨‍🏫 Teacher", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                            }
                            OutlinedButton(
                                onClick = {
                                    keyboardController?.hide()
                                    focusManager.clearFocus()
                                    viewModel.signInDemoAdmin()
                                    onDismiss()
                                },
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp),
                                modifier = Modifier.weight(1f).height(36.dp)
                            ) {
                                Text("🛡️ Admin", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                            }
                            OutlinedButton(
                                onClick = {
                                    keyboardController?.hide()
                                    focusManager.clearFocus()
                                    viewModel.signInDemoStudent()
                                    onDismiss()
                                },
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp),
                                modifier = Modifier.weight(1f).height(36.dp)
                            ) {
                                Text("🎓 Student", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Anonymous / Guest Login
                        OutlinedButton(
                            onClick = {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                viewModel.signInAnonymously()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .testTag("auth_guest_button"),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Continue as Guest (Student Level)", fontSize = 12.sp)
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Switch mode button
                        TextButton(
                            onClick = { isSignUpMode = !isSignUpMode }
                        ) {
                            Text(
                                text = if (isSignUpMode) "Already have an account? Sign In" else "Create New Account / Register Faculty",
                                color = Color(0xFF4F46E5),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        TextButton(onClick = onDismiss) {
                            Text("Close", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AuthenticatedUserInfo(
    user: AuthUser,
    viewModel: QuizViewModel,
    onSignOut: () -> Unit,
    onRegisterAnother: (() -> Unit)? = null,
    onDismiss: () -> Unit,
    isDark: Boolean
) {
    val cloudSyncState by viewModel.cloudSyncState.collectAsState()
    val isCloudSyncAvailable by viewModel.isCloudSyncAvailable.collectAsState()

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
        ),
        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF10B981).copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("✓", fontSize = 20.sp, color = Color(0xFF10B981), fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = user.displayName ?: if (user.isAnonymous) "Guest Student" else "Logged In User",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = user.email ?: if (user.isAnonymous) "Anonymous Session" else "No Email",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Role Badge
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = when (user.role) {
                    UserRole.ADMIN -> Color(0xFF7C3AED).copy(alpha = 0.12f)
                    UserRole.TEACHER -> Color(0xFF0D9488).copy(alpha = 0.12f)
                    UserRole.STUDENT -> Color(0xFF2563EB).copy(alpha = 0.12f)
                },
                border = BorderStroke(1.dp, when (user.role) {
                    UserRole.ADMIN -> Color(0xFF7C3AED)
                    UserRole.TEACHER -> Color(0xFF0D9488)
                    UserRole.STUDENT -> Color(0xFF2563EB)
                }),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = when (user.role) {
                        UserRole.ADMIN -> "🛡️ School Administrator (Full Admin Access)"
                        UserRole.TEACHER -> "👨‍🏫 Verified Faculty / Teacher (Question CRUD & Alerts)"
                        UserRole.STUDENT -> "🎓 Student (Standard Learner Access)"
                    },
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = when (user.role) {
                        UserRole.ADMIN -> Color(0xFF7C3AED)
                        UserRole.TEACHER -> Color(0xFF0D9488)
                        UserRole.STUDENT -> Color(0xFF2563EB)
                    },
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Role Switcher for Fast Evaluation
            Text(
                text = "⚡ Switch Role (RBAC Testing):",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                UserRole.values().forEach { role ->
                    val isCurrent = user.role == role
                    val roleColor = when (role) {
                        UserRole.ADMIN -> Color(0xFF7C3AED)
                        UserRole.TEACHER -> Color(0xFF0D9488)
                        UserRole.STUDENT -> Color(0xFF2563EB)
                    }
                    Surface(
                        onClick = { viewModel.updateUserRole(role) },
                        shape = RoundedCornerShape(10.dp),
                        color = if (isCurrent) roleColor.copy(alpha = 0.16f) else if (isDark) Color(0xFF334155).copy(alpha = 0.4f) else Color(0xFFF1F5F9),
                        border = BorderStroke(
                            1.dp,
                            if (isCurrent) roleColor else if (isDark) Color(0xFF475569) else Color(0xFFCBD5E1)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 7.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = when (role) {
                                    UserRole.STUDENT -> "🎓 Student"
                                    UserRole.TEACHER -> "👨‍🏫 Teacher"
                                    UserRole.ADMIN -> "🛡️ Admin"
                                },
                                fontSize = 11.sp,
                                fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium,
                                color = if (isCurrent) roleColor else MaterialTheme.colorScheme.onSurface,
                                maxLines = 1
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (isDark) Color(0xFF0F172A) else Color(0xFFF1F5F9),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Firebase UID: ${user.uid.take(16)}...",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = if (user.isAnonymous) "Status: Guest Mode" else "Status: Verified Account",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF10B981)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Cloud Firestore & Storage Synchronization Section
            Text(
                text = "Cloud Sync (Firestore & Storage)",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(6.dp))

            when (val sync = cloudSyncState) {
                is CloudSyncState.Syncing -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(14.dp), strokeWidth = 2.dp)
                        Text("Syncing with Firebase Firestore...", fontSize = 11.sp, color = MaterialTheme.colorScheme.primary)
                    }
                }
                is CloudSyncState.Success -> {
                    Text("✓ ${sync.message}", fontSize = 11.sp, color = Color(0xFF10B981), fontWeight = FontWeight.SemiBold)
                }
                is CloudSyncState.Error -> {
                    Text("⚠️ ${sync.message}", fontSize = 11.sp, color = Color(0xFFEF4444))
                }
                else -> {
                    Text(
                        text = if (isCloudSyncAvailable) "Firestore & Storage active. Ready to sync data." else "Cloud fallback active for offline use.",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = { viewModel.syncWithFirestore() },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f).testTag("auth_cloud_backup_button")
                ) {
                    Text("☁️ Backup", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = { viewModel.restoreFromFirestore() },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f).testTag("auth_cloud_restore_button")
                ) {
                    Text("📥 Restore", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (onRegisterAnother != null) {
        Button(
            onClick = onRegisterAnother,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .testTag("auth_register_another_student_button")
        ) {
            Icon(Icons.Default.PersonAdd, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("REGISTER ANOTHER STUDENT", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))
    }

    Button(
        onClick = onSignOut,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .testTag("auth_sign_out_button")
    ) {
        Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = null, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text("SIGN OUT", fontWeight = FontWeight.Bold)
    }

    Spacer(modifier = Modifier.height(8.dp))

    OutlinedButton(
        onClick = onDismiss,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Done")
    }
}

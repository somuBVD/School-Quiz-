@file:OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)

package com.example.ui.admin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizViewModel
import com.example.auth.AuthUiState
import com.example.auth.AuthUser
import com.example.auth.UserRole

/**
 * Gate screen shown when an unauthenticated user attempts to access the Teacher & Admin Panel.
 * Provides a tailored sign-in/registration flow specifically designed for faculty and administrators,
 * along with one-click demo credentials for rapid verification of role privileges.
 */
@Composable
fun AdminAuthGate(
    viewModel: QuizViewModel,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    val authState by viewModel.authUiState.collectAsState()
    var isSignUpMode by remember { mutableStateOf(false) }
    var selectedRole by remember { mutableStateOf(UserRole.TEACHER) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var displayName by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val primaryIndigo = Color(0xFF4F46E5)
    val cardBg = if (isDark) Color(0xFF1E293B) else Color.White
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- HERO HEADER ---
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF3730A3) else Color(0xFFC7D2FE)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(primaryIndigo.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🛡️", fontSize = 32.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Faculty & Staff Portal",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isDark) Color(0xFFC7D2FE) else Color(0xFF312E81)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Firebase Authentication & Role-Based Access Control",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = primaryIndigo
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sign in with your verified teacher or administrator credentials to manage Room questions, broadcast bulletins, and configure school curriculum.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }

        // --- SIGN IN / REGISTRATION CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("admin_auth_form_card"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = cardBorder
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Mode Toggle: Sign In vs Register
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isDark) Color(0xFF0F172A) else Color(0xFFF1F5F9))
                        .padding(4.dp)
                ) {
                    Button(
                        onClick = { isSignUpMode = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isSignUpMode) primaryIndigo else Color.Transparent,
                            contentColor = if (!isSignUpMode) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f).height(38.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("Faculty Sign In", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }

                    Button(
                        onClick = { isSignUpMode = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSignUpMode) primaryIndigo else Color.Transparent,
                            contentColor = if (isSignUpMode) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f).height(38.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("Register Staff", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }
                }

                // Error Message if any
                if (authState is AuthUiState.Error) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = Color(0xFFEF4444).copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, Color(0xFFEF4444)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("⚠️ ", fontSize = 14.sp)
                            Text(
                                text = (authState as AuthUiState.Error).message,
                                color = Color(0xFFDC2626),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                // If Registering, Select Role
                if (isSignUpMode) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "Designated Access Role:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            listOf(
                                UserRole.TEACHER to "👨‍🏫 Teacher",
                                UserRole.ADMIN to "🛡️ Administrator"
                            ).forEach { (role, label) ->
                                val selected = selectedRole == role
                                FilterChip(
                                    selected = selected,
                                    onClick = { selectedRole = role },
                                    label = {
                                        Text(
                                            text = label,
                                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                                            fontSize = 11.sp,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = displayName,
                        onValueChange = { displayName = it },
                        label = { Text(if (selectedRole == UserRole.ADMIN) "Administrator Name" else "Teacher Full Name") },
                        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("admin_register_name_input"),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                // Email Field
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Institutional / Staff Email") },
                    placeholder = { Text("e.g. teacher.sharma@school.edu") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("admin_auth_email_input"),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                // Password Field
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password (Min 6 chars)") },
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("admin_auth_password_input"),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                // Submit Button
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
                        .testTag("admin_auth_submit_button"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryIndigo),
                    enabled = email.isNotBlank() && password.length >= 6
                ) {
                    if (authState is AuthUiState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Verifying Credentials...")
                    } else {
                        Icon(
                            imageVector = if (isSignUpMode) Icons.Default.PersonAdd else Icons.AutoMirrored.Filled.Login,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isSignUpMode) "REGISTER & ACCESS PANEL" else "SIGN IN TO ADMIN PANEL",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        // --- FAST ONE-CLICK DEMO ACCESS PROFILES ---
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = cardBorder
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⚡ ", fontSize = 16.sp)
                    Text(
                        text = "Instant Demo Verification Profiles",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Text(
                    text = "Tap any role below to authenticate instantly and test how the admin panel differentiates access levels:",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Teacher Demo Button
                Surface(
                    onClick = { viewModel.signInDemoTeacher() },
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFF0D9488).copy(alpha = 0.08f),
                    border = BorderStroke(1.2.dp, Color(0xFF0D9488)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("demo_sign_in_teacher")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Text("👨‍🏫", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "Mrs. Sharma",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFF5EEAD4) else Color(0xFF0D9488)
                                )
                                Text(
                                    text = "teacher.sharma@school.edu",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF0D9488).copy(alpha = 0.18f),
                            border = BorderStroke(1.dp, Color(0xFF0D9488).copy(alpha = 0.4f))
                        ) {
                            Text(
                                text = "TEACHER ROLE",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isDark) Color(0xFF5EEAD4) else Color(0xFF0D9488),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                // Administrator Demo Button
                Surface(
                    onClick = { viewModel.signInDemoAdmin() },
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFF7C3AED).copy(alpha = 0.08f),
                    border = BorderStroke(1.2.dp, Color(0xFF7C3AED)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("demo_sign_in_admin")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Text("🛡️", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "Principal Administrator",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFC4B5FD) else Color(0xFF7C3AED)
                                )
                                Text(
                                    text = "admin.principal@school.edu",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF7C3AED).copy(alpha = 0.18f),
                            border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.4f))
                        ) {
                            Text(
                                text = "ADMIN ROLE",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isDark) Color(0xFFC4B5FD) else Color(0xFF7C3AED),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                // Student Demo Button (Demonstrating Access Restriction)
                Surface(
                    onClick = { viewModel.signInDemoStudent() },
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFF2563EB).copy(alpha = 0.08f),
                    border = BorderStroke(1.2.dp, Color(0xFF2563EB)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("demo_sign_in_student")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Text("🎓", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "Aarav Patel (Student)",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFF93C5FD) else Color(0xFF2563EB)
                                )
                                Text(
                                    text = "student.aarav@school.edu",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFEF4444).copy(alpha = 0.15f),
                            border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.4f))
                        ) {
                            Text(
                                text = "TEST RESTRICTION",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFDC2626),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }

        // --- RBAC PERMISSION COMPARISON CARD ---
        RoleMatrixCard(isDark = isDark)
    }
}

/**
 * Screen shown when an authenticated STUDENT attempts to view the Admin Panel.
 * Delineates clearly what students can access vs teachers vs administrators,
 * and provides options to switch accounts or self-elevate for testing.
 */
@Composable
fun StudentAccessRestricted(
    user: AuthUser,
    viewModel: QuizViewModel,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    val cardBg = if (isDark) Color(0xFF1E293B) else Color.White
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- RESTRICTION HERO BANNER ---
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = if (isDark) Color(0xFF450A0A) else Color(0xFFFEF2F2),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF991B1B) else Color(0xFFFECACA)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFEF4444).copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🚫", fontSize = 30.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Access Restricted: Student Account",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isDark) Color(0xFFFCA5A5) else Color(0xFF991B1B)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "The Teacher & Admin Panel requires verified faculty credentials. Students are restricted from modifying curriculum and school alerts.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }

        // --- CURRENT ACCOUNT INFO CARD ---
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = cardBorder
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Current Active Session:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF2563EB).copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🎓", fontSize = 22.sp)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = user.displayName ?: "Student User",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Text(
                            text = user.email ?: "Anonymous Guest Session",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Badge(containerColor = Color(0xFF2563EB).copy(alpha = 0.15f)) {
                        Text(
                            text = "STUDENT LEVEL",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF2563EB)
                        )
                    }
                }

                HorizontalDivider(color = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

                Text(
                    text = "To access question creation, updates, and school alerts, switch to a Teacher or Administrator profile below:",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Quick Elevation & Switch Buttons
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { viewModel.updateUserRole(UserRole.TEACHER) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.height(42.dp),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 0.dp)
                    ) {
                        Text("⚡ Elevate to Teacher", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                    }

                    Button(
                        onClick = { viewModel.updateUserRole(UserRole.ADMIN) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.height(42.dp),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 0.dp)
                    ) {
                        Text("🛡️ Elevate to Admin", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                    }
                }

                OutlinedButton(
                    onClick = { viewModel.signOut() },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFDC2626)),
                    border = BorderStroke(1.dp, Color(0xFFDC2626).copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(40.dp)
                ) {
                    Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Sign Out to Login as Faculty", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // --- RBAC MATRIX CARD ---
        RoleMatrixCard(isDark = isDark)
    }
}

/**
 * Top bar header displaying the authenticated faculty member's credentials,
 * verified role badge, and fast role-switching chip row for emulator testing.
 */
@Composable
fun FacultyHeaderBar(
    user: AuthUser,
    role: UserRole,
    viewModel: QuizViewModel,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    val roleColor = when (role) {
        UserRole.ADMIN -> Color(0xFF7C3AED)
        UserRole.TEACHER -> Color(0xFF0D9488)
        UserRole.STUDENT -> Color(0xFF2563EB)
    }

    val cardBg = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = cardBg),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(roleColor.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (role == UserRole.ADMIN) "🛡️" else "👨‍🏫",
                            fontSize = 18.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(modifier = Modifier.weight(1f, fill = false)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = user.displayName ?: if (role == UserRole.ADMIN) "Principal Administrator" else "Faculty Teacher",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = roleColor.copy(alpha = 0.15f),
                                border = BorderStroke(1.dp, roleColor.copy(alpha = 0.5f))
                            ) {
                                Text(
                                    text = if (role == UserRole.ADMIN) "ADMIN" else "TEACHER",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = roleColor,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Text(
                            text = user.email ?: "faculty@school.edu",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Sign Out Button
                IconButton(
                    onClick = { viewModel.signOut() },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Logout,
                        contentDescription = "Sign Out",
                        tint = Color(0xFFEF4444),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Quick Role Switcher (Equal size, horizontal, single-line, perfectly fitted)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "Role Switcher:",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    UserRole.values().forEach { r ->
                        val isActive = role == r
                        val targetRoleColor = when (r) {
                            UserRole.ADMIN -> Color(0xFF7C3AED)
                            UserRole.TEACHER -> Color(0xFF0D9488)
                            UserRole.STUDENT -> Color(0xFF2563EB)
                        }
                        Surface(
                            onClick = { viewModel.updateUserRole(r) },
                            shape = RoundedCornerShape(10.dp),
                            color = if (isActive) targetRoleColor.copy(alpha = 0.16f) else if (isDark) Color(0xFF334155).copy(alpha = 0.4f) else Color(0xFFF1F5F9),
                            border = BorderStroke(
                                1.dp,
                                if (isActive) targetRoleColor else if (isDark) Color(0xFF475569) else Color(0xFFCBD5E1)
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 12.dp, vertical = 7.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = when (r) {
                                        UserRole.STUDENT -> "🎓 Student"
                                        UserRole.TEACHER -> "👨‍🏫 Teacher"
                                        UserRole.ADMIN -> "🛡️ Admin"
                                    },
                                    fontSize = 11.sp,
                                    fontWeight = if (isActive) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isActive) targetRoleColor else MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Visual matrix comparing permissions between Student, Teacher, and Administrator access levels.
 */
@Composable
fun RoleMatrixCard(
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    val cardBg = if (isDark) Color(0xFF1E293B) else Color.White
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = cardBg),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("📋 ", fontSize = 16.sp)
                Text(
                    text = "Access Level Privilege Matrix",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // Matrix Items
            val permissions = listOf(
                Triple("Question Bank CRUD (Create, Edit, Delete)", "❌ No", "✅ Full CRUD"),
                Triple("Broadcast Bulletins & Classroom Alerts", "❌ No", "✅ Classroom / Subject"),
                Triple("Promotional Banners & Sponsorship Campaigns", "❌ No", "👁️ View Only"),
                Triple("Faculty Account Management & RBAC Roles", "❌ No", "❌ Admin Only"),
                Triple("Take Standard 6-10 Quizzes & Flashcards", "✅ Yes", "✅ Yes"),
                Triple("Global Leaderboards & 1v1 Battle Arena", "✅ Yes", "✅ Yes")
            )

            permissions.forEach { (feature, studentAccess, teacherAccess) ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = feature,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (studentAccess.startsWith("✅")) Color(0xFF10B981).copy(alpha = 0.12f) else Color(0xFFEF4444).copy(alpha = 0.12f),
                            border = BorderStroke(1.dp, if (studentAccess.startsWith("✅")) Color(0xFF10B981).copy(alpha = 0.3f) else Color(0xFFEF4444).copy(alpha = 0.3f))
                        ) {
                            Text(
                                text = "STUDENT: $studentAccess",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (studentAccess.startsWith("✅")) Color(0xFF10B981) else Color(0xFFDC2626),
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (teacherAccess.startsWith("✅")) Color(0xFF4F46E5).copy(alpha = 0.12f) else Color(0xFF64748B).copy(alpha = 0.12f),
                            border = BorderStroke(1.dp, if (teacherAccess.startsWith("✅")) Color(0xFF4F46E5).copy(alpha = 0.3f) else Color(0xFF64748B).copy(alpha = 0.3f))
                        ) {
                            Text(
                                text = "TEACHER: $teacherAccess",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (teacherAccess.startsWith("✅")) Color(0xFF4F46E5) else Color(0xFF64748B),
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
                HorizontalDivider(color = if (isDark) Color(0xFF334155).copy(alpha = 0.5f) else Color(0xFFF1F5F9))
            }
        }
    }
}

/**
 * Dedicated tab for School Administrators to view faculty roster, audit permissions,
 * and test role elevation.
 */
@Composable
fun AdminFacultyManagementTab(
    user: AuthUser,
    viewModel: QuizViewModel,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    val cardBg = if (isDark) Color(0xFF1E293B) else Color.White
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Administrator Banner
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = if (isDark) Color(0xFF2E1065) else Color(0xFFFAF5FF),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF6B21A8) else Color(0xFFE9D5FF)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("🛡️", fontSize = 28.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "School Administrator Control Center",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color(0xFFE9D5FF) else Color(0xFF581C87)
                    )
                    Text(
                        text = "Manage staff privileges, inspect Firebase Authentication tokens, and audit role access.",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Active Session Security Audit Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = cardBorder
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "🔒 Security Audit & Token Inspector",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = if (isDark) Color(0xFF0F172A) else Color(0xFFF1F5F9),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Firebase UID: ${user.uid}", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                        Text("Identity Email: ${user.email ?: "N/A"}", fontSize = 11.sp)
                        Text("Assigned Role: ${user.role.displayName}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7C3AED))
                        Text("Privilege Level: isPrivileged = ${user.role.isPrivileged}", fontSize = 11.sp, color = Color(0xFF10B981))
                        Text("Session Integrity: Authenticated via Firebase Local/Remote Keystore", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }

        // Faculty Directory Simulation
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = cardBorder
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "👥 Faculty Roster & Quick Role Delegation",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )

                listOf(
                    Triple("Mrs. Sharma", "teacher.sharma@school.edu", UserRole.TEACHER),
                    Triple("Principal Administrator", "admin.principal@school.edu", UserRole.ADMIN),
                    Triple("Aarav Patel", "student.aarav@school.edu", UserRole.STUDENT),
                    Triple("Prof. Verma (Science)", "prof.verma@school.edu", UserRole.TEACHER)
                ).forEach { (name, email, memberRole) ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f).padding(end = 8.dp)) {
                            Text(name, fontWeight = FontWeight.Bold, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            Text(email, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = when (memberRole) {
                                UserRole.ADMIN -> Color(0xFF7C3AED).copy(alpha = 0.15f)
                                UserRole.TEACHER -> Color(0xFF0D9488).copy(alpha = 0.15f)
                                UserRole.STUDENT -> Color(0xFF2563EB).copy(alpha = 0.15f)
                            }
                        ) {
                            Text(
                                text = memberRole.name,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = when (memberRole) {
                                    UserRole.ADMIN -> Color(0xFF7C3AED)
                                    UserRole.TEACHER -> Color(0xFF0D9488)
                                    UserRole.STUDENT -> Color(0xFF2563EB)
                                },
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                    HorizontalDivider(color = if (isDark) Color(0xFF334155).copy(alpha = 0.5f) else Color(0xFFF1F5F9))
                }
            }
        }
    }
}

package com.example.ui.profile

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.SubcomposeAsyncImage
import com.example.QuizViewModel
import com.example.auth.AuthUiState
import com.example.auth.CloudSyncState
import com.example.data.*
import com.example.ui.auth.AuthDialog
import com.example.ui.dashboard.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

/**
 * Comprehensive Student Profile Screen deeply integrated with:
 * 1. Firebase Auth: User identification, Google Auth status, UID, and role-based accounts.
 * 2. Firebase Cloud Firestore: Real-time sync of student profile, standard, points, XP, and study streak.
 * 3. Firebase Cloud Storage: Custom photo upload and download URL persistence.
 * 4. Displays: Curriculum Progress, Subject-by-Subject Mastery, Earned Badges, and Quiz History Statistics.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentProfileScreen(
    viewModel: QuizViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    val userProfile by viewModel.userProfile.collectAsState()
    val authState by viewModel.authUiState.collectAsState()
    val progressList by viewModel.unitProgressList.collectAsState()
    val historicalScores by viewModel.historicalScores.collectAsState()
    val cloudSyncState by viewModel.cloudSyncState.collectAsState()
    val isAvatarUploading by viewModel.isAvatarUploading.collectAsState()
    val isFirestoreOffline by viewModel.isFirestoreOffline.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()

    // Dialog & navigation state
    var showAuthDialog by remember { mutableStateOf(false) }
    var showEditProfileDialog by remember { mutableStateOf(false) }
    var showPhotoOptionsDialog by remember { mutableStateOf(false) }
    var selectedBadgeDetail by remember { mutableStateOf<Pair<BadgeDefinition, BadgeProgress>?>(null) }
    var selectedHistoryFilter by remember { mutableStateOf("all") }
    var selectedBadgeFilter by remember { mutableStateOf("all") } // "all", "earned", "in_progress"

    BackHandler {
        onNavigateBack()
    }

    // Photo picker launcher (zero permissions, Google Play compliant)
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            coroutineScope.launch {
                try {
                    val bytes = withContext(Dispatchers.IO) {
                        context.contentResolver.openInputStream(uri)?.use { inputStream ->
                            val bitmap = BitmapFactory.decodeStream(inputStream)
                            if (bitmap != null) {
                                // Scale down if larger than 640px to ensure fast upload
                                val maxDimension = 640
                                val scale = (maxDimension.toFloat() / maxOf(bitmap.width, bitmap.height)).coerceAtMost(1f)
                                val scaled = if (scale < 1f) {
                                    Bitmap.createScaledBitmap(
                                        bitmap,
                                        (bitmap.width * scale).toInt(),
                                        (bitmap.height * scale).toInt(),
                                        true
                                    )
                                } else bitmap

                                val outputStream = ByteArrayOutputStream()
                                scaled.compress(Bitmap.CompressFormat.JPEG, 85, outputStream)
                                outputStream.toByteArray()
                            } else null
                        }
                    }

                    if (bytes != null && bytes.isNotEmpty()) {
                        Toast.makeText(context, "Uploading profile photo to Firebase Storage...", Toast.LENGTH_SHORT).show()
                        viewModel.uploadStudentAvatar(bytes) { result ->
                            if (result.isSuccess) {
                                Toast.makeText(context, "✅ Profile photo updated!", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Storage upload note: ${result.exceptionOrNull()?.message ?: "Saved"}", Toast.LENGTH_LONG).show()
                            }
                        }
                    } else {
                        Toast.makeText(context, "Unable to read chosen image", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "Error processing image: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Evaluate all badges against profile & progress
    val evaluatedBadges = remember(userProfile, progressList) {
        val prof = userProfile ?: UserProfile()
        BadgeSystem.allBadges.map { badge ->
            val prog = badge.evaluate(prof, progressList)
            badge to prog
        }
    }

    val earnedBadgesCount = evaluatedBadges.count { it.second.isUnlocked }
    val totalBadgesCount = evaluatedBadges.size

    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .testTag("student_profile_screen"),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🎓", fontSize = 22.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Student Profile",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack,
                        modifier = Modifier.testTag("profile_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    // Quick Cloud Sync button
                    val isSyncing = cloudSyncState is CloudSyncState.Syncing
                    IconButton(
                        onClick = {
                            viewModel.syncWithFirestore()
                            Toast.makeText(context, "🔄 Synchronizing with Firebase Firestore...", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.testTag("profile_cloud_sync_button")
                    ) {
                        val rotation by animateFloatAsState(
                            targetValue = if (isSyncing) 360f else 0f,
                            animationSpec = if (isSyncing) infiniteRepeatable(tween(1000, easing = LinearEasing)) else spring(),
                            label = "syncRotation"
                        )
                        Icon(
                            imageVector = Icons.Default.Sync,
                            contentDescription = "Sync with Firebase",
                            tint = if (isSyncing) Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Firebase Auth Account Button
                    IconButton(
                        onClick = { showAuthDialog = true },
                        modifier = Modifier.testTag("profile_auth_button")
                    ) {
                        Icon(
                            imageVector = if (authState is AuthUiState.Authenticated) Icons.Default.AccountCircle else Icons.Default.VpnKey,
                            contentDescription = "Firebase Account",
                            tint = if (authState is AuthUiState.Authenticated) Color(0xFF10B981) else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val profile = userProfile ?: UserProfile()

            // ========================================================
            // 1. HERO PROFILE & FIREBASE STORAGE PHOTO CARD
            // ========================================================
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("profile_hero_card"),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Avatar Photo with Firebase Storage integration
                        Box(
                            contentAlignment = Alignment.BottomEnd,
                            modifier = Modifier
                                .size(84.dp)
                                .clickable { showPhotoOptionsDialog = true }
                                .testTag("profile_avatar_picker_box")
                        ) {
                            if (profile.avatar.startsWith("http://") || profile.avatar.startsWith("https://")) {
                                // Remote photo loaded from Firebase Storage
                                SubcomposeAsyncImage(
                                    model = profile.avatar,
                                    contentDescription = "Profile Photo from Firebase Storage",
                                    contentScale = ContentScale.Crop,
                                    loading = {
                                        Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            CircularProgressIndicator(strokeWidth = 2.dp, modifier = Modifier.size(24.dp))
                                        }
                                    },
                                    error = {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(Color(0xFFE0E7FF)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("🎓", fontSize = 34.sp)
                                        }
                                    },
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(CircleShape)
                                        .border(2.5.dp, Color(0xFF4F46E5), CircleShape)
                                )
                            } else {
                                // Illustrated Character Avatar from AvatarCatalog
                                val illustration = AvatarCatalog.getAvatarById(profile.avatar)
                                StudentAvatarBadge(
                                    avatar = illustration,
                                    size = 80.dp,
                                    showRing = true
                                )
                            }

                            // Camera / Edit Overlay Badge
                            Box(
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF4F46E5))
                                    .border(2.dp, MaterialTheme.colorScheme.surface, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CameraAlt,
                                    contentDescription = "Change Photo via Firebase Storage",
                                    tint = Color.White,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = profile.name,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                IconButton(
                                    onClick = { showEditProfileDialog = true },
                                    modifier = Modifier
                                        .size(28.dp)
                                        .testTag("profile_edit_name_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit Profile Info",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }

                            Text(
                                text = "✨ @${profile.nickname.ifBlank { "StarScholar" }}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            // Standard / Class Tag & Attendance Streak
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val stdName = when (profile.standard) {
                                    11 -> "Morarji Entrance"
                                    12 -> "NMMS Scholarship"
                                    else -> "Class ${profile.standard}"
                                }
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFF4F46E5).copy(alpha = 0.12f),
                                    border = BorderStroke(1.dp, Color(0xFF4F46E5).copy(alpha = 0.3f))
                                ) {
                                    Text(
                                        text = "📚 $stdName",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF4F46E5),
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }

                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFEA580C).copy(alpha = 0.12f),
                                    border = BorderStroke(1.dp, Color(0xFFEA580C).copy(alpha = 0.3f))
                                ) {
                                    Text(
                                        text = "🔥 ${profile.attendanceStreak}d Streak",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFEA580C),
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }
                        }
                    }

                    if (isAvatarUploading) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "Uploading avatar to Firebase Storage...",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(4.dp)
                                    .clip(RoundedCornerShape(2.dp))
                            )
                        }
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                    // Firebase Auth & Cloud Sync Status Row
                    val authUser = (authState as? AuthUiState.Authenticated)?.user
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (authUser != null) Color(0xFF10B981).copy(alpha = 0.08f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        border = BorderStroke(1.dp, if (authUser != null) Color(0xFF10B981).copy(alpha = 0.25f) else MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = if (authUser != null) "🟢 Firebase Auth: Connected" else "🟡 Firebase: Local / Guest Session",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = if (authUser != null) Color(0xFF047857) else MaterialTheme.colorScheme.onSurface
                                    )
                                }
                                Text(
                                    text = if (authUser != null) {
                                        authUser.email ?: authUser.displayName ?: "UID: ${authUser.uid.take(12)}..."
                                    } else {
                                        "Sign in with Google to sync progress across devices"
                                    },
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (authUser != null) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = {
                                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                            clipboard.setPrimaryClip(ClipData.newPlainText("Firebase UID", authUser.uid))
                                            Toast.makeText(context, "UID copied to clipboard", Toast.LENGTH_SHORT).show()
                                        },
                                        modifier = Modifier.size(32.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.ContentCopy,
                                            contentDescription = "Copy UID",
                                            tint = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                    IconButton(
                                        onClick = {
                                            viewModel.signOutFromApp()
                                            Toast.makeText(context, "Signed out. Switching account...", Toast.LENGTH_SHORT).show()
                                        },
                                        modifier = Modifier.size(32.dp).testTag("profile_sign_out_button")
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                            contentDescription = "Sign Out / Switch Role",
                                            tint = Color(0xFFEF4444),
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                            } else {
                                Button(
                                    onClick = { showAuthDialog = true },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                    modifier = Modifier.testTag("profile_connect_account_button")
                                ) {
                                    Text("Sign In", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }

                    // Register Another Student Quick Action Button (shifted to its own distinct line in card)
                    OutlinedButton(
                        onClick = {
                            viewModel.signOutFromApp()
                            Toast.makeText(context, "Switching to Student Registration (ಹೊಸ ವಿದ್ಯಾರ್ಥಿ ನೋಂದಣಿ)", Toast.LENGTH_SHORT).show()
                        },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color(0xFF4F46E5)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("profile_register_another_student_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null,
                            tint = Color(0xFF4F46E5),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "➕ Register Another Student (ಹೊಸ ವಿದ್ಯಾರ್ಥಿ ನೋಂದಣಿ)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4F46E5)
                        )
                    }
                }
            }

            // ========================================================
            // 2. LEARNING PROGRESS & STATS SUMMARY (CURRICULUM)
            // ========================================================
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("profile_progress_card"),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
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
                            Text("📊", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Curriculum Progress",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = titleColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // Firestore Persistence Status
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (!isFirestoreOffline) Color(0xFF10B981).copy(alpha = 0.12f) else Color(0xFFF59E0B).copy(alpha = 0.12f)
                        ) {
                            Text(
                                text = if (!isFirestoreOffline) "☁️ Live" else "💾 Offline",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (!isFirestoreOffline) Color(0xFF047857) else Color(0xFFB45309),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // 4-Pill Metric Summary
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ProfileMetricPill(
                            icon = "⚡",
                            value = "${profile.xp} XP",
                            label = "Experience",
                            color = Color(0xFF6366F1),
                            modifier = Modifier.weight(1f)
                        )
                        ProfileMetricPill(
                            icon = "🪙",
                            value = "${profile.coins}",
                            label = "Coins Earned",
                            color = Color(0xFFD97706),
                            modifier = Modifier.weight(1f)
                        )
                        ProfileMetricPill(
                            icon = "⭐",
                            value = "${profile.stars}",
                            label = "Stars",
                            color = Color(0xFFEAB308),
                            modifier = Modifier.weight(1f)
                        )
                        ProfileMetricPill(
                            icon = "🏆",
                            value = "${profile.totalPoints}",
                            label = "Total Points",
                            color = Color(0xFF10B981),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    // Level calculation
                    val level = (profile.xp / 500) + 1
                    val currentLevelProgress = (profile.xp % 500).toFloat() / 500f
                    val animatedLevelProgress by animateFloatAsState(
                        targetValue = currentLevelProgress,
                        animationSpec = tween(700),
                        label = "levelProgress"
                    )

                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Scholar Level $level",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "${profile.xp % 500} / 500 XP to Level ${level + 1}",
                                    fontSize = 11.sp,
                                    color = subtitleColor
                                )
                            }
                            LinearProgressIndicator(
                                progress = { animatedLevelProgress },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(4.dp)),
                                color = Color(0xFF4F46E5),
                                trackColor = MaterialTheme.colorScheme.outlineVariant
                            )
                        }
                    }

                    // Subject Breakdown
                    val standardTemplate = QuizStaticData.standardsList.find { it.std == profile.standard }
                    if (standardTemplate != null) {
                        Text(
                            text = "Subject Mastery Breakdown (${standardTemplate.name})",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = subtitleColor
                        )

                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            standardTemplate.subjects.forEach { subject ->
                                val unitsForSubject = progressList.filter {
                                    it.stdId == profile.standard && it.subjectId.equals(subject.id, ignoreCase = true)
                                }
                                val completedUnits = unitsForSubject.count { it.progress >= 100 }
                                val totalUnits = subject.units.size
                                val avgProgress = if (totalUnits > 0) {
                                    (completedUnits.toFloat() / totalUnits).coerceIn(0f, 1f)
                                } else 0f

                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.surface,
                                    border = BorderStroke(1.dp, Color(subject.colorHex).copy(alpha = 0.25f)),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 12.dp, vertical = 9.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(10.dp)
                                                    .clip(CircleShape)
                                                    .background(Color(subject.colorHex))
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = subject.title,
                                                    fontSize = 12.5.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = titleColor,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                                Text(
                                                    text = "$completedUnits / $totalUnits Mastered",
                                                    fontSize = 10.5.sp,
                                                    color = subtitleColor,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.width(8.dp))

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            LinearProgressIndicator(
                                                progress = { avgProgress },
                                                modifier = Modifier
                                                    .width(60.dp)
                                                    .height(6.dp)
                                                    .clip(RoundedCornerShape(3.dp)),
                                                color = Color(subject.colorHex),
                                                trackColor = Color(subject.colorHex).copy(alpha = 0.15f)
                                            )
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "${(avgProgress * 100).toInt()}%",
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(subject.colorHex),
                                                maxLines = 1,
                                                softWrap = false
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // ========================================================
            // 3. EARNED BADGES & MERIT REWARDS SECTION
            // ========================================================
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("profile_badges_card"),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
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
                            Text("🏅", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Merit Badges",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = titleColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFF59E0B).copy(alpha = 0.15f),
                            border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.35f))
                        ) {
                            Text(
                                text = "$earnedBadgesCount / $totalBadgesCount",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFD97706),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // Filter Chips: All, Earned Only, In Progress
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        FilterChip(
                            selected = selectedBadgeFilter == "all",
                            onClick = { selectedBadgeFilter = "all" },
                            label = { Text("All ($totalBadgesCount)", fontSize = 11.sp) },
                            modifier = Modifier.testTag("badge_filter_all")
                        )
                        FilterChip(
                            selected = selectedBadgeFilter == "earned",
                            onClick = { selectedBadgeFilter = "earned" },
                            label = { Text("🏆 Unlocked ($earnedBadgesCount)", fontSize = 11.sp) },
                            modifier = Modifier.testTag("badge_filter_earned")
                        )
                        FilterChip(
                            selected = selectedBadgeFilter == "in_progress",
                            onClick = { selectedBadgeFilter = "in_progress" },
                            label = { Text("⏳ In Progress (${totalBadgesCount - earnedBadgesCount})", fontSize = 11.sp) },
                            modifier = Modifier.testTag("badge_filter_in_progress")
                        )
                    }

                    val filteredBadges = evaluatedBadges.filter { (_, prog) ->
                        when (selectedBadgeFilter) {
                            "earned" -> prog.isUnlocked
                            "in_progress" -> !prog.isUnlocked
                            else -> true
                        }
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        filteredBadges.forEach { (badge, progress) ->
                            BadgeItemRow(
                                badge = badge,
                                progress = progress,
                                isDark = isDark,
                                onClick = { selectedBadgeDetail = badge to progress }
                            )
                        }
                    }
                }
            }

            // ========================================================
            // 4. QUIZ HISTORY & ATTEMPT STATISTICS
            // ========================================================
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("profile_history_card"),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
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
                            Text("📜", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Quiz History",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = titleColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF4F46E5).copy(alpha = 0.12f)
                        ) {
                            Text(
                                text = "${historicalScores.size} Attempts",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4F46E5),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // History Statistical KPIs
                    val avgAccuracy = if (historicalScores.isNotEmpty()) {
                        historicalScores.map { it.accuracyPercentage }.average().toInt()
                    } else 0
                    val bestScore = historicalScores.maxOfOrNull { it.score } ?: 0
                    val perfectQuizzes = historicalScores.count { it.accuracyPercentage == 100 }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ProfileMetricPill(
                            icon = "🎯",
                            value = "$avgAccuracy%",
                            label = "Avg Accuracy",
                            color = if (avgAccuracy >= 80) Color(0xFF10B981) else Color(0xFF4F46E5),
                            modifier = Modifier.weight(1f)
                        )
                        ProfileMetricPill(
                            icon = "⭐",
                            value = "$bestScore Pts",
                            label = "High Score",
                            color = Color(0xFFD97706),
                            modifier = Modifier.weight(1f)
                        )
                        ProfileMetricPill(
                            icon = "💯",
                            value = "$perfectQuizzes",
                            label = "Perfect 100%",
                            color = Color(0xFF059669),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    if (historicalScores.isEmpty()) {
                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text("🎯", fontSize = 32.sp)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "No Quiz Attempts Recorded Yet",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Take practice quizzes to build your learning history & statistics!",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = subtitleColor,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    } else {
                        val dateFormat = remember { SimpleDateFormat("dd MMM, hh:mm a", Locale.getDefault()) }

                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            historicalScores.take(15).forEach { scoreEntity ->
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.surface,
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Surface(
                                                    shape = RoundedCornerShape(6.dp),
                                                    color = Color(0xFF4F46E5).copy(alpha = 0.12f)
                                                ) {
                                                    Text(
                                                        text = scoreEntity.subjectId.uppercase(),
                                                        fontSize = 9.5.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = Color(0xFF4F46E5),
                                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                                        maxLines = 1,
                                                        softWrap = false
                                                    )
                                                }
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = scoreEntity.unitName,
                                                    fontSize = 12.5.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = titleColor,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis,
                                                    modifier = Modifier.weight(1f, fill = false)
                                                )
                                            }

                                            Spacer(modifier = Modifier.height(4.dp))

                                            Text(
                                                text = "⏱️ ${dateFormat.format(Date(scoreEntity.completedAt))} • ${if (scoreEntity.isPassed) "✅ Passed" else "Needs Review"}",
                                                fontSize = 10.5.sp,
                                                color = subtitleColor
                                            )
                                        }

                                        Surface(
                                            shape = RoundedCornerShape(8.dp),
                                            color = when {
                                                scoreEntity.accuracyPercentage >= 80 -> Color(0xFF10B981).copy(alpha = 0.15f)
                                                scoreEntity.accuracyPercentage >= 50 -> Color(0xFFF59E0B).copy(alpha = 0.15f)
                                                else -> Color(0xFFEF4444).copy(alpha = 0.15f)
                                            }
                                        ) {
                                            Column(
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                                horizontalAlignment = Alignment.End
                                            ) {
                                                Text(
                                                    text = "${scoreEntity.accuracyPercentage}%",
                                                    fontWeight = FontWeight.ExtraBold,
                                                    fontSize = 12.sp,
                                                    color = when {
                                                        scoreEntity.accuracyPercentage >= 80 -> Color(0xFF047857)
                                                        scoreEntity.accuracyPercentage >= 50 -> Color(0xFFB45309)
                                                        else -> Color(0xFFB91C1C)
                                                    }
                                                )
                                                Text(
                                                    text = "${scoreEntity.score}/${scoreEntity.totalQuestions} pts",
                                                    fontSize = 9.5.sp,
                                                    color = subtitleColor
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    // ========================================================
    // DIALOGS: Photo Picker, Name/Grade Edit, Badge Details, Auth
    // ========================================================

    // 1. Photo Picker Choice Dialog (Storage Upload vs Character Avatar)
    if (showPhotoOptionsDialog) {
        Dialog(onDismissRequest = { showPhotoOptionsDialog = false }) {
            Surface(
                shape = RoundedCornerShape(22.dp),
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Customize Profile Photo",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Upload a photo to Firebase Cloud Storage, or choose an illustrated scholar avatar.",
                        style = MaterialTheme.typography.bodySmall,
                        color = subtitleColor
                    )

                    // Option A: Upload via Firebase Storage
                    Button(
                        onClick = {
                            showPhotoOptionsDialog = false
                            photoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("upload_photo_storage_button")
                    ) {
                        Icon(Icons.Default.CloudUpload, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Upload Photo (Firebase Storage)", fontWeight = FontWeight.Bold)
                    }

                    // Option B: Choose Character Avatar from catalog
                    OutlinedButton(
                        onClick = {
                            showPhotoOptionsDialog = false
                            showEditProfileDialog = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("choose_avatar_catalog_button")
                    ) {
                        Icon(Icons.Default.Palette, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Choose Character Avatar", fontWeight = FontWeight.Bold)
                    }

                    TextButton(
                        onClick = { showPhotoOptionsDialog = false },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Cancel")
                    }
                }
            }
        }
    }

    // 2. Edit Profile Details Dialog (Name, Nickname, Standard)
    if (showEditProfileDialog) {
        val currentProfile = userProfile ?: UserProfile()
        var editName by remember { mutableStateOf(currentProfile.name) }
        var editNickname by remember { mutableStateOf(currentProfile.nickname) }
        var editStd by remember { mutableIntStateOf(currentProfile.standard) }
        var selectedAvatarId by remember { mutableStateOf(currentProfile.avatar) }

        Dialog(onDismissRequest = { showEditProfileDialog = false }) {
            Surface(
                shape = RoundedCornerShape(22.dp),
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Edit Student Profile",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedTextField(
                        value = editName,
                        onValueChange = { editName = it },
                        label = { Text("Full Name") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("edit_name_input")
                    )

                    OutlinedTextField(
                        value = editNickname,
                        onValueChange = { editNickname = it },
                        label = { Text("Scholar Nickname") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("edit_nickname_input")
                    )

                    // Grade Selector
                    Text("Select Active Standard / Grade", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        listOf(6, 7, 8, 9, 10, 11, 12).forEach { stdNum ->
                            val label = when (stdNum) {
                                11 -> "Morarji"
                                12 -> "NMMS"
                                else -> "Std $stdNum"
                            }
                            FilterChip(
                                selected = editStd == stdNum,
                                onClick = { editStd = stdNum },
                                label = { Text(label, fontSize = 11.sp) }
                            )
                        }
                    }

                    // Avatar Selection from catalog
                    Text("Choose Scholar Avatar", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        AvatarCatalog.allAvatars.forEach { avatar ->
                            val isSelected = selectedAvatarId == avatar.id
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(Color(avatar.primaryColorHex).copy(alpha = if (isSelected) 0.35f else 0.1f))
                                    .border(
                                        width = if (isSelected) 2.5.dp else 1.dp,
                                        color = if (isSelected) Color(avatar.primaryColorHex) else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .clickable { selectedAvatarId = avatar.id },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(avatar.emoji, fontSize = 24.sp)
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { showEditProfileDialog = false }) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {
                                viewModel.updateStudentNameAndGrade(editName, editStd)
                                viewModel.updateStudentProfile(selectedAvatarId, editNickname)
                                showEditProfileDialog = false
                                Toast.makeText(context, "✅ Profile updated and synced to Firestore", Toast.LENGTH_SHORT).show()
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.testTag("save_profile_button")
                        ) {
                            Text("Save Changes")
                        }
                    }
                }
            }
        }
    }

    // 3. Badge Detail Dialog
    selectedBadgeDetail?.let { (badge, progress) ->
        BadgeDetailDialog(
            badge = badge,
            progress = progress,
            isDark = isDark,
            onDismiss = { selectedBadgeDetail = null },
            onShare = {
                try {
                    val sendIntent = android.content.Intent().apply {
                        action = android.content.Intent.ACTION_SEND
                        putExtra(
                            android.content.Intent.EXTRA_TEXT,
                            "🎓 I unlocked the ${badge.title} badge in School Quiz! ${badge.emoji}\nCriteria: ${badge.criteria}"
                        )
                        type = "text/plain"
                    }
                    context.startActivity(android.content.Intent.createChooser(sendIntent, "Share Badge"))
                } catch (e: Exception) {
                    Toast.makeText(context, "Badge shared: ${badge.title}!", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    // 4. Firebase Authentication Dialog
    if (showAuthDialog) {
        AuthDialog(
            viewModel = viewModel,
            onDismiss = { showAuthDialog = false }
        )
    }
}

/**
 * Metric Pill for quick stats
 */
@Composable
private fun ProfileMetricPill(
    icon: String,
    value: String,
    label: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = color.copy(alpha = 0.08f),
        border = BorderStroke(1.dp, color.copy(alpha = 0.25f)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(icon, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
                color = color,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = label,
                fontSize = 8.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Single Badge row item in the Badges showcase
 */
@Composable
private fun BadgeItemRow(
    badge: BadgeDefinition,
    progress: BadgeProgress,
    isDark: Boolean,
    onClick: () -> Unit
) {
    val badgeColor = Color(badge.colorHex)
    val rarityColor = when (badge.rarity) {
        "Legendary" -> Color(0xFFFFB300)
        "Epic" -> Color(0xFF9333EA)
        "Rare" -> Color(0xFF3B82F6)
        else -> Color(0xFF10B981)
    }

    Surface(
        shape = RoundedCornerShape(12.dp),
        color = if (progress.isUnlocked)
            MaterialTheme.colorScheme.surface
        else
            MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
        border = BorderStroke(
            1.dp,
            if (progress.isUnlocked)
                badgeColor.copy(alpha = 0.45f)
            else
                MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("badge_row_${badge.id}")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Central Emoji Icon
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(
                        if (progress.isUnlocked)
                            badgeColor.copy(alpha = 0.15f)
                        else
                            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.25f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (progress.isUnlocked) badge.emoji else "🔒",
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = badge.title,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (progress.isUnlocked)
                            MaterialTheme.colorScheme.onSurface
                        else
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = rarityColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "${badge.rarity} • ${badge.category.title}",
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = rarityColor,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.5.dp),
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = badge.description,
                    fontSize = 10.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            if (progress.isUnlocked) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF10B981).copy(alpha = 0.15f)
                ) {
                    Text(
                        text = "Unlocked",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF047857),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.5.dp),
                        maxLines = 1,
                        softWrap = false
                    )
                }
            } else {
                Text(
                    text = "${progress.current}/${progress.target}",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    softWrap = false
                )
            }
        }
    }
}

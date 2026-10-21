@file:OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)

package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import com.example.QuizViewModel
import com.example.data.*
import com.example.ui.common.OfflineModeSyncBanner
import com.example.ui.home.Translator
import com.example.ui.settings.DailyReminderSettingsCard
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: QuizViewModel,
    dashboardViewModel: StudentDashboardViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = StudentDashboardViewModelFactory(viewModel.repository)
    ),
    modifier: Modifier = Modifier,
    onStartQuiz: (stdId: Int, subjectId: String, unitId: Int, unitName: String) -> Unit = { std, sub, uid, uname ->
        viewModel.startQuiz(std, sub, uid, uname)
    }
) {
    val context = LocalContext.current
    val userProfile by viewModel.userProfile.collectAsState()
    val progressList by viewModel.unitProgressList.collectAsState()
    val dashboardUiState by dashboardViewModel.uiState.collectAsState()
    val recommendations by viewModel.recommendedQuizzes.collectAsState()
    val weakAreaTopics by viewModel.weakAreaTopics.collectAsState()
    val currentLang by viewModel.currentLanguage.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val bookmarkedQuestions by viewModel.bookmarkedQuestions.collectAsState()
    val historicalScores by viewModel.historicalScores.collectAsState()
    val cloudSyncState by viewModel.cloudSyncState.collectAsState()
    val profileStatus by viewModel.profileUpdateStatus.collectAsState()
    val downloadedQuizzes by viewModel.downloadedQuizzes.collectAsState()
    val isFirestoreOffline by viewModel.isFirestoreOffline.collectAsState()
    val isFirestorePersistenceActive by viewModel.isFirestorePersistenceActive.collectAsState()
    val isForcedOffline by viewModel.isForcedOfflineMode.collectAsState()
    var selectedTab by remember { mutableIntStateOf(0) } // 0 = Overview, 1 = Analytics & Charts, 2 = Badges, 3 = Saved, 4 = History
    var selectedBadgeDetail by remember { mutableStateOf<Pair<BadgeDefinition, BadgeProgress>?>(null) }
    var showEditProfileDialog by remember { mutableStateOf(false) }
    var showShareDialog by remember { mutableStateOf(false) }
    var showPdfExportDialog by remember { mutableStateOf(false) }
    var showOfflineManagerDialog by remember { mutableStateOf(false) }
    var showBulkUploadDialog by remember { mutableStateOf(false) }
    var activeMilestoneCelebration by remember { mutableStateOf<MilestoneType?>(null) }
    var hasCelebratedStreak7 by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    LaunchedEffect(userProfile?.attendanceStreak) {
        val streak = userProfile?.attendanceStreak ?: 0
        if (streak >= 7 && !hasCelebratedStreak7) {
            hasCelebratedStreak7 = true
            activeMilestoneCelebration = MilestoneType.SEVEN_DAY_STREAK
        }
    }

    LaunchedEffect(profileStatus) {
        profileStatus?.let { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            viewModel.clearProfileUpdateStatus()
        }
    }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9))

    val unlockedBadgesCount = remember(userProfile, progressList) {
        userProfile?.let { prof ->
            BadgeSystem.allBadges.count { it.evaluate(prof, progressList).isUnlocked }
        } ?: 0
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Dashboard Title Header with Firestore Persistence Status Pill
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = Translator.translate("dashboard", currentLang),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = titleColor,
                modifier = Modifier
                    .weight(1f, fill = false)
                    .testTag("dashboard_title")
            )

            Spacer(modifier = Modifier.width(8.dp))

            FirestorePersistenceStatusPill(
                isOffline = isFirestoreOffline,
                isPersistenceActive = isFirestorePersistenceActive,
                isDark = isDark,
                onClick = { viewModel.toggleFirestoreOfflineMode() },
                modifier = Modifier.testTag("dashboard_firestore_persistence_pill")
            )
        }

        // Dedicated Visual Indicator: Shows when app is working in offline mode due to Firestore persistence setting
        FirestorePersistenceOfflineIndicator(
            isOffline = isFirestoreOffline,
            isPersistenceActive = isFirestorePersistenceActive,
            isForcedOffline = isForcedOffline,
            isDark = isDark,
            onToggleOfflineMode = { viewModel.toggleFirestoreOfflineMode() },
            onSyncNow = { viewModel.syncWithFirestore() },
            modifier = Modifier.testTag("dashboard_firestore_offline_indicator")
        )

        userProfile?.let { profile ->
            val avatarIllustration = AvatarCatalog.getAvatarById(profile.avatar)

            // Aligned Student Header Card with Avatar Illustration & Custom Nickname
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("dashboard_student_header"),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Clickable Avatar Illustration Badge with Edit Icon Indicator
                        Box(
                            modifier = Modifier
                                .clickable { showEditProfileDialog = true }
                                .testTag("student_avatar_badge_button"),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            StudentAvatarBadge(
                                avatar = avatarIllustration,
                                size = 52.dp,
                                showRing = true
                            )
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primary)
                                    .border(1.5.dp, MaterialTheme.colorScheme.surface, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Edit Avatar & Nickname",
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(11.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { showEditProfileDialog = true },
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = profile.nickname.ifBlank { profile.name },
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f, fill = false)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(avatarIllustration.secondaryEmoji, fontSize = 14.sp)
                            }
                            Spacer(modifier = Modifier.height(2.dp))
                            // Horizontal row showing details on one line with clear separation
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val stdDisplay = when (profile.standard) {
                                    11 -> "Morarji"
                                    12 -> "NMMS"
                                    else -> "${Translator.translate("std", currentLang)} ${profile.standard}"
                                }
                                Text(
                                    text = "${profile.name} • $stdDisplay",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Medium,
                                    color = subtitleColor,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f, fill = false)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "• ${avatarIllustration.name}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(avatarIllustration.primaryColorHex),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(6.dp))

                        // Compact Quick Action Icons Row with guaranteed spacing
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            // Share Achievements Button
                            IconButton(
                                onClick = { showShareDialog = true },
                                modifier = Modifier
                                    .size(34.dp)
                                    .testTag("dashboard_share_achievements_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = "Share Achievements to Social Media",
                                    tint = Color(0xFF6366F1),
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            // Export PDF Report Button
                            IconButton(
                                onClick = { showPdfExportDialog = true },
                                modifier = Modifier
                                    .size(34.dp)
                                    .testTag("dashboard_export_pdf_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PictureAsPdf,
                                    contentDescription = "Export & Share PDF Report",
                                    tint = Color(0xFFEF4444),
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            // Edit Profile / Avatar Button
                            IconButton(
                                onClick = { showEditProfileDialog = true },
                                modifier = Modifier
                                    .size(34.dp)
                                    .testTag("edit_student_profile_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Palette,
                                    contentDescription = "Customize Avatar & Nickname",
                                    tint = Color(avatarIllustration.primaryColorHex),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Prominent Student Level & Quiz Rank Badges (Responsive layout preventing overlap)
                    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                        if (maxWidth < 360.dp) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                StudentLevelCompactBadge(
                                    levelInfo = dashboardUiState.studentLevel,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                QuizRankCompactBadge(
                                    rankInfo = dashboardUiState.quizRank,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        } else {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                StudentLevelCompactBadge(
                                    levelInfo = dashboardUiState.studentLevel,
                                    modifier = Modifier.weight(1f)
                                )
                                QuizRankCompactBadge(
                                    rankInfo = dashboardUiState.quizRank,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }
            }

            // Edit Profile & Avatar Dialog
            if (showEditProfileDialog) {
                EditProfileDialog(
                    userProfile = profile,
                    onDismissRequest = { showEditProfileDialog = false },
                    onSaveProfile = { avatarId, nickname ->
                        showEditProfileDialog = false
                        viewModel.updateStudentProfile(avatarId, nickname)
                    }
                )
            }

            // Quick Action Row: Offline Sync Indicator & Export Report
            OfflineModeSyncBanner(
                cloudSyncState = cloudSyncState,
                isDark = isDark,
                onSyncNow = { viewModel.syncWithFirestore() },
                modifier = Modifier.testTag("dashboard_offline_sync_banner")
            )

            // Direct Quick Action Shortcuts (PDF Export + Social Share + Bulk Upload)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { showPdfExportDialog = true },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quick_export_pdf_button"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                ) {
                    Icon(Icons.Default.PictureAsPdf, contentDescription = null, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("PDF 📄", fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }

                Button(
                    onClick = { showShareDialog = true },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quick_share_achievements_button"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6366F1)),
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                ) {
                    Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Share 🚀", fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }

                Button(
                    onClick = { showBulkUploadDialog = true },
                    modifier = Modifier
                        .weight(1.1f)
                        .testTag("quick_bulk_upload_button"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                ) {
                    Icon(Icons.Default.CloudUpload, contentDescription = null, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Upload 📥", fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }

            // Profile Tabs: Overview vs Analytics vs Badges vs Saved Questions vs History
            ScrollableTabRow(
                selectedTabIndex = selectedTab,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .testTag("dashboard_profile_tabs"),
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary,
                edgePadding = 8.dp
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = {
                        Text(
                            text = "📊 ${Translator.translate("overview", currentLang)}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    },
                    modifier = Modifier.testTag("profile_tab_overview")
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = {
                        Text(
                            text = "📈 Analytics & Trends",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    },
                    modifier = Modifier.testTag("profile_tab_analytics")
                )
                Tab(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "🏆 ${Translator.translate("badges", currentLang)}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Badge(
                                containerColor = Color(0xFFFFB300).copy(alpha = 0.2f),
                                contentColor = if (isDark) Color(0xFFFFD54F) else Color(0xFFB45309)
                            ) {
                                Text(
                                    text = "$unlockedBadgesCount/${BadgeSystem.allBadges.size}",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 11.sp
                                )
                            }
                        }
                    },
                    modifier = Modifier.testTag("profile_tab_badges")
                )
                Tab(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "🔖 ${Translator.translate("saved_questions", currentLang)}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                            if (bookmarkedQuestions.isNotEmpty()) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Badge(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                ) {
                                    Text(
                                        text = bookmarkedQuestions.size.toString(),
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 11.sp
                                    )
                                }
                            }
                        }
                    },
                    modifier = Modifier.testTag("profile_tab_saved_questions")
                )
                Tab(
                    selected = selectedTab == 4,
                    onClick = { selectedTab = 4 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "📜 History",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                            if (historicalScores.isNotEmpty()) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Badge(
                                    containerColor = Color(0xFF6366F1).copy(alpha = 0.2f),
                                    contentColor = if (isDark) Color(0xFFA5B4FC) else Color(0xFF4338CA)
                                ) {
                                    Text(
                                        text = historicalScores.size.toString(),
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 11.sp
                                    )
                                }
                            }
                        }
                    },
                    modifier = Modifier.testTag("profile_tab_history")
                )
            }

            AnimatedContent(
                targetState = selectedTab,
                transitionSpec = {
                    val direction = if (targetState > initialState) 1 else -1
                    (slideInHorizontally(
                        animationSpec = spring(dampingRatio = 0.85f, stiffness = Spring.StiffnessMediumLow),
                        initialOffsetX = { fullWidth -> direction * (fullWidth / 4) }
                    ) + fadeIn(animationSpec = tween(220))) togetherWith
                    (slideOutHorizontally(
                        animationSpec = tween(180),
                        targetOffsetX = { fullWidth -> -direction * (fullWidth / 4) }
                    ) + fadeOut(animationSpec = tween(160)))
                },
                label = "dashboard_tab_transition"
            ) { tabIndex ->
                when (tabIndex) {
                    0 -> {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            // 0. FLEXIBLE RESPONSIVE GRID SYSTEM (LEVEL MARKERS + STREAK COUNTERS + PERFORMANCE CHARTS)
                            StudentDashboardFlexibleGrid(
                    levelInfo = dashboardUiState.studentLevel,
                    attendanceStreak = profile.attendanceStreak,
                    quizRank = dashboardUiState.quizRank,
                    overallAccuracy = dashboardUiState.overallAverageAccuracy,
                    passRate = dashboardUiState.passRatePercentage,
                    totalQuizzes = dashboardUiState.totalQuizzesAttempted,
                    totalXp = profile.xp,
                    performanceStats = dashboardUiState.weeklyPerformance,
                    isDark = isDark,
                    cardBorder = cardBorder,
                    onLevelClick = {
                        // Tapping level marker highlights level ladder
                    },
                    onStreakClick = {
                        activeMilestoneCelebration = if (profile.attendanceStreak >= 7) {
                            MilestoneType.SEVEN_DAY_STREAK
                        } else {
                            MilestoneType.TOP_TEN_PERCENT
                        }
                    },
                    onRankClick = {
                        // Tapping rank highlights tier info
                    },
                    onViewFullAnalytics = {
                        selectedTab = 1
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // 0.1. DETAILED STUDENT LEVEL & XP PROGRESSION LADDER CARD
                StudentLevelProgressionCard(
                    levelInfo = dashboardUiState.studentLevel,
                    isDark = isDark,
                    cardBorder = cardBorder,
                    modifier = Modifier.testTag("student_level_progression_card")
                )

                // 0.2. RESPONSIVE ACTION TILES (MILESTONES & OFFLINE ROOM STORAGE)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Milestones Celebration Card
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                activeMilestoneCelebration = if (profile.attendanceStreak >= 7) {
                                    MilestoneType.SEVEN_DAY_STREAK
                                } else {
                                    MilestoneType.TOP_TEN_PERCENT
                                }
                            }
                            .testTag("dashboard_milestone_showcase_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDark) Color(0xFF311042) else Color(0xFFFAF5FF)
                        ),
                        border = BorderStroke(1.dp, if (isDark) Color(0xFFA855F7) else Color(0xFFE9D5FF))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("🎉", fontSize = 20.sp)
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (profile.attendanceStreak >= 7) "7-Day Streak!" else "Milestones",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFF3E8FF) else Color(0xFF6B21A8),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Tap rewards 🎊",
                                    fontSize = 10.sp,
                                    color = if (isDark) Color(0xFFD8B4FE) else Color(0xFF9333EA),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }

                    // Offline Room DB Card
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { showOfflineManagerDialog = true }
                            .testTag("dashboard_offline_storage_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDark) Color(0xFF064E3B).copy(alpha = 0.5f) else Color(0xFFECFDF5)
                        ),
                        border = BorderStroke(1.dp, if (isDark) Color(0xFF059669) else Color(0xFFA7F3D0))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("💾", fontSize = 20.sp)
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "${downloadedQuizzes.size} Offline Quizzes",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF065F46),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Room DB Cache 📂",
                                    fontSize = 10.sp,
                                    color = if (isDark) Color(0xFF6EE7B7) else Color(0xFF047857),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }

            // 1b. ROOM DATABASE PERFORMANCE AGGREGATIONS & STATISTICS
            StudentAggregatedStatsView(
                uiState = dashboardUiState,
                isDark = isDark,
                onTimeRangeSelected = { dashboardViewModel.setTimeRangeFilter(it) },
                onStandardSelected = { dashboardViewModel.setStandardFilter(it) },
                onSubjectSelected = { dashboardViewModel.setSubjectFilter(it) }
            )

            // 2. DETAILED STATISTICS CARD
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp), // rounded-3xl
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = cardBorder
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "School Progress Overview",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor
                    )

                    HorizontalDivider(color = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9))

                    // School Rank Line
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Competition Class Rank:",
                            style = MaterialTheme.typography.bodyMedium,
                            color = subtitleColor,
                            modifier = Modifier.weight(1f, fill = false)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "👑 Rank #3 (Overall)",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFD97706) // amber-600
                        )
                    }

                    // Accumulated Level / Total XP
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total XP Level Points:",
                            style = MaterialTheme.typography.bodyMedium,
                            color = subtitleColor,
                            modifier = Modifier.weight(1f, fill = false)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "⚡ ${profile.xp} XP",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF7C3AED) // violet-600
                        )
                    }

                    // Attendance Streak Tracker
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Consecutive Daily Streak:",
                            style = MaterialTheme.typography.bodyMedium,
                            color = subtitleColor,
                            modifier = Modifier.weight(1f, fill = false)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "🔥 ${profile.attendanceStreak} Days Active",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFEA580C) // orange-600
                        )
                    }
                }
            }

            // 3. SUBJECT-WISE PERFORMANCE (EXPANDABLE SECTORS)
            Text(
                text = "Performance by subject",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = titleColor
            )

            // Compile representative list of subjects for Std selected
            val subjectsList = QuizStaticData.standardsList.find { it.std == profile.standard }?.subjects ?: emptyList()

            subjectsList.forEach { subj ->
                val progressForSubj = progressList.filter { it.stdId == profile.standard && it.subjectId == subj.id }
                val attemptedSubjCount = progressForSubj.count { it.progress > 0 }
                val avgSubjPercentage = if (attemptedSubjCount > 0) {
                    progressForSubj.filter { it.progress > 0 }.map { it.progress }.average().toInt()
                } else 0

                val color = Color(subj.colorHex)

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp), // rounded-3xl
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = cardBorder
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(16.dp)) // rounded-2xl
                                .background(color.copy(alpha = 0.12f)),
                            contentAlignment = Alignment.Center
                        ) {
                            val emoji = when (subj.id) {
                                "kannada" -> "📘"
                                "english" -> "📗"
                                "hindi" -> "📙"
                                "math" -> "📕"
                                "science" -> "📔"
                                "social" -> "📒"
                                "computer" -> "💻"
                                else -> "📚"
                            }
                            Text(emoji, fontSize = 20.sp)
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = subj.title,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor
                                )
                                Text(
                                    text = "$avgSubjPercentage%",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = color
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            LinearProgressIndicator(
                                progress = { avgSubjPercentage / 100f },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(6.dp)
                                    .clip(RoundedCornerShape(3.dp)),
                                color = color,
                                trackColor = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9)
                            )
                        }
                    }
                }
            }

            // 3.5. ADAPTIVE WEAK AREA RECOMMENDATION HUB (ROOM DATABASE STATS)
            WeakAreaRecommendationHub(
                recommendations = if (dashboardUiState.recommendations.isNotEmpty()) dashboardUiState.recommendations else recommendations,
                weakAreaTopics = if (dashboardUiState.weakAreaTopics.isNotEmpty()) dashboardUiState.weakAreaTopics else weakAreaTopics,
                isDark = isDark,
                onStartQuiz = onStartQuiz,
                modifier = Modifier.testTag("dashboard_weak_area_recommendation_section")
            )

            // Daily Practice Quiz Reminder Scheduler Card
            DailyReminderSettingsCard(
                modifier = Modifier.testTag("dashboard_daily_reminder_card")
            )

            // 3.8. TEACHER & FACULTY QUESTION MANAGEMENT PORTAL CARD
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("dashboard_teacher_portal_card"),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF134E4A).copy(alpha = 0.4f) else Color(0xFFF0FDF4)
                ),
                border = BorderStroke(1.dp, if (isDark) Color(0xFF0D9488) else Color(0xFFA7F3D0))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(34.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF0D9488).copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("📚", fontSize = 16.sp)
                            }
                            Column {
                                Text(
                                    text = "Teacher & Faculty Portal",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 13.5.sp,
                                    color = if (isDark) Color(0xFF5EEAD4) else Color(0xFF065F46),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Bulk Question Uploader • Classwise & Unitwise",
                                    fontSize = 10.5.sp,
                                    color = if (isDark) Color(0xFF99F6E4) else Color(0xFF047857),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF0D9488),
                            contentColor = Color.White
                        ) {
                            Text(
                                text = "Excel • CSV • PDF",
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Text(
                        text = "Upload custom question banks via Excel spreadsheet (.xlsx), CSV, or PDF question papers for any Standard (6-10), Subject, and Unit directly into the app.",
                        fontSize = 12.sp,
                        color = if (isDark) Color(0xFFCCFBF1) else Color(0xFF064E3B)
                    )

                    Button(
                        onClick = { showBulkUploadDialog = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("dashboard_open_bulk_upload_button"),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488))
                    ) {
                        Icon(Icons.Default.CloudUpload, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Add Bulk Questions (Excel / CSV / PDF)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // 4. UNLOCKED MERIT BADGES CABINET
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Merit Badges & Achievements",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor
                )
                TextButton(
                    onClick = { selectedTab = 1 },
                    modifier = Modifier.testTag("view_all_badges_button")
                ) {
                    Text(
                        text = "View All ($unlockedBadgesCount/${BadgeSystem.allBadges.size}) →",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            val badgeEvaluations = remember(profile, progressList) {
                BadgeSystem.allBadges.map { badge ->
                    badge to badge.evaluate(profile, progressList)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                badgeEvaluations.forEach { (badge, progress) ->
                    BadgeCabinetItem(
                        emoji = badge.emoji,
                        title = badge.title,
                        desc = if (progress.isUnlocked) "Unlocked 🎉" else progress.progressText,
                        unlocked = progress.isUnlocked,
                        color = Color(badge.colorHex),
                        onClick = { selectedBadgeDetail = badge to progress }
                    )
                }
            }
                        }
                    }
                    1 -> {
                        // 2. DATA VISUALIZATION & ANALYTICS CHARTS TAB (Performance trends & Completion history)
                        AnalyticsChartsSection(
                            userProfile = profile,
                            progressList = progressList,
                            isDark = isDark,
                            monthlyPerformance = dashboardUiState.monthlyPerformance,
                            modifier = Modifier.testTag("dashboard_analytics_charts_section")
                        )
                    }
                    2 -> {
                        // 3. BADGES & ACHIEVEMENTS SHOWCASE TAB
                        BadgesShowcaseView(
                            userProfile = profile,
                            progressList = progressList,
                            isDark = isDark
                        )
                    }
                    3 -> {
                        // 4. SAVED QUESTIONS TAB CONTENT (ROOM DATABASE)
                        SavedQuestionsTab(viewModel = viewModel)
                    }
                    else -> {
                        // 5. QUIZ SCORE HISTORY TAB CONTENT (ROOM DATABASE) & PDF EXPORT
                        HistoricalScoresSection(
                            historicalScores = historicalScores,
                            isDark = isDark,
                            studentName = profile.name,
                            onDeleteScore = { viewModel.deleteHistoricalScore(it) },
                            onClearAll = { viewModel.clearAllHistoricalScores() },
                            onStartNewQuiz = {
                                onStartQuiz(profile.standard, "math", 1, "Numbers (Place Value)")
                            },
                            onExportPdf = { showPdfExportDialog = true }
                        )
                    }
                }
            }

        // Bottom Inset Spacer to prevent system navigation bar or tab overlap
        Spacer(modifier = Modifier.height(48.dp))
    }

    // Modal dialog when tapping a badge in the overview cabinet
    selectedBadgeDetail?.let { (badge, progress) ->
        BadgeDetailDialog(
            badge = badge,
            progress = progress,
            isDark = isDark,
            onDismiss = { selectedBadgeDetail = null },
            onShare = {
                Toast.makeText(
                    context,
                    if (progress.isUnlocked) "🎉 Shared achievement: ${badge.title}!" else "Keep practicing to unlock ${badge.title}!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }

    // Social Media Share Achievements Dialog
    if (showShareDialog) {
        userProfile?.let { prof ->
            ShareAchievementDialog(
                profile = prof,
                rankInfo = dashboardUiState.quizRank,
                progressList = progressList,
                isDark = isDark,
                onDismiss = { showShareDialog = false }
            )
        }
    }

    // Animated Milestone Celebration Full-Screen Overlay
    activeMilestoneCelebration?.let { milestone ->
        userProfile?.let { prof ->
            MilestoneCelebrationDialog(
                milestone = milestone,
                profile = prof,
                onDismiss = { activeMilestoneCelebration = null },
                onClaimReward = { bonusPts, bonusStars ->
                    viewModel.claimDailyStreakBonus(bonusPts, bonusStars)
                }
            )
        }
    }

    // Offline Quizzes Room Storage Manager Dialog
    if (showOfflineManagerDialog) {
        com.example.ui.home.OfflineQuizzesDialog(
            viewModel = viewModel,
            onDismiss = { showOfflineManagerDialog = false },
            onStartQuiz = onStartQuiz
        )
    }

    // Official Student Performance PDF Report Dialog
    if (showPdfExportDialog) {
        userProfile?.let { prof ->
            PdfReportExportDialog(
                profile = prof,
                progressList = progressList,
                historicalScores = historicalScores,
                rankInfo = dashboardUiState.quizRank,
                weakAreaTopics = weakAreaTopics,
                isDark = isDark,
                onDismiss = { showPdfExportDialog = false }
            )
        }
    }

    // Teacher & Faculty Bulk Question Upload Dialog
    if (showBulkUploadDialog) {
        com.example.ui.admin.BulkQuestionUploadDialog(
            viewModel = viewModel,
            isDark = isDark,
            onDismiss = { showBulkUploadDialog = false }
        )
    }
}
}

@Composable
fun BadgeCabinetItem(
    emoji: String,
    title: String,
    desc: String,
    unlocked: Boolean,
    color: Color,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .width(122.dp)
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick)
            .testTag("cabinet_badge_${title.lowercase().replace(" ", "_")}"),
        shape = RoundedCornerShape(24.dp), // rounded-3xl
        colors = CardDefaults.cardColors(
            containerColor = if (unlocked) color.copy(alpha = 0.12f)
            else Color(0xFFF1F5F9)
        ),
        border = BorderStroke(1.dp, if (unlocked) color.copy(alpha = 0.3f) else Color(0xFFE2E8F0))
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .background(if (unlocked) color.copy(alpha = 0.25f) else Color.LightGray.copy(alpha = 0.3f))
                    .border(1.dp, if (unlocked) color else Color.LightGray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (unlocked) emoji else "🔒",
                    fontSize = 22.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = if (unlocked) MaterialTheme.colorScheme.onSurface else Color(0xFF94A3B8),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = desc,
                fontSize = 9.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = if (unlocked) color else Color(0xFF64748B),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

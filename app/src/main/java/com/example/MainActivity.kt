package com.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.data.*
import com.example.notification.DailyReminderScheduler
import com.example.ui.admin.AdminPanelScreen
import com.example.ui.admin.AdminScreen
import com.example.ui.auth.AuthDialog
import com.example.ui.battle.BattleArenaScreen
import com.example.ui.blitz.QuizBlitzScreen
import com.example.ui.bookmarks.BookmarksVaultDialog
import com.example.ui.challenge.DailyChallengeDialog
import com.example.ui.dashboard.DashboardScreen
import com.example.ui.flashcards.FlashcardScreen
import com.example.ui.profile.StudentProfileScreen
import com.example.ui.home.HomeScreen
import com.example.ui.home.Translator
import com.example.ui.leaderboard.LeaderboardScreen
import com.example.ui.mistakes.MistakeVaultDialog
import com.example.ui.quiz.QuizScreen
import com.example.ui.study.StudyTimerDialog
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.ThemeSwitch
import com.example.ui.theme.ThemeSwitchCard
import com.example.ui.theme.GlobalThemeToggleButton
import com.example.localization.AppLanguage
import com.example.localization.AppStrings
import com.example.localization.CustomLanguageSettingsProvider
import com.example.localization.LanguageSettingsProvider
import com.example.localization.LocalAppStrings
import com.example.localization.LocalLanguageSettingsProvider
import com.example.localization.LocaleManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Configure Firestore offline persistence & automatic background synchronization
        com.example.auth.FirebaseCloudSyncManager.getInstance(applicationContext)
        com.example.sync.QuizDataSyncWorker.schedulePeriodic(applicationContext)

        val themeManager = ThemeManager.getInstance(applicationContext)
        val database = QuizDatabase.getDatabase(applicationContext, lifecycleScope)
        val repository = QuizRepository(
            quizDao = database.quizDao(),
            quizQuestionDao = database.quizQuestionDao(),
            downloadedQuizDao = database.downloadedQuizDao(),
            studentProgressDao = database.studentProgressDao(),
            historicalScoreDao = database.historicalScoreDao(),
            studentPointDao = database.studentPointDao()
        )
        val factory = QuizViewModelFactory(application, repository)
        val viewModel = ViewModelProvider(this, factory)[QuizViewModel::class.java]

        val settingsFactory = SettingsViewModelFactory(application, themeManager)
        val settingsViewModel = ViewModelProvider(this, settingsFactory)[SettingsViewModel::class.java]

        // Initialize local notification channel and ensure daily WorkManager reminder is active
        DailyReminderScheduler.createNotificationChannel(this)
        val reminderSettings = DailyReminderScheduler.getSettings(this)
        if (reminderSettings.isEnabled) {
            DailyReminderScheduler.scheduleDailyReminderWithWorkManager(
                context = this,
                hour = reminderSettings.hour,
                minute = reminderSettings.minute
            )
        }

        setContent {
            val isDark by settingsViewModel.isDarkMode.collectAsState()
            MyApplicationTheme(darkTheme = isDark) {
                MainContentNavigator(viewModel = viewModel, settingsViewModel = settingsViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContentNavigator(
    viewModel: QuizViewModel,
    settingsViewModel: SettingsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val activeQuizState by viewModel.activeQuizState.collectAsState()
    val notifications by viewModel.notifications.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val currentLang by viewModel.currentLanguage.collectAsState()
    val strings = AppStrings.forLanguage(currentLang)

    val isDark by settingsViewModel.isDarkMode.collectAsState()
    val themeMode by settingsViewModel.themeMode.collectAsState()
    val soundEffects by settingsViewModel.soundEffectsEnabled.collectAsState()
    val vibrationEnabled by settingsViewModel.vibrationEnabled.collectAsState()

    val flashcardState by viewModel.flashcardState.collectAsState()
    val dailyChallengeState by viewModel.dailyChallengeState.collectAsState()
    val battleArenaState by viewModel.battleArenaState.collectAsState()
    val blitzState by viewModel.blitzState.collectAsState()
    val mistakes by viewModel.mistakesList.collectAsState()
    var showBookmarksVault by remember { mutableStateOf(false) }
    var showStudyTimer by remember { mutableStateOf(false) }
    var showMistakeVault by remember { mutableStateOf(false) }
    var showAuthDialog by remember { mutableStateOf(false) }
    var showLanguageDialog by remember { mutableStateOf(false) }

    var activeScreenRoute by remember { mutableStateOf("home") } // "home", "dashboard", "leaderboard", "admin"
    var showNotificationsDropdown by remember { mutableStateOf(false) }
    var showSettingsDialog by remember { mutableStateOf(false) }

    val systemInDark = androidx.compose.foundation.isSystemInDarkTheme()
    LaunchedEffect(systemInDark, themeMode) {
        if (themeMode == ThemeMode.SYSTEM) {
            settingsViewModel.updateSystemDark(systemInDark)
        }
    }

    val unreadNotificationsCount = notifications.size

    val context = androidx.compose.ui.platform.LocalContext.current
    val languageSettingsProvider = remember {
        CustomLanguageSettingsProvider.getInstance(context)
    }

    LaunchedEffect(currentLang) {
        try {
            LocaleManager.updateConfiguration(context, AppLanguage.from(currentLang))
        } catch (ignored: Exception) {}
    }

    CompositionLocalProvider(
        LocalAppStrings provides strings,
        LocalLanguageSettingsProvider provides languageSettingsProvider
    ) {
        // Back navigation handling for all game modes and sub-screens
        BackHandler(enabled = showNotificationsDropdown) {
            showNotificationsDropdown = false
        }
        BackHandler(enabled = activeQuizState.isPlaying) {
            viewModel.exitQuiz()
        }
        BackHandler(enabled = flashcardState.isActive) {
            viewModel.exitFlashcards()
        }
        BackHandler(enabled = battleArenaState.isActive) {
            viewModel.exitBattleArena()
        }
        BackHandler(enabled = blitzState.isActive) {
            viewModel.exitQuizBlitz()
        }
        BackHandler(enabled = !showNotificationsDropdown && !activeQuizState.isPlaying && !flashcardState.isActive && !battleArenaState.isActive && !blitzState.isActive && activeScreenRoute != "home") {
            activeScreenRoute = "home"
        }

        val isAuthCompleted by viewModel.isStartupAuthCompleted.collectAsState()

        // If startup role-based auth is not completed, display StartupAuthScreen gate
        if (!isAuthCompleted) {
            com.example.ui.auth.StartupAuthScreen(
                viewModel = viewModel,
                onAuthComplete = { /* StateFlow in ViewModel triggers transition */ }
            )
        } else if (activeQuizState.isPlaying) {
            QuizScreen(
                viewModel = viewModel,
                onExitQuiz = { viewModel.exitQuiz() }
            )
        } else if (flashcardState.isActive) {
            FlashcardScreen(
                viewModel = viewModel
            )
        } else if (battleArenaState.isActive) {
            BattleArenaScreen(
                viewModel = viewModel
            )
        } else if (blitzState.isActive) {
            QuizBlitzScreen(
                viewModel = viewModel
            )
        } else {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(end = 4.dp)
                            ) {
                                Text("🏫", fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = strings.appName,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 17.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        },
                        actions = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(2.dp),
                                modifier = Modifier.horizontalScroll(rememberScrollState())
                            ) {
                                // Study Timer quick access icon
                                IconButton(
                                    onClick = { showStudyTimer = true },
                                    modifier = Modifier
                                        .size(36.dp)
                                        .testTag("study_timer_icon_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Timer,
                                        contentDescription = strings.studyTimer,
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(19.dp)
                                    )
                                }

                                // Bookmarks Vault quick access icon
                                IconButton(
                                    onClick = { showBookmarksVault = true },
                                    modifier = Modifier
                                        .size(36.dp)
                                        .testTag("bookmarks_vault_icon_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.BookmarkBorder,
                                        contentDescription = strings.bookmarksVault,
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(19.dp)
                                    )
                                }

                                // Mistake Vault Quick Access Icon
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .padding(end = 2.dp)
                                ) {
                                    IconButton(
                                        onClick = { showMistakeVault = true },
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .testTag("mistake_vault_icon_button")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Psychology,
                                            contentDescription = "Mistake Vault",
                                            tint = if (mistakes.isNotEmpty()) Color(0xFFEF4444) else MaterialTheme.colorScheme.onSurfaceVariant,
                                            modifier = Modifier.size(19.dp)
                                        )
                                    }
                                    if (mistakes.isNotEmpty()) {
                                        Box(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xFFEF4444))
                                                .align(Alignment.TopEnd)
                                                .offset(x = 1.dp, y = 2.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = mistakes.size.toString(),
                                                color = Color.White,
                                                fontSize = 8.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }

                                // Settings Icon Button
                                IconButton(
                                    onClick = { showSettingsDialog = true },
                                    modifier = Modifier
                                        .size(36.dp)
                                        .testTag("settings_icon_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Settings,
                                        contentDescription = strings.settings,
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(19.dp)
                                    )
                                }

                                // Student Profile Icon Button
                                IconButton(
                                    onClick = { activeScreenRoute = "profile" },
                                    modifier = Modifier
                                        .size(36.dp)
                                        .testTag("topbar_student_profile_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.AccountCircle,
                                        contentDescription = "Student Profile",
                                        tint = if (activeScreenRoute == "profile") Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }

                                // Alerts Ticker button with a badge
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .testTag("notifications_bell")
                                        .padding(end = 4.dp)
                                        .clickable { showNotificationsDropdown = !showNotificationsDropdown },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = if (unreadNotificationsCount > 0) Icons.Default.NotificationsActive else Icons.Default.Notifications,
                                        contentDescription = "Alerts",
                                        tint = if (unreadNotificationsCount > 0) Color(0xFFEF4444) else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    if (unreadNotificationsCount > 0) {
                                        Box(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xFFEF4444))
                                                .align(Alignment.TopEnd)
                                                .offset(x = 1.dp, y = 2.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = unreadNotificationsCount.toString(),
                                                color = Color.White,
                                                fontSize = 8.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                },
                bottomBar = {
                    val homeScale by animateFloatAsState(targetValue = if (activeScreenRoute == "home") 1.15f else 1f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = "nav_home_scale")
                    val dashScale by animateFloatAsState(targetValue = if (activeScreenRoute == "dashboard") 1.15f else 1f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = "nav_dash_scale")
                    val leadScale by animateFloatAsState(targetValue = if (activeScreenRoute == "leaderboard") 1.15f else 1f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = "nav_lead_scale")
                    val adminScale by animateFloatAsState(targetValue = if (activeScreenRoute == "admin") 1.15f else 1f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = "nav_admin_scale")

                    NavigationBar(
                        modifier = Modifier.testTag("main_navigation_bar"),
                        windowInsets = WindowInsets.navigationBars,
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        // Home Toggle
                        NavigationBarItem(
                            selected = activeScreenRoute == "home",
                            onClick = { activeScreenRoute = "home" },
                            alwaysShowLabel = true,
                            icon = {
                                Icon(
                                    imageVector = if (activeScreenRoute == "home") Icons.Filled.Home else Icons.Outlined.Home,
                                    contentDescription = strings.navHome,
                                    tint = if (activeScreenRoute == "home") Color(0xFF4F46E5) else Color(0xFF64748B),
                                    modifier = Modifier.size(22.dp).scale(homeScale)
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navHome,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = if (activeScreenRoute == "home") Color(0xFF4F46E5) else Color(0xFF64748B)
                                )
                            },
                            modifier = Modifier.testTag("nav_home_button")
                        )

                        // Dashboard Toggle
                        NavigationBarItem(
                            selected = activeScreenRoute == "dashboard",
                            onClick = { activeScreenRoute = "dashboard" },
                            alwaysShowLabel = true,
                            icon = {
                                Icon(
                                    imageVector = if (activeScreenRoute == "dashboard") Icons.Filled.BarChart else Icons.Outlined.BarChart,
                                    contentDescription = strings.navDashboard,
                                    tint = if (activeScreenRoute == "dashboard") Color(0xFF4F46E5) else Color(0xFF64748B),
                                    modifier = Modifier.size(22.dp).scale(dashScale)
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navDashboard,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = if (activeScreenRoute == "dashboard") Color(0xFF4F46E5) else Color(0xFF64748B)
                                )
                            },
                            modifier = Modifier.testTag("nav_dashboard_button")
                        )

                        // 1vs1 Battle Arena Quick Action
                        NavigationBarItem(
                            selected = false,
                            onClick = { viewModel.startBattleArena() },
                            alwaysShowLabel = true,
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.FlashOn,
                                    contentDescription = strings.navBattle,
                                    tint = Color(0xFFE11D48),
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navBattle,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = Color(0xFFE11D48)
                                )
                            },
                            modifier = Modifier.testTag("nav_battle_button")
                        )

                        // Leaderboard Arena Toggle
                        NavigationBarItem(
                            selected = activeScreenRoute == "leaderboard",
                            onClick = { activeScreenRoute = "leaderboard" },
                            alwaysShowLabel = true,
                            icon = {
                                Icon(
                                    imageVector = if (activeScreenRoute == "leaderboard") Icons.Filled.EmojiEvents else Icons.Outlined.EmojiEvents,
                                    contentDescription = strings.navRankings,
                                    tint = if (activeScreenRoute == "leaderboard") Color(0xFF4F46E5) else Color(0xFF64748B),
                                    modifier = Modifier.size(22.dp).scale(leadScale)
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navRankings,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = if (activeScreenRoute == "leaderboard") Color(0xFF4F46E5) else Color(0xFF64748B)
                                )
                            },
                            modifier = Modifier.testTag("nav_leaderboard_button")
                        )

                        // Admin Panel Toggle
                        NavigationBarItem(
                            selected = activeScreenRoute == "admin",
                            onClick = { activeScreenRoute = "admin" },
                            alwaysShowLabel = true,
                            icon = {
                                Icon(
                                    imageVector = if (activeScreenRoute == "admin") Icons.Filled.SupervisorAccount else Icons.Outlined.SupervisorAccount,
                                    contentDescription = strings.navAdmin,
                                    tint = if (activeScreenRoute == "admin") Color(0xFF4F46E5) else Color(0xFF64748B),
                                    modifier = Modifier.size(22.dp).scale(adminScale)
                                )
                            },
                            label = {
                                Text(
                                    text = strings.navAdmin,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = if (activeScreenRoute == "admin") Color(0xFF4F46E5) else Color(0xFF64748B)
                                )
                            },
                            modifier = Modifier.testTag("nav_admin_button")
                        )
                    }
                }
            ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Screen Route Layout Switcher with modern smooth animation
                AnimatedContent(
                    targetState = activeScreenRoute,
                    transitionSpec = {
                        val routeOrder = listOf("home", "dashboard", "leaderboard", "admin", "profile")
                        val fromIndex = routeOrder.indexOf(initialState).coerceAtLeast(0)
                        val toIndex = routeOrder.indexOf(targetState).coerceAtLeast(0)
                        val direction = if (toIndex >= fromIndex) 1 else -1

                        (slideInHorizontally(
                            animationSpec = spring(dampingRatio = 0.85f, stiffness = Spring.StiffnessMediumLow),
                            initialOffsetX = { fullWidth -> direction * (fullWidth / 4) }
                        ) + fadeIn(animationSpec = tween(220))) togetherWith
                        (slideOutHorizontally(
                            animationSpec = tween(180),
                            targetOffsetX = { fullWidth -> -direction * (fullWidth / 4) }
                        ) + fadeOut(animationSpec = tween(160)))
                    },
                    label = "screen_route_transition",
                    modifier = Modifier.fillMaxSize()
                ) { route ->
                    when (route) {
                        "home" -> HomeScreen(
                            viewModel = viewModel,
                            settingsViewModel = settingsViewModel,
                            languageSettingsProvider = languageSettingsProvider,
                            onStartQuiz = { stdId, subjectId, unitId, name ->
                                viewModel.startQuiz(stdId, subjectId, unitId, name)
                            }
                        )
                        "dashboard" -> DashboardScreen(
                            viewModel = viewModel
                        )
                        "leaderboard" -> LeaderboardScreen(
                            viewModel = viewModel,
                            onNavigateToHome = { activeScreenRoute = "home" },
                            onNavigateToBattle = { viewModel.startBattleArena() }
                        )
                        "admin" -> AdminScreen(
                            viewModel = viewModel
                        )
                        "admin_panel" -> AdminPanelScreen(
                            viewModel = viewModel,
                            onNavigateBack = { activeScreenRoute = "admin" }
                        )
                        "profile" -> StudentProfileScreen(
                            viewModel = viewModel,
                            onNavigateBack = { activeScreenRoute = "home" }
                        )
                    }
                }

                // Alert notification list drop-down overlay with modern animated entrance
                AnimatedVisibility(
                    visible = showNotificationsDropdown,
                    enter = fadeIn(tween(180)) + slideInVertically(
                        animationSpec = spring(dampingRatio = 0.8f, stiffness = Spring.StiffnessMediumLow),
                        initialOffsetY = { -it / 3 }
                    ) + scaleIn(initialScale = 0.92f, transformOrigin = androidx.compose.ui.graphics.TransformOrigin(1f, 0f)),
                    exit = fadeOut(tween(140)) + slideOutVertically(
                        animationSpec = tween(140),
                        targetOffsetY = { -it / 4 }
                    ) + scaleOut(targetScale = 0.94f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.35f))
                            .clickable { showNotificationsDropdown = false }
                    ) {
                        Card(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .width(310.dp)
                                .heightIn(max = 400.dp)
                                .padding(8.dp)
                                .clickable(enabled = false) {}, // stop propagation
                            shape = RoundedCornerShape(24.dp), // rounded-3xl
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
                        ) {
                            Column {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color(0xFF4F46E5))
                                        .padding(16.dp)
                                ) {
                                    Text(
                                        text = strings.alerts,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White,
                                        fontSize = 14.sp
                                    )
                                }

                                if (notifications.isEmpty()) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(32.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(strings.noAlerts, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                    }
                                } else {
                                    Column(
                                        modifier = Modifier
                                            .verticalScroll(rememberScrollState())
                                            .padding(12.dp),
                                        verticalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        notifications.forEach { item ->
                                            Card(
                                                colors = CardDefaults.cardColors(
                                                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                                                ),
                                                shape = RoundedCornerShape(16.dp),
                                                border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9))
                                            ) {
                                                Column(modifier = Modifier.padding(12.dp)) {
                                                    Row(
                                                        modifier = Modifier.fillMaxWidth(),
                                                        horizontalArrangement = Arrangement.SpaceBetween,
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(
                                                            text = item.title,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            fontSize = 12.sp,
                                                            color = MaterialTheme.colorScheme.onSurface
                                                        )
                                                        Text(
                                                            text = item.category.uppercase(),
                                                            fontSize = 9.sp,
                                                            color = Color(0xFF818CF8),
                                                            fontWeight = FontWeight.ExtraBold
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.height(4.dp))
                                                    Text(
                                                        text = item.description,
                                                        fontSize = 11.sp,
                                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                                    )
                                                }
                                            }
                                        }
                                        
                                        TextButton(
                                            onClick = { showNotificationsDropdown = false },
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Text("Dismiss", color = Color(0xFF818CF8), fontWeight = FontWeight.ExtraBold)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Settings Dialog Modal
                if (showSettingsDialog) {
                    AlertDialog(
                        onDismissRequest = { showSettingsDialog = false },
                        modifier = Modifier.testTag("settings_modal_dialog"),
                        title = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("⚙️", fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Application Settings",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                            }
                        },
                        text = {
                            Column(
                                modifier = Modifier.verticalScroll(rememberScrollState()),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                // Account & Cloud Sync Section
                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Text(
                                        text = "Account & Profile",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                showSettingsDialog = false
                                                showAuthDialog = true
                                            }
                                            .testTag("settings_account_profile_card"),
                                        shape = RoundedCornerShape(12.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                                        )
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(12.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .size(38.dp)
                                                        .clip(CircleShape)
                                                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.AccountCircle,
                                                        contentDescription = "Profile",
                                                        tint = MaterialTheme.colorScheme.primary,
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                }
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Column {
                                                    Text(
                                                        text = "Cloud Account & Sync",
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 13.sp,
                                                        color = MaterialTheme.colorScheme.onSurface
                                                    )
                                                    Text(
                                                        text = "Google Sign-In, Cloud Backup & Firestore",
                                                        fontSize = 11.sp,
                                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                                    )
                                                }
                                            }
                                            Icon(
                                                imageVector = Icons.Default.ChevronRight,
                                                contentDescription = null,
                                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                    }
                                }

                                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                                // Theme Section
                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Text(
                                        text = "Appearance Theme (ThemeManager)",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = "Controls the global light and dark theme mode across all screens and components.",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )

                                    // Dedicated persistent ThemeSwitchCard for instant light/dark toggle
                                    ThemeSwitchCard(
                                        settingsViewModel = settingsViewModel,
                                        modifier = Modifier.testTag("settings_theme_switch_card")
                                    )

                                    // Theme choices: Light, Dark, System
                                    val themeOptions = listOf(
                                        Triple(ThemeMode.LIGHT, "☀️ Light Mode", "Bright, high-contrast palette"),
                                        Triple(ThemeMode.DARK, "🌙 Dark Mode", "Deep slate, battery-saving palette"),
                                        Triple(ThemeMode.SYSTEM, "⚙️ System Default", "Follows your device system theme")
                                    )

                                    themeOptions.forEach { (mode, title, desc) ->
                                        val isSelected = themeMode == mode
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clickable {
                                                    settingsViewModel.setThemeMode(mode, systemInDark)
                                                }
                                                .testTag("theme_option_${mode.name.lowercase()}"),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = if (isSelected)
                                                    MaterialTheme.colorScheme.primaryContainer
                                                else
                                                    MaterialTheme.colorScheme.surfaceVariant
                                            ),
                                            border = if (isSelected)
                                                BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                                            else
                                                null
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(12.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text(
                                                        text = title,
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 13.sp,
                                                        color = if (isSelected)
                                                            MaterialTheme.colorScheme.onPrimaryContainer
                                                        else
                                                            MaterialTheme.colorScheme.onSurface
                                                    )
                                                    Text(
                                                        text = desc,
                                                        fontSize = 11.sp,
                                                        color = if (isSelected)
                                                            MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                                                        else
                                                            MaterialTheme.colorScheme.onSurfaceVariant
                                                    )
                                                }
                                                RadioButton(
                                                    selected = isSelected,
                                                    onClick = {
                                                        settingsViewModel.setThemeMode(mode, systemInDark)
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }

                                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                                // Preferences Section
                                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                    Text(
                                        text = "Quiz Feedback (SettingsViewModel)",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column {
                                            Text(
                                                text = "Sound Effects",
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 13.sp
                                            )
                                            Text(
                                                text = "Audio cues for answers & completions",
                                                fontSize = 11.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Switch(
                                            checked = soundEffects,
                                            onCheckedChange = { settingsViewModel.toggleSoundEffects() }
                                        )
                                    }

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column {
                                            Text(
                                                text = "Haptic Vibration",
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 13.sp
                                            )
                                            Text(
                                                text = "Vibrate on quiz responses",
                                                fontSize = 11.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Switch(
                                            checked = vibrationEnabled,
                                            onCheckedChange = { settingsViewModel.toggleVibration() }
                                        )
                                    }

                                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                                    // Local Daily Reminder Scheduler
                                    com.example.ui.settings.DailyReminderSettingsCard()

                                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                                    // Class & Curriculum Visibility Settings Card (Hide/Show Std 6 to 10, Morarji, NMMS)
                                    com.example.ui.settings.ClassVisibilitySettingsCard(settingsViewModel = settingsViewModel)

                                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                                    // Language Selection Section
                                    // Language Selection Section (English, Hindi, Kannada)
                                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text("🌐", fontSize = 16.sp)
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = strings.languageSection,
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 13.sp,
                                                    color = MaterialTheme.colorScheme.primary
                                                )
                                            }
                                            Surface(
                                                shape = RoundedCornerShape(6.dp),
                                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                                            ) {
                                                Text(
                                                    text = "${AppLanguage.from(currentLang).flagEmoji} ${AppLanguage.from(currentLang).nativeName}",
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        }

                                        Text(
                                            text = strings.languageDesc,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )

                                        // Quick Filter Chips Row for 1-tap language switching
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .horizontalScroll(rememberScrollState()),
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            AppLanguage.entries.forEach { appLang ->
                                                val isLangSelected = AppLanguage.from(currentLang) == appLang
                                                FilterChip(
                                                    selected = isLangSelected,
                                                    onClick = {
                                                        viewModel.switchLanguage(appLang.displayName)
                                                        settingsViewModel.setLanguage(appLang.displayName)
                                                        languageSettingsProvider.setLanguage(appLang)
                                                        Toast.makeText(
                                                            context,
                                                            "${appLang.flagEmoji} Switched to ${appLang.displayName} (${appLang.nativeName})",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    },
                                                    label = {
                                                        Text(
                                                            text = "${appLang.flagEmoji} ${appLang.nativeName}",
                                                            fontSize = 11.sp,
                                                            fontWeight = if (isLangSelected) FontWeight.ExtraBold else FontWeight.Medium
                                                        )
                                                    },
                                                    modifier = Modifier.testTag("settings_chip_${appLang.code}"),
                                                    colors = FilterChipDefaults.filterChipColors(
                                                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                                        selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                                                    )
                                                )
                                            }
                                        }

                                        // Detailed Localized Selection Cards
                                        AppLanguage.entries.forEach { appLang ->
                                            val isLangSelected = AppLanguage.from(currentLang) == appLang
                                            Card(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clickable {
                                                        viewModel.switchLanguage(appLang.displayName)
                                                        settingsViewModel.setLanguage(appLang.displayName)
                                                        languageSettingsProvider.setLanguage(appLang)
                                                        Toast.makeText(
                                                            context,
                                                            "${appLang.flagEmoji} Switched to ${appLang.displayName} (${appLang.nativeName})",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }
                                                    .testTag("settings_lang_${appLang.code}"),
                                                shape = RoundedCornerShape(14.dp),
                                                colors = CardDefaults.cardColors(
                                                    containerColor = if (isLangSelected)
                                                        MaterialTheme.colorScheme.primaryContainer
                                                    else
                                                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                                                ),
                                                border = if (isLangSelected)
                                                    BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                                                else
                                                    BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                                            ) {
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(horizontal = 14.dp, vertical = 12.dp),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                                        Text(appLang.flagEmoji, fontSize = 22.sp)
                                                        Spacer(modifier = Modifier.width(12.dp))
                                                        Column {
                                                            Text(
                                                                text = appLang.nativeName,
                                                                fontWeight = FontWeight.ExtraBold,
                                                                fontSize = 14.5.sp,
                                                                color = if (isLangSelected)
                                                                    MaterialTheme.colorScheme.onPrimaryContainer
                                                                else
                                                                    MaterialTheme.colorScheme.onSurface
                                                            )
                                                            Text(
                                                                text = appLang.displayName,
                                                                fontSize = 11.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                color = if (isLangSelected)
                                                                    MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
                                                                else
                                                                    MaterialTheme.colorScheme.onSurfaceVariant
                                                            )
                                                        }
                                                    }
                                                    RadioButton(
                                                        selected = isLangSelected,
                                                        onClick = {
                                                            viewModel.switchLanguage(appLang.displayName)
                                                            settingsViewModel.setLanguage(appLang.displayName)
                                                            languageSettingsProvider.setLanguage(appLang)
                                                            Toast.makeText(
                                                                context,
                                                                "${appLang.flagEmoji} Switched to ${appLang.displayName} (${appLang.nativeName})",
                                                                Toast.LENGTH_SHORT
                                                            ).show()
                                                        }
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        },
                        confirmButton = {
                            Button(
                                onClick = { showSettingsDialog = false },
                                modifier = Modifier.testTag("settings_done_button")
                            ) {
                                Text(strings.done, fontWeight = FontWeight.Bold)
                            }
                        }
                    )
                }

                // Quick Language Selection Dialog
                if (showLanguageDialog) {
                    AlertDialog(
                        onDismissRequest = { showLanguageDialog = false },
                        modifier = Modifier.testTag("main_language_dialog"),
                        title = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🌐", fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(strings.chooseLanguage, fontWeight = FontWeight.Bold)
                            }
                        },
                        text = {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                AppLanguage.entries.forEach { appLang ->
                                    val isSelected = AppLanguage.from(currentLang) == appLang
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(12.dp))
                                            .background(
                                                if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                                                else Color.Transparent
                                            )
                                            .clickable {
                                                viewModel.switchLanguage(appLang.displayName)
                                                settingsViewModel.setLanguage(appLang.displayName)
                                                showLanguageDialog = false
                                            }
                                            .padding(12.dp)
                                            .testTag("top_lang_option_${appLang.code}"),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = isSelected,
                                            onClick = {
                                                viewModel.switchLanguage(appLang.displayName)
                                                settingsViewModel.setLanguage(appLang.displayName)
                                                showLanguageDialog = false
                                            }
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(appLang.flagEmoji, fontSize = 20.sp)
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column {
                                            Text(
                                                text = appLang.nativeName,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                                fontSize = 15.sp,
                                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                                            )
                                            if (appLang != AppLanguage.ENGLISH) {
                                                Text(
                                                    text = appLang.displayName,
                                                    fontSize = 12.sp,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        },
                        confirmButton = {
                            TextButton(
                                onClick = { showLanguageDialog = false },
                                modifier = Modifier.testTag("close_main_language_dialog_button")
                            ) {
                                Text(strings.close, fontWeight = FontWeight.Bold)
                            }
                        }
                    )
                }

                // Daily Quest / Challenge Dialog
                if (dailyChallengeState.isActive) {
                    DailyChallengeDialog(viewModel = viewModel)
                }

                // Bookmarks & Saved Questions Review Vault
                if (showBookmarksVault) {
                    BookmarksVaultDialog(
                        viewModel = viewModel,
                        onDismiss = { showBookmarksVault = false }
                    )
                }

                // Mistake Vault Dialog
                if (showMistakeVault) {
                    MistakeVaultDialog(
                        viewModel = viewModel,
                        onDismiss = { showMistakeVault = false }
                    )
                }

                // Study Pomodoro Focus Timer Dialog
                if (showStudyTimer) {
                    StudyTimerDialog(
                        viewModel = viewModel,
                        onDismiss = { showStudyTimer = false }
                    )
                }

                // Firebase Authentication Dialog
                if (showAuthDialog) {
                    AuthDialog(
                        viewModel = viewModel,
                        onDismiss = { showAuthDialog = false }
                    )
                }
            }
        }
    }
}
}

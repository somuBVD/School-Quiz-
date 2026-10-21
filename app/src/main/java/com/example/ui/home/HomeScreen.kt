package com.example.ui.home

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizViewModel
import com.example.SettingsViewModel
import android.widget.Toast
import com.example.audio.SoundEffectsManager
import com.example.data.*
import com.example.ui.auth.AuthDialog
import com.example.ui.common.OfflineModeSyncBanner
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import com.example.localization.AppLanguage
import com.example.localization.AppStrings
import com.example.localization.LanguageSettingsProvider
import com.example.localization.LocalLanguageSettingsProvider

object Translator {
    fun translate(key: String, lang: String): String {
        return AppStrings.get(key, lang)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: QuizViewModel,
    onStartQuiz: (stdId: Int, subjectId: String, unitId: Int, unitName: String) -> Unit,
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel? = null,
    languageSettingsProvider: LanguageSettingsProvider? = null,
    onOpenProfile: (() -> Unit)? = null
) {
    val userProfile by viewModel.userProfile.collectAsState()
    val activeAds by viewModel.activeAds.collectAsState()
    val selectedStd by viewModel.selectedStd.collectAsState()
    val selectedSubjectId by viewModel.selectedSubjectId.collectAsState()
    val progressList by viewModel.unitProgressList.collectAsState()
    val recommendations by viewModel.recommendedQuizzes.collectAsState()
    val categorySummaries by viewModel.categorySummaries.collectAsState()
    val cloudSyncState by viewModel.cloudSyncState.collectAsState()
    val currentLang by viewModel.currentLanguage.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val downloadedQuizzes by viewModel.downloadedQuizzes.collectAsState()
    val downloadingUnits by viewModel.downloadingUnits.collectAsState()

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9))

    var searchQuery by remember { mutableStateOf("") }
    val selectedSubjectFilter by viewModel.selectedSubjectFilter.collectAsState()
    var selectedDifficulty by remember { mutableStateOf("all") }
    var showOfflineOnly by remember { mutableStateOf(false) }
    var expandedSubjectId by remember { mutableStateOf<String?>(null) }
    var showOfflineManagerDialog by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val visibleStandards by (settingsViewModel?.visibleStandards?.collectAsState()
        ?: remember { mutableStateOf(setOf(6, 7, 8, 9, 10, 11, 12)) })

    // If current selected standard was hidden in settings, switch to the first available visible standard
    LaunchedEffect(visibleStandards) {
        if (selectedStd !in visibleStandards && visibleStandards.isNotEmpty()) {
            val fallbackStd = visibleStandards.sorted().firstOrNull() ?: 6
            viewModel.changeStandard(fallbackStd)
            viewModel.setSubjectFilter("all")
            expandedSubjectId = null
        }
    }

    // Banners state handling
    var activeAdIndex by remember { mutableIntStateOf(0) }
    LaunchedEffect(activeAds) {
        if (activeAds.isNotEmpty()) {
            while (true) {
                delay(4000)
                activeAdIndex = (activeAdIndex + 1) % activeAds.size
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. TOP PROFILE SECTION
        userProfile?.let { profile ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpenProfile?.invoke() }
                    .testTag("student_profile_header"),
                shape = RoundedCornerShape(24.dp), // rounded-3xl
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // Top row: Avatar + Aligned Student info + Utility Actions
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Student Profile Info
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            // Profile Avatar with decorative design
                            Box(
                                modifier = Modifier
                                    .size(52.dp)
                                    .clip(CircleShape)
                                    .background(if (isDark) Color(0xFF312E81) else Color(0xFFE0E7FF))
                                    .border(1.5.dp, if (isDark) Color(0xFF4338CA) else Color(0xFFC7D2FE), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                if (profile.avatar.startsWith("http://") || profile.avatar.startsWith("https://")) {
                                    SubcomposeAsyncImage(
                                        model = profile.avatar,
                                        contentDescription = "Profile Photo",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize().clip(CircleShape)
                                    )
                                } else {
                                    val avatarChar = if (profile.name.isNotEmpty()) profile.name.first().uppercase() else "🎓"
                                    Text(
                                        text = avatarChar,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF4F46E5)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = profile.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = (if (isDark) Color(0xFF4338CA) else Color(0xFF4F46E5)).copy(alpha = 0.12f)
                                    ) {
                                        val stdLabel = when (profile.standard) {
                                            11 -> "Morarji"
                                            12 -> "NMMS"
                                            else -> "${Translator.translate("std", currentLang)} ${profile.standard}"
                                        }
                                        Text(
                                            text = stdLabel,
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF4F46E5),
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }

                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = Color(0xFFEA580C).copy(alpha = 0.12f)
                                    ) {
                                        Text(
                                            text = "🔥 ${profile.attendanceStreak} ${Translator.translate("streak", currentLang)}",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFFEA580C),
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Bottom row: Score & Balance chips cleanly aligned
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Coins Chip
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isDark) Color(0xFF422006) else Color(0xFFFEF08A))
                                .border(1.dp, if (isDark) Color(0xFF713F12) else Color(0xFFFDE047), RoundedCornerShape(12.dp))
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🪙", fontSize = 13.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${profile.coins} ${Translator.translate("coins", currentLang)}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFFDE047) else Color(0xFF713F12)
                                )
                            }
                        }

                        // Stars Chip (like ★ in HTML)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isDark) Color(0xFF422006).copy(alpha = 0.6f) else Color(0xFFFEF9C3))
                                .border(1.dp, if (isDark) Color(0xFF854D0E) else Color(0xFFFEF08A), RoundedCornerShape(12.dp))
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("★", fontSize = 13.sp, color = Color(0xFFCA8A04))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${profile.stars} ${Translator.translate("stars", currentLang)}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFFEF08A) else Color(0xFF713F12)
                                )
                            }
                        }

                        // Student Level & XP Badge Chip
                        val studentLevel = com.example.data.StudentLevelSystem.calculateLevel(profile.xp)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isDark) Color(0xFF2E1065) else Color(0xFFF3E8FF))
                                .border(1.dp, if (isDark) Color(0xFF581C87) else Color(0xFFDDD6FE), RoundedCornerShape(12.dp))
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(studentLevel.badgeEmoji, fontSize = 13.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "LVL ${studentLevel.level} • ${profile.xp} XP",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFD8B4FE) else Color(0xFF6B21A8)
                                )
                            }
                        }
                    }
                }
            }
        }

        // 2. ADVERTISING & CONTEST BANNER CAROUSEL
        val ad = if (activeAds.isNotEmpty()) (activeAds.getOrNull(activeAdIndex) ?: activeAds.first()) else null
        if (ad != null) {
            AnimatedContent(
                targetState = ad,
                transitionSpec = {
                    (fadeIn(animationSpec = tween(350)) + slideInHorizontally(
                        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                        initialOffsetX = { it / 3 }
                    )) togetherWith (fadeOut(animationSpec = tween(250)) + slideOutHorizontally(
                        animationSpec = tween(250),
                        targetOffsetX = { -it / 3 }
                    ))
                },
                label = "banner_carousel_animation"
            ) { currentAd ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF6366F1), // indigo-500
                                    Color(0xFF4338CA)  // indigo-700
                                )
                            )
                        )
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.weight(1f, fill = false),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Column {
                                Text(
                                    text = currentAd.title,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = currentAd.subtitle,
                                    fontSize = 12.sp,
                                    color = Color.White.copy(alpha = 0.9f),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            // Simple clean border play, active action badge
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .background(Color.White.copy(alpha = 0.18f))
                                    .border(1.dp, Color.White.copy(alpha = 0.35f), RoundedCornerShape(50))
                                    .padding(horizontal = 14.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = "PLAY NOW ➔",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        // Owl helper mascot container
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.15f))
                                .border(1.5.dp, Color.White.copy(alpha = 0.3f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "🦉",
                                fontSize = 26.sp
                            )
                        }
                    }
                }
            }
        }

        // 3. DAILY ATTENDANCE & STREAK TRACKING BOARD
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("home_daily_streak_card"),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = cardBorder
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                userProfile?.let { profile ->
                    // Top header: Streak count highlighted prominently with bonus indicator
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(34.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFEA580C).copy(alpha = 0.12f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("🔥", fontSize = 18.sp)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Column(modifier = Modifier.weight(1f, fill = false)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "${profile.attendanceStreak} Days Active Streak",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = titleColor,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.weight(1f, fill = false)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = Color(0xFFEA580C)
                                    ) {
                                        Text(
                                            text = "BONUS",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                        )
                                    }
                                }
                                val bonusPts = (profile.attendanceStreak * 25).coerceAtLeast(25)
                                Text(
                                    text = "+$bonusPts XP daily bonus!",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = if (isDark) Color(0xFFFDBA74) else Color(0xFFC2410C),
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        Button(
                            onClick = {
                                viewModel.claimDailyAttendanceReward()
                                SoundEffectsManager.playStreakBonus(context)
                                Toast.makeText(context, "🎉 Daily Streak Reward Claimed! +Bonus XP & Coins", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .height(32.dp)
                                .testTag("claim_daily_button"),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF4F46E5)
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text("🎁", fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Claim",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // 7-Day Visual Streak Cycle with Bonus Day 7 - evenly distributed across card
                    val cycleStreak = if (profile.attendanceStreak > 0) ((profile.attendanceStreak - 1) % 7) + 1 else 0
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        (1..7).forEach { day ->
                            val claimed = day <= cycleStreak
                            val isDay7 = day == 7
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(34.dp)
                                        .clip(CircleShape)
                                        .background(
                                            when {
                                                claimed -> if (isDark) Color(0xFF881337) else Color(0xFFFFE4E6)
                                                isDay7 -> if (isDark) Color(0xFF422006) else Color(0xFFFEF3C7)
                                                else -> if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9)
                                            }
                                        )
                                        .border(
                                            width = 1.dp,
                                            color = when {
                                                claimed -> if (isDark) Color(0xFFBE123C) else Color(0xFFFDA4AF)
                                                isDay7 -> if (isDark) Color(0xFFD97706) else Color(0xFFFBBF24)
                                                else -> if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                                            },
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = if (claimed) "🔥" else if (isDay7) "⭐" else "$day",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = when {
                                            claimed -> if (isDark) Color(0xFFFECDD3) else Color(0xFFBE123C)
                                            isDay7 -> if (isDark) Color(0xFFFDE68A) else Color(0xFFB45309)
                                            else -> subtitleColor
                                        }
                                    )
                                }
                                Text(
                                    text = if (isDay7) "Day 7" else "D$day",
                                    fontSize = 9.sp,
                                    fontWeight = if (claimed || isDay7) FontWeight.Bold else FontWeight.Medium,
                                    color = if (claimed) (if (isDark) Color(0xFFFDA4AF) else Color(0xFFE11D48)) else subtitleColor
                                )
                            }
                        }
                    }
                }
            }
        }

        // 3.62. DAILY STUDY TARGET & GOAL PROGRESS
        DailyStudyGoalCard(
            viewModel = viewModel,
            isDark = isDark,
            cardBorder = cardBorder
        )

        // 3.5. QUICK CHALLENGES & ARENA HUB (Compact Grid)
        val mistakes by viewModel.mistakesList.collectAsState()
        var showMistakeVaultDialog by remember { mutableStateOf(false) }
        var showFormulaVaultDialog by remember { mutableStateOf(false) }
        var showStudyTimerDialog by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("challenges_arena_hub"),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Row 1: Daily Quest & 1v1 Battle Arena
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Daily Quest Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { viewModel.startDailyChallenge() }
                        .testTag("daily_quest_banner"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF)
                    ),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF4338CA) else Color(0xFFC7D2FE))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("🎯", fontSize = 18.sp)
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFFF59E0B)
                            ) {
                                Text(
                                    text = "2X XP",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = Translator.translate("daily_challenge", currentLang),
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFE0E7FF) else Color(0xFF1E1B4B),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Daily Challenge",
                            fontSize = 10.5.sp,
                            color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF4F46E5),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // 1v1 Battle Arena Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { viewModel.startBattleArena() }
                        .testTag("battle_arena_banner"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF3B0764) else Color(0xFFFDF4FF)
                    ),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF7E22CE) else Color(0xFFF0ABFC))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("⚔️", fontSize = 18.sp)
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFFE11D48)
                            ) {
                                Text(
                                    text = "LIVE",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "1 vs 1 Battle",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFF5D0FE) else Color(0xFF701A75),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Duel classmates",
                            fontSize = 10.5.sp,
                            color = if (isDark) Color(0xFFE879F9) else Color(0xFF9333EA),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // Row 2: 60s Quiz Blitz & Mistake Vault
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // 60s Blitz Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { viewModel.startQuizBlitz(selectedStd) }
                        .testTag("quiz_blitz_banner"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF4C0519) else Color(0xFFFFF1F2)
                    ),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF9F1239) else Color(0xFFFECDD3))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("⚡", fontSize = 18.sp)
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFFE11D48)
                            ) {
                                Text(
                                    text = "SPEED",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "60s Quiz Blitz",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFFFE4E6) else Color(0xFF881337),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "+3s speed sprint",
                            fontSize = 10.5.sp,
                            color = if (isDark) Color(0xFFFDA4AF) else Color(0xFF9F1239),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Mistake Vault Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { showMistakeVaultDialog = true }
                        .testTag("home_mistake_vault_banner"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF450A0A) else Color(0xFFFEF2F2)
                    ),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF7F1D1D) else Color(0xFFFCA5A5))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("🧠", fontSize = 18.sp)
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFFDC2626)
                            ) {
                                Text(
                                    text = "${mistakes.size}",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "Mistake Vault",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFFCA5A5) else Color(0xFF7F1D1D),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (mistakes.isEmpty()) "0 mistakes 🌟" else "${mistakes.size} to review",
                            fontSize = 10.5.sp,
                            color = if (isDark) Color(0xFFFECDD3) else Color(0xFF991B1B),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // Row 3: Formula Vault (ಸೂತ್ರ ಭಂಡಾರ) & Study Focus Timer
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Formula Vault Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { showFormulaVaultDialog = true }
                        .testTag("home_formula_vault_card"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF0C4A6E) else Color(0xFFF0F9FF)
                    ),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF0284C7) else Color(0xFFBAE6FD))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("📐", fontSize = 18.sp)
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFF0284C7)
                            ) {
                                Text(
                                    text = "RULES",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "Formula Vault",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFE0F2FE) else Color(0xFF0369A1),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "ಸೂತ್ರಗಳು & Laws",
                            fontSize = 10.5.sp,
                            color = if (isDark) Color(0xFF7DD3FC) else Color(0xFF0284C7),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Study Focus Timer Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { showStudyTimerDialog = true }
                        .testTag("home_study_focus_timer_card"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF2E1065) else Color(0xFFFAF5FF)
                    ),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF7C3AED) else Color(0xFFDDD6FE))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("⏱️", fontSize = 18.sp)
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFF7C3AED)
                            ) {
                                Text(
                                    text = "FOCUS",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "Focus Timer",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFF3E8FF) else Color(0xFF581C87),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Pomodoro Study",
                            fontSize = 10.5.sp,
                            color = if (isDark) Color(0xFFC4B5FD) else Color(0xFF7C3AED),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }

        if (showMistakeVaultDialog) {
            com.example.ui.mistakes.MistakeVaultDialog(
                viewModel = viewModel,
                onDismiss = { showMistakeVaultDialog = false }
            )
        }

        if (showFormulaVaultDialog) {
            com.example.ui.study.FormulaVaultDialog(
                viewModel = viewModel,
                onDismiss = { showFormulaVaultDialog = false },
                onPracticeFormula = { std, subjectId, unitId ->
                    onStartQuiz(std, subjectId, 1, "${subjectId.replaceFirstChar { it.uppercase() }} Practice")
                }
            )
        }

        if (showStudyTimerDialog) {
            com.example.ui.study.StudyTimerDialog(
                viewModel = viewModel,
                onDismiss = { showStudyTimerDialog = false }
            )
        }

        // 3.8. OFFLINE MODE & CLOUD SYNC INDICATOR
        OfflineModeSyncBanner(
            cloudSyncState = cloudSyncState,
            isDark = isDark,
            onSyncNow = { viewModel.syncWithFirestore() },
            modifier = Modifier.testTag("home_offline_sync_banner")
        )

        // 3.85. OFFLINE DOWNLOADS ROOM VAULT SHORTCUT
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showOfflineManagerDialog = true }
                .testTag("offline_downloads_vault_banner"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF064E3B).copy(alpha = 0.5f) else Color(0xFFECFDF5)
            ),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF059669) else Color(0xFFA7F3D0))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF10B981).copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CloudDone,
                            contentDescription = null,
                            tint = Color(0xFF10B981),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Offline Quizzes (Room)",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF065F46)
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF10B981)
                        ) {
                            Text(
                                text = "${downloadedQuizzes.size} READY",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = if (downloadedQuizzes.isEmpty()) "Tap 📥 next to any quiz or subject to download for 100% offline study"
                                   else "${downloadedQuizzes.sumOf { it.questionCount }} questions saved locally • Tap to manage",
                            fontSize = 12.sp,
                            color = if (isDark) Color(0xFF6EE7B7) else Color(0xFF047857)
                        )
                    }
                }

                FilledTonalButton(
                    onClick = { showOfflineManagerDialog = true },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = if (isDark) Color(0xFF065F46) else Color(0xFFD1FAE5),
                        contentColor = if (isDark) Color(0xFFA7F3D0) else Color(0xFF065F46)
                    ),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier.testTag("manage_offline_quizzes_button")
                ) {
                    Text(
                        text = "Manage 💾",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // 4. SEARCH AND FILTER BAR (Subject, Grade Level, Difficulty)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("quiz_search_and_filter_section"),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text(Translator.translate("search_hint", currentLang), fontSize = 13.sp, color = subtitleColor) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = subtitleColor) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear", tint = subtitleColor)
                        }
                    }
                },
                shape = RoundedCornerShape(16.dp), // rounded-2xl
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("home_search_bar"),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                    unfocusedContainerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                    focusedBorderColor = if (isDark) Color(0xFF4F46E5) else Color(0xFFE2E8F0),
                    unfocusedBorderColor = Color.Transparent,
                    focusedTextColor = titleColor,
                    unfocusedTextColor = titleColor
                ),
                singleLine = true
            )

            // Predictive Search Suggestions Row (Instant matches as student types)
            val predictiveSuggestions = remember(searchQuery, selectedStd) {
                if (searchQuery.isBlank()) {
                    emptyList()
                } else {
                    val stdObj = QuizStaticData.standardsList.find { it.std == selectedStd }
                    val matches = mutableListOf<Triple<String, String, String>>() // (Type, Label, QueryValue)
                    stdObj?.subjects?.forEach { subj ->
                        if (subj.title.contains(searchQuery, ignoreCase = true)) {
                            matches.add(Triple("Subject", subj.title, subj.title))
                        }
                        subj.units.forEach { u ->
                            if (u.name.contains(searchQuery, ignoreCase = true)) {
                                matches.add(Triple("Chapter", u.name, u.name))
                            }
                        }
                    }
                    if ("easy".contains(searchQuery, ignoreCase = true)) matches.add(Triple("Difficulty", "🟢 Easy", "easy"))
                    if ("medium".contains(searchQuery, ignoreCase = true)) matches.add(Triple("Difficulty", "🟡 Medium", "medium"))
                    if ("hard".contains(searchQuery, ignoreCase = true)) matches.add(Triple("Difficulty", "🔴 Hard", "hard"))
                    matches.distinctBy { it.second }.take(6)
                }
            }

            if (predictiveSuggestions.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(vertical = 2.dp)
                        .testTag("predictive_search_suggestions_row"),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Suggestions:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = subtitleColor)
                    predictiveSuggestions.forEachIndexed { idx, (type, label, queryVal) ->
                        SuggestionChip(
                            onClick = {
                                if (type == "Difficulty") {
                                    selectedDifficulty = queryVal
                                    searchQuery = ""
                                } else {
                                    searchQuery = queryVal
                                }
                            },
                            label = {
                                Text(
                                    text = "$label ($type)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                                labelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.testTag("predictive_chip_$idx")
                        )
                    }
                }
            }

            // 1. Class: Horizontal Scrolling Bar (Std 6 to 10, Morarji, NMMS)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .testTag("class_selection_row"),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Class:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = subtitleColor,
                    modifier = Modifier.padding(end = 4.dp)
                )

                val displayedStandards = QuizStaticData.standardsList.filter { standard ->
                    visibleStandards.contains(standard.std)
                }.ifEmpty { QuizStaticData.standardsList }

                displayedStandards.forEach { standardTemplate ->
                    val stdNum = standardTemplate.std
                    val isSelected = selectedStd == stdNum
                    FilterChip(
                        selected = isSelected,
                        onClick = {
                            viewModel.changeStandard(stdNum)
                            viewModel.setSubjectFilter("all")
                            expandedSubjectId = null // close any expandable panels
                        },
                        label = {
                            Text(
                                text = standardTemplate.name,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF4F46E5),
                            selectedLabelColor = Color.White
                        ),
                        modifier = Modifier.testTag("class_card_$stdNum")
                    )
                }
            }

            // 2. Subject: Horizontal Scrolling Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Subject:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = subtitleColor,
                    modifier = Modifier.padding(end = 4.dp)
                )

                val subjectFilterOptions = when (selectedStd) {
                    12 -> listOf(
                        "all" to "All Subjects",
                        "gmat" to "🧩 GMAT",
                        "sat_math" to "📐 SAT (Maths)",
                        "sat_science" to "🔬 SAT (Science)",
                        "sat_social" to "🌍 SAT (ಸಮಾಜವಿಜ್ಞಾನ)"
                    )
                    11 -> listOf(
                        "all" to "All Subjects",
                        "kannada" to "✍️ Kannada",
                        "english" to "📖 English",
                        "math" to "📐 Maths",
                        "general_science" to "🌿 Environmental Studies",
                        "gk" to "💡 GK",
                        "mental_ability" to "🧩 Mental Ability"
                    )
                    else -> listOf(
                        "all" to "All Subjects",
                        "math" to "📐 Math",
                        "science" to "🔬 Science",
                        "english" to "📖 English",
                        "social" to "🌍 Social",
                        "kannada" to "ಕನ್ನಡ",
                        "hindi" to "हिन्दी",
                        "fln" to "💻 FLN (Basics)"
                    )
                }

                subjectFilterOptions.forEach { (subId, label) ->
                    val isSelected = selectedSubjectFilter == subId
                    FilterChip(
                        selected = isSelected,
                        onClick = { viewModel.setSubjectFilter(subId) },
                        label = { Text(label, fontSize = 11.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF4F46E5),
                            selectedLabelColor = Color.White
                        ),
                        modifier = Modifier.testTag("filter_subject_$subId")
                    )
                }
            }

            // 3. Difficulty: Horizontal Scrolling Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Difficulty:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = subtitleColor,
                    modifier = Modifier.padding(end = 4.dp)
                )

                val difficultyOptions = listOf(
                    "all" to "All Levels",
                    "easy" to "🟢 Easy",
                    "medium" to "🟡 Medium",
                    "hard" to "🔴 Hard"
                )

                difficultyOptions.forEach { (diffKey, label) ->
                    val isSelected = selectedDifficulty == diffKey
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedDifficulty = diffKey },
                        label = { Text(label, fontSize = 11.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = when (diffKey) {
                                "easy" -> Color(0xFF10B981)
                                "medium" -> Color(0xFFF59E0B)
                                "hard" -> Color(0xFFEF4444)
                                else -> Color(0xFF4F46E5)
                            },
                            selectedLabelColor = Color.White
                        ),
                        modifier = Modifier.testTag("filter_difficulty_$diffKey")
                    )
                }

                // Dedicated Offline Ready Filter Chip
                FilterChip(
                    selected = showOfflineOnly,
                    onClick = { showOfflineOnly = !showOfflineOnly },
                    label = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (showOfflineOnly) Icons.Default.CloudDone else Icons.Default.CloudDownload,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = if (showOfflineOnly) Color.White else Color(0xFF10B981)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "💾 Offline Ready (${downloadedQuizzes.size})",
                                fontSize = 11.sp,
                                fontWeight = if (showOfflineOnly) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF10B981),
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.testTag("filter_offline_ready")
                )

                if (selectedSubjectFilter != "all" || selectedDifficulty != "all" || showOfflineOnly || searchQuery.isNotEmpty()) {
                    TextButton(
                        onClick = {
                            viewModel.setSubjectFilter("all")
                            selectedDifficulty = "all"
                            showOfflineOnly = false
                            searchQuery = ""
                        },
                        modifier = Modifier.testTag("clear_all_filters_button")
                    ) {
                        Text("Reset Filters ✕", fontSize = 11.sp, color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }

        // 5.5. PERSONALIZED QUIZ RECOMMENDATIONS (ROOM DATA HEURISTICS)
        RecommendedQuizzesSection(
            recommendations = recommendations,
            categorySummaries = categorySummaries,
            isDark = isDark,
            onStartQuiz = onStartQuiz
        )

        // 6. SUBJECTS & EXPANDABLE UNITS VERTICAL LIST
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            val selectedStdName = when (selectedStd) {
                11 -> "Morarji"
                12 -> "NMMS"
                else -> "${Translator.translate("std", currentLang)} $selectedStd"
            }
            Text(
                text = "${Translator.translate("subjects", currentLang)} ($selectedStdName)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = titleColor
            )

            // Locate subjects configured for current selected standard
            val standardTemplate = QuizStaticData.standardsList.find { it.std == selectedStd }
            val subjects = standardTemplate?.subjects ?: emptyList()

            // Filter subjects by subject filter, search query, difficulty, and offline download status
            val filteredSubjects = subjects.filter { subj ->
                val matchesSubject = selectedSubjectFilter == "all" || subj.id.equals(selectedSubjectFilter, ignoreCase = true)
                val hasMatchingUnits = subj.units.any { u ->
                    val matchesSearch = searchQuery.isEmpty() ||
                            u.name.contains(searchQuery, ignoreCase = true) ||
                            subj.title.contains(searchQuery, ignoreCase = true)
                    val matchesDifficulty = selectedDifficulty == "all" ||
                            u.difficulty.equals(selectedDifficulty, ignoreCase = true)
                    val isDownloaded = downloadedQuizzes.any { it.stdId == selectedStd && it.subjectId == subj.id && it.unitId == u.id }
                    val matchesOffline = !showOfflineOnly || isDownloaded
                    matchesSearch && matchesDifficulty && matchesOffline
                }
                matchesSubject && hasMatchingUnits
            }

            if (filteredSubjects.isEmpty()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .testTag("quiz_library_empty_state_card"),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = cardBorder
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(if (showOfflineOnly) "📥" else "🔍", fontSize = 32.sp)
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Text(
                            text = if (showOfflineOnly) "No Offline Quizzes Here" else "No Quizzes Found",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = if (showOfflineOnly) "You haven't downloaded any quizzes for this filter. Tap the 📥 download icon on any quiz to save it for 100% offline study!"
                                   else "We couldn't find any subjects or chapters matching \"$searchQuery\" with the current filters.",
                            style = MaterialTheme.typography.bodySmall,
                            color = subtitleColor,
                            textAlign = TextAlign.Center,
                            lineHeight = 16.sp,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                searchQuery = ""
                                viewModel.setSubjectFilter("all")
                                selectedDifficulty = "all"
                                showOfflineOnly = false
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.testTag("empty_state_clear_filters_button")
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Clear Filters & Show All", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            } else {
                filteredSubjects.forEach { subject ->
                    val color = Color(subject.colorHex)
                    val isExpanded = expandedSubjectId == subject.id || searchQuery.isNotEmpty()

                    // Compute overall subject progress %
                    val progressForSubj = progressList.filter { it.stdId == selectedStd && it.subjectId == subject.id }
                    val attemptedSubjCount = progressForSubj.count { it.progress > 0 }
                    val avgSubjPercentage = if (attemptedSubjCount > 0) {
                        progressForSubj.filter { it.progress > 0 }.map { it.progress }.average().toInt()
                    } else 0

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateContentSize(animationSpec = tween(durationMillis = 300))
                            .testTag("subject_card_${subject.id}"),
                        shape = RoundedCornerShape(24.dp), // rounded-3xl
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        border = cardBorder,
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        onClick = {
                            expandedSubjectId = if (isExpanded) null else subject.id
                        }
                    ) {
                        Column {
                            // Subject Primary Row
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Rounded-2xl dynamic background container
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .clip(RoundedCornerShape(16.dp)) // rounded-2xl
                                        .background(color.copy(alpha = 0.12f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    val icon = when (subject.iconName) {
                                        "kannada" -> "✍️"
                                        "english" -> "🔤"
                                        "hindi" -> "🇮🇳"
                                        "math" -> "📐"
                                        "science" -> "🔬"
                                        "social" -> "🌍"
                                        "computer" -> "💻"
                                        "general_science" -> "🌿"
                                        "gk" -> "💡"
                                        "mental_ability" -> "🧩"
                                        else -> "📚"
                                    }
                                    Text(icon, fontSize = 20.sp)
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = subject.title,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = titleColor
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        LinearProgressIndicator(
                                            progress = { avgSubjPercentage / 100f },
                                            modifier = Modifier
                                                .width(96.dp)
                                                .height(6.dp)
                                                .clip(RoundedCornerShape(3.dp)),
                                            color = color,
                                            trackColor = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9)
                                        )
                                        Text(
                                            text = "$avgSubjPercentage%",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = color
                                        )
                                    }
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "${subject.units.size} U",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = subtitleColor,
                                        modifier = Modifier.padding(end = 4.dp)
                                    )
                                    Icon(
                                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                        contentDescription = "Expand",
                                        tint = subtitleColor
                                    )
                                }
                            }

                            // Expandable Units list Detail block
                            if (isExpanded) {
                                HorizontalDivider(color = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9))

                                Column(
                                    modifier = Modifier
                                        .background(if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC))
                                        .padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    val filteredUnits = subject.units.filter { unit ->
                                        val matchesSearch = searchQuery.isEmpty() ||
                                                unit.name.contains(searchQuery, ignoreCase = true) ||
                                                subject.title.contains(searchQuery, ignoreCase = true)
                                        val matchesDiff = selectedDifficulty == "all" ||
                                                unit.difficulty.equals(selectedDifficulty, ignoreCase = true)
                                        val isDownloaded = downloadedQuizzes.any { it.stdId == selectedStd && it.subjectId == subject.id && it.unitId == unit.id }
                                        val matchesOffline = !showOfflineOnly || isDownloaded
                                        matchesSearch && matchesDiff && matchesOffline
                                    }

                                    // Subject Level Offline Batch Download Bar
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 4.dp, vertical = 2.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        val downloadedInSubject = subject.units.count { u ->
                                            downloadedQuizzes.any { it.stdId == selectedStd && it.subjectId == subject.id && it.unitId == u.id }
                                        }
                                        Text(
                                            text = if (downloadedInSubject == subject.units.size) "💾 All ${subject.units.size} units ready offline"
                                                   else "💾 $downloadedInSubject of ${subject.units.size} offline (Room DB)",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (downloadedInSubject > 0) Color(0xFF10B981) else subtitleColor
                                        )
                                        TextButton(
                                            onClick = {
                                                viewModel.downloadAllQuizzesForSubject(selectedStd, subject.id) { total ->
                                                    Toast.makeText(context, "Saved $total units for offline play!", Toast.LENGTH_SHORT).show()
                                                }
                                            },
                                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                            modifier = Modifier.testTag("download_all_${subject.id}_button")
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.CloudDownload,
                                                contentDescription = null,
                                                modifier = Modifier.size(15.dp),
                                                tint = color
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = "Download All",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = color
                                            )
                                        }
                                    }

                                    filteredUnits.forEach { unit ->
                                        // Fetch progress for this specific unit
                                        val progressRecord = progressList.find {
                                            it.stdId == selectedStd && it.subjectId == subject.id && it.unitId == unit.id
                                        }
                                        val percent = progressRecord?.progress ?: 0
                                        val isUnitDownloaded = downloadedQuizzes.any {
                                            it.stdId == selectedStd && it.subjectId == subject.id && it.unitId == unit.id
                                        }
                                        val isUnitDownloading = downloadingUnits.contains("${selectedStd}_${subject.id}_${unit.id}")

                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .testTag("unit_card_${subject.id}_${unit.id}"),
                                            shape = RoundedCornerShape(16.dp),
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
                                                // 1. Full-width Unit Title: Clear text with natural wrapping
                                                Text(
                                                    text = "${Translator.translate("unit", currentLang)} ${unit.id}: ${unit.name}",
                                                    fontWeight = FontWeight.ExtraBold,
                                                    fontSize = 14.5.sp,
                                                    color = titleColor,
                                                    maxLines = 2,
                                                    overflow = TextOverflow.Ellipsis,
                                                    modifier = Modifier.fillMaxWidth()
                                                )

                                                Spacer(modifier = Modifier.height(10.dp))

                                                // 2. Metadata & Action Buttons Row (Optimized for Mobile)
                                                // 2. Metadata & Action Buttons Row (Small equal size in a single horizontal line, perfectly aligned with no overflow)
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                                                ) {
                                                    val difficultyKey = when (unit.difficulty) {
                                                        "Easy" -> "easy"
                                                        "Medium" -> "medium"
                                                        "Hard" -> "hard"
                                                        else -> "medium"
                                                    }

                                                    val difficultyColor = when (unit.difficulty) {
                                                        "Easy" -> Color(0xFF10B981) // emerald-500
                                                        "Medium" -> Color(0xFFF59E0B) // amber-500
                                                        "Hard" -> Color(0xFFEF4444) // red-500
                                                        else -> Color.Gray
                                                    }

                                                    // 1. Difficulty Level (Small equal-sized chip)
                                                    Box(
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .height(30.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(difficultyColor.copy(alpha = 0.12f))
                                                            .border(BorderStroke(0.8.dp, difficultyColor.copy(alpha = 0.35f)), RoundedCornerShape(8.dp)),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = Translator.translate(difficultyKey, currentLang),
                                                            fontSize = 9.5.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = difficultyColor,
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                    }

                                                    // 2. No. of Questions (Small equal-sized chip)
                                                    Box(
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .height(30.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9))
                                                            .border(BorderStroke(0.8.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)), RoundedCornerShape(8.dp)),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = "📝 ${unit.totalQuestions} Q",
                                                            fontSize = 9.5.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = subtitleColor,
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                    }

                                                    // 3. Offline Play Button (Small equal-sized button)
                                                    Box(
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .height(30.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(
                                                                if (isUnitDownloaded) Color(0xFF10B981).copy(alpha = 0.15f)
                                                                else if (isUnitDownloading) Color(0xFF6366F1).copy(alpha = 0.15f)
                                                                else if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9)
                                                            )
                                                            .border(
                                                                BorderStroke(
                                                                    0.8.dp,
                                                                    if (isUnitDownloaded) Color(0xFF10B981).copy(alpha = 0.4f)
                                                                    else if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                                                                ),
                                                                RoundedCornerShape(8.dp)
                                                            )
                                                            .clickable {
                                                                if (isUnitDownloaded) {
                                                                    Toast.makeText(
                                                                        context,
                                                                        "'${unit.name}' is saved locally for offline play (${unit.totalQuestions} Qs in Room DB)",
                                                                        Toast.LENGTH_SHORT
                                                                    ).show()
                                                                } else if (!isUnitDownloading) {
                                                                    viewModel.downloadQuizForOffline(selectedStd, subject.id, unit.id, unit.name) { success ->
                                                                        if (success) {
                                                                            Toast.makeText(context, "Saved '${unit.name}' for offline play!", Toast.LENGTH_SHORT).show()
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            .testTag("download_button_${subject.id}_${unit.id}"),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        if (isUnitDownloading) {
                                                            CircularProgressIndicator(
                                                                modifier = Modifier.size(13.dp),
                                                                strokeWidth = 2.dp,
                                                                color = Color(0xFF6366F1)
                                                            )
                                                        } else if (isUnitDownloaded) {
                                                            Icon(
                                                                imageVector = Icons.Default.CloudDone,
                                                                contentDescription = "Downloaded for offline play",
                                                                tint = Color(0xFF10B981),
                                                                modifier = Modifier.size(16.dp)
                                                            )
                                                        } else {
                                                            Icon(
                                                                imageVector = Icons.Default.CloudDownload,
                                                                contentDescription = "Download for offline play",
                                                                tint = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B),
                                                                modifier = Modifier.size(16.dp)
                                                            )
                                                        }
                                                    }

                                                    // 4. Card Display Button (Flashcards quick revision, small equal-sized button)
                                                    Box(
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .height(30.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(color.copy(alpha = 0.12f))
                                                            .border(BorderStroke(0.8.dp, color.copy(alpha = 0.35f)), RoundedCornerShape(8.dp))
                                                            .clickable {
                                                                viewModel.startFlashcards(selectedStd, subject.id, unit.id, unit.name)
                                                            }
                                                            .testTag("flashcard_button_${subject.id}_${unit.id}"),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text("🗂️", fontSize = 13.sp)
                                                    }

                                                    // 5. Quiz Play Button (Small equal-sized action button)
                                                    Box(
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .height(30.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(color)
                                                            .clickable {
                                                                onStartQuiz(selectedStd, subject.id, unit.id, unit.name)
                                                            }
                                                            .testTag("play_button_${subject.id}_${unit.id}"),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Icon(
                                                            imageVector = Icons.Default.PlayArrow,
                                                            contentDescription = Translator.translate("play", currentLang),
                                                            tint = Color.White,
                                                            modifier = Modifier.size(17.dp)
                                                        )
                                                    }
                                                }

                                                Spacer(modifier = Modifier.height(10.dp))

                                                // 3. Progress percentage bar
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    LinearProgressIndicator(
                                                        progress = { percent / 100f },
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .height(6.dp)
                                                            .clip(RoundedCornerShape(3.dp)),
                                                        color = color,
                                                        trackColor = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9)
                                                    )
                                                    Spacer(modifier = Modifier.width(8.dp))
                                                    Text(
                                                        text = "$percent%",
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = color,
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
                }
            }
        }
    }

    // Offline Quizzes Room Storage Manager Dialog
    if (showOfflineManagerDialog) {
        OfflineQuizzesDialog(
            viewModel = viewModel,
            onDismiss = { showOfflineManagerDialog = false },
            onStartQuiz = onStartQuiz
        )
    }
}

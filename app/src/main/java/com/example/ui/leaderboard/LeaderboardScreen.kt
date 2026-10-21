package com.example.ui.leaderboard

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.QuizViewModel
import com.example.localization.LocalAppStrings

/**
 * Rich model representing a student in the Classroom and Global Leaderboard.
 */
data class StudentLeaderboardEntry(
    val id: String,
    val name: String,
    val standard: Int,
    val school: String,
    val avatarEmoji: String,
    val xp: Int,
    val coins: Int,
    val stars: Int,
    val quizzesCompleted: Int,
    val accuracy: Int,
    val streakDays: Int,
    val titleBadge: String,
    val favoriteSubject: String,
    val motto: String,
    val isMe: Boolean = false,
    val rank: Int = 0,
    val weeklyXp: Int = 0,
    val kudosCount: Int = 0
)

enum class LeaderboardScope {
    CLASSROOM,
    GLOBAL
}

enum class LeaderboardTimeframe {
    WEEKLY,
    ALL_TIME
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardScreen(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {},
    onNavigateToBattle: () -> Unit = {}
) {
    val context = LocalContext.current
    val userProfile by viewModel.userProfile.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val strings = LocalAppStrings.current

    // Scope & Timeframe controls
    var currentScope by remember { mutableStateOf(LeaderboardScope.CLASSROOM) }
    var currentTimeframe by remember { mutableStateOf(LeaderboardTimeframe.WEEKLY) }
    var selectedGradeFilter by remember { mutableIntStateOf(0) } // 0 = All/Default for scope

    // Selected student for detailed profile modal
    var inspectedStudent by remember { mutableStateOf<StudentLeaderboardEntry?>(null) }

    // Dynamic kudos state map (StudentId -> Kudos Count)
    val kudosMap = remember { mutableStateMapOf<String, Int>() }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9))

    // Base roster of high-achieving Karnataka students across various grades
    val staticPeers = remember {
        listOf(
            StudentLeaderboardEntry(
                id = "prajwal_k",
                name = "Prajwal K.",
                standard = 8,
                school = "Govt Model High, Bengaluru",
                avatarEmoji = "🦁",
                xp = 2450,
                coins = 480,
                stars = 72,
                quizzesCompleted = 26,
                accuracy = 94,
                streakDays = 12,
                titleBadge = "Math Prodigy",
                favoriteSubject = "Mathematics",
                motto = "Consistency and regular practice turn hard problems into simple fun!",
                weeklyXp = 560,
                kudosCount = 34
            ),
            StudentLeaderboardEntry(
                id = "sneha_rao",
                name = "Sneha Rao",
                standard = 8,
                school = "Sharada Vidyalaya, Mysuru",
                avatarEmoji = "🦋",
                xp = 2180,
                coins = 390,
                stars = 64,
                quizzesCompleted = 23,
                accuracy = 92,
                streakDays = 9,
                titleBadge = "Science Whiz",
                favoriteSubject = "Science",
                motto = "Curiosity is the engine of discovery. Keep asking questions!",
                weeklyXp = 490,
                kudosCount = 42
            ),
            StudentLeaderboardEntry(
                id = "ananya_hegde",
                name = "Ananya Hegde",
                standard = 9,
                school = "Sir M.V. High, Shivamogga",
                avatarEmoji = "🌺",
                xp = 2680,
                coins = 520,
                stars = 81,
                quizzesCompleted = 29,
                accuracy = 96,
                streakDays = 15,
                titleBadge = "Physics Champion",
                favoriteSubject = "Science",
                motto = "Aim for excellence, and success will naturally follow.",
                weeklyXp = 610,
                kudosCount = 51
            ),
            StudentLeaderboardEntry(
                id = "darshan_m",
                name = "Darshan M.",
                standard = 10,
                school = "Kendriya Vidyalaya, Davanagere",
                avatarEmoji = "🦅",
                xp = 2920,
                coins = 610,
                stars = 92,
                quizzesCompleted = 32,
                accuracy = 95,
                streakDays = 18,
                titleBadge = "Board Exam Ace",
                favoriteSubject = "Social Science",
                motto = "Small daily improvements over time lead to stunning achievements.",
                weeklyXp = 680,
                kudosCount = 63
            ),
            StudentLeaderboardEntry(
                id = "akshay_n",
                name = "Akshay N.",
                standard = 8,
                school = "National High School, Hubballi",
                avatarEmoji = "🚀",
                xp = 1850,
                coins = 310,
                stars = 48,
                quizzesCompleted = 19,
                accuracy = 89,
                streakDays = 7,
                titleBadge = "History Explorer",
                favoriteSubject = "Social Science",
                motto = "History teaches us how to shape tomorrow with wisdom.",
                weeklyXp = 380,
                kudosCount = 28
            ),
            StudentLeaderboardEntry(
                id = "tejas_gowda",
                name = "Tejas Gowda",
                standard = 8,
                school = "Adarsha Vidyalaya, Belagavi",
                avatarEmoji = "⚡",
                xp = 1620,
                coins = 270,
                stars = 42,
                quizzesCompleted = 16,
                accuracy = 86,
                streakDays = 6,
                titleBadge = "Kannada Scholar",
                favoriteSubject = "Kannada",
                motto = "Dedication and pride in our mother tongue and learning.",
                weeklyXp = 310,
                kudosCount = 22
            ),
            StudentLeaderboardEntry(
                id = "kavya_s",
                name = "Kavya S.",
                standard = 8,
                school = "St. Joseph's, Mangaluru",
                avatarEmoji = "🐬",
                xp = 1450,
                coins = 240,
                stars = 38,
                quizzesCompleted = 14,
                accuracy = 88,
                streakDays = 5,
                titleBadge = "Speed Solver",
                favoriteSubject = "English",
                motto = "Every mistake is a stepping stone to mastery.",
                weeklyXp = 290,
                kudosCount = 19
            ),
            StudentLeaderboardEntry(
                id = "rohan_patil",
                name = "Rohan Patil",
                standard = 7,
                school = "Rotary School, Kalaburagi",
                avatarEmoji = "🐯",
                xp = 1980,
                coins = 350,
                stars = 53,
                quizzesCompleted = 21,
                accuracy = 91,
                streakDays = 11,
                titleBadge = "Grammar Master",
                favoriteSubject = "English",
                motto = "Words have the power to illuminate the mind!",
                weeklyXp = 440,
                kudosCount = 37
            ),
            StudentLeaderboardEntry(
                id = "divya_bhat",
                name = "Divya Bhat",
                standard = 6,
                school = "Chinmaya Vidyalaya, Udupi",
                avatarEmoji = "🌟",
                xp = 1720,
                coins = 290,
                stars = 45,
                quizzesCompleted = 18,
                accuracy = 90,
                streakDays = 8,
                titleBadge = "Bright Spark",
                favoriteSubject = "Science",
                motto = "Stay curious, stay inspired, and never stop reading.",
                weeklyXp = 390,
                kudosCount = 25
            ),
            StudentLeaderboardEntry(
                id = "manoj_kumar",
                name = "Manoj Kumar",
                standard = 10,
                school = "Sainik School, Vijayapura",
                avatarEmoji = "🎖️",
                xp = 2810,
                coins = 590,
                stars = 87,
                quizzesCompleted = 31,
                accuracy = 96,
                streakDays = 16,
                titleBadge = "Speed Runner",
                favoriteSubject = "Mathematics",
                motto = "Discipline builds character, character builds champions.",
                weeklyXp = 640,
                kudosCount = 58
            ),
            StudentLeaderboardEntry(
                id = "spoorthi_joshi",
                name = "Spoorthi Joshi",
                standard = 9,
                school = "Alva's High School, Moodabidri",
                avatarEmoji = "🕊️",
                xp = 2390,
                coins = 430,
                stars = 69,
                quizzesCompleted = 25,
                accuracy = 93,
                streakDays = 14,
                titleBadge = "Biology Genius",
                favoriteSubject = "Science",
                motto = "Nature holds the most fascinating secrets to learn.",
                weeklyXp = 520,
                kudosCount = 44
            ),
            StudentLeaderboardEntry(
                id = "keerthana_r",
                name = "Keerthana R.",
                standard = 6,
                school = "Lions School, Hassan",
                avatarEmoji = "🦄",
                xp = 1590,
                coins = 260,
                stars = 39,
                quizzesCompleted = 15,
                accuracy = 87,
                streakDays = 7,
                titleBadge = "Word Wizard",
                favoriteSubject = "Kannada",
                motto = "Learning a little every day builds a mountain of knowledge.",
                weeklyXp = 330,
                kudosCount = 21
            )
        )
    }

    // Build current student entry dynamically from live UserProfile
    val userStandard = userProfile?.standard ?: 8
    val userXp = userProfile?.xp ?: 1250
    val userCoins = userProfile?.coins ?: 240
    val userStars = userProfile?.stars ?: 45
    val userName = userProfile?.name?.ifBlank { "You (Scholar)" } ?: "You (Scholar)"
    val userStreak = userProfile?.attendanceStreak ?: 5

    val myLiveEntry = remember(userProfile, userXp, userCoins, userStars, userName, userStreak, userStandard) {
        StudentLeaderboardEntry(
            id = "me_user_active",
            name = userName,
            standard = userStandard,
            school = "Karnataka State Board",
            avatarEmoji = "🎓",
            xp = userXp,
            coins = userCoins,
            stars = userStars,
            quizzesCompleted = (userXp / 80).coerceAtLeast(12),
            accuracy = 91,
            streakDays = userStreak,
            titleBadge = if (userXp > 2000) "Diamond Scholar" else if (userXp > 1500) "Star Achiever" else "Rising Star",
            favoriteSubject = "Science",
            motto = "Striving for excellence with every single quiz!",
            isMe = true,
            weeklyXp = (userXp * 0.35f).toInt().coerceAtLeast(150),
            kudosCount = 18
        )
    }

    // Assemble and filter leaderboard based on active scope & timeframe
    val displayedLeaderboard = remember(
        currentScope,
        currentTimeframe,
        selectedGradeFilter,
        staticPeers,
        myLiveEntry,
        userStandard
    ) {
        val allStudents = (staticPeers + myLiveEntry)

        val filtered = when (currentScope) {
            LeaderboardScope.CLASSROOM -> {
                val targetGrade = if (selectedGradeFilter > 0) selectedGradeFilter else userStandard
                allStudents.filter { it.standard == targetGrade }
            }
            LeaderboardScope.GLOBAL -> {
                if (selectedGradeFilter > 0) {
                    allStudents.filter { it.standard == selectedGradeFilter }
                } else {
                    allStudents
                }
            }
        }

        // Sort based on Timeframe: Weekly XP vs All-time XP
        val sorted = if (currentTimeframe == LeaderboardTimeframe.WEEKLY) {
            filtered.sortedByDescending { it.weeklyXp }
        } else {
            filtered.sortedByDescending { it.xp }
        }

        sorted.mapIndexed { index, student ->
            student.copy(rank = index + 1)
        }
    }

    // Current user's rank in this list
    val myCurrentRankItem = displayedLeaderboard.find { it.isMe }
    val myCurrentRank = myCurrentRankItem?.rank ?: 1

    // Identify student right ahead of the user for Healthy Competition Motivation Card
    val studentAhead = remember(displayedLeaderboard, myCurrentRank) {
        if (myCurrentRank > 1) {
            displayedLeaderboard.getOrNull(myCurrentRank - 2) // rank is 1-indexed, so ahead is index myCurrentRank - 2
        } else {
            null
        }
    }

    val studentBehind = remember(displayedLeaderboard, myCurrentRank) {
        if (myCurrentRank < displayedLeaderboard.size) {
            displayedLeaderboard.getOrNull(myCurrentRank)
        } else {
            null
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Pinned/Hero Standing Card
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("pinned_my_rank_bar"),
            shape = RoundedCornerShape(16.dp),
            color = if (isDark) Color(0xFF1E1B4B).copy(alpha = 0.6f) else Color(0xFFEEF2FF),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF4338CA) else Color(0xFFC7D2FE))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    listOf(Color(0xFF6366F1), Color(0xFF8B5CF6))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(myLiveEntry.avatarEmoji, fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Your Standing",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = subtitleColor
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFF6366F1).copy(alpha = 0.15f)
                            ) {
                                val userStdLabel = when (userStandard) {
                                    11 -> "Morarji"
                                    12 -> "NMMS"
                                    else -> "Class Std $userStandard"
                                }
                                Text(
                                    text = if (currentScope == LeaderboardScope.CLASSROOM) userStdLabel else "Karnataka State",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF6366F1),
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "Rank #$myCurrentRank • ${if (currentTimeframe == LeaderboardTimeframe.WEEKLY) "${myLiveEntry.weeklyXp} Wk XP" else "${myLiveEntry.xp} Total XP"}",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor
                        )
                    }
                }

                Button(
                    onClick = onNavigateToHome,
                    modifier = Modifier
                        .height(36.dp)
                        .testTag("pinned_earn_xp_button"),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6366F1)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Earn XP",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(13.dp)
                        )
                    }
                }
            }
        }
            // Header Section
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "🏆 Student Leaderboard",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor,
                            modifier = Modifier.testTag("leaderboard_title")
                        )
                        Text(
                            text = "Compete, inspire, and grow together in healthy academic competition!",
                            style = MaterialTheme.typography.bodySmall,
                            color = subtitleColor
                        )
                    }
                }

                // Attendance Streak Banner
                userProfile?.let { profile ->
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = Color(0xFFEA580C).copy(alpha = 0.1f),
                        border = BorderStroke(1.dp, Color(0xFFEA580C).copy(alpha = 0.35f)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("leaderboard_attendance_streak_bar")
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🔥", fontSize = 16.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "${profile.attendanceStreak} Days Active Streak",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 12.5.sp,
                                    color = Color(0xFFEA580C)
                                )
                            }

                            Text(
                                text = "Every quiz adds to your class standing!",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isDark) Color(0xFFFDBA74) else Color(0xFFC2410C)
                            )
                        }
                    }
                }
            }

            // PRIMARY SCOPE TOGGLE: Classroom vs Global
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("leaderboard_scope_segmented_row")
            ) {
                SegmentedButton(
                    selected = currentScope == LeaderboardScope.CLASSROOM,
                    onClick = {
                        currentScope = LeaderboardScope.CLASSROOM
                        selectedGradeFilter = 0
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = 0, count = 2)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🏫 ", fontSize = 14.sp)
                        Text("Classroom Standings", fontWeight = FontWeight.Bold)
                    }
                }
                SegmentedButton(
                    selected = currentScope == LeaderboardScope.GLOBAL,
                    onClick = {
                        currentScope = LeaderboardScope.GLOBAL
                        selectedGradeFilter = 0
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = 1, count = 2)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🌍 ", fontSize = 14.sp)
                        Text("State-Wide Global", fontWeight = FontWeight.Bold)
                    }
                }
            }

            // TIMEFRAME & GRADE FILTER ROW
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Weekly vs All-Time Tabs
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9))
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(9.dp),
                        color = if (currentTimeframe == LeaderboardTimeframe.WEEKLY) Color(0xFF6366F1) else Color.Transparent,
                        modifier = Modifier
                            .clickable { currentTimeframe = LeaderboardTimeframe.WEEKLY }
                            .testTag("tab_weekly_leaders")
                    ) {
                        Text(
                            text = "⚡ Weekly Sprint",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (currentTimeframe == LeaderboardTimeframe.WEEKLY) Color.White else subtitleColor,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(9.dp),
                        color = if (currentTimeframe == LeaderboardTimeframe.ALL_TIME) Color(0xFF6366F1) else Color.Transparent,
                        modifier = Modifier
                            .clickable { currentTimeframe = LeaderboardTimeframe.ALL_TIME }
                            .testTag("tab_alltime_legends")
                    ) {
                        Text(
                            text = "👑 All-Time",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (currentTimeframe == LeaderboardTimeframe.ALL_TIME) Color.White else subtitleColor,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }

                // Classroom/Grade selector tag
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFF10B981).copy(alpha = 0.12f),
                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.3f))
                ) {
                    Text(
                        text = if (currentScope == LeaderboardScope.CLASSROOM) "Grade $userStandard Peers" else "All Karnataka Schools",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF047857),
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }

            // Grade filter chips (Scrollable)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = selectedGradeFilter == 0,
                    onClick = { selectedGradeFilter = 0 },
                    label = {
                        val myClassTitle = when (userStandard) {
                            11 -> "Morarji Class"
                            12 -> "NMMS Class"
                            else -> "My Class (Std $userStandard)"
                        }
                        Text(
                            text = if (currentScope == LeaderboardScope.CLASSROOM) myClassTitle else "All Standards",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
                listOf(6 to "Std 6", 7 to "Std 7", 8 to "Std 8", 9 to "Std 9", 10 to "Std 10", 11 to "Morarji", 12 to "NMMS").forEach { (grade, label) ->
                    FilterChip(
                        selected = selectedGradeFilter == grade,
                        onClick = { selectedGradeFilter = grade },
                        label = {
                            Text(
                                text = label,
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )
                }
            }

            // HEALTHY COMPETITION: "CATCH UP CHALLENGE" / "GAP TO NEXT RANK" CARD
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("healthy_competition_motivation_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF)
                ),
                border = BorderStroke(1.5.dp, Color(0xFF6366F1).copy(alpha = 0.7f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🎯", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Academic Motivation & Growth",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF4338CA)
                            )
                        }
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF6366F1).copy(alpha = 0.2f)
                        ) {
                            Text(
                                text = "Healthy Competition",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4338CA),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    if (myCurrentRank == 1) {
                        Text(
                            text = "👑 Outstanding Work! You're holding Rank #1 in ${if (currentScope == LeaderboardScope.CLASSROOM) "your classroom" else "the state"} with ${if (currentTimeframe == LeaderboardTimeframe.WEEKLY) myLiveEntry.weeklyXp else myLiveEntry.xp} XP! Keep taking quizzes to defend your title and help inspire classmates!",
                            fontSize = 12.sp,
                            color = if (isDark) Color(0xFFC7D2FE) else Color(0xFF3730A3),
                            lineHeight = 17.sp
                        )
                    } else if (studentAhead != null) {
                        val aheadXp = if (currentTimeframe == LeaderboardTimeframe.WEEKLY) studentAhead.weeklyXp else studentAhead.xp
                        val myScoreXp = if (currentTimeframe == LeaderboardTimeframe.WEEKLY) myLiveEntry.weeklyXp else myLiveEntry.xp
                        val gap = (aheadXp - myScoreXp).coerceAtLeast(10)

                        Text(
                            text = "You are currently Rank #$myCurrentRank! You only need $gap more XP to overtake ${studentAhead.name} for Rank #${studentAhead.rank}! Complete 1 high-accuracy chapter quiz to climb the rankings.",
                            fontSize = 12.sp,
                            color = if (isDark) Color(0xFFC7D2FE) else Color(0xFF3730A3),
                            lineHeight = 17.sp
                        )
                    } else {
                        Text(
                            text = "Every quiz you complete earns valuable Experience Points (XP) and advances your standing among classmates! Challenge your friends to test knowledge together.",
                            fontSize = 12.sp,
                            color = if (isDark) Color(0xFFC7D2FE) else Color(0xFF3730A3),
                            lineHeight = 17.sp
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = onNavigateToHome,
                            modifier = Modifier
                                .weight(1f)
                                .height(40.dp)
                                .testTag("challenge_take_quiz_button"),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF6366F1)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Take Quiz ➔",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        OutlinedButton(
                            onClick = onNavigateToBattle,
                            modifier = Modifier
                                .weight(0.8f)
                                .height(40.dp)
                                .testTag("challenge_duel_button"),
                            border = BorderStroke(1.dp, Color(0xFF6366F1)),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "⚔️ 1v1 Duel",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6366F1),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            // TOP 3 PODIUM SHOWCASE
            if (displayedLeaderboard.size >= 3) {
                PodiumCard(
                    topUsers = displayedLeaderboard.take(3),
                    isWeekly = currentTimeframe == LeaderboardTimeframe.WEEKLY,
                    isDark = isDark,
                    onStudentClick = { inspectedStudent = it },
                    onCheer = { student ->
                        val current = kudosMap[student.id] ?: student.kudosCount
                        kudosMap[student.id] = current + 1
                        Toast.makeText(context, "High-five sent to ${student.name}! ✋✨", Toast.LENGTH_SHORT).show()
                    }
                )
            }

            // ALL RANKINGS TITLE & ACTIVE COUNT
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (currentScope == LeaderboardScope.CLASSROOM) "🏫 Classmates Roster" else "🌍 Top Karnataka Scholars",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor
                )
                Text(
                    text = "${displayedLeaderboard.size} Students Ranked",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = subtitleColor
                )
            }

            // FULL STUDENT RANKINGS LIST
            displayedLeaderboard.forEach { student ->
                val rank = student.rank
                val isMe = student.isMe
                val dynamicKudos = kudosMap[student.id] ?: student.kudosCount
                val scoreXp = if (currentTimeframe == LeaderboardTimeframe.WEEKLY) student.weeklyXp else student.xp

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("leaderboard_user_row_$rank")
                        .clickable { inspectedStudent = student },
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isMe) {
                            if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF)
                        } else {
                            MaterialTheme.colorScheme.surface
                        }
                    ),
                    border = if (isMe) {
                        BorderStroke(1.5.dp, Color(0xFF6366F1))
                    } else {
                        cardBorder
                    }
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f).padding(end = 8.dp)
                            ) {
                                // Rank Badge
                                Box(
                                    modifier = Modifier
                                        .size(38.dp)
                                        .clip(CircleShape)
                                        .background(
                                            when (rank) {
                                                1 -> Color(0xFFFEF3C7) // gold
                                                2 -> Color(0xFFE2E8F0) // silver
                                                3 -> Color(0xFFFFEDD5) // bronze
                                                else -> if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9)
                                            }
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = when (rank) {
                                            1 -> "🥇"
                                            2 -> "🥈"
                                            3 -> "🥉"
                                            else -> "#$rank"
                                        },
                                        fontSize = if (rank <= 3) 18.sp else 12.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isDark) Color.White else Color(0xFF1E293B)
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))

                                // Avatar & Name details
                                Column(modifier = Modifier.weight(1f, fill = false)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = student.name,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 14.sp,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            color = titleColor
                                        )
                                        if (isMe) {
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Surface(
                                                shape = RoundedCornerShape(4.dp),
                                                color = Color(0xFF6366F1)
                                            ) {
                                                Text(
                                                    text = "YOU",
                                                    fontSize = 8.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Color.White,
                                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                                )
                                            }
                                        }
                                    }

                                    val studentStdText = when (student.standard) {
                                        11 -> "Morarji"
                                        12 -> "NMMS"
                                        else -> "Std ${student.standard}"
                                    }
                                    Text(
                                        text = "${student.school} • $studentStdText",
                                        fontSize = 10.5.sp,
                                        color = subtitleColor,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            // XP Pill
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = Color(0xFF7C3AED).copy(alpha = 0.12f),
                                border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.25f))
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.End,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Text(
                                        text = "$scoreXp XP",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 13.sp,
                                        color = Color(0xFF7C3AED)
                                    )
                                    Text(
                                        text = if (currentTimeframe == LeaderboardTimeframe.WEEKLY) "Weekly Sprint" else "Total XP",
                                        fontSize = 8.5.sp,
                                        color = Color(0xFF7C3AED).copy(alpha = 0.8f)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Secondary Stats & Mutual Cheer Buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Color(0xFFF59E0B).copy(alpha = 0.12f)
                                ) {
                                    Text(
                                        text = "🎯 ${student.accuracy}% Acc",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFD97706),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Color(0xFFEA580C).copy(alpha = 0.12f)
                                ) {
                                    Text(
                                        text = "🔥 ${student.streakDays}d Streak",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFEA580C),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                Text(
                                    text = student.titleBadge,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = subtitleColor
                                )
                            }

                            // Cheer / High-Five Button
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9),
                                modifier = Modifier
                                    .clickable {
                                        kudosMap[student.id] = dynamicKudos + 1
                                        Toast.makeText(context, "Cheer sent to ${student.name}! 👏✨", Toast.LENGTH_SHORT).show()
                                    }
                                    .testTag("cheer_button_${student.id}")
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text("👏", fontSize = 11.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "$dynamicKudos",
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = subtitleColor
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

    // STUDENT DETAIL INSPECTION DIALOG
    inspectedStudent?.let { student ->
        val dynamicKudos = kudosMap[student.id] ?: student.kudosCount
        Dialog(onDismissRequest = { inspectedStudent = null }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .testTag("student_inspection_dialog"),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E293B) else Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    listOf(Color(0xFF6366F1), Color(0xFFA855F7))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(student.avatarEmoji, fontSize = 36.sp)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = student.name,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = titleColor
                        )
                        val studentStdText = when (student.standard) {
                            11 -> "Morarji"
                            12 -> "NMMS"
                            else -> "Standard ${student.standard}"
                        }
                        Text(
                            text = "${student.school} • $studentStdText",
                            fontSize = 12.sp,
                            color = subtitleColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF6366F1).copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "🏆 ${student.titleBadge}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF6366F1),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    // Stats Grid
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            color = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC),
                            border = cardBorder
                        ) {
                            Column(
                                modifier = Modifier.padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Total XP", fontSize = 10.sp, color = subtitleColor)
                                Text("${student.xp}", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF7C3AED))
                            }
                        }

                        Surface(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            color = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC),
                            border = cardBorder
                        ) {
                            Column(
                                modifier = Modifier.padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Accuracy", fontSize = 10.sp, color = subtitleColor)
                                Text("${student.accuracy}%", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF10B981))
                            }
                        }

                        Surface(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            color = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC),
                            border = cardBorder
                        ) {
                            Column(
                                modifier = Modifier.padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Streak", fontSize = 10.sp, color = subtitleColor)
                                Text("${student.streakDays}d", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFEA580C))
                            }
                        }
                    }

                    // Motto Card
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        color = Color(0xFFF59E0B).copy(alpha = 0.1f),
                        border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.25f))
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("💡 Study Motto", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD97706))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "\"${student.motto}\"",
                                fontSize = 11.5.sp,
                                color = if (isDark) Color(0xFFFDE68A) else Color(0xFF92400E)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = {
                                kudosMap[student.id] = dynamicKudos + 1
                                Toast.makeText(context, "High-five sent to ${student.name}! ✋✨", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Send Cheer 👏 ($dynamicKudos)", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }

                        OutlinedButton(
                            onClick = {
                                inspectedStudent = null
                                onNavigateToBattle()
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Friendly Duel ⚔️", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    TextButton(onClick = { inspectedStudent = null }) {
                        Text("Close", color = subtitleColor)
                    }
                }
            }
        }
    }
}

/**
 * Top 3 Podium component highlighting gold, silver, and bronze places.
 */
@Composable
fun PodiumCard(
    topUsers: List<StudentLeaderboardEntry>,
    isWeekly: Boolean,
    isDark: Boolean,
    onStudentClick: (StudentLeaderboardEntry) -> Unit,
    onCheer: (StudentLeaderboardEntry) -> Unit
) {
    if (topUsers.size < 3) return

    val first = topUsers[0]
    val second = topUsers[1]
    val third = topUsers[2]

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("podium_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
        ),
        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("✨", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "ACADEMIC PODIUM CHAMPIONS",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD97706),
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("✨", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                // 2nd Place (Silver)
                PodiumPillar(
                    user = second,
                    rank = 2,
                    medal = "🥈",
                    height = 58.dp,
                    color = Color(0xFF94A3B8),
                    isWeekly = isWeekly,
                    isDark = isDark,
                    modifier = Modifier.weight(1f),
                    onClick = { onStudentClick(second) }
                )

                // 1st Place (Gold)
                PodiumPillar(
                    user = first,
                    rank = 1,
                    medal = "👑",
                    height = 76.dp,
                    color = Color(0xFFF59E0B),
                    isWeekly = isWeekly,
                    isDark = isDark,
                    modifier = Modifier.weight(1f),
                    onClick = { onStudentClick(first) }
                )

                // 3rd Place (Bronze)
                PodiumPillar(
                    user = third,
                    rank = 3,
                    medal = "🥉",
                    height = 48.dp,
                    color = Color(0xFFD97706),
                    isWeekly = isWeekly,
                    isDark = isDark,
                    modifier = Modifier.weight(1f),
                    onClick = { onStudentClick(third) }
                )
            }
        }
    }
}

@Composable
fun PodiumPillar(
    user: StudentLeaderboardEntry,
    rank: Int,
    medal: String,
    height: androidx.compose.ui.unit.Dp,
    color: Color,
    isWeekly: Boolean,
    isDark: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val score = if (isWeekly) user.weeklyXp else user.xp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 2.dp)
            .clickable { onClick() }
    ) {
        Text(medal, fontSize = 20.sp)
        Text(
            text = user.name.split(" ").firstOrNull() ?: user.name,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = if (isDark) Color.White else Color(0xFF1E293B)
        )
        Text(
            text = "$score XP",
            fontWeight = FontWeight.Bold,
            fontSize = 9.5.sp,
            color = color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .height(height)
                .clip(RoundedCornerShape(topStart = 14.dp, topEnd = 14.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(color.copy(alpha = 0.4f), color.copy(alpha = 0.15f))
                    )
                )
                .border(
                    BorderStroke(1.5.dp, color.copy(alpha = 0.6f)),
                    shape = RoundedCornerShape(topStart = 14.dp, topEnd = 14.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "#$rank",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = color
                )
                if (user.isMe) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = Color(0xFF6366F1)
                    ) {
                        Text(
                            text = "YOU",
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                        )
                    }
                }
            }
        }
    }
}

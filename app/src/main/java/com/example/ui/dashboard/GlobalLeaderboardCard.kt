package com.example.ui.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.example.R
import com.example.data.GlobalLeaderboardEntry
import com.example.data.GlobalLeaderboardRepository
import com.example.data.GlobalLeaderboardUiState
import com.example.data.StudentLevelSystem
import com.example.data.UserProfile
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

/**
 * Dashboard component that fetches and displays the Top 10 students ranked by
 * total accumulated XP directly from Cloud Firestore (`/global_leaderboard`).
 */
@Composable
fun GlobalLeaderboardCard(
    userProfile: UserProfile?,
    authUserUid: String?,
    isDark: Boolean,
    cardBorder: BorderStroke,
    onSignInWithGoogle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val repository = remember(context) { GlobalLeaderboardRepository(context.applicationContext) }

    var refreshNonce by remember { mutableIntStateOf(0) }
    var isSyncingSelf by remember { mutableStateOf(false) }

    // Re-key the Firestore snapshot flow whenever the signed-in user or manual refresh changes
    val leaderboardFlow = remember(authUserUid, refreshNonce) {
        repository.observeTopStudents(GlobalLeaderboardRepository.DEFAULT_TOP_LIMIT)
    }
    val uiState by leaderboardFlow.collectAsStateWithLifecycle(initialValue = GlobalLeaderboardUiState.Loading)

    // Keep the signed-in student's accumulated XP synced to the public leaderboard
    LaunchedEffect(
        authUserUid,
        userProfile?.xp,
        userProfile?.nickname,
        userProfile?.name,
        userProfile?.avatar,
        userProfile?.standard
    ) {
        if (!authUserUid.isNullOrBlank() && userProfile != null) {
            repository.publishStudentEntry(userProfile)
        }
    }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val numberFormat = remember { NumberFormat.getIntegerInstance(Locale.getDefault()) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("dashboard_global_leaderboard_card"),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header: Globe/Trophy crest + Title + Live Badge + Refresh Action
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
                            .size(40.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(Color(0xFFF59E0B), Color(0xFFD97706))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = stringResource(R.string.global_leaderboard_title),
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.global_leaderboard_title),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = titleColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isDark) Color(0xFF064E3B) else Color(0xFFDCFCE7)
                            ) {
                                Text(
                                    text = if (uiState is GlobalLeaderboardUiState.Success && (uiState as GlobalLeaderboardUiState.Success).isFromCache) {
                                        "CACHED"
                                    } else {
                                        "TOP 10"
                                    },
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isDark) Color(0xFF6EE7B7) else Color(0xFF15803D),
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = stringResource(R.string.global_leaderboard_subtitle),
                            style = MaterialTheme.typography.bodySmall,
                            color = subtitleColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                IconButton(
                    onClick = {
                        if (!authUserUid.isNullOrBlank() && userProfile != null && !isSyncingSelf) {
                            coroutineScope.launch {
                                isSyncingSelf = true
                                try {
                                    repository.publishStudentEntry(userProfile)
                                } finally {
                                    isSyncingSelf = false
                                    refreshNonce++
                                }
                            }
                        } else {
                            refreshNonce++
                        }
                    },
                    modifier = Modifier
                        .size(48.dp)
                        .testTag("global_leaderboard_refresh_button")
                ) {
                    if (isSyncingSelf) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = stringResource(R.string.global_leaderboard_refresh),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            // Content states
            when (val state = uiState) {
                is GlobalLeaderboardUiState.Loading -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                            .testTag("global_leaderboard_loading"),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(28.dp),
                            strokeWidth = 3.dp,
                            color = Color(0xFFD97706)
                        )
                        Text(
                            text = stringResource(R.string.global_leaderboard_loading),
                            style = MaterialTheme.typography.bodySmall,
                            color = subtitleColor
                        )
                    }
                }

                is GlobalLeaderboardUiState.SignedOut -> {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC),
                        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("global_leaderboard_signed_out")
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Public,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = stringResource(R.string.global_leaderboard_signin_title),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = titleColor,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(R.string.global_leaderboard_signin_desc),
                                style = MaterialTheme.typography.bodySmall,
                                color = subtitleColor,
                                textAlign = TextAlign.Center
                            )
                            Button(
                                onClick = onSignInWithGoogle,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(min = 48.dp)
                                    .testTag("global_leaderboard_signin_button"),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.Login,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = stringResource(R.string.global_leaderboard_signin_cta),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                is GlobalLeaderboardUiState.Error -> {
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.45f),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.4f)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("global_leaderboard_error")
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Warning,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = state.message,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onErrorContainer,
                                    modifier = Modifier.weight(1f, fill = false)
                                )
                            }
                            OutlinedButton(
                                onClick = { refreshNonce++ },
                                modifier = Modifier
                                    .heightIn(min = 48.dp)
                                    .testTag("global_leaderboard_retry_button"),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.global_leaderboard_retry),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                is GlobalLeaderboardUiState.Success -> {
                    if (state.entries.isEmpty()) {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = if (isDark) Color(0xFF1E293B) else Color(0xFFFFFBEB),
                            border = BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.35f)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("global_leaderboard_empty")
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text("🏆", fontSize = 30.sp)
                                Text(
                                    text = stringResource(R.string.global_leaderboard_empty_title),
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = stringResource(R.string.global_leaderboard_empty_desc),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = subtitleColor,
                                    textAlign = TextAlign.Center
                                )
                                if (userProfile != null) {
                                    Button(
                                        onClick = {
                                            coroutineScope.launch {
                                                isSyncingSelf = true
                                                try {
                                                    repository.publishStudentEntry(userProfile)
                                                } finally {
                                                    isSyncingSelf = false
                                                }
                                            }
                                        },
                                        enabled = !isSyncingSelf,
                                        modifier = Modifier
                                            .heightIn(min = 48.dp)
                                            .testTag("global_leaderboard_publish_xp_button"),
                                        shape = RoundedCornerShape(12.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706))
                                    ) {
                                        Text(
                                            text = stringResource(R.string.global_leaderboard_publish_cta),
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    } else {
                        // Top 3 Podium Showcase when at least 3 students exist
                        if (state.entries.size >= 3) {
                            GlobalPodiumShowcase(
                                topThree = state.entries.take(3),
                                currentUserUid = state.currentUserUid,
                                isDark = isDark,
                                numberFormat = numberFormat
                            )
                            HorizontalDivider(
                                color = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0),
                                thickness = 1.dp
                            )
                        }

                        // Ranked List (ranks 4..10 when podium is shown, or 1..size when < 3)
                        val startIndex = if (state.entries.size >= 3) 3 else 0
                        val remainingEntries = state.entries.drop(startIndex)
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("global_leaderboard_list"),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            remainingEntries.forEachIndexed { idx, entry ->
                                val rank = startIndex + idx + 1
                                GlobalLeaderboardRow(
                                    rank = rank,
                                    entry = entry,
                                    isCurrentUser = entry.uid == state.currentUserUid,
                                    isDark = isDark,
                                    numberFormat = numberFormat
                                )
                            }
                        }

                        // Current student's position summary chip
                        val myRankIdx = state.entries.indexOfFirst { it.uid == state.currentUserUid }
                        if (myRankIdx >= 0) {
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Your Global Standing: #${myRankIdx + 1} of Top 10",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                    Text(
                                        text = "${numberFormat.format(state.entries[myRankIdx].xp)} XP",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.Black,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        } else if (userProfile != null) {
                            val tenthXp = state.entries.lastOrNull()?.xp ?: 0
                            val gap = (tenthXp - userProfile.xp + 1).coerceAtLeast(1)
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC),
                                border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Your XP: ${numberFormat.format(userProfile.xp)} XP • Earn ${numberFormat.format(gap)} more XP to break into the Top 10!",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = subtitleColor,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun GlobalPodiumShowcase(
    topThree: List<GlobalLeaderboardEntry>,
    currentUserUid: String?,
    isDark: Boolean,
    numberFormat: NumberFormat
) {
    val first = topThree[0]
    val second = topThree[1]
    val third = topThree[2]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)
            .testTag("global_leaderboard_podium"),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        // #2 Silver (Left)
        PodiumColumn(
            rank = 2,
            entry = second,
            isCurrentUser = second.uid == currentUserUid,
            medal = "🥈",
            accentColor = Color(0xFF64748B),
            containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
            avatarSize = 42.dp,
            topSpacer = 14.dp,
            isDark = isDark,
            numberFormat = numberFormat,
            modifier = Modifier.weight(1f)
        )

        // #1 Gold (Center Elevated)
        PodiumColumn(
            rank = 1,
            entry = first,
            isCurrentUser = first.uid == currentUserUid,
            medal = "👑",
            accentColor = Color(0xFFD97706),
            containerColor = if (isDark) Color(0xFF422006).copy(alpha = 0.55f) else Color(0xFFFEF3C7),
            avatarSize = 52.dp,
            topSpacer = 0.dp,
            isDark = isDark,
            numberFormat = numberFormat,
            modifier = Modifier.weight(1.12f)
        )

        // #3 Bronze (Right)
        PodiumColumn(
            rank = 3,
            entry = third,
            isCurrentUser = third.uid == currentUserUid,
            medal = "🥉",
            accentColor = Color(0xFFB45309),
            containerColor = if (isDark) Color(0xFF291D16) else Color(0xFFFFF7ED),
            avatarSize = 40.dp,
            topSpacer = 20.dp,
            isDark = isDark,
            numberFormat = numberFormat,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun PodiumColumn(
    rank: Int,
    entry: GlobalLeaderboardEntry,
    isCurrentUser: Boolean,
    medal: String,
    accentColor: Color,
    containerColor: Color,
    avatarSize: Dp,
    topSpacer: Dp,
    isDark: Boolean,
    numberFormat: NumberFormat,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(top = topSpacer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = containerColor,
            border = BorderStroke(
                width = if (isCurrentUser || rank == 1) 1.5.dp else 1.dp,
                color = if (isCurrentUser) MaterialTheme.colorScheme.primary else accentColor.copy(alpha = 0.5f)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("global_leaderboard_podium_rank_$rank")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = medal, fontSize = if (rank == 1) 18.sp else 15.sp)

                LeaderboardAvatar(
                    avatar = entry.avatar,
                    displayName = entry.displayName,
                    size = avatarSize,
                    ringColor = accentColor
                )

                Text(
                    text = if (isCurrentUser) "${entry.displayName} (You)" else entry.displayName,
                    fontSize = if (rank == 1) 12.sp else 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = formatCompactStandard(entry.standard),
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = accentColor.copy(alpha = if (isDark) 0.25f else 0.16f)
                ) {
                    Text(
                        text = "${numberFormat.format(entry.xp)} XP",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Black,
                        color = if (isDark) Color(0xFFFDE68A) else accentColor,
                        maxLines = 1,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun GlobalLeaderboardRow(
    rank: Int,
    entry: GlobalLeaderboardEntry,
    isCurrentUser: Boolean,
    isDark: Boolean,
    numberFormat: NumberFormat
) {
    val levelInfo = remember(entry.xp) { StudentLevelSystem.calculateLevel(entry.xp) }

    val rowBg = when {
        isCurrentUser -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = if (isDark) 0.35f else 0.45f)
        isDark -> Color(0xFF1E293B).copy(alpha = 0.65f)
        else -> Color(0xFFF8FAFC)
    }
    val rowBorder = when {
        isCurrentUser -> BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary)
        else -> BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    }

    val rankColor = when (rank) {
        1 -> Color(0xFFD97706)
        2 -> Color(0xFF64748B)
        3 -> Color(0xFFB45309)
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = rowBg,
        border = rowBorder,
        modifier = Modifier
            .fillMaxWidth()
            .testTag("global_leaderboard_row_$rank")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Rank number badge
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(rankColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "#$rank",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = rankColor
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            LeaderboardAvatar(
                avatar = entry.avatar,
                displayName = entry.displayName,
                size = 36.dp,
                ringColor = if (isCurrentUser) MaterialTheme.colorScheme.primary else Color(0xFF94A3B8)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = entry.displayName,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                    if (isCurrentUser) {
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            Text(
                                text = "YOU",
                                fontSize = 8.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                            )
                        }
                    }
                }
                Text(
                    text = "${formatCompactStandard(entry.standard)} • LVL ${levelInfo.level} • 🔥 ${entry.attendanceStreak}d",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Accumulated XP Pill
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (isDark) Color(0xFF312E81).copy(alpha = 0.7f) else Color(0xFFEEF2FF)
            ) {
                Text(
                    text = "${numberFormat.format(entry.xp)} XP",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isDark) Color(0xFFC7D2FE) else Color(0xFF4338CA),
                    maxLines = 1,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun LeaderboardAvatar(
    avatar: String,
    displayName: String,
    size: Dp,
    ringColor: Color
) {
    if (avatar.startsWith("http://") || avatar.startsWith("https://")) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .border(1.5.dp, ringColor, CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            SubcomposeAsyncImage(
                model = avatar,
                contentDescription = "$displayName avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().clip(CircleShape)
            )
        }
    } else {
        val catalogAvatar = remember(avatar) { AvatarCatalog.getAvatarById(avatar) }
        StudentAvatarBadge(
            avatar = catalogAvatar,
            size = size,
            showRing = true
        )
    }
}

private fun formatCompactStandard(standard: Int): String = when (standard) {
    11 -> "Morarji"
    12 -> "NMMS"
    else -> "Std $standard"
}

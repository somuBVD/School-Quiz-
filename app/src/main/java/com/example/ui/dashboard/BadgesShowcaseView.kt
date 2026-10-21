package com.example.ui.dashboard

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.data.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgesShowcaseView(
    userProfile: UserProfile,
    progressList: List<UnitProgress>,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var selectedCategory by remember { mutableStateOf(BadgeCategory.ALL) }
    var showOnlyUnlocked by remember { mutableStateOf(false) }
    var selectedBadgeDetail by remember { mutableStateOf<Pair<BadgeDefinition, BadgeProgress>?>(null) }

    // Evaluate all badges against current student profile and progress
    val evaluatedBadges = remember(userProfile, progressList) {
        BadgeSystem.allBadges.map { badge ->
            val progress = badge.evaluate(userProfile, progressList)
            badge to progress
        }
    }

    val totalCount = evaluatedBadges.size
    val unlockedCount = evaluatedBadges.count { it.second.isUnlocked }
    val overallProgress = if (totalCount > 0) unlockedCount.toFloat() / totalCount else 0f
    val animatedProgress by animateFloatAsState(
        targetValue = overallProgress,
        animationSpec = tween(800),
        label = "overallBadgeProgress"
    )

    val filteredBadges = evaluatedBadges.filter { (badge, progress) ->
        val matchesCategory = selectedCategory == BadgeCategory.ALL || badge.category == selectedCategory
        val matchesUnlocked = !showOnlyUnlocked || progress.isUnlocked
        matchesCategory && matchesUnlocked
    }

    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("badges_showcase_view"),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- 1. HERO SUMMARY CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("badges_hero_card"),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
            ),
            border = cardBorder
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFFFB300).copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🎖️", fontSize = 22.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Achievement Hall",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = titleColor
                            )
                            Text(
                                text = "$unlockedCount of $totalCount Badges Unlocked",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFD97706)
                            )
                        }
                    }

                    // Trophy Pill
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = Color(0xFFFFB300).copy(alpha = 0.2f),
                        border = BorderStroke(1.dp, Color(0xFFFFB300).copy(alpha = 0.4f))
                    ) {
                        Text(
                            text = "${(overallProgress * 100).toInt()}% Done",
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFFFD54F) else Color(0xFFB45309)
                        )
                    }
                }

                // Progress Bar
                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Color(0xFFFFB300),
                    trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                )

                Text(
                    text = "Complete curriculum quizzes, achieve high accuracy, and maintain streaks to collect rare badges!",
                    fontSize = 11.sp,
                    color = subtitleColor
                )
            }
        }

        // --- 2. CATEGORY FILTERS & TOGGLES ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BadgeCategory.entries.forEach { category ->
                val isSelected = selectedCategory == category
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = category },
                    label = {
                        Text(
                            text = "${category.icon} ${category.title}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier.testTag("filter_badge_cat_${category.name.lowercase()}")
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Unlocked only filter
            FilterChip(
                selected = showOnlyUnlocked,
                onClick = { showOnlyUnlocked = !showOnlyUnlocked },
                label = {
                    Text(
                        text = if (showOnlyUnlocked) "✓ Unlocked Only" else "Show All",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                modifier = Modifier.testTag("filter_badge_unlocked_only")
            )
        }

        // --- 3. BADGES GRID ---
        if (filteredBadges.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🔒", fontSize = 36.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "No badges match your filter",
                        color = subtitleColor,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                filteredBadges.chunked(2).forEach { rowPair ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        rowPair.forEach { (badge, progress) ->
                            Box(modifier = Modifier.weight(1f)) {
                                BadgeItemCard(
                                    badge = badge,
                                    progress = progress,
                                    isDark = isDark,
                                    cardBorder = cardBorder,
                                    titleColor = titleColor,
                                    subtitleColor = subtitleColor,
                                    onClick = { selectedBadgeDetail = badge to progress }
                                )
                            }
                        }
                        if (rowPair.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }

    // Modal Dialog when user inspects badge details
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
}

/**
 * Individual Badge Card inside showcase grid
 */
@Composable
fun BadgeItemCard(
    badge: BadgeDefinition,
    progress: BadgeProgress,
    isDark: Boolean,
    cardBorder: BorderStroke,
    titleColor: Color,
    subtitleColor: Color,
    onClick: () -> Unit
) {
    val badgeColor = Color(badge.colorHex)
    val unlocked = progress.isUnlocked

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("badge_card_${badge.id}"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = when {
                unlocked -> badgeColor.copy(alpha = if (isDark) 0.16f else 0.08f)
                isDark -> Color(0xFF1E293B)
                else -> Color(0xFFF8FAFC)
            }
        ),
        border = if (unlocked) BorderStroke(1.5.dp, badgeColor.copy(alpha = 0.5f)) else cardBorder
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Rarity Chip & Lock Indicator Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = when (badge.rarity) {
                        "Legendary" -> Color(0xFFFFB300).copy(alpha = 0.2f)
                        "Epic" -> Color(0xFF8B5CF6).copy(alpha = 0.2f)
                        "Rare" -> Color(0xFF3B82F6).copy(alpha = 0.2f)
                        else -> Color(0xFF64748B).copy(alpha = 0.15f)
                    }
                ) {
                    Text(
                        text = badge.rarity.uppercase(),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = when (badge.rarity) {
                            "Legendary" -> Color(0xFFD97706)
                            "Epic" -> Color(0xFF7C3AED)
                            "Rare" -> Color(0xFF2563EB)
                            else -> Color(0xFF475569)
                        },
                        maxLines = 1,
                        softWrap = false
                    )
                }

                if (unlocked) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Unlocked",
                        tint = Color(0xFF10B981),
                        modifier = Modifier.size(16.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Locked",
                        tint = subtitleColor.copy(alpha = 0.6f),
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            // Central Emoji Icon
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(
                        if (unlocked) {
                            Brush.radialGradient(
                                listOf(badgeColor.copy(alpha = 0.35f), badgeColor.copy(alpha = 0.1f))
                            )
                        } else {
                            Brush.radialGradient(
                                listOf(Color(0xFF94A3B8).copy(alpha = 0.2f), Color(0xFF94A3B8).copy(alpha = 0.05f))
                            )
                        }
                    )
                    .border(
                        1.5.dp,
                        if (unlocked) badgeColor.copy(alpha = 0.6f) else Color(0xFF94A3B8).copy(alpha = 0.3f),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (unlocked) badge.emoji else "🔒",
                    fontSize = 24.sp
                )
            }

            // Title
            Text(
                text = badge.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (unlocked) titleColor else subtitleColor,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Progress text
            Text(
                text = progress.progressText,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = if (unlocked) badgeColor else subtitleColor
            )

            // Progress Indicator
            LinearProgressIndicator(
                progress = { progress.progressFraction },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = if (unlocked) badgeColor else Color(0xFF94A3B8),
                trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
            )

            // Reward
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("✨", fontSize = 11.sp)
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "+${badge.xpReward} XP",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = subtitleColor
                )
            }
        }
    }
}

/**
 * Detailed Dialog for inspecting criteria and rewards
 */
@Composable
fun BadgeDetailDialog(
    badge: BadgeDefinition,
    progress: BadgeProgress,
    isDark: Boolean,
    onDismiss: () -> Unit,
    onShare: () -> Unit
) {
    val badgeColor = Color(badge.colorHex)
    val unlocked = progress.isUnlocked

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.5.dp, if (unlocked) badgeColor.copy(alpha = 0.5f) else Color(0xFF94A3B8).copy(alpha = 0.3f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .testTag("badge_detail_dialog")
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header Badge Medal
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(
                            if (unlocked) {
                                Brush.radialGradient(
                                    listOf(badgeColor.copy(alpha = 0.4f), badgeColor.copy(alpha = 0.12f))
                                )
                            } else {
                                Brush.radialGradient(
                                    listOf(Color(0xFF94A3B8).copy(alpha = 0.25f), Color(0xFF94A3B8).copy(alpha = 0.08f))
                                )
                            }
                        )
                        .border(
                            2.dp,
                            if (unlocked) badgeColor else Color(0xFF94A3B8).copy(alpha = 0.4f),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (unlocked) badge.emoji else "🔒",
                        fontSize = 38.sp
                    )
                }

                // Title & Rarity
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = badge.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = badgeColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "${badge.rarity.uppercase()} • ${badge.category.title}",
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = badgeColor,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }

                // Description
                Text(
                    text = badge.description,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                // Requirement Box
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Requirement",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = if (unlocked) "🎉 Complete" else progress.progressText,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (unlocked) Color(0xFF10B981) else badgeColor
                            )
                        }

                        Text(
                            text = badge.criteria,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        LinearProgressIndicator(
                            progress = { progress.progressFraction },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = if (unlocked) Color(0xFF10B981) else badgeColor,
                            trackColor = if (isDark) Color(0xFF334155) else Color(0xFFCBD5E1)
                        )
                    }
                }

                // Reward & XP
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("✨ Bonus XP", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text("+${badge.xpReward} XP", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF6366F1))
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Status", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(
                            text = if (unlocked) "Unlocked" else "Locked",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (unlocked) Color(0xFF10B981) else Color(0xFF94A3B8)
                        )
                    }
                }

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text("Close", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = onShare,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (unlocked) badgeColor else MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(if (unlocked) "Brag 🎉" else "Challenge", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

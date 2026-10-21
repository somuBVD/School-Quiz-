package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.StudentLevelInfo
import com.example.data.StudentLevelSystem

/**
 * Compact Student Level Pill Badge for headers, profile summaries, and quick views.
 */
@Composable
fun StudentLevelCompactBadge(
    levelInfo: StudentLevelInfo,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val levelColor = Color(levelInfo.colorHex)

    Surface(
        modifier = modifier
            .testTag("student_level_compact_badge")
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
        shape = RoundedCornerShape(12.dp),
        color = levelColor.copy(alpha = 0.14f),
        border = BorderStroke(1.dp, levelColor.copy(alpha = 0.4f))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = levelInfo.badgeEmoji, fontSize = 13.sp)
            Text(
                text = "LVL ${levelInfo.level}",
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                color = levelColor
            )
            Text(
                text = "•",
                fontSize = 11.sp,
                color = levelColor.copy(alpha = 0.6f)
            )
            Text(
                text = "${levelInfo.totalXp} XP",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = levelColor
            )
        }
    }
}

/**
 * Prominent Student Level & XP Progression Card for the Student Dashboard.
 * Displays level, XP earned for correct answers, progress bar toward next level,
 * perks, and an interactive level ladder dialog.
 */
@Composable
fun StudentLevelProgressionCard(
    levelInfo: StudentLevelInfo,
    isDark: Boolean,
    cardBorder: BorderStroke,
    modifier: Modifier = Modifier
) {
    var showLadderDialog by remember { mutableStateOf(false) }
    val levelColor = Color(levelInfo.colorHex)

    val animatedProgress by animateFloatAsState(
        targetValue = levelInfo.progressFraction,
        animationSpec = tween(durationMillis = 800),
        label = "levelProgressAnim"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("student_level_progression_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E1B4B).copy(alpha = 0.6f) else Color(0xFFFAF5FF)
        ),
        border = BorderStroke(1.5.dp, if (isDark) levelColor.copy(alpha = 0.6f) else levelColor.copy(alpha = 0.35f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header Row: Level Icon, Title, and Level Ladder Action Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        levelColor.copy(alpha = 0.25f),
                                        levelColor.copy(alpha = 0.1f)
                                    )
                                )
                            )
                            .border(2.dp, levelColor.copy(alpha = 0.6f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = levelInfo.badgeEmoji, fontSize = 26.sp)
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f, fill = false)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Level ${levelInfo.level}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = levelColor
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = levelColor.copy(alpha = 0.15f),
                                border = BorderStroke(1.dp, levelColor.copy(alpha = 0.4f))
                            ) {
                                Text(
                                    text = levelInfo.rankBadge,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = levelColor,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Text(
                            text = levelInfo.title,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Level Ladder Button
                Button(
                    onClick = { showLadderDialog = true },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = levelColor
                    ),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                    modifier = Modifier.testTag("open_level_ladder_button")
                ) {
                    Text(
                        text = "Ladder 🪜",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            // Experience Points Meter & Progression Bar
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⚡", fontSize = 13.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${levelInfo.totalXp} XP",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = levelColor
                        )
                        Text(
                            text = " / ${levelInfo.nextLevelMinXp} XP",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    val percent = (animatedProgress * 100).toInt()
                    Text(
                        text = "$percent%",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = levelColor
                    )
                }

                // Smooth Progress Bar
                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    color = levelColor,
                    trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                )

                // Subtitle: XP to next level & XP earning rule
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (levelInfo.nextUnlockTitle != null) {
                            "${levelInfo.xpRequiredForNextLevel} XP to ${levelInfo.nextUnlockTitle}"
                        } else {
                            "Max Level Reached! 👑"
                        },
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF10B981).copy(alpha = 0.12f),
                        border = BorderStroke(0.8.dp, Color(0xFF10B981).copy(alpha = 0.3f))
                    ) {
                        Text(
                            text = "+25 XP / correct answer",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF047857),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            // Perks & Unlocked Privileges Footer Chip
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
                border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("🎁", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Level Perk Active:",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = levelInfo.perkDescription,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }

    // Level Ladder Dialog
    if (showLadderDialog) {
        StudentLevelLadderDialog(
            currentLevelInfo = levelInfo,
            isDark = isDark,
            onDismiss = { showLadderDialog = false }
        )
    }
}

/**
 * Detailed Dialog showcasing all student levels from Level 1 to 10 with XP requirements,
 * perks, and unlock status.
 */
@Composable
fun StudentLevelLadderDialog(
    currentLevelInfo: StudentLevelInfo,
    isDark: Boolean,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Dialog Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🪜", fontSize = 22.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Student Level Ladder",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            // Horizontal Current Level pill placed directly below Student Level Ladder text
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(currentLevelInfo.colorHex).copy(alpha = 0.15f),
                                border = BorderStroke(1.dp, Color(currentLevelInfo.colorHex).copy(alpha = 0.4f)),
                                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                ) {
                                    Text(currentLevelInfo.badgeEmoji, fontSize = 12.sp)
                                    Text(
                                        text = "CURRENT: Level ${currentLevelInfo.level} • ${currentLevelInfo.title}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(currentLevelInfo.colorHex),
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }

                            Text(
                                text = "Earn +25 XP for every correct answer",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                HorizontalDivider()

                // Levels List
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 420.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(StudentLevelSystem.LEVEL_DEFINITIONS) { def ->
                        val isCurrent = def.level == currentLevelInfo.level
                        val isUnlocked = currentLevelInfo.totalXp >= def.minXp
                        val tierColor = Color(def.colorHex)

                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = if (isCurrent) tierColor.copy(alpha = 0.15f)
                            else if (isUnlocked) (if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC))
                            else (if (isDark) Color(0xFF0F172A) else Color(0xFFF1F5F9)),
                            border = BorderStroke(
                                if (isCurrent) 2.dp else 1.dp,
                                if (isCurrent) tierColor
                                else if (isUnlocked) tierColor.copy(alpha = 0.4f)
                                else Color.Gray.copy(alpha = 0.2f)
                            ),
                            modifier = Modifier.fillMaxWidth()
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
                                            .size(40.dp)
                                            .clip(CircleShape)
                                            .background(tierColor.copy(alpha = 0.15f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = def.emoji, fontSize = 20.sp)
                                    }

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(end = 8.dp)
                                    ) {
                                        Text(
                                            text = "Level ${def.level}: ${def.title}",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (isUnlocked) tierColor else Color.Gray,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )

                                        if (isCurrent) {
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Surface(
                                                shape = RoundedCornerShape(4.dp),
                                                color = tierColor
                                            ) {
                                                Text(
                                                    text = "CURRENT LEVEL",
                                                    fontSize = 9.sp,
                                                    fontWeight = FontWeight.Black,
                                                    color = Color.White,
                                                    maxLines = 1,
                                                    softWrap = false,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(2.dp))

                                        Text(
                                            text = "${def.minXp} XP • ${def.perk}",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }

                                if (isUnlocked) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Unlocked",
                                        tint = Color(0xFF10B981),
                                        modifier = Modifier.size(20.dp)
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = "Locked",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                // Done Button
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Got It! 👍", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

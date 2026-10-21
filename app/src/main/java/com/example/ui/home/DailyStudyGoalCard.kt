package com.example.ui.home

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizViewModel
import com.example.audio.SoundEffectsManager

@Composable
fun DailyStudyGoalCard(
    viewModel: QuizViewModel,
    isDark: Boolean,
    cardBorder: BorderStroke,
    modifier: Modifier = Modifier
) {
    val dailyTarget by viewModel.dailyGoalTarget.collectAsState()
    val dailyCompleted by viewModel.dailyGoalCompleted.collectAsState()
    val isClaimed by viewModel.isDailyGoalClaimed.collectAsState()
    val context = LocalContext.current

    var showEditTargetDialog by remember { mutableStateOf(false) }

    val rawProgress = if (dailyTarget > 0) (dailyCompleted.toFloat() / dailyTarget).coerceIn(0f, 1f) else 0f
    val animatedProgress by animateFloatAsState(
        targetValue = rawProgress,
        animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing),
        label = "daily_goal_progress"
    )
    val isGoalMet = dailyCompleted >= dailyTarget

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("daily_study_goal_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF6366F1).copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🎯", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f, fill = false)) {
                        Text(
                            text = "Daily Study Target",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "$dailyCompleted of $dailyTarget quizzes finished today",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                IconButton(
                    onClick = { showEditTargetDialog = true },
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("edit_daily_goal_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Goal",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Progress Bar & Percentage
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = if (isGoalMet) "Goal Completed! 🎉" else "${(rawProgress * 100).toInt()}% progress",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isGoalMet) Color(0xFF16A34A) else MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "$dailyCompleted / $dailyTarget",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = if (isGoalMet) Color(0xFF16A34A) else Color(0xFF4F46E5),
                    trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                )
            }

            // Claim Reward or Status Button with smooth appearance
            AnimatedVisibility(
                visible = isGoalMet && !isClaimed,
                enter = expandVertically(animationSpec = spring(stiffness = Spring.StiffnessMediumLow)) + fadeIn(),
                exit = shrinkVertically(animationSpec = tween(200)) + fadeOut()
            ) {
                Button(
                    onClick = {
                        viewModel.claimDailyGoalReward()
                        SoundEffectsManager.playStreakBonus(context)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("claim_daily_goal_reward_button"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A))
                ) {
                    Text(
                        text = "🎁 Claim Goal Reward (+100 XP)",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 12.5.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            if (isClaimed) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = (if (isDark) Color(0xFF14532D) else Color(0xFFDCFCE7)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("✅", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Daily Goal Claimed! Great job sticking to your study schedule.",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isDark) Color(0xFFBBF7D0) else Color(0xFF15803D)
                        )
                    }
                }
            }
        }
    }

    if (showEditTargetDialog) {
        AlertDialog(
            onDismissRequest = { showEditTargetDialog = false },
            title = {
                Text("Set Daily Quiz Target", fontWeight = FontWeight.Bold)
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Select how many quizzes you plan to complete each day:")
                    listOf(2, 3, 5, 8).forEach { targetValue ->
                        OutlinedButton(
                            onClick = {
                                viewModel.setDailyGoalTarget(targetValue)
                                showEditTargetDialog = false
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("$targetValue Quizzes per day ${if (targetValue == dailyTarget) "(Current)" else ""}")
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showEditTargetDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

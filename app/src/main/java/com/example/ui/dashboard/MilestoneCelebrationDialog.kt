package com.example.ui.dashboard

import android.content.Intent
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.audio.SoundEffectsManager
import com.example.data.UserProfile
import com.example.ui.quiz.CelebrationParticleOverlay

enum class MilestoneType(
    val title: String,
    val subtitle: String,
    val emoji: String,
    val bonusPoints: Int,
    val bonusStars: Int,
    val accentColor: Color
) {
    SEVEN_DAY_STREAK(
        title = "7-Day Streak Master!",
        subtitle = "Incredible consistency! You have studied and answered quizzes for 7 straight days.",
        emoji = "🔥",
        bonusPoints = 100,
        bonusStars = 25,
        accentColor = Color(0xFFEA580C)
    ),
    TOP_TEN_PERCENT(
        title = "Top 10% Leaderboard Scholar!",
        subtitle = "Outstanding performance! Your score places you among the top 10% of all students.",
        emoji = "👑",
        bonusPoints = 150,
        bonusStars = 50,
        accentColor = Color(0xFFF59E0B)
    ),
    DIAMOND_TIER(
        title = "Diamond Tier Unlocked!",
        subtitle = "Academic excellence! You have ascended to the Diamond rank with your high quiz mastery.",
        emoji = "💎",
        bonusPoints = 200,
        bonusStars = 75,
        accentColor = Color(0xFF6366F1)
    )
}

@Composable
fun MilestoneCelebrationDialog(
    milestone: MilestoneType,
    profile: UserProfile,
    onDismiss: () -> Unit,
    onClaimReward: (points: Int, stars: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isClaimed by remember { mutableStateOf(false) }

    // Sound effect on appearance
    LaunchedEffect(milestone) {
        SoundEffectsManager.playStreakBonus(context)
    }

    // Gentle pulse animation for the trophy
    val infiniteTransition = rememberInfiniteTransition(label = "milestone_pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "trophy_scale"
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.75f))
                .testTag("milestone_celebration_overlay"),
            contentAlignment = Alignment.Center
        ) {
            // Particle celebration canvas in the background
            CelebrationParticleOverlay(
                triggerKey = milestone.ordinal,
                isHighScore = true,
                isPerfectScore = true,
                modifier = Modifier.fillMaxSize()
            )

            // Central Card
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(2.dp, milestone.accentColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Close button top right
                    Box(modifier = Modifier.fillMaxWidth()) {
                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(32.dp)
                                .testTag("close_milestone_button")
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }

                    // Trophy / Badge Icon with scale pulse
                    Box(
                        modifier = Modifier
                            .scale(scale)
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(milestone.accentColor.copy(alpha = 0.15f))
                            .border(3.dp, milestone.accentColor, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(milestone.emoji, fontSize = 48.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = milestone.accentColor
                    ) {
                        Text(
                            text = "MILESTONE REACHED",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = milestone.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = milestone.subtitle,
                        fontSize = 13.sp,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // Reward Highlight Card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = milestone.accentColor.copy(alpha = 0.1f)
                        ),
                        border = BorderStroke(1.dp, milestone.accentColor.copy(alpha = 0.4f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("⭐", fontSize = 16.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "+${milestone.bonusPoints} Points",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 14.sp,
                                    color = milestone.accentColor
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🌟", fontSize = 16.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "+${milestone.bonusStars} Stars",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 14.sp,
                                    color = milestone.accentColor
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Action buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Share to Social Button
                        OutlinedButton(
                            onClick = {
                                val shareText = "🏆 I just achieved the ${milestone.title} on School Quiz App! " +
                                        "Earned +${milestone.bonusPoints} bonus points! Challenge me in the 1vs1 Arena! 🚀"
                                val sendIntent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(Intent.EXTRA_TEXT, shareText)
                                    type = "text/plain"
                                }
                                val chooser = Intent.createChooser(sendIntent, "Share Milestone Achievement")
                                context.startActivity(chooser)
                            },
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier.weight(1f).testTag("share_milestone_button"),
                            contentPadding = PaddingValues(vertical = 12.dp)
                        ) {
                            Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Share", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }

                        // Claim Reward Button
                        Button(
                            onClick = {
                                if (!isClaimed) {
                                    isClaimed = true
                                    onClaimReward(milestone.bonusPoints, milestone.bonusStars)
                                    SoundEffectsManager.playStreakBonus(context)
                                }
                                onDismiss()
                            },
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = milestone.accentColor),
                            modifier = Modifier.weight(1.3f).testTag("claim_milestone_reward_button"),
                            contentPadding = PaddingValues(vertical = 12.dp)
                        ) {
                            Text("Claim Reward 🎁", fontWeight = FontWeight.ExtraBold, fontSize = 13.sp, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

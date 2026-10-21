package com.example.ui.blitz

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizViewModel
import com.example.audio.SoundEffectsManager
import com.example.ui.quiz.CelebrationParticleOverlay

@Composable
fun QuizBlitzScreen(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier
) {
    val blitzState by viewModel.blitzState.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val context = LocalContext.current

    if (!blitzState.isActive) return

    val currentQuestion = blitzState.questions.getOrNull(blitzState.currentIndex)

    LaunchedEffect(blitzState.isFinished) {
        if (blitzState.isFinished) {
            SoundEffectsManager.playQuizCompletion(context, isHighScore = blitzState.isNewHighScore || blitzState.score > 300)
        }
    }

    LaunchedEffect(blitzState.secondsRemaining) {
        if (blitzState.isActive && !blitzState.isFinished && blitzState.secondsRemaining in 1..5) {
            SoundEffectsManager.playTimerTick(context)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            colors = if (isDark) listOf(Color(0xFF831843), Color(0xFF4C0519))
                            else listOf(Color(0xFFF43F5E), Color(0xFFE11D48))
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { viewModel.exitQuizBlitz() },
                        modifier = Modifier.testTag("exit_blitz_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Exit Blitz",
                            tint = Color.White
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "⚡ 60s QUIZ BLITZ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                        val multiplier = when {
                            blitzState.currentStreakCombo >= 7 -> 4
                            blitzState.currentStreakCombo >= 5 -> 3
                            blitzState.currentStreakCombo >= 3 -> 2
                            else -> 1
                        }
                        if (multiplier > 1) {
                            Text(
                                text = "🔥 $multiplier" + "X COMBO MULTIPLIER!",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFFDE047)
                            )
                        } else {
                            Text(
                                text = "Score: ${blitzState.score} pts",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White.copy(alpha = 0.9f)
                            )
                        }
                    }

                    // Remaining Seconds Pill
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = if (blitzState.secondsRemaining <= 10) Color(0xFF991B1B) else Color.White.copy(alpha = 0.25f),
                        border = BorderStroke(1.5.dp, if (blitzState.secondsRemaining <= 10) Color(0xFFFCA5A5) else Color.White.copy(alpha = 0.5f))
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = if (blitzState.secondsRemaining <= 10) "⚠️" else "⏱️",
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${blitzState.secondsRemaining}s",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (blitzState.isFinished) {
                // Game Over Console
                CelebrationParticleOverlay(
                    triggerKey = blitzState.score,
                    isHighScore = blitzState.isNewHighScore,
                    modifier = Modifier.fillMaxSize()
                )
                QuizBlitzResultsView(
                    blitzState = blitzState,
                    isDark = isDark,
                    onPlayAgain = { viewModel.startQuizBlitz(blitzState.stdId) },
                    onExit = { viewModel.exitQuizBlitz() }
                )
            } else if (currentQuestion != null) {
                // Active Blitz Question Screen
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        // Dynamic Timer Progress Bar
                        val progress = (blitzState.secondsRemaining / 60f).coerceIn(0f, 1f)
                        LinearProgressIndicator(
                            progress = { progress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = if (blitzState.secondsRemaining <= 10) Color(0xFFEF4444) else Color(0xFFE11D48),
                            trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                        )

                        // Combo & Score Bar
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFFF59E0B).copy(alpha = 0.15f)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text("🔥", fontSize = 12.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Streak: ${blitzState.currentStreakCombo}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFFD97706)
                                    )
                                }
                            }

                            Text(
                                text = "Question ${blitzState.currentIndex + 1}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Question Card
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("blitz_question_card"),
                            shape = RoundedCornerShape(24.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface
                            ),
                            border = BorderStroke(1.5.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
                        ) {
                            Column(
                                modifier = Modifier.padding(20.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Color(0xFF4F46E5).copy(alpha = 0.12f)
                                ) {
                                    Text(
                                        text = currentQuestion.subjectId.uppercase(),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFF4F46E5),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                Text(
                                    text = currentQuestion.questionText,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        // Options Grid (Rapid-fire instant tap)
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            currentQuestion.options.forEachIndexed { index, option ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            val isCorrect = option.trim().equals(currentQuestion.correctAnswer.trim(), ignoreCase = true)
                                            if (isCorrect) {
                                                val nextStreak = blitzState.currentStreakCombo + 1
                                                if (nextStreak >= 3) {
                                                    SoundEffectsManager.playComboStreak(context, nextStreak)
                                                } else {
                                                    SoundEffectsManager.playCorrect(context)
                                                }
                                            } else {
                                                SoundEffectsManager.playIncorrect(context)
                                            }
                                            viewModel.submitBlitzAnswer(option)
                                        }
                                        .testTag("blitz_option_$index"),
                                    shape = RoundedCornerShape(16.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
                                    ),
                                    border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFCBD5E1))
                                ) {
                                    Row(
                                        modifier = Modifier.padding(14.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xFFE11D48).copy(alpha = 0.15f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = ('A' + index).toString(),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Color(0xFFE11D48)
                                            )
                                        }

                                        Spacer(modifier = Modifier.width(12.dp))

                                        Text(
                                            text = option,
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.SemiBold,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Bottom info: +3s time bonus hint
                    Text(
                        text = "⚡ Each correct answer awards points and adds +3s to the clock!",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun QuizBlitzResultsView(
    blitzState: QuizViewModel.BlitzState,
    isDark: Boolean,
    onPlayAgain: () -> Unit,
    onExit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(76.dp)
                .clip(CircleShape)
                .background(Color(0xFFE11D48).copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Text("⚡", fontSize = 42.sp)
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "BLITZ FINISHED!",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.onSurface
        )

        if (blitzState.isNewHighScore) {
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF59E0B)
            ) {
                Text(
                    text = "🏆 NEW PERSONAL BEST SCORE!",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Scorecard Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.5.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Total Blitz Score:", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("${blitzState.score} pts", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black, color = Color(0xFFE11D48))
                }

                HorizontalDivider()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Correct Answers:", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("✅ ${blitzState.correctCount} questions", fontWeight = FontWeight.Bold, color = Color(0xFF16A34A))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Highest Combo Streak:", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("🔥 ${blitzState.highestStreakCombo} in a row", fontWeight = FontWeight.Bold, color = Color(0xFFEA580C))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Rewards Earned:", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("+${blitzState.earnedXP} XP • +${blitzState.earnedCoins} Coins", fontWeight = FontWeight.ExtraBold, color = Color(0xFF6366F1))
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onExit,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .testTag("blitz_exit_button"),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Exit", fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = onPlayAgain,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .testTag("blitz_play_again_button"),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48))
            ) {
                Text("Play Again ⚡", fontWeight = FontWeight.ExtraBold, color = Color.White)
            }
        }
    }
}

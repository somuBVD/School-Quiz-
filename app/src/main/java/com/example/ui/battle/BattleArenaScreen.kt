package com.example.ui.battle

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizViewModel
import com.example.audio.SoundEffectsManager
import com.example.data.SubjectType
import com.example.localization.LocalAppStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BattleArenaScreen(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier
) {
    val battleState by viewModel.battleArenaState.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val strings = LocalAppStrings.current
    val context = LocalContext.current

    LaunchedEffect(battleState.stage, battleState.currentRoundIndex) {
        if (battleState.stage == BattleStage.ROUND_REVEAL) {
            val lastResult = battleState.roundResults.lastOrNull()
            if (lastResult?.userCorrect == true) {
                SoundEffectsManager.playCorrect(context)
            } else if (lastResult != null) {
                SoundEffectsManager.playIncorrect(context)
            }
        } else if (battleState.stage == BattleStage.GAME_OVER) {
            val won = battleState.userScore > battleState.opponentScore
            SoundEffectsManager.playQuizCompletion(context, isPerfect = won, isHighScore = won)
        }
    }

    val surfaceColor = MaterialTheme.colorScheme.surface
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⚔️", fontSize = 22.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = strings.battleArena,
                            fontWeight = FontWeight.ExtraBold,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.exitBattleArena() },
                        modifier = Modifier.testTag("exit_battle_arena_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    // Trophies count badge
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFFF59E0B).copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, Color(0xFFF59E0B)),
                        modifier = Modifier.padding(end = 12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text("🏆", fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${battleState.userScore * 10 + 120} Trophies",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFD97706)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = surfaceColor)
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AnimatedContent(
                targetState = battleState.stage,
                transitionSpec = {
                    (fadeIn(animationSpec = tween(280)) + scaleIn(initialScale = 0.94f)) togetherWith
                    (fadeOut(animationSpec = tween(200)) + scaleOut(targetScale = 0.94f))
                },
                label = "battle_stage_transition",
                modifier = Modifier.fillMaxSize()
            ) { stage ->
                when (stage) {
                    BattleStage.LOBBY -> {
                        BattleLobbyView(
                            battleState = battleState,
                            onSelectSubject = { viewModel.selectBattleSubject(it) },
                            onStartMatchmaking = { viewModel.findBattleMatch() },
                            onHostRoom = { viewModel.createPrivateBattleRoom() },
                            onJoinRoom = { code -> viewModel.findBattleMatch(code) },
                            isDark = isDark
                        )
                    }
                    BattleStage.MATCHMAKING -> {
                        BattleMatchmakingView(
                            battleState = battleState,
                            onCancel = { viewModel.exitBattleArena() },
                            onChallengeAi = { viewModel.startAiBattleChallenger() },
                            isDark = isDark
                        )
                    }
                    BattleStage.IN_PROGRESS, BattleStage.ROUND_REVEAL -> {
                        BattleMatchView(
                            battleState = battleState,
                            userName = userProfile?.name ?: "Student",
                            onSubmitAnswer = { viewModel.submitBattleAnswer(it) },
                            isDark = isDark
                        )
                    }
                    BattleStage.GAME_OVER -> {
                        BattleGameOverView(
                            battleState = battleState,
                            userName = userProfile?.name ?: "Student",
                            onPlayAgain = { viewModel.findBattleMatch() },
                            onExit = { viewModel.exitBattleArena() },
                            isDark = isDark
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BattleLobbyView(
    battleState: BattleArenaState,
    onSelectSubject: (String) -> Unit,
    onStartMatchmaking: () -> Unit,
    onHostRoom: () -> Unit,
    onJoinRoom: (String) -> Unit,
    isDark: Boolean
) {
    var roomInput by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Hero Banner
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E1B4B) else Color(0xFF4338CA)
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Real-Time Online Duel",
                        color = Color(0xFFA5B4FC),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Real Students 1 vs 1 Battle Online!",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "5 Rapid Questions • 15s Per Round • Live Firebase Cloud Synchronized",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 11.sp
                    )
                }
                Text("⚔️", fontSize = 48.sp)
            }
        }

        // Subject arena selection
        Text(
            text = "Choose Battle Field Subject",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold
        )

        val subjects = listOf(
            Triple("fln", "FLN (Basics)", "💡"),
            Triple("mixed", "All Subjects (Mixed)", "⚡"),
            Triple("math", "Mathematics", "📐"),
            Triple("science", "Science", "🔬"),
            Triple("kannada", "Kannada", "✍️"),
            Triple("english", "English", "🔤"),
            Triple("social", "Social Science", "🌍"),
            Triple("hindi", "Hindi", "🇮🇳"),
            Triple("general_science", "Environmental Studies", "🌿"),
            Triple("mental_ability", "Mental Ability (ಬೌದ್ಧಿಕ ಸಾಮರ್ಥ್ಯ)", "🧩")
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            subjects.chunked(2).forEach { rowSubjects ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    rowSubjects.forEach { (id, name, emoji) ->
                        val isSelected = battleState.selectedSubject == id
                        Surface(
                            onClick = { onSelectSubject(id) },
                            shape = RoundedCornerShape(16.dp),
                            color = if (isSelected) Color(0xFF4F46E5) else if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                            border = BorderStroke(
                                1.dp,
                                if (isSelected) Color(0xFF4F46E5) else if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("battle_subject_$id")
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(emoji, fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = name,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                    if (rowSubjects.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }

        // Friend Duel / Custom Room Code
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
            ),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "🏫 Duel a Classmate Online",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    OutlinedButton(
                        onClick = onHostRoom,
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                        modifier = Modifier.testTag("create_room_code_button")
                    ) {
                        Text("Create Code", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = roomInput,
                        onValueChange = { if (it.length <= 6) roomInput = it.uppercase() },
                        placeholder = { Text("Enter 6-digit Code", fontSize = 13.sp) },
                        modifier = Modifier
                            .weight(1f)
                            .testTag("room_code_input"),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )
                    Button(
                        onClick = { if (roomInput.isNotBlank()) onJoinRoom(roomInput) },
                        shape = RoundedCornerShape(12.dp),
                        enabled = roomInput.isNotBlank(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                        modifier = Modifier.testTag("join_room_button")
                    ) {
                        Text("Join Duel", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Quick Match Call to Action placed at bottom below
        Button(
            onClick = onStartMatchmaking,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .testTag("start_quick_match_button"),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5))
        ) {
            Icon(Icons.Default.FlashOn, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("QUICK MATCH (FIND ONLINE STUDENT)", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
        }
    }
}

@Composable
fun BattleMatchmakingView(
    battleState: BattleArenaState,
    onCancel: () -> Unit,
    onChallengeAi: () -> Unit,
    isDark: Boolean
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(110.dp)
                .scale(pulseScale)
                .clip(CircleShape)
                .background(Color(0xFF4F46E5).copy(alpha = 0.15f))
                .border(2.dp, Color(0xFF4F46E5), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("⚔️", fontSize = 50.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (battleState.isHost && battleState.roomCode.isNotBlank()) "Waiting for Classmate to Connect..." else "Searching for Online Opponent...",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = battleState.statusMessage.ifBlank { "Connecting with students across Karnataka schools..." },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        if (battleState.roomCode.isNotBlank() && battleState.isHost) {
            Spacer(modifier = Modifier.height(18.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4F46E5).copy(alpha = 0.12f)),
                border = BorderStroke(2.dp, Color(0xFF4F46E5)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("ONLINE DUEL ROOM CODE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4F46E5))
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = battleState.roomCode,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 4.sp,
                        color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF4338CA)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Share this 6-digit code with your classmate to join your live battle!",
                        fontSize = 11.5.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        CircularProgressIndicator(
            color = Color(0xFF4F46E5),
            modifier = Modifier.size(32.dp),
            strokeWidth = 3.dp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Elapsed: ${battleState.matchmakingSeconds}s",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // AI Challenger instant play button
        Button(
            onClick = onChallengeAi,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("play_ai_fallback_button")
        ) {
            Text("⚡ Play with AI Challenger Now", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = onCancel,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("cancel_battle_search_button")
        ) {
            Text("Cancel Duel")
        }
    }
}

@Composable
fun BattleMatchView(
    battleState: BattleArenaState,
    userName: String,
    onSubmitAnswer: (String) -> Unit,
    isDark: Boolean
) {
    val currentQuestion = battleState.currentQuestion ?: return
    val opponent = battleState.opponent

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // 1. TOP SCOREBOARD & LIVE HEALTH COMPARISON
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
            ),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Player side
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF4F46E5)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("👤", fontSize = 16.sp)
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Column(modifier = Modifier.weight(1f, fill = false)) {
                            Text(
                                text = userName,
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "${battleState.userScore} pts",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF4F46E5)
                            )
                        }
                    }

                    // Round & Timer
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = "R${battleState.currentRoundIndex + 1}/${battleState.totalRounds}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Surface(
                            shape = CircleShape,
                            color = if (battleState.roundSecondsRemaining <= 5) Color(0xFFEF4444) else Color(0xFFF59E0B)
                        ) {
                            Text(
                                text = "${battleState.roundSecondsRemaining}s",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                            )
                        }
                    }

                    // Opponent side
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Text(
                                text = opponent?.name ?: "Rival",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "${battleState.opponentScore} pts",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFDC2626)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFDC2626)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(opponent?.avatar ?: "🎯", fontSize = 16.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Comparative Tug-of-War Bar
                val totalPoints = (battleState.userScore + battleState.opponentScore).coerceAtLeast(1)
                val userRatio = (battleState.userScore.toFloat() / totalPoints).coerceIn(0.1f, 0.9f)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFFDC2626))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(if (battleState.userScore == 0 && battleState.opponentScore == 0) 0.5f else userRatio)
                            .background(Color(0xFF4F46E5))
                    )
                }

                // Opponent Status Indicator & Online Badge
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (battleState.isOnlineMatch) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF10B981))
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "ONLINE 1v1 • ${opponent?.school ?: "Karnataka"}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF059669)
                            )
                        }
                    } else {
                        Text(
                            text = "🤖 AI CHALLENGER",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    if (battleState.opponentSelectedAnswer.isNotEmpty() || battleState.opponentAnswerLocked) {
                        Text(
                            text = "⚡ Opponent locked in!",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF10B981)
                        )
                    } else {
                        Text(
                            text = "💭 Opponent is thinking...",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // 2. QUESTION PROMPT CARD
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 12.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF4F46E5).copy(alpha = 0.12f),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    Text(
                        text = currentQuestion.subjectId.uppercase(),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF4F46E5),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Text(
                    text = currentQuestion.questionText,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // 3. ANSWER CHOICES
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            currentQuestion.options.forEach { option ->
                val isSelected = battleState.userSelectedAnswer == option
                val isCorrect = option == currentQuestion.correctAnswer
                val isReveal = battleState.stage == BattleStage.ROUND_REVEAL

                val buttonBg = when {
                    isReveal && isCorrect -> Color(0xFF10B981)
                    isReveal && isSelected && !isCorrect -> Color(0xFFEF4444)
                    isSelected -> Color(0xFF4F46E5)
                    else -> if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9)
                }

                val textColor = if (isSelected || (isReveal && isCorrect)) Color.White else MaterialTheme.colorScheme.onSurface

                Surface(
                    onClick = {
                        if (battleState.userSelectedAnswer.isEmpty()) {
                            onSubmitAnswer(option)
                        }
                    },
                    shape = RoundedCornerShape(14.dp),
                    color = buttonBg,
                    border = BorderStroke(
                        1.dp,
                        if (isSelected) Color(0xFF4F46E5) else if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("battle_option_$option")
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = option,
                            fontSize = 14.sp,
                            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                            color = textColor,
                            modifier = Modifier.weight(1f)
                        )
                        if (isReveal && isCorrect) {
                            Text("✓", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BattleGameOverView(
    battleState: BattleArenaState,
    userName: String,
    onPlayAgain: () -> Unit,
    onExit: () -> Unit,
    isDark: Boolean
) {
    val isWin = battleState.userScore > battleState.opponentScore
    val isDraw = battleState.userScore == battleState.opponentScore

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = when {
                isWin -> "🏆 VICTORY!"
                isDraw -> "🤝 DRAW!"
                else -> "💔 DEFEAT"
            },
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = when {
                isWin -> Color(0xFFF59E0B)
                isDraw -> Color(0xFF6B7280)
                else -> Color(0xFFEF4444)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = when {
                isWin -> "Outstanding duel! You outsmarted your rival!"
                isDraw -> "Incredible match! Both students matched in skills!"
                else -> "Tough duel! Review concepts and challenge again!"
            },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Head to head final scorecard
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
            ),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(userName, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "${battleState.userScore}",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF4F46E5)
                    )
                    Text("Points", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }

                Text("VS", fontWeight = FontWeight.Black, fontSize = 18.sp, color = Color(0xFF94A3B8))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(battleState.opponent?.name ?: "Rival", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "${battleState.opponentScore}",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFDC2626)
                    )
                    Text("Points", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Rewards Card
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF10B981).copy(alpha = 0.12f),
            border = BorderStroke(1.dp, Color(0xFF10B981)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🪙 +${if (isWin) 50 else 15} Coins", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("⚡ +${if (isWin) 120 else 40} XP", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🏆 +${if (isWin) 25 else 5} Trophies", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onPlayAgain,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("battle_rematch_button"),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5))
        ) {
            Icon(Icons.Default.Refresh, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("PLAY AGAIN (NEW DUEL)", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onExit,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("battle_exit_button"),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("Back to Home")
        }
    }
}

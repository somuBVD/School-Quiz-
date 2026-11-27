package com.example.ui.battle

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizViewModel
import com.example.R
import com.example.audio.SoundEffectsManager
import com.example.localization.LocalAppStrings
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BattleArenaScreen(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier
) {
    val battleState by viewModel.battleArenaState.collectAsState()
    val selectedStd by viewModel.selectedStd.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val isFirebaseGoogleSignedIn by viewModel.isFirebaseGoogleSignedIn.collectAsState()
    val authUiState by viewModel.authUiState.collectAsState()
    val strings = LocalAppStrings.current
    val context = LocalContext.current

    // Zero-delay audio feedback for instant local quick-fire answers
    LaunchedEffect(battleState.lastFeedback?.timestampMs) {
        val fb = battleState.lastFeedback ?: return@LaunchedEffect
        if (!fb.skipped) {
            if (fb.userCorrect) {
                SoundEffectsManager.playCorrect(context)
            } else {
                SoundEffectsManager.playIncorrect(context)
            }
        }
    }

    // Audio feedback for online round reveal & final match completion
    LaunchedEffect(battleState.stage, battleState.currentRoundIndex) {
        if (battleState.isOnlineMatch && battleState.stage == BattleStage.ROUND_REVEAL) {
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⚔️", fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = strings.battleArena,
                            fontWeight = FontWeight.ExtraBold,
                            style = MaterialTheme.typography.titleLarge,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
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
                                text = "${battleState.userScore * 10 + 120}",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.ExtraBold,
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
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            val screenStage = if (battleState.stage == BattleStage.ROUND_REVEAL) BattleStage.IN_PROGRESS else battleState.stage
            AnimatedContent(
                targetState = screenStage,
                transitionSpec = {
                    fadeIn(animationSpec = tween(110)) togetherWith fadeOut(animationSpec = tween(80))
                },
                label = "battle_stage_transition",
                modifier = Modifier.fillMaxSize()
            ) { stage ->
                when (stage) {
                    BattleStage.LOBBY -> {
                        val signedInUser = (authUiState as? com.example.auth.AuthUiState.Authenticated)?.user
                        val authError = (authUiState as? com.example.auth.AuthUiState.Error)?.message
                        BattleLobbyView(
                            battleState = battleState,
                            selectedStd = selectedStd,
                            isFirebaseGoogleSignedIn = isFirebaseGoogleSignedIn,
                            signedInDisplayName = signedInUser?.displayName ?: userProfile?.name ?: "Student",
                            authErrorMessage = authError,
                            onSignInWithGoogle = { viewModel.signInWithGoogle(context) },
                            onSelectSubject = { viewModel.selectBattleSubject(it) },
                            onSelectStreamMode = { viewModel.selectBattleStreamMode(it) },
                            onStartMatchmaking = { viewModel.findBattleMatch() },
                            onHostRoom = { viewModel.createPrivateBattleRoom() },
                            onJoinRoom = { code -> viewModel.findBattleMatch(code) },
                            onPracticeWithAi = { viewModel.startAiBattleChallenger() },
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
                            onSkipQuestion = { viewModel.skipBattleQuestion() },
                            onFinishEarly = { viewModel.finishBattleEarly() },
                            isDark = isDark
                        )
                    }
                    BattleStage.GAME_OVER -> {
                        BattleGameOverView(
                            battleState = battleState,
                            userName = userProfile?.name ?: "Student",
                            onPlayAgain = {
                                if (battleState.isOnlineMatch) {
                                    viewModel.findBattleMatch()
                                } else {
                                    viewModel.startAiBattleChallenger()
                                }
                            },
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
    selectedStd: Int,
    isFirebaseGoogleSignedIn: Boolean,
    signedInDisplayName: String,
    authErrorMessage: String?,
    onSignInWithGoogle: () -> Unit,
    onSelectSubject: (String) -> Unit,
    onSelectStreamMode: (BattleStreamMode) -> Unit,
    onStartMatchmaking: () -> Unit,
    onHostRoom: () -> Unit,
    onJoinRoom: (String) -> Unit,
    onPracticeWithAi: () -> Unit,
    isDark: Boolean
) {
    var roomInput by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    val heroGradient = if (isDark) {
        Brush.linearGradient(listOf(Color(0xFF0F172A), Color(0xFF312E81), Color(0xFF0F766E)))
    } else {
        Brush.linearGradient(listOf(Color(0xFF1E1B4B), Color(0xFF4338CA), Color(0xFF0D9488)))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 720.dp)
            .verticalScroll(scrollState)
            .padding(16.dp)
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. High-Speed Arena Hero Banner
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(heroGradient)
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFFF59E0B)
                        ) {
                            Text(
                                text = stringResource(R.string.battle_quickfire_badge),
                                color = Color(0xFF1E1B4B),
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        if (battleState.availableMcqPreviewCount > 0) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color.White.copy(alpha = 0.18f)
                            ) {
                                Text(
                                    text = "${battleState.availableMcqPreviewCount} MCQs Ready",
                                    color = Color(0xFFA7F3D0),
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = stringResource(R.string.battle_quickfire_title),
                        color = Color.White,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.battle_quickfire_subtitle),
                        color = Color.White.copy(alpha = 0.88f),
                        fontSize = 11.5.sp,
                        lineHeight = 16.sp
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text("⚡", fontSize = 42.sp)
            }
        }

        // 2. Speed Stream Mode Selector (Infinite / Max Unique Pool / 60s Blitz)
        Text(
            text = stringResource(R.string.battle_mode_section_title),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.ExtraBold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BattleStreamMode.entries.forEach { mode ->
                val selected = battleState.streamMode == mode
                val modeIcon = when (mode) {
                    BattleStreamMode.INFINITE -> Icons.Rounded.AllInclusive
                    BattleStreamMode.MAX_MARATHON -> Icons.Rounded.Layers
                    BattleStreamMode.BLITZ_60S -> Icons.Rounded.Timer
                }
                Surface(
                    onClick = { onSelectStreamMode(mode) },
                    shape = RoundedCornerShape(16.dp),
                    color = if (selected) Color(0xFF4F46E5) else if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                    border = BorderStroke(
                        if (selected) 1.5.dp else 1.dp,
                        if (selected) Color(0xFF818CF8) else if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 74.dp)
                        .testTag("battle_mode_${mode.name.lowercase()}")
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = modeIcon,
                            contentDescription = mode.displayTitle,
                            tint = if (selected) Color(0xFFFDE68A) else MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = mode.badgeLabel,
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (selected) Color.White else MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }

        Text(
            text = battleState.streamMode.description,
            fontSize = 11.5.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // 3. Instant Zero-Delay Launch CTA
        Button(
            onClick = onPracticeWithAi,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .testTag("start_instant_speed_battle_button"),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
        ) {
            Icon(Icons.Default.Bolt, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${stringResource(R.string.battle_launch_cta)} (${battleState.streamMode.badgeLabel})",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 13.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // 4. Subject Arena Selection
        Text(
            text = stringResource(R.string.battle_subject_section_title),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.ExtraBold
        )

        val subjects = remember(selectedStd) {
            val stdSubjects = com.example.data.QuizStaticData.standardsList
                .find { it.std == selectedStd }
                ?.subjects
                .orEmpty()
            val dynamicList = mutableListOf(Triple("mixed", "All Subjects (Max MCQs)", "⚡"))
            stdSubjects.forEach { subj ->
                val emoji = when (subj.iconName) {
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
                    "cdp" -> "🧠"
                    "teaching_research" -> "🎓"
                    else -> "📚"
                }
                dynamicList.add(Triple(subj.id, subj.title, emoji))
            }
            if (dynamicList.size <= 1) {
                listOf(
                    Triple("mixed", "All Subjects (Max MCQs)", "⚡"),
                    Triple("math", "Mathematics", "📐"),
                    Triple("science", "Science", "🔬"),
                    Triple("kannada", "Kannada", "✍️"),
                    Triple("english", "English", "🔤"),
                    Triple("social", "Social Science", "🌍")
                )
            } else {
                dynamicList
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            subjects.chunked(2).forEach { rowSubjects ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowSubjects.forEach { (id, name, emoji) ->
                        val isSelected = battleState.selectedSubject == id
                        Surface(
                            onClick = { onSelectSubject(id) },
                            shape = RoundedCornerShape(14.dp),
                            color = if (isSelected) Color(0xFF4F46E5) else if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                            border = BorderStroke(
                                1.dp,
                                if (isSelected) Color(0xFF4F46E5) else if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 48.dp)
                                .testTag("battle_subject_$id")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(emoji, fontSize = 18.sp)
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

        // 5. Online Firestore Multiplayer Status & Classmate Room Code Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("battle_firebase_status_card"),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
            ),
            border = BorderStroke(
                1.dp,
                if (isFirebaseGoogleSignedIn) Color(0xFF10B981).copy(alpha = 0.55f) else Color(0xFFF59E0B).copy(alpha = 0.65f)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = if (isFirebaseGoogleSignedIn) Icons.Default.VerifiedUser else Icons.Default.CloudOff,
                        contentDescription = null,
                        tint = if (isFirebaseGoogleSignedIn) Color(0xFF10B981) else Color(0xFFD97706),
                        modifier = Modifier.size(20.dp)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isFirebaseGoogleSignedIn) {
                                "Live Online 1v1 Arena (Up to 100 MCQs)"
                            } else {
                                "Sign in with Google for Online 1v1"
                            },
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = if (isFirebaseGoogleSignedIn) {
                                "Connected as $signedInDisplayName • Instant Firestore rooms"
                            } else {
                                "Connect Google to challenge live classmates or play zero-delay AI duels above."
                            },
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                if (!isFirebaseGoogleSignedIn) {
                    Button(
                        onClick = onSignInWithGoogle,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("battle_google_signin_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Sign in with Google", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                    }
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = onStartMatchmaking,
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                            modifier = Modifier
                                .weight(1.2f)
                                .height(48.dp)
                                .testTag("start_quick_match_button")
                        ) {
                            Icon(Icons.Default.FlashOn, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Online Quick Match", fontWeight = FontWeight.Bold, fontSize = 12.sp, maxLines = 1)
                        }
                        OutlinedButton(
                            onClick = onHostRoom,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(0.9f)
                                .height(48.dp)
                                .testTag("create_room_code_button")
                        ) {
                            Text("Create Code", fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = roomInput,
                            onValueChange = { if (it.length <= 6) roomInput = it.uppercase() },
                            placeholder = { Text("6-digit Room Code", fontSize = 12.5.sp) },
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
                            modifier = Modifier
                                .height(52.dp)
                                .testTag("join_room_button")
                        ) {
                            Text("Join", fontWeight = FontWeight.Bold)
                        }
                    }
                }

                val bannerText = authErrorMessage?.takeIf { it.isNotBlank() }
                    ?: battleState.statusMessage.takeIf { it.isNotBlank() }
                if (bannerText != null) {
                    Text(
                        text = bannerText,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (authErrorMessage != null) Color(0xFFDC2626) else MaterialTheme.colorScheme.primary
                    )
                }
            }
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
        initialValue = 0.92f,
        targetValue = 1.12f,
        animationSpec = infiniteRepeatable(
            animation = tween(700, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(104.dp)
                .scale(pulseScale)
                .clip(CircleShape)
                .background(Color(0xFF4F46E5).copy(alpha = 0.16f))
                .border(2.dp, Color(0xFF4F46E5), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("⚔️", fontSize = 46.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (battleState.isHost && battleState.roomCode.isNotBlank()) {
                "Waiting for Classmate to Join..."
            } else {
                "Finding Online Opponent..."
            },
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = battleState.statusMessage.ifBlank { "Syncing up to 100 quick-fire MCQs..." },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        if (battleState.roomCode.isNotBlank() && battleState.isHost) {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4F46E5).copy(alpha = 0.12f)),
                border = BorderStroke(2.dp, Color(0xFF4F46E5)),
                modifier = Modifier.fillMaxWidth()
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
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))
        CircularProgressIndicator(color = Color(0xFF4F46E5), modifier = Modifier.size(30.dp), strokeWidth = 3.dp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Elapsed: ${battleState.matchmakingSeconds}s",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = onChallengeAi,
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("play_ai_fallback_button")
        ) {
            Text("⚡ Start Zero-Delay AI Duel Now", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = onCancel,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("cancel_battle_search_button")
        ) {
            Text("Cancel Duel")
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
    val playedCount = battleState.answeredCount
    val correctCount = battleState.correctCount
    val avgSec = if (battleState.averageResponseMs > 0L) {
        String.format(Locale.US, "%.1fs", battleState.averageResponseMs / 1000f)
    } else "—"
    val coinsEarned = (if (isWin) 40 else 15) + (correctCount * 3).coerceAtMost(120)
    val xpEarned = (if (isWin) 100 else 40) + (correctCount * 8).coerceAtMost(300)
    val trophiesEarned = if (isWin) 25 + (correctCount / 5) * 5 else 5

    Column(
        modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 640.dp)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = when {
                isWin -> "🏆 VICTORY!"
                isDraw -> "🤝 DRAW!"
                else -> "⚡ DUEL COMPLETE"
            },
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            color = when {
                isWin -> Color(0xFFF59E0B)
                isDraw -> Color(0xFF64748B)
                else -> Color(0xFF4F46E5)
            }
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "$correctCount/$playedCount MCQs correct (${battleState.accuracyPercent}%) • ${battleState.streamMode.displayTitle}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Head-to-Head Scorecard
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
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(userName, fontWeight = FontWeight.Bold, fontSize = 13.5.sp, maxLines = 1)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("${battleState.userScore}", fontSize = 32.sp, fontWeight = FontWeight.Black, color = Color(0xFF4F46E5))
                    Text("Points", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }

                Text("VS", fontWeight = FontWeight.Black, fontSize = 17.sp, color = Color(0xFF94A3B8))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(battleState.opponent?.name ?: "Rival", fontWeight = FontWeight.Bold, fontSize = 13.5.sp, maxLines = 1)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("${battleState.opponentScore}", fontSize = 32.sp, fontWeight = FontWeight.Black, color = Color(0xFFDC2626))
                    Text("Points", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Speed Telemetry Breakdown Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TelemetryStatChip(label = "Answered", value = "$playedCount", modifier = Modifier.weight(1f), isDark = isDark)
            TelemetryStatChip(label = "Best Streak", value = "🔥 ${battleState.maxUserStreak}", modifier = Modifier.weight(1f), isDark = isDark)
            TelemetryStatChip(label = "Avg Speed", value = avgSec, modifier = Modifier.weight(1f), isDark = isDark)
            TelemetryStatChip(label = "Pace", value = "${battleState.questionsPerMinute}/m", modifier = Modifier.weight(1f), isDark = isDark)
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Scaled Rewards Banner
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF10B981).copy(alpha = 0.12f),
            border = BorderStroke(1.dp, Color(0xFF10B981)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("🪙 +$coinsEarned Coins", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                Text("⚡ +$xpEarned XP", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                Text("🏆 +$trophiesEarned", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onPlayAgain,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .testTag("battle_rematch_button"),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5))
        ) {
            Icon(Icons.Default.Refresh, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("PLAY AGAIN (ZERO-DELAY DUEL)", fontWeight = FontWeight.ExtraBold)
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

@Composable
private fun TelemetryStatChip(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    isDark: Boolean
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1
            )
            Text(
                text = label,
                fontSize = 9.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }
    }
}

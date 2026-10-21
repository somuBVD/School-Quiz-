package com.example.ui.quiz

import android.speech.tts.TextToSpeech
import android.widget.Toast
import kotlinx.coroutines.delay
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
import com.example.data.*
import com.example.localization.AppStrings
import com.example.localization.LocalAppStrings
import com.example.ui.dashboard.CertificateData
import com.example.ui.dashboard.QuizCertificateDialog
import java.util.Locale

@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    onExitQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    val quizState by viewModel.activeQuizState.collectAsState()
    val currentLang by viewModel.currentLanguage.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val strings = AppStrings.forLanguage(currentLang)
    val context = LocalContext.current

    // Initialize TextToSpeech for Audio Questions
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    var isTtsReady by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale.ENGLISH
                isTtsReady = true
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    // Timed challenge state
    var isCountdownTimerEnabled by remember { mutableStateOf(true) }

    // Audio feedback for answer submission (correct vs incorrect)
    LaunchedEffect(quizState.currentIndex, quizState.isAnswerSubmitted) {
        if (quizState.isAnswerSubmitted) {
            val lastReview = quizState.sessionAnswerReviews.lastOrNull()
            val isCorrect = lastReview?.isCorrect ?: run {
                val currentQuestion = quizState.questions.getOrNull(quizState.currentIndex)
                if (currentQuestion?.type == "MATCH") {
                    val expected = currentQuestion.correctAnswer.split(",").associate {
                        val split = it.split("=")
                        split[0].toInt() to split[1].toInt()
                    }
                    quizState.userMatchState == expected
                } else {
                    quizState.selectedAnswer.trim().equals(currentQuestion?.correctAnswer?.trim() ?: "", ignoreCase = true)
                }
            }

            if (isCorrect) {
                SoundEffectsManager.playCorrect(context)
            } else {
                SoundEffectsManager.playIncorrect(context)
            }
        }
    }

    // Audio tick for question countdown timer under 5 seconds (only when timer is enabled)
    LaunchedEffect(quizState.secondsRemaining, quizState.isAnswerSubmitted, isCountdownTimerEnabled) {
        if (isCountdownTimerEnabled && !quizState.isAnswerSubmitted && quizState.secondsRemaining in 1..4) {
            SoundEffectsManager.playTimerTick(context)
        }
    }

    // Audio feedback for quiz completion (celebratory victory fanfare)
    LaunchedEffect(quizState.isQuizFinished) {
        if (quizState.isQuizFinished) {
            val isPerfect = quizState.correctCount == quizState.totalQuestions && quizState.totalQuestions > 0
            val isHighScore = quizState.totalScorePoints > 300
            SoundEffectsManager.playQuizCompletion(context, isPerfect = isPerfect, isHighScore = isHighScore)
        }
    }

    if (!quizState.isPlaying) {
        return
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEEF2FF),
                border = BorderStroke(1.dp, Color(0xFFE0E7FF)),
                shadowElevation = 2.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { viewModel.exitQuiz() },
                        modifier = Modifier
                            .size(32.dp)
                            .testTag("exit_quiz_button")
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Exit Quiz",
                            tint = Color(0xFF312E81),
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Text(
                            text = quizState.unitName,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.ExtraBold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color(0xFF1E293B)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            Text(
                                text = "${strings.question} ${quizState.currentIndex + 1}/${quizState.totalQuestions}",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = Color(0xFF475569)
                            )
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFF10B981).copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "💾 Room",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF047857),
                                    modifier = Modifier.padding(horizontal = 3.dp, vertical = 1.dp)
                                )
                            }
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        // Optional Timer Toggle Button
                        IconButton(
                            onClick = {
                                isCountdownTimerEnabled = !isCountdownTimerEnabled
                                Toast.makeText(
                                    context,
                                    if (isCountdownTimerEnabled) "⏱️ Timed Challenge (120s)" else "🌱 Untimed Practice",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier
                                .size(32.dp)
                                .testTag("quiz_timer_toggle_button")
                        ) {
                            Icon(
                                imageVector = if (isCountdownTimerEnabled) Icons.Default.Timer else Icons.Default.TimerOff,
                                contentDescription = if (isCountdownTimerEnabled) "Disable Timer" else "Enable Timer",
                                tint = if (isCountdownTimerEnabled) Color(0xFF4F46E5) else Color(0xFF94A3B8),
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        // In-Quiz Language Switcher Toggle
                        val currentAppLang = com.example.localization.AppLanguage.from(currentLang)
                        IconButton(
                            onClick = {
                                val nextLang = viewModel.toggleNextLanguage()
                                Toast.makeText(
                                    context,
                                    "${nextLang.flagEmoji} ${nextLang.displayName}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier
                                .size(32.dp)
                                .testTag("quiz_language_toggle_button")
                        ) {
                            Text(
                                text = currentAppLang.flagEmoji,
                                fontSize = 13.sp
                            )
                        }

                        // Toggling Review Later & Bookmarks Vault
                        val currentQ = quizState.questions.getOrNull(quizState.currentIndex)
                        val isMarked = quizState.markedForReview.contains(quizState.currentIndex) || (currentQ != null && viewModel.isBookmarked(currentQ.id))
                        IconButton(
                            onClick = {
                                viewModel.toggleMarkForReview()
                                currentQ?.let { viewModel.toggleBookmark(it) }
                            },
                            modifier = Modifier
                                .size(32.dp)
                                .testTag("review_later_button")
                        ) {
                            Icon(
                                imageVector = if (isMarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = "Review Later",
                                tint = if (isMarked) Color(0xFFD97706) else Color(0xFF475569),
                                modifier = Modifier.size(16.dp)
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
            if (quizState.isQuizFinished) {
                // RENDER PLAY RESULTS CONSOLE
                QuizResultsView(
                    quizState = quizState,
                    userProfile = userProfile,
                    onContinueNextUnit = { viewModel.startNextUnitQuiz() },
                    onPlayAgain = {
                        viewModel.startQuiz(
                            quizState.stdId,
                            quizState.subjectId,
                            quizState.unitId,
                            quizState.unitName
                        )
                    },
                    onExit = { viewModel.exitQuiz() },
                    onRetryMistakes = { viewModel.retrySessionMistakes() },
                    onBookmarkQuestion = { viewModel.toggleBookmark(it) },
                    isBookmarked = { viewModel.isBookmarked(it) },
                    onOpenMistakeVault = { viewModel.startMistakePracticeQuiz() }
                )
            } else {
                // RENDER ACTIVE PLAY SHEET WITH MODERN ANIMATED QUESTION TRANSITIONS
                AnimatedContent(
                    targetState = quizState.currentIndex,
                    transitionSpec = {
                        val direction = if (targetState >= initialState) 1 else -1
                        (slideInHorizontally(
                            animationSpec = spring(stiffness = Spring.StiffnessMediumLow, dampingRatio = 0.85f),
                            initialOffsetX = { fullWidth -> direction * (fullWidth / 2) }
                        ) + fadeIn(animationSpec = tween(220))) togetherWith
                        (slideOutHorizontally(
                            animationSpec = tween(180),
                            targetOffsetX = { fullWidth -> -direction * (fullWidth / 3) }
                        ) + fadeOut(animationSpec = tween(160)))
                    },
                    label = "quiz_active_sheet_transition",
                    modifier = Modifier.fillMaxSize()
                ) { index ->
                    val currentQuestion = quizState.questions.getOrNull(index)
                    if (currentQuestion != null) {
                        ActiveQuizPlaySheet(
                            quizState = quizState,
                            currentQuestion = currentQuestion,
                            tts = tts,
                            isTtsReady = isTtsReady,
                            isTimerEnabled = isCountdownTimerEnabled,
                            onSelectAnswer = { viewModel.selectQuizAnswer(it) },
                            onSelectMatchItem = { left, right -> viewModel.selectMatchItem(left, right) },
                            onClearMatchItem = { viewModel.clearMatchItem(it) },
                            onSubmitAnswer = { viewModel.submitQuizAnswer() },
                            onSkipQuestion = { viewModel.skipCurrentQuestion() },
                            onNextQuestion = { viewModel.goToNextQuestion() }
                        )
                    } else {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(color = Color(0xFF4F46E5))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ActiveQuizPlaySheet(
    quizState: QuizViewModel.ActiveQuizState,
    currentQuestion: QuestionModel,
    tts: TextToSpeech?,
    isTtsReady: Boolean,
    isTimerEnabled: Boolean = true,
    onSelectAnswer: (String) -> Unit,
    onSelectMatchItem: (Int, Int) -> Unit,
    onClearMatchItem: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onSkipQuestion: () -> Unit,
    onNextQuestion: () -> Unit
) {
    val scrollState = rememberScrollState()
    val strings = LocalAppStrings.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // COUNTDOWN TIMER WITH ACCURATE TIME RECORDING & OPTIONAL TIMER SUPPORT
            QuestionCountdownTimer(
                secondsRemaining = quizState.secondsRemaining,
                totalSeconds = quizState.totalTimeLimitSeconds,
                isAnswerSubmitted = quizState.isAnswerSubmitted,
                isReviewMarked = quizState.markedForReview.contains(quizState.currentIndex),
                isTimerEnabled = isTimerEnabled
            )

            // QUESTION CARD DISPLAY
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0))
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Specific Render for Graphic styles (IMAGE, AUDIO or VIDEO)
                    when (currentQuestion.type) {
                        "IMAGE" -> {
                            Box(
                                modifier = Modifier
                                    .size(54.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFEEF2FF))
                                    .border(1.dp, Color(0xFFE0E7FF), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                val emoji = when (currentQuestion.mediaRes) {
                                    "geometric_set_square" -> "📐"
                                    "recycle_symbol" -> "♻️"
                                    "wise_owl" -> "🦉"
                                    else -> "🔺"
                                }
                                Text(emoji, fontSize = 32.sp)
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                        }
                        "AUDIO" -> {
                            var isSpeaking by remember { mutableStateOf(false) }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.padding(bottom = 6.dp)
                            ) {
                                Button(
                                    onClick = {
                                        if (isTtsReady && tts != null) {
                                            isSpeaking = true
                                            tts.speak(
                                                currentQuestion.mediaRes,
                                                TextToSpeech.QUEUE_FLUSH,
                                                null,
                                                "QUIZ_SPEECH"
                                            )
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF4F46E5)
                                    ),
                                    shape = CircleShape,
                                    modifier = Modifier
                                        .size(38.dp)
                                        .testTag("speaker_clue_button"),
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                        contentDescription = "Speak Clue",
                                        modifier = Modifier.size(20.dp),
                                        tint = Color.White
                                    )
                                }
                                Text(
                                    text = if (isSpeaking) "🎙️ Playing..." else "🔊 Listen Clue",
                                    fontSize = 11.sp,
                                    color = Color(0xFF4F46E5),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        "VIDEO" -> {
                            var rotationAngle by remember { mutableStateOf(0f) }
                            LaunchedEffect(Unit) {
                                while (true) {
                                    delay(40)
                                    rotationAngle = (rotationAngle + 3) % 360f
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(64.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFF0F172A)),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    // Animated Clock Face rotation
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .border(2.dp, Color.White, CircleShape)
                                            .padding(3.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .width(2.5.dp)
                                                .rotate(rotationAngle)
                                                .background(Color(0xFFEF4444))
                                        )
                                        Box(
                                            modifier = Modifier
                                                .size(5.dp)
                                                .background(Color.White, CircleShape)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "🔴 SIMULATION",
                                        color = Color.White,
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                        }
                    }

                    Text(
                        text = currentQuestion.questionText,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 15.sp,
                            lineHeight = 22.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        softWrap = true,
                        maxLines = Int.MAX_VALUE,
                        overflow = TextOverflow.Visible,
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }
            }

            // VOICE-TO-TEXT INPUT ASSISTANT FOR ACCESSIBILITY & ENGAGEMENT
            VoiceAnswerAssistant(
                options = currentQuestion.options,
                currentQuestionText = currentQuestion.questionText,
                isSubmitted = quizState.isAnswerSubmitted,
                onAnswerMatched = { matchedAnswer ->
                    onSelectAnswer(matchedAnswer)
                },
                onSubmitRequested = {
                    onSubmitAnswer()
                },
                onClearRequested = {
                    onSelectAnswer("")
                }
            )

            // RENDER DYNAMIC COMPONENT ACCORDING TO QUESTION FORMATS
            when (currentQuestion.type) {
                "MATCH" -> {
                    MatchFollowingWidget(
                        currentQuestion = currentQuestion,
                        userMatchState = quizState.userMatchState,
                        isSubmitted = quizState.isAnswerSubmitted,
                        onMatchSelected = onSelectMatchItem,
                        onClearMatch = onClearMatchItem
                    )
                }
                "FILL" -> {
                    FillBlankWidget(
                        selectedWord = quizState.selectedAnswer,
                        options = currentQuestion.options,
                        isSubmitted = quizState.isAnswerSubmitted,
                        onWordSelected = onSelectAnswer
                    )
                }
                else -> {
                    // MCQ, TF, IMAGE, AUDIO, VIDEO fallbacks: Standard Option click Cards
                    StandardOptionsGrid(
                        options = currentQuestion.options,
                        selected = quizState.selectedAnswer,
                        correctAnswer = currentQuestion.correctAnswer,
                        isSubmitted = quizState.isAnswerSubmitted,
                        onSelect = onSelectAnswer
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // SUBMISSION STATE CONTROL FOOTER
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            if (quizState.isAnswerSubmitted) {
                // EXPLANATION & POINTS/TIME BREAKDOWN CONTAINER
                val isCorrect = quizState.selectedAnswer.trim().equals(currentQuestion.correctAnswer.trim(), ignoreCase = true) || currentQuestion.type == "MATCH"
                val lastResult = quizState.lastQuestionResult
                val lastStat = quizState.questionTimeStats.lastOrNull()

                Card(
                    modifier = Modifier.fillMaxWidth().testTag("answer_explanation_card"),
                    shape = RoundedCornerShape(24.dp), // rounded-3xl
                    colors = CardDefaults.cardColors(
                        containerColor = if (isCorrect) Color(0xFFDCFCE7) else Color(0xFFFEE2E2) // green-100 vs red-100
                    ),
                    border = BorderStroke(1.dp, if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFCA5A5))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = if (isCorrect) "✅ Correct Answer" else "❌ Incorrect Answer",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 14.sp,
                                    color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB91C1C)
                                )
                                if (isCorrect) {
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = Color(0xFF10B981).copy(alpha = 0.2f),
                                        border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.5f))
                                    ) {
                                        Text(
                                            text = "+25 XP",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color(0xFF047857),
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                            if (lastStat != null) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(lastStat.zone.colorHex).copy(alpha = 0.18f),
                                    border = BorderStroke(1.dp, Color(lastStat.zone.colorHex).copy(alpha = 0.4f))
                                ) {
                                    Text(
                                        text = "⏱️ ${lastStat.timeTakenSeconds}s taken",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(lastStat.zone.colorHex),
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }

                        // TIME THRESHOLD & POINTS DEDUCTION BANNER
                        if (lastResult != null) {
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                                border = BorderStroke(1.dp, Color(lastResult.zone.colorHex).copy(alpha = 0.35f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text(lastResult.zone.badgeEmoji, fontSize = 14.sp)
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Column {
                                            Text(
                                                text = lastResult.zone.label,
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Color(lastResult.zone.colorHex)
                                            )
                                            Text(
                                                text = lastResult.zone.ruleDescription,
                                                fontSize = 10.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                    Text(
                                        text = if (isCorrect) "+${lastResult.finalPoints} pts" else "0 pts",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Black,
                                        color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB91C1C)
                                    )
                                }
                            }
                        }

                        Text(
                            text = "Correct Answer: ${currentQuestion.correctAnswer}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF1E293B)
                        )
                        Text(
                            text = currentQuestion.explanation,
                            fontSize = 12.sp,
                            color = Color(0xFF475569)
                        )
                    }
                }

                Button(
                    onClick = onNextQuestion,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("next_question_button"),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isCorrect) Color(0xFF10B981) else Color(0xFF4F46E5)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = when {
                            isCorrect && quizState.currentIndex + 1 == quizState.totalQuestions -> strings.autoAdvanceFinish
                            isCorrect -> strings.autoAdvanceNext
                            quizState.currentIndex + 1 == quizState.totalQuestions -> strings.finishQuiz
                            else -> strings.nextQuestion
                        },
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = onSkipQuestion,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .testTag("skip_question_button"),
                        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Skip Question",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.5.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color(0xFF475569)
                        )
                    }

                    Button(
                        onClick = onSubmitAnswer,
                        enabled = quizState.selectedAnswer.isNotEmpty() || (currentQuestion.type == "MATCH" && quizState.userMatchState.size == currentQuestion.options.size),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .testTag("submit_answer_button"),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4F46E5), // indigo
                            disabledContainerColor = Color(0xFFE2E8F0)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Submit Answer",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 12.5.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = if (quizState.selectedAnswer.isNotEmpty() || (currentQuestion.type == "MATCH" && quizState.userMatchState.size == currentQuestion.options.size)) Color.White else Color(0xFF94A3B8)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StandardOptionsGrid(
    options: List<String>,
    selected: String,
    correctAnswer: String,
    isSubmitted: Boolean,
    onSelect: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        options.forEachIndexed { index, option ->
            val isOptionSelected = selected.trim().equals(option.trim(), ignoreCase = true)
            val isOptionCorrect = option.trim().equals(correctAnswer.trim(), ignoreCase = true)

            val targetContainerColor = when {
                isSubmitted && isOptionCorrect -> Color(0xFFDCFCE7) // green-100
                isSubmitted && isOptionSelected && !isOptionCorrect -> Color(0xFFFEE2E2) // red-100
                isOptionSelected -> Color(0xFFEEF2FF) // indigo-50
                else -> Color.White
            }

            val targetBorderColor = when {
                isSubmitted && isOptionCorrect -> Color(0xFF10B981) // emerald-500
                isSubmitted && isOptionSelected && !isOptionCorrect -> Color(0xFFEF4444) // red-500
                isOptionSelected -> Color(0xFF4F46E5) // indigo-600
                else -> Color(0xFFE2E8F0) // slate-200
            }

            val animContainerColor by animateColorAsState(
                targetValue = targetContainerColor,
                animationSpec = tween(220),
                label = "opt_bg"
            )
            val animBorderColor by animateColorAsState(
                targetValue = targetBorderColor,
                animationSpec = tween(220),
                label = "opt_border"
            )
            val optionScale by animateFloatAsState(
                targetValue = if (isOptionSelected) 1.02f else 1f,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                label = "opt_scale"
            )

            val labelChar = ('A' + index).toString()

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(optionScale)
                    .clickable(enabled = !isSubmitted) { onSelect(option) }
                    .border(1.dp, animBorderColor, RoundedCornerShape(16.dp))
                    .testTag("option_card_${index}"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = animContainerColor)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 11.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(
                                if (isOptionSelected) Color(0xFF4F46E5)
                                else Color(0xFFF1F5F9)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = labelChar,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isOptionSelected) Color.White else Color(0xFF475569)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = option,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E293B),
                        softWrap = true,
                        maxLines = Int.MAX_VALUE,
                        modifier = Modifier.weight(1f)
                    )

                    if (isSubmitted && isOptionCorrect) {
                        Text("✅", fontSize = 16.sp)
                    } else if (isSubmitted && isOptionSelected && !isOptionCorrect) {
                        Text("❌", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun FillBlankWidget(
    selectedWord: String,
    options: List<String>,
    isSubmitted: Boolean,
    onWordSelected: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Blanks Input/State Visuals
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color(0xFFE2E8F0)), RoundedCornerShape(16.dp))
                .background(Color(0xFFF8FAFC))
                .padding(14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (selectedWord.isEmpty()) "❓ [Tap your answer below]" else selectedWord,
                fontSize = 16.sp,
                color = if (selectedWord.isEmpty()) Color(0xFF94A3B8) else Color(0xFF4F46E5),
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        }

        Text(
            text = "TAP TO CHOOSE ANSWER:",
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF64748B)
        )

        // Options Candidates arranged in 2 columns so long text never squishes or overflows
        val chunked = options.chunked(2)
        chunked.forEach { rowOpts ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                rowOpts.forEach { opt ->
                    val active = selectedWord.trim().equals(opt.trim(), ignoreCase = true)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (active) Color(0xFFEEF2FF) else Color(0xFFF1F5F9)
                            )
                            .border(
                                1.dp,
                                if (active) Color(0xFF4F46E5) else Color(0xFFE2E8F0),
                                RoundedCornerShape(12.dp)
                            )
                            .clickable(enabled = !isSubmitted) { onWordSelected(opt) }
                            .padding(vertical = 10.dp, horizontal = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = opt,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (active) Color(0xFF4F46E5) else Color(0xFF334155),
                            textAlign = TextAlign.Center,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                if (rowOpts.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun MatchFollowingWidget(
    currentQuestion: QuestionModel,
    userMatchState: Map<Int, Int>, // LeftIndex -> RightIndex
    isSubmitted: Boolean,
    onMatchSelected: (Int, Int) -> Unit,
    onClearMatch: (Int) -> Unit
) {
    val splitItems = currentQuestion.options.map { it.split("=") }
    val leftItems = splitItems.map { it.firstOrNull() ?: "" }
    val rightItems = remember(currentQuestion) {
        splitItems.mapIndexed { i, parts -> i to (parts.lastOrNull() ?: "") }.shuffled()
    }

    var selectedLeftIndex by remember { mutableStateOf<Int?>(null) }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "👇 TAP ONE ON LEFT, THEN TAP MATCHING RESPONSE ON RIGHT:",
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF64748B),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // LEFT COLUMN
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "COLUMN A",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF4F46E5)
                )

                leftItems.forEachIndexed { i, left ->
                    val isTapped = selectedLeftIndex == i
                    val hasMatched = userMatchState.containsKey(i)
                    val matchTarget = userMatchState[i]
                    val rightText = if (matchTarget != null) {
                        rightItems.find { it.first == matchTarget }?.second ?: ""
                    } else ""

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(enabled = !isSubmitted) {
                                if (hasMatched) {
                                    onClearMatch(i)
                                } else {
                                    selectedLeftIndex = i
                                }
                            }
                            .border(
                                width = if (isTapped) 2.dp else 1.dp,
                                color = if (isTapped) Color(0xFF4F46E5) else Color(0xFFE2E8F0),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (hasMatched) Color(0xFFDCFCE7) else Color.White
                        )
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = left,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF1E293B)
                            )
                            if (hasMatched) {
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "🔗 paired: $rightText",
                                    fontSize = 11.sp,
                                    color = Color(0xFF15803D),
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }
                }
            }

            // RIGHT COLUMN
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "COLUMN B",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF4F46E5)
                )

                rightItems.forEach { (rightIndex, rightText) ->
                    val isUsed = userMatchState.values.contains(rightIndex)

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(enabled = !isSubmitted && selectedLeftIndex != null && !isUsed) {
                                val left = selectedLeftIndex
                                if (left != null) {
                                    onMatchSelected(left, rightIndex)
                                    selectedLeftIndex = null
                                }
                            }
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE2E8F0),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isUsed) Color(0xFFF1F5F9) else Color.White
                        )
                    ) {
                        Text(
                            text = rightText,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isUsed) Color(0xFF94A3B8) else Color(0xFF1E293B),
                            modifier = Modifier.padding(14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuizResultsView(
    quizState: QuizViewModel.ActiveQuizState,
    userProfile: com.example.data.UserProfile? = null,
    onContinueNextUnit: () -> Unit = {},
    onPlayAgain: () -> Unit,
    onExit: () -> Unit,
    onRetryMistakes: () -> Unit = {},
    onBookmarkQuestion: (QuestionModel) -> Unit = {},
    isBookmarked: (String) -> Boolean = { false },
    onOpenMistakeVault: () -> Unit = {}
) {
    val accuracy = if (quizState.totalQuestions > 0) {
        ((quizState.correctCount.toFloat() / quizState.totalQuestions) * 100).toInt()
    } else 0

    val totalSecs = quizState.totalTimeTakenSeconds
    val formattedTotalTime = if (totalSecs >= 60) {
        "${totalSecs / 60}m ${totalSecs % 60}s"
    } else {
        "${totalSecs}s"
    }

    val avgTimePerQ = if (quizState.questionTimeStats.isNotEmpty()) {
        String.format(Locale.getDefault(), "%.1fs", totalSecs.toFloat() / quizState.questionTimeStats.size)
    } else {
        "0s"
    }

    val scrollState = rememberScrollState()
    val isHighScore = accuracy >= 70
    val isPerfectScore = accuracy == 100
    var celebrationTrigger by remember { mutableIntStateOf(1) }
    var showCertificateDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 12.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Celebratory Banner on quiz completion with dynamic confetti trigger
            QuizCompletionCelebrationBanner(
                accuracy = accuracy,
                isHighScore = isHighScore,
                isPerfect = isPerfectScore,
                onTriggerCelebration = { celebrationTrigger++ }
            )

            // UNIFIED COMPACT QUIZ SUMMARY CARD
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quiz_summary_card"),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Header Row: Title & Subtitle on left, Trophy badge on right
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f).padding(end = 8.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "Quiz Summary!",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF1E293B),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = if (isHighScore) Color(0xFF10B981).copy(alpha = 0.15f) else Color(0xFF6366F1).copy(alpha = 0.15f)
                                ) {
                                    Text(
                                        text = if (isPerfectScore) "PERFECT 🌟" else if (isHighScore) "PASSED ✨" else "COMPLETED 👍",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isHighScore) Color(0xFF047857) else Color(0xFF4338CA),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            val stdLabel = when (quizState.stdId) {
                                11 -> "Morarji"
                                12 -> "NMMS"
                                else -> "Standard ${quizState.stdId}"
                            }
                            Text(
                                text = "${quizState.unitName} • $stdLabel",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF64748B),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        // Compact Trophy Badge
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFFEF3C7),
                            border = BorderStroke(1.dp, Color(0xFFFDE68A)),
                            modifier = Modifier.size(38.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(if (isPerfectScore) "👑" else "🏆", fontSize = 19.sp)
                            }
                        }
                    }

                    HorizontalDivider(color = Color(0xFFF1F5F9))

                    // Stats Row: Circular Score Meter + 3 Quick Metric Chips
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Compact Circular Meter (62dp)
                        Box(
                            modifier = Modifier
                                .size(62.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.radialGradient(
                                        colors = listOf(Color(0xFFEEF2FF), MaterialTheme.colorScheme.background)
                                    )
                                )
                                .border(2.dp, Color(0xFF6366F1).copy(alpha = 0.3f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "$accuracy%",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF4F46E5),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Score",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF64748B),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        // Key Stats Grid in 3 mini badges
                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Accuracy", fontSize = 9.5.sp, color = Color(0xFF64748B))
                                Text(
                                    text = "${quizState.correctCount}/${quizState.totalQuestions}",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFF10B981)
                                )
                                Text("Correct", fontSize = 8.5.sp, color = Color(0xFF059669))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Total Time", fontSize = 9.5.sp, color = Color(0xFF64748B))
                                Text(
                                    text = formattedTotalTime,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFF1E293B)
                                )
                                Text("Duration", fontSize = 8.5.sp, color = Color(0xFF64748B))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Points", fontSize = 9.5.sp, color = Color(0xFF64748B))
                                Text(
                                    text = "${quizState.totalScorePoints}",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFF4F46E5)
                                )
                                Text("Earned", fontSize = 8.5.sp, color = Color(0xFF4F46E5))
                            }
                        }
                    }
                }
            }

            // PERFORMANCE FEEDBACK & EVALUATION CARD (ಅಧ್ಯಯನ ವಿಮರ್ಶೆ ಮತ್ತು ಮಾರ್ಗದರ್ಶನ)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quiz_performance_feedback_card"),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = when {
                        accuracy >= 80 -> Color(0xFFF0FDF4)
                        accuracy >= 60 -> Color(0xFFEFF6FF)
                        else -> Color(0xFFFFFBEB)
                    }
                ),
                border = BorderStroke(
                    1.dp,
                    when {
                        accuracy >= 80 -> Color(0xFFBBF7D0)
                        accuracy >= 60 -> Color(0xFFBFDBFE)
                        else -> Color(0xFFFDE68A)
                    }
                )
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = when {
                                accuracy >= 90 -> "🌟"
                                accuracy >= 75 -> "🎯"
                                accuracy >= 60 -> "💡"
                                else -> "📖"
                            },
                            fontSize = 20.sp
                        )
                        Column {
                            Text(
                                text = "Performance Feedback • ಅಧ್ಯಯನ ವಿಮರ್ಶೆ",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = when {
                                    accuracy >= 80 -> Color(0xFF166534)
                                    accuracy >= 60 -> Color(0xFF1E40AF)
                                    else -> Color(0xFF92400E)
                                }
                            )
                            Text(
                                text = when {
                                    accuracy >= 90 -> "ಅತ್ಯುನ್ನತ ಪ್ರದರ್ಶನ! (Outstanding Mastery)"
                                    accuracy >= 75 -> "ಉತ್ತಮ ಪ್ರದರ್ಶನ! (Commendable Performance)"
                                    accuracy >= 60 -> "ಉತ್ತಮ ಪ್ರಯತ್ನ! (Good Effort)"
                                    else -> "ಕಠಿಣ ಅಭ್ಯಾಸ ಅಗತ್ಯವಿದೆ (More Practice Needed)"
                                },
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = when {
                                    accuracy >= 80 -> Color(0xFF15803D)
                                    accuracy >= 60 -> Color(0xFF2563EB)
                                    else -> Color(0xFFB45309)
                                }
                            )
                        }
                    }

                    Text(
                        text = when {
                            accuracy >= 90 -> "ನೀವು ಈ ಘಟಕದಲ್ಲಿ ಅತ್ಯುನ್ನತ ಜ್ಞಾನ ಮತ್ತು ವೇಗವನ್ನು ಪ್ರದರ್ಶಿಸಿದ್ದೀರಿ. NMMS ಪರೀಕ್ಷೆಯಲ್ಲಿ ಅಗ್ರ ಶ್ರೇಣಿಗೆ ಇದು ಉತ್ತಮ ತಯಾರಿ! ಮುಂದಿನ ಘಟಕವನ್ನು ಅಭ್ಯಾಸ ಮಾಡಿ."
                            accuracy >= 75 -> "ಮೂಲ ಪರಿಕಲ್ಪನೆಗಳನ್ನು ಚೆನ್ನಾಗಿ ಅರ್ಥಮಾಡಿಕೊಂಡಿದ್ದೀರಿ. ತಪ್ಪು ಉತ್ತರಗಳನ್ನು ಒಮ್ಮೆ ವಿಮರ್ಶೆ ಮಾಡಿ (Review Mistakes) 100% ನಿಖರತೆ ಸಾಧಿಸಿ."
                            accuracy >= 60 -> "ಉತ್ತಮ ಪ್ರಯತ್ನ! ಕೆಲವು ಪ್ರಶ್ನೆಗಳಲ್ಲಿ ಸೂತ್ರಗಳು ಮತ್ತು ಲೆಕ್ಕಾಚಾರಗಳನ್ನು ಇನ್ನಷ್ಟು ಪರಿಷ್ಕರಿಸಿ. ಪುನರಾವರ್ತಿತ ಅಭ್ಯಾಸವು ನಿಮ್ಮ ಅಂಕಗಳನ್ನು ಹೆಚ್ಚಿಸುತ್ತದೆ."
                            else -> "ಚಿಂತಿಸಬೇಡಿ! ಪರಿಕಲ್ಪನೆಗಳನ್ನು ಮತ್ತೊಮ್ಮೆ ಓದಿ, ಸೂತ್ರಗಳನ್ನು ನೆನಪಿಟ್ಟುಕೊಂಡು ತಪ್ಪುಗಳ ಕಣಜದಲ್ಲಿ (Mistake Vault) ಅಭ್ಯಾಸ ಮಾಡಿ."
                        },
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f),
                        lineHeight = 17.sp,
                        softWrap = true
                    )
                }
            }

        // INCORRECT ANSWER REVIEW & DETAILED CONCEPT EXPLANATIONS
        IncorrectAnswerReviewSection(
            reviews = quizState.sessionAnswerReviews,
            onBookmarkQuestion = onBookmarkQuestion,
            isBookmarked = isBookmarked,
            onRetryMistakes = onRetryMistakes,
            onOpenMistakeVault = onOpenMistakeVault,
            modifier = Modifier.fillMaxWidth()
        )

        // TIME & THRESHOLD DEDUCTIONS ANALYTICS CARD
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("time_analytics_card"),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.5.dp, Color(0xFFE2E8F0))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⏱️", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Time & Points Calculation",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF1E293B)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF4F46E5).copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = "Threshold Engine",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4F46E5),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }

                // 4-Column Grid for Metrics
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Total Time", fontSize = 10.sp, color = Color(0xFF64748B))
                        Text(formattedTotalTime, fontSize = 14.sp, fontWeight = FontWeight.Black, color = Color(0xFF1E293B))
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Avg Speed", fontSize = 10.sp, color = Color(0xFF64748B))
                        Text(avgTimePerQ, fontSize = 14.sp, fontWeight = FontWeight.Black, color = Color(0xFF3B82F6))
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Deductions", fontSize = 10.sp, color = Color(0xFF64748B))
                        Text(
                            text = if (quizState.totalTimeDeducted > 0) "-${quizState.totalTimeDeducted} pts" else "0 pts",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            color = if (quizState.totalTimeDeducted > 0) Color(0xFFEF4444) else Color(0xFF10B981)
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Speed Bonus", fontSize = 10.sp, color = Color(0xFF64748B))
                        Text(
                            text = "+${quizState.totalSpeedBonus} pts",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF10B981)
                        )
                    }
                }

                HorizontalDivider(color = Color(0xFFF1F5F9))

                // Points summary banner
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Net Quiz Points Earned:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF475569)
                    )
                    Text(
                        text = "${quizState.totalScorePoints} pts",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF4F46E5),
                        modifier = Modifier.testTag("net_quiz_points_text")
                    )
                }
            }
        }

        // DETAILED PER-QUESTION TIMING BREAKDOWN TABLE
        if (quizState.questionTimeStats.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("question_time_stats_card"),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0))
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
                        Text(
                            text = "Question-by-Question Timing",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF1E293B)
                        )
                        Text(
                            text = "${quizState.questionTimeStats.size} Questions",
                            fontSize = 11.sp,
                            color = Color(0xFF64748B)
                        )
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        quizState.questionTimeStats.forEach { stat ->
                            val zoneColor = Color(stat.zone.colorHex)
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (stat.isCorrect) Color(0xFFF8FAFC) else Color(0xFFFEF2F2),
                                border = BorderStroke(1.dp, zoneColor.copy(alpha = 0.3f)),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("question_time_row_${stat.questionIndex}")
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text(
                                            text = if (stat.isCorrect) "✅" else "❌",
                                            fontSize = 12.sp
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Column {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text(
                                                    text = "Q${stat.questionIndex + 1}",
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Color(0xFF1E293B)
                                                )
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = "⏱️ ${stat.timeTakenSeconds}s",
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = zoneColor
                                                )
                                            }
                                            Text(
                                                text = stat.zone.label,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = zoneColor
                                            )
                                        }
                                    }

                                    Column(horizontalAlignment = Alignment.End) {
                                        Text(
                                            text = if (stat.isCorrect) "+${stat.finalPoints} pts" else "0 pts",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Black,
                                            color = if (stat.isCorrect) Color(0xFF15803D) else Color(0xFFB91C1C)
                                        )
                                        if (stat.penaltyDeduction > 0) {
                                            Text(
                                                text = "(-${stat.penaltyDeduction} penalty)",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFEF4444)
                                            )
                                        } else if (stat.speedBonus > 0) {
                                            Text(
                                                text = "(+${stat.speedBonus} bonus)",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF10B981)
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

        // BADGE / HONOR GREETINGS
        if (accuracy == 100) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF3C7)), // amber-100
                shape = RoundedCornerShape(24.dp), // rounded-3xl
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, Color(0xFFFDE68A))
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text("🥋", fontSize = 28.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "UNLOCKED: PERFECT BLADE BADGE!",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFB45309)
                        )
                        Text(
                            text = "Achieved 100% correct answers with flawless speed.",
                            fontSize = 11.sp,
                            color = Color(0xFF78350F)
                        )
                    }
                }
            }
        }

        // REWARDS SUMMARY CHIPS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Coins won
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp), // rounded-3xl
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF3C7)), // amber-100
                border = BorderStroke(1.dp, Color(0xFFFDE68A))
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("🪙 Coins", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF92400E))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "+${quizState.earnedCoins}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF78350F)
                    )
                }
            }

            // Stars won
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp), // rounded-3xl
                colors = CardDefaults.cardColors(containerColor = Color(0xFFD1FAE5)), // emerald-100
                border = BorderStroke(1.dp, Color(0xFFA7F3D0))
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("⭐ Stars", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF065F46))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "+${quizState.earnedStars}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF047857)
                    )
                }
            }

            // XP won
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp), // rounded-3xl
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E8FF)), // purple-100
                border = BorderStroke(1.dp, Color(0xFFE9D5FF))
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("⚡ XP Points", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF6B21A8))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "+${quizState.earnedXP}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF5B21B6)
                    )
                }
            }
        }

        // STUDENT LEVEL & XP PROGRESSION SUMMARY
        val currentLevel = com.example.data.StudentLevelSystem.calculateLevel(userProfile?.xp ?: 0)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("quiz_result_level_progression_card"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.5.dp, Color(currentLevel.colorHex).copy(alpha = 0.4f))
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
                        Text(currentLevel.badgeEmoji, fontSize = 22.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "Student Level ${currentLevel.level}",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 14.sp,
                                    color = Color(currentLevel.colorHex)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Color(currentLevel.colorHex).copy(alpha = 0.15f)
                                ) {
                                    Text(
                                        text = currentLevel.rankBadge,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(currentLevel.colorHex),
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            Text(
                                text = currentLevel.title,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Text(
                        text = "${currentLevel.totalXp} XP",
                        fontWeight = FontWeight.Black,
                        fontSize = 13.sp,
                        color = Color(currentLevel.colorHex)
                    )
                }

                LinearProgressIndicator(
                    progress = { currentLevel.progressFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Color(currentLevel.colorHex),
                    trackColor = Color(0xFFE2E8F0)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (currentLevel.nextUnlockTitle != null) "${currentLevel.xpRequiredForNextLevel} XP to ${currentLevel.nextUnlockTitle}" else "Max Level Reached! 👑",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = Color(0xFF10B981).copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = "+25 XP / correct",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF047857),
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }

        // NEXT CHAPTER PROGRESSION BANNER & DIRECT CONTINUE BUTTON
        val nextUnitInfo = remember(quizState.stdId, quizState.subjectId, quizState.unitId) {
            QuizStaticData.getNextUnit(quizState.stdId, quizState.subjectId, quizState.unitId)
        }

        if (nextUnitInfo != null) {
            val (nextSubj, nextUnit) = nextUnitInfo
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("next_unit_progression_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFECFDF5)), // emerald-50
                border = BorderStroke(1.5.dp, Color(0xFF10B981).copy(alpha = 0.5f))
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
                            Text("✨", fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Next Chapter Ready!",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF065F46)
                            )
                        }
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF10B981).copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "${nextSubj.title} • Unit ${nextUnit.id}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF047857),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Text(
                        text = "Great job finishing Unit ${quizState.unitId}! Keep your learning streak going with Unit ${nextUnit.id} (${nextUnit.name}).",
                        fontSize = 11.5.sp,
                        color = Color(0xFF047857),
                        lineHeight = 16.sp
                    )

                    Button(
                        onClick = onContinueNextUnit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .testTag("continue_next_unit_button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF10B981) // emerald-500
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Continue to Unit ${nextUnit.id}: ${nextUnit.name}",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Continue",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }

        // CERTIFICATE OF EXCELLENCE BUTTON (For Passing Scores)
        if (accuracy >= 60) {
            FilledTonalButton(
                onClick = { showCertificateDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("quiz_result_view_certificate_button"),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color(0xFFFEF3C7),
                    contentColor = Color(0xFFB45309)
                )
            ) {
                Text("🎓 View Certificate of Excellence", fontWeight = FontWeight.ExtraBold, fontSize = 13.5.sp)
            }
        }

        if (showCertificateDialog) {
            QuizCertificateDialog(
                certificateData = CertificateData(
                    studentName = userProfile?.name ?: "Dedicated Student",
                    standard = quizState.stdId,
                    subjectTitle = quizState.subjectId.replaceFirstChar { it.uppercase() },
                    unitName = quizState.unitName,
                    score = quizState.correctCount,
                    totalQuestions = quizState.totalQuestions,
                    accuracyPercentage = accuracy,
                    completedAt = System.currentTimeMillis()
                ),
                isDark = false,
                onDismiss = { showCertificateDialog = false }
            )
        }

        // CONTROLLER BACK TO WORKSPACE
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedButton(
                onClick = onExit,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .testTag("exit_summary_button"),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Exit Class", fontWeight = FontWeight.Bold, color = Color(0xFF475569))
            }

            if (quizState.incorrectReviewItems.isNotEmpty()) {
                Button(
                    onClick = onRetryMistakes,
                    modifier = Modifier
                        .weight(1.2f)
                        .height(48.dp)
                        .testTag("retry_mistakes_bottom_button"),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Mistakes (${quizState.incorrectReviewItems.size})", fontWeight = FontWeight.ExtraBold, color = Color.White, fontSize = 12.sp)
                }
            }

            Button(
                onClick = onPlayAgain,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .testTag("replay_quiz_button"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4F46E5)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Replay", fontWeight = FontWeight.ExtraBold, color = Color.White)
            }
        }
    }

    // Confetti & Star Burst Particle Animation Overlay
    CelebrationParticleOverlay(
        triggerKey = celebrationTrigger,
        isHighScore = isHighScore,
        isPerfectScore = isPerfectScore,
        modifier = Modifier.fillMaxSize()
    )
}
}

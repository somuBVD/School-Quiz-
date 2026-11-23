package com.example.ui.exam

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import com.example.QuizViewModel
import com.example.data.QuestionModel
import com.example.ui.quiz.SessionAnswerReview
import java.util.Locale

/**
 * Result data model for completed Mock Exam diagnostic report.
 */
data class MockExamResult(
    val totalQuestions: Int,
    val correctCount: Int,
    val incorrectCount: Int,
    val unansweredCount: Int,
    val totalScore: Int,
    val percentage: Float,
    val grade: String,
    val timeTakenSeconds: Int,
    val xpAwarded: Int,
    val reviews: List<SessionAnswerReview>
)

/**
 * State of active Board Mock Exam.
 */
data class MockExamState(
    val isActive: Boolean = false,
    val stdId: Int = 10,
    val subjectId: String = "math",
    val subjectTitle: String = "Mathematics",
    val questions: List<QuestionModel> = emptyList(),
    val userAnswers: Map<Int, String> = emptyMap(),
    val markedForReview: Set<Int> = emptySet(),
    val currentIndex: Int = 0,
    val secondsRemaining: Int = 900, // 15 mins default
    val totalDurationSeconds: Int = 900,
    val isFinished: Boolean = false,
    val result: MockExamResult? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockExamSimulatorScreen(
    state: MockExamState,
    onSelectAnswer: (Int, String) -> Unit,
    onToggleReview: (Int) -> Unit,
    onClearAnswer: (Int) -> Unit,
    onJumpToQuestion: (Int) -> Unit,
    onSubmitExam: () -> Unit,
    onExitExam: () -> Unit,
    onRetakeExam: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showSubmitConfirmationDialog by remember { mutableStateOf(false) }
    var showQuestionPaletteBottomSheet by remember { mutableStateOf(false) }

    if (state.isFinished && state.result != null) {
        // RENDER POST-EXAM COMPREHENSIVE DIAGNOSTIC REPORT
        MockExamReportView(
            result = state.result,
            subjectTitle = state.subjectTitle,
            standard = state.stdId,
            onRetake = onRetakeExam,
            onExit = onExitExam,
            modifier = modifier
        )
        return
    }

    val currentQuestion = state.questions.getOrNull(state.currentIndex)
    val mins = state.secondsRemaining / 60
    val secs = state.secondsRemaining % 60
    val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", mins, secs)
    val isTimeLow = state.secondsRemaining <= 120

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "📝 ${state.subjectTitle} Mock Exam",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFF6366F1).copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "Std ${state.stdId}",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF4F46E5),
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "Question ${state.currentIndex + 1} of ${state.questions.size}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { showSubmitConfirmationDialog = true }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Exit Exam")
                    }
                },
                actions = {
                    // Timer Chip
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (isTimeLow) Color(0xFFEF4444).copy(alpha = 0.15f) else Color(0xFF10B981).copy(alpha = 0.15f),
                        border = BorderStroke(
                            1.dp,
                            if (isTimeLow) Color(0xFFEF4444) else Color(0xFF10B981)
                        ),
                        modifier = Modifier.padding(end = 6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = if (isTimeLow) "🚨" else "⏱️",
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = formattedTime,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isTimeLow) Color(0xFFDC2626) else Color(0xFF047857)
                            )
                        }
                    }

                    // Question Palette Toggle
                    IconButton(
                        onClick = { showQuestionPaletteBottomSheet = true },
                        modifier = Modifier.testTag("exam_palette_button")
                    ) {
                        Icon(Icons.Default.GridView, contentDescription = "Question Palette", tint = Color(0xFF6366F1))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Previous Question Button
                    OutlinedButton(
                        onClick = {
                            if (state.currentIndex > 0) {
                                onJumpToQuestion(state.currentIndex - 1)
                            }
                        },
                        enabled = state.currentIndex > 0,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Prev", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Mark for Review Button
                    val isMarked = state.markedForReview.contains(state.currentIndex)
                    Button(
                        onClick = { onToggleReview(state.currentIndex) },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isMarked) Color(0xFF8B5CF6) else Color(0xFFF3E8FF),
                            contentColor = if (isMarked) Color.White else Color(0xFF7C3AED)
                        ),
                        modifier = Modifier.weight(1.2f)
                    ) {
                        Text(
                            text = if (isMarked) "🟣 Marked" else "Mark Review",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Next / Finish Button
                    if (state.currentIndex < state.questions.size - 1) {
                        Button(
                            onClick = { onJumpToQuestion(state.currentIndex + 1) },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Next", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next", modifier = Modifier.size(16.dp))
                        }
                    } else {
                        Button(
                            onClick = { showSubmitConfirmationDialog = true },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Finish", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Quick Mini Status Bar (Answered vs Unanswered)
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🟢 ${state.userAnswers.size} Answered",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF047857)
                    )
                    Text(
                        text = "🟣 ${state.markedForReview.size} For Review",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6D28D9)
                    )
                    Text(
                        text = "⚪ ${state.questions.size - state.userAnswers.size} Remaining",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Question Card
            if (currentQuestion != null) {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFFEEF2FF)
                            ) {
                                Text(
                                    text = "Question ${state.currentIndex + 1}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF4F46E5),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }

                            if (state.userAnswers.containsKey(state.currentIndex)) {
                                TextButton(
                                    onClick = { onClearAnswer(state.currentIndex) },
                                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text("Clear Response", fontSize = 11.sp, color = Color(0xFFEF4444))
                                }
                            }
                        }

                        // Question Text
                        Text(
                            text = currentQuestion.questionText,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 22.sp
                        )

                        HorizontalDivider(color = Color(0xFFF1F5F9))

                        // Options
                        val selectedChoice = state.userAnswers[state.currentIndex]
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            currentQuestion.options.forEachIndexed { optIndex, optionText ->
                                val isSelected = selectedChoice == optionText
                                val optionPrefix = ('A' + optIndex).toString()

                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = if (isSelected) Color(0xFF4F46E5).copy(alpha = 0.1f) else MaterialTheme.colorScheme.surface,
                                    border = BorderStroke(
                                        1.5.dp,
                                        if (isSelected) Color(0xFF4F46E5) else Color(0xFFE2E8F0)
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(12.dp))
                                        .clickable {
                                            onSelectAnswer(state.currentIndex, optionText)
                                        }
                                        .testTag("mock_exam_opt_$optIndex")
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(
                                                    if (isSelected) Color(0xFF4F46E5) else Color(0xFFF1F5F9)
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = optionPrefix,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = if (isSelected) Color.White else Color(0xFF475569)
                                            )
                                        }

                                        Spacer(modifier = Modifier.width(12.dp))

                                        Text(
                                            text = optionText,
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                            color = if (isSelected) Color(0xFF1E293B) else MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.weight(1f)
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

    // Submit Confirmation Dialog
    if (showSubmitConfirmationDialog) {
        AlertDialog(
            onDismissRequest = { showSubmitConfirmationDialog = false },
            title = {
                Text("Submit Mock Exam?", fontWeight = FontWeight.ExtraBold)
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Are you sure you want to finalize your mock examination?")
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = Color(0xFFF8FAFC),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("• Answered: ${state.userAnswers.size} of ${state.questions.size}", fontWeight = FontWeight.Bold, color = Color(0xFF047857))
                            Text("• Marked for Review: ${state.markedForReview.size}", fontWeight = FontWeight.Bold, color = Color(0xFF6D28D9))
                            Text("• Unanswered: ${state.questions.size - state.userAnswers.size}", fontWeight = FontWeight.Bold, color = Color(0xFFDC2626))
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitConfirmationDialog = false
                        onSubmitExam()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                ) {
                    Text("Submit & Score", color = Color.White, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitConfirmationDialog = false }) {
                    Text("Keep Testing")
                }
            }
        )
    }

    // Question Palette Bottom Sheet Dialog
    if (showQuestionPaletteBottomSheet) {
        Dialog(onDismissRequest = { showQuestionPaletteBottomSheet = false }) {
            Surface(
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Question Palette",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold
                        )
                        IconButton(onClick = { showQuestionPaletteBottomSheet = false }) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }

                    // Legend
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFF10B981)))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Answered", fontSize = 10.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFF8B5CF6)))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Review", fontSize = 10.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFFCBD5E1)))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Skipped", fontSize = 10.sp)
                        }
                    }

                    // Palette Grid
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(5),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 280.dp)
                    ) {
                        itemsIndexed(state.questions) { index, _ ->
                            val isCurrent = index == state.currentIndex
                            val isAnswered = state.userAnswers.containsKey(index)
                            val isMarked = state.markedForReview.contains(index)

                            val bgColor = when {
                                isCurrent -> Color(0xFF3B82F6)
                                isMarked -> Color(0xFF8B5CF6)
                                isAnswered -> Color(0xFF10B981)
                                else -> Color(0xFFF1F5F9)
                            }
                            val textColor = if (isCurrent || isMarked || isAnswered) Color.White else Color(0xFF475569)

                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(bgColor)
                                    .clickable {
                                        onJumpToQuestion(index)
                                        showQuestionPaletteBottomSheet = false
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = (index + 1).toString(),
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 13.sp,
                                    color = textColor
                                )
                            }
                        }
                    }

                    Button(
                        onClick = {
                            showQuestionPaletteBottomSheet = false
                            showSubmitConfirmationDialog = true
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                    ) {
                        Text("Submit Exam Now", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }
    }
}

/**
 * Diagnostic Post-Exam Review Report View
 */
@Composable
fun MockExamReportView(
    result: MockExamResult,
    subjectTitle: String,
    standard: Int,
    onRetake: () -> Unit,
    onExit: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Triumphant Result Banner Card
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFF4F46E5),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text("🏆 Mock Exam Report Card", color = Color.White.copy(alpha = 0.85f), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "${result.percentage.toInt()}%",
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color.White.copy(alpha = 0.2f)
                ) {
                    Text(
                        text = "Grade: ${result.grade} • Std $standard $subjectTitle",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("🌟 +${result.xpAwarded} XP", color = Color(0xFFFDE047), fontWeight = FontWeight.Bold)
                    Text("⏱️ ${result.timeTakenSeconds / 60}m ${result.timeTakenSeconds % 60}s", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }

        // 3 Key Metrics Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Correct
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = Color(0xFFDCFCE7),
                border = BorderStroke(1.dp, Color(0xFFBBF7D0)),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Correct", fontSize = 11.sp, color = Color(0xFF15803D), fontWeight = FontWeight.Bold)
                    Text("✅ ${result.correctCount}", fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color(0xFF15803D))
                }
            }

            // Incorrect
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = Color(0xFFFEE2E2),
                border = BorderStroke(1.dp, Color(0xFFFECACA)),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Incorrect", fontSize = 11.sp, color = Color(0xFFB91C1C), fontWeight = FontWeight.Bold)
                    Text("❌ ${result.incorrectCount}", fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color(0xFFB91C1C))
                }
            }

            // Skipped
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = Color(0xFFF1F5F9),
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Skipped", fontSize = 11.sp, color = Color(0xFF475569), fontWeight = FontWeight.Bold)
                    Text("⚪ ${result.unansweredCount}", fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color(0xFF475569))
                }
            }
        }

        // Action Buttons: Retake or Exit
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onExit,
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.weight(1f).height(48.dp)
            ) {
                Text("Back to Home", fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = onRetake,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                modifier = Modifier.weight(1f).height(48.dp)
            ) {
                Text("Retake Test", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }

        // Detailed Question-by-Question Diagnostic Review
        Text(
            text = "Detailed Diagnostic Solutions (${result.reviews.size})",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 8.dp)
        )

        result.reviews.forEachIndexed { idx, review ->
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, if (review.isCorrect) Color(0xFFBBF7D0) else Color(0xFFFECACA)),
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
                            text = "Q${idx + 1}. ${if (review.isCorrect) "✅ Correct" else "❌ Incorrect"}",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp,
                            color = if (review.isCorrect) Color(0xFF15803D) else Color(0xFFDC2626)
                        )
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFFF1F5F9)
                        ) {
                            Text(
                                text = "⏱️ ${review.timeTakenSeconds}s",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF64748B),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Text(
                        text = review.question.questionText,
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (review.isCorrect) Color(0xFFF0FDF4) else Color(0xFFFEF2F2),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "Your choice: ${review.studentAnswer.ifEmpty { "(No answer selected)" }}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (review.isCorrect) Color(0xFF15803D) else Color(0xFFDC2626)
                            )
                            if (!review.isCorrect) {
                                Text(
                                    text = "Correct answer: ${review.question.correctAnswer}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF15803D)
                                )
                            }
                        }
                    }

                    if (review.question.explanation.isNotEmpty()) {
                        Text(
                            text = "💡 Explanation: ${review.question.explanation}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

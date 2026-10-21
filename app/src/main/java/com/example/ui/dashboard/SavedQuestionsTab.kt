package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizViewModel
import com.example.data.QuestionModel
import com.example.data.QuizStaticData

@Composable
fun SavedQuestionsTab(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier
) {
    val bookmarkedQuestions by viewModel.bookmarkedQuestions.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()

    var selectedSubjectFilter by remember { mutableStateOf("all") }
    var showClearConfirmation by remember { mutableStateOf(false) }

    val filteredQuestions = remember(bookmarkedQuestions, selectedSubjectFilter) {
        if (selectedSubjectFilter == "all") {
            bookmarkedQuestions
        } else {
            bookmarkedQuestions.filter { it.subjectId.equals(selectedSubjectFilter, ignoreCase = true) }
        }
    }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("saved_questions_tab_content"),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Tab Header & Actions Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🔖", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Saved Questions",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor,
                        modifier = Modifier.testTag("saved_questions_header_title")
                    )
                }
                Text(
                    text = "${bookmarkedQuestions.size} questions saved for later review",
                    style = MaterialTheme.typography.bodySmall,
                    color = subtitleColor
                )
            }

            if (bookmarkedQuestions.isNotEmpty()) {
                OutlinedButton(
                    onClick = { showClearConfirmation = true },
                    modifier = Modifier.testTag("clear_all_saved_questions_button"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.5f)),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DeleteSweep,
                        contentDescription = "Clear All Bookmarks",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Clear All", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Subject Filter Chips
        val distinctSubjects = remember(bookmarkedQuestions) {
            listOf("all" to "All") + bookmarkedQuestions.map { it.subjectId }.distinct().map { id ->
                val title = when (id.lowercase()) {
                    "math" -> "Mathematics"
                    "science" -> "Science"
                    "english" -> "English"
                    "kannada" -> "Kannada"
                    "hindi" -> "Hindi"
                    "social" -> "Social Studies"
                    "computer" -> "Computer"
                    else -> id.replaceFirstChar { it.uppercase() }
                }
                id to title
            }
        }

        if (distinctSubjects.size > 2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .testTag("saved_questions_filter_chips_row"),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                distinctSubjects.forEach { (key, label) ->
                    val isSelected = selectedSubjectFilter == key
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedSubjectFilter = key },
                        label = {
                            Text(
                                text = if (key == "all") "$label (${bookmarkedQuestions.size})" else label,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.testTag("saved_filter_chip_$key")
                    )
                }
            }
        }

        // Questions List or Empty State
        if (filteredQuestions.isEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
                    .testTag("saved_questions_empty_state_card"),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(
                                if (isDark) Color(0xFF312E81) else Color(0xFFEEF2FF)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🔖", fontSize = 32.sp)
                    }

                    Text(
                        text = "No Saved Questions Yet",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor
                    )

                    Text(
                        text = "While playing quizzes or studying flashcards, tap the 🔖 bookmark icon to save challenging questions here in your Room database for later review.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = subtitleColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Button(
                        onClick = {
                            // Bookmark a sample question from static questions for instant demonstration
                            val sample = QuizStaticData.staticQuestions.firstOrNull() ?: QuestionModel(
                                id = "sample_bookmark_q1",
                                stdId = 6,
                                subjectId = "math",
                                unitId = 1,
                                type = "MCQ",
                                questionText = "What is the place value of 7 in 45,712?",
                                options = listOf("70", "700", "7,000", "7"),
                                correctAnswer = "700",
                                explanation = "In 45,712, 7 is in hundreds place, so 7 x 100 = 700."
                            )
                            viewModel.bookmarkQuestion(sample)
                        },
                        modifier = Modifier.testTag("bookmark_sample_question_button"),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Bookmark a Sample Question", fontWeight = FontWeight.Bold)
                    }
                }
            }
        } else {
            // Render each saved question
            filteredQuestions.forEachIndexed { index, question ->
                SavedQuestionItemCard(
                    question = question,
                    index = index + 1,
                    isDark = isDark,
                    onRemove = { viewModel.removeBookmark(question.id) },
                    modifier = Modifier.testTag("saved_question_card_${question.id}")
                )
            }
        }
    }

    // Confirmation Dialog for Clearing All Saved Questions
    if (showClearConfirmation) {
        AlertDialog(
            onDismissRequest = { showClearConfirmation = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Clear All Saved Questions?", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Text(
                    "Are you sure you want to remove all ${bookmarkedQuestions.size} saved questions from your local database? This action cannot be undone.",
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.clearAllBookmarks()
                        showClearConfirmation = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                    modifier = Modifier.testTag("confirm_clear_all_bookmarks_button")
                ) {
                    Text("Clear All", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { showClearConfirmation = false },
                    modifier = Modifier.testTag("cancel_clear_all_bookmarks_button")
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun SavedQuestionItemCard(
    question: QuestionModel,
    index: Int,
    isDark: Boolean,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isExplanationExpanded by remember { mutableStateOf(false) }
    var selectedPracticeOption by remember { mutableStateOf<String?>(null) }

    val subjectColor = Color(QuizStaticData.SUBJECT_COLORS[question.subjectId.lowercase()] ?: 0xFF4F46E5)
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Top Row: Badges & Remove Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Subject Badge
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = subjectColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = question.subjectId.replaceFirstChar { it.uppercase() },
                            color = subjectColor,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }

                    // Chapter / Unit Info
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9)
                    ) {
                        Text(
                            text = "Std ${question.stdId} • Ch ${question.unitId}",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }

                    // Question Type Chip
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (isDark) Color(0xFF312E81).copy(alpha = 0.4f) else Color(0xFFEEF2FF)
                    ) {
                        Text(
                            text = question.type,
                            color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF4338CA),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                        )
                    }
                }

                // Remove Bookmark Action
                IconButton(
                    onClick = onRemove,
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("remove_saved_question_${question.id}")
                ) {
                    Icon(
                        imageVector = Icons.Default.BookmarkRemove,
                        contentDescription = "Remove Question from Saved",
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Question Text
            Text(
                text = "${index}. ${question.questionText}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.testTag("saved_question_text_${question.id}")
            )

            // Multiple Choice Options List (Interactive Practice)
            if (question.options.isNotEmpty()) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    question.options.forEachIndexed { optIndex, optionText ->
                        val letter = ('A' + optIndex).toString()
                        val isSelected = selectedPracticeOption == optionText
                        val isCorrectOption = optionText.equals(question.correctAnswer, ignoreCase = true)

                        val optionBg = when {
                            isSelected && isCorrectOption -> Color(0xFF10B981).copy(alpha = 0.15f)
                            isSelected && !isCorrectOption -> Color(0xFFEF4444).copy(alpha = 0.15f)
                            else -> if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
                        }

                        val optionBorderColor = when {
                            isSelected && isCorrectOption -> Color(0xFF10B981)
                            isSelected && !isCorrectOption -> Color(0xFFEF4444)
                            else -> if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(optionBg)
                                .border(1.dp, optionBorderColor, RoundedCornerShape(12.dp))
                                .clickable { selectedPracticeOption = optionText }
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(CircleShape)
                                    .background(
                                        when {
                                            isSelected && isCorrectOption -> Color(0xFF10B981)
                                            isSelected && !isCorrectOption -> Color(0xFFEF4444)
                                            else -> if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = letter,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = optionText,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )

                            if (isSelected) {
                                Icon(
                                    imageVector = if (isCorrectOption) Icons.Default.CheckCircle else Icons.Default.Cancel,
                                    contentDescription = null,
                                    tint = if (isCorrectOption) Color(0xFF10B981) else Color(0xFFEF4444),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Solution & Explanation Toggle
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { isExplanationExpanded = !isExplanationExpanded }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (isExplanationExpanded) Icons.Default.VisibilityOff else Icons.Default.Lightbulb,
                        contentDescription = null,
                        tint = if (isExplanationExpanded) MaterialTheme.colorScheme.primary else Color(0xFFD97706),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isExplanationExpanded) "Hide Solution" else "View Correct Answer & Explanation",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isExplanationExpanded) MaterialTheme.colorScheme.primary else Color(0xFFD97706),
                        modifier = Modifier.testTag("toggle_explanation_${question.id}")
                    )
                }

                Icon(
                    imageVector = if (isExplanationExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(20.dp)
                )
            }

            // Expanded Explanation Box
            AnimatedVisibility(
                visible = isExplanationExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(if (isDark) Color(0xFF064E3B).copy(alpha = 0.25f) else Color(0xFFECFDF5))
                        .border(1.dp, if (isDark) Color(0xFF065F46) else Color(0xFFA7F3D0), RoundedCornerShape(14.dp))
                        .padding(12.dp)
                        .testTag("explanation_box_${question.id}"),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("✅", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Correct Answer: ${question.correctAnswer}",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp,
                            color = if (isDark) Color(0xFF6EE7B7) else Color(0xFF065F46)
                        )
                    }

                    if (question.explanation.isNotBlank()) {
                        HorizontalDivider(
                            color = if (isDark) Color(0xFF065F46) else Color(0xFFA7F3D0).copy(alpha = 0.6f)
                        )
                        Row(verticalAlignment = Alignment.Top) {
                            Text("💡", fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = question.explanation,
                                style = MaterialTheme.typography.bodySmall,
                                color = if (isDark) Color(0xFFD1FAE5) else Color(0xFF047857),
                                lineHeight = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

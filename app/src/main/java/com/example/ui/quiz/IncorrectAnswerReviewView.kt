package com.example.ui.quiz

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.QuestionModel
import com.example.data.SubjectType

/**
 * Data model recording a student's answer submission for a question in an active quiz session,
 * capturing the selected response, correctness, timing, and point adjustments.
 */
data class SessionAnswerReview(
    val questionIndex: Int,
    val question: QuestionModel,
    val studentAnswer: String,
    val isCorrect: Boolean,
    val isTimedOut: Boolean = false,
    val isSkipped: Boolean = false,
    val timeTakenSeconds: Int = 0,
    val penaltyDeduction: Int = 0,
    val speedBonus: Int = 0,
    val finalPoints: Int = 0
)

/**
 * Filter mode for reviewing question answers at the end of a quiz.
 */
enum class ReviewFilterMode(val title: String) {
    INCORRECT_ONLY("Mistakes Only"),
    ALL_QUESTIONS("All Questions"),
    CORRECT_ONLY("Correct Only")
}

/**
 * Extracts and links the core academic curriculum concept for a given question.
 */
fun getLinkedConcept(question: QuestionModel): String {
    val text = question.questionText.lowercase()
    val expl = question.explanation.lowercase()

    return when {
        question.subjectId.equals("math", ignoreCase = true) -> {
            when {
                text.contains("fraction") || expl.contains("fraction") || text.contains("/") -> "🔢 Number Operations: Fractions & Decimals"
                text.contains("triangle") || text.contains("angle") || text.contains("area") || text.contains("perimeter") -> "📐 Geometry: Angles & Mensuration"
                text.contains("equation") || text.contains("variable") || text.contains("x +") || text.contains("solve") -> "🧮 Algebra: Linear Expressions & Equations"
                text.contains("prime") || text.contains("factor") || text.contains("lcm") || text.contains("hcf") -> "📊 Number Theory: Factors & Multiples"
                text.contains("percent") || text.contains("ratio") || text.contains("proportion") -> "📈 Applied Math: Ratios & Percentages"
                text.contains("integer") || text.contains("negative") || text.contains("positive") -> "🔢 Number Line: Integers & Properties"
                else -> "🧮 Mathematical Principles & Problem Solving"
            }
        }
        question.subjectId.equals("science", ignoreCase = true) -> {
            when {
                text.contains("plant") || text.contains("photosynthesis") || text.contains("leaf") || text.contains("chlorophyll") -> "🌱 Botany: Photosynthesis & Plant Nutrition"
                text.contains("cell") || text.contains("tissue") || text.contains("organ") -> "🔬 Cytology: Cell Structure & Function"
                text.contains("digestion") || text.contains("heart") || text.contains("blood") || text.contains("respiration") -> "🧬 Human Biology: Life Processes"
                text.contains("acid") || text.contains("base") || text.contains("ph") || text.contains("salt") -> "🧪 Chemistry: Acids, Bases & Indicators"
                text.contains("force") || text.contains("motion") || text.contains("friction") || text.contains("gravity") -> "⚡ Physics: Mechanics, Motion & Force"
                text.contains("light") || text.contains("reflection") || text.contains("lens") || text.contains("mirror") -> "💡 Optics: Light Reflection & Refraction"
                text.contains("sound") || text.contains("wave") || text.contains("frequency") -> "🔊 Physics: Sound Waves & Acoustics"
                text.contains("heat") || text.contains("temperature") || text.contains("thermal") -> "🔥 Thermodynamics: Heat & Temperature"
                text.contains("planet") || text.contains("solar") || text.contains("earth") || text.contains("moon") -> "🌌 Astronomy: Solar System & Celestial Bodies"
                else -> "🔬 Scientific Inquiry & Natural Phenomena"
            }
        }
        question.subjectId.equals("english", ignoreCase = true) -> {
            when {
                text.contains("noun") || text.contains("verb") || text.contains("adjective") || text.contains("adverb") -> "📝 English Grammar: Parts of Speech"
                text.contains("tense") || text.contains("past") || text.contains("present") || text.contains("future") -> "⏱️ Grammar: Tense Conjugation & Timelines"
                text.contains("synonym") || text.contains("antonym") || text.contains("meaning") || text.contains("word") -> "📚 Lexicon: Vocabulary & Synonyms"
                text.contains("preposition") || text.contains("conjunction") -> "🔗 Syntax: Connectors & Relational Words"
                text.contains("voice") || text.contains("passive") || text.contains("active") -> "🗣️ Syntax: Active & Passive Voice"
                text.contains("idiom") || text.contains("phrase") || text.contains("metaphor") -> "🎭 Figurative Language: Idioms & Expressions"
                else -> "📖 English Language & Reading Comprehension"
            }
        }
        question.subjectId.equals("kannada", ignoreCase = true) -> {
            when {
                text.contains("ವರ್ಣಮಾಲೆ") || text.contains("ಸ್ವರ") || text.contains("ವ್ಯಂಜನ") -> "🔤 ಕನ್ನಡ ವರ್ಣಮಾಲೆ ಮತ್ತು ಧ್ವನಿವಿಜ್ಞಾನ"
                text.contains("ಗುಣಿತಾಕ್ಷರ") || text.contains("ಸಂಯುಕ್ತಾಕ್ಷರ") || text.contains("ಒತ್ತಕ್ಷರ") -> "✍️ ಸಂಯುಕ್ತಾಕ್ಷರ & ಗುಣಿತಾಕ್ಷರ ರಚನೆ"
                text.contains("ಗಾದೆ") || text.contains("ನುಡಿಗಟ್ಟು") -> "📜 ಕನ್ನಡ ಗಾದೆಗಳು ಮತ್ತು ನಾಣ್ಣುಡಿಗಳು"
                text.contains("ಸಂಧಿ") || text.contains("ಸಮಾಸ") -> "📖 ಕನ್ನಡ ವ್ಯಾಕರಣ: ಸಂಧಿ & ಸಮಾಸ ನಿಯಮಗಳು"
                text.contains("ಸಾಹಿತ್ಯ") || text.contains("ಕವಿ") || text.contains("ಕೃತಿ") -> "🎭 ಕನ್ನಡ ಸಾಹಿತ್ಯ ಮತ್ತು ಕವಿ ಪರಿಚಯ"
                else -> "📚 ಕನ್ನಡ ಭಾಷೆ, ವ್ಯಾಕರಣ ಮತ್ತು ಸಾಹಿತ್ಯ"
            }
        }
        question.subjectId.equals("hindi", ignoreCase = true) -> {
            when {
                text.contains("स्वर") || text.contains("व्यंजन") || text.contains("वर्णमाला") -> "🔤 हिन्दी वर्णमाला और लिपि ज्ञान"
                text.contains("संज्ञा") || text.contains("सर्वनाम") || text.contains("विशेषण") || text.contains("क्रिया") -> "📝 हिन्दी व्याकरण: पद भेद और वाक्य विचार"
                text.contains("मुहावरा") || text.contains("लोकोक्ति") -> "📜 मुहावरे और लोकोक्तियाँ"
                text.contains("संधि") || text.contains("समास") -> "📖 संधि और शब्द-रचना"
                text.contains("विलोम") || text.contains("पर्यायवाची") -> "📚 शब्द-भंडार: विलोम और पर्यायवाची"
                else -> "📚 हिन्दी भाषा, व्याकरण और साहित्य संकल्पना"
            }
        }
        question.subjectId.equals("social", ignoreCase = true) -> {
            when {
                text.contains("freedom") || text.contains("gandhi") || text.contains("british") || text.contains("revolt") -> "🏛️ History: Indian Freedom Movement"
                text.contains("constitution") || text.contains("right") || text.contains("parliament") || text.contains("democracy") -> "⚖️ Civics: Indian Constitution & Governance"
                text.contains("river") || text.contains("mountain") || text.contains("soil") || text.contains("climate") || text.contains("monsoon") -> "🗺️ Geography: Physical Features & Climate"
                text.contains("empire") || text.contains("dynasty") || text.contains("king") || text.contains("ashoka") || text.contains("mughal") -> "🏺 History: Ancient & Medieval Dynasties"
                else -> "🌍 Social Science: History, Civics & Geography"
            }
        }
        else -> "💡 Academic Concepts & Fundamentals"
    }
}

/**
 * Returns a comprehensive, student-friendly explanation linked to the question concept.
 */
fun getEnrichedExplanation(question: QuestionModel): String {
    if (question.explanation.isNotBlank() && question.explanation.length > 8) {
        return question.explanation.trim()
    }

    return when (question.type) {
        "TF" -> "The statement evaluates to '${question.correctAnswer}'. Carefully verify the key definitions to identify factual vs false assertions."
        "MATCH" -> "Each entity on the left maps to its corresponding partner: ${question.correctAnswer}. Review paired curriculum terms."
        "FILL" -> "The missing term is correctly completed by '${question.correctAnswer}'. Ensure proper context alignment and spelling."
        else -> "The correct answer is '${question.correctAnswer}'. Review the core rule in the textbook chapter to reinforce this topic."
    }
}

/**
 * Returns a practical study tip / memory aid for the student.
 */
fun getConceptStudyTip(question: QuestionModel): String {
    return when (question.subjectId.lowercase()) {
        "math" -> "💡 Practice Tip: Double-check arithmetic steps and write formulas before substituting values."
        "science" -> "💡 Science Tip: Relate this concept to everyday observations or draw a quick diagram to remember life cycles and reactions."
        "english" -> "💡 Language Tip: Read the full sentence aloud to test whether grammatical phrasing and subject-verb agreement sound natural."
        "kannada" -> "💡 ಅಧ್ಯಯನ ಸಲಹೆ: ವ್ಯಾಕರಣ ಸೂತ್ರಗಳನ್ನು ಪ್ರತಿದಿನ ಪುನರಾವರ್ತಿಸಿ ಹಾಗೂ ವಾಕ್ಯಗಳಲ್ಲಿ ಬಳಸಿ ಅಭ್ಯಾಸ ಮಾಡಿ."
        "hindi" -> "💡 अध्ययन युक्ति: व्याकरण नियमों को वाक्यों में प्रयोग करके अभ्यास करें और कठिन शब्दों को लिखकर याद रखें।"
        "social" -> "💡 Social Tip: Create a timeline chart of events or draw mind-maps connecting causes to their historical outcomes."
        else -> "💡 Learning Tip: Bookmark this question to review it in your Mistake Vault before the upcoming tests."
    }
}

/**
 * Interactive 'Incorrect Answer Review' component displayed at the end of each quiz.
 * Allows students to inspect the questions they answered wrong, compare their given answer
 * with the correct answer, study detailed explanations, and review key academic concepts.
 */
@Composable
fun IncorrectAnswerReviewSection(
    reviews: List<SessionAnswerReview>,
    onBookmarkQuestion: (QuestionModel) -> Unit,
    isBookmarked: (String) -> Boolean,
    onRetryMistakes: () -> Unit,
    onOpenMistakeVault: () -> Unit,
    modifier: Modifier = Modifier
) {
    val incorrectReviews = remember(reviews) { reviews.filter { !it.isCorrect } }
    val correctReviews = remember(reviews) { reviews.filter { it.isCorrect } }

    var currentFilter by remember {
        mutableStateOf(
            if (incorrectReviews.isNotEmpty()) ReviewFilterMode.INCORRECT_ONLY else ReviewFilterMode.ALL_QUESTIONS
        )
    }

    val displayedReviews = when (currentFilter) {
        ReviewFilterMode.INCORRECT_ONLY -> incorrectReviews
        ReviewFilterMode.ALL_QUESTIONS -> reviews
        ReviewFilterMode.CORRECT_ONLY -> correctReviews
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("incorrect_answers_review_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(
            1.5.dp,
            if (incorrectReviews.isNotEmpty()) Color(0xFFEF4444).copy(alpha = 0.4f) else Color(0xFF10B981).copy(alpha = 0.4f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header: Title and Concept Badge
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(
                                if (incorrectReviews.isNotEmpty()) Color(0xFFFEE2E2) else Color(0xFFDCFCE7)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(if (incorrectReviews.isNotEmpty()) "🔍" else "🌟", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Incorrect Answer Review",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = if (incorrectReviews.isNotEmpty()) {
                                "${incorrectReviews.size} of ${reviews.size} questions need concept review"
                            } else {
                                "All ${reviews.size} questions answered correctly!"
                            },
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (incorrectReviews.isNotEmpty()) Color(0xFFDC2626) else Color(0xFF15803D)
                        )
                    }
                }

                // Filter Pill Tag placed horizontally on the next line
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF6366F1).copy(alpha = 0.12f)
                ) {
                    Text(
                        text = "📖 Pedagogical Review",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4F46E5),
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            // Overview Status Banner
            if (incorrectReviews.isEmpty()) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFF0FDF4),
                    border = BorderStroke(1.dp, Color(0xFF86EFAC)),
                    modifier = Modifier.fillMaxWidth().testTag("perfect_score_review_banner")
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("🎉", fontSize = 28.sp)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Zero Mistakes Made!",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF166534)
                            )
                            Text(
                                text = "You demonstrated complete mastery over every question in this quiz. Review the core concepts and explanations below to consolidate your learning.",
                                fontSize = 11.sp,
                                color = Color(0xFF15803D),
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            } else {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFFEF2F2),
                    border = BorderStroke(1.dp, Color(0xFFFECACA)),
                    modifier = Modifier.fillMaxWidth().testTag("mistakes_found_review_banner")
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("💡", fontSize = 28.sp)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Analyze Your Mistakes to Improve!",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF991B1B)
                            )
                            Text(
                                text = "Understanding why an answer was wrong is the fastest way to learn. Inspect the detailed explanations, note the key concepts, and retry them below.",
                                fontSize = 11.sp,
                                color = Color(0xFFB91C1C),
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }

            // Segmented Filter Tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("review_filter_row"),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Tab 1: Mistakes Only
                FilterChip(
                    selected = currentFilter == ReviewFilterMode.INCORRECT_ONLY,
                    onClick = { currentFilter = ReviewFilterMode.INCORRECT_ONLY },
                    label = {
                        Text(
                            text = "❌ Mistakes (${incorrectReviews.size})",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("tab_filter_incorrect"),
                    shape = RoundedCornerShape(12.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFFEE2E2),
                        selectedLabelColor = Color(0xFF991B1B)
                    )
                )

                // Tab 2: All Questions
                FilterChip(
                    selected = currentFilter == ReviewFilterMode.ALL_QUESTIONS,
                    onClick = { currentFilter = ReviewFilterMode.ALL_QUESTIONS },
                    label = {
                        Text(
                            text = "📋 All (${reviews.size})",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("tab_filter_all"),
                    shape = RoundedCornerShape(12.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFEEF2FF),
                        selectedLabelColor = Color(0xFF4338CA)
                    )
                )

                // Tab 3: Correct Only
                FilterChip(
                    selected = currentFilter == ReviewFilterMode.CORRECT_ONLY,
                    onClick = { currentFilter = ReviewFilterMode.CORRECT_ONLY },
                    label = {
                        Text(
                            text = "✅ Correct (${correctReviews.size})",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("tab_filter_correct"),
                    shape = RoundedCornerShape(12.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFDCFCE7),
                        selectedLabelColor = Color(0xFF166534)
                    )
                )
            }

            // Cards for each question in the current filter
            if (displayedReviews.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (currentFilter == ReviewFilterMode.INCORRECT_ONLY) {
                            "✨ No incorrect questions in this quiz session! Great job!"
                        } else {
                            "No questions available in this filter."
                        },
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    displayedReviews.forEach { review ->
                        QuestionReviewDetailCard(
                            review = review,
                            isBookmarked = isBookmarked(review.question.id),
                            onToggleBookmark = { onBookmarkQuestion(review.question) }
                        )
                    }
                }
            }

            // Action Buttons at the bottom
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (incorrectReviews.isNotEmpty()) {
                    Button(
                        onClick = onRetryMistakes,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("retry_mistakes_practice_button")
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Practice ${incorrectReviews.size} Mistakes",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                OutlinedButton(
                    onClick = onOpenMistakeVault,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("open_mistakes_vault_button"),
                    border = BorderStroke(1.5.dp, Color(0xFF4F46E5))
                ) {
                    Icon(
                        Icons.Default.BookmarkBorder,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFF4F46E5)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Mistakes Vault",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4F46E5)
                    )
                }
            }
        }
    }
}

/**
 * Card displaying an individual question's answer comparison, user response,
 * correct answer, linked academic concept, and detailed pedagogical explanation.
 */
@Composable
fun QuestionReviewDetailCard(
    review: SessionAnswerReview,
    isBookmarked: Boolean,
    onToggleBookmark: () -> Unit,
    modifier: Modifier = Modifier
) {
    val q = review.question
    val concept = remember(q) { getLinkedConcept(q) }
    val explanation = remember(q) { getEnrichedExplanation(q) }
    val tip = remember(q) { getConceptStudyTip(q) }

    val isWrong = !review.isCorrect
    val containerColor = if (isWrong) Color(0xFFFEF2F2).copy(alpha = 0.5f) else Color(0xFFF0FDF4).copy(alpha = 0.5f)
    val borderColor = if (isWrong) Color(0xFFFCA5A5) else Color(0xFF86EFAC)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("review_question_card_${review.questionIndex}"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row: Question Index, Status Pill, Time, and Bookmark Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    // Question index badge
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (isWrong) Color(0xFFDC2626) else Color(0xFF16A34A)
                    ) {
                        Text(
                            text = "Q${review.questionIndex + 1}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }

                    // Result Pill
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = when {
                            review.isCorrect -> Color(0xFFDCFCE7)
                            review.isTimedOut -> Color(0xFFFEF3C7)
                            review.isSkipped -> Color(0xFFF1F5F9)
                            else -> Color(0xFFFEE2E2)
                        }
                    ) {
                        Text(
                            text = when {
                                review.isCorrect -> "✅ Correct (+${review.finalPoints} pts)"
                                review.isTimedOut -> "⏳ Timed Out"
                                review.isSkipped -> "⏭️ Skipped"
                                else -> "❌ Incorrect"
                            },
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = when {
                                review.isCorrect -> Color(0xFF166534)
                                review.isTimedOut -> Color(0xFFB45309)
                                review.isSkipped -> Color(0xFF475569)
                                else -> Color(0xFF991B1B)
                            },
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }

                    // Time spent
                    Text(
                        text = "⏱️ ${review.timeTakenSeconds}s",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF64748B)
                    )
                }

                // Bookmark icon button
                IconButton(
                    onClick = onToggleBookmark,
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("bookmark_button_${review.questionIndex}")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = if (isBookmarked) "Bookmarked" else "Bookmark",
                        tint = if (isBookmarked) Color(0xFFD97706) else Color(0xFF94A3B8),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Question Text
            Text(
                text = q.questionText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 20.sp,
                modifier = Modifier.testTag("question_text_${review.questionIndex}")
            )

            // Answer Comparison: Student Answer vs Correct Answer
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                // Student's Response
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isWrong) Color(0xFFFEE2E2) else Color(0xFFDCFCE7),
                    border = BorderStroke(1.dp, if (isWrong) Color(0xFFFCA5A5) else Color(0xFF86EFAC)),
                    modifier = Modifier.fillMaxWidth().testTag("student_answer_box_${review.questionIndex}")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isWrong) "❌ Your Answer: " else "✅ Your Answer: ",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isWrong) Color(0xFF991B1B) else Color(0xFF166534)
                        )
                        Text(
                            text = when {
                                review.isTimedOut -> "No answer (Time expired)"
                                review.isSkipped -> "Question skipped"
                                review.studentAnswer.isNotBlank() -> review.studentAnswer
                                else -> "(No answer selected)"
                            },
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isWrong) Color(0xFFB91C1C) else Color(0xFF15803D)
                        )
                    }
                }

                // Correct Answer (always shown for clarity)
                if (isWrong) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFFECFDF5),
                        border = BorderStroke(1.dp, Color(0xFF6EE7B7)),
                        modifier = Modifier.fillMaxWidth().testTag("correct_answer_box_${review.questionIndex}")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "🎯 Correct Answer: ",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF065F46)
                            )
                            Text(
                                text = q.correctAnswer,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF047857)
                            )
                        }
                    }
                }
            }

            // Options breakdown if multiple choices exist
            if (q.options.isNotEmpty() && q.type != "MATCH") {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "ANSWER CHOICES:",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF64748B)
                    )
                    q.options.forEach { opt ->
                        val isThisCorrect = opt.trim().equals(q.correctAnswer.trim(), ignoreCase = true)
                        val isThisStudentWrong = isWrong && opt.trim().equals(review.studentAnswer.trim(), ignoreCase = true)

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = when {
                                isThisCorrect -> Color(0xFFDCFCE7)
                                isThisStudentWrong -> Color(0xFFFEE2E2)
                                else -> MaterialTheme.colorScheme.surface
                            },
                            border = BorderStroke(
                                1.dp,
                                when {
                                    isThisCorrect -> Color(0xFF16A34A)
                                    isThisStudentWrong -> Color(0xFFDC2626)
                                    else -> Color(0xFFE2E8F0)
                                }
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = when {
                                        isThisCorrect -> "✅ "
                                        isThisStudentWrong -> "❌ "
                                        else -> "⚪ "
                                    },
                                    fontSize = 11.sp
                                )
                                Text(
                                    text = opt,
                                    fontSize = 11.sp,
                                    fontWeight = if (isThisCorrect || isThisStudentWrong) FontWeight.Bold else FontWeight.Normal,
                                    color = when {
                                        isThisCorrect -> Color(0xFF166534)
                                        isThisStudentWrong -> Color(0xFF991B1B)
                                        else -> MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            }
                        }
                    }
                }
            }

            // Concept & Detailed Explanation Box (Core Educational Value)
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = Color(0xFFEEF2FF),
                border = BorderStroke(1.dp, Color(0xFFC7D2FE)),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("concept_explanation_box_${review.questionIndex}")
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Linked Concept Pill & Concept Breakdown Tag
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF4F46E5)
                        ) {
                            Text(
                                text = concept,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                    .testTag("linked_concept_text_${review.questionIndex}")
                            )
                        }

                        Text(
                            text = "💡 Concept Breakdown",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4F46E5),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }

                    // Detailed Explanation
                    Text(
                        text = explanation,
                        fontSize = 12.sp,
                        color = Color(0xFF1E1B4B),
                        lineHeight = 17.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.testTag("detailed_explanation_text_${review.questionIndex}")
                    )

                    // Helpful Study Tip
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color.White.copy(alpha = 0.7f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = tip,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF4338CA),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            lineHeight = 14.sp
                        )
                    }
                }
            }
        }
    }
}

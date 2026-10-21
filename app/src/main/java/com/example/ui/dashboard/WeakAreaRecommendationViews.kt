package com.example.ui.dashboard

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
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.*

enum class RecommendationFilterType(val label: String) {
    ALL("All Suggestions"),
    WEAK_AREAS("🎯 Weak Areas"),
    NEXT_CHAPTERS("🚀 Next Topics"),
    MASTERY("⭐ Mastery")
}

/**
 * Intelligent Recommendation Hub in the Student Dashboard.
 * Identifies past weak areas from the local Room database (historical_scores & unit_progress)
 * and dynamically recommends targeted quizzes to boost accuracy and conceptual mastery.
 */
@Composable
fun WeakAreaRecommendationHub(
    recommendations: List<QuizRecommendation>,
    weakAreaTopics: List<WeakAreaTopic>,
    isDark: Boolean,
    onStartQuiz: (stdId: Int, subjectId: String, unitId: Int, unitName: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedFilter by remember { mutableStateOf(RecommendationFilterType.ALL) }
    var highlightedUnitId by remember { mutableStateOf<Int?>(null) }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBg = if (isDark) Color(0xFF1E293B) else Color.White
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    val weakRecommendations = remember(recommendations) {
        recommendations.filter { it.reason.isWeakArea }
    }

    val filteredList = remember(recommendations, selectedFilter, highlightedUnitId) {
        val base = when (selectedFilter) {
            RecommendationFilterType.ALL -> recommendations
            RecommendationFilterType.WEAK_AREAS -> recommendations.filter { it.reason.isWeakArea }
            RecommendationFilterType.NEXT_CHAPTERS -> recommendations.filter { it.reason == RecommendationReason.NEXT_IN_SEQUENCE || it.reason == RecommendationReason.UNEXPLORED_TOPIC }
            RecommendationFilterType.MASTERY -> recommendations.filter { it.reason == RecommendationReason.STRONG_SUBJECT || it.reason == RecommendationReason.STREAK_BUILDER }
        }
        if (highlightedUnitId != null) {
            base.filter { it.unitId == highlightedUnitId }
        } else base
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("weak_area_recommendation_hub"),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // --- 1. SECTION HEADER ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF6366F1).copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🎯", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Topic Recommendations",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor
                    )
                    Text(
                        text = "Targeted from Room database weak areas",
                        fontSize = 11.sp,
                        color = subtitleColor
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (weakAreaTopics.isNotEmpty()) Color(0xFFEF4444).copy(alpha = 0.12f) else Color(0xFF10B981).copy(alpha = 0.12f),
                border = BorderStroke(1.dp, if (weakAreaTopics.isNotEmpty()) Color(0xFFEF4444).copy(alpha = 0.4f) else Color(0xFF10B981).copy(alpha = 0.4f))
            ) {
                Text(
                    text = if (weakAreaTopics.isNotEmpty()) "${weakAreaTopics.size} Weak Areas" else "Mastery Optimal",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (weakAreaTopics.isNotEmpty()) Color(0xFFDC2626) else Color(0xFF059669),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        // --- 2. WEAK AREAS HIGHLIGHT BANNER (If Room stats identified struggles) ---
        if (weakAreaTopics.isNotEmpty()) {
            Surface(
                shape = RoundedCornerShape(18.dp),
                color = if (isDark) Color(0xFF3B1219) else Color(0xFFFEF2F2),
                border = BorderStroke(1.dp, if (isDark) Color(0xFF7F1D1D) else Color(0xFFFECACA)),
                modifier = Modifier.fillMaxWidth().testTag("weak_areas_detected_banner")
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
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("📉", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Weak Areas Detected in Room Stats",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 12.sp,
                                color = if (isDark) Color(0xFFFCA5A5) else Color(0xFF991B1B)
                            )
                        }

                        if (highlightedUnitId != null) {
                            Text(
                                text = "Show All",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFEF4444),
                                modifier = Modifier.clickable { highlightedUnitId = null }
                            )
                        }
                    }

                    Text(
                        text = "Historical quiz logs in Room indicate accuracy below 70% in the following topics. Tap any topic to focus your practice:",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Horizontal scrollable chips of detected weak topics
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        weakAreaTopics.forEach { topic ->
                            val isSelected = highlightedUnitId == topic.unitId
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isSelected) Color(topic.urgencyLevel.colorHex) else Color(topic.urgencyLevel.colorHex).copy(alpha = 0.12f),
                                border = BorderStroke(1.dp, Color(topic.urgencyLevel.colorHex).copy(alpha = 0.6f)),
                                modifier = Modifier
                                    .clickable {
                                        highlightedUnitId = if (isSelected) null else topic.unitId
                                        selectedFilter = RecommendationFilterType.WEAK_AREAS
                                    }
                                    .testTag("weak_topic_chip_${topic.unitId}")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(topic.urgencyLevel.emoji, fontSize = 12.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "${topic.subjectTitle}: Unit ${topic.unitId} (${topic.averageAccuracy}%)",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSelected) Color.White else Color(topic.urgencyLevel.colorHex)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // --- 3. FILTER CHIPS ROW ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RecommendationFilterType.entries.forEach { filter ->
                val isSelected = selectedFilter == filter && highlightedUnitId == null
                val label = when (filter) {
                    RecommendationFilterType.ALL -> "All (${recommendations.size})"
                    RecommendationFilterType.WEAK_AREAS -> "🎯 Weak Areas (${weakRecommendations.size})"
                    RecommendationFilterType.NEXT_CHAPTERS -> "🚀 Next Topics"
                    RecommendationFilterType.MASTERY -> "⭐ Mastery"
                }

                FilterChip(
                    selected = isSelected,
                    onClick = {
                        selectedFilter = filter
                        highlightedUnitId = null
                    },
                    label = {
                        Text(
                            text = label,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Normal
                        )
                    },
                    modifier = Modifier.testTag("rec_filter_${filter.name}")
                )
            }
        }

        // --- 4. RECOMMENDATION CARDS LIST ---
        if (filteredList.isEmpty()) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = cardBg,
                border = cardBorder,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("🎉", fontSize = 28.sp)
                    Text(
                        text = if (selectedFilter == RecommendationFilterType.WEAK_AREAS)
                            "No Critical Weak Areas Detected!"
                        else "No Recommendations in this Category",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = titleColor
                    )
                    Text(
                        text = if (selectedFilter == RecommendationFilterType.WEAK_AREAS)
                            "Great job! All your quiz scores in the Room database are above 70%. Take more quizzes or explore next chapters."
                        else "Try selecting another filter above to view personalized suggestions.",
                        fontSize = 11.sp,
                        color = subtitleColor,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                filteredList.take(6).forEach { rec ->
                    RecommendationItemCard(
                        recommendation = rec,
                        isDark = isDark,
                        onStartQuiz = onStartQuiz
                    )
                }
            }
        }
    }
}

/**
 * Individual Card representing a tailored quiz recommendation.
 * Highlights the pedagogical rationale and room stats insights.
 */
@Composable
fun RecommendationItemCard(
    recommendation: QuizRecommendation,
    isDark: Boolean,
    onStartQuiz: (stdId: Int, subjectId: String, unitId: Int, unitName: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val recColor = Color(recommendation.reason.tagColorHex)
    val subjColor = Color(recommendation.subjectColorHex)
    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBg = if (isDark) Color(0xFF1E293B) else Color.White

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = cardBg,
        border = BorderStroke(
            1.2.dp,
            if (recommendation.reason.isWeakArea) recColor.copy(alpha = 0.6f)
            else if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
        ),
        modifier = modifier
            .fillMaxWidth()
            .testTag("dashboard_rec_${recommendation.id}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header: Reason Badge + XP Reward
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = recColor.copy(alpha = 0.14f),
                    border = BorderStroke(1.dp, recColor.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(recommendation.reason.icon, fontSize = 11.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = recommendation.badgeLabel,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = recColor
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF10B981).copy(alpha = 0.12f)
                ) {
                    Text(
                        text = "+${recommendation.xpReward} XP",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF059669),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            // Subject Pill + Unit Title
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = subjColor.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = recommendation.subjectTitle.uppercase(),
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = subjColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Unit ${recommendation.unitId}: ${recommendation.unitName}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Room Stats Diagnostic Snippet (if available)
            if (recommendation.roomStatsDiagnostic.isNotBlank()) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC),
                    border = BorderStroke(0.8.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("📊 ", fontSize = 10.sp)
                        Text(
                            text = "Room Stats: ${recommendation.roomStatsDiagnostic}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = subtitleColor
                        )
                    }
                }
            }

            // Pedagogical Rationale
            Text(
                text = recommendation.rationale,
                fontSize = 11.sp,
                color = subtitleColor,
                lineHeight = 15.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Bottom Action Bar: Questions count, Difficulty & Action Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "📝 ${recommendation.totalQuestions} Questions",
                        fontSize = 10.sp,
                        color = subtitleColor
                    )
                    Text("•", fontSize = 10.sp, color = subtitleColor)
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = when (recommendation.difficulty) {
                            "Easy" -> Color(0xFF10B981).copy(alpha = 0.15f)
                            "Medium" -> Color(0xFFF59E0B).copy(alpha = 0.15f)
                            else -> Color(0xFFEF4444).copy(alpha = 0.15f)
                        }
                    ) {
                        Text(
                            text = recommendation.difficulty,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = when (recommendation.difficulty) {
                                "Easy" -> Color(0xFF059669)
                                "Medium" -> Color(0xFFD97706)
                                else -> Color(0xFFDC2626)
                            },
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }

                Button(
                    onClick = {
                        onStartQuiz(
                            recommendation.stdId,
                            recommendation.subjectId,
                            recommendation.unitId,
                            recommendation.unitName
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = subjColor),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    modifier = Modifier
                        .height(34.dp)
                        .testTag("start_quiz_rec_${recommendation.unitId}")
                ) {
                    Text(
                        text = if (recommendation.reason.isWeakArea) "Revise Now" else "Start Quiz",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

package com.example.ui.home

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.*

@Composable
fun RecommendedQuizzesSection(
    recommendations: List<QuizRecommendation>,
    categorySummaries: List<CategoryPerformanceSummary>,
    isDark: Boolean,
    onStartQuiz: (stdId: Int, subjectId: String, unitId: Int, unitName: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showAllDialog by remember { mutableStateOf(false) }
    var selectedRecommendationDetail by remember { mutableStateOf<QuizRecommendation?>(null) }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    if (recommendations.isEmpty()) return

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("recommended_quizzes_section"),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // --- 1. SECTION HEADER ---
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
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF6366F1).copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("💡", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f, fill = false)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Recommended For You",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f, fill = false)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF6366F1).copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "Smart",
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6366F1)
                            )
                        }
                    }
                    Text(
                        text = "Based on your quiz performance",
                        fontSize = 11.sp,
                        color = subtitleColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            TextButton(
                onClick = { showAllDialog = true },
                modifier = Modifier.testTag("explore_all_recommendations_button")
            ) {
                Text(
                    text = "See All (${recommendations.size}) →",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // --- 2. CATEGORY MASTERY QUICK STRIP ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            categorySummaries.forEach { cat ->
                val statusColor = Color(cat.status.colorHex)
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC),
                    border = BorderStroke(1.dp, statusColor.copy(alpha = 0.35f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(cat.status.emoji, fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = cat.subjectTitle.split(" ").first(),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = titleColor
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (cat.attemptedUnits > 0) "${cat.averageScore}%" else "New",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = statusColor
                        )
                    }
                }
            }
        }

        // --- 3. HORIZONTAL CAROUSEL OF RECOMMENDATION CARDS ---
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("recommendations_carousel")
        ) {
            items(recommendations.take(6)) { item ->
                RecommendationCard(
                    recommendation = item,
                    isDark = isDark,
                    cardBorder = cardBorder,
                    titleColor = titleColor,
                    subtitleColor = subtitleColor,
                    onPlay = {
                        onStartQuiz(item.stdId, item.subjectId, item.unitId, item.unitName)
                    },
                    onInfoClick = {
                        selectedRecommendationDetail = item
                    }
                )
            }
        }
    }

    // Modal Dialog showing complete list and deep category analytics
    if (showAllDialog) {
        AllRecommendationsDialog(
            recommendations = recommendations,
            categorySummaries = categorySummaries,
            isDark = isDark,
            onDismiss = { showAllDialog = false },
            onStartQuiz = { stdId, subjectId, unitId, unitName ->
                showAllDialog = false
                onStartQuiz(stdId, subjectId, unitId, unitName)
            }
        )
    }

    // Detailed explanation dialog for a single recommendation
    selectedRecommendationDetail?.let { item ->
        RecommendationDetailDialog(
            item = item,
            isDark = isDark,
            onDismiss = { selectedRecommendationDetail = null },
            onPlay = {
                selectedRecommendationDetail = null
                onStartQuiz(item.stdId, item.subjectId, item.unitId, item.unitName)
            }
        )
    }
}

/**
 * Individual Card in the Horizontal Carousel
 */
@Composable
fun RecommendationCard(
    recommendation: QuizRecommendation,
    isDark: Boolean,
    cardBorder: BorderStroke,
    titleColor: Color,
    subtitleColor: Color,
    onPlay: () -> Unit,
    onInfoClick: () -> Unit
) {
    val subjectColor = Color(recommendation.subjectColorHex)
    val reasonColor = Color(recommendation.reason.tagColorHex)

    Card(
        modifier = Modifier
            .width(260.dp)
            .testTag("recommendation_card_${recommendation.id}"),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.5.dp, reasonColor.copy(alpha = 0.45f))
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Reason Pill & Info Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = reasonColor.copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, reasonColor.copy(alpha = 0.35f))
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
                            color = reasonColor
                        )
                    }
                }

                IconButton(
                    onClick = onInfoClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Reason Details",
                        tint = subtitleColor,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Subject & Unit Name
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = recommendation.subjectTitle,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = subjectColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Unit ${recommendation.unitId}: ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor,
                        maxLines = 1,
                        softWrap = false
                    )
                    Text(
                        text = recommendation.unitName,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = titleColor,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                }
            }

            // Rationale snippet
            Text(
                text = recommendation.rationale,
                fontSize = 11.sp,
                color = subtitleColor,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 15.sp
            )

            // Info Chips & Play Button Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9)
                    ) {
                        Text(
                            text = "${recommendation.totalQuestions} Qs",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = subtitleColor,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFFF59E0B).copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "+${recommendation.xpReward} XP",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFD97706),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                }

                Button(
                    onClick = onPlay,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = subjectColor),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    modifier = Modifier.height(32.dp).testTag("play_recommendation_btn_${recommendation.id}")
                ) {
                    Text(
                        text = "Play",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

/**
 * Detailed Dialog for inspecting all recommended quizzes categorized by reason.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllRecommendationsDialog(
    recommendations: List<QuizRecommendation>,
    categorySummaries: List<CategoryPerformanceSummary>,
    isDark: Boolean,
    onDismiss: () -> Unit,
    onStartQuiz: (stdId: Int, subjectId: String, unitId: Int, unitName: String) -> Unit
) {
    var selectedFilterReason by remember { mutableStateOf<RecommendationReason?>(null) }

    val filteredList = remember(selectedFilterReason, recommendations) {
        if (selectedFilterReason == null) recommendations
        else recommendations.filter { it.reason == selectedFilterReason }
    }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(26.dp),
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .testTag("all_recommendations_dialog")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Top Header Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🎯", fontSize = 22.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Personalized Recommendations",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${recommendations.size} suggested quizzes for your current grade",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                // Filter Reason Chips
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    FilterChip(
                        selected = selectedFilterReason == null,
                        onClick = { selectedFilterReason = null },
                        label = { Text("All (${recommendations.size})", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                        modifier = Modifier.testTag("filter_all_recs")
                    )

                    RecommendationReason.entries.forEach { reason ->
                        val count = recommendations.count { it.reason == reason }
                        if (count > 0) {
                            FilterChip(
                                selected = selectedFilterReason == reason,
                                onClick = { selectedFilterReason = reason },
                                label = {
                                    Text(
                                        "${reason.icon} ${reason.title} ($count)",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                },
                                modifier = Modifier.testTag("filter_rec_${reason.name.lowercase()}")
                            )
                        }
                    }
                }

                // Scrollable List of Recommended Items
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (filteredList.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No recommendations match this filter.",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 12.sp
                            )
                        }
                    } else {
                        filteredList.forEach { rec ->
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC),
                                border = BorderStroke(1.dp, Color(rec.reason.tagColorHex).copy(alpha = 0.35f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(rec.reason.icon, fontSize = 12.sp)
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = rec.badgeLabel,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Color(rec.reason.tagColorHex)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(
                                            text = rec.unitName,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        Text(
                                            text = "${rec.subjectTitle} • ${rec.totalQuestions} Questions • ${rec.difficulty}",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = rec.rationale,
                                            fontSize = 10.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                                            lineHeight = 13.sp
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(10.dp))

                                    Button(
                                        onClick = {
                                            onStartQuiz(rec.stdId, rec.subjectId, rec.unitId, rec.unitName)
                                        },
                                        shape = RoundedCornerShape(12.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(rec.subjectColorHex)),
                                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                                    ) {
                                        Text("Play", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Detailed Explanation Modal Dialog for why a specific quiz was chosen
 */
@Composable
fun RecommendationDetailDialog(
    item: QuizRecommendation,
    isDark: Boolean,
    onDismiss: () -> Unit,
    onPlay: () -> Unit
) {
    val subjectColor = Color(item.subjectColorHex)
    val reasonColor = Color(item.reason.tagColorHex)

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(26.dp),
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.5.dp, reasonColor.copy(alpha = 0.5f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .testTag("recommendation_detail_dialog")
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Header Icon
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(reasonColor.copy(alpha = 0.15f))
                        .border(1.5.dp, reasonColor.copy(alpha = 0.4f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(item.reason.icon, fontSize = 28.sp)
                }

                // Title
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = reasonColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = item.badgeLabel,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = reasonColor
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = item.unitName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "${item.subjectTitle} • Standard ${item.stdId}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = subjectColor
                    )
                }

                // Why Recommended Card
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Psychology,
                                contentDescription = "AI Heuristic",
                                tint = reasonColor,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Why this quiz?",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text(
                            text = item.rationale,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 17.sp
                        )
                    }
                }

                // Metadata Stats
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Questions", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text("${item.totalQuestions}", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Difficulty", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(item.difficulty, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = subjectColor)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Reward", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text("+${item.xpReward} XP", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFD97706))
                    }
                }

                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Later")
                    }

                    Button(
                        onClick = onPlay,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = subjectColor)
                    ) {
                        Text("Play Now", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
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
import com.example.data.QuizStaticData

@Composable
fun StudentAggregatedStatsView(
    uiState: StudentDashboardUiState,
    isDark: Boolean,
    onTimeRangeSelected: (DashboardTimeRange) -> Unit,
    onStandardSelected: (Int?) -> Unit,
    onSubjectSelected: (String?) -> Unit,
    modifier: Modifier = Modifier
) {
    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- 1. FILTER CONTROLS (TIME RANGE & STANDARD) ---
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "📊 Performance Intelligence",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor
                )
                Text(
                    text = "Aggregated from Room DB",
                    style = MaterialTheme.typography.labelSmall,
                    color = subtitleColor
                )
            }

            // Time Range Filter Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                DashboardTimeRange.entries.forEach { range ->
                    val isSelected = uiState.selectedTimeRange == range
                    FilterChip(
                        selected = isSelected,
                        onClick = { onTimeRangeSelected(range) },
                        label = {
                            Text(
                                text = range.displayName,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        leadingIcon = if (isSelected) {
                            {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        } else null,
                        modifier = Modifier.testTag("filter_range_${range.name}")
                    )
                }

                // Standard Filters
                val standards = listOf(null, 6, 7, 8, 9, 10, 11, 12)
                standards.forEach { std ->
                    val isSelected = uiState.selectedStandardFilter == std
                    FilterChip(
                        selected = isSelected,
                        onClick = { onStandardSelected(std) },
                        label = {
                            val labelText = when (std) {
                                null -> "All Standards"
                                11 -> "Morarji"
                                12 -> "NMMS"
                                else -> "Std $std"
                            }
                            Text(
                                text = labelText,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        modifier = Modifier.testTag("filter_std_${std ?: "all"}")
                    )
                }
            }
        }

        // --- 2. HEADLINE METRICS GRID (RESPONSIVE GRID) ---
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            if (maxWidth < 360.dp) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SummaryKpiCard(
                            modifier = Modifier.weight(1f),
                            title = "Avg Accuracy",
                            value = "${uiState.overallAverageAccuracy.toInt()}%",
                            subtitle = "${uiState.totalCorrectAnswers}/${uiState.totalQuestionsAnswered} correct",
                            accentColor = if (uiState.overallAverageAccuracy >= 80f) Color(0xFF10B981)
                            else if (uiState.overallAverageAccuracy >= 50f) Color(0xFFF59E0B) else Color(0xFFEF4444),
                            icon = Icons.AutoMirrored.Filled.TrendingUp,
                            isDark = isDark,
                            cardBorder = cardBorder,
                            tag = "kpi_accuracy"
                        )
                        SummaryKpiCard(
                            modifier = Modifier.weight(1f),
                            title = "Pass Rate",
                            value = "${uiState.passRatePercentage.toInt()}%",
                            subtitle = "${uiState.passedQuizzesCount}/${uiState.totalQuizzesAttempted} passed",
                            accentColor = Color(0xFF6366F1),
                            icon = Icons.Default.CheckCircle,
                            isDark = isDark,
                            cardBorder = cardBorder,
                            tag = "kpi_pass_rate"
                        )
                    }
                    SummaryKpiCard(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Attempts",
                        value = "${uiState.totalQuizzesAttempted}",
                        subtitle = "${uiState.perfectScoresCount} perfect 💯",
                        accentColor = Color(0xFFEC4899),
                        icon = Icons.Default.School,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        tag = "kpi_attempts"
                    )
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    SummaryKpiCard(
                        modifier = Modifier.weight(1f),
                        title = "Avg Accuracy",
                        value = "${uiState.overallAverageAccuracy.toInt()}%",
                        subtitle = "${uiState.totalCorrectAnswers}/${uiState.totalQuestionsAnswered} correct",
                        accentColor = if (uiState.overallAverageAccuracy >= 80f) Color(0xFF10B981)
                        else if (uiState.overallAverageAccuracy >= 50f) Color(0xFFF59E0B) else Color(0xFFEF4444),
                        icon = Icons.AutoMirrored.Filled.TrendingUp,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        tag = "kpi_accuracy"
                    )
                    SummaryKpiCard(
                        modifier = Modifier.weight(1f),
                        title = "Pass Rate",
                        value = "${uiState.passRatePercentage.toInt()}%",
                        subtitle = "${uiState.passedQuizzesCount}/${uiState.totalQuizzesAttempted} passed",
                        accentColor = Color(0xFF6366F1),
                        icon = Icons.Default.CheckCircle,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        tag = "kpi_pass_rate"
                    )
                    SummaryKpiCard(
                        modifier = Modifier.weight(1f),
                        title = "Attempts",
                        value = "${uiState.totalQuizzesAttempted}",
                        subtitle = "${uiState.perfectScoresCount} perfect 💯",
                        accentColor = Color(0xFFEC4899),
                        icon = Icons.Default.School,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        tag = "kpi_attempts"
                    )
                }
            }
        }

        // --- 3. REWARD & ENGAGEMENT METRICS (2x2 Compact Horizontal Grid) ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("rewards_stat_card"),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E1B4B).copy(alpha = 0.6f) else Color(0xFFEEF2FF)
            ),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF3730A3) else Color(0xFFC7D2FE))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MetricChip(
                        modifier = Modifier.weight(1f),
                        emoji = "⚡",
                        label = "Total XP",
                        value = "+${uiState.totalXpEarned}",
                        color = Color(0xFF8B5CF6),
                        isDark = isDark
                    )
                    MetricChip(
                        modifier = Modifier.weight(1f),
                        emoji = "🪙",
                        label = "Coins",
                        value = "+${uiState.totalCoinsEarned}",
                        color = Color(0xFFF59E0B),
                        isDark = isDark
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MetricChip(
                        modifier = Modifier.weight(1f),
                        emoji = "⭐",
                        label = "Stars Won",
                        value = "+${uiState.totalStarsEarned}",
                        color = Color(0xFF10B981),
                        isDark = isDark
                    )
                    val minutesSpent = (uiState.totalTimeSpentSeconds / 60)
                    val timeStr = if (minutesSpent > 60) "${minutesSpent / 60}h ${minutesSpent % 60}m" else "${minutesSpent}m"
                    MetricChip(
                        modifier = Modifier.weight(1f),
                        emoji = "⏱️",
                        label = "Time Spent",
                        value = timeStr,
                        color = Color(0xFF3B82F6),
                        isDark = isDark
                    )
                }
            }
        }

        // --- 4. STRENGTHS & FOCUS RECOMMENDATIONS ---
        if (uiState.strongestSubject != null || uiState.subjectNeedingFocus != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                uiState.strongestSubject?.let { strong ->
                    SubjectInsightPill(
                        modifier = Modifier.weight(1f),
                        type = "Strongest Area 🌟",
                        subjectName = strong.subjectName,
                        accuracy = strong.averageAccuracy,
                        badgeColor = Color(0xFF10B981),
                        bgColor = if (isDark) Color(0xFF064E3B) else Color(0xFFD1FAE5),
                        isDark = isDark
                    )
                }

                uiState.subjectNeedingFocus?.let { focus ->
                    SubjectInsightPill(
                        modifier = Modifier.weight(1f),
                        type = "Needs Focus 🎯",
                        subjectName = focus.subjectName,
                        accuracy = focus.averageAccuracy,
                        badgeColor = Color(0xFFF59E0B),
                        bgColor = if (isDark) Color(0xFF451A03) else Color(0xFFFEF3C7),
                        isDark = isDark
                    )
                }
            }
        }

        // --- 5. 7-DAY WEEKLY ACTIVITY TREND ---
        if (uiState.weeklyPerformance.any { it.attemptsCount > 0 }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("weekly_trend_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "📅 7-Day Quiz Activity",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = titleColor
                        )
                        Text(
                            text = "${uiState.weeklyPerformance.sumOf { it.attemptsCount }} attempts this week",
                            style = MaterialTheme.typography.bodySmall,
                            color = subtitleColor
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    val maxDayAttempts = maxOf(1, uiState.weeklyPerformance.maxOf { it.attemptsCount })
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        uiState.weeklyPerformance.forEach { dayStat ->
                            val heightFraction = (dayStat.attemptsCount.toFloat() / maxDayAttempts).coerceIn(0.12f, 1f)
                            val barColor = if (dayStat.attemptsCount > 0) Color(0xFF6366F1) else Color(0xFF94A3B8).copy(alpha = 0.3f)

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                if (dayStat.attemptsCount > 0) {
                                    Text(
                                        text = "${dayStat.attemptsCount}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                }

                                Box(
                                    modifier = Modifier
                                        .width(20.dp)
                                        .height((60 * heightFraction).dp)
                                        .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                                        .background(barColor)
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = dayStat.dayLabel,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = subtitleColor
                                )
                            }
                        }
                    }
                }
            }
        }

        // --- 5.5. 30-DAY PERFORMANCE TREND LINE CHART (RECHARTS STYLE) ---
        ThirtyDayPerformanceLineChart(
            dailyStats = uiState.monthlyPerformance,
            isDark = isDark,
            cardBorder = cardBorder,
            modifier = Modifier.testTag("student_30_day_line_chart")
        )

        // --- 6. SUBJECT PERFORMANCE BREAKDOWN ---
        if (uiState.subjectStats.isNotEmpty()) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "📚 Subject Accuracy Breakdown",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )

                uiState.subjectStats.forEach { stat ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("subject_stat_${stat.subjectId}"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        border = cardBorder
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(10.dp)
                                            .clip(CircleShape)
                                            .background(Color(stat.colorHex))
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = stat.subjectName,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = titleColor
                                    )
                                }

                                Text(
                                    text = "${stat.averageAccuracy.toInt()}%",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (stat.averageAccuracy >= 80f) Color(0xFF10B981)
                                    else if (stat.averageAccuracy >= 50f) Color(0xFFF59E0B) else Color(0xFFEF4444)
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            LinearProgressIndicator(
                                progress = { (stat.averageAccuracy / 100f).coerceIn(0f, 1f) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(6.dp)
                                    .clip(RoundedCornerShape(3.dp)),
                                color = Color(stat.colorHex),
                                trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "${stat.totalAttempts} attempts • ${stat.passedCount} passed",
                                    fontSize = 11.sp,
                                    color = subtitleColor
                                )
                                Text(
                                    text = "+${stat.totalXpEarned} XP • High Score: ${stat.highScore}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = subtitleColor
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SummaryKpiCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subtitle: String,
    accentColor: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isDark: Boolean,
    cardBorder: BorderStroke,
    tag: String
) {
    Card(
        modifier = modifier.testTag(tag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(14.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = value,
                fontSize = 17.sp,
                fontWeight = FontWeight.Black,
                color = accentColor,
                maxLines = 1
            )

            Text(
                text = title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = subtitle,
                fontSize = 8.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun MetricChip(
    modifier: Modifier = Modifier,
    emoji: String,
    label: String,
    value: String,
    color: Color,
    isDark: Boolean
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = if (isDark) Color(0xFF0F172A) else Color.White,
        border = BorderStroke(1.dp, color.copy(alpha = 0.25f))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(emoji, fontSize = 15.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Column(modifier = Modifier.weight(1f, fill = false)) {
                Text(
                    text = value,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = color,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = label,
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun MetricColumn(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = color
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun SubjectInsightPill(
    modifier: Modifier = Modifier,
    type: String,
    subjectName: String,
    accuracy: Float,
    badgeColor: Color,
    bgColor: Color,
    isDark: Boolean
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(bgColor)
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = type,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = badgeColor
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "$subjectName (${accuracy.toInt()}%)",
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isDark) Color.White else Color(0xFF1E293B),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

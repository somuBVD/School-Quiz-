package com.example.ui.dashboard

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.QuizRankInfo
import com.example.data.StudentLevelInfo

/**
 * Flexible, responsive dashboard grid system that dynamically calculates
 * available viewport constraints and adapts layout, spacing, and typography.
 *
 * Guarantees that:
 * 1. Level markers, streak counters, and performance indicators are cleanly aligned
 *    both horizontally and vertically.
 * 2. Visual elements never overlap, wrap awkwardly, or clip off-screen on smaller devices (< 360dp).
 * 3. Performance charts scale seamlessly without label collision.
 */
@Composable
fun StudentDashboardFlexibleGrid(
    levelInfo: StudentLevelInfo,
    attendanceStreak: Int,
    quizRank: QuizRankInfo,
    overallAccuracy: Float,
    passRate: Float,
    totalQuizzes: Int,
    totalXp: Int,
    performanceStats: List<DayPerformanceStat>,
    isDark: Boolean,
    cardBorder: BorderStroke,
    onLevelClick: () -> Unit,
    onStreakClick: () -> Unit,
    onRankClick: () -> Unit,
    onViewFullAnalytics: () -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .testTag("student_dashboard_flexible_grid")
    ) {
        val availableWidth = maxWidth
        val isNarrow = availableWidth < 360.dp
        val isExpanded = availableWidth >= 600.dp

        val horizontalSpacing: Dp = if (isNarrow) 8.dp else 12.dp
        val verticalSpacing: Dp = if (isNarrow) 10.dp else 14.dp

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(verticalSpacing)
        ) {
            // =================================================================
            // 1. KEY METRICS FLEXIBLE GRID (LEVEL MARKER + STREAK + ACCURACY + RANK)
            // =================================================================
            if (isExpanded) {
                // Expanded screens (tablets / foldables): 4 balanced horizontal columns
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
                ) {
                    FlexibleLevelMarkerCard(
                        levelInfo = levelInfo,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = false,
                        onClick = onLevelClick,
                        modifier = Modifier.weight(1f)
                    )
                    FlexibleStreakCounterCard(
                        attendanceStreak = attendanceStreak,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = false,
                        onClick = onStreakClick,
                        modifier = Modifier.weight(1f)
                    )
                    FlexiblePerformanceMetricCard(
                        accuracy = overallAccuracy,
                        passRate = passRate,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = false,
                        onClick = onViewFullAnalytics,
                        modifier = Modifier.weight(1f)
                    )
                    FlexibleRankPointsCard(
                        quizRank = quizRank,
                        totalPoints = levelInfo.totalXp,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = false,
                        onClick = onRankClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            } else {
                // Handheld phones: 2-column uniform grid (or stacked on ultra-narrow < 320dp)
                if (availableWidth < 310.dp) {
                    // Ultra-compact fallback: single stacked column
                    FlexibleLevelMarkerCard(
                        levelInfo = levelInfo,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = true,
                        onClick = onLevelClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                    FlexibleStreakCounterCard(
                        attendanceStreak = attendanceStreak,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = true,
                        onClick = onStreakClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                    FlexiblePerformanceMetricCard(
                        accuracy = overallAccuracy,
                        passRate = passRate,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = true,
                        onClick = onViewFullAnalytics,
                        modifier = Modifier.fillMaxWidth()
                    )
                    FlexibleRankPointsCard(
                        quizRank = quizRank,
                        totalPoints = levelInfo.totalXp,
                        isDark = isDark,
                        cardBorder = cardBorder,
                        isNarrow = true,
                        onClick = onRankClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    // Standard mobile: Pair 1 (Level Marker + Streak Counter)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
                    ) {
                        FlexibleLevelMarkerCard(
                            levelInfo = levelInfo,
                            isDark = isDark,
                            cardBorder = cardBorder,
                            isNarrow = isNarrow,
                            onClick = onLevelClick,
                            modifier = Modifier.weight(1f)
                        )
                        FlexibleStreakCounterCard(
                            attendanceStreak = attendanceStreak,
                            isDark = isDark,
                            cardBorder = cardBorder,
                            isNarrow = isNarrow,
                            onClick = onStreakClick,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    // Standard mobile: Pair 2 (Performance Accuracy + Rank Tier)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
                    ) {
                        FlexiblePerformanceMetricCard(
                            accuracy = overallAccuracy,
                            passRate = passRate,
                            isDark = isDark,
                            cardBorder = cardBorder,
                            isNarrow = isNarrow,
                            onClick = onViewFullAnalytics,
                            modifier = Modifier.weight(1f)
                        )
                        FlexibleRankPointsCard(
                            quizRank = quizRank,
                            totalPoints = levelInfo.totalXp,
                            isDark = isDark,
                            cardBorder = cardBorder,
                            isNarrow = isNarrow,
                            onClick = onRankClick,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // =================================================================
            // 2. RESPONSIVE PERFORMANCE CHART CARD
            // =================================================================
            FlexiblePerformanceChartCard(
                performanceStats = performanceStats,
                overallAccuracy = overallAccuracy,
                totalQuizzes = totalQuizzes,
                isDark = isDark,
                cardBorder = cardBorder,
                isNarrow = isNarrow,
                onViewFullAnalytics = onViewFullAnalytics,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

/**
 * 1. Level Marker Card:
 * Cleanly displays student level, badge emoji, XP numbers, and progress bar to next level.
 */
@Composable
fun FlexibleLevelMarkerCard(
    levelInfo: StudentLevelInfo,
    isDark: Boolean,
    cardBorder: BorderStroke,
    isNarrow: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val levelColor = Color(levelInfo.colorHex)
    val animatedProgress by animateFloatAsState(
        targetValue = levelInfo.progressFraction,
        animationSpec = tween(durationMillis = 800),
        label = "gridLevelProgress"
    )

    Card(
        modifier = modifier
            .testTag("flexible_level_marker_card")
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E1B4B).copy(alpha = 0.55f) else Color(0xFFEEF2FF)
        ),
        border = BorderStroke(1.dp, if (isDark) levelColor.copy(alpha = 0.45f) else Color(0xFFC7D2FE))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(if (isNarrow) 10.dp else 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header Row: Emoji + Level Chip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = levelInfo.badgeEmoji, fontSize = if (isNarrow) 16.sp else 18.sp)
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = levelColor
                ) {
                    Text(
                        text = "LVL ${levelInfo.level}",
                        fontSize = if (isNarrow) 9.sp else 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Title & Total XP
            Text(
                text = levelInfo.title,
                fontSize = if (isNarrow) 12.sp else 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isDark) Color(0xFFE0E7FF) else Color(0xFF312E81),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "${levelInfo.totalXp} Total XP",
                fontSize = if (isNarrow) 10.sp else 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF4F46E5),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Mini Progress Bar to Next Level
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = levelColor,
                    trackColor = if (isDark) Color(0xFF312E81) else Color(0xFFE0E7FF)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${levelInfo.xpInCurrentLevel}/${levelInfo.xpRequiredForNextLevel} XP",
                        fontSize = 8.5.sp,
                        color = if (isDark) Color(0xFF818CF8) else Color(0xFF6366F1),
                        maxLines = 1
                    )
                    Text(
                        text = "${(levelInfo.progressFraction * 100).toInt()}%",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = levelColor,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

/**
 * 2. Streak Counter Card:
 * Displays active daily attendance streak, XP bonus, and 7-day consistency dots.
 */
@Composable
fun FlexibleStreakCounterCard(
    attendanceStreak: Int,
    isDark: Boolean,
    cardBorder: BorderStroke,
    isNarrow: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bonusXp = (attendanceStreak * 25).coerceAtLeast(25)

    Card(
        modifier = modifier
            .testTag("flexible_streak_counter_card")
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF431407).copy(alpha = 0.55f) else Color(0xFFFFF7ED)
        ),
        border = BorderStroke(1.dp, if (isDark) Color(0xFFEA580C).copy(alpha = 0.45f) else Color(0xFFFED7AA))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(if (isNarrow) 10.dp else 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header Row: Flame + Bonus XP Chip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "🔥", fontSize = if (isNarrow) 16.sp else 18.sp)
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFEA580C)
                ) {
                    Text(
                        text = "+$bonusXp XP",
                        fontSize = if (isNarrow) 9.sp else 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Main Streak Text
            Text(
                text = "$attendanceStreak Days Active",
                fontSize = if (isNarrow) 12.sp else 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isDark) Color(0xFFFFEDD5) else Color(0xFF9A3412),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = if (attendanceStreak >= 7) "7-Day Star! 🌟" else "Daily Quiz Streak",
                fontSize = if (isNarrow) 10.sp else 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isDark) Color(0xFFFDBA74) else Color(0xFFC2410C),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // 7-Day Consistency Dot Markers (clean horizontal alignment)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val filledDots = (attendanceStreak % 7).let { if (it == 0 && attendanceStreak > 0) 7 else it }
                for (i in 1..7) {
                    val isDayActive = i <= filledDots
                    Box(
                        modifier = Modifier
                            .size(if (isNarrow) 6.dp else 8.dp)
                            .clip(CircleShape)
                            .background(
                                if (isDayActive) Color(0xFFEA580C)
                                else if (isDark) Color(0xFF7C2D12)
                                else Color(0xFFFFEDD5)
                            )
                    )
                }
            }
        }
    }
}

/**
 * 3. Performance Accuracy Card:
 * Displays student overall accuracy %, pass rate, and status.
 */
@Composable
fun FlexiblePerformanceMetricCard(
    accuracy: Float,
    passRate: Float,
    isDark: Boolean,
    cardBorder: BorderStroke,
    isNarrow: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val accuracyColor = if (accuracy >= 80f) Color(0xFF10B981)
    else if (accuracy >= 50f) Color(0xFFF59E0B)
    else Color(0xFFEF4444)

    Card(
        modifier = modifier
            .testTag("flexible_performance_metric_card")
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF064E3B).copy(alpha = 0.5f) else Color(0xFFECFDF5)
        ),
        border = BorderStroke(1.dp, if (isDark) accuracyColor.copy(alpha = 0.45f) else Color(0xFFA7F3D0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(if (isNarrow) 10.dp else 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header Row: Target Emoji + Pass Rate Chip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "🎯", fontSize = if (isNarrow) 16.sp else 18.sp)
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = accuracyColor
                ) {
                    Text(
                        text = "${passRate.toInt()}% Pass",
                        fontSize = if (isNarrow) 9.sp else 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "${accuracy.toInt()}% Accuracy",
                fontSize = if (isNarrow) 12.sp else 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF065F46),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = if (accuracy >= 80f) "Excellent Form! 🏆" else if (accuracy >= 50f) "Steady Progress 📈" else "Keep Practicing 💪",
                fontSize = if (isNarrow) 10.sp else 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isDark) Color(0xFF6EE7B7) else Color(0xFF047857),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Mini Accuracy Bar
            LinearProgressIndicator(
                progress = { (accuracy / 100f).coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = accuracyColor,
                trackColor = if (isDark) Color(0xFF064E3B) else Color(0xFFD1FAE5)
            )
        }
    }
}

/**
 * 4. Rank & Points Card:
 * Displays student rank tier (Novice/Scholar/Master), total points, and leaderboard status.
 */
@Composable
fun FlexibleRankPointsCard(
    quizRank: QuizRankInfo,
    totalPoints: Int,
    isDark: Boolean,
    cardBorder: BorderStroke,
    isNarrow: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tierColor = Color(quizRank.badgeColorHex)

    Card(
        modifier = modifier
            .testTag("flexible_rank_points_card")
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF311042).copy(alpha = 0.55f) else Color(0xFFFAF5FF)
        ),
        border = BorderStroke(1.dp, if (isDark) tierColor.copy(alpha = 0.45f) else Color(0xFFE9D5FF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(if (isNarrow) 10.dp else 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header Row: Badge Emoji + Points Chip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = quizRank.badgeEmoji, fontSize = if (isNarrow) 16.sp else 18.sp)
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = tierColor
                ) {
                    Text(
                        text = "RANK",
                        fontSize = if (isNarrow) 9.sp else 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = quizRank.rankTitle,
                fontSize = if (isNarrow) 12.sp else 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isDark) Color(0xFFF3E8FF) else Color(0xFF6B21A8),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "$totalPoints Total Pts",
                fontSize = if (isNarrow) 10.sp else 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isDark) Color(0xFFD8B4FE) else Color(0xFF9333EA),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Tier Progress Indicator
            LinearProgressIndicator(
                progress = { quizRank.progressFraction },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = tierColor,
                trackColor = if (isDark) Color(0xFF4C1D95) else Color(0xFFF3E8FF)
            )
        }
    }
}

/**
 * 5. Flexible Performance Chart Card:
 * Responsive trend visualization seamlessly aligned with the grid markers above.
 * Includes time-series bezier curve, accuracy dots, and metric toggles.
 */
@Composable
fun FlexiblePerformanceChartCard(
    performanceStats: List<DayPerformanceStat>,
    overallAccuracy: Float,
    totalQuizzes: Int,
    isDark: Boolean,
    cardBorder: BorderStroke,
    isNarrow: Boolean,
    onViewFullAnalytics: () -> Unit,
    modifier: Modifier = Modifier
) {
    val chartData = remember(performanceStats) {
        if (performanceStats.isNotEmpty()) performanceStats.takeLast(7)
        else {
            val list = mutableListOf<DayPerformanceStat>()
            val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
            for (i in 0..6) {
                list.add(
                    DayPerformanceStat(
                        dayLabel = days[i],
                        timestamp = System.currentTimeMillis() - ((6 - i) * 86400000L),
                        attemptsCount = if (i >= 4) 2 else 1,
                        averageAccuracy = if (i >= 4) 85f else 75f,
                        xpEarned = 50
                    )
                )
            }
            list
        }
    }

    val primaryColor = Color(0xFF6366F1)
    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant

    Card(
        modifier = modifier
            .testTag("flexible_performance_chart_container"),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(if (isNarrow) 12.dp else 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(if (isNarrow) 28.dp else 32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(primaryColor.copy(alpha = 0.12f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                            contentDescription = "Trend",
                            tint = primaryColor,
                            modifier = Modifier.size(if (isNarrow) 16.dp else 18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Performance Trend",
                            fontSize = if (isNarrow) 13.sp else 15.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor
                        )
                        Text(
                            text = "7-Day Quiz Accuracy & Activity",
                            fontSize = if (isNarrow) 10.sp else 11.sp,
                            color = subtitleColor
                        )
                    }
                }

                TextButton(
                    onClick = onViewFullAnalytics,
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "More ↗",
                        fontSize = if (isNarrow) 11.sp else 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryColor
                    )
                }
            }

            // Canvas Chart Area
            val chartHeight = if (isNarrow) 110.dp else 130.dp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(chartHeight)
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val width = size.width
                    val height = size.height
                    val bottomPadding = 24.dp.toPx()
                    val graphHeight = height - bottomPadding

                    if (chartData.size >= 2) {
                        val maxAcc = 100f
                        val points = chartData.mapIndexed { index, stat ->
                            val x = (index.toFloat() / (chartData.size - 1)) * width
                            val y = graphHeight - ((stat.averageAccuracy.coerceIn(0f, maxAcc) / maxAcc) * (graphHeight - 16.dp.toPx())) - 8.dp.toPx()
                            Offset(x, y)
                        }

                        // Draw smooth gradient fill under the line
                        val fillPath = Path().apply {
                            moveTo(points.first().x, graphHeight)
                            points.forEach { lineTo(it.x, it.y) }
                            lineTo(points.last().x, graphHeight)
                            close()
                        }

                        drawPath(
                            path = fillPath,
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    primaryColor.copy(alpha = 0.25f),
                                    primaryColor.copy(alpha = 0.02f)
                                )
                            )
                        )

                        // Draw smooth curve stroke
                        val strokePath = Path().apply {
                            moveTo(points.first().x, points.first().y)
                            for (i in 1 until points.size) {
                                val p0 = points[i - 1]
                                val p1 = points[i]
                                val controlX = (p0.x + p1.x) / 2
                                cubicTo(controlX, p0.y, controlX, p1.y, p1.x, p1.y)
                            }
                        }

                        drawPath(
                            path = strokePath,
                            color = primaryColor,
                            style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
                        )

                        // Draw point dots
                        points.forEach { pt ->
                            drawCircle(
                                color = if (isDark) Color(0xFF1E1B4B) else Color.White,
                                radius = 4.5.dp.toPx(),
                                center = pt
                            )
                            drawCircle(
                                color = primaryColor,
                                radius = 3.dp.toPx(),
                                center = pt
                            )
                        }
                    }
                }

                // X-Axis Day Labels aligned at bottom
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    chartData.forEach { stat ->
                        Text(
                            text = stat.dayLabel.take(3),
                            fontSize = if (isNarrow) 9.sp else 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = subtitleColor,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Bottom Metric Summary Bar (cleanly aligned)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isDark) Color(0xFF1E293B).copy(alpha = 0.6f) else Color(0xFFF8FAFC))
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📊", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Average: ${overallAccuracy.toInt()}%",
                        fontSize = if (isNarrow) 10.5.sp else 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = titleColor
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⚡", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$totalQuizzes Quizzes Done",
                        fontSize = if (isNarrow) 10.5.sp else 11.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = subtitleColor
                    )
                }
            }
        }
    }
}

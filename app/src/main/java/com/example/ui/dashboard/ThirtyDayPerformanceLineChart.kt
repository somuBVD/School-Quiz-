package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Metric mode for the 30-Day Performance Line Chart.
 */
enum class LineChartMetric(val label: String, val unit: String, val icon: String) {
    ACCURACY("Accuracy", "%", "🎯"),
    ATTEMPTS("Quizzes", "quizzes", "📝"),
    XP("XP Gained", "XP", "⚡")
}

/**
 * Interactive Line Chart visualizing student quiz performance trends over the last 30 days.
 * Inspired by modern data visualization libraries (like Recharts), implemented using
 * native Jetpack Compose Canvas with smooth cubic Bézier curves, gradient area fills,
 * interactive point inspection tooltips, and time-series aggregation.
 */
@Composable
fun ThirtyDayPerformanceLineChart(
    dailyStats: List<DayPerformanceStat>,
    isDark: Boolean,
    cardBorder: BorderStroke,
    modifier: Modifier = Modifier
) {
    var selectedMetric by remember { mutableStateOf(LineChartMetric.ACCURACY) }
    var selectedPointIndex by remember { mutableIntStateOf(-1) }

    // Normalize input to exactly 30 days if empty
    val normalizedStats = remember(dailyStats) {
        if (dailyStats.isNotEmpty()) dailyStats.takeLast(30)
        else {
            val list = mutableListOf<DayPerformanceStat>()
            val format = SimpleDateFormat("MMM d", Locale.getDefault())
            for (i in 29 downTo 0) {
                val time = System.currentTimeMillis() - (i * 86400000L)
                list.add(
                    DayPerformanceStat(
                        dayLabel = if (i == 0) "Today" else format.format(Date(time)),
                        timestamp = time,
                        attemptsCount = 0,
                        averageAccuracy = 0f,
                        xpEarned = 0
                    )
                )
            }
            list
        }
    }

    // High level metrics
    val activeDaysCount = normalizedStats.count { it.attemptsCount > 0 }
    val totalQuizzesInPeriod = normalizedStats.sumOf { it.attemptsCount }
    val nonZeroAccuracies = normalizedStats.filter { it.attemptsCount > 0 }.map { it.averageAccuracy }
    val averageAccuracyInPeriod = if (nonZeroAccuracies.isNotEmpty()) nonZeroAccuracies.average().toFloat() else 0f
    val peakAccuracyInPeriod = if (nonZeroAccuracies.isNotEmpty()) nonZeroAccuracies.maxOrNull() ?: 0f else 0f
    val totalXpInPeriod = normalizedStats.sumOf { it.xpEarned }

    val primaryLineColor = when (selectedMetric) {
        LineChartMetric.ACCURACY -> Color(0xFF6366F1) // Indigo-500
        LineChartMetric.ATTEMPTS -> Color(0xFF10B981) // Emerald-500
        LineChartMetric.XP -> Color(0xFFF59E0B)       // Amber-500
    }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val gridColor = if (isDark) Color(0xFF334155).copy(alpha = 0.5f) else Color(0xFFE2E8F0)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("thirty_day_line_chart_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header Row (Optimized to prevent overlay and oversized chips)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                            contentDescription = "Trend",
                            tint = primaryLineColor,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "30-Day Performance Trends",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Text(
                        text = "Daily quiz completion & accuracy over the past month",
                        style = MaterialTheme.typography.bodySmall,
                        color = subtitleColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Interactive Metric Pill Toggle (Accuracy, Quizzes, XP) with small suitable vector icon
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = primaryLineColor.copy(alpha = 0.12f),
                    border = BorderStroke(1.dp, primaryLineColor.copy(alpha = 0.35f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = when (selectedMetric) {
                                LineChartMetric.ACCURACY -> Icons.Default.Adjust
                                LineChartMetric.ATTEMPTS -> Icons.Default.CheckCircle
                                LineChartMetric.XP -> Icons.Default.Bolt
                            },
                            contentDescription = selectedMetric.label,
                            tint = primaryLineColor,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = selectedMetric.label,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = primaryLineColor,
                            maxLines = 1
                        )
                    }
                }
            }

            // Metric Selector Segmented Filter Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LineChartMetric.entries.forEach { metric ->
                    val isSelected = selectedMetric == metric
                    FilterChip(
                        selected = isSelected,
                        onClick = {
                            selectedMetric = metric
                            selectedPointIndex = -1
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = when (metric) {
                                    LineChartMetric.ACCURACY -> Icons.Default.Adjust
                                    LineChartMetric.ATTEMPTS -> Icons.Default.CheckCircle
                                    LineChartMetric.XP -> Icons.Default.Bolt
                                },
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = if (isSelected) Color.White else primaryLineColor
                            )
                        },
                        label = {
                            Text(
                                text = metric.label,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = primaryLineColor,
                            selectedLabelColor = Color.White
                        ),
                        modifier = Modifier.testTag("metric_selector_${metric.name.lowercase()}")
                    )
                }
            }

            // Summary Stats Pills Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TrendSummaryChip(
                    modifier = Modifier.weight(1f),
                    label = "30-Day Avg",
                    value = "${averageAccuracyInPeriod.toInt()}%",
                    accentColor = Color(0xFF6366F1),
                    isDark = isDark
                )
                TrendSummaryChip(
                    modifier = Modifier.weight(1f),
                    label = "Peak Score",
                    value = "${peakAccuracyInPeriod.toInt()}%",
                    accentColor = Color(0xFF10B981),
                    isDark = isDark
                )
                TrendSummaryChip(
                    modifier = Modifier.weight(1f),
                    label = "Active Days",
                    value = "$activeDaysCount/30",
                    accentColor = Color(0xFFF59E0B),
                    isDark = isDark
                )
                TrendSummaryChip(
                    modifier = Modifier.weight(1f),
                    label = "Total Quizzes",
                    value = "$totalQuizzesInPeriod",
                    accentColor = Color(0xFFEC4899),
                    isDark = isDark
                )
            }

            // Selected Day Tooltip Banner (if user tapped a point)
            AnimatedVisibility(
                visible = selectedPointIndex in normalizedStats.indices,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                if (selectedPointIndex in normalizedStats.indices) {
                    val stat = normalizedStats[selectedPointIndex]
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("chart_selected_day_tooltip"),
                        shape = RoundedCornerShape(14.dp),
                        color = primaryLineColor.copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, primaryLineColor.copy(alpha = 0.35f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "📅 ${stat.dayLabel}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor
                                )
                                Text(
                                    text = if (stat.attemptsCount > 0)
                                        "${stat.attemptsCount} quizzes completed • ${stat.xpEarned} XP earned"
                                    else "No quiz attempts recorded on this day",
                                    fontSize = 10.sp,
                                    color = subtitleColor
                                )
                            }
                            Text(
                                text = when (selectedMetric) {
                                    LineChartMetric.ACCURACY -> "${stat.averageAccuracy.toInt()}% accuracy"
                                    LineChartMetric.ATTEMPTS -> "${stat.attemptsCount} attempts"
                                    LineChartMetric.XP -> "+${stat.xpEarned} XP"
                                },
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                color = primaryLineColor
                            )
                        }
                    }
                }
            }

            // Main Line Chart Canvas
            val chartValues = remember(normalizedStats, selectedMetric) {
                normalizedStats.map { stat ->
                    when (selectedMetric) {
                        LineChartMetric.ACCURACY -> stat.averageAccuracy
                        LineChartMetric.ATTEMPTS -> stat.attemptsCount.toFloat()
                        LineChartMetric.XP -> stat.xpEarned.toFloat()
                    }
                }
            }

            val maxVal = remember(chartValues, selectedMetric) {
                when (selectedMetric) {
                    LineChartMetric.ACCURACY -> 100f
                    LineChartMetric.ATTEMPTS -> (chartValues.maxOrNull() ?: 1f).coerceAtLeast(5f)
                    LineChartMetric.XP -> (chartValues.maxOrNull() ?: 10f).coerceAtLeast(50f)
                }
            }

            val animProgress by animateFloatAsState(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 800),
                label = "lineChartAnim"
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isDark) Color(0xFF0F172A).copy(alpha = 0.5f) else Color(0xFFF8FAFC))
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .pointerInput(normalizedStats) {
                            detectTapGestures { offset ->
                                val stepX = size.width / (normalizedStats.size - 1).coerceAtLeast(1)
                                val tappedIdx = (offset.x / stepX).toInt().coerceIn(0, normalizedStats.lastIndex)
                                selectedPointIndex = if (selectedPointIndex == tappedIdx) -1 else tappedIdx
                            }
                        }
                        .testTag("thirty_day_line_chart_canvas")
                ) {
                    val w = size.width
                    val h = size.height
                    val n = chartValues.size
                    if (n < 2) return@Canvas

                    val stepX = w / (n - 1).toFloat()

                    // 1. HORIZONTAL GRID LINES (0%, 25%, 50%, 75%, 100%)
                    val gridLevels = listOf(0.0f, 0.25f, 0.5f, 0.75f, 1.0f)
                    val dashEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

                    gridLevels.forEach { lvl ->
                        val y = h - (lvl * h)
                        drawLine(
                            color = gridColor,
                            start = Offset(0f, y),
                            end = Offset(w, y),
                            strokeWidth = 1f,
                            pathEffect = if (lvl in 0.01f..0.99f) dashEffect else null
                        )
                    }

                    // 2. AVERAGE BASELINE (Dashed accent line)
                    if (selectedMetric == LineChartMetric.ACCURACY && averageAccuracyInPeriod > 0) {
                        val avgY = h - ((averageAccuracyInPeriod / maxVal).coerceIn(0f, 1f) * h)
                        drawLine(
                            color = primaryLineColor.copy(alpha = 0.4f),
                            start = Offset(0f, avgY),
                            end = Offset(w, avgY),
                            strokeWidth = 1.5f,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f), 0f)
                        )
                    }

                    // Calculate point coordinates
                    val points = chartValues.mapIndexed { idx, value ->
                        val x = idx * stepX
                        val ratio = (value / maxVal).coerceIn(0f, 1f) * animProgress
                        val y = h - (ratio * h)
                        Offset(x, y)
                    }

                    // 3. SMOOTH BÉZIER CURVE PATH & GRADIENT AREA FILL
                    val strokePath = Path()
                    val fillPath = Path()

                    points.forEachIndexed { i, p ->
                        if (i == 0) {
                            strokePath.moveTo(p.x, p.y)
                            fillPath.moveTo(p.x, h)
                            fillPath.lineTo(p.x, p.y)
                        } else {
                            val prev = points[i - 1]
                            val cx1 = prev.x + (p.x - prev.x) / 2f
                            val cy1 = prev.y
                            val cx2 = prev.x + (p.x - prev.x) / 2f
                            val cy2 = p.y
                            strokePath.cubicTo(cx1, cy1, cx2, cy2, p.x, p.y)
                            fillPath.cubicTo(cx1, cy1, cx2, cy2, p.x, p.y)
                        }
                    }

                    // Close fill path down to base
                    fillPath.lineTo(points.last().x, h)
                    fillPath.close()

                    // Draw gradient area under the line (Recharts style)
                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                primaryLineColor.copy(alpha = 0.35f),
                                primaryLineColor.copy(alpha = 0.05f),
                                Color.Transparent
                            )
                        )
                    )

                    // Draw the smooth curve line stroke
                    drawPath(
                        path = strokePath,
                        color = primaryLineColor,
                        style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
                    )

                    // 4. DRAW DATA POINT CIRCLES (For active study days)
                    points.forEachIndexed { idx, p ->
                        val stat = normalizedStats[idx]
                        val isActive = stat.attemptsCount > 0
                        val isSelected = idx == selectedPointIndex

                        if (isActive || isSelected) {
                            val pointRadius = if (isSelected) 6.dp.toPx() else 4.dp.toPx()
                            // Outer ring
                            drawCircle(
                                color = if (isSelected) Color(0xFFEA580C) else primaryLineColor,
                                radius = pointRadius + 2.dp.toPx(),
                                center = p
                            )
                            // Inner circle
                            drawCircle(
                                color = Color.White,
                                radius = pointRadius,
                                center = p
                            )
                            // Center dot
                            drawCircle(
                                color = if (isSelected) Color(0xFFEA580C) else primaryLineColor,
                                radius = pointRadius / 2f,
                                center = p
                            )
                        }
                    }
                }
            }

            // X-Axis Date Labels Row (Sampled across 30 days)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val tickIndices = listOf(0, 7, 14, 21, 28, normalizedStats.lastIndex)
                tickIndices.forEach { idx ->
                    val label = normalizedStats.getOrNull(idx)?.dayLabel ?: ""
                    Text(
                        text = label,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = subtitleColor
                    )
                }
            }

            // Explanatory Footer Pill
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "💡 Tap any data point to inspect that day's score and activity",
                    fontSize = 11.sp,
                    color = subtitleColor
                )
                Text(
                    text = "Room SQLite 30D Log",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryLineColor
                )
            }
        }
    }
}

@Composable
private fun TrendSummaryChip(
    label: String,
    value: String,
    accentColor: Color,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9)
        ),
        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = accentColor
            )
        }
    }
}

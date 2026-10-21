package com.example.ui.dashboard

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.QuizStaticData
import com.example.data.SubjectTemplate
import com.example.data.UnitTemplate
import com.example.data.UnitProgress
import com.example.data.UserProfile

/**
 * Data structures for Subject Performance & Unit Progress Analytics
 */
data class SubjectPerformanceMetric(
    val subject: SubjectTemplate,
    val totalUnits: Int,
    val attemptedUnits: Int,
    val completedUnits: Int,
    val averageScore: Int,
    val completionPercentage: Int,
    val color: Color
)

data class UnitPerformanceMetric(
    val unit: UnitTemplate,
    val subjectTitle: String,
    val subjectColor: Color,
    val progress: Int,
    val score: Int,
    val isCompleted: Boolean
)

@Composable
fun AnalyticsChartsSection(
    userProfile: UserProfile,
    progressList: List<UnitProgress>,
    isDark: Boolean,
    monthlyPerformance: List<DayPerformanceStat> = emptyList(),
    modifier: Modifier = Modifier
) {
    val currentStd = userProfile.standard
    val currentSubjects: List<SubjectTemplate> = remember(currentStd) {
        QuizStaticData.standardsList.find { it.std == currentStd }?.subjects ?: emptyList()
    }

    // Compute Subject-based performance metrics
    val subjectMetrics = remember(currentSubjects, progressList, currentStd) {
        currentSubjects.map { subject ->
            val units = subject.units
            val totalUnits = units.size
            val subProgress = progressList.filter { it.stdId == currentStd && it.subjectId == subject.id }

            val completedUnits = subProgress.count { it.progress >= 100 }
            val attemptedUnits = subProgress.count { it.progress > 0 }
            val avgScore = if (attemptedUnits > 0) {
                val nonZeroProgress = subProgress.filter { it.progress > 0 }
                if (nonZeroProgress.isNotEmpty()) {
                    nonZeroProgress.map { progItem ->
                        if (progItem.totalQuestions > 0) {
                            (progItem.completedQuestions * 100 / progItem.totalQuestions)
                        } else {
                            progItem.progress
                        }
                    }.average().toInt()
                } else 0
            } else 0

            val completionPercentage = if (totalUnits > 0) {
                ((completedUnits.toFloat() / totalUnits) * 100).toInt()
            } else 0

            SubjectPerformanceMetric(
                subject = subject,
                totalUnits = totalUnits,
                attemptedUnits = attemptedUnits,
                completedUnits = completedUnits,
                averageScore = avgScore,
                completionPercentage = completionPercentage,
                color = Color(subject.colorHex)
            )
        }
    }

    // Selected subject for detailed Unit-wise drilldown (null = All subjects)
    var selectedSubjectId by remember { mutableStateOf<String?>(null) }
    var selectedBarIndex by remember { mutableIntStateOf(-1) }

    val filteredUnits = remember(selectedSubjectId, currentSubjects, progressList, currentStd) {
        val subjectsToInspect = if (selectedSubjectId != null) {
            currentSubjects.filter { it.id == selectedSubjectId }
        } else {
            currentSubjects
        }

        subjectsToInspect.flatMap { subject ->
            subject.units.map { unit ->
                val entity = progressList.firstOrNull {
                    it.stdId == currentStd && it.subjectId == subject.id && it.unitId == unit.id
                }
                val prog = entity?.progress ?: 0
                val score = if (entity != null && entity.totalQuestions > 0) {
                    (entity.completedQuestions * 100 / entity.totalQuestions)
                } else {
                    prog
                }
                UnitPerformanceMetric(
                    unit = unit,
                    subjectTitle = subject.title,
                    subjectColor = Color(subject.colorHex),
                    progress = prog,
                    score = score,
                    isCompleted = prog >= 100
                )
            }
        }
    }

    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("analytics_charts_section"),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- 1. HERO HEADER: OVERALL CURRICULUM MASTERY DONUT & METRIC SUMMARY ---
        MasteryOverviewDonutCard(
            subjectMetrics = subjectMetrics,
            isDark = isDark,
            cardBorder = cardBorder,
            titleColor = titleColor,
            subtitleColor = subtitleColor
        )

        // --- 1.25. RECHARTS MULTI-SUBJECT PERFORMANCE PROGRESS DASHBOARD ---
        MultiSubjectPerformanceTrendChart(
            progressList = progressList,
            subjects = currentSubjects,
            isDark = isDark,
            cardBorder = cardBorder,
            modifier = Modifier.testTag("multi_subject_recharts_dashboard")
        )

        // --- 1.5. 30-DAY PERFORMANCE TREND LINE CHART (AGGREGATE) ---
        ThirtyDayPerformanceLineChart(
            dailyStats = monthlyPerformance,
            isDark = isDark,
            cardBorder = cardBorder,
            modifier = Modifier.testTag("analytics_30_day_line_chart")
        )

        // --- 2. SUBJECT-BASED PERFORMANCE METRICS (CANVAS BAR & ACCURACY COMPARISON) ---
        SubjectPerformanceBarChartCard(
            subjectMetrics = subjectMetrics,
            selectedBarIndex = selectedBarIndex,
            onBarSelected = { idx ->
                selectedBarIndex = if (selectedBarIndex == idx) -1 else idx
            },
            isDark = isDark,
            cardBorder = cardBorder,
            titleColor = titleColor,
            subtitleColor = subtitleColor
        )

        // --- 3. SUBJECT STRENGTH & FOCUS RECOMMENDATIONS ---
        SubjectRankingCard(
            subjectMetrics = subjectMetrics,
            isDark = isDark,
            cardBorder = cardBorder,
            titleColor = titleColor,
            subtitleColor = subtitleColor
        )

        // --- 4. UNIT-WISE PROGRESS STEP CHART & DRILLDOWN ---
        UnitProgressDrilldownSection(
            currentSubjects = currentSubjects,
            selectedSubjectId = selectedSubjectId,
            onSubjectSelected = { selectedSubjectId = it },
            units = filteredUnits,
            isDark = isDark,
            cardBorder = cardBorder,
            titleColor = titleColor,
            subtitleColor = subtitleColor
        )
    }
}

/**
 * Visual Donut / Ring chart displaying Curriculum completion status
 */
@Composable
fun MasteryOverviewDonutCard(
    subjectMetrics: List<SubjectPerformanceMetric>,
    isDark: Boolean,
    cardBorder: BorderStroke,
    titleColor: Color,
    subtitleColor: Color
) {
    val totalUnitsCount = subjectMetrics.sumOf { it.totalUnits }.coerceAtLeast(1)
    val completedUnitsCount = subjectMetrics.sumOf { it.completedUnits }
    val inProgressUnitsCount = subjectMetrics.sumOf { it.attemptedUnits - it.completedUnits }
    val notStartedUnitsCount = (totalUnitsCount - completedUnitsCount - inProgressUnitsCount).coerceAtLeast(0)

    val completedRatio = completedUnitsCount.toFloat() / totalUnitsCount
    val inProgressRatio = inProgressUnitsCount.toFloat() / totalUnitsCount
    val notStartedRatio = notStartedUnitsCount.toFloat() / totalUnitsCount

    val animatedCompleted by animateFloatAsState(targetValue = completedRatio, animationSpec = tween(900), label = "compRatio")
    val animatedInProgress by animateFloatAsState(targetValue = inProgressRatio, animationSpec = tween(900), label = "inProgRatio")

    val overallScoreAvg = if (subjectMetrics.isNotEmpty()) {
        val nonZero = subjectMetrics.filter { it.averageScore > 0 }
        if (nonZero.isNotEmpty()) nonZero.map { it.averageScore }.average().toInt() else 0
    } else 0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("curriculum_mastery_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.PieChart,
                        contentDescription = "Mastery",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Curriculum Completion Matrix",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor
                    )
                }
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "${(completedRatio * 100).toInt()}% Done",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Interactive Donut Chart Canvas
                Box(
                    modifier = Modifier.size(130.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val completedColor = Color(0xFF10B981) // emerald-500
                    val inProgressColor = Color(0xFF3B82F6) // blue-500
                    val emptyColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)

                    Canvas(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                        val strokeWidth = 24.dp.toPx()
                        val diameter = size.minDimension - strokeWidth
                        val radius = diameter / 2
                        val center = Offset(size.width / 2, size.height / 2)

                        // Background track
                        drawCircle(
                            color = emptyColor,
                            radius = radius,
                            center = center,
                            style = Stroke(width = strokeWidth)
                        )

                        // In progress segment
                        val inProgressSweep = animatedInProgress * 360f
                        val completedSweep = animatedCompleted * 360f

                        // Draw completed
                        if (completedSweep > 0f) {
                            drawArc(
                                color = completedColor,
                                startAngle = -90f,
                                sweepAngle = completedSweep,
                                useCenter = false,
                                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                                topLeft = Offset(center.x - radius, center.y - radius),
                                size = Size(radius * 2, radius * 2)
                            )
                        }

                        // Draw in progress
                        if (inProgressSweep > 0f) {
                            drawArc(
                                color = inProgressColor,
                                startAngle = -90f + completedSweep,
                                sweepAngle = inProgressSweep,
                                useCenter = false,
                                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                                topLeft = Offset(center.x - radius, center.y - radius),
                                size = Size(radius * 2, radius * 2)
                            )
                        }
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "$completedUnitsCount/$totalUnitsCount",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor
                        )
                        Text(
                            text = "Units",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = subtitleColor
                        )
                    }
                }

                // Legend & Key Metrics
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DonutLegendRow(
                        color = Color(0xFF10B981),
                        label = "Mastered (100%)",
                        count = completedUnitsCount,
                        percentage = (completedRatio * 100).toInt(),
                        titleColor = titleColor
                    )
                    DonutLegendRow(
                        color = Color(0xFF3B82F6),
                        label = "In Progress",
                        count = inProgressUnitsCount,
                        percentage = (inProgressRatio * 100).toInt(),
                        titleColor = titleColor
                    )
                    DonutLegendRow(
                        color = if (isDark) Color(0xFF64748B) else Color(0xFF94A3B8),
                        label = "Unattempted",
                        count = notStartedUnitsCount,
                        percentage = (notStartedRatio * 100).toInt(),
                        titleColor = titleColor
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 2.dp),
                        color = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Overall Quiz Avg:",
                            fontSize = 11.sp,
                            color = subtitleColor,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f, fill = false),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "🎯 $overallScoreAvg%",
                            fontSize = 12.sp,
                            color = Color(0xFF8B5CF6),
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DonutLegendRow(
    color: Color,
    label: String,
    count: Int,
    percentage: Int,
    titleColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(color)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = titleColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "$count ($percentage%)",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}

/**
 * Subject Performance Bar Chart Card:
 * Compares Completion % and Average Score % across each subject
 */
@Composable
fun SubjectPerformanceBarChartCard(
    subjectMetrics: List<SubjectPerformanceMetric>,
    selectedBarIndex: Int,
    onBarSelected: (Int) -> Unit,
    isDark: Boolean,
    cardBorder: BorderStroke,
    titleColor: Color,
    subtitleColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("subject_performance_chart_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                        contentDescription = "Subject Metrics",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Subject Performance Comparison",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor
                    )
                }
            }

            Text(
                text = "Tap any subject bar to view unit breakdown & mastery insights.",
                fontSize = 11.sp,
                color = subtitleColor
            )

            // Visual Chart Legend
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(Color(0xFF3B82F6))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Completion %", fontSize = 11.sp, color = subtitleColor)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(Color(0xFF10B981))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Quiz Score %", fontSize = 11.sp, color = subtitleColor)
                }
            }

            // Custom Animated Bar Chart using Canvas
            val chartHeight = 170.dp
            val selectedMetric = if (selectedBarIndex in subjectMetrics.indices) subjectMetrics[selectedBarIndex] else null

            Box(modifier = Modifier.fillMaxWidth().height(chartHeight)) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 4.dp, vertical = 8.dp)
                ) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    val barGroupCount = subjectMetrics.size.coerceAtLeast(1)
                    val groupWidth = canvasWidth / barGroupCount
                    val barWidth = (groupWidth * 0.28f).coerceAtMost(16.dp.toPx())
                    val barSpacing = 4.dp.toPx()

                    // Draw reference gridlines
                    val gridSteps = 4
                    for (i in 0..gridSteps) {
                        val y = canvasHeight * (i.toFloat() / gridSteps)
                        drawLine(
                            color = if (isDark) Color(0xFF334155).copy(alpha = 0.5f) else Color(0xFFE2E8F0),
                            start = Offset(0f, y),
                            end = Offset(canvasWidth, y),
                            strokeWidth = 1.dp.toPx()
                        )
                    }

                    // Render Bars for each subject
                    subjectMetrics.forEachIndexed { index, metric ->
                        val groupCenterX = groupWidth * index + groupWidth / 2

                        val completionHeight = (metric.completionPercentage / 100f) * (canvasHeight - 20.dp.toPx())
                        val scoreHeight = (metric.averageScore / 100f) * (canvasHeight - 20.dp.toPx())

                        val isHighlighted = selectedBarIndex == index || selectedBarIndex == -1

                        // Bar 1: Completion (Blue or dimmed)
                        val completionColor = if (isHighlighted) Color(0xFF3B82F6) else Color(0xFF94A3B8).copy(alpha = 0.4f)
                        val scoreColor = if (isHighlighted) Color(0xFF10B981) else Color(0xFF94A3B8).copy(alpha = 0.3f)

                        val bar1Left = groupCenterX - barWidth - (barSpacing / 2)
                        val bar1Top = canvasHeight - completionHeight

                        drawRoundRect(
                            color = completionColor,
                            topLeft = Offset(bar1Left, bar1Top),
                            size = Size(barWidth, completionHeight.coerceAtLeast(4.dp.toPx())),
                            cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
                        )

                        // Bar 2: Score (Emerald)
                        val bar2Left = groupCenterX + (barSpacing / 2)
                        val bar2Top = canvasHeight - scoreHeight

                        drawRoundRect(
                            color = scoreColor,
                            topLeft = Offset(bar2Left, bar2Top),
                            size = Size(barWidth, scoreHeight.coerceAtLeast(4.dp.toPx())),
                            cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
                        )
                    }
                }
            }

            // Subject Labels underneath bars
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                subjectMetrics.forEachIndexed { index, metric ->
                    val isSelected = selectedBarIndex == index
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSelected) metric.color.copy(alpha = 0.15f) else Color.Transparent)
                            .clickable { onBarSelected(index) }
                            .padding(vertical = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = metric.subject.title.take(4),
                            fontSize = 10.sp,
                            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
                            color = if (isSelected) metric.color else subtitleColor,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Interactive Tooltip Card if a bar is selected
            AnimatedVisibility(visible = selectedMetric != null) {
                selectedMetric?.let { metric ->
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        color = metric.color.copy(alpha = 0.1f),
                        border = BorderStroke(1.dp, metric.color.copy(alpha = 0.3f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = metric.subject.title,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor
                                )
                                Text(
                                    text = "${metric.completedUnits} of ${metric.totalUnits} units mastered",
                                    fontSize = 11.sp,
                                    color = subtitleColor
                                )
                            }
                            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                Column(horizontalAlignment = Alignment.End) {
                                    Text(text = "Completion", fontSize = 10.sp, color = subtitleColor)
                                    Text(
                                        text = "${metric.completionPercentage}%",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFF3B82F6)
                                    )
                                }
                                Column(horizontalAlignment = Alignment.End) {
                                    Text(text = "Score Avg", fontSize = 10.sp, color = subtitleColor)
                                    Text(
                                        text = "${metric.averageScore}%",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
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

/**
 * Subject Ranking & Recommendations:
 * Identifies student's highest performing subject and areas needing revision
 */
@Composable
fun SubjectRankingCard(
    subjectMetrics: List<SubjectPerformanceMetric>,
    isDark: Boolean,
    cardBorder: BorderStroke,
    titleColor: Color,
    subtitleColor: Color
) {
    if (subjectMetrics.isEmpty()) return

    val sortedByScore = subjectMetrics.sortedByDescending { it.averageScore }
    val bestSubject = sortedByScore.firstOrNull { it.averageScore > 0 }
    val needsFocus = sortedByScore.lastOrNull { it.completionPercentage < 100 }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("subject_insights_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AutoGraph,
                    contentDescription = "Insights",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Performance Diagnostics",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Best Subject Card
                Surface(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    color = if (isDark) Color(0xFF064E3B).copy(alpha = 0.5f) else Color(0xFFECFDF5),
                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🌟", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Strongest Subject",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF059669)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = bestSubject?.subject?.title ?: "Keep Practicing",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (bestSubject != null) "${bestSubject.averageScore}% Accuracy" else "No quizzes yet",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF059669)
                        )
                    }
                }

                // Needs Focus Card
                Surface(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    color = if (isDark) Color(0xFF451A03).copy(alpha = 0.5f) else Color(0xFFFFFBEB),
                    border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🎯", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Recommended Focus",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFD97706)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = needsFocus?.subject?.title ?: "All Completed!",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (needsFocus != null) "${needsFocus.completionPercentage}% Complete" else "Curriculum Mastered",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFD97706)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Unit-Wise Progress Drilldown with Subject Filter chips and horizontal step progress bars
 */
@Composable
fun UnitProgressDrilldownSection(
    currentSubjects: List<SubjectTemplate>,
    selectedSubjectId: String?,
    onSubjectSelected: (String?) -> Unit,
    units: List<UnitPerformanceMetric>,
    isDark: Boolean,
    cardBorder: BorderStroke,
    titleColor: Color,
    subtitleColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("unit_progress_drilldown_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Stars,
                        contentDescription = "Units",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Unit-Wise Progress Matrix",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor
                    )
                }
                Text(
                    text = "${units.size} Units",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = subtitleColor
                )
            }

            // Subject Filter Horizontal Chips
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = selectedSubjectId == null,
                    onClick = { onSubjectSelected(null) },
                    label = { Text("All Subjects", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                    modifier = Modifier.testTag("filter_all_units")
                )

                currentSubjects.forEach { subj ->
                    FilterChip(
                        selected = selectedSubjectId == subj.id,
                        onClick = { onSubjectSelected(subj.id) },
                        label = { Text(subj.title, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                        modifier = Modifier.testTag("filter_unit_subj_${subj.id}")
                    )
                }
            }

            // Unit Progress Step List
            if (units.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No units found for current selection.",
                        color = subtitleColor,
                        fontSize = 13.sp
                    )
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    units.forEach { item ->
                        UnitProgressBarItem(
                            item = item,
                            isDark = isDark,
                            titleColor = titleColor,
                            subtitleColor = subtitleColor
                        )
                    }
                }
            }
        }
    }
}

/**
 * Individual Unit horizontal step progress bar with animated completion fill
 */
@Composable
fun UnitProgressBarItem(
    item: UnitPerformanceMetric,
    isDark: Boolean,
    titleColor: Color,
    subtitleColor: Color
) {
    val animatedProgress by animateFloatAsState(
        targetValue = item.progress / 100f,
        animationSpec = tween(700),
        label = "unitProg"
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("unit_progress_item_${item.unit.id}"),
        shape = RoundedCornerShape(16.dp),
        color = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC),
        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
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
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Status Badge Icon
                    if (item.isCompleted) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Mastered",
                            tint = Color(0xFF10B981),
                            modifier = Modifier.size(18.dp)
                        )
                    } else if (item.progress > 0) {
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF3B82F6))
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF94A3B8).copy(alpha = 0.5f))
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Unit ${item.unit.id}: ${item.unit.name}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = titleColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "• ${item.subjectTitle}",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = item.subjectColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Completion Badge
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = when {
                        item.isCompleted -> Color(0xFF10B981).copy(alpha = 0.15f)
                        item.progress > 0 -> Color(0xFF3B82F6).copy(alpha = 0.15f)
                        else -> Color(0xFF94A3B8).copy(alpha = 0.12f)
                    }
                ) {
                    Text(
                        text = when {
                            item.isCompleted -> "100% Mastered"
                            item.progress > 0 -> "${item.progress}% (${item.score}% pts)"
                            else -> "Not Started"
                        },
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = when {
                            item.isCompleted -> Color(0xFF059669)
                            item.progress > 0 -> Color(0xFF2563EB)
                            else -> Color(0xFF64748B)
                        }
                    )
                }
            }

            // Segmented Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(animatedProgress)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = if (item.isCompleted) {
                                    listOf(Color(0xFF10B981), Color(0xFF34D399))
                                } else {
                                    listOf(item.subjectColor, item.subjectColor.copy(alpha = 0.8f))
                                }
                            )
                        )
                )
            }
        }
    }
}

package com.example.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.CloudDone
import androidx.compose.material.icons.rounded.Computer
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.OfflinePin
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Public
import androidx.compose.material.icons.rounded.Science
import androidx.compose.material.icons.rounded.Sync
import androidx.compose.material.icons.rounded.Translate
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.QuizStaticData
import com.example.data.UnitProgress
import com.example.sync.KpscSyncStatus

private data class KpscSubModuleUi(
    val subjectId: String,
    val titleResId: Int,
    val kannadaLabel: String,
    val icon: ImageVector,
    val accentColor: Color
)

/**
 * Dedicated 'KPSC Exam Preparation' category section embedded in the Home category selector.
 * Features the 5 core KPSC sub-modules (Kannada, English, General Knowledge, Science, Computer Basics),
 * live per-module readiness progress, Room offline index & WorkManager sync status, quick-jump topic chips,
 * and an inline unit launcher when a sub-module is active.
 */
@Composable
fun KpscExamPrepSection(
    selectedStd: Int,
    selectedSubjectFilter: String,
    progressList: List<UnitProgress>,
    isDark: Boolean,
    onSelectModule: (subjectId: String) -> Unit,
    onSelectAllKpsc: () -> Unit,
    onStartQuiz: (stdId: Int, subjectId: String, unitId: Int, unitName: String) -> Unit,
    modifier: Modifier = Modifier,
    kpscSyncedQuestionCount: Int = 0,
    kpscMaterialCount: Int = 0,
    kpscSyncStatus: KpscSyncStatus = KpscSyncStatus.IDLE,
    onSyncKpscContent: () -> Unit = {}
) {
    val isKpscSelected = selectedStd == 15

    val coreModules = remember {
        listOf(
            KpscSubModuleUi(
                subjectId = "kpsc_kannada",
                titleResId = R.string.kpsc_module_kannada,
                kannadaLabel = "ಸಾಮಾನ್ಯ ಕನ್ನಡ",
                icon = Icons.Rounded.Translate,
                accentColor = Color(0xFF2563EB)
            ),
            KpscSubModuleUi(
                subjectId = "kpsc_english",
                titleResId = R.string.kpsc_module_english,
                kannadaLabel = "ಸಾಮಾನ್ಯ ಇಂಗ್ಲಿಷ್",
                icon = Icons.Rounded.MenuBook,
                accentColor = Color(0xFF059669)
            ),
            KpscSubModuleUi(
                subjectId = "kpsc_gk",
                titleResId = R.string.kpsc_module_gk,
                kannadaLabel = "ಸಾಮಾನ್ಯ ಜ್ಞಾನ",
                icon = Icons.Rounded.Public,
                accentColor = Color(0xFFD97706)
            ),
            KpscSubModuleUi(
                subjectId = "kpsc_science",
                titleResId = R.string.kpsc_module_science,
                kannadaLabel = "ಸಾಮಾನ್ಯ ವಿಜ್ಞಾನ",
                icon = Icons.Rounded.Science,
                accentColor = Color(0xFF0284C7)
            ),
            KpscSubModuleUi(
                subjectId = "kpsc_computer",
                titleResId = R.string.kpsc_module_computer,
                kannadaLabel = "ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ",
                icon = Icons.Rounded.Computer,
                accentColor = Color(0xFF0891B2)
            )
        )
    }

    val extraKpscShortcuts = remember {
        listOf(
            "kpsc_kannada_grammar" to "ಕನ್ನಡ ವ್ಯಾಕರಣ",
            "karnataka_history" to "ಕರ್ನಾಟಕ ಇತಿಹಾಸ",
            "indian_polity" to "ಸಂವಿಧಾನ (Polity)",
            "geography_economy" to "Geo & Economy",
            "mental_ability" to "CSAT Reasoning"
        )
    }

    val kpscSubjectsById = remember {
        QuizStaticData.kpscStandard.subjects.associateBy { it.id }
    }

    val kpscProgressBySubject = remember(progressList) {
        progressList
            .filter { it.stdId == 15 }
            .groupBy { it.subjectId }
    }

    val overallReadiness = remember(kpscProgressBySubject) {
        val coreIds = listOf("kpsc_kannada", "kpsc_english", "kpsc_gk", "kpsc_science", "kpsc_computer")
        val scores = coreIds.map { id ->
            val items = kpscProgressBySubject[id].orEmpty().filter { it.progress > 0 }
            if (items.isNotEmpty()) items.map { it.progress }.average().toInt() else 0
        }
        if (scores.isNotEmpty()) scores.average().toInt() else 0
    }

    val headerGradient = if (isDark) {
        Brush.linearGradient(listOf(Color(0xFF1E1B4B), Color(0xFF312E81), Color(0xFF1E3A5F)))
    } else {
        Brush.linearGradient(listOf(Color(0xFF1E1B4B), Color(0xFF3730A3), Color(0xFF0F766E)))
    }

    val containerBorder = if (isKpscSelected) {
        BorderStroke(1.5.dp, Color(0xFF4F46E5))
    } else {
        BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("kpsc_exam_prep_section"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = containerBorder,
        elevation = CardDefaults.cardElevation(defaultElevation = if (isKpscSelected) 3.dp else 1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Atmospheric Header Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(headerGradient)
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(Color.White.copy(alpha = 0.16f))
                                    .border(1.dp, Color.White.copy(alpha = 0.25f), RoundedCornerShape(14.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.AccountBalance,
                                    contentDescription = stringResource(R.string.kpsc_exam_prep_title),
                                    tint = Color(0xFFFDE68A),
                                    modifier = Modifier.size(22.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text(
                                        text = stringResource(R.string.kpsc_exam_prep_title),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.weight(1f, fill = false)
                                    )
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = Color(0xFFF59E0B)
                                    ) {
                                        Text(
                                            text = stringResource(R.string.kpsc_exam_prep_badge),
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(0xFF1E1B4B),
                                            maxLines = 1,
                                            softWrap = false,
                                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = stringResource(R.string.kpsc_exam_prep_subtitle),
                                    fontSize = 11.sp,
                                    color = Color(0xFFE0E7FF),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        FilledTonalButton(
                            onClick = onSelectAllKpsc,
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = if (isKpscSelected && selectedSubjectFilter == "all") {
                                    Color(0xFFF59E0B)
                                } else {
                                    Color.White.copy(alpha = 0.16f)
                                },
                                contentColor = if (isKpscSelected && selectedSubjectFilter == "all") {
                                    Color(0xFF1E1B4B)
                                } else {
                                    Color.White
                                }
                            ),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                            modifier = Modifier
                                .heightIn(min = 36.dp)
                                .testTag("kpsc_view_all_button")
                        ) {
                            Text(
                                text = stringResource(R.string.kpsc_exam_prep_view_all),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // Compact Overall Readiness Bar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        LinearProgressIndicator(
                            progress = { (overallReadiness / 100f).coerceIn(0f, 1f) },
                            modifier = Modifier
                                .weight(1f)
                                .height(5.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = Color(0xFFFDE68A),
                            trackColor = Color.White.copy(alpha = 0.2f)
                        )
                        Text(
                            text = "$overallReadiness% Ready",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            softWrap = false
                        )
                    }

                    // Offline Room Index & WorkManager Sync Status Strip
                    val isSyncing = kpscSyncStatus == KpscSyncStatus.SYNCING
                    val statusLabel = when (kpscSyncStatus) {
                        KpscSyncStatus.SYNCING -> stringResource(R.string.kpsc_sync_syncing)
                        KpscSyncStatus.SYNCED -> "${stringResource(R.string.kpsc_sync_cloud_ready)} • $kpscSyncedQuestionCount Qs"
                        else -> if (kpscSyncedQuestionCount > 0) {
                            "${stringResource(R.string.kpsc_sync_ready)} • $kpscSyncedQuestionCount Qs"
                        } else {
                            "${stringResource(R.string.kpsc_sync_ready)} • $kpscMaterialCount Modules"
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White.copy(alpha = 0.12f))
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            if (isSyncing) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(14.dp),
                                    strokeWidth = 2.dp,
                                    color = Color(0xFFFDE68A)
                                )
                            } else {
                                Icon(
                                    imageVector = if (kpscSyncStatus == KpscSyncStatus.SYNCED) {
                                        Icons.Rounded.CloudDone
                                    } else {
                                        Icons.Rounded.OfflinePin
                                    },
                                    contentDescription = statusLabel,
                                    tint = Color(0xFFA7F3D0),
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                            Text(
                                text = statusLabel,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White.copy(alpha = 0.94f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Spacer(modifier = Modifier.width(6.dp))

                        Surface(
                            onClick = { if (!isSyncing) onSyncKpscContent() },
                            shape = RoundedCornerShape(8.dp),
                            color = Color.White.copy(alpha = 0.18f),
                            modifier = Modifier
                                .heightIn(min = 32.dp)
                                .testTag("kpsc_sync_now_button")
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Sync,
                                    contentDescription = stringResource(R.string.kpsc_sync_cd),
                                    tint = Color.White,
                                    modifier = Modifier.size(13.dp)
                                )
                                Text(
                                    text = stringResource(R.string.kpsc_sync_action),
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }
            }

            // 5 Core Sub-Modules Grid (2 + 2 + 1 full-width Computer Basics card)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Row 1: Kannada & English
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    coreModules.take(2).forEach { module ->
                        val subjectTemplate = kpscSubjectsById[module.subjectId]
                        val unitCount = subjectTemplate?.units?.size ?: 0
                        val avgPct = kpscProgressBySubject[module.subjectId]
                            .orEmpty()
                            .filter { it.progress > 0 }
                            .let { list -> if (list.isNotEmpty()) list.map { it.progress }.average().toInt() else 0 }

                        KpscSubModuleCard(
                            module = module,
                            unitCount = unitCount,
                            progressPercent = avgPct,
                            isSelected = isKpscSelected && selectedSubjectFilter.equals(module.subjectId, ignoreCase = true),
                            isDark = isDark,
                            onClick = { onSelectModule(module.subjectId) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Row 2: General Knowledge & Science
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    coreModules.drop(2).take(2).forEach { module ->
                        val subjectTemplate = kpscSubjectsById[module.subjectId]
                        val unitCount = subjectTemplate?.units?.size ?: 0
                        val avgPct = kpscProgressBySubject[module.subjectId]
                            .orEmpty()
                            .filter { it.progress > 0 }
                            .let { list -> if (list.isNotEmpty()) list.map { it.progress }.average().toInt() else 0 }

                        KpscSubModuleCard(
                            module = module,
                            unitCount = unitCount,
                            progressPercent = avgPct,
                            isSelected = isKpscSelected && selectedSubjectFilter.equals(module.subjectId, ignoreCase = true),
                            isDark = isDark,
                            onClick = { onSelectModule(module.subjectId) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Row 3: Computer Basics (Full-width featured sub-module card)
                val computerModule = coreModules.last()
                val compTemplate = kpscSubjectsById[computerModule.subjectId]
                val compUnits = compTemplate?.units?.size ?: 0
                val compPct = kpscProgressBySubject[computerModule.subjectId]
                    .orEmpty()
                    .filter { it.progress > 0 }
                    .let { list -> if (list.isNotEmpty()) list.map { it.progress }.average().toInt() else 0 }

                KpscFeaturedSubModuleCard(
                    module = computerModule,
                    unitCount = compUnits,
                    progressPercent = compPct,
                    isSelected = isKpscSelected && selectedSubjectFilter.equals(computerModule.subjectId, ignoreCase = true),
                    isDark = isDark,
                    onClick = { onSelectModule(computerModule.subjectId) }
                )

                // Inline quick-launch units strip when one of the KPSC sub-modules is selected
                val activeSubjectTemplate = if (isKpscSelected && selectedSubjectFilter != "all") {
                    kpscSubjectsById[selectedSubjectFilter]
                } else null

                AnimatedVisibility(
                    visible = activeSubjectTemplate != null,
                    enter = expandVertically(animationSpec = spring(stiffness = Spring.StiffnessMediumLow)) + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    activeSubjectTemplate?.let { subj ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(
                                    if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC)
                                )
                                .border(
                                    1.dp,
                                    Color(subj.colorHex).copy(alpha = 0.35f),
                                    RoundedCornerShape(16.dp)
                                )
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = subj.title,
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "${subj.units.size} Units",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(subj.colorHex),
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }

                            subj.units.forEach { unit ->
                                Surface(
                                    onClick = { onStartQuiz(15, subj.id, unit.id, unit.name) },
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.surface,
                                    border = BorderStroke(
                                        1.dp,
                                        if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .heightIn(min = 48.dp)
                                        .testTag("kpsc_quick_unit_${subj.id}_${unit.id}")
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 12.dp, vertical = 10.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = unit.name,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onSurface,
                                                maxLines = 2,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = "${unit.totalQuestions} Qs • ${unit.difficulty}",
                                                fontSize = 10.5.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Box(
                                            modifier = Modifier
                                                .size(32.dp)
                                                .clip(CircleShape)
                                                .background(Color(subj.colorHex).copy(alpha = 0.14f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Rounded.PlayArrow,
                                                contentDescription = "Start ${unit.name}",
                                                tint = Color(subj.colorHex),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Secondary quick links to additional KPSC papers (Grammar, History, Polity, Economy, CSAT)
                HorizontalDivider(
                    color = if (isDark) Color(0xFF334155) else Color(0xFFF1F5F9),
                    modifier = Modifier.padding(top = 2.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "More:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        softWrap = false
                    )
                    extraKpscShortcuts.forEach { (subId, label) ->
                        val chipSelected = isKpscSelected && selectedSubjectFilter.equals(subId, ignoreCase = true)
                        Surface(
                            onClick = { onSelectModule(subId) },
                            shape = RoundedCornerShape(10.dp),
                            color = if (chipSelected) {
                                Color(0xFF4F46E5)
                            } else if (isDark) {
                                Color(0xFF1E293B)
                            } else {
                                Color(0xFFF1F5F9)
                            },
                            modifier = Modifier
                                .heightIn(min = 34.dp)
                                .testTag("kpsc_extra_chip_$subId")
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = label,
                                    fontSize = 11.sp,
                                    fontWeight = if (chipSelected) FontWeight.Bold else FontWeight.SemiBold,
                                    color = if (chipSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    softWrap = false
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
private fun KpscSubModuleCard(
    module: KpscSubModuleUi,
    unitCount: Int,
    progressPercent: Int,
    isSelected: Boolean,
    isDark: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor by animateColorAsState(
        targetValue = when {
            isSelected -> module.accentColor.copy(alpha = if (isDark) 0.24f else 0.12f)
            isDark -> Color(0xFF1E293B)
            else -> Color(0xFFF8FAFC)
        },
        label = "kpsc_submodule_bg"
    )
    val borderColor by animateColorAsState(
        targetValue = when {
            isSelected -> module.accentColor
            isDark -> Color(0xFF334155)
            else -> Color(0xFFE2E8F0)
        },
        label = "kpsc_submodule_border"
    )
    val title = stringResource(module.titleResId)

    Surface(
        modifier = modifier
            .heightIn(min = 96.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .testTag("kpsc_submodule_${module.subjectId}"),
        shape = RoundedCornerShape(16.dp),
        color = bgColor,
        border = BorderStroke(if (isSelected) 1.5.dp else 1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(module.accentColor.copy(alpha = 0.16f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = module.icon,
                        contentDescription = title,
                        tint = module.accentColor,
                        modifier = Modifier.size(19.dp)
                    )
                }

                if (isSelected) {
                    Icon(
                        imageVector = Icons.Rounded.CheckCircle,
                        contentDescription = "Selected",
                        tint = module.accentColor,
                        modifier = Modifier.size(18.dp)
                    )
                } else {
                    Text(
                        text = "${unitCount}U",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = title,
                    fontSize = 13.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = module.kannadaLabel,
                    fontSize = 11.sp,
                    lineHeight = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            LinearProgressIndicator(
                progress = { (progressPercent / 100f).coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp)),
                color = module.accentColor,
                trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
            )
        }
    }
}

@Composable
private fun KpscFeaturedSubModuleCard(
    module: KpscSubModuleUi,
    unitCount: Int,
    progressPercent: Int,
    isSelected: Boolean,
    isDark: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor by animateColorAsState(
        targetValue = when {
            isSelected -> module.accentColor.copy(alpha = if (isDark) 0.24f else 0.12f)
            isDark -> Color(0xFF1E293B)
            else -> Color(0xFFF8FAFC)
        },
        label = "kpsc_featured_bg"
    )
    val borderColor by animateColorAsState(
        targetValue = when {
            isSelected -> module.accentColor
            isDark -> Color(0xFF334155)
            else -> Color(0xFFE2E8F0)
        },
        label = "kpsc_featured_border"
    )
    val title = stringResource(module.titleResId)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 68.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .testTag("kpsc_submodule_${module.subjectId}"),
        shape = RoundedCornerShape(16.dp),
        color = bgColor,
        border = BorderStroke(if (isSelected) 1.5.dp else 1.dp, borderColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 11.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(module.accentColor.copy(alpha = 0.16f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = module.icon,
                        contentDescription = title,
                        tint = module.accentColor,
                        modifier = Modifier.size(21.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "${module.kannadaLabel} • $unitCount Units • $progressPercent%",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = if (isSelected) Icons.Rounded.CheckCircle else Icons.AutoMirrored.Rounded.ArrowForward,
                contentDescription = if (isSelected) "Selected" else "Open $title",
                tint = module.accentColor,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

package com.example.ui.admin

import android.widget.Toast
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.QuizViewModel
import com.example.auth.AuthUiState
import com.example.auth.AuthUser
import com.example.auth.UserRole
import com.example.data.*
import java.util.UUID

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AdminScreen(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    // Room Database Questions
    val roomQuestions by viewModel.allRoomQuestions.collectAsState()
    val isCentralPoolSyncing by viewModel.isCentralPoolSyncing.collectAsState()
    val cloudSyncState by viewModel.cloudSyncState.collectAsState()
    val isCloudSyncAvailable by viewModel.isCloudSyncAvailable.collectAsState()
    val notifications by viewModel.notifications.collectAsState()
    val activeAds by viewModel.activeAds.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val authState by viewModel.authUiState.collectAsState()
    val currentUserRole by viewModel.currentUserRole.collectAsState()

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    var activeAdminTab by remember { mutableStateOf("ANALYTICS") } // "ANALYTICS", "QUESTIONS", "NOTIFICATIONS", "ADS", "FACULTY"

    // Search, Filter, and Pagination States for Room Questions
    var searchQuery by remember { mutableStateOf("") }
    var questionsPage by remember { mutableIntStateOf(0) }
    val pageSize = 50
    var selectedStdFilter by remember { mutableStateOf<Int?>(null) }
    var selectedSubjectFilter by remember { mutableStateOf<String?>(null) }
    var selectedDifficultyFilter by remember { mutableStateOf<String?>(null) }

    // Dialog States for Update & Delete
    var editingQuestion by remember { mutableStateOf<QuizQuestionEntity?>(null) }
    var deletingQuestion by remember { mutableStateOf<QuizQuestionEntity?>(null) }

    // CREATE Form States
    var qStd by remember { mutableIntStateOf(6) }
    var qSubject by remember { mutableStateOf("math") }
    var qUnit by remember { mutableIntStateOf(1) }
    var qUnitName by remember { mutableStateOf("Unit 1") }
    var qType by remember { mutableStateOf("MCQ") } // "MCQ", "TF", "FILL", "MATCH"
    var qDifficulty by remember { mutableStateOf("Medium") } // "Easy", "Medium", "Hard"
    var qPoints by remember { mutableIntStateOf(10) }
    var qText by remember { mutableStateOf("") }
    var qOptionsStr by remember { mutableStateOf("") }
    var qAnswer by remember { mutableStateOf("") }
    var qExplanation by remember { mutableStateOf("") }
    var qHint by remember { mutableStateOf("") }
    var showCreateForm by remember { mutableStateOf(false) }
    var showBulkUploadDialog by remember { mutableStateOf(false) }
    var showAdminPanelScreen by remember { mutableStateOf(false) }
    var showResetConfirmDialog by remember { mutableStateOf(false) }

    if (showAdminPanelScreen) {
        AdminPanelScreen(
            viewModel = viewModel,
            modifier = modifier,
            onNavigateBack = { showAdminPanelScreen = false }
        )
        return
    }

    // Form: Notification inputs
    var notifTitle by remember { mutableStateOf("") }
    var notifDesc by remember { mutableStateOf("") }
    var notifCategory by remember { mutableStateOf("General") }

    // Form: Advertisement inputs
    var adTitle by remember { mutableStateOf("") }
    var adSubtitle by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val authenticatedUser = (authState as? AuthUiState.Authenticated)?.user

        if (authenticatedUser == null) {
            // Unauthenticated view: Tailored Firebase Auth Sign-In Portal
            AdminAuthGate(
                viewModel = viewModel,
                isDark = isDark
            )
        } else if (currentUserRole == UserRole.STUDENT) {
            // Authenticated as Student: Permission Restricted View
            StudentAccessRestricted(
                user = authenticatedUser,
                viewModel = viewModel,
                isDark = isDark
            )
        } else {
            // --- 1. VERIFIED FACULTY HEADER BANNER ---
            FacultyHeaderBar(
                user = authenticatedUser,
                role = currentUserRole,
                viewModel = viewModel,
                isDark = isDark
            )

            // --- 2. ADMIN NAVIGATION TABS ---
            val tabList = mutableListOf(
                "ANALYTICS" to "📊 Class Analytics & Reports",
                "QUESTIONS" to "📚 Questions (${roomQuestions.size})",
                "NOTIFICATIONS" to "📢 Alerts (${notifications.size})",
                "ADS" to "🎯 Banners (${activeAds.size})"
            )
            if (currentUserRole == UserRole.ADMIN) {
                tabList.add("FACULTY" to "👥 Faculty & Roles")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9))
                    .border(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0), RoundedCornerShape(16.dp))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                tabList.forEach { (key, label) ->
                    val active = activeAdminTab == key
                    Button(
                        onClick = { activeAdminTab = key },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (active) Color(0xFF4F46E5) else Color.Transparent,
                            contentColor = if (active) Color.White else subtitleColor
                        ),
                        modifier = Modifier
                            .height(38.dp)
                            .testTag("admin_tab_$key"),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp)
                    ) {
                        Text(text = label, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            }

            HorizontalDivider(color = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

            // --- 3. TAB CONTENT ---
            when (activeAdminTab) {
                "ANALYTICS" -> {
                    ClassAnalyticsAndReportsView(
                        viewModel = viewModel,
                        isDark = isDark
                    )
                }
                "FACULTY" -> {
                    AdminFacultyManagementTab(
                        user = authenticatedUser,
                        viewModel = viewModel,
                        isDark = isDark
                    )
                }
                "QUESTIONS" -> {
                // Central Cloud Pool (Firebase Firestore) & Local Room Status Banner
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("central_cloud_pool_card"),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF)
                    ),
                    border = BorderStroke(1.2.dp, if (isDark) Color(0xFF4338CA) else Color(0xFFC7D2FE))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
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
                                        .size(38.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color(0xFF4F46E5).copy(alpha = 0.15f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("🌐", fontSize = 20.sp)
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    FlowRow(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Text(
                                            text = "Central Question Pool",
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 15.sp,
                                            color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF312E81)
                                        )
                                        Badge(
                                            containerColor = if (isCloudSyncAvailable) Color(0xFF10B981) else Color(0xFFF59E0B),
                                            contentColor = Color.White
                                        ) {
                                            Text(if (isCloudSyncAvailable) "Cloud Synced" else "Offline Cache", fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }
                                    Text(
                                        text = "${roomQuestions.size} active questions across Room & Firebase Firestore",
                                        fontSize = 12.sp,
                                        color = if (isDark) Color(0xFFC7D2FE) else Color(0xFF4338CA),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            if (isCentralPoolSyncing) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(24.dp),
                                    strokeWidth = 2.5.dp,
                                    color = Color(0xFF4F46E5)
                                )
                            }
                        }

                        // Sync Operations Button Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            // 1. Sync to Cloud
                            FilledTonalButton(
                                onClick = {
                                    viewModel.syncAllRoomQuestionsToCloud { count, success ->
                                        if (success) {
                                            Toast.makeText(context, "✅ Synced $count questions to Central Cloud Pool!", Toast.LENGTH_SHORT).show()
                                        } else {
                                            Toast.makeText(context, "Offline mode: Questions saved locally to Room", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                },
                                enabled = !isCentralPoolSyncing,
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.filledTonalButtonColors(
                                    containerColor = Color(0xFF4F46E5),
                                    contentColor = Color.White
                                ),
                                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(38.dp)
                                    .testTag("sync_to_cloud_pool_button")
                            ) {
                                Icon(Icons.Default.CloudUpload, contentDescription = null, modifier = Modifier.size(15.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Sync Cloud",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            // 2. Pull from Cloud
                            FilledTonalButton(
                                onClick = {
                                    viewModel.fetchAndImportCentralQuestionsFromCloud { count, success ->
                                        if (success) {
                                            Toast.makeText(context, "📥 Imported $count questions from Central Cloud Pool!", Toast.LENGTH_SHORT).show()
                                        } else {
                                            Toast.makeText(context, "Loaded questions from device cache", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                },
                                enabled = !isCentralPoolSyncing,
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.filledTonalButtonColors(
                                    containerColor = Color(0xFF0D9488),
                                    contentColor = Color.White
                                ),
                                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(38.dp)
                                    .testTag("pull_from_cloud_pool_button")
                            ) {
                                Icon(Icons.Default.CloudDownload, contentDescription = null, modifier = Modifier.size(15.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Pull Cloud",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            // 3. New Question
                            Button(
                                onClick = { showCreateForm = !showCreateForm },
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (showCreateForm) Color(0xFF64748B) else Color(0xFF7C3AED)
                                ),
                                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(38.dp)
                                    .testTag("toggle_create_question_button")
                            ) {
                                Icon(
                                    imageVector = if (showCreateForm) Icons.Default.Close else Icons.Default.Add,
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (showCreateForm) "Hide" else "New",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        // Secondary actions: Bulk Upload & Reset Curriculum
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedButton(
                                onClick = { showAdminPanelScreen = true },
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(36.dp)
                                    .testTag("open_bulk_upload_dialog_button"),
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                            ) {
                                Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(14.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Bulk CSV/Excel", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                            }

                            OutlinedButton(
                                onClick = { showResetConfirmDialog = true },
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(36.dp)
                                    .testTag("reset_question_pool_button"),
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                            ) {
                                Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(14.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Reset Standard", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

                // Rapid Content Expansion: Bulk CSV & Excel Question Bank Upload Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("bulk_csv_excel_upload_banner_card"),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF0F291E) else Color(0xFFECFDF5)
                    ),
                    border = BorderStroke(1.5.dp, if (isDark) Color(0xFF059669) else Color(0xFFA7F3D0))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f, fill = false)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color(0xFF10B981).copy(alpha = 0.2f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("📊", fontSize = 22.sp)
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "Rapid Content Expansion",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF065F46),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = "Upload Question Banks via CSV or Excel (.xlsx)",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = if (isDark) Color(0xFF6EE7B7) else Color(0xFF047857),
                                        fontWeight = FontWeight.SemiBold,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = Color(0xFF10B981).copy(alpha = 0.2f),
                                border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f))
                            ) {
                                Text(
                                    text = "EXCEL & CSV",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF047857),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Text(
                            text = "Quickly expand your quiz curriculum across standards 6-10, Morarji, and NMMS by uploading spreadsheets in bulk. Supports multi-choice questions with auto-column matching, custom chapters, and difficulty grading.",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 17.sp
                        )

                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = { showAdminPanelScreen = true },
                                modifier = Modifier
                                    .height(44.dp)
                                    .testTag("launch_csv_excel_uploader_button"),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF059669)
                                )
                            ) {
                                Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Open Firestore Admin Panel",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            OutlinedButton(
                                onClick = {
                                    val clipboard = context.getSystemService(android.content.Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                                    clipboard.setPrimaryClip(android.content.ClipData.newPlainText("CSV Template", com.example.data.BulkQuestionParser.SAMPLE_CSV_TEMPLATE))
                                    android.widget.Toast.makeText(context, "Copied sample CSV template to clipboard!", android.widget.Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier.height(44.dp),
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(1.dp, Color(0xFF059669))
                            ) {
                                Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Copy Template",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF059669),
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }

                // ==================== C: CREATE OPERATION (NEW QUESTION FORM) ====================
                AnimatedVisibility(
                    visible = showCreateForm,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("admin_create_question_card"),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = cardBorder
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "➕ Create New Quiz Question (Room DB)",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor
                                )
                                Text(
                                    text = "CRUD: Create",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color(0xFF10B981),
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            // 1. Grade Standard
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("Standard Grade:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = subtitleColor)
                                FlowRow(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    listOf(6, 7, 8, 9, 10, 11, 12).forEach { stdVal ->
                                        val isSelected = qStd == stdVal
                                        val labelText = when (stdVal) {
                                            11 -> "Morarji"
                                            12 -> "NMMS"
                                            else -> "Std $stdVal"
                                        }
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = { qStd = stdVal },
                                            label = { Text(labelText, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                                            modifier = Modifier.testTag("create_std_$stdVal")
                                        )
                                    }
                                }
                            }

                            // 2. Course Subject
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("Course Subject:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = subtitleColor)
                                FlowRow(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    listOf("math", "science", "social", "english", "kannada", "hindi", "computer").forEach { subj ->
                                        val isSelected = qSubject == subj
                                        val color = Color(QuizStaticData.SUBJECT_COLORS[subj] ?: 0xFF6366F1)
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = { qSubject = subj },
                                            label = {
                                                Text(
                                                    text = subj.replaceFirstChar { it.uppercase() },
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = if (isSelected) color else subtitleColor
                                                )
                                            },
                                            modifier = Modifier.testTag("create_sub_$subj")
                                        )
                                    }
                                }
                            }

                            // 3. Unit Number, Unit Name & Points
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                OutlinedTextField(
                                    value = qUnit.toString(),
                                    onValueChange = { qUnit = it.toIntOrNull() ?: 1 },
                                    label = { Text("Unit #", fontSize = 11.sp) },
                                    modifier = Modifier.weight(1f).testTag("create_q_unit_input"),
                                    shape = RoundedCornerShape(12.dp)
                                )

                                OutlinedTextField(
                                    value = qUnitName,
                                    onValueChange = { qUnitName = it },
                                    label = { Text("Unit Title", fontSize = 11.sp) },
                                    modifier = Modifier.weight(2f).testTag("create_q_unit_name_input"),
                                    shape = RoundedCornerShape(12.dp)
                                )

                                OutlinedTextField(
                                    value = qPoints.toString(),
                                    onValueChange = { qPoints = it.toIntOrNull() ?: 10 },
                                    label = { Text("Points", fontSize = 11.sp) },
                                    modifier = Modifier.weight(1f).testTag("create_q_points_input"),
                                    shape = RoundedCornerShape(12.dp)
                                )
                            }

                            // 4. Format Type
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("Format Type:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = subtitleColor)
                                FlowRow(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    listOf("MCQ" to "Multiple Choice (MCQ)", "TF" to "True / False", "FILL" to "Fill in Blanks", "MATCH" to "Match Following").forEach { (t, label) ->
                                        val isSelected = qType == t
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = {
                                                qType = t
                                                if (t == "TF" && qOptionsStr.isBlank()) {
                                                    qOptionsStr = "True|False"
                                                }
                                            },
                                            label = { Text(label, fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                                        )
                                    }
                                }
                            }

                            // 5. Difficulty Level
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("Difficulty Level:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = subtitleColor)
                                FlowRow(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    listOf("Easy", "Medium", "Hard").forEach { diff ->
                                        val isSelected = qDifficulty == diff
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = { qDifficulty = diff },
                                            label = { Text(diff, fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                                        )
                                    }
                                }
                            }

                            // 5. Question Text
                            OutlinedTextField(
                                value = qText,
                                onValueChange = { qText = it },
                                label = { Text("Question Prompt / Statement *") },
                                placeholder = { Text("e.g. What is the value of 5 squared?") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("admin_q_text_input"),
                                shape = RoundedCornerShape(12.dp),
                                minLines = 2
                            )

                            // 6. Options / Choices
                            OutlinedTextField(
                                value = qOptionsStr,
                                onValueChange = { qOptionsStr = it },
                                label = { Text("Choices (pipe-separated: Choice A|Choice B|Choice C|Choice D) *") },
                                placeholder = { Text("10|20|25|30") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("admin_q_options_input"),
                                shape = RoundedCornerShape(12.dp)
                            )

                            // 7. Correct Answer
                            OutlinedTextField(
                                value = qAnswer,
                                onValueChange = { qAnswer = it },
                                label = { Text("Correct Answer *") },
                                placeholder = { Text("e.g. 25 (must match one of the choices)") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("admin_q_answer_input"),
                                shape = RoundedCornerShape(12.dp)
                            )

                            // 8. Explanation & Hint
                            OutlinedTextField(
                                value = qExplanation,
                                onValueChange = { qExplanation = it },
                                label = { Text("Educational Explanation") },
                                placeholder = { Text("Explain why this is correct for student review") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("admin_q_expl_input"),
                                shape = RoundedCornerShape(12.dp)
                            )

                            OutlinedTextField(
                                value = qHint,
                                onValueChange = { qHint = it },
                                label = { Text("Student Clue / Hint (optional)") },
                                placeholder = { Text("e.g. Multiply 5 by itself") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("admin_q_hint_input"),
                                shape = RoundedCornerShape(12.dp)
                            )

                            // Submit Button
                            Button(
                                onClick = {
                                    val trimmedText = qText.trim()
                                    val trimmedAnswer = qAnswer.trim()
                                    if (trimmedText.isEmpty() || trimmedAnswer.isEmpty()) {
                                        Toast.makeText(context, "Please provide Question Text and Correct Answer", Toast.LENGTH_SHORT).show()
                                        return@Button
                                    }

                                    val generatedId = "room_q_${qStd}_${qSubject}_${qUnit}_${System.currentTimeMillis() % 100000}"
                                    val newEntity = QuizQuestionEntity(
                                        id = generatedId,
                                        stdId = qStd,
                                        subjectId = qSubject,
                                        unitId = qUnit,
                                        unitName = qUnitName.ifBlank { "Unit $qUnit" },
                                        type = qType,
                                        questionText = trimmedText,
                                        optionsString = qOptionsStr.trim(),
                                        correctAnswer = trimmedAnswer,
                                        explanation = qExplanation.trim(),
                                        difficulty = qDifficulty,
                                        hint = qHint.trim(),
                                        points = qPoints,
                                        isCustom = true,
                                        createdAt = System.currentTimeMillis()
                                    )

                                    viewModel.insertRoomQuestion(newEntity)
                                    Toast.makeText(context, "Question added to Room database!", Toast.LENGTH_SHORT).show()

                                    // Reset input text
                                    qText = ""
                                    qOptionsStr = ""
                                    qAnswer = ""
                                    qExplanation = ""
                                    qHint = ""
                                    showCreateForm = false
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                                    .testTag("admin_save_question_button"),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(Icons.Default.AddCircle, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Save Question to Room Database", fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }

                // ==================== R: READ OPERATION (FILTER & LIST) ====================
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    // Search Bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { 
                            searchQuery = it 
                            questionsPage = 0
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("admin_search_input"),
                        placeholder = { Text("Search by question prompt or ID...") },
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = "Search", tint = subtitleColor)
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Close, contentDescription = "Clear", tint = subtitleColor)
                                }
                            }
                        },
                        shape = RoundedCornerShape(14.dp),
                        singleLine = true
                    )

                    // Standard Filters with FlowRow Wrap
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text("Std:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = subtitleColor)
                        FilterChip(
                            selected = selectedStdFilter == null,
                            onClick = { selectedStdFilter = null },
                            label = { Text("All", fontSize = 11.sp) },
                            modifier = Modifier.testTag("filter_std_all")
                        )
                        listOf(6 to "Std 6", 7 to "Std 7", 8 to "Std 8", 9 to "Std 9", 10 to "Std 10", 11 to "Morarji", 12 to "NMMS").forEach { (std, label) ->
                            FilterChip(
                                selected = selectedStdFilter == std,
                                onClick = { selectedStdFilter = if (selectedStdFilter == std) null else std },
                                label = { Text(label, fontSize = 11.sp) },
                                modifier = Modifier.testTag("filter_std_$std")
                            )
                        }
                    }

                    // Subject Filters with FlowRow Wrap
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text("Subject:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = subtitleColor)
                        FilterChip(
                            selected = selectedSubjectFilter == null,
                            onClick = { selectedSubjectFilter = null },
                            label = { Text("All Subjects", fontSize = 11.sp) },
                            modifier = Modifier.testTag("filter_subj_all")
                        )
                        listOf("math", "science", "social", "english", "kannada", "hindi", "computer").forEach { subj ->
                            FilterChip(
                                selected = selectedSubjectFilter == subj,
                                onClick = { selectedSubjectFilter = if (selectedSubjectFilter == subj) null else subj },
                                label = { Text(subj.replaceFirstChar { it.uppercase() }, fontSize = 11.sp) },
                                modifier = Modifier.testTag("filter_subj_$subj")
                            )
                        }
                    }
                }

                // Filter logic
                val filteredQuestions = remember(roomQuestions, searchQuery, selectedStdFilter, selectedSubjectFilter, selectedDifficultyFilter) {
                    roomQuestions.filter { q ->
                        val matchesSearch = searchQuery.isBlank() ||
                                q.questionText.contains(searchQuery, ignoreCase = true) ||
                                q.id.contains(searchQuery, ignoreCase = true)
                        val matchesStd = selectedStdFilter == null || q.stdId == selectedStdFilter
                        val matchesSubject = selectedSubjectFilter == null || q.subjectId.equals(selectedSubjectFilter, ignoreCase = true)
                        val matchesDifficulty = selectedDifficultyFilter == null || q.difficulty.equals(selectedDifficultyFilter, ignoreCase = true)
                        matchesSearch && matchesStd && matchesSubject && matchesDifficulty
                    }
                }

                // Questions Counter Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Questions in Room (${filteredQuestions.size} shown / ${roomQuestions.size} total)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = titleColor
                    )
                }

                if (filteredQuestions.isEmpty()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("admin_no_questions_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = cardBorder
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("🔍", fontSize = 32.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "No questions match your filter",
                                fontWeight = FontWeight.Bold,
                                color = titleColor
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Try clearing filters or add a new question using the button above.",
                                fontSize = 12.sp,
                                color = subtitleColor
                            )
                        }
                    }
                } else {
                    val totalPages = maxOf(1, (filteredQuestions.size + pageSize - 1) / pageSize)
                    val safePage = questionsPage.coerceIn(0, totalPages - 1)
                    val paginatedQuestions = filteredQuestions.drop(safePage * pageSize).take(pageSize)

                    // Pagination Control Bar (Top)
                    if (totalPages > 1) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedButton(
                                onClick = { if (safePage > 0) questionsPage = safePage - 1 },
                                enabled = safePage > 0,
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("◀ Previous", fontSize = 12.sp)
                            }
                            Text(
                                text = "Page ${safePage + 1} of $totalPages (${filteredQuestions.size} questions)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = subtitleColor
                            )
                            OutlinedButton(
                                onClick = { if (safePage < totalPages - 1) questionsPage = safePage + 1 },
                                enabled = safePage < totalPages - 1,
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("Next ▶", fontSize = 12.sp)
                            }
                        }
                    }

                    // List of Questions with Edit and Delete (Paginated)
                    paginatedQuestions.forEach { question ->
                        RoomQuestionAdminCard(
                            question = question,
                            isDark = isDark,
                            cardBorder = cardBorder,
                            onEdit = { editingQuestion = question },
                            onDelete = { deletingQuestion = question }
                        )
                    }

                    // Pagination Control Bar (Bottom)
                    if (totalPages > 1) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedButton(
                                onClick = { if (safePage > 0) questionsPage = safePage - 1 },
                                enabled = safePage > 0,
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("◀ Previous", fontSize = 12.sp)
                            }
                            Text(
                                text = "Page ${safePage + 1} of $totalPages",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = subtitleColor
                            )
                            OutlinedButton(
                                onClick = { if (safePage < totalPages - 1) questionsPage = safePage + 1 },
                                enabled = safePage < totalPages - 1,
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("Next ▶", fontSize = 12.sp)
                            }
                        }
                    }
                }
            }

            "NOTIFICATIONS" -> {
                // NOTIFICATIONS BROADCAST FORM
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = cardBorder
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text(
                            text = "Broadcast Bulletin / Class Alert",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor
                        )

                        OutlinedTextField(
                            value = notifTitle,
                            onValueChange = { notifTitle = it },
                            label = { Text("Alert Title") },
                            placeholder = { Text("e.g. 📢 Math Olympiad registration open") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = notifDesc,
                            onValueChange = { notifDesc = it },
                            label = { Text("Alert Details / Descriptions") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            listOf("General", "Exam", "Daily Challenge", "System").forEach { cat ->
                                val act = notifCategory == cat
                                Surface(
                                    onClick = { notifCategory = cat },
                                    shape = RoundedCornerShape(12.dp),
                                    color = if (act) Color(0xFF4F46E5).copy(alpha = 0.16f) else if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                                    border = BorderStroke(1.dp, if (act) Color(0xFF4F46E5) else if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
                                ) {
                                    Text(
                                        text = cat,
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (act) Color(0xFF4F46E5) else subtitleColor,
                                        maxLines = 1,
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                                    )
                                }
                            }
                        }

                        Button(
                            onClick = {
                                if (notifTitle.isNotEmpty()) {
                                    viewModel.createAdminNotification(notifTitle, notifDesc, notifCategory)
                                    notifTitle = ""
                                    notifDesc = ""
                                    Toast.makeText(context, "Bulletin published!", Toast.LENGTH_SHORT).show()
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Broadcast Alert Bulletin", fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Broadcasted Bulletins (${notifications.size})",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor
                )

                notifications.forEach { bullet ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = cardBorder
                    ) {
                        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "[${bullet.category}]",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF4F46E5)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = bullet.title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = titleColor
                                )
                                Text(
                                    text = bullet.description,
                                    fontSize = 12.sp,
                                    color = subtitleColor
                                )
                            }
                            IconButton(onClick = { viewModel.removeNotification(bullet.id) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFFEF4444))
                            }
                        }
                    }
                }
            }

            "ADS" -> {
                // ANNOUNCEMENTS ADS CABINETS MANAGEMENT FORM
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = cardBorder
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text(
                            text = "Publish Educational Banner Campaign",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = titleColor
                        )

                        OutlinedTextField(
                            value = adTitle,
                            onValueChange = { adTitle = it },
                            label = { Text("Banner Campaign Title") },
                            placeholder = { Text("e.g. Science Olympiad 2026") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = adSubtitle,
                            onValueChange = { adSubtitle = it },
                            label = { Text("Banner Campaign Subtitle") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        Button(
                            onClick = {
                                if (adTitle.isNotEmpty()) {
                                    viewModel.createAdminAd(adTitle, adSubtitle, "campaign_banner")
                                    adTitle = ""
                                    adSubtitle = ""
                                    Toast.makeText(context, "Campaign published!", Toast.LENGTH_SHORT).show()
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Publish Banner Campaign", fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Campus Ad Campaigns (${activeAds.size})",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor
                )

                activeAds.forEach { ad ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = cardBorder
                    ) {
                        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = ad.title,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = titleColor
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = ad.subtitle,
                                    fontSize = 12.sp,
                                    color = subtitleColor
                                )
                            }
                            IconButton(onClick = { viewModel.removeAd(ad.id) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFFEF4444))
                            }
                        }
                    }
                }
            }
        }
        }
    }

    // ==================== B: BULK QUESTIONS UPLOAD DIALOG ====================
    if (showBulkUploadDialog) {
        BulkQuestionUploadDialog(
            viewModel = viewModel,
            isDark = isDark,
            onDismiss = { showBulkUploadDialog = false }
        )
    }

    // ==================== U: UPDATE DIALOG ====================
    editingQuestion?.let { question ->
        EditQuestionDialog(
            question = question,
            onDismiss = { editingQuestion = null },
            onSave = { updated ->
                viewModel.updateRoomQuestion(updated)
                editingQuestion = null
                Toast.makeText(context, "Question updated in Room DB!", Toast.LENGTH_SHORT).show()
            }
        )
    }

    // ==================== D: DELETE CONFIRMATION DIALOG ====================
    deletingQuestion?.let { question ->
        AlertDialog(
            onDismissRequest = { deletingQuestion = null },
            title = {
                Text("Delete Question from Room DB?", fontWeight = FontWeight.Bold)
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("This will permanently remove this question from your device's local Room database:")
                    Text(
                        text = "\"${question.questionText}\"",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "ID: ${question.id} • Std ${question.stdId} • ${question.subjectId.uppercase()} • Unit ${question.unitId}",
                        fontSize = 11.sp,
                        color = subtitleColor
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteRoomQuestion(question.id)
                        deletingQuestion = null
                        Toast.makeText(context, "Question deleted from Room database", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                    modifier = Modifier.testTag("confirm_delete_question_button")
                ) {
                    Text("Delete Permanently")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { deletingQuestion = null },
                    modifier = Modifier.testTag("cancel_delete_question_button")
                ) {
                    Text("Cancel")
                }
            },
            modifier = Modifier.testTag("delete_question_dialog")
        )
    }

    // ==================== R: RESET CONFIRMATION DIALOG ====================
    if (showResetConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showResetConfirmDialog = false },
            title = {
                Text("Reset Central Question Bank?", fontWeight = FontWeight.Bold)
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("This will restore the central question bank back to the official standard syllabus curriculum:")
                    Text(
                        text = "• All official curriculum units (Std 6 to 10)\n• High-yield questions with verified answers\n• Kannada & English subject curriculum",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.resetQuestionBankToCurriculum { count ->
                            showResetConfirmDialog = false
                            Toast.makeText(context, "Question bank reset to official curriculum ($count questions)", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                    modifier = Modifier.testTag("confirm_reset_curriculum_button")
                ) {
                    Text("Reset Curriculum")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { showResetConfirmDialog = false },
                    modifier = Modifier.testTag("cancel_reset_curriculum_button")
                ) {
                    Text("Cancel")
                }
            },
            modifier = Modifier.testTag("reset_curriculum_dialog")
        )
    }
}

/**
 * Question Card with Read, Edit, and Delete action buttons
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun RoomQuestionAdminCard(
    question: QuizQuestionEntity,
    isDark: Boolean,
    cardBorder: BorderStroke,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    val subjectColor = Color(QuizStaticData.SUBJECT_COLORS[question.subjectId] ?: 0xFF6366F1)
    val diffColor = when (question.difficulty.lowercase()) {
        "easy" -> Color(0xFF10B981)
        "hard" -> Color(0xFFEF4444)
        else -> Color(0xFFF59E0B)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("room_question_item_${question.id}"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header: Subject, Standard, Unit, Difficulty, and Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(subjectColor)
                    )
                    Text(
                        text = "${question.subjectId.replaceFirstChar { it.uppercase() }} • Std ${question.stdId} • U${question.unitId}",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = subjectColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                FlowRow(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Type Badge
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF6366F1).copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = question.type,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6366F1),
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }

                    // Difficulty Badge
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = diffColor.copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = question.difficulty,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = diffColor,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }

                    // Edit Button
                    IconButton(
                        onClick = onEdit,
                        modifier = Modifier
                            .size(28.dp)
                            .testTag("edit_question_${question.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Question",
                            tint = Color(0xFF4F46E5),
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    // Delete Button
                    IconButton(
                        onClick = onDelete,
                        modifier = Modifier
                            .size(28.dp)
                            .testTag("delete_question_${question.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete Question",
                            tint = Color(0xFFEF4444),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Question Text Prompt
            Text(
                text = question.questionText,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Options List
            if (question.optionsString.isNotBlank()) {
                val options = question.optionsString.split("|")
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    options.forEachIndexed { idx, opt ->
                        val isCorrect = opt.trim().equals(question.correctAnswer.trim(), ignoreCase = true)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    if (isCorrect) Color(0xFF10B981).copy(alpha = 0.12f)
                                    else if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
                                )
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${('A' + idx)}. $opt",
                                fontSize = 12.sp,
                                fontWeight = if (isCorrect) FontWeight.Bold else FontWeight.Normal,
                                color = if (isCorrect) Color(0xFF059669) else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                            if (isCorrect) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Correct Answer",
                                    tint = Color(0xFF10B981),
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }
                }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Correct Answer: ",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = question.correctAnswer,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF10B981)
                    )
                }
            }

            // Explanation & Points
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (question.explanation.isNotBlank()) {
                    Text(
                        text = "💡 ${question.explanation}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${question.points} pts",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6366F1)
                )
            }
        }
    }
}

/**
 * Edit Question Dialog for Update operations
 */
@Composable
private fun EditQuestionDialog(
    question: QuizQuestionEntity,
    onDismiss: () -> Unit,
    onSave: (QuizQuestionEntity) -> Unit
) {
    var editStd by remember { mutableIntStateOf(question.stdId) }
    var editSubject by remember { mutableStateOf(question.subjectId) }
    var editUnit by remember { mutableIntStateOf(question.unitId) }
    var editUnitName by remember { mutableStateOf(question.unitName) }
    var editType by remember { mutableStateOf(question.type) }
    var editDifficulty by remember { mutableStateOf(question.difficulty) }
    var editPoints by remember { mutableIntStateOf(question.points) }
    var editText by remember { mutableStateOf(question.questionText) }
    var editOptions by remember { mutableStateOf(question.optionsString) }
    var editAnswer by remember { mutableStateOf(question.correctAnswer) }
    var editExplanation by remember { mutableStateOf(question.explanation) }
    var editHint by remember { mutableStateOf(question.hint) }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.9f)
                .testTag("edit_question_dialog")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Dialog Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "✏️ Edit Quiz Question",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = "ID: ${question.id}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                HorizontalDivider()

                // Scrollable Form Body
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Standard & Subject
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = editStd.toString(),
                            onValueChange = { editStd = it.toIntOrNull() ?: editStd },
                            label = { Text("Standard Grade") },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = editSubject,
                            onValueChange = { editSubject = it.lowercase().trim() },
                            label = { Text("Subject ID") },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }

                    // Unit & Points
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = editUnit.toString(),
                            onValueChange = { editUnit = it.toIntOrNull() ?: editUnit },
                            label = { Text("Unit #") },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = editUnitName,
                            onValueChange = { editUnitName = it },
                            label = { Text("Unit Name") },
                            modifier = Modifier.weight(2f),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = editPoints.toString(),
                            onValueChange = { editPoints = it.toIntOrNull() ?: editPoints },
                            label = { Text("Points") },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }

                    // Format & Difficulty
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = editType,
                            onValueChange = { editType = it.uppercase().trim() },
                            label = { Text("Type (MCQ, TF, MATCH, FILL)") },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = editDifficulty,
                            onValueChange = { editDifficulty = it },
                            label = { Text("Difficulty (Easy, Medium, Hard)") },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }

                    // Question Text
                    OutlinedTextField(
                        value = editText,
                        onValueChange = { editText = it },
                        label = { Text("Question Prompt *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("edit_q_text_input"),
                        shape = RoundedCornerShape(12.dp),
                        minLines = 2
                    )

                    // Options
                    OutlinedTextField(
                        value = editOptions,
                        onValueChange = { editOptions = it },
                        label = { Text("Choices (pipe-separated: A|B|C|D)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("edit_q_options_input"),
                        shape = RoundedCornerShape(12.dp)
                    )

                    // Correct Answer
                    OutlinedTextField(
                        value = editAnswer,
                        onValueChange = { editAnswer = it },
                        label = { Text("Correct Answer Value *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("edit_q_answer_input"),
                        shape = RoundedCornerShape(12.dp)
                    )

                    // Explanation
                    OutlinedTextField(
                        value = editExplanation,
                        onValueChange = { editExplanation = it },
                        label = { Text("Educational Explanation") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("edit_q_expl_input"),
                        shape = RoundedCornerShape(12.dp)
                    )

                    // Hint
                    OutlinedTextField(
                        value = editHint,
                        onValueChange = { editHint = it },
                        label = { Text("Clue / Hint") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("edit_q_hint_input"),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                HorizontalDivider()

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.testTag("cancel_edit_question_button")
                    ) {
                        Text("Cancel")
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = {
                            if (editText.isNotBlank() && editAnswer.isNotBlank()) {
                                val updated = question.copy(
                                    stdId = editStd,
                                    subjectId = editSubject,
                                    unitId = editUnit,
                                    unitName = editUnitName,
                                    type = editType,
                                    difficulty = editDifficulty,
                                    points = editPoints,
                                    questionText = editText.trim(),
                                    optionsString = editOptions.trim(),
                                    correctAnswer = editAnswer.trim(),
                                    explanation = editExplanation.trim(),
                                    hint = editHint.trim()
                                )
                                onSave(updated)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                        modifier = Modifier.testTag("save_edit_question_button")
                    ) {
                        Icon(Icons.Default.Save, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Save Changes")
                    }
                }
            }
        }
    }
}

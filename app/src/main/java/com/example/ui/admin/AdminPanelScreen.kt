@file:OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)

package com.example.ui.admin

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.QuizViewModel
import com.example.auth.AuthUiState
import com.example.auth.CloudSyncState
import com.example.auth.UserRole
import com.example.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

/**
 * Dedicated AdminPanelScreen for bulk-importing quiz questions into the Firestore database
 * via CSV or Excel (.xlsx) spreadsheets, raw content paste, and central pool inspection.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AdminPanelScreen(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {}
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Back handling
    BackHandler { onNavigateBack() }

    // Theme & State observation
    val isDark by viewModel.isDarkMode.collectAsState()
    val authState by viewModel.authUiState.collectAsState()
    val currentUserRole by viewModel.currentUserRole.collectAsState()
    val isCloudSyncAvailable by viewModel.isCloudSyncAvailable.collectAsState()
    val isCentralPoolSyncing by viewModel.isCentralPoolSyncing.collectAsState()
    val cloudSyncState by viewModel.cloudSyncState.collectAsState()
    val firestoreBulkProgress by viewModel.firestoreBulkProgress.collectAsState()
    val isBulkImportingToFirestore by viewModel.isBulkImportingToFirestore.collectAsState()
    val allRoomQuestions by viewModel.allRoomQuestions.collectAsState()

    // Navigation Tabs within Admin Panel:
    // 0: CSV/Excel Bulk Uploader
    // 1: Direct Paste / Editor
    // 2: Firestore Question Pool Browser
    // 3: Guidelines & Templates
    var selectedPanelTab by remember { mutableIntStateOf(0) }

    // Target Curriculum Config
    var targetStd by remember { mutableIntStateOf(6) }
    var targetSubject by remember { mutableStateOf(SubjectType.SCIENCE.id) }
    var targetUnitId by remember { mutableIntStateOf(1) }
    var targetUnitName by remember { mutableStateOf("Living vs Non-Living Things") }
    var targetDifficulty by remember { mutableStateOf("Medium") }
    var autoDetectCurriculumByRow by remember { mutableStateOf(true) }

    // Units based on selected standard and subject
    val availableUnits = remember(targetStd, targetSubject) {
        val stdData = QuizStaticData.standardsList.find { it.std == targetStd }
        val subData = stdData?.subjects?.find { it.id == targetSubject }
        subData?.units ?: emptyList()
    }

    LaunchedEffect(availableUnits) {
        if (availableUnits.isNotEmpty()) {
            val first = availableUnits.first()
            targetUnitId = first.id
            targetUnitName = first.name
            targetDifficulty = first.difficulty
        }
    }

    // File selection & parsing states
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    var selectedFileName by remember { mutableStateOf<String?>(null) }
    var detectedFileFormat by remember { mutableStateOf<String?>(null) }
    var isParsingFile by remember { mutableStateOf(false) }
    var parsedQuestions by remember { mutableStateOf<List<ParsedBulkQuestion>>(emptyList()) }
    var previewFilter by remember { mutableStateOf("ALL") } // "ALL", "VALID", "ISSUES"
    var previewSearchQuery by remember { mutableStateOf("") }
    var uploadSuccessSummary by remember { mutableStateOf<String?>(null) }

    // Upload Target Settings
    var uploadToFirestore by remember { mutableStateOf(true) }
    var saveToLocalRoom by remember { mutableStateOf(true) }

    // Direct Paste Tab State
    var rawPastedText by remember { mutableStateOf("") }

    // Firestore Browser State
    var cloudQuestions by remember { mutableStateOf<List<QuestionModel>>(emptyList()) }
    var isLoadingCloudQuestions by remember { mutableStateOf(false) }
    var cloudStdFilter by remember { mutableStateOf<Int?>(null) }
    var cloudSubjectFilter by remember { mutableStateOf<String?>(null) }
    var cloudSearchQuery by remember { mutableStateOf("") }

    // Edit Question Modal State
    var editingParsedIndex by remember { mutableStateOf<Int?>(null) }

    // Colors
    val surfaceColor = MaterialTheme.colorScheme.surface
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    val emeraldColor = Color(0xFF10B981)
    val indigoColor = Color(0xFF4F46E5)

    // Storage Access Framework Document Picker for CSV and Excel spreadsheets
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        if (uri != null) {
            selectedFileUri = uri
            uploadSuccessSummary = null
            isParsingFile = true
            coroutineScope.launch {
                try {
                    val result = withContext(Dispatchers.IO) {
                        BulkQuestionParser.parseFileUri(
                            context = context,
                            uri = uri,
                            stdId = targetStd,
                            subjectId = targetSubject,
                            unitId = targetUnitId,
                            unitName = targetUnitName,
                            defaultDifficulty = targetDifficulty
                        )
                    }
                    parsedQuestions = result.first
                    detectedFileFormat = result.second
                    selectedFileName = uri.lastPathSegment?.substringAfterLast('/') ?: "spreadsheet_file"
                    isParsingFile = false
                    Toast.makeText(
                        context,
                        "Parsed ${result.first.size} questions from $detectedFileFormat",
                        Toast.LENGTH_SHORT
                    ).show()
                } catch (e: Exception) {
                    isParsingFile = false
                    Toast.makeText(context, "Error reading file: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .testTag("admin_panel_screen"),
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Admin Panel",
                                fontWeight = FontWeight.ExtraBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = indigoColor.copy(alpha = 0.15f),
                                border = BorderStroke(1.dp, indigoColor.copy(alpha = 0.4f))
                            ) {
                                Text(
                                    text = "FIRESTORE",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = indigoColor,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "Bulk CSV & Excel Question Importer to Cloud Database",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack,
                        modifier = Modifier.testTag("admin_panel_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Navigate Back"
                        )
                    }
                },
                actions = {
                    // Cloud Status Indicator Chip
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isCloudSyncAvailable) emeraldColor.copy(alpha = 0.15f) else Color(0xFFF59E0B).copy(alpha = 0.15f),
                        border = BorderStroke(
                            1.dp,
                            if (isCloudSyncAvailable) emeraldColor.copy(alpha = 0.35f) else Color(0xFFF59E0B).copy(alpha = 0.35f)
                        ),
                        modifier = Modifier.padding(end = 12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(if (isCloudSyncAvailable) emeraldColor else Color(0xFFF59E0B))
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isCloudSyncAvailable) "Firestore Ready" else "Offline Cache",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isCloudSyncAvailable) emeraldColor else Color(0xFFF59E0B)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Live Synchronization / Progress Banner
            AnimatedVisibility(visible = isBulkImportingToFirestore || firestoreBulkProgress != null) {
                Surface(
                    color = indigoColor.copy(alpha = 0.12f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val progress = firestoreBulkProgress
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(16.dp),
                                    strokeWidth = 2.dp,
                                    color = indigoColor
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Uploading to Firestore Database...",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = indigoColor
                                )
                            }
                            if (progress != null && progress.second > 0) {
                                Text(
                                    text = "${progress.first} / ${progress.second} questions",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = indigoColor
                                )
                            }
                        }
                        if (progress != null && progress.second > 0) {
                            Spacer(modifier = Modifier.height(6.dp))
                            LinearProgressIndicator(
                                progress = { progress.first.toFloat() / progress.second },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(6.dp)
                                    .clip(RoundedCornerShape(3.dp)),
                                color = indigoColor,
                                trackColor = indigoColor.copy(alpha = 0.2f),
                            )
                        }
                    }
                }
            }

            // Top Navigation Tab Row
            ScrollableTabRow(
                selectedTabIndex = selectedPanelTab,
                edgePadding = 12.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("admin_panel_tab_row"),
                divider = { HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)) }
            ) {
                Tab(
                    selected = selectedPanelTab == 0,
                    onClick = { selectedPanelTab = 0 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Bulk CSV / Excel", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    },
                    modifier = Modifier.testTag("tab_bulk_upload")
                )
                Tab(
                    selected = selectedPanelTab == 1,
                    onClick = { selectedPanelTab = 1 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.ContentPaste, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Paste Content", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    },
                    modifier = Modifier.testTag("tab_paste_content")
                )
                Tab(
                    selected = selectedPanelTab == 2,
                    onClick = {
                        selectedPanelTab = 2
                        // Trigger fetch of Firestore central questions
                        isLoadingCloudQuestions = true
                        viewModel.fetchAndImportCentralQuestionsFromCloud(
                            stdId = cloudStdFilter,
                            subjectId = cloudSubjectFilter
                        ) { count, _ ->
                            isLoadingCloudQuestions = false
                        }
                    },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.CloudQueue, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Firestore Cloud Pool", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    },
                    modifier = Modifier.testTag("tab_cloud_pool")
                )
                Tab(
                    selected = selectedPanelTab == 3,
                    onClick = { selectedPanelTab = 3 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.AutoMirrored.Filled.HelpOutline, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("CSV / Excel Template", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    },
                    modifier = Modifier.testTag("tab_templates")
                )
            }

            // Tab Content
            when (selectedPanelTab) {
                0 -> BulkFileImporterTab(
                    viewModel = viewModel,
                    isDark = isDark,
                    targetStd = targetStd,
                    onTargetStdChange = { targetStd = it },
                    targetSubject = targetSubject,
                    onTargetSubjectChange = { targetSubject = it },
                    targetUnitId = targetUnitId,
                    onTargetUnitIdChange = { targetUnitId = it },
                    targetUnitName = targetUnitName,
                    onTargetUnitNameChange = { targetUnitName = it },
                    targetDifficulty = targetDifficulty,
                    onTargetDifficultyChange = { targetDifficulty = it },
                    availableUnits = availableUnits,
                    selectedFileName = selectedFileName,
                    detectedFileFormat = detectedFileFormat,
                    isParsingFile = isParsingFile,
                    parsedQuestions = parsedQuestions,
                    onParsedQuestionsChange = { parsedQuestions = it },
                    previewFilter = previewFilter,
                    onPreviewFilterChange = { previewFilter = it },
                    previewSearchQuery = previewSearchQuery,
                    onPreviewSearchQueryChange = { previewSearchQuery = it },
                    uploadToFirestore = uploadToFirestore,
                    onUploadToFirestoreChange = { uploadToFirestore = it },
                    saveToLocalRoom = saveToLocalRoom,
                    onSaveToLocalRoomChange = { saveToLocalRoom = it },
                    isBulkImporting = isBulkImportingToFirestore,
                    uploadSuccessSummary = uploadSuccessSummary,
                    onSelectFile = {
                        filePickerLauncher.launch(
                            arrayOf(
                                "text/comma-separated-values",
                                "text/csv",
                                "text/plain",
                                "text/tab-separated-values",
                                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                                "application/vnd.ms-excel",
                                "application/octet-stream",
                                "*/*"
                            )
                        )
                    },
                    onClearFile = {
                        selectedFileUri = null
                        selectedFileName = null
                        detectedFileFormat = null
                        parsedQuestions = emptyList()
                        uploadSuccessSummary = null
                    },
                    onStartImport = { validList ->
                        uploadSuccessSummary = null
                        viewModel.bulkImportQuestionsToFirestore(
                            questions = validList,
                            saveToLocalRoom = saveToLocalRoom,
                            onComplete = { count, success, message ->
                                if (success) {
                                    uploadSuccessSummary = "🎉 Successfully imported $count questions into Firestore database!"
                                    Toast.makeText(context, uploadSuccessSummary, Toast.LENGTH_LONG).show()
                                } else {
                                    Toast.makeText(context, "Upload note: $message", Toast.LENGTH_LONG).show()
                                }
                            }
                        )
                    },
                    onEditQuestion = { index -> editingParsedIndex = index }
                )

                1 -> DirectPasteTab(
                    isDark = isDark,
                    rawText = rawPastedText,
                    onRawTextChange = { rawPastedText = it },
                    targetStd = targetStd,
                    targetSubject = targetSubject,
                    targetUnitId = targetUnitId,
                    targetUnitName = targetUnitName,
                    targetDifficulty = targetDifficulty,
                    onParsed = { parsedList ->
                        parsedQuestions = parsedList
                        selectedFileName = "Pasted Content (${parsedList.size} items)"
                        detectedFileFormat = "Direct Text / CSV Parse"
                        selectedPanelTab = 0 // Jump to preview & commit
                    }
                )

                2 -> FirestoreQuestionPoolTab(
                    viewModel = viewModel,
                    isDark = isDark,
                    isLoading = isLoadingCloudQuestions,
                    selectedStd = cloudStdFilter,
                    onStdChange = {
                        cloudStdFilter = it
                        viewModel.fetchAndImportCentralQuestionsFromCloud(it, cloudSubjectFilter)
                    },
                    selectedSubject = cloudSubjectFilter,
                    onSubjectChange = {
                        cloudSubjectFilter = it
                        viewModel.fetchAndImportCentralQuestionsFromCloud(cloudStdFilter, it)
                    },
                    searchQuery = cloudSearchQuery,
                    onSearchQueryChange = { cloudSearchQuery = it }
                )

                3 -> TemplateGuidelinesTab(
                    isDark = isDark,
                    onCopyTemplate = { tpl ->
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        clipboard.setPrimaryClip(ClipData.newPlainText("Quiz Template", tpl))
                        Toast.makeText(context, "Template copied to clipboard!", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }

    // Modal Dialog to edit an individual parsed question before importing
    editingParsedIndex?.let { index ->
        if (index in parsedQuestions.indices) {
            val item = parsedQuestions[index]
            var editPrompt by remember { mutableStateOf(item.entity.questionText) }
            var editOptions by remember { mutableStateOf(item.entity.optionsString.split('|').toMutableList()) }
            var editAnswer by remember { mutableStateOf(item.entity.correctAnswer) }
            var editExplanation by remember { mutableStateOf(item.entity.explanation) }
            var editDiff by remember { mutableStateOf(item.entity.difficulty) }

            Dialog(onDismissRequest = { editingParsedIndex = null }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Edit Question #${index + 1}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        OutlinedTextField(
                            value = editPrompt,
                            onValueChange = { editPrompt = it },
                            label = { Text("Question Text") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Text("Options (A, B, C, D):", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        editOptions.forEachIndexed { optIdx, optVal ->
                            OutlinedTextField(
                                value = optVal,
                                onValueChange = { newVal ->
                                    val updated = editOptions.toMutableList()
                                    updated[optIdx] = newVal
                                    editOptions = updated
                                },
                                label = { Text("Option ${'A' + optIdx}") },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        OutlinedTextField(
                            value = editAnswer,
                            onValueChange = { editAnswer = it },
                            label = { Text("Correct Answer") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = editExplanation,
                            onValueChange = { editExplanation = it },
                            label = { Text("Explanation (Optional)") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = { editingParsedIndex = null }) {
                                Text("Cancel")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = {
                                    val updatedEntity = item.entity.copy(
                                        questionText = editPrompt,
                                        optionsString = editOptions.joinToString("|"),
                                        correctAnswer = editAnswer,
                                        explanation = editExplanation,
                                        difficulty = editDiff
                                    )
                                    val isValid = editPrompt.isNotBlank() &&
                                            editOptions.size >= 2 &&
                                            editAnswer.isNotBlank()
                                    val updatedList = parsedQuestions.toMutableList()
                                    updatedList[index] = ParsedBulkQuestion(
                                        entity = updatedEntity,
                                        isValid = isValid,
                                        validationMessage = if (isValid) "Valid" else "Requires question, options, and answer"
                                    )
                                    parsedQuestions = updatedList
                                    editingParsedIndex = null
                                }
                            ) {
                                Text("Save Changes")
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Tab 0: Bulk File Importer for CSV & Excel Spreadsheets
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun BulkFileImporterTab(
    viewModel: QuizViewModel,
    isDark: Boolean,
    targetStd: Int,
    onTargetStdChange: (Int) -> Unit,
    targetSubject: String,
    onTargetSubjectChange: (String) -> Unit,
    targetUnitId: Int,
    onTargetUnitIdChange: (Int) -> Unit,
    targetUnitName: String,
    onTargetUnitNameChange: (String) -> Unit,
    targetDifficulty: String,
    onTargetDifficultyChange: (String) -> Unit,
    availableUnits: List<UnitTemplate>,
    selectedFileName: String?,
    detectedFileFormat: String?,
    isParsingFile: Boolean,
    parsedQuestions: List<ParsedBulkQuestion>,
    onParsedQuestionsChange: (List<ParsedBulkQuestion>) -> Unit,
    previewFilter: String,
    onPreviewFilterChange: (String) -> Unit,
    previewSearchQuery: String,
    onPreviewSearchQueryChange: (String) -> Unit,
    uploadToFirestore: Boolean,
    onUploadToFirestoreChange: (Boolean) -> Unit,
    saveToLocalRoom: Boolean,
    onSaveToLocalRoomChange: (Boolean) -> Unit,
    isBulkImporting: Boolean,
    uploadSuccessSummary: String?,
    onSelectFile: () -> Unit,
    onClearFile: () -> Unit,
    onStartImport: (List<QuizQuestionEntity>) -> Unit,
    onEditQuestion: (Int) -> Unit
) {
    val emeraldColor = Color(0xFF10B981)
    val indigoColor = Color(0xFF4F46E5)
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    val validQuestions = remember(parsedQuestions) {
        parsedQuestions.filter { it.isValid }.map { it.entity }
    }
    val issueCount = remember(parsedQuestions) {
        parsedQuestions.count { !it.isValid }
    }

    val filteredList = remember(parsedQuestions, previewFilter, previewSearchQuery) {
        parsedQuestions.filter { item ->
            val matchesFilter = when (previewFilter) {
                "VALID" -> item.isValid
                "ISSUES" -> !item.isValid
                else -> true
            }
            val matchesSearch = if (previewSearchQuery.isBlank()) true else {
                item.entity.questionText.contains(previewSearchQuery, ignoreCase = true) ||
                        item.entity.correctAnswer.contains(previewSearchQuery, ignoreCase = true)
            }
            matchesFilter && matchesSearch
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Step 1: Target Curriculum Header & Selector
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = cardBorder,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(indigoColor.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("1", fontWeight = FontWeight.Bold, color = indigoColor, fontSize = 14.sp)
                    }
                    Text(
                        text = "Curriculum Target & Fallback Defaults",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "If your spreadsheet rows omit Standard, Subject, or Unit columns, these selected defaults are assigned automatically.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Standard Selector Chips - Single scrollable horizontal line
                Text("Standard / Class:", fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val standards = listOf(
                        6 to "Class 6",
                        7 to "Class 7",
                        8 to "Class 8",
                        9 to "Class 9",
                        10 to "Class 10",
                        11 to "Morarji",
                        12 to "NMMS"
                    )
                    standards.forEach { (stdNum, stdLabel) ->
                        FilterChip(
                            selected = targetStd == stdNum,
                            onClick = { onTargetStdChange(stdNum) },
                            label = { Text(stdLabel, fontSize = 11.5.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = indigoColor.copy(alpha = 0.18f),
                                selectedLabelColor = indigoColor
                            )
                        )
                    }
                }

                // Subject Selector Chips - Single scrollable horizontal line
                Text("Subject:", fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val subjects: List<Pair<String, String>> = listOf(
                        SubjectType.SCIENCE.id to "Science (ವಿಜ್ಞಾನ)",
                        SubjectType.MATHEMATICS.id to "Maths (ಗಣಿತ)",
                        SubjectType.SOCIAL_SCIENCE.id to "Social (ಸಮಾಜ)",
                        SubjectType.KANNADA.id to "Kannada (ಕನ್ನಡ)",
                        SubjectType.ENGLISH.id to "English",
                        SubjectType.HINDI.id to "Hindi (ಹಿಂದಿ)",
                        "gmat" to "GMAT / Mental Ability"
                    )
                    subjects.forEach { (subId, subLabel) ->
                        FilterChip(
                            selected = targetSubject == subId,
                            onClick = { onTargetSubjectChange(subId) },
                            label = { Text(subLabel, fontSize = 11.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = indigoColor.copy(alpha = 0.18f),
                                selectedLabelColor = indigoColor
                            )
                        )
                    }
                }

                // Unit selection if available - Single scrollable horizontal line
                if (availableUnits.isNotEmpty()) {
                    Text("Unit / Chapter:", fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        availableUnits.take(8).forEach { u ->
                            FilterChip(
                                selected = targetUnitId == u.id,
                                onClick = {
                                    onTargetUnitIdChange(u.id)
                                    onTargetUnitNameChange(u.name)
                                    onTargetDifficultyChange(u.difficulty)
                                },
                                label = { Text("U${u.id}: ${u.name}", fontSize = 11.sp, maxLines = 1) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = emeraldColor.copy(alpha = 0.18f),
                                    selectedLabelColor = emeraldColor
                                )
                            )
                        }
                    }
                }
            }
        }

        // Step 2: File Picker Dropzone Card
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC)
            ),
            border = BorderStroke(1.5.dp, if (selectedFileName != null) emeraldColor else indigoColor.copy(alpha = 0.5f)),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("csv_excel_file_dropzone")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(indigoColor.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("2", fontWeight = FontWeight.Bold, color = indigoColor, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Choose CSV or Excel Spreadsheet",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (selectedFileName == null) {
                    // Empty state: Tap to select
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(emeraldColor.copy(alpha = 0.12f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CloudUpload,
                            contentDescription = "Upload Spreadsheet",
                            tint = emeraldColor,
                            modifier = Modifier.size(36.dp)
                        )
                    }

                    Text(
                        text = "Select .csv or .xlsx Spreadsheet File",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Supports Microsoft Excel (.xlsx), Comma-Separated Values (.csv), or TSV files with auto-detected question columns.",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Button(
                        onClick = onSelectFile,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = emeraldColor),
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .height(44.dp)
                            .testTag("select_spreadsheet_button")
                    ) {
                        Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Browse & Select File", fontWeight = FontWeight.Bold)
                    }
                } else {
                    // File is selected! Show details banner
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = emeraldColor.copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, emeraldColor.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Description,
                                    contentDescription = null,
                                    tint = emeraldColor,
                                    modifier = Modifier.size(28.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = selectedFileName,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.5.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = detectedFileFormat ?: "Spreadsheet Document",
                                        fontSize = 11.sp,
                                        color = emeraldColor,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                            Row {
                                OutlinedButton(
                                    onClick = onSelectFile,
                                    shape = RoundedCornerShape(8.dp),
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                    modifier = Modifier.height(32.dp)
                                ) {
                                    Text("Change", fontSize = 11.sp)
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                IconButton(
                                    onClick = onClearFile,
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Clear",
                                        tint = MaterialTheme.colorScheme.error,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Success Summary Banner (if completed)
        uploadSuccessSummary?.let { summary ->
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = emeraldColor.copy(alpha = 0.15f),
                border = BorderStroke(1.dp, emeraldColor.copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = emeraldColor, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = summary,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF065F46)
                    )
                }
            }
        }

        // Step 3: Interactive Validation & Question Preview
        if (parsedQuestions.isNotEmpty()) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = cardBorder,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(indigoColor.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("3", fontWeight = FontWeight.Bold, color = indigoColor, fontSize = 14.sp)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Preview & Validation",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        // Summary badges with FlowRow
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = emeraldColor.copy(alpha = 0.15f),
                                border = BorderStroke(1.dp, emeraldColor.copy(alpha = 0.3f))
                            ) {
                                Text(
                                    text = "✓ ${validQuestions.size} Valid",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = emeraldColor,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                            if (issueCount > 0) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFEF4444).copy(alpha = 0.15f),
                                    border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.3f))
                                ) {
                                    Text(
                                        text = "⚠️ $issueCount Issues",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFEF4444),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }
                    }

                    // Filter chips & Search
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        FilterChip(
                            selected = previewFilter == "ALL",
                            onClick = { onPreviewFilterChange("ALL") },
                            label = { Text("All (${parsedQuestions.size})", fontSize = 11.sp) }
                        )
                        FilterChip(
                            selected = previewFilter == "VALID",
                            onClick = { onPreviewFilterChange("VALID") },
                            label = { Text("Valid Only (${validQuestions.size})", fontSize = 11.sp) }
                        )
                        if (issueCount > 0) {
                            FilterChip(
                                selected = previewFilter == "ISSUES",
                                onClick = { onPreviewFilterChange("ISSUES") },
                                label = { Text("Issues ($issueCount)", fontSize = 11.sp) }
                            )
                        }
                    }

                    // Question Cards Preview (First 8 items with pagination note)
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        filteredList.take(8).forEachIndexed { idx, item ->
                            val q = item.entity
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                                border = BorderStroke(
                                    1.dp,
                                    if (item.isValid) emeraldColor.copy(alpha = 0.3f) else Color(0xFFEF4444).copy(alpha = 0.4f)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onEditQuestion(idx) }
                                    .testTag("preview_question_item_$idx")
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    FlowRow(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "#${idx + 1}",
                                                fontWeight = FontWeight.ExtraBold,
                                                fontSize = 11.sp,
                                                color = indigoColor
                                            )
                                            Text(
                                                text = "Std ${q.stdId} • ${q.subjectId.uppercase()} • U${q.unitId}",
                                                fontSize = 10.5.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            if (item.isValid) {
                                                Text("✓ Ready", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = emeraldColor)
                                            } else {
                                                Text(
                                                    item.validationMessage,
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFFEF4444),
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            }
                                            IconButton(
                                                onClick = { onEditQuestion(idx) },
                                                modifier = Modifier.size(24.dp)
                                            ) {
                                                Icon(Icons.Default.Edit, contentDescription = "Edit", modifier = Modifier.size(14.dp))
                                            }
                                        }
                                    }

                                    Text(
                                        text = q.questionText,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )

                                    // Options row
                                    val opts = q.optionsString.split('|')
                                    FlowRow(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        opts.forEachIndexed { oIdx, opt ->
                                            val isCorrect = opt.trim().equals(q.correctAnswer.trim(), ignoreCase = true)
                                            Surface(
                                                shape = RoundedCornerShape(6.dp),
                                                color = if (isCorrect) emeraldColor.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surface,
                                                border = BorderStroke(1.dp, if (isCorrect) emeraldColor else MaterialTheme.colorScheme.outlineVariant)
                                            ) {
                                                Text(
                                                    text = "${'A' + oIdx}. $opt",
                                                    fontSize = 10.5.sp,
                                                    fontWeight = if (isCorrect) FontWeight.Bold else FontWeight.Normal,
                                                    color = if (isCorrect) emeraldColor else MaterialTheme.colorScheme.onSurface,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (filteredList.size > 8) {
                            Text(
                                text = "Showing first 8 of ${filteredList.size} parsed items. All ${validQuestions.size} valid questions will be uploaded to Firestore.",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }

            // Step 4: Destination & Import Action
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF)
                ),
                border = BorderStroke(1.5.dp, indigoColor.copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(indigoColor),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("4", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Target Destination & Commit",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = indigoColor
                        )
                    }

                    // Toggles
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onUploadToFirestoreChange(!uploadToFirestore) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = uploadToFirestore,
                            onCheckedChange = { onUploadToFirestoreChange(it) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Upload to Firebase Firestore Database",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                            Text(
                                text = "Populates cloud 'questions' collection and mirrors to 'quiz_questions' for student devices",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSaveToLocalRoomChange(!saveToLocalRoom) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = saveToLocalRoom,
                            onCheckedChange = { onSaveToLocalRoomChange(it) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Also cache into Local Room DB",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                            Text(
                                text = "Ensures instant offline quiz access even without cellular or internet data",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Big Commit Button
                    Button(
                        onClick = { onStartImport(validQuestions) },
                        enabled = validQuestions.isNotEmpty() && !isBulkImporting,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("bulk_import_to_firestore_button"),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = indigoColor)
                    ) {
                        if (isBulkImporting) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = Color.White,
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Uploading to Firestore...", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        } else {
                            Icon(Icons.Default.CloudUpload, contentDescription = null, modifier = Modifier.size(22.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Bulk Import ${validQuestions.size} Questions to Firestore",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Tab 1: Direct Paste / Text Input Tab
 */
@Composable
private fun DirectPasteTab(
    isDark: Boolean,
    rawText: String,
    onRawTextChange: (String) -> Unit,
    targetStd: Int,
    targetSubject: String,
    targetUnitId: Int,
    targetUnitName: String,
    targetDifficulty: String,
    onParsed: (List<ParsedBulkQuestion>) -> Unit
) {
    val context = LocalContext.current
    val indigoColor = Color(0xFF4F46E5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Direct CSV / Text Question Input",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Copy and paste rows directly from Excel, Google Sheets, or a CSV file here. The parser automatically discovers column headers.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Quick sample insert buttons - FlowRow wraps to next horizontal line
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            OutlinedButton(
                onClick = {
                    onRawTextChange(
                        """
question,optionA,optionB,optionC,optionD,answer,explanation
ಸಸ್ಯಗಳು ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಗೆ ಬಳಸುವ ಅನಿಲ ಯಾವುದು?,ಆಮ್ಲಜನಕ,ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್,ಸಾರಜನಕ,ಹೈಡ್ರೋಜನ್,ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್,ಸಸ್ಯಗಳು ಸೂರ್ಯನ ಬೆಳಕಿನಲ್ಲಿ ಆಹಾರ ತಯಾರಿಸಲು CO2 ಬಳಸುತ್ತವೆ.
ಮಾನವ ದೇಹದ ಅತಿ ದೊಡ್ಡ ಅಂಗ ಯಾವುದು?,ಯಕೃತ್ತು,ಚರ್ಮ,ಹೃದಯ,ಮೆದುಳು,ಚರ್ಮ,ಮಾನವನ ಬಾಹ್ಯ ರಕ್ಷಣಾ ಕವಚವಾಗಿರುವ ಚರ್ಮ ಅತಿ ದೊಡ್ಡ ಅಂಗವಾಗಿದೆ.
ನೀರಿನ ರಾಸಾಯನಿಕ ಸೂತ್ರವೇನು?,H2O,CO2,NaCl,O2,H2O,ಎರಡು ಹೈಡ್ರೋಜನ್ ಮತ್ತು ಒಂದು ಆಮ್ಲಜನಕ ಪರಮಾಣುಗಳು ಸೇರಿ ನೀರಾಗುತ್ತದೆ.
                        """.trimIndent()
                    )
                },
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                modifier = Modifier.height(32.dp)
            ) {
                Text("Insert Science Sample (ಕನ್ನಡ)", fontSize = 11.sp)
            }

            OutlinedButton(
                onClick = {
                    onRawTextChange(
                        """
question,optionA,optionB,optionC,optionD,answer,explanation
In 1828 who founded the Brahma Samaj?,Raja Ram Mohan Roy,Swami Dayananda Saraswati,Swami Vivekananda,Ishwar Chandra Vidyasagar,Raja Ram Mohan Roy,Raja Ram Mohan Roy established the Brahma Samaj in Calcutta.
Which gas is most abundant in Earth atmosphere?,Nitrogen,Oxygen,Carbon Dioxide,Argon,Nitrogen,Nitrogen makes up approximately 78% of Earth's atmosphere.
                        """.trimIndent()
                    )
                },
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                modifier = Modifier.height(32.dp)
            ) {
                Text("Insert English Sample", fontSize = 11.sp)
            }
        }

        OutlinedTextField(
            value = rawText,
            onValueChange = onRawTextChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .testTag("direct_paste_text_field"),
            placeholder = {
                Text(
                    "Paste CSV rows here...\nquestion,optionA,optionB,optionC,optionD,answer,explanation",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 12.sp
                )
            },
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Monospace)
        )

        Button(
            onClick = {
                if (rawText.isBlank()) {
                    Toast.makeText(context, "Please paste some CSV text first", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                val questions = BulkQuestionParser.parseAuto(
                    content = rawText,
                    stdId = targetStd,
                    subjectId = targetSubject,
                    unitId = targetUnitId,
                    unitName = targetUnitName,
                    defaultDifficulty = targetDifficulty
                )
                if (questions.isEmpty()) {
                    Toast.makeText(context, "Could not discover any quiz questions in text", Toast.LENGTH_LONG).show()
                } else {
                    onParsed(questions)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("parse_pasted_content_button"),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = indigoColor)
        ) {
            Icon(Icons.Default.Bolt, contentDescription = null, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Parse & Preview Pasted Questions", fontWeight = FontWeight.Bold)
        }
    }
}

/**
 * Tab 2: Firestore Question Pool Browser
 */
@Composable
private fun FirestoreQuestionPoolTab(
    viewModel: QuizViewModel,
    isDark: Boolean,
    isLoading: Boolean,
    selectedStd: Int?,
    onStdChange: (Int?) -> Unit,
    selectedSubject: String?,
    onSubjectChange: (String?) -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit
) {
    val context = LocalContext.current
    val roomQuestions by viewModel.allRoomQuestions.collectAsState()
    val isCentralPoolSyncing by viewModel.isCentralPoolSyncing.collectAsState()

    val filteredList = remember(roomQuestions, selectedStd, selectedSubject, searchQuery) {
        roomQuestions.filter { q ->
            val matchesStd = selectedStd == null || q.stdId == selectedStd
            val matchesSub = selectedSubject == null || q.subjectId.equals(selectedSubject, ignoreCase = true)
            val matchesSearch = if (searchQuery.isBlank()) true else {
                q.questionText.contains(searchQuery, ignoreCase = true) ||
                        q.correctAnswer.contains(searchQuery, ignoreCase = true)
            }
            matchesStd && matchesSub && matchesSearch
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Central Firestore Pool",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${filteredList.size} questions matching current filters",
                    fontSize = 11.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Sync from Cloud button
            Button(
                onClick = {
                    viewModel.fetchAndImportCentralQuestionsFromCloud(selectedStd, selectedSubject) { count, _ ->
                        Toast.makeText(context, "Loaded $count central questions", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                modifier = Modifier.height(34.dp)
            ) {
                if (isCentralPoolSyncing) {
                    CircularProgressIndicator(modifier = Modifier.size(14.dp), color = Color.White, strokeWidth = 2.dp)
                } else {
                    Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Refresh Cloud", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Standard Filter Chips - Single scrollable horizontal line
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterChip(
                selected = selectedStd == null,
                onClick = { onStdChange(null) },
                label = { Text("All Classes", fontSize = 11.sp) }
            )
            listOf(6, 7, 8, 9, 10, 11, 12).forEach { std ->
                FilterChip(
                    selected = selectedStd == std,
                    onClick = { onStdChange(if (selectedStd == std) null else std) },
                    label = { Text(if (std == 11) "Morarji" else if (std == 12) "NMMS" else "Class $std", fontSize = 11.sp) }
                )
            }
        }

        // Subject Filter Chips - Single scrollable horizontal line
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterChip(
                selected = selectedSubject == null,
                onClick = { onSubjectChange(null) },
                label = { Text("All Subjects", fontSize = 11.sp) }
            )
            listOf(
                SubjectType.SCIENCE.id to "Science",
                SubjectType.MATHEMATICS.id to "Maths",
                SubjectType.SOCIAL_SCIENCE.id to "Social",
                SubjectType.KANNADA.id to "Kannada",
                SubjectType.ENGLISH.id to "English",
                SubjectType.HINDI.id to "Hindi"
            ).forEach { (subId, subLabel) ->
                FilterChip(
                    selected = selectedSubject == subId,
                    onClick = { onSubjectChange(if (selectedSubject == subId) null else subId) },
                    label = { Text(subLabel, fontSize = 11.sp) }
                )
            }
        }

        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search question text...", fontSize = 12.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp)) },
            shape = RoundedCornerShape(10.dp),
            singleLine = true
        )

        // Question List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(filteredList.take(50)) { idx, q ->
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Std ${q.stdId} • ${q.subjectId.uppercase()} • Unit ${q.unitId}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4F46E5)
                            )
                            IconButton(
                                onClick = {
                                    viewModel.deleteFirestoreQuestion(q.id) {
                                        viewModel.deleteRoomQuestion(q.id)
                                        Toast.makeText(context, "Deleted question", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFFEF4444), modifier = Modifier.size(16.dp))
                            }
                        }

                        Text(
                            text = q.questionText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.5.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = "Ans: ${q.correctAnswer}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF10B981)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Tab 3: CSV & Excel Template Guidelines
 */
@Composable
private fun TemplateGuidelinesTab(
    isDark: Boolean,
    onCopyTemplate: (String) -> Unit
) {
    val indigoColor = Color(0xFF4F46E5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "Spreadsheet Format Guidelines",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Our parser is resilient and intelligent. As long as your CSV or Excel file contains the standard headers or follows standard column order, it parses automatically.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Template Card
        Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
            ),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Recommended Column Headers:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.5.sp,
                    color = indigoColor
                )

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isDark) Color(0xFF0F172A) else Color(0xFFECEFF1),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "standard,subject,unit,question,optionA,optionB,optionC,optionD,answer,explanation",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }

                Button(
                    onClick = {
                        val sampleCsv = """
standard,subject,unit,question,optionA,optionB,optionC,optionD,answer,explanation
6,science,1,What is the SI unit of force?,Newton,Joule,Pascal,Watt,Newton,Force is measured in Newtons named after Sir Isaac Newton.
6,science,1,Which gas do plants release during photosynthesis?,Oxygen,Carbon Dioxide,Nitrogen,Helium,Oxygen,Photosynthesis produces glucose and releases oxygen gas.
8,social,1,Who was the first Governor-General of British India?,Warren Hastings,Lord Dalhousie,Lord Wellesley,Robert Clive,Warren Hastings,Warren Hastings became Governor-General in 1773.
                        """.trimIndent()
                        onCopyTemplate(sampleCsv)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = indigoColor)
                ) {
                    Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Copy Sample CSV to Clipboard", fontSize = 12.sp)
                }
            }
        }

        // Kannada Support Info Card
        Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "Full Kannada (ಕನ್ನಡ) & Unicode Support",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color(0xFF10B981)
                )
                Text(
                    text = "Save your Excel file as UTF-8 CSV or standard .xlsx. All Kannada characters, complex conjuncts, and numbers are decoded natively without encoding corruption.",
                    fontSize = 11.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

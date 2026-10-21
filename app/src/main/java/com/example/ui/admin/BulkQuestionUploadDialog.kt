package com.example.ui.admin

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
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
import androidx.compose.material.icons.automirrored.filled.InsertDriveFile
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
import com.example.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Material 3 Dialog enabling teachers and administrators to import questions in bulk
 * via Excel (.xlsx/.xls), CSV, TSV, PDF, or text files organized class-wise, subject-wise, and unit-wise.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BulkQuestionUploadDialog(
    viewModel: QuizViewModel,
    isDark: Boolean,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Target curriculum configuration
    var targetStd by remember { mutableIntStateOf(6) }
    var targetSubject by remember { mutableStateOf(SubjectType.SCIENCE.id) }
    var targetUnitId by remember { mutableIntStateOf(1) }
    var targetUnitName by remember { mutableStateOf("Living vs Non-Living Things") }
    var targetDifficulty by remember { mutableStateOf("Medium") }
    var isCustomUnitSelected by remember { mutableStateOf(false) }

    // Dynamic curriculum units for current Std & Subject
    val availableUnits = remember(targetStd, targetSubject) {
        val stdData = QuizStaticData.standardsList.find { it.std == targetStd }
        val subData = stdData?.subjects?.find { it.id == targetSubject }
        subData?.units ?: emptyList()
    }

    // Auto-sync unit selection if standard or subject changed
    LaunchedEffect(availableUnits) {
        if (!isCustomUnitSelected && availableUnits.isNotEmpty()) {
            val first = availableUnits.first()
            targetUnitId = first.id
            targetUnitName = first.name
            targetDifficulty = first.difficulty
        }
    }

    // Input Tabs: 0 = File Upload (Excel/CSV/PDF), 1 = Paste Content, 2 = Templates & Guidelines
    var selectedInputTab by remember { mutableIntStateOf(0) }

    // Upload & Parse States
    var selectedFileName by remember { mutableStateOf<String?>(null) }
    var detectedFormat by remember { mutableStateOf<String?>(null) }
    var rawTextContent by remember { mutableStateOf("") }
    var isParsing by remember { mutableStateOf(false) }
    var isImporting by remember { mutableStateOf(false) }
    var parsedQuestions by remember { mutableStateOf<List<ParsedBulkQuestion>>(emptyList()) }
    var questionFilter by remember { mutableStateOf("ALL") } // "ALL", "VALID", "ISSUES"
    var previewSearchQuery by remember { mutableStateOf("") }

    // State for editing a specific parsed question before importing
    var editingQuestionIndex by remember { mutableStateOf<Int?>(null) }

    // Parse plain text content
    fun parseText(text: String, fileName: String? = null, formatName: String = "Text") {
        if (text.isBlank()) {
            Toast.makeText(context, "No content to parse", Toast.LENGTH_SHORT).show()
            return
        }
        isParsing = true
        coroutineScope.launch {
            val results = withContext(Dispatchers.Default) {
                BulkQuestionParser.parseAuto(
                    content = text,
                    stdId = targetStd,
                    subjectId = targetSubject,
                    unitId = targetUnitId,
                    unitName = targetUnitName,
                    defaultDifficulty = targetDifficulty
                )
            }
            parsedQuestions = results
            selectedFileName = fileName
            detectedFormat = formatName
            isParsing = false
            if (results.isEmpty()) {
                Toast.makeText(context, "No questions detected. Check format or use templates.", Toast.LENGTH_LONG).show()
            } else {
                val validCount = results.count { it.isValid }
                Toast.makeText(context, "Parsed ${results.size} questions ($validCount valid)", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Zero-permission SAF Document Picker for CSV, Excel (.xlsx/.xls), PDF, and Text files
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        if (uri != null) {
            coroutineScope.launch {
                isParsing = true
                try {
                    val (results, formatName) = withContext(Dispatchers.IO) {
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
                    val fileName = uri.lastPathSegment?.substringAfterLast('/') ?: "uploaded_file"
                    parsedQuestions = results
                    selectedFileName = fileName
                    detectedFormat = formatName
                    isParsing = false

                    if (results.isEmpty()) {
                        Toast.makeText(context, "No questions detected in $fileName. Check structure or use sample templates.", Toast.LENGTH_LONG).show()
                    } else {
                        val validCount = results.count { it.isValid }
                        Toast.makeText(context, "Parsed ${results.size} questions from $formatName ($validCount valid)", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    isParsing = false
                    Toast.makeText(context, "Error processing file: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .fillMaxHeight(0.94f)
                .clip(RoundedCornerShape(24.dp))
                .testTag("bulk_question_upload_dialog"),
            color = if (isDark) Color(0xFF0F172A) else Color.White,
            shape = RoundedCornerShape(24.dp),
            tonalElevation = 6.dp
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // 1. DIALOG HEADER BANNER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4F46E5))
                        .padding(horizontal = 20.dp, vertical = 14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CloudUpload,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "Bulk Question Uploader",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                                Text(
                                    text = "Excel (.xlsx) • CSV • PDF • Text (Classwise, Subjectwise, Unitwise)",
                                    fontSize = 11.sp,
                                    color = Color.White.copy(alpha = 0.85f)
                                )
                            }
                        }

                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.2f))
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                    }
                }

                // 2. MAIN SCROLLABLE BODY
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // --- TARGET CURRICULUM SELECTION CARD ---
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
                        ),
                        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "🎯 Target Curriculum Destination",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF3730A3)
                                )
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFF4F46E5).copy(alpha = 0.15f)
                                ) {
                                    val targetStdLabel = when (targetStd) {
                                        11 -> "Morarji"
                                        12 -> "NMMS"
                                        else -> "Std $targetStd"
                                    }
                                    Text(
                                        text = "$targetStdLabel • ${targetSubject.uppercase()}",
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFF4F46E5)
                                    )
                                }
                            }

                            // Class / Standard Selection Row - Single scrollable horizontal line
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text(
                                    text = "Class / Grade / Exam Stream:",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    listOf(6, 7, 8, 9, 10, 11, 12).forEach { stdNum ->
                                        val isSelected = targetStd == stdNum
                                        val labelText = when (stdNum) {
                                            11 -> "Morarji"
                                            12 -> "NMMS"
                                            else -> "Class $stdNum"
                                        }
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = { targetStd = stdNum },
                                            label = {
                                                Text(
                                                    text = labelText,
                                                    fontSize = 11.5.sp,
                                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                                )
                                            },
                                            modifier = Modifier.testTag("bulk_std_chip_$stdNum")
                                        )
                                    }
                                }
                            }

                            // Subject Selection Row - Single scrollable horizontal line
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text(
                                    text = "Subject:",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    SubjectType.entries.forEach { sub ->
                                        val isSelected = targetSubject == sub.id
                                        FilterChip(
                                            selected = isSelected,
                                            onClick = { targetSubject = sub.id },
                                            label = {
                                                Text(
                                                    text = sub.displayName,
                                                    fontSize = 11.sp,
                                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                                )
                                            },
                                            leadingIcon = {
                                                Box(
                                                    modifier = Modifier
                                                        .size(8.dp)
                                                        .clip(CircleShape)
                                                        .background(Color(sub.colorHex))
                                                )
                                            },
                                            modifier = Modifier.testTag("bulk_subject_chip_${sub.id}")
                                        )
                                    }
                                }
                            }

                            // Unit / Chapter Selection
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Unit / Chapter:",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    TextButton(
                                        onClick = { isCustomUnitSelected = !isCustomUnitSelected },
                                        contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Text(
                                            text = if (isCustomUnitSelected) "Use Standard Unit" else "Custom Chapter ✏️",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF4F46E5)
                                        )
                                    }
                                }

                                if (!isCustomUnitSelected && availableUnits.isNotEmpty()) {
                                    FlowRow(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        verticalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        availableUnits.forEach { unitItem ->
                                            val isSelected = targetUnitId == unitItem.id && targetUnitName == unitItem.name
                                            FilterChip(
                                                selected = isSelected,
                                                onClick = {
                                                    targetUnitId = unitItem.id
                                                    targetUnitName = unitItem.name
                                                    targetDifficulty = unitItem.difficulty
                                                },
                                                label = {
                                                    Text(
                                                        text = "Unit ${unitItem.id}: ${unitItem.name}",
                                                        fontSize = 11.sp,
                                                        maxLines = 1,
                                                        overflow = TextOverflow.Ellipsis,
                                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                                    )
                                                }
                                            )
                                        }
                                    }
                                } else {
                                    // Custom Unit Input Fields
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        OutlinedTextField(
                                            value = targetUnitId.toString(),
                                            onValueChange = { newVal ->
                                                newVal.toIntOrNull()?.let { targetUnitId = it }
                                            },
                                            label = { Text("Unit #", fontSize = 10.sp) },
                                            modifier = Modifier.width(80.dp),
                                            singleLine = true
                                        )

                                        OutlinedTextField(
                                            value = targetUnitName,
                                            onValueChange = { targetUnitName = it },
                                            label = { Text("Custom Chapter / Unit Name", fontSize = 10.sp) },
                                            modifier = Modifier.weight(1f),
                                            singleLine = true
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // --- 3. INPUT METHOD TABS ---
                    TabRow(
                        selectedTabIndex = selectedInputTab,
                        containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                        contentColor = Color(0xFF4F46E5),
                        modifier = Modifier.clip(RoundedCornerShape(12.dp))
                    ) {
                        Tab(
                            selected = selectedInputTab == 0,
                            onClick = { selectedInputTab = 0 },
                            text = { Text("📁 File (Excel/CSV/PDF)", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                        )
                        Tab(
                            selected = selectedInputTab == 1,
                            onClick = { selectedInputTab = 1 },
                            text = { Text("📋 Paste Questions", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                        )
                        Tab(
                            selected = selectedInputTab == 2,
                            onClick = { selectedInputTab = 2 },
                            text = { Text("💡 Templates & Guides", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                        )
                    }

                    // TAB CONTENT
                    when (selectedInputTab) {
                        0 -> {
                            // File Picker Tab
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(14.dp)),
                                color = if (isDark) Color(0xFF1E293B).copy(alpha = 0.5f) else Color(0xFFF8FAFC),
                                border = BorderStroke(1.5.dp, Color(0xFF4F46E5).copy(alpha = 0.4f))
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.InsertDriveFile,
                                        contentDescription = null,
                                        tint = Color(0xFF4F46E5),
                                        modifier = Modifier.size(36.dp)
                                    )

                                    Text(
                                        text = selectedFileName ?: "Select Excel (.xlsx/.xls), CSV (.csv), or PDF (.pdf) file",
                                        fontSize = 12.5.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = if (selectedFileName != null) Color(0xFF10B981) else MaterialTheme.colorScheme.onSurface
                                    )

                                    if (detectedFormat != null) {
                                        Surface(
                                            shape = RoundedCornerShape(8.dp),
                                            color = Color(0xFF10B981).copy(alpha = 0.15f)
                                        ) {
                                            Text(
                                                text = "Detected Format: $detectedFormat",
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF047857)
                                            )
                                        }
                                    }

                                    Button(
                                        onClick = {
                                            filePickerLauncher.launch(
                                                arrayOf(
                                                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                                                    "application/vnd.ms-excel",
                                                    "application/pdf",
                                                    "text/csv",
                                                    "text/comma-separated-values",
                                                    "text/tab-separated-values",
                                                    "text/plain",
                                                    "*/*"
                                                )
                                            )
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.testTag("choose_file_button")
                                    ) {
                                        Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("Choose File from Storage", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        }
                        1 -> {
                            // Paste Text Tab
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                OutlinedTextField(
                                    value = rawTextContent,
                                    onValueChange = { rawTextContent = it },
                                    placeholder = {
                                        Text(
                                            text = "Paste CSV rows or numbered Question Paper text:\n\n1. Question Prompt?\nA) Opt 1\nB) Opt 2\nAnswer: A\nExplanation: ...",
                                            fontSize = 11.5.sp
                                        )
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .testTag("bulk_paste_textfield"),
                                    shape = RoundedCornerShape(12.dp)
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    OutlinedButton(
                                        onClick = {
                                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                            val item = clipboard.primaryClip?.getItemAt(0)
                                            item?.text?.let { rawTextContent = it.toString() }
                                        },
                                        modifier = Modifier.weight(1f),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(Icons.Default.ContentPaste, contentDescription = null, modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Paste", fontSize = 11.sp)
                                    }

                                    Button(
                                        onClick = { parseText(rawTextContent, "Pasted Content", "Manual Paste") },
                                        modifier = Modifier.weight(1f).testTag("parse_pasted_button"),
                                        shape = RoundedCornerShape(10.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5))
                                    ) {
                                        Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Parse Text", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        }
                        2 -> {
                            // Templates & Guidelines Tab
                            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9)
                                    )
                                ) {
                                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Text("📋 Pre-Formatted Sample Templates", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                        Text(
                                            "Easily copy or test sample formats to see how questions are automatically parsed into class-wise and unit-wise quizzes.",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            FilledTonalButton(
                                                onClick = {
                                                    rawTextContent = BulkQuestionParser.SAMPLE_CSV_TEMPLATE
                                                    selectedInputTab = 1
                                                    parseText(rawTextContent, "Sample_Questions.csv", "CSV Template")
                                                },
                                                modifier = Modifier.weight(1f),
                                                shape = RoundedCornerShape(10.dp)
                                            ) {
                                                Text("Load CSV Sample", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                                            }

                                            FilledTonalButton(
                                                onClick = {
                                                    rawTextContent = BulkQuestionParser.SAMPLE_PDF_TEXT_TEMPLATE
                                                    selectedInputTab = 1
                                                    parseText(rawTextContent, "Question_Paper.txt", "Question Paper Template")
                                                },
                                                modifier = Modifier.weight(1f),
                                                shape = RoundedCornerShape(10.dp)
                                            ) {
                                                Text("Load Paper Sample", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                                            }
                                        }

                                        OutlinedButton(
                                            onClick = {
                                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                                clipboard.setPrimaryClip(ClipData.newPlainText("CSV Template", BulkQuestionParser.SAMPLE_CSV_TEMPLATE))
                                                Toast.makeText(context, "Copied CSV headers & sample to clipboard!", Toast.LENGTH_SHORT).show()
                                            },
                                            modifier = Modifier.fillMaxWidth(),
                                            shape = RoundedCornerShape(10.dp)
                                        ) {
                                            Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(14.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text("Copy Excel/CSV Template to Clipboard", fontSize = 11.sp)
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // --- 4. PARSED QUESTIONS PREVIEW ---
                    if (isParsing) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Analyzing question syntax and options...", fontSize = 12.sp)
                        }
                    } else if (parsedQuestions.isNotEmpty()) {
                        val validCount = parsedQuestions.count { it.isValid }
                        val invalidCount = parsedQuestions.size - validCount

                        val displayedQuestions = remember(parsedQuestions, questionFilter, previewSearchQuery) {
                            parsedQuestions.filter { item ->
                                val matchesFilter = when (questionFilter) {
                                    "VALID" -> item.isValid
                                    "ISSUES" -> !item.isValid
                                    else -> true
                                }
                                val matchesSearch = previewSearchQuery.isBlank() ||
                                        item.entity.questionText.contains(previewSearchQuery, ignoreCase = true) ||
                                        item.entity.correctAnswer.contains(previewSearchQuery, ignoreCase = true)
                                matchesFilter && matchesSearch
                            }
                        }

                        // Preview Summary Bar
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Preview Questions (${parsedQuestions.size})",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isDark) Color.White else Color(0xFF1E293B)
                            )

                            FlowRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                FilterChip(
                                    selected = questionFilter == "ALL",
                                    onClick = { questionFilter = "ALL" },
                                    label = { Text("All (${parsedQuestions.size})", fontSize = 10.5.sp) }
                                )
                                FilterChip(
                                    selected = questionFilter == "VALID",
                                    onClick = { questionFilter = "VALID" },
                                    label = { Text("Valid ($validCount)", fontSize = 10.5.sp) }
                                )
                                if (invalidCount > 0) {
                                    FilterChip(
                                        selected = questionFilter == "ISSUES",
                                        onClick = { questionFilter = "ISSUES" },
                                        label = { Text("Issues ($invalidCount)", fontSize = 10.5.sp) }
                                    )
                                }
                            }
                        }

                        // Search Field for parsed list
                        if (parsedQuestions.size > 4) {
                            OutlinedTextField(
                                value = previewSearchQuery,
                                onValueChange = { previewSearchQuery = it },
                                placeholder = { Text("Filter preview questions...", fontSize = 11.sp) },
                                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(16.dp)) },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true,
                                shape = RoundedCornerShape(10.dp)
                            )
                        }

                        // Questions Preview List
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .border(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0), RoundedCornerShape(12.dp))
                                .background(if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC))
                                .padding(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            displayedQuestions.forEachIndexed { idx, item ->
                                Surface(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(10.dp),
                                    color = if (isDark) Color(0xFF0F172A) else Color.White,
                                    border = BorderStroke(
                                        1.dp,
                                        if (item.isValid) Color(0xFF10B981).copy(alpha = 0.4f) else Color(0xFFEF4444).copy(alpha = 0.4f)
                                    )
                                ) {
                                    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                                Text(
                                                    text = "#${idx + 1}",
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Color(0xFF4F46E5)
                                                )
                                                Badge(containerColor = Color(0xFF6366F1).copy(alpha = 0.15f)) {
                                                    Text(item.entity.type, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4F46E5))
                                                }
                                                Badge(containerColor = Color(0xFFF59E0B).copy(alpha = 0.15f)) {
                                                    Text(item.entity.difficulty, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFB45309))
                                                }
                                            }

                                            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                                // Edit Button
                                                IconButton(
                                                    onClick = {
                                                        val originalIndex = parsedQuestions.indexOf(item)
                                                        if (originalIndex != -1) editingQuestionIndex = originalIndex
                                                    },
                                                    modifier = Modifier.size(24.dp)
                                                ) {
                                                    Icon(Icons.Default.Edit, contentDescription = "Edit Question", tint = Color(0xFF4F46E5), modifier = Modifier.size(15.dp))
                                                }

                                                // Delete Button
                                                IconButton(
                                                    onClick = {
                                                        parsedQuestions = parsedQuestions.toMutableList().apply { remove(item) }
                                                    },
                                                    modifier = Modifier.size(24.dp)
                                                ) {
                                                    Icon(Icons.Default.Delete, contentDescription = "Remove", tint = Color(0xFFEF4444), modifier = Modifier.size(15.dp))
                                                }
                                            }
                                        }

                                        Text(
                                            text = item.entity.questionText,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = if (isDark) Color.White else Color(0xFF0F172A)
                                        )

                                        if (item.entity.optionsString.isNotBlank()) {
                                            Text(
                                                text = "Options: ${item.entity.optionsString.split('|').joinToString(" • ")}",
                                                fontSize = 10.5.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }

                                        Text(
                                            text = "✅ Answer: ${item.entity.correctAnswer}",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF10B981)
                                        )

                                        if (!item.isValid) {
                                            Text(
                                                text = "⚠️ ${item.validationMessage}",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFEF4444)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // 5. BOTTOM ACTION BAR
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
                ) {
                    val validQuestions = parsedQuestions.filter { it.isValid }.map {
                        it.entity.copy(
                            stdId = targetStd,
                            subjectId = targetSubject,
                            unitId = targetUnitId,
                            unitName = targetUnitName
                        )
                    }
                    var uploadToFirestore by remember { mutableStateOf(true) }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { uploadToFirestore = !uploadToFirestore },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = uploadToFirestore,
                                onCheckedChange = { uploadToFirestore = it }
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "☁️ Bulk-upload to Firebase Firestore database (questions collection)",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF065F46)
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            OutlinedButton(
                                onClick = onDismiss,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Cancel", fontSize = 12.sp)
                            }

                            Button(
                                onClick = {
                                    if (validQuestions.isEmpty()) {
                                        Toast.makeText(context, "No valid questions to import", Toast.LENGTH_SHORT).show()
                                        return@Button
                                    }
                                    isImporting = true
                                    if (uploadToFirestore) {
                                        viewModel.bulkImportQuestionsToFirestore(validQuestions, saveToLocalRoom = true) { count, success, message ->
                                            isImporting = false
                                            Toast.makeText(
                                                context,
                                                if (success) "🎉 Successfully uploaded $count questions to Firestore & local cache!" else "Upload note: $message",
                                                Toast.LENGTH_LONG
                                            ).show()
                                            onDismiss()
                                        }
                                    } else {
                                        viewModel.insertBulkRoomQuestions(validQuestions) { count ->
                                            isImporting = false
                                            Toast.makeText(
                                                context,
                                                "🎉 Successfully imported $count questions into Class $targetStd • $targetSubject • $targetUnitName!",
                                                Toast.LENGTH_LONG
                                            ).show()
                                            onDismiss()
                                        }
                                    }
                                },
                                enabled = validQuestions.isNotEmpty() && !isImporting,
                                modifier = Modifier
                                    .weight(2f)
                                    .testTag("commit_bulk_import_button"),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                            ) {
                                if (isImporting) {
                                    CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Uploading...", fontSize = 12.sp)
                                } else {
                                    Icon(Icons.Default.DoneAll, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (uploadToFirestore) "Upload ${validQuestions.size} to Firestore" else "Import ${validQuestions.size} Questions",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Modal Dialog to edit an individual parsed question
    editingQuestionIndex?.let { index ->
        if (index in parsedQuestions.indices) {
            val item = parsedQuestions[index]
            var editPrompt by remember { mutableStateOf(item.entity.questionText) }
            var editOptions by remember { mutableStateOf(item.entity.optionsString.split('|').toMutableList()) }
            var editAnswer by remember { mutableStateOf(item.entity.correctAnswer) }
            var editExplanation by remember { mutableStateOf(item.entity.explanation) }
            var editDiff by remember { mutableStateOf(item.entity.difficulty) }

            Dialog(onDismissRequest = { editingQuestionIndex = null }) {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (isDark) Color(0xFF1E293B) else Color.White,
                    modifier = Modifier.fillMaxWidth(0.95f)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(18.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text("✏️ Edit Parsed Question #${index + 1}", fontWeight = FontWeight.Bold, fontSize = 14.sp)

                        OutlinedTextField(
                            value = editPrompt,
                            onValueChange = { editPrompt = it },
                            label = { Text("Question Prompt") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        // Options
                        Text("Options:", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        editOptions.forEachIndexed { optIdx, optVal ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text("${('A'.code + optIdx).toChar()})", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                OutlinedTextField(
                                    value = optVal,
                                    onValueChange = { newVal ->
                                        editOptions = editOptions.toMutableList().apply { set(optIdx, newVal) }
                                    },
                                    modifier = Modifier.weight(1f),
                                    singleLine = true
                                )
                                RadioButton(
                                    selected = editAnswer.equals(optVal, ignoreCase = true) && optVal.isNotBlank(),
                                    onClick = { editAnswer = optVal }
                                )
                            }
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
                            label = { Text("Explanation") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextButton(onClick = { editingQuestionIndex = null }) {
                                Text("Cancel")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = {
                                    val updatedEntity = item.entity.copy(
                                        questionText = editPrompt,
                                        optionsString = editOptions.filter { it.isNotBlank() }.joinToString("|"),
                                        correctAnswer = editAnswer,
                                        explanation = editExplanation,
                                        difficulty = editDiff
                                    )
                                    val isValid = editPrompt.length >= 5 && editAnswer.isNotBlank()
                                    parsedQuestions = parsedQuestions.toMutableList().apply {
                                        set(index, ParsedBulkQuestion(updatedEntity, isValid, if (isValid) "Valid" else "Validation issues"))
                                    }
                                    editingQuestionIndex = null
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

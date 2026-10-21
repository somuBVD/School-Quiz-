package com.example.ui.study

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.QuizViewModel

data class FormulaItem(
    val id: String,
    val title: String,
    val formula: String,
    val description: String,
    val subjectId: String,
    val standard: Int,
    val category: String,
    val unitId: String = "1"
)

object FormulaStaticRepository {
    val formulas = listOf(
        // MATHEMATICS
        FormulaItem(
            id = "m1",
            title = "Square of Sum Identity",
            formula = "(a + b)² = a² + 2ab + b²",
            description = "Standard algebraic expansion for sum of two terms",
            subjectId = "math",
            standard = 8,
            category = "Algebra",
            unitId = "algebra"
        ),
        FormulaItem(
            id = "m2",
            title = "Difference of Squares",
            formula = "(a + b)(a - b) = a² - b²",
            description = "Product of sum and difference equals difference of squares",
            subjectId = "math",
            standard = 8,
            category = "Algebra",
            unitId = "algebra"
        ),
        FormulaItem(
            id = "m3",
            title = "Quadratic Formula (ಶ್ರೀಧರಾಚಾರ್ಯ ಸೂತ್ರ)",
            formula = "x = (-b ± √(b² - 4ac)) / (2a)",
            description = "Roots of quadratic equation ax² + bx + c = 0",
            subjectId = "math",
            standard = 10,
            category = "Algebra",
            unitId = "quadratic"
        ),
        FormulaItem(
            id = "m4",
            title = "Area of Circle",
            formula = "Area = πr²  |  Circumference = 2πr",
            description = "Fundamental circle mensuration with radius r",
            subjectId = "math",
            standard = 7,
            category = "Geometry",
            unitId = "mensuration"
        ),
        FormulaItem(
            id = "m5",
            title = "Pythagoras Theorem (ಪೈಥಾಗೊರಸ್ ಪ್ರಮೇಯ)",
            formula = "Hypotenuse² = Base² + Height²  (c² = a² + b²)",
            description = "In a right-angled triangle, square of hypotenuse equals sum of squares of sides",
            subjectId = "math",
            standard = 9,
            category = "Geometry",
            unitId = "triangles"
        ),
        FormulaItem(
            id = "m6",
            title = "Trigonometric Identity #1",
            formula = "sin²θ + cos²θ = 1  |  tanθ = sinθ / cosθ",
            description = "Fundamental Pythagorean trigonometric identity",
            subjectId = "math",
            standard = 10,
            category = "Trigonometry",
            unitId = "trigonometry"
        ),
        FormulaItem(
            id = "m7",
            title = "Arithmetic Progression nth Term",
            formula = "aₙ = a + (n - 1)d  |  Sₙ = (n/2)[2a + (n - 1)d]",
            description = "General term and sum of first n terms with common difference d",
            subjectId = "math",
            standard = 10,
            category = "Algebra",
            unitId = "ap"
        ),
        FormulaItem(
            id = "m8",
            title = "Total Surface Area of Cylinder",
            formula = "TSA = 2πr(h + r)  |  Volume = πr²h",
            description = "Surface area and volume of right circular cylinder",
            subjectId = "math",
            standard = 9,
            category = "Mensuration",
            unitId = "mensuration"
        ),

        // SCIENCE
        FormulaItem(
            id = "s1",
            title = "Newton's Second Law of Motion",
            formula = "Force = mass × acceleration  (F = ma)",
            description = "Rate of change of momentum is proportional to applied force",
            subjectId = "science",
            standard = 9,
            category = "Physics",
            unitId = "motion"
        ),
        FormulaItem(
            id = "s2",
            title = "Ohm's Law (ಓಮ್‌ನ ನಿಯಮ)",
            formula = "Voltage = Current × Resistance  (V = I × R)",
            description = "Potential difference is directly proportional to current at constant temperature",
            subjectId = "science",
            standard = 10,
            category = "Physics",
            unitId = "electricity"
        ),
        FormulaItem(
            id = "s3",
            title = "Photosynthesis Reaction (ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆ)",
            formula = "6CO₂ + 6H₂O + Sunlight → C₆H₁₂O₆ + 6O₂",
            description = "Plants convert carbon dioxide and water into glucose and oxygen using chlorophyll",
            subjectId = "science",
            standard = 7,
            category = "Biology",
            unitId = "plants"
        ),
        FormulaItem(
            id = "s4",
            title = "Mirror Formula & Magnification",
            formula = "(1 / f) = (1 / v) + (1 / u)  |  m = -v / u",
            description = "Relation between focal length f, image distance v, and object distance u",
            subjectId = "science",
            standard = 10,
            category = "Physics",
            unitId = "light"
        ),
        FormulaItem(
            id = "s5",
            title = "Mendelian Monohybrid Ratio",
            formula = "Phenotypic: 3 : 1  |  Genotypic: 1 : 2 : 1",
            description = "F2 generation cross ratio for single trait inheritance",
            subjectId = "science",
            standard = 10,
            category = "Biology",
            unitId = "genetics"
        ),

        // SOCIAL SCIENCE & CONSTITUTION
        FormulaItem(
            id = "ss1",
            title = "Fundamental Rights (ಮೂಲಭೂತ ಹಕ್ಕುಗಳು)",
            formula = "Part III, Articles 14 to 32 of Indian Constitution",
            description = "Right to Equality, Freedom, Against Exploitation, Religion, Culture & Education, Remedies",
            subjectId = "social",
            standard = 8,
            category = "Civics",
            unitId = "constitution"
        ),
        FormulaItem(
            id = "ss2",
            title = "Karnataka Golden Dynasties Chronology",
            formula = "Kadambas (345 CE) → Badami Chalukyas → Rashtrakutas → Hoysalas → Vijayanagara (1336 CE)",
            description = "Historical timeline of prominent Karnataka kingdoms and cultural eras",
            subjectId = "social",
            standard = 9,
            category = "History",
            unitId = "history"
        ),

        // KANNADA & ENGLISH GRAMMAR
        FormulaItem(
            id = "g1",
            title = "ಕನ್ನಡ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳು (7 Vibhakthis)",
            formula = "ಪ್ರಥಮಾ (ಉ), ದ್ವಿತೀಯಾ (ಅನ್ನು), ತೃತೀಯಾ (ಇಂದ), ಚತುರ್ಥಿ (ಗೆ/ಕ್ಕೆ), ಪಂಚಮೀ (ದೆಸೆಯಿಂದ), ಷಷ್ಠೀ (ಅ), ಸಪ್ತಮೀ (ಅಲ್ಲಿ)",
            description = "Complete set of Kannada noun case endings (ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳು)",
            subjectId = "kannada",
            standard = 8,
            category = "Grammar",
            unitId = "grammar"
        ),
        FormulaItem(
            id = "g2",
            title = "Simple Past vs Present Perfect Tense",
            formula = "Past: Subj + V2  |  Present Perfect: Subj + have/has + V3",
            description = "Completed past action vs action with present relevance",
            subjectId = "english",
            standard = 7,
            category = "Grammar",
            unitId = "grammar"
        )
    )
}

@Composable
fun FormulaVaultDialog(
    viewModel: QuizViewModel,
    onDismiss: () -> Unit,
    onPracticeFormula: ((std: Int, subjectId: String, unitId: String) -> Unit)? = null
) {
    var selectedSubject by remember { mutableStateOf("all") }
    var selectedStandard by remember { mutableStateOf(0) } // 0 = all
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current
    val isDark by viewModel.isDarkMode.collectAsState()

    val filteredFormulas = remember(selectedSubject, selectedStandard, searchQuery) {
        FormulaStaticRepository.formulas.filter { item ->
            val matchesSubj = selectedSubject == "all" || item.subjectId == selectedSubject
            val matchesStd = selectedStandard == 0 || item.standard == selectedStandard
            val matchesQuery = searchQuery.isBlank() ||
                    item.title.contains(searchQuery, ignoreCase = true) ||
                    item.formula.contains(searchQuery, ignoreCase = true) ||
                    item.category.contains(searchQuery, ignoreCase = true)
            matchesSubj && matchesStd && matchesQuery
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .testTag("formula_vault_dialog"),
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
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
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF4F46E5).copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("📐", fontSize = 22.sp)
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "Formula Vault (ಸೂತ್ರ ಭಂಡಾರ)",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Essential formulas & rules for Std 6-10",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search formulas, laws, theorems...", fontSize = 13.sp) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp)) },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear", modifier = Modifier.size(16.dp))
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("formula_search_input"),
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true
                )

                // Subject Filters
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val subjectFilters = listOf(
                        "all" to "All Subjects",
                        "math" to "📐 Math",
                        "science" to "🔬 Science",
                        "social" to "🌍 Social",
                        "kannada" to "✍️ ಕನ್ನಡ",
                        "english" to "🔤 English",
                        "general_science" to "🌿 Environmental Studies",
                        "mental_ability" to "🧩 Mental Ability (ಬೌದ್ಧಿಕ ಸಾಮರ್ಥ್ಯ)"
                    )
                    subjectFilters.forEach { (id, label) ->
                        val isSelected = selectedSubject == id
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedSubject = id },
                            label = { Text(label, fontSize = 11.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF4F46E5),
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.testTag("filter_formula_$id")
                        )
                    }
                }

                // Standard / Grade Filters
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Class:",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    listOf(0 to "All Grades", 6 to "Std 6", 7 to "Std 7", 8 to "Std 8", 9 to "Std 9", 10 to "Std 10", 11 to "Morarji", 12 to "NMMS").forEach { (std, label) ->
                        val isSelected = selectedStandard == std
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedStandard = std },
                            label = { Text(label, fontSize = 11.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF059669),
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.testTag("filter_std_$std")
                        )
                    }
                }

                // Formula List
                if (filteredFormulas.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("🔍", fontSize = 32.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "No formulas match \"$searchQuery\"",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(filteredFormulas, key = { it.id }) { item ->
                            FormulaCard(
                                item = item,
                                isDark = isDark,
                                onCopy = {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Formula", "${item.title}: ${item.formula}")
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "Copied formula to clipboard! 📋", Toast.LENGTH_SHORT).show()
                                },
                                onPractice = {
                                    onPracticeFormula?.invoke(item.standard, item.subjectId, item.unitId)
                                    onDismiss()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun FormulaCard(
    item: FormulaItem,
    isDark: Boolean,
    onCopy: () -> Unit,
    onPractice: () -> Unit
) {
    val badgeColor = when (item.subjectId) {
        "math" -> Color(0xFF3B82F6)
        "science" -> Color(0xFF10B981)
        "social" -> Color(0xFFF59E0B)
        "kannada" -> Color(0xFFEC4899)
        else -> Color(0xFF8B5CF6)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("formula_item_${item.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
        ),
        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header: Category Pill & Class Pill
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
                        color = badgeColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "${item.subjectId.uppercase()} • ${item.category}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = badgeColor,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF059669).copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = "Std ${item.standard}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF059669),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    IconButton(
                        onClick = onCopy,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Copy Formula",
                            modifier = Modifier.size(15.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // Title
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Formula Highlighting Box
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (isDark) Color(0xFF0F172A) else Color(0xFFEEF2FF),
                border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFC7D2FE)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.formula,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isDark) Color(0xFFA5B4FC) else Color(0xFF312E81),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                )
            }

            // Description
            Text(
                text = item.description,
                fontSize = 11.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 16.sp
            )

            // Practice Action Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = onPractice,
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier.height(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Practice Quiz", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

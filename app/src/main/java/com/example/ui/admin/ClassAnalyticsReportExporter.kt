package com.example.ui.admin

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Color as AndroidColor
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Data model representing a synthesized or student performance record for educator analytics.
 */
data class StudentClassRecord(
    val id: String,
    val name: String,
    val nickname: String,
    val standard: Int,
    val accuracy: Int,
    val quizzesTaken: Int,
    val totalPoints: Int,
    val xp: Int,
    val streak: Int,
    val tier: String, // "Advanced", "Proficient", "Developing", "Needs Attention"
    val isCurrentUser: Boolean = false
)

/**
 * Data model representing an identified learning gap or misconception across the class.
 */
data class ClassLearningGap(
    val id: String,
    val subject: String,
    val unitName: String,
    val standard: Int,
    val errorRatePercentage: Int,
    val affectedStudentsCount: Int,
    val severity: String, // "Critical", "Moderate", "Minor"
    val rootMisconception: String,
    val recommendedIntervention: String
)

/**
 * Aggregated class metrics summary.
 */
data class ClassPerformanceMetrics(
    val standard: Int,
    val totalStudents: Int,
    val averageAccuracy: Int,
    val totalQuizzesCompleted: Int,
    val averageResponseTimeSecs: Float,
    val advancedCount: Int,
    val proficientCount: Int,
    val developingCount: Int,
    val needsAttentionCount: Int,
    val topSubject: String,
    val struggleSubject: String
)

/**
 * Exporter utility that generates official multi-page PDF assessment reports and CSV exports
 * for educators and school administrators to audit class-wide performance metrics and learning gaps.
 */
object ClassAnalyticsReportExporter {

    private const val TAG = "ClassAnalyticsExporter"
    private const val PAGE_WIDTH = 595  // Standard A4 width in pt
    private const val PAGE_HEIGHT = 842 // Standard A4 height in pt

    /**
     * Generates an official 2-page Class Academic Performance & Learning Gap Audit PDF document.
     */
    fun generateClassSummaryPdf(
        context: Context,
        metrics: ClassPerformanceMetrics,
        learningGaps: List<ClassLearningGap>,
        roster: List<StudentClassRecord>
    ): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "Class_Performance_Report_Std${metrics.standard}_$timeStamp.pdf"
        val file = File(context.cacheDir, fileName)

        try {
            val pdfDocument = PdfDocument()

            try {
            val paint = Paint().apply { isAntiAlias = true }
            val dateFormat = SimpleDateFormat("dd MMMM yyyy • hh:mm a", Locale.getDefault())
            val dateStr = dateFormat.format(Date())

            // ==========================================
            // PAGE 1: EXECUTIVE CLASS PERFORMANCE & KPIS
            // ==========================================
            val page1Info = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, 1).create()
            val page1 = pdfDocument.startPage(page1Info)
            val canvas1 = page1.canvas

            // Top Official Header Banner (Royal Indigo)
            paint.color = AndroidColor.rgb(30, 27, 75) // Indigo-950
            canvas1.drawRect(0f, 0f, PAGE_WIDTH.toFloat(), 105f, paint)

            paint.color = AndroidColor.rgb(99, 102, 241) // Accent strip
            canvas1.drawRect(0f, 100f, PAGE_WIDTH.toFloat(), 105f, paint)

            paint.color = AndroidColor.WHITE
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 17f
            canvas1.drawText("🏫 CLASS ACADEMIC PERFORMANCE & LEARNING GAP AUDIT", 28f, 38f, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.textSize = 9.5f
            paint.color = AndroidColor.rgb(224, 231, 255)
            val stdTitle = if (metrics.standard > 0) "Standard ${metrics.standard}" else "All Standards (Grades 6-10)"
            canvas1.drawText("Official Educator Diagnostic Report • Cohort: $stdTitle • Generated: $dateStr", 28f, 58f, paint)
            canvas1.drawText("Curriculum Standards: Karnataka State Board & CBSE Secondary Alignment", 28f, 74f, paint)

            // Document Badge
            paint.color = AndroidColor.rgb(79, 70, 229)
            canvas1.drawRoundRect(PAGE_WIDTH - 135f, 24f, PAGE_WIDTH - 24f, 50f, 6f, 6f, paint)
            paint.color = AndroidColor.WHITE
            paint.textSize = 8.5f
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            canvas1.drawText("EDU-AUDIT-2026", PAGE_WIDTH - 125f, 41f, paint)

            var currentY = 125f

            // Executive KPI Cards (Row of 4 Cards)
            val cardWidth = (PAGE_WIDTH - 56f - 24f) / 4f
            val cardHeight = 65f

            // Card 1: Students
            drawKpiBox(canvas1, paint, 28f, currentY, cardWidth, cardHeight, "STUDENTS", "${metrics.totalStudents}", "Active Cohort", AndroidColor.rgb(79, 70, 229))
            // Card 2: Average Accuracy
            drawKpiBox(canvas1, paint, 28f + cardWidth + 8f, currentY, cardWidth, cardHeight, "AVG ACCURACY", "${metrics.averageAccuracy}%", if (metrics.averageAccuracy >= 75) "Proficient" else "Review Needed", AndroidColor.rgb(16, 185, 129))
            // Card 3: Quizzes Taken
            drawKpiBox(canvas1, paint, 28f + (cardWidth + 8f) * 2, currentY, cardWidth, cardHeight, "QUIZZES COMPLETED", "${metrics.totalQuizzesCompleted}", "Cumulative", AndroidColor.rgb(59, 130, 246))
            // Card 4: Avg Speed
            drawKpiBox(canvas1, paint, 28f + (cardWidth + 8f) * 3, currentY, cardWidth, cardHeight, "AVG SPEED", String.format(Locale.getDefault(), "%.1fs", metrics.averageResponseTimeSecs), "Per Question", AndroidColor.rgb(245, 158, 11))

            currentY += cardHeight + 20f

            // Performance Tier Distribution Section
            paint.color = AndroidColor.rgb(248, 250, 252)
            canvas1.drawRoundRect(28f, currentY, PAGE_WIDTH - 28f, currentY + 75f, 8f, 8f, paint)
            paint.style = Paint.Style.STROKE
            paint.color = AndroidColor.rgb(226, 232, 240)
            paint.strokeWidth = 1f
            canvas1.drawRoundRect(28f, currentY, PAGE_WIDTH - 28f, currentY + 75f, 8f, 8f, paint)
            paint.style = Paint.Style.FILL

            paint.color = AndroidColor.rgb(30, 41, 59)
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 11f
            canvas1.drawText("📊 STUDENT MASTERY DISTRIBUTION BY TIER", 40f, currentY + 22f, paint)

            val tierColWidth = (PAGE_WIDTH - 80f) / 4f
            val tierY = currentY + 45f
            drawTierIndicator(canvas1, paint, 40f, tierY, "Advanced (80-100%)", "${metrics.advancedCount} students", AndroidColor.rgb(22, 163, 74))
            drawTierIndicator(canvas1, paint, 40f + tierColWidth, tierY, "Proficient (60-79%)", "${metrics.proficientCount} students", AndroidColor.rgb(37, 99, 235))
            drawTierIndicator(canvas1, paint, 40f + tierColWidth * 2, tierY, "Developing (40-59%)", "${metrics.developingCount} students", AndroidColor.rgb(217, 119, 6))
            drawTierIndicator(canvas1, paint, 40f + tierColWidth * 3, tierY, "Needs Support (<40%)", "${metrics.needsAttentionCount} students", AndroidColor.rgb(220, 38, 38))

            currentY += 95f

            // Section: Common Learning Gaps
            paint.color = AndroidColor.rgb(30, 41, 59)
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12f
            canvas1.drawText("⚠️ IDENTIFIED COMMON LEARNING GAPS & RECOMMENDED INTERVENTIONS", 28f, currentY, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.textSize = 8.5f
            paint.color = AndroidColor.rgb(100, 116, 139)
            canvas1.drawText("Ranked by student error frequency. Address these root misconceptions during upcoming classroom sessions.", 28f, currentY + 14f, paint)

            currentY += 26f

            // Draw up to 4 learning gap summary cards on Page 1
            learningGaps.take(4).forEach { gap ->
                drawLearningGapPdfCard(canvas1, paint, 28f, currentY, PAGE_WIDTH - 56f, 85f, gap)
                currentY += 95f
            }

            // Page 1 Footer
            paint.color = AndroidColor.rgb(148, 163, 184)
            paint.textSize = 8f
            canvas1.drawText("School Quiz Educator Dashboard • Page 1 of 2 • Confidential Academic Assessment", 28f, PAGE_HEIGHT - 20f, paint)

            pdfDocument.finishPage(page1)

            // ==========================================
            // PAGE 2: STUDENT ROSTER & INDIVIDUAL PROGRESS
            // ==========================================
            val page2Info = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, 2).create()
            val page2 = pdfDocument.startPage(page2Info)
            val canvas2 = page2.canvas

            // Page 2 Header
            paint.color = AndroidColor.rgb(30, 27, 75)
            canvas2.drawRect(0f, 0f, PAGE_WIDTH.toFloat(), 55f, paint)

            paint.color = AndroidColor.WHITE
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 13f
            canvas2.drawText("📋 CLASS STUDENT ROSTER & PERFORMANCE BREAKDOWN", 28f, 32f, paint)

            paint.color = AndroidColor.rgb(224, 231, 255)
            paint.textSize = 8.5f
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            canvas2.drawText("Cohort: $stdTitle • Ranked by Accuracy & Quiz Engagement", 28f, 46f, paint)

            currentY = 75f

            // Table Header
            paint.color = AndroidColor.rgb(241, 245, 249)
            canvas2.drawRect(28f, currentY, PAGE_WIDTH - 28f, currentY + 22f, paint)

            paint.color = AndroidColor.rgb(71, 85, 105)
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 8.5f
            canvas2.drawText("STUDENT NAME", 36f, currentY + 14f, paint)
            canvas2.drawText("CLASS", 180f, currentY + 14f, paint)
            canvas2.drawText("QUIZZES", 230f, currentY + 14f, paint)
            canvas2.drawText("ACCURACY", 290f, currentY + 14f, paint)
            canvas2.drawText("POINTS", 360f, currentY + 14f, paint)
            canvas2.drawText("STREAK", 420f, currentY + 14f, paint)
            canvas2.drawText("MASTERY STATUS", 480f, currentY + 14f, paint)

            currentY += 24f

            // Table Rows
            roster.forEachIndexed { index, student ->
                if (currentY < PAGE_HEIGHT - 60f) {
                    val rowBg = if (index % 2 == 0) AndroidColor.WHITE else AndroidColor.rgb(248, 250, 252)
                    paint.color = rowBg
                    canvas2.drawRect(28f, currentY, PAGE_WIDTH - 28f, currentY + 22f, paint)

                    paint.color = if (student.isCurrentUser) AndroidColor.rgb(67, 56, 202) else AndroidColor.rgb(30, 41, 59)
                    paint.typeface = Typeface.create(Typeface.DEFAULT, if (student.isCurrentUser) Typeface.BOLD else Typeface.NORMAL)
                    paint.textSize = 8.5f

                    val displayName = if (student.isCurrentUser) "${student.name} (Active)" else student.name
                    canvas2.drawText(displayName, 36f, currentY + 14f, paint)
                    canvas2.drawText("Std ${student.standard}", 180f, currentY + 14f, paint)
                    canvas2.drawText("${student.quizzesTaken}", 235f, currentY + 14f, paint)

                    // Accuracy color
                    paint.color = when {
                        student.accuracy >= 80 -> AndroidColor.rgb(22, 163, 74)
                        student.accuracy >= 60 -> AndroidColor.rgb(37, 99, 235)
                        else -> AndroidColor.rgb(220, 38, 38)
                    }
                    paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                    canvas2.drawText("${student.accuracy}%", 295f, currentY + 14f, paint)

                    paint.color = AndroidColor.rgb(71, 85, 105)
                    paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                    canvas2.drawText("${student.totalPoints}", 360f, currentY + 14f, paint)
                    canvas2.drawText("${student.streak} days", 420f, currentY + 14f, paint)

                    paint.color = when (student.tier) {
                        "Advanced" -> AndroidColor.rgb(22, 163, 74)
                        "Proficient" -> AndroidColor.rgb(37, 99, 235)
                        "Developing" -> AndroidColor.rgb(217, 119, 6)
                        else -> AndroidColor.rgb(220, 38, 38)
                    }
                    paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                    canvas2.drawText(student.tier, 480f, currentY + 14f, paint)

                    currentY += 22f
                }
            }

            // Page 2 Footer
            paint.color = AndroidColor.rgb(148, 163, 184)
            paint.textSize = 8f
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            canvas2.drawText("School Quiz Educator Dashboard • Page 2 of 2 • Teacher Assessment Report", 28f, PAGE_HEIGHT - 20f, paint)

            pdfDocument.finishPage(page2)

            FileOutputStream(file).use { out ->
                pdfDocument.writeTo(out)
            }

            return file
        } finally {
            try {
                pdfDocument.close()
            } catch (_: Throwable) {}
        }
    } catch (e: Throwable) {
        Log.w(TAG, "Native PdfDocument not available in current runtime, generating fallback document: ${e.message}")
        generateFallbackPdf(file, metrics, learningGaps, roster)
        return file
    }
}

    private fun generateFallbackPdf(
        file: File,
        metrics: ClassPerformanceMetrics,
        learningGaps: List<ClassLearningGap>,
        roster: List<StudentClassRecord>
    ) {
        val standardLabel = if (metrics.standard > 0) metrics.standard.toString() else "All"
        val streamText = buildString {
            append("BT /F1 14 Tf 50 780 Td (CLASS ACADEMIC PERFORMANCE & LEARNING GAP AUDIT) Tj ET\n")
            append("BT /F1 10 Tf 50 750 Td (Standard: ")
            append(standardLabel)
            append(" | Students: ")
            append(metrics.totalStudents)
            append(" | Accuracy: ")
            append(metrics.averageAccuracy)
            append("%) Tj ET\n")
            append("BT /F1 10 Tf 50 730 Td (Total Quizzes: ")
            append(metrics.totalQuizzesCompleted)
            append(" | Advanced: ")
            append(metrics.advancedCount)
            append(" | Proficient: ")
            append(metrics.proficientCount)
            append(") Tj ET\n")
            append("BT /F1 10 Tf 50 700 Td (Identified Learning Gaps: ")
            append(learningGaps.size)
            append(") Tj ET\n")
            learningGaps.take(4).forEachIndexed { index, gap ->
                val y = 680 - (index * 20)
                append("BT /F1 9 Tf 50 ")
                append(y)
                append(" Td (- [")
                append(gap.severity)
                append("] ")
                append(gap.subject)
                append(" - ")
                append(gap.unitName)
                append(": ")
                append(gap.errorRatePercentage)
                append("% error) Tj ET\n")
            }
            append("BT /F1 10 Tf 50 580 Td (Student Roster: ")
            append(roster.size)
            append(" students recorded) Tj ET\n")
        }
        val streamBytes = streamText.toByteArray(Charsets.ISO_8859_1)

        val content = buildString {
            append("%PDF-1.4\n")
            append("1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n")
            append("2 0 obj\n<< /Type /Pages /Kids [3 0 R] /Count 1 >>\nendobj\n")
            append("3 0 obj\n<< /Type /Page /Parent 2 0 R /MediaBox [0 0 595 842] /Resources << /Font << /F1 5 0 R >> >> /Contents 4 0 R >>\nendobj\n")
            append("4 0 obj\n<< /Length ${streamBytes.size} >>\nstream\n")
            append(streamText)
            append("\nendstream\nendobj\n")
            append("5 0 obj\n<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>\nendobj\n")
            append("xref\n0 6\n0000000000 65535 f \n0000000009 00000 n \n0000000058 00000 n \n0000000115 00000 n \n0000000224 00000 n \n0000000450 00000 n \ntrailer\n<< /Size 6 /Root 1 0 R >>\nstartxref\n520\n%%EOF\n")
        }
        file.writeText(content, Charsets.ISO_8859_1)
    }

    /**
     * Generates a standard CSV report string containing class metrics, student roster, and learning gaps.
     */
    fun generateClassSummaryCsv(
        metrics: ClassPerformanceMetrics,
        learningGaps: List<ClassLearningGap>,
        roster: List<StudentClassRecord>
    ): String {
        val sb = StringBuilder()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        sb.append("=== CLASS ACADEMIC PERFORMANCE SUMMARY ===\n")
        sb.append("Standard,${if (metrics.standard > 0) metrics.standard else "All"}\n")
        sb.append("Generated At,${dateFormat.format(Date())}\n")
        sb.append("Total Students,${metrics.totalStudents}\n")
        sb.append("Average Accuracy %,${metrics.averageAccuracy}\n")
        sb.append("Total Quizzes Completed,${metrics.totalQuizzesCompleted}\n")
        sb.append("Average Speed Seconds,${metrics.averageResponseTimeSecs}\n\n")

        sb.append("=== IDENTIFIED LEARNING GAPS & MISCONCEPTIONS ===\n")
        sb.append("Subject,Unit Topic,Error Rate %,Severity,Affected Students,Root Misconception,Recommended Intervention\n")
        learningGaps.forEach { gap ->
            sb.append("\"${gap.subject}\",\"${gap.unitName}\",${gap.errorRatePercentage},\"${gap.severity}\",${gap.affectedStudentsCount},\"${gap.rootMisconception.replace("\"", "\"\"")}\",\"${gap.recommendedIntervention.replace("\"", "\"\"")}\"\n")
        }
        sb.append("\n")

        sb.append("=== STUDENT ROSTER & PERFORMANCE METRICS ===\n")
        sb.append("Student Name,Standard,Quizzes Taken,Accuracy %,Total Points,XP,Streak Days,Performance Tier\n")
        roster.forEach { s ->
            sb.append("\"${s.name}\",${s.standard},${s.quizzesTaken},${s.accuracy},${s.totalPoints},${s.xp},${s.streak},\"${s.tier}\"\n")
        }

        return sb.toString()
    }

    /**
     * Saves CSV string to file in internal cache and returns the [File].
     */
    fun saveCsvReport(context: Context, csvContent: String, standard: Int): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "Class_Performance_Report_Std${standard}_$timeStamp.csv"
        val file = File(context.cacheDir, fileName)
        file.writeText(csvContent)
        return file
    }

    /**
     * Shares a generated file (PDF or CSV) via Android ACTION_SEND.
     */
    fun shareFile(context: Context, file: File, mimeType: String, title: String) {
        try {
            val authority = "${context.packageName}.fileprovider"
            val uri = FileProvider.getUriForFile(context, authority, file)

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = mimeType
                putExtra(Intent.EXTRA_STREAM, uri)
                putExtra(Intent.EXTRA_SUBJECT, title)
                putExtra(Intent.EXTRA_TEXT, "Attached is the official Class Academic Performance & Learning Gap Audit report.")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            val chooser = Intent.createChooser(intent, title).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(chooser)
        } catch (e: Exception) {
            Log.e(TAG, "Share error: ${e.message}", e)
            Toast.makeText(context, "Could not open share chooser: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Saves file to public Downloads directory.
     */
    fun saveFileToDownloads(context: Context, file: File, mimeType: String): Pair<Boolean, String> {
        return try {
            val fileName = file.name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                    put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/SchoolQuiz/TeacherReports")
                }
                val uri: Uri? = context.contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
                if (uri != null) {
                    context.contentResolver.openOutputStream(uri)?.use { out ->
                        file.inputStream().use { input -> input.copyTo(out) }
                    }
                    Pair(true, "Downloads/SchoolQuiz/TeacherReports/$fileName")
                } else {
                    Pair(false, "Failed to create media entry")
                }
            } else {
                @Suppress("DEPRECATION")
                val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                val targetDir = File(downloadsDir, "SchoolQuiz/TeacherReports").apply { mkdirs() }
                val targetFile = File(targetDir, fileName)
                file.copyTo(targetFile, overwrite = true)
                Pair(true, targetFile.absolutePath)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Save to downloads failed: ${e.message}", e)
            Pair(false, e.localizedMessage ?: "Unknown error")
        }
    }

    // --- PDF Drawing Helpers ---

    private fun drawKpiBox(
        canvas: android.graphics.Canvas,
        paint: Paint,
        x: Float,
        y: Float,
        width: Float,
        height: Float,
        label: String,
        value: String,
        subtext: String,
        accentColor: Int
    ) {
        paint.color = AndroidColor.rgb(248, 250, 252)
        canvas.drawRoundRect(x, y, x + width, y + height, 8f, 8f, paint)

        paint.style = Paint.Style.STROKE
        paint.color = AndroidColor.rgb(226, 232, 240)
        paint.strokeWidth = 1f
        canvas.drawRoundRect(x, y, x + width, y + height, 8f, 8f, paint)
        paint.style = Paint.Style.FILL

        paint.color = accentColor
        canvas.drawRect(x, y, x + 4f, y + height, paint)

        paint.color = AndroidColor.rgb(100, 116, 139)
        paint.textSize = 7f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText(label, x + 10f, y + 16f, paint)

        paint.color = AndroidColor.rgb(15, 23, 42)
        paint.textSize = 14f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText(value, x + 10f, y + 38f, paint)

        paint.color = accentColor
        paint.textSize = 7f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        canvas.drawText(subtext, x + 10f, y + 54f, paint)
    }

    private fun drawTierIndicator(canvas: android.graphics.Canvas, paint: Paint, x: Float, y: Float, label: String, count: String, color: Int) {
        paint.color = color
        canvas.drawCircle(x + 4f, y + 2f, 4f, paint)

        paint.color = AndroidColor.rgb(51, 65, 85)
        paint.textSize = 8f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText(label, x + 14f, y + 5f, paint)

        paint.color = AndroidColor.rgb(100, 116, 139)
        paint.textSize = 7.5f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        canvas.drawText(count, x + 14f, y + 18f, paint)
    }

    private fun drawLearningGapPdfCard(
        canvas: android.graphics.Canvas,
        paint: Paint,
        x: Float,
        y: Float,
        width: Float,
        height: Float,
        gap: ClassLearningGap
    ) {
        val bg = when (gap.severity) {
            "Critical" -> AndroidColor.rgb(254, 242, 242)
            "Moderate" -> AndroidColor.rgb(254, 243, 199)
            else -> AndroidColor.rgb(240, 253, 244)
        }
        val border = when (gap.severity) {
            "Critical" -> AndroidColor.rgb(254, 202, 202)
            "Moderate" -> AndroidColor.rgb(253, 230, 138)
            else -> AndroidColor.rgb(187, 247, 208)
        }
        val tagColor = when (gap.severity) {
            "Critical" -> AndroidColor.rgb(220, 38, 38)
            "Moderate" -> AndroidColor.rgb(217, 119, 6)
            else -> AndroidColor.rgb(22, 163, 74)
        }

        paint.color = bg
        canvas.drawRoundRect(x, y, x + width, y + height, 8f, 8f, paint)

        paint.style = Paint.Style.STROKE
        paint.color = border
        paint.strokeWidth = 1f
        canvas.drawRoundRect(x, y, x + width, y + height, 8f, 8f, paint)
        paint.style = Paint.Style.FILL

        // Header: Subject & Unit + Severity Pill
        paint.color = AndroidColor.rgb(15, 23, 42)
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        paint.textSize = 10f
        canvas.drawText("${gap.subject}: ${gap.unitName} (Std ${gap.standard})", x + 12f, y + 18f, paint)

        paint.color = tagColor
        canvas.drawRoundRect(x + width - 95f, y + 8f, x + width - 10f, y + 24f, 4f, 4f, paint)
        paint.color = AndroidColor.WHITE
        paint.textSize = 7.5f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText("${gap.severity.uppercase()} (${gap.errorRatePercentage}% ERR)", x + width - 90f, y + 20f, paint)

        // Misconception
        paint.color = AndroidColor.rgb(153, 27, 27)
        paint.textSize = 8.5f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText("Identified Misconception:", x + 12f, y + 36f, paint)
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        paint.color = AndroidColor.rgb(51, 65, 85)
        canvas.drawText(gap.rootMisconception.take(85), x + 125f, y + 36f, paint)

        // Recommended Intervention
        paint.color = AndroidColor.rgb(67, 56, 202)
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        paint.textSize = 8.5f
        canvas.drawText("Educator Intervention:", x + 12f, y + 54f, paint)
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        paint.color = AndroidColor.rgb(51, 65, 85)
        canvas.drawText(gap.recommendedIntervention.take(85), x + 125f, y + 54f, paint)

        // Affected students note
        paint.color = AndroidColor.rgb(100, 116, 139)
        paint.textSize = 7.5f
        canvas.drawText("Affecting ${gap.affectedStudentsCount} students • Priority recommendation for board preparation", x + 12f, y + 72f, paint)
    }
}

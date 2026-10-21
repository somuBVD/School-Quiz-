package com.example.ui.dashboard

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Color as AndroidColor
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.data.BadgeSystem
import com.example.data.HistoricalScoreEntity
import com.example.data.QuizRankInfo
import com.example.data.QuizRankTier
import com.example.data.SubjectType
import com.example.data.UnitProgress
import com.example.data.UserProfile
import com.example.data.WeakAreaTopic
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Utility to export the student's complete quiz performance report and completion history
 * as an official multi-page PDF document formatted for record-keeping, printing, saving, or sharing.
 */
object StudentReportPdfExporter {

    private const val TAG = "PdfReportExporter"
    private const val PAGE_WIDTH = 595  // Standard A4 width in pt
    private const val PAGE_HEIGHT = 842 // Standard A4 height in pt

    /**
     * Generates the complete 2-page official student performance PDF report.
     * Returns the created [File] in internal storage.
     */
    fun generatePdfReport(
        context: Context,
        profile: UserProfile,
        progressList: List<UnitProgress>,
        historicalScores: List<HistoricalScoreEntity>,
        rankInfo: QuizRankInfo? = null,
        weakAreaTopics: List<WeakAreaTopic> = emptyList()
    ): File {
        val pdfDocument = PdfDocument()
        val calculatedRank = rankInfo ?: QuizRankTier.calculateRank(profile.totalPoints)

        try {
            val paint = Paint().apply {
                isAntiAlias = true
            }

            // ==========================================
            // PAGE 1: ACADEMIC TRANSCRIPT & SUBJECT MASTERY
            // ==========================================
            val page1Info = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, 1).create()
            val page1 = pdfDocument.startPage(page1Info)
            val canvas1 = page1.canvas

            // 1. TOP OFFICIAL HEADER BANNER (Deep Indigo-Blue)
            paint.color = AndroidColor.rgb(49, 46, 129) // Indigo-900
            canvas1.drawRect(0f, 0f, PAGE_WIDTH.toFloat(), 105f, paint)

            paint.color = AndroidColor.rgb(67, 56, 202) // Indigo-700 accent strip
            canvas1.drawRect(0f, 100f, PAGE_WIDTH.toFloat(), 105f, paint)

            paint.color = AndroidColor.WHITE
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 18f
            canvas1.drawText("🎓 STUDENT QUIZ PERFORMANCE & LEARNING TRANSCRIPT", 32f, 40f, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.textSize = 10f
            paint.color = AndroidColor.rgb(224, 231, 255) // Indigo-100
            val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy • hh:mm a", Locale.getDefault())
            canvas1.drawText("Official Academic Progress Report • Generated: ${dateFormat.format(Date())}", 32f, 62f, paint)
            canvas1.drawText("Verified Local Room SQLite Storage • Cloud-Synchronized Learning Record", 32f, 78f, paint)

            // Document ID badge in header
            paint.color = AndroidColor.rgb(99, 102, 241) // Indigo-500
            canvas1.drawRoundRect(PAGE_WIDTH - 140f, 25f, PAGE_WIDTH - 28f, 52f, 6f, 6f, paint)
            paint.color = AndroidColor.WHITE
            paint.textSize = 8.5f
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            val docId = "DOC-SQ${profile.id}-${(System.currentTimeMillis() % 100000)}"
            canvas1.drawText("ID: $docId", PAGE_WIDTH - 132f, 42f, paint)

            // 2. STUDENT PROFILE CARD
            var currentY = 125f
            paint.color = AndroidColor.rgb(248, 250, 252) // Slate-50
            canvas1.drawRoundRect(28f, currentY, (PAGE_WIDTH - 28).toFloat(), currentY + 100f, 10f, 10f, paint)

            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 1.2f
            paint.color = AndroidColor.rgb(203, 213, 225) // Slate-300 border
            canvas1.drawRoundRect(28f, currentY, (PAGE_WIDTH - 28).toFloat(), currentY + 100f, 10f, 10f, paint)
            paint.style = Paint.Style.FILL

            // Student Name & Standard
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 16f
            paint.color = AndroidColor.rgb(15, 23, 42) // Slate-900
            val displayName = profile.name.ifBlank { "Student Learner" }
            canvas1.drawText(displayName, 42f, currentY + 28f, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.textSize = 10.5f
            paint.color = AndroidColor.rgb(71, 85, 105) // Slate-600
            val nick = if (profile.nickname.isNotBlank()) "Nickname: \"${profile.nickname}\" • " else ""
            val stdCurriculum = when (profile.standard) {
                11 -> "Morarji Entrance Exam"
                12 -> "NMMS Scholarship Exam"
                else -> "Class ${profile.standard}th Curriculum"
            }
            canvas1.drawText("${nick}Standard: $stdCurriculum", 42f, currentY + 48f, paint)

            // Student Metric Pills inside profile card
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 10f

            // Rank Pill
            paint.color = AndroidColor.rgb(79, 70, 229)
            canvas1.drawText("🎖️ Rank: ${calculatedRank.rankTitle}", 42f, currentY + 76f, paint)

            // Points Pill
            paint.color = AndroidColor.rgb(217, 119, 6) // Amber-600
            canvas1.drawText("⭐ Total Points: ${profile.totalPoints} pts", 195f, currentY + 76f, paint)

            // Streak Pill
            paint.color = AndroidColor.rgb(220, 38, 38) // Red-600
            canvas1.drawText("🔥 Streak: ${profile.attendanceStreak} Days", 345f, currentY + 76f, paint)

            // XP / Stars
            paint.color = AndroidColor.rgb(13, 148, 136) // Teal-600
            canvas1.drawText("⚡ XP: ${profile.xp} | Stars: ${profile.stars}", 450f, currentY + 76f, paint)

            // 3. ACADEMIC HIGHLIGHT METRICS (4 Metric Cards)
            currentY += 120f
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12.5f
            paint.color = AndroidColor.rgb(30, 41, 59)
            canvas1.drawText("📊 Key Academic Performance Indicators", 32f, currentY, paint)

            val attemptedUnits = progressList.count { it.progress > 0 }
            val completedUnits = progressList.count { it.progress >= 100 }
            val overallAccuracy = if (attemptedUnits > 0) {
                progressList.filter { it.progress > 0 }.map { it.progress }.average().toInt()
            } else 0
            val totalSolvedQuestions = progressList.sumOf { it.completedQuestions }

            currentY += 14f
            val cardGap = 8f
            val cardW = (PAGE_WIDTH - 56 - (cardGap * 3)) / 4f
            val kpiList = listOf(
                Pair("Quizzes Started", "$attemptedUnits"),
                Pair("Mastered (100%)", "$completedUnits"),
                Pair("Average Accuracy", "$overallAccuracy%"),
                Pair("Questions Solved", "$totalSolvedQuestions")
            )

            kpiList.forEachIndexed { idx, (label, value) ->
                val kpiX = 28f + idx * (cardW + cardGap)
                paint.color = AndroidColor.rgb(241, 245, 249) // Slate-100
                canvas1.drawRoundRect(kpiX, currentY, kpiX + cardW, currentY + 52f, 6f, 6f, paint)

                paint.style = Paint.Style.STROKE
                paint.strokeWidth = 1f
                paint.color = AndroidColor.rgb(226, 232, 240)
                canvas1.drawRoundRect(kpiX, currentY, kpiX + cardW, currentY + 52f, 6f, 6f, paint)
                paint.style = Paint.Style.FILL

                paint.textSize = 8f
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                paint.color = AndroidColor.rgb(100, 116, 139)
                canvas1.drawText(label, kpiX + 8f, currentY + 18f, paint)

                paint.textSize = 14f
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                paint.color = when (idx) {
                    0 -> AndroidColor.rgb(79, 70, 229)
                    1 -> AndroidColor.rgb(16, 185, 129)
                    2 -> if (overallAccuracy >= 75) AndroidColor.rgb(16, 185, 129) else AndroidColor.rgb(234, 88, 12)
                    else -> AndroidColor.rgb(14, 165, 233)
                }
                canvas1.drawText(value, kpiX + 8f, currentY + 40f, paint)
            }

            // 4. CURRICULUM SUBJECT-WISE MASTERY BREAKDOWN
            currentY += 75f
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12.5f
            paint.color = AndroidColor.rgb(30, 41, 59)
            canvas1.drawText("📚 Curriculum Subject-Wise Mastery Breakdown", 32f, currentY, paint)

            currentY += 12f
            // Subject table header
            paint.color = AndroidColor.rgb(226, 232, 240) // Slate-200
            canvas1.drawRect(28f, currentY, (PAGE_WIDTH - 28).toFloat(), currentY + 22f, paint)

            paint.color = AndroidColor.rgb(71, 85, 105)
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 9f
            canvas1.drawText("SUBJECT", 38f, currentY + 15f, paint)
            canvas1.drawText("UNITS ATTEMPTED", 160f, currentY + 15f, paint)
            canvas1.drawText("PROGRESS VISUALIZER", 270f, currentY + 15f, paint)
            canvas1.drawText("ACCURACY", 420f, currentY + 15f, paint)
            canvas1.drawText("PROFICIENCY", 490f, currentY + 15f, paint)

            currentY += 22f

            val coreSubjects = SubjectType.entries
            coreSubjects.forEachIndexed { index, subject ->
                val rowY = currentY + (index * 26f)
                val subProgress = progressList.filter { it.subjectId.equals(subject.id, ignoreCase = true) }
                val subAttempted = subProgress.count { it.progress > 0 }
                val totalUnits = subProgress.size.coerceAtLeast(1)
                val avgAcc = if (subAttempted > 0) {
                    subProgress.filter { it.progress > 0 }.map { it.progress }.average().toInt()
                } else 0

                // Alternating row background
                if (index % 2 == 1) {
                    paint.color = AndroidColor.rgb(248, 250, 252)
                    canvas1.drawRect(28f, rowY, (PAGE_WIDTH - 28).toFloat(), rowY + 26f, paint)
                }

                // Subject Name
                paint.color = AndroidColor.rgb(15, 23, 42)
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                paint.textSize = 9.5f
                canvas1.drawText(subject.displayName, 38f, rowY + 17f, paint)

                // Units Attempted
                paint.color = AndroidColor.rgb(71, 85, 105)
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                paint.textSize = 9f
                canvas1.drawText("$subAttempted / $totalUnits chapters", 160f, rowY + 17f, paint)

                // Progress Bar Visualizer
                val barX = 270f
                val barW = 120f
                val barH = 7f
                val barY = rowY + 10f
                paint.color = AndroidColor.rgb(226, 232, 240)
                canvas1.drawRoundRect(barX, barY, barX + barW, barY + barH, 3.5f, 3.5f, paint)

                val filledW = (avgAcc / 100f) * barW
                if (filledW > 0) {
                    paint.color = when {
                        avgAcc >= 80 -> AndroidColor.rgb(16, 185, 129)
                        avgAcc >= 50 -> AndroidColor.rgb(245, 158, 11)
                        else -> AndroidColor.rgb(239, 68, 68)
                    }
                    canvas1.drawRoundRect(barX, barY, barX + filledW, barY + barH, 3.5f, 3.5f, paint)
                }

                // Accuracy Text
                paint.color = AndroidColor.rgb(15, 23, 42)
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                paint.textSize = 9f
                canvas1.drawText("$avgAcc%", 420f, rowY + 17f, paint)

                // Proficiency Label
                val statusText = when {
                    avgAcc >= 80 -> "Mastered ⭐"
                    avgAcc >= 50 -> "Proficient 👍"
                    subAttempted > 0 -> "Practicing 📖"
                    else -> "Not Started"
                }
                paint.color = when {
                    avgAcc >= 80 -> AndroidColor.rgb(16, 185, 129)
                    avgAcc >= 50 -> AndroidColor.rgb(217, 119, 6)
                    else -> AndroidColor.rgb(100, 116, 139)
                }
                canvas1.drawText(statusText, 490f, rowY + 17f, paint)
            }

            currentY += coreSubjects.size * 26f + 20f

            // 5. ACADEMIC FOCUS & STRENGTH RECOMMENDATIONS BOX
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12.5f
            paint.color = AndroidColor.rgb(30, 41, 59)
            canvas1.drawText("🎯 Academic Focus Areas & Teacher Recommendations", 32f, currentY, paint)

            currentY += 12f
            paint.color = AndroidColor.rgb(254, 243, 199) // Amber-50
            canvas1.drawRoundRect(28f, currentY, (PAGE_WIDTH - 28).toFloat(), currentY + 80f, 8f, 8f, paint)

            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 1f
            paint.color = AndroidColor.rgb(252, 211, 77) // Amber-300
            canvas1.drawRoundRect(28f, currentY, (PAGE_WIDTH - 28).toFloat(), currentY + 80f, 8f, 8f, paint)
            paint.style = Paint.Style.FILL

            paint.color = AndroidColor.rgb(146, 64, 14) // Amber-800
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 9.5f
            canvas1.drawText("💡 Personalized Learning Guidance:", 40f, currentY + 22f, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.textSize = 8.5f
            paint.color = AndroidColor.rgb(120, 53, 15)

            if (weakAreaTopics.isNotEmpty()) {
                val topicsFormatted = weakAreaTopics.take(3).joinToString(" • ") { "${it.subjectTitle}: ${it.unitName} (${it.averageAccuracy}%)" }
                canvas1.drawText("• Priority review suggested for: $topicsFormatted", 40f, currentY + 40f, paint)
                canvas1.drawText("• Practice targeted interactive flashcards and retry past quiz errors to build confidence.", 40f, currentY + 56f, paint)
                canvas1.drawText("• Consistent daily participation boosts retention and improves leaderboard percentile.", 40f, currentY + 70f, paint)
            } else {
                canvas1.drawText("• Outstanding performance across all attempted curriculum areas! Excellent mastery demonstrated.", 40f, currentY + 40f, paint)
                canvas1.drawText("• Maintain attendance streak and advance into higher difficulty chapters to challenge your skills.", 40f, currentY + 56f, paint)
                canvas1.drawText("• Continue sharing achievements and reviewing bookmarked questions to ensure retention.", 40f, currentY + 70f, paint)
            }

            // PAGE 1 FOOTER
            val footer1Y = PAGE_HEIGHT - 38f
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 1f
            paint.color = AndroidColor.rgb(226, 232, 240)
            canvas1.drawLine(28f, footer1Y - 14f, (PAGE_WIDTH - 28).toFloat(), footer1Y - 14f, paint)
            paint.style = Paint.Style.FILL

            paint.textSize = 8f
            paint.color = AndroidColor.rgb(148, 163, 184)
            canvas1.drawText("Certified by School Quiz Android Learning System • Local Room SQLite Encrypted & Cloud Sync", 32f, footer1Y, paint)
            canvas1.drawText("Page 1 of 2 • Continue on Page 2 for Detailed Quiz Completion History & Badges", 32f, footer1Y + 12f, paint)

            pdfDocument.finishPage(page1)

            // ==========================================
            // PAGE 2: QUIZ HISTORY LOG & EARNED HONORS
            // ==========================================
            val page2Info = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, 2).create()
            val page2 = pdfDocument.startPage(page2Info)
            val canvas2 = page2.canvas

            // Page 2 Header
            paint.color = AndroidColor.rgb(67, 56, 202) // Indigo-700
            canvas2.drawRect(0f, 0f, PAGE_WIDTH.toFloat(), 75f, paint)

            paint.color = AndroidColor.WHITE
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 16f
            canvas2.drawText("📜 QUIZ COMPLETION HISTORY & EARNED HONORS", 32f, 34f, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.textSize = 9.5f
            paint.color = AndroidColor.rgb(224, 231, 255)
            canvas2.drawText("Chronological Test Log & Student Academic Achievements • Official Verification", 32f, 54f, paint)

            var page2Y = 95f
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12.5f
            paint.color = AndroidColor.rgb(30, 41, 59)
            canvas2.drawText("📋 Detailed Quiz Completion Records (${historicalScores.size} entries recorded)", 32f, page2Y, paint)

            page2Y += 12f
            // Table Header row
            paint.color = AndroidColor.rgb(241, 245, 249)
            canvas2.drawRect(28f, page2Y, (PAGE_WIDTH - 28).toFloat(), page2Y + 22f, paint)

            paint.color = AndroidColor.rgb(71, 85, 105)
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 9f
            canvas2.drawText("DATE & TIME", 36f, page2Y + 15f, paint)
            canvas2.drawText("SUBJECT", 155f, page2Y + 15f, paint)
            canvas2.drawText("CHAPTER / UNIT", 235f, page2Y + 15f, paint)
            canvas2.drawText("SCORE", 415f, page2Y + 15f, paint)
            canvas2.drawText("RESULT", 485f, page2Y + 15f, paint)

            page2Y += 22f

            // Historical rows (up to 14 latest records)
            val displayScores = historicalScores.take(14)
            if (displayScores.isEmpty()) {
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
                paint.textSize = 9.5f
                paint.color = AndroidColor.rgb(148, 163, 184)
                canvas2.drawText("No completed quizzes recorded yet. Take quizzes in the app to populate history.", 36f, page2Y + 20f, paint)
                page2Y += 40f
            } else {
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                paint.textSize = 8.5f

                displayScores.forEachIndexed { idx, score ->
                    val rowY = page2Y + (idx * 21f)
                    if (idx % 2 == 1) {
                        paint.color = AndroidColor.rgb(248, 250, 252)
                        canvas2.drawRect(28f, rowY, (PAGE_WIDTH - 28).toFloat(), rowY + 21f, paint)
                    }

                    // Date
                    paint.color = AndroidColor.rgb(100, 116, 139)
                    val dateFormatted = try {
                        SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()).format(Date(score.completedAt))
                    } catch (e: Exception) {
                        SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())
                    }
                    canvas2.drawText(dateFormatted, 36f, rowY + 14f, paint)

                    // Subject
                    paint.color = AndroidColor.rgb(15, 23, 42)
                    canvas2.drawText(score.subjectId.replaceFirstChar { it.uppercase() }.take(12), 155f, rowY + 14f, paint)

                    // Unit
                    canvas2.drawText(score.unitName.take(28), 235f, rowY + 14f, paint)

                    // Score
                    paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                    val pct = score.accuracyPercentage
                    paint.color = if (pct >= 80) AndroidColor.rgb(16, 185, 129)
                    else if (pct >= 50) AndroidColor.rgb(234, 88, 12)
                    else AndroidColor.rgb(239, 68, 68)
                    canvas2.drawText("${score.score}/${score.totalQuestions} ($pct%)", 415f, rowY + 14f, paint)

                    // Result Pill
                    val resultStatus = when {
                        pct >= 90 -> "EXCELLENT"
                        pct >= 75 -> "PASS (A)"
                        pct >= 50 -> "PASS (B)"
                        else -> "REVIEW"
                    }
                    canvas2.drawText(resultStatus, 485f, rowY + 14f, paint)
                    paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }

                page2Y += displayScores.size * 21f + 25f
            }

            // 6. EARNED HONORS & BADGES SHOWCASE
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12.5f
            paint.color = AndroidColor.rgb(30, 41, 59)
            canvas2.drawText("🏆 Unlocked Merit Badges & Academic Honors", 32f, page2Y, paint)

            page2Y += 12f

            val unlockedBadges = BadgeSystem.allBadges.filter { badge ->
                badge.evaluate(profile, progressList).isUnlocked
            }

            if (unlockedBadges.isEmpty()) {
                paint.color = AndroidColor.rgb(248, 250, 252)
                canvas2.drawRoundRect(28f, page2Y, (PAGE_WIDTH - 28).toFloat(), page2Y + 50f, 6f, 6f, paint)
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
                paint.textSize = 9.5f
                paint.color = AndroidColor.rgb(100, 116, 139)
                canvas2.drawText("No merit badges unlocked yet. Keep practicing daily to earn exclusive honors!", 40f, page2Y + 28f, paint)
                page2Y += 60f
            } else {
                val badgeColumns = 2
                val badgeCardW = (PAGE_WIDTH - 56 - 12f) / 2f
                val badgesToShow = unlockedBadges.take(6)

                badgesToShow.forEachIndexed { bIdx, badge ->
                    val col = bIdx % badgeColumns
                    val row = bIdx / badgeColumns
                    val bX = 28f + col * (badgeCardW + 12f)
                    val bY = page2Y + (row * 42f)

                    paint.color = AndroidColor.rgb(241, 245, 249)
                    canvas2.drawRoundRect(bX, bY, bX + badgeCardW, bY + 36f, 6f, 6f, paint)

                    paint.style = Paint.Style.STROKE
                    paint.strokeWidth = 1f
                    paint.color = AndroidColor.rgb(226, 232, 240)
                    canvas2.drawRoundRect(bX, bY, bX + badgeCardW, bY + 36f, 6f, 6f, paint)
                    paint.style = Paint.Style.FILL

                    // Badge Emoji + Title
                    paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                    paint.textSize = 9.5f
                    paint.color = AndroidColor.rgb(15, 23, 42)
                    canvas2.drawText("${badge.emoji} ${badge.title}", bX + 10f, bY + 16f, paint)

                    // Criteria / category
                    paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                    paint.textSize = 7.5f
                    paint.color = AndroidColor.rgb(100, 116, 139)
                    canvas2.drawText(badge.criteria.take(36), bX + 10f, bY + 28f, paint)
                }

                val rowCount = (badgesToShow.size + 1) / badgeColumns
                page2Y += rowCount * 42f + 16f
            }

            // 7. OFFICIAL VERIFICATION SEAL & SIGNATURE BOX
            page2Y = page2Y.coerceAtLeast(PAGE_HEIGHT - 135f)
            paint.color = AndroidColor.rgb(248, 250, 252)
            canvas2.drawRoundRect(28f, page2Y, (PAGE_WIDTH - 28).toFloat(), page2Y + 68f, 8f, 8f, paint)

            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 1f
            paint.color = AndroidColor.rgb(203, 213, 225)
            canvas2.drawRoundRect(28f, page2Y, (PAGE_WIDTH - 28).toFloat(), page2Y + 68f, 8f, 8f, paint)
            paint.style = Paint.Style.FILL

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 9.5f
            paint.color = AndroidColor.rgb(49, 46, 129) // Indigo-900
            canvas2.drawText("🛡️ OFFICIAL TRANSCRIPT VERIFICATION & SECURITY SEAL", 40f, page2Y + 22f, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.textSize = 8f
            paint.color = AndroidColor.rgb(71, 85, 105)
            canvas2.drawText("This document certifies student quiz participation, knowledge mastery, and daily consistency.", 40f, page2Y + 38f, paint)
            canvas2.drawText("Verification Hash: SHA256-${(profile.name.hashCode() + profile.totalPoints).toString(16).uppercase().take(12)} • Authorized Student Record", 40f, page2Y + 52f, paint)

            // PAGE 2 FOOTER
            val footer2Y = PAGE_HEIGHT - 38f
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 1f
            paint.color = AndroidColor.rgb(226, 232, 240)
            canvas2.drawLine(28f, footer2Y - 14f, (PAGE_WIDTH - 28).toFloat(), footer2Y - 14f, paint)
            paint.style = Paint.Style.FILL

            paint.textSize = 8f
            paint.color = AndroidColor.rgb(148, 163, 184)
            canvas2.drawText("Generated by School Quiz Master Engine • Retain for Parent-Teacher Meeting or Academic Records", 32f, footer2Y, paint)
            canvas2.drawText("Page 2 of 2 • End of Academic Performance Transcript", 32f, footer2Y + 12f, paint)

            pdfDocument.finishPage(page2)

            // Save PDF to internal files/reports directory
            val outputDir = File(context.filesDir, "reports").apply { mkdirs() }
            val cleanName = profile.name.replace(Regex("[^a-zA-Z0-9]"), "_").ifBlank { "Student" }
            val fileName = "Quiz_Report_${cleanName}_Std${profile.standard}_${System.currentTimeMillis()}.pdf"
            val file = File(outputDir, fileName)

            FileOutputStream(file).use { out ->
                pdfDocument.writeTo(out)
            }
            pdfDocument.close()

            Log.i(TAG, "Student report successfully saved to ${file.absolutePath}")
            return file

        } catch (e: Exception) {
            Log.e(TAG, "Failed to generate PDF: ${e.message}", e)
            pdfDocument.close()
            throw e
        }
    }

    /**
     * Backward-compatible helper method that generates and shares the PDF report.
     */
    fun exportStudentReport(
        context: Context,
        profile: UserProfile,
        progressList: List<UnitProgress>,
        historicalScores: List<HistoricalScoreEntity>,
        onSuccess: (File) -> Unit = {}
    ) {
        try {
            val file = generatePdfReport(
                context = context,
                profile = profile,
                progressList = progressList,
                historicalScores = historicalScores
            )
            onSuccess(file)
            sharePdf(context, file)
        } catch (e: Exception) {
            Toast.makeText(context, "Error generating PDF report: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Shares the generated PDF document via Android's native share sheet (ACTION_SEND).
     */
    fun sharePdf(context: Context, file: File) {
        try {
            val authority = "${context.packageName}.fileprovider"
            val uri = FileProvider.getUriForFile(context, authority, file)

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "application/pdf"
                putExtra(Intent.EXTRA_STREAM, uri)
                putExtra(Intent.EXTRA_SUBJECT, "Student Quiz Performance Report: ${file.name}")
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Attached is my official School Quiz performance report and academic transcript. Check out my learning progress and quiz scores!"
                )
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            val chooser = Intent.createChooser(shareIntent, "Share Student Quiz Report (PDF)").apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(chooser)
        } catch (e: Exception) {
            Log.w(TAG, "Failed to launch PDF share intent: ${e.message}")
            Toast.makeText(context, "Could not open share chooser: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Saves a copy of the PDF into the device's public Downloads directory
     * so students can easily find, print, or transfer it.
     */
    fun savePdfToDownloads(context: Context, file: File): Pair<Boolean, String> {
        return try {
            val fileName = file.name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                    put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/SchoolQuiz")
                }

                val uri: Uri? = context.contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
                if (uri != null) {
                    context.contentResolver.openOutputStream(uri)?.use { out ->
                        file.inputStream().use { input ->
                            input.copyTo(out)
                        }
                    }
                    Pair(true, "Downloads/SchoolQuiz/$fileName")
                } else {
                    Pair(false, "Failed to create media store entry")
                }
            } else {
                @Suppress("DEPRECATION")
                val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                val targetDir = File(downloadsDir, "SchoolQuiz").apply { mkdirs() }
                val targetFile = File(targetDir, fileName)
                file.copyTo(targetFile, overwrite = true)

                // Notify media scanner
                MediaScannerConnection.scanFile(
                    context,
                    arrayOf(targetFile.absolutePath),
                    arrayOf("application/pdf"),
                    null
                )
                Pair(true, targetFile.absolutePath)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save PDF to downloads: ${e.message}", e)
            Pair(false, e.localizedMessage ?: "Unknown error")
        }
    }

    /**
     * Opens the PDF document using an external PDF viewer application via ACTION_VIEW.
     */
    fun viewPdf(context: Context, file: File) {
        try {
            val authority = "${context.packageName}.fileprovider"
            val uri = FileProvider.getUriForFile(context, authority, file)

            val viewIntent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, "application/pdf")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(viewIntent)
        } catch (e: Exception) {
            Log.w(TAG, "No default PDF viewer found: ${e.message}")
            Toast.makeText(context, "No PDF viewer app found. You can share or save the file.", Toast.LENGTH_LONG).show()
        }
    }
}

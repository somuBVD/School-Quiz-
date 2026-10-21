package com.example

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.example.ui.admin.ClassAnalyticsReportExporter
import com.example.ui.admin.ClassLearningGap
import com.example.ui.admin.ClassPerformanceMetrics
import com.example.ui.admin.StudentClassRecord
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ClassAnalyticsAndReportsTest {

    private lateinit var application: Application

    private val sampleMetrics = ClassPerformanceMetrics(
        standard = 6,
        totalStudents = 12,
        averageAccuracy = 76,
        totalQuizzesCompleted = 84,
        averageResponseTimeSecs = 14.5f,
        advancedCount = 5,
        proficientCount = 4,
        developingCount = 2,
        needsAttentionCount = 1,
        topSubject = "Mathematics & Science",
        struggleSubject = "Fractions & Grammar"
    )

    private val sampleGaps = listOf(
        ClassLearningGap(
            id = "g1",
            subject = "Mathematics",
            unitName = "Fractions & Decimals",
            standard = 6,
            errorRatePercentage = 58,
            affectedStudentsCount = 7,
            severity = "Critical",
            rootMisconception = "Directly adding denominators instead of finding LCM.",
            recommendedIntervention = "Model step-by-step LCM finding with visual fraction bars."
        ),
        ClassLearningGap(
            id = "g2",
            subject = "Science",
            unitName = "Acids and Bases",
            standard = 6,
            errorRatePercentage = 45,
            affectedStudentsCount = 5,
            severity = "Moderate",
            rootMisconception = "Confusion between red and blue litmus color changes.",
            recommendedIntervention = "Use mnemonic BRA (Blue to Red is Acid) and virtual indicator lab."
        )
    )

    private val sampleRoster = listOf(
        StudentClassRecord(
            id = "s1",
            name = "Suhas Govind",
            nickname = "StarScholar",
            standard = 6,
            accuracy = 92,
            quizzesTaken = 14,
            totalPoints = 2100,
            xp = 1450,
            streak = 6,
            tier = "Advanced",
            isCurrentUser = true
        ),
        StudentClassRecord(
            id = "s2",
            name = "Rohan Kumar",
            nickname = "Rohan",
            standard = 6,
            accuracy = 64,
            quizzesTaken = 8,
            totalPoints = 1200,
            xp = 800,
            streak = 3,
            tier = "Proficient",
            isCurrentUser = false
        )
    )

    @Before
    fun setup() {
        application = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testGenerateClassSummaryPdfCreatesValidDocument() {
        val pdfFile = ClassAnalyticsReportExporter.generateClassSummaryPdf(
            context = application,
            metrics = sampleMetrics,
            learningGaps = sampleGaps,
            roster = sampleRoster
        )

        assertNotNull("Generated PDF file should not be null", pdfFile)
        assertTrue("PDF file must exist", pdfFile.exists())
        assertTrue("PDF file size must be greater than zero", pdfFile.length() > 0)
        assertTrue("File name should indicate class report", pdfFile.name.contains("Class_Performance_Report"))
    }

    @Test
    fun testGenerateClassSummaryCsvContent() {
        val csv = ClassAnalyticsReportExporter.generateClassSummaryCsv(
            metrics = sampleMetrics,
            learningGaps = sampleGaps,
            roster = sampleRoster
        )

        assertNotNull(csv)
        assertTrue("Should include executive section", csv.contains("CLASS ACADEMIC PERFORMANCE SUMMARY"))
        assertTrue("Should contain metrics standard", csv.contains("Standard,6"))
        assertTrue("Should contain accuracy", csv.contains("Average Accuracy %,76"))
        assertTrue("Should contain learning gap header", csv.contains("IDENTIFIED LEARNING GAPS & MISCONCEPTIONS"))
        assertTrue("Should contain gap misconception", csv.contains("Directly adding denominators instead of finding LCM."))
        assertTrue("Should contain student roster header", csv.contains("STUDENT ROSTER & PERFORMANCE METRICS"))
        assertTrue("Should contain student name", csv.contains("Suhas Govind"))
        assertTrue("Should contain student tier", csv.contains("Advanced"))
    }

    @Test
    fun testSaveCsvReportCreatesFile() {
        val csvContent = ClassAnalyticsReportExporter.generateClassSummaryCsv(
            metrics = sampleMetrics,
            learningGaps = sampleGaps,
            roster = sampleRoster
        )

        val csvFile = ClassAnalyticsReportExporter.saveCsvReport(
            context = application,
            csvContent = csvContent,
            standard = 6
        )

        assertTrue("CSV file must exist", csvFile.exists())
        assertTrue("CSV file must contain data", csvFile.length() > 0)
        assertTrue("File extension should be csv", csvFile.name.endsWith(".csv"))
    }

    @Test
    fun testMetricsTierIntegrity() {
        val sumTiers = sampleMetrics.advancedCount + sampleMetrics.proficientCount +
                       sampleMetrics.developingCount + sampleMetrics.needsAttentionCount
        assertEquals("Sum of tiers should equal total students", sampleMetrics.totalStudents, sumTiers)
        assertTrue("Average accuracy should be valid percentage", sampleMetrics.averageAccuracy in 0..100)
    }
}

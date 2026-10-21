package com.example.data

/**
 * Underlying pedagogical reason why a quiz is recommended to the student.
 */
enum class RecommendationReason(
    val title: String,
    val icon: String,
    val tagColorHex: Long
) {
    NEEDS_PRACTICE("Needs Practice", "🎯", 0xFFEF4444),       // Score < 70% in a category: revise and improve
    CRITICAL_WEAKNESS("Critical Weak Area", "⚠️", 0xFFDC2626), // Score < 50% or multiple failures
    FAILED_RETRY("Failed Quiz Re-attempt", "🔄", 0xFFEA580C),  // Most recent attempt was failed
    LOW_ACCURACY("Low Accuracy Revise", "📉", 0xFFE11D48),      // Low accuracy (50-69%)
    SUBJECT_REINFORCEMENT("Weak Subject Reinforcement", "📚", 0xFF7C3AED), // Whole subject has low accuracy
    NEXT_IN_SEQUENCE("Next Chapter", "🚀", 0xFF3B82F6),        // Solved unit N with good score, suggest unit N+1
    STRONG_SUBJECT("Mastery Focus", "⭐", 0xFF10B981),         // Category has > 80% score: conquer more in this strong subject
    UNEXPLORED_TOPIC("Discover New", "✨", 0xFF8B5CF6),        // No attempts in this subject yet
    STREAK_BUILDER("Quick Win", "⚡", 0xFFF59E0B);             // Short / Easy quiz to keep momentum going

    val isWeakArea: Boolean
        get() = this == NEEDS_PRACTICE ||
                this == CRITICAL_WEAKNESS ||
                this == FAILED_RETRY ||
                this == LOW_ACCURACY ||
                this == SUBJECT_REINFORCEMENT
}

/**
 * Severity level of an identified student weak area.
 */
enum class WeaknessUrgency(val label: String, val emoji: String, val colorHex: Long) {
    CRITICAL("Critical Focus", "🚨", 0xFFDC2626),
    MODERATE("Needs Revision", "⚠️", 0xFFEA580C),
    MILD("Improvement Area", "📈", 0xFFF59E0B)
}

/**
 * Detailed representation of a specific topic / unit identified as a weak area
 * from Room database records (historical_scores and unit_progress).
 */
data class WeakAreaTopic(
    val stdId: Int,
    val subjectId: String,
    val subjectTitle: String,
    val subjectColorHex: Long,
    val unitId: Int,
    val unitName: String,
    val averageAccuracy: Int,
    val attemptsCount: Int,
    val failedCount: Int,
    val difficulty: String,
    val urgencyLevel: WeaknessUrgency,
    val diagnosticSummary: String
)

/**
 * Categorical performance status for a subject area based on Room persistence records.
 */
enum class CategoryStatus(val label: String, val emoji: String, val colorHex: Long) {
    STRONG("Strong Mastery", "🌟", 0xFF10B981),
    DEVELOPING("Developing", "📈", 0xFF3B82F6),
    WEAK("Needs Attention", "🎯", 0xFFEF4444),
    UNTOUCHED("Unexplored", "🌱", 0xFF94A3B8)
}

/**
 * Category-level statistical summary calculated from Room database entries.
 */
data class CategoryPerformanceSummary(
    val subjectId: String,
    val subjectTitle: String,
    val subjectColorHex: Long,
    val totalUnits: Int,
    val attemptedUnits: Int,
    val completedUnits: Int,
    val averageScore: Int,
    val status: CategoryStatus
)

/**
 * A personalized quiz recommendation tailored to student weaknesses, strengths, and curriculum progression.
 */
data class QuizRecommendation(
    val id: String,
    val stdId: Int,
    val subjectId: String,
    val subjectTitle: String,
    val subjectColorHex: Long,
    val unitId: Int,
    val unitName: String,
    val totalQuestions: Int,
    val difficulty: String,
    val reason: RecommendationReason,
    val badgeLabel: String,
    val rationale: String,
    val currentAccuracy: Int, // Previous performance % (0 if untouched)
    val priorityScore: Float, // Internal score for sorting
    val xpReward: Int,
    val isCompleted: Boolean,
    val historicalAttemptsCount: Int = 0,
    val failedAttemptsCount: Int = 0,
    val roomStatsDiagnostic: String = ""
)

/**
 * Recommendation engine that analyzes student performance in Room database
 * (both UnitProgress records and HistoricalScoreEntity quiz attempts)
 * to identify weak areas and formulate tailored, high-priority quiz topic recommendations.
 */
object QuizRecommendationEngine {

    /**
     * Computes subject category mastery levels from Room UnitProgress records.
     */
    fun calculateCategorySummaries(
        progressList: List<UnitProgress>,
        standard: Int
    ): List<CategoryPerformanceSummary> {
        val standardTemplate = QuizStaticData.standardsList.find { it.std == standard }
            ?: QuizStaticData.standardsList.firstOrNull() ?: return emptyList()

        return standardTemplate.subjects.map { subject ->
            val units = subject.units
            val totalUnits = units.size
            val subProgress = progressList.filter { it.stdId == standard && it.subjectId == subject.id }

            val completedUnits = subProgress.count { it.progress >= 100 }
            val attemptedUnits = subProgress.count { it.progress > 0 }
            val avgScore = if (attemptedUnits > 0) {
                val nonZero = subProgress.filter { it.progress > 0 }
                if (nonZero.isNotEmpty()) {
                    nonZero.map { it.progress }.average().toInt()
                } else 0
            } else 0

            val status = when {
                attemptedUnits == 0 -> CategoryStatus.UNTOUCHED
                avgScore >= 80 -> CategoryStatus.STRONG
                avgScore < 60 -> CategoryStatus.WEAK
                else -> CategoryStatus.DEVELOPING
            }

            CategoryPerformanceSummary(
                subjectId = subject.id,
                subjectTitle = subject.title,
                subjectColorHex = subject.colorHex,
                totalUnits = totalUnits,
                attemptedUnits = attemptedUnits,
                completedUnits = completedUnits,
                averageScore = avgScore,
                status = status
            )
        }
    }

    /**
     * Identifies specific weak area topics from Room database statistics.
     * Evaluates both historical attempt logs (HistoricalScoreEntity) and current progress (UnitProgress).
     */
    fun identifyWeakAreaTopics(
        progressList: List<UnitProgress>,
        historicalScores: List<HistoricalScoreEntity>,
        standard: Int
    ): List<WeakAreaTopic> {
        val standardTemplate = QuizStaticData.standardsList.find { it.std == standard }
            ?: QuizStaticData.standardsList.firstOrNull() ?: return emptyList()

        val weakTopics = mutableListOf<WeakAreaTopic>()
        val progressMap = progressList.filter { it.stdId == standard }
            .associateBy { "${it.subjectId.lowercase()}_${it.unitId}" }
        val scoresByUnit = historicalScores.filter { it.stdId == standard }
            .groupBy { "${it.subjectId.lowercase()}_${it.unitId}" }

        for (subject in standardTemplate.subjects) {
            for (unit in subject.units) {
                val key = "${subject.id.lowercase()}_${unit.id}"
                val unitScores = scoresByUnit[key] ?: emptyList()
                val unitProg = progressMap[key]

                val attemptsCount = unitScores.size
                val failedCount = unitScores.count { !it.isPassed || it.accuracyPercentage < 50 }

                // Calculate blended accuracy from historical scores or progress
                val avgAcc = when {
                    unitScores.isNotEmpty() -> unitScores.map { it.accuracyPercentage }.average().toInt()
                    unitProg != null && unitProg.progress > 0 -> unitProg.progress
                    else -> null
                }

                if (avgAcc != null && avgAcc < 70) {
                    val urgency = when {
                        avgAcc < 50 || failedCount >= 2 -> WeaknessUrgency.CRITICAL
                        avgAcc < 60 || failedCount >= 1 -> WeaknessUrgency.MODERATE
                        else -> WeaknessUrgency.MILD
                    }

                    val summary = when (urgency) {
                        WeaknessUrgency.CRITICAL -> "Critical struggle: $avgAcc% accuracy with $failedCount failed attempt(s). Needs immediate revision."
                        WeaknessUrgency.MODERATE -> "Moderate weak area: $avgAcc% average score across $attemptsCount attempt(s)."
                        WeaknessUrgency.MILD -> "Developing area: $avgAcc% mastery. A quick quiz will push you past the 70% threshold."
                    }

                    weakTopics.add(
                        WeakAreaTopic(
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            averageAccuracy = avgAcc,
                            attemptsCount = attemptsCount,
                            failedCount = failedCount,
                            difficulty = unit.difficulty,
                            urgencyLevel = urgency,
                            diagnosticSummary = summary
                        )
                    )
                }
            }
        }

        return weakTopics.sortedBy { it.averageAccuracy }
    }

    /**
     * Backward-compatible overload for existing calls.
     */
    fun generateRecommendations(
        userProfile: UserProfile?,
        progressList: List<UnitProgress>,
        standard: Int
    ): List<QuizRecommendation> = generateRecommendations(userProfile, progressList, emptyList(), standard)

    /**
     * Generates an intelligently ranked list of quiz recommendations based on
     * student weak areas identified from the Room database stats.
     */
    fun generateRecommendations(
        userProfile: UserProfile?,
        progressList: List<UnitProgress>,
        historicalScores: List<HistoricalScoreEntity>,
        standard: Int
    ): List<QuizRecommendation> {
        val standardTemplate = QuizStaticData.standardsList.find { it.std == standard }
            ?: QuizStaticData.standardsList.firstOrNull() ?: return emptyList()

        val recommendations = mutableListOf<QuizRecommendation>()
        val categorySummaries = calculateCategorySummaries(progressList, standard)
        val categoryMap = categorySummaries.associateBy { it.subjectId }

        // Pre-aggregate Room historical quiz scores per unit
        val historicalScoresMap = historicalScores.filter { it.stdId == standard }
            .groupBy { "${it.subjectId.lowercase()}_${it.unitId}" }

        // Also aggregate historical scores at subject level to detect weak subjects
        val subjectScoresMap = historicalScores.filter { it.stdId == standard }
            .groupBy { it.subjectId.lowercase() }
        val weakSubjectIds = subjectScoresMap.filter { (_, scores) ->
            scores.isNotEmpty() && scores.map { it.accuracyPercentage }.average() < 65.0
        }.keys

        for (subject in standardTemplate.subjects) {
            val summary = categoryMap[subject.id]
            val subProgress = progressList.filter { it.stdId == standard && it.subjectId == subject.id }
            val progressByUnit = subProgress.associateBy { it.unitId }
            val isWeakSubject = weakSubjectIds.contains(subject.id.lowercase()) || (summary?.status == CategoryStatus.WEAK)

            for ((index, unit) in subject.units.withIndex()) {
                val unitProgress = progressByUnit[unit.id]
                val currentScore = unitProgress?.progress ?: 0
                val isCompleted = currentScore >= 100

                val unitHistKey = "${subject.id.lowercase()}_${unit.id}"
                val unitHistoricalAttempts = historicalScoresMap[unitHistKey] ?: emptyList()
                val attemptsCount = unitHistoricalAttempts.size
                val failedCount = unitHistoricalAttempts.count { !it.isPassed || it.accuracyPercentage < 50 }
                val latestAttempt = unitHistoricalAttempts.maxByOrNull { it.completedAt }
                val histAccuracy = if (unitHistoricalAttempts.isNotEmpty()) {
                    unitHistoricalAttempts.map { it.accuracyPercentage }.average().toInt()
                } else currentScore

                // =====================================================================
                // HEURISTIC 1A: CRITICAL WEAK AREA (Room stats show <50% or multiple failures)
                // =====================================================================
                if ((histAccuracy in 1..49) || (failedCount >= 2)) {
                    val priority = 130f + (100f - histAccuracy.toFloat()) + (failedCount * 10f)
                    recommendations.add(
                        QuizRecommendation(
                            id = "${standard}_${subject.id}_${unit.id}_critical_weakness",
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            totalQuestions = unit.totalQuestions,
                            difficulty = unit.difficulty,
                            reason = RecommendationReason.CRITICAL_WEAKNESS,
                            badgeLabel = "Critical Weak Area (${histAccuracy}%)",
                            rationale = "Room stats report ${histAccuracy}% accuracy across $attemptsCount attempts with $failedCount failed test(s). Targeted practice will build foundational understanding.",
                            currentAccuracy = histAccuracy,
                            priorityScore = priority,
                            xpReward = unit.totalQuestions * 20,
                            isCompleted = false,
                            historicalAttemptsCount = attemptsCount,
                            failedAttemptsCount = failedCount,
                            roomStatsDiagnostic = "$attemptsCount attempts • $failedCount failed • $histAccuracy% avg accuracy"
                        )
                    )
                }

                // =====================================================================
                // HEURISTIC 1B: FAILED RETRY (Latest attempt in Room is failed)
                // =====================================================================
                else if (latestAttempt != null && (!latestAttempt.isPassed || latestAttempt.accuracyPercentage < 50)) {
                    val priority = 115f + (100f - latestAttempt.accuracyPercentage.toFloat())
                    recommendations.add(
                        QuizRecommendation(
                            id = "${standard}_${subject.id}_${unit.id}_failed_retry",
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            totalQuestions = unit.totalQuestions,
                            difficulty = unit.difficulty,
                            reason = RecommendationReason.FAILED_RETRY,
                            badgeLabel = "Retry Failed Quiz (${latestAttempt.accuracyPercentage}%)",
                            rationale = "Your last quiz on ${unit.name} fell below the pass mark (${latestAttempt.score}/${latestAttempt.totalQuestions}). Re-attempt to clear this hurdle!",
                            currentAccuracy = latestAttempt.accuracyPercentage,
                            priorityScore = priority,
                            xpReward = unit.totalQuestions * 18,
                            isCompleted = false,
                            historicalAttemptsCount = attemptsCount,
                            failedAttemptsCount = failedCount,
                            roomStatsDiagnostic = "Last attempt failed (${latestAttempt.accuracyPercentage}%)"
                        )
                    )
                }

                // =====================================================================
                // HEURISTIC 1C: MODERATE WEAK AREA / NEEDS PRACTICE (Score in 50..69%)
                // =====================================================================
                else if (histAccuracy in 50..69 || currentScore in 1..69) {
                    val scoreToUse = if (histAccuracy in 50..69) histAccuracy else currentScore
                    val priority = 95f + (100f - scoreToUse.toFloat())
                    recommendations.add(
                        QuizRecommendation(
                            id = "${standard}_${subject.id}_${unit.id}_practice",
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            totalQuestions = unit.totalQuestions,
                            difficulty = unit.difficulty,
                            reason = RecommendationReason.NEEDS_PRACTICE,
                            badgeLabel = "Improve Score (${scoreToUse}%)",
                            rationale = "You previously scored $scoreToUse% in ${subject.title}. Re-attempting will help master key concepts and earn bonus XP!",
                            currentAccuracy = scoreToUse,
                            priorityScore = priority,
                            xpReward = unit.totalQuestions * 15,
                            isCompleted = false,
                            historicalAttemptsCount = attemptsCount,
                            failedAttemptsCount = failedCount,
                            roomStatsDiagnostic = if (attemptsCount > 0) "$attemptsCount attempts • $scoreToUse% avg accuracy" else "Recorded score: $scoreToUse%"
                        )
                    )
                }

                // =====================================================================
                // HEURISTIC 1D: WEAK SUBJECT FOUNDATION REINFORCEMENT
                // (Subject overall accuracy < 65% and this unit is not completed)
                // =====================================================================
                if (isWeakSubject && currentScore < 80 && recommendations.none { it.id.startsWith("${standard}_${subject.id}_${unit.id}") }) {
                    recommendations.add(
                        QuizRecommendation(
                            id = "${standard}_${subject.id}_${unit.id}_subject_reinf",
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            totalQuestions = unit.totalQuestions,
                            difficulty = unit.difficulty,
                            reason = RecommendationReason.SUBJECT_REINFORCEMENT,
                            badgeLabel = "Reinforce Weak Subject",
                            rationale = "Your overall performance in ${subject.title} is below average. Working through Unit ${unit.id} will strengthen your foundations.",
                            currentAccuracy = currentScore,
                            priorityScore = 85f - (currentScore * 0.2f),
                            xpReward = unit.totalQuestions * 16,
                            isCompleted = isCompleted,
                            historicalAttemptsCount = attemptsCount,
                            failedAttemptsCount = failedCount,
                            roomStatsDiagnostic = "Overall ${subject.title} needs improvement"
                        )
                    )
                }

                // =====================================================================
                // HEURISTIC 2: NEXT IN SEQUENCE
                // =====================================================================
                if (index > 0) {
                    val prevUnit = subject.units[index - 1]
                    val prevProgress = progressByUnit[prevUnit.id]?.progress ?: 0
                    if (prevProgress >= 60 && currentScore < 100) {
                        val priority = 70f + (prevProgress.toFloat() * 0.2f)
                        recommendations.add(
                            QuizRecommendation(
                                id = "${standard}_${subject.id}_${unit.id}_next",
                                stdId = standard,
                                subjectId = subject.id,
                                subjectTitle = subject.title,
                                subjectColorHex = subject.colorHex,
                                unitId = unit.id,
                                unitName = unit.name,
                                totalQuestions = unit.totalQuestions,
                                difficulty = unit.difficulty,
                                reason = RecommendationReason.NEXT_IN_SEQUENCE,
                                badgeLabel = "Next Chapter",
                                rationale = "You did great in Unit ${prevUnit.id} (${prevProgress}%). Continue your curriculum sequence with Unit ${unit.id}!",
                                currentAccuracy = currentScore,
                                priorityScore = priority + 25f,
                                xpReward = unit.totalQuestions * 15,
                                isCompleted = isCompleted,
                                historicalAttemptsCount = attemptsCount,
                                failedAttemptsCount = failedCount
                            )
                        )
                    }
                }

                // =====================================================================
                // HEURISTIC 3: STRONG SUBJECT MASTERY
                // =====================================================================
                if (summary?.status == CategoryStatus.STRONG && currentScore < 100) {
                    recommendations.add(
                        QuizRecommendation(
                            id = "${standard}_${subject.id}_${unit.id}_strong",
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            totalQuestions = unit.totalQuestions,
                            difficulty = unit.difficulty,
                            reason = RecommendationReason.STRONG_SUBJECT,
                            badgeLabel = "Mastery Challenge",
                            rationale = "You have ${summary.averageScore}% average mastery in ${subject.title}! Complete this unit to dominate the leaderboard.",
                            currentAccuracy = currentScore,
                            priorityScore = 75f + (summary.averageScore * 0.1f),
                            xpReward = unit.totalQuestions * 15 + 20,
                            isCompleted = isCompleted,
                            historicalAttemptsCount = attemptsCount,
                            failedAttemptsCount = failedCount
                        )
                    )
                }

                // =====================================================================
                // HEURISTIC 4: UNTOUCHED SUBJECT DISCOVERY
                // =====================================================================
                if (summary?.status == CategoryStatus.UNTOUCHED && unit.id == 1) {
                    recommendations.add(
                        QuizRecommendation(
                            id = "${standard}_${subject.id}_${unit.id}_discover",
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            totalQuestions = unit.totalQuestions,
                            difficulty = unit.difficulty,
                            reason = RecommendationReason.UNEXPLORED_TOPIC,
                            badgeLabel = "New Subject",
                            rationale = "You haven't explored ${subject.title} yet. Jump in with this introductory quiz to earn easy coins!",
                            currentAccuracy = 0,
                            priorityScore = 65f,
                            xpReward = unit.totalQuestions * 15 + 10,
                            isCompleted = false
                        )
                    )
                }

                // =====================================================================
                // HEURISTIC 5: STREAK BUILDER / QUICK WIN
                // =====================================================================
                if ((userProfile?.attendanceStreak ?: 0) >= 3 && unit.difficulty == "Easy" && currentScore < 100) {
                    recommendations.add(
                        QuizRecommendation(
                            id = "${standard}_${subject.id}_${unit.id}_streak",
                            stdId = standard,
                            subjectId = subject.id,
                            subjectTitle = subject.title,
                            subjectColorHex = subject.colorHex,
                            unitId = unit.id,
                            unitName = unit.name,
                            totalQuestions = unit.totalQuestions,
                            difficulty = unit.difficulty,
                            reason = RecommendationReason.STREAK_BUILDER,
                            badgeLabel = "Quick Momentum",
                            rationale = "A brisk ${unit.totalQuestions}-question test to keep your ${userProfile?.attendanceStreak ?: 1}-day streak alive!",
                            currentAccuracy = currentScore,
                            priorityScore = 60f,
                            xpReward = unit.totalQuestions * 15,
                            isCompleted = isCompleted
                        )
                    )
                }
            }
        }

        // Deduplicate recommendations by unit (keep the one with highest priority score)
        return recommendations
            .groupBy { "${it.stdId}_${it.subjectId}_${it.unitId}" }
            .map { (_, list) -> list.maxByOrNull { it.priorityScore }!! }
            .sortedByDescending { it.priorityScore }
    }
}

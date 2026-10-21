package com.example.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Filter options for historical data evaluation.
 */
enum class DashboardTimeRange(val displayName: String) {
    ALL_TIME("All Time"),
    PAST_7_DAYS("Last 7 Days"),
    PAST_30_DAYS("Last 30 Days")
}

/**
 * Performance metrics aggregated per subject.
 */
data class SubjectAggregateStat(
    val subjectId: String,
    val subjectName: String,
    val totalAttempts: Int,
    val averageAccuracy: Float,
    val highScore: Int,
    val totalQuestionsAnswered: Int,
    val totalCorrectAnswers: Int,
    val totalXpEarned: Int,
    val passedCount: Int,
    val passRatePercentage: Float,
    val colorHex: Long
)

/**
 * Daily aggregation for performance charting and trends.
 */
data class DayPerformanceStat(
    val dayLabel: String,
    val timestamp: Long,
    val attemptsCount: Int,
    val averageAccuracy: Float,
    val xpEarned: Int
)

/**
 * Aggregated UI state for the student dashboard.
 */
data class StudentDashboardUiState(
    val isLoading: Boolean = false,
    val totalQuizzesAttempted: Int = 0,
    val passedQuizzesCount: Int = 0,
    val passRatePercentage: Float = 0f,
    val overallAverageAccuracy: Float = 0f,
    val totalQuestionsAnswered: Int = 0,
    val totalCorrectAnswers: Int = 0,
    val totalXpEarned: Int = 0,
    val totalCoinsEarned: Int = 0,
    val totalStarsEarned: Int = 0,
    val totalTimeSpentSeconds: Int = 0,
    val perfectScoresCount: Int = 0,

    // Strengths & Weaknesses
    val strongestSubject: SubjectAggregateStat? = null,
    val subjectNeedingFocus: SubjectAggregateStat? = null,
    val subjectStats: List<SubjectAggregateStat> = emptyList(),

    // Room Database Stats Recommendation Engine & Weak Areas
    val recommendations: List<QuizRecommendation> = emptyList(),
    val weakAreaTopics: List<WeakAreaTopic> = emptyList(),
    val criticalWeakAreasCount: Int = 0,

    // Temporal Trends
    val recentAttempts: List<HistoricalScoreEntity> = emptyList(),
    val recentAccuracyTrend: List<Float> = emptyList(),
    val weeklyPerformance: List<DayPerformanceStat> = emptyList(),
    val monthlyPerformance: List<DayPerformanceStat> = emptyList(),

    // User Profile & Unit Completion
    val studentName: String = "",
    val studentStandard: Int = 6,
    val completedUnitsCount: Int = 0,
    val totalUnitsCount: Int = 0,
    val totalPoints: Int = 0,
    val quizRank: QuizRankInfo = QuizRankTier.calculateRank(0),
    val studentLevel: StudentLevelInfo = StudentLevelSystem.calculateLevel(0),

    // Filters
    val selectedStandardFilter: Int? = null, // null = all standards
    val selectedTimeRange: DashboardTimeRange = DashboardTimeRange.ALL_TIME,
    val selectedSubjectFilter: String? = null // null = all subjects
)

/**
 * ViewModel for the student dashboard that aggregates historical performance data
 * from the Room database (historical_scores, unit_progress, user_profile)
 * and calculates comprehensive statistics for display.
 */
class StudentDashboardViewModel(
    private val repository: QuizRepository
) : ViewModel() {

    private val _selectedStandardFilter = MutableStateFlow<Int?>(null)
    val selectedStandardFilter: StateFlow<Int?> = _selectedStandardFilter.asStateFlow()

    private val _selectedTimeRange = MutableStateFlow(DashboardTimeRange.ALL_TIME)
    val selectedTimeRange: StateFlow<DashboardTimeRange> = _selectedTimeRange.asStateFlow()

    private val _selectedSubjectFilter = MutableStateFlow<String?>(null)
    val selectedSubjectFilter: StateFlow<String?> = _selectedSubjectFilter.asStateFlow()

    private val _isLoading = MutableStateFlow(false)

    private data class FilterState(
        val standard: Int? = null,
        val timeRange: DashboardTimeRange = DashboardTimeRange.ALL_TIME,
        val subject: String? = null
    )

    private val filterState: Flow<FilterState> = combine(
        _selectedStandardFilter,
        _selectedTimeRange,
        _selectedSubjectFilter
    ) { std, time, subject ->
        FilterState(std, time, subject)
    }

    // Aggregate flows from Room repository
    val uiState: StateFlow<StudentDashboardUiState> = combine(
        repository.allHistoricalScores,
        repository.getAllUnitProgress(),
        repository.userProfile,
        filterState
    ) { scores, progressList, profile, filters ->
        calculateDashboardStatistics(
            scores = scores,
            progressList = progressList,
            profile = profile,
            stdFilter = filters.standard,
            timeRange = filters.timeRange,
            subjectFilter = filters.subject
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = StudentDashboardUiState(isLoading = true)
    )

    fun setStandardFilter(standard: Int?) {
        _selectedStandardFilter.value = standard
    }

    fun setTimeRangeFilter(range: DashboardTimeRange) {
        _selectedTimeRange.value = range
    }

    fun setSubjectFilter(subjectId: String?) {
        _selectedSubjectFilter.value = subjectId
    }

    fun deleteHistoricalScore(id: Long) {
        viewModelScope.launch {
            repository.deleteHistoricalScoreById(id)
        }
    }

    fun clearAllHistoricalScores() {
        viewModelScope.launch {
            repository.clearHistoricalScores()
        }
    }

    /**
     * Pure statistics calculation engine aggregating local Room database records.
     */
    private fun calculateDashboardStatistics(
        scores: List<HistoricalScoreEntity>,
        progressList: List<UnitProgress>,
        profile: UserProfile?,
        stdFilter: Int?,
        timeRange: DashboardTimeRange,
        subjectFilter: String?
    ): StudentDashboardUiState {
        val now = System.currentTimeMillis()
        val timeCutoff = when (timeRange) {
            DashboardTimeRange.ALL_TIME -> 0L
            DashboardTimeRange.PAST_7_DAYS -> now - (7L * 24 * 60 * 60 * 1000)
            DashboardTimeRange.PAST_30_DAYS -> now - (30L * 24 * 60 * 60 * 1000)
        }

        // Apply filters
        val filteredScores = scores.filter { score ->
            val matchesTime = score.completedAt >= timeCutoff
            val matchesStd = stdFilter == null || score.stdId == stdFilter
            val matchesSubject = subjectFilter == null || score.subjectId.equals(subjectFilter, ignoreCase = true)
            matchesTime && matchesStd && matchesSubject
        }

        val totalQuizzes = filteredScores.size
        val passedQuizzes = filteredScores.count { it.isPassed }
        val passRate = if (totalQuizzes > 0) (passedQuizzes.toFloat() / totalQuizzes * 100f) else 0f
        val overallAccuracy = if (totalQuizzes > 0) {
            filteredScores.map { it.accuracyPercentage.toFloat() }.average().toFloat()
        } else 0f

        val totalQuestionsAnswered = filteredScores.sumOf { it.totalQuestions }
        val totalCorrectAnswers = filteredScores.sumOf { it.score }
        val totalXp = filteredScores.sumOf { it.earnedXP }
        val totalCoins = filteredScores.sumOf { it.earnedCoins }
        val totalStars = filteredScores.sumOf { it.earnedStars }
        val totalTimeSpent = filteredScores.sumOf { it.timeTakenSeconds }
        val perfectScores = filteredScores.count { it.totalQuestions > 0 && it.score == it.totalQuestions }

        // Subject Breakdown Aggregation
        val subjectScoresMap = filteredScores.groupBy { it.subjectId.lowercase() }
        val subjectStats = subjectScoresMap.map { (subjId, subScores) ->
            val subAttempts = subScores.size
            val subPassed = subScores.count { it.isPassed }
            val subPassRate = if (subAttempts > 0) (subPassed.toFloat() / subAttempts * 100f) else 0f
            val subAccuracy = if (subAttempts > 0) {
                subScores.map { it.accuracyPercentage.toFloat() }.average().toFloat()
            } else 0f
            val subHighScore = subScores.maxOfOrNull { it.score } ?: 0
            val subQuestions = subScores.sumOf { it.totalQuestions }
            val subCorrect = subScores.sumOf { it.score }
            val subXp = subScores.sumOf { it.earnedXP }
            val colorHex = QuizStaticData.SUBJECT_COLORS[subjId] ?: 0xFF6366F1

            val displayName = when (subjId) {
                "math" -> "Mathematics"
                "science" -> "Science"
                "social" -> "Social Science"
                "english" -> "English"
                "kannada" -> "Kannada"
                "hindi" -> "Hindi"
                "computer" -> "Computer"
                else -> subjId.replaceFirstChar { it.uppercase() }
            }

            SubjectAggregateStat(
                subjectId = subjId,
                subjectName = displayName,
                totalAttempts = subAttempts,
                averageAccuracy = subAccuracy,
                highScore = subHighScore,
                totalQuestionsAnswered = subQuestions,
                totalCorrectAnswers = subCorrect,
                totalXpEarned = subXp,
                passedCount = subPassed,
                passRatePercentage = subPassRate,
                colorHex = colorHex
            )
        }.sortedByDescending { it.totalAttempts }

        val strongest = subjectStats.maxByOrNull { it.averageAccuracy }
        val focusNeeded = if (subjectStats.size > 1) {
            subjectStats.filter { it.averageAccuracy < 75f }.minByOrNull { it.averageAccuracy }
                ?: subjectStats.minByOrNull { it.averageAccuracy }
        } else null

        // Recent attempts & accuracy sparkline
        val recentList = filteredScores.take(10)
        val accuracyTrend = recentList.map { it.accuracyPercentage.toFloat() }.reversed()

        // 7-Day & 30-Day Performance Trends
        val weeklyPerformance = calculateWeeklyPerformance(filteredScores)
        val monthlyPerformance = calculateThirtyDayPerformance(filteredScores)

        // Progress List summary
        val completedUnits = progressList.count { it.progress >= 100 }
        val totalUnits = progressList.size

        // Recommendation Engine based on Room Database Historical Stats & Progress
        val standardToUse = profile?.standard ?: (stdFilter ?: 6)
        val recommendations = QuizRecommendationEngine.generateRecommendations(
            userProfile = profile,
            progressList = progressList,
            historicalScores = scores,
            standard = standardToUse
        )
        val weakAreaTopics = QuizRecommendationEngine.identifyWeakAreaTopics(
            progressList = progressList,
            historicalScores = scores,
            standard = standardToUse
        )
        val criticalWeakCount = weakAreaTopics.count { it.urgencyLevel == WeaknessUrgency.CRITICAL }

        // Total Points & Quiz Rank Calculation
        val points = profile?.totalPoints ?: (filteredScores.sumOf { it.score * 10 })
        val rankInfo = QuizRankTier.calculateRank(points)
        val levelInfo = StudentLevelSystem.calculateLevel(totalXp)

        return StudentDashboardUiState(
            isLoading = false,
            totalQuizzesAttempted = totalQuizzes,
            passedQuizzesCount = passedQuizzes,
            passRatePercentage = passRate,
            overallAverageAccuracy = overallAccuracy,
            totalQuestionsAnswered = totalQuestionsAnswered,
            totalCorrectAnswers = totalCorrectAnswers,
            totalXpEarned = totalXp,
            totalCoinsEarned = totalCoins,
            totalStarsEarned = totalStars,
            totalTimeSpentSeconds = totalTimeSpent,
            perfectScoresCount = perfectScores,
            strongestSubject = strongest,
            subjectNeedingFocus = focusNeeded,
            subjectStats = subjectStats,
            recommendations = recommendations,
            weakAreaTopics = weakAreaTopics,
            criticalWeakAreasCount = criticalWeakCount,
            recentAttempts = recentList,
            recentAccuracyTrend = accuracyTrend,
            weeklyPerformance = weeklyPerformance,
            monthlyPerformance = monthlyPerformance,
            studentName = profile?.name ?: "Student",
            studentStandard = standardToUse,
            completedUnitsCount = completedUnits,
            totalUnitsCount = totalUnits,
            totalPoints = points,
            quizRank = rankInfo,
            studentLevel = levelInfo,
            selectedStandardFilter = stdFilter,
            selectedTimeRange = timeRange,
            selectedSubjectFilter = subjectFilter
        )
    }

    private fun calculateWeeklyPerformance(scores: List<HistoricalScoreEntity>): List<DayPerformanceStat> {
        val calendar = Calendar.getInstance()
        val dayFormat = SimpleDateFormat("EEE", Locale.getDefault())
        val dayList = mutableListOf<DayPerformanceStat>()

        // Last 7 days from 6 days ago up to today
        for (i in 6 downTo 0) {
            val cal = Calendar.getInstance()
            cal.add(Calendar.DAY_OF_YEAR, -i)
            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            cal.set(Calendar.MILLISECOND, 0)
            val startOfDay = cal.timeInMillis

            cal.set(Calendar.HOUR_OF_DAY, 23)
            cal.set(Calendar.MINUTE, 59)
            cal.set(Calendar.SECOND, 59)
            cal.set(Calendar.MILLISECOND, 999)
            val endOfDay = cal.timeInMillis

            val dayScores = scores.filter { it.completedAt in startOfDay..endOfDay }
            val attemptsCount = dayScores.size
            val avgAcc = if (attemptsCount > 0) {
                dayScores.map { it.accuracyPercentage.toFloat() }.average().toFloat()
            } else 0f
            val xp = dayScores.sumOf { it.earnedXP }

            val label = if (i == 0) "Today" else dayFormat.format(Date(startOfDay))
            dayList.add(
                DayPerformanceStat(
                    dayLabel = label,
                    timestamp = startOfDay,
                    attemptsCount = attemptsCount,
                    averageAccuracy = avgAcc,
                    xpEarned = xp
                )
            )
        }
        return dayList
    }

    private fun calculateThirtyDayPerformance(scores: List<HistoricalScoreEntity>): List<DayPerformanceStat> {
        val dayList = mutableListOf<DayPerformanceStat>()
        val dayFormat = SimpleDateFormat("MMM d", Locale.getDefault())

        for (i in 29 downTo 0) {
            val cal = Calendar.getInstance()
            cal.add(Calendar.DAY_OF_YEAR, -i)
            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            cal.set(Calendar.MILLISECOND, 0)
            val startOfDay = cal.timeInMillis

            cal.set(Calendar.HOUR_OF_DAY, 23)
            cal.set(Calendar.MINUTE, 59)
            cal.set(Calendar.SECOND, 59)
            cal.set(Calendar.MILLISECOND, 999)
            val endOfDay = cal.timeInMillis

            val dayScores = scores.filter { it.completedAt in startOfDay..endOfDay }
            val attemptsCount = dayScores.size
            val avgAcc = if (attemptsCount > 0) {
                dayScores.map { it.accuracyPercentage.toFloat() }.average().toFloat()
            } else 0f
            val xp = dayScores.sumOf { it.earnedXP }

            val label = if (i == 0) "Today" else dayFormat.format(Date(startOfDay))
            dayList.add(
                DayPerformanceStat(
                    dayLabel = label,
                    timestamp = startOfDay,
                    attemptsCount = attemptsCount,
                    averageAccuracy = avgAcc,
                    xpEarned = xp
                )
            )
        }
        return dayList
    }
}

/**
 * Factory for creating [StudentDashboardViewModel] with [QuizRepository].
 */
class StudentDashboardViewModelFactory(
    private val repository: QuizRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentDashboardViewModel::class.java)) {
            return StudentDashboardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}

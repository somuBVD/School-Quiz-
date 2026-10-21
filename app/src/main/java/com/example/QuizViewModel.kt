package com.example

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.auth.AuthUiState
import com.example.auth.AuthUser
import com.example.auth.UserRole
import com.example.auth.CloudSyncState
import com.example.auth.FirebaseAuthManager
import com.example.auth.FirebaseCloudSyncManager
import com.example.data.*
import com.example.localization.AppLanguage
import com.example.localization.CustomLanguageSettingsProvider
import com.example.localization.LanguageSettingsProvider
import com.example.localization.LocaleManager
import com.example.ui.battle.BattleArenaState
import com.example.ui.battle.BattleOpponent
import com.example.ui.battle.BattleRoundResult
import com.example.ui.battle.BattleStage
import com.example.battle.RealOnlineBattleManager
import com.example.battle.OnlineRoomData
import com.example.battle.OnlinePlayer
import com.example.ui.quiz.QuestionScoreResult
import com.example.ui.quiz.QuestionTimeStat
import com.example.ui.quiz.SessionAnswerReview
import com.example.ui.quiz.TimeThresholdZone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class QuizViewModel(application: Application, val repository: QuizRepository) : AndroidViewModel(application) {

    private val appPrefs = application.getSharedPreferences("quiz_app_user_data", Context.MODE_PRIVATE)

    // --- Core Database Flows ---
    val userProfile: StateFlow<UserProfile?> = repository.userProfile
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val leaderboard: StateFlow<List<LeaderboardUser>> = repository.leaderboard
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val notifications: StateFlow<List<NotificationEntity>> = repository.notifications
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeAds: StateFlow<List<AdvertisementEntity>> = repository.activeAds
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allCustomQuestions: StateFlow<List<CustomQuestion>> = repository.getAllCustomQuestions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allRoomQuestions: StateFlow<List<QuizQuestionEntity>> = repository.allRoomQuestions
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val historicalScores: StateFlow<List<HistoricalScoreEntity>> = repository.allHistoricalScores
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // --- Offline Downloaded Quizzes backed by Room ---
    val downloadedQuizzes: StateFlow<List<DownloadedQuizEntity>> = repository.allDownloadedQuizzes
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val downloadedQuizCount: StateFlow<Int> = repository.downloadedQuizCount
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val totalCachedQuestionsCount: StateFlow<Int> = repository.totalCachedQuestionsCount
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    private val _isPreloadingCache = MutableStateFlow(false)
    val isPreloadingCache: StateFlow<Boolean> = _isPreloadingCache.asStateFlow()

    private val _downloadingUnits = MutableStateFlow<Set<String>>(emptySet())
    val downloadingUnits: StateFlow<Set<String>> = _downloadingUnits.asStateFlow()

    // --- Dynamic Navigation & Topic Selection with Persistent Retention ---
    private val PREF_SELECTED_STANDARD = "pref_selected_standard"
    private val PREF_SELECTED_SUBJECT = "pref_selected_subject"

    private val savedStd = appPrefs.getInt("pref_selected_standard", 6).let { if (it in 6..12) it else 6 }
    private val savedSubject = appPrefs.getString("pref_selected_subject", "all") ?: "all"

    private val _selectedStd = MutableStateFlow(savedStd)
    val selectedStd: StateFlow<Int> = _selectedStd.asStateFlow()

    private val _selectedSubjectFilter = MutableStateFlow(savedSubject)
    val selectedSubjectFilter: StateFlow<String> = _selectedSubjectFilter.asStateFlow()

    private val _selectedSubjectId = MutableStateFlow(if (savedSubject != "all") savedSubject else "math")
    val selectedSubjectId: StateFlow<String> = _selectedSubjectId.asStateFlow()

    val unitProgressList: StateFlow<List<UnitProgress>> = _selectedStd
        .flatMapLatest { std ->
            repository.getProgressForStandard(std)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Recommendation Engine Flows: Combines Room UserProfile, UnitProgress, Historical Scores & Selected Standard
    val recommendedQuizzes: StateFlow<List<QuizRecommendation>> = combine(
        userProfile,
        unitProgressList,
        repository.allHistoricalScores,
        _selectedStd
    ) { profile, progressList, historicalScores, std ->
        QuizRecommendationEngine.generateRecommendations(
            userProfile = profile,
            progressList = progressList,
            historicalScores = historicalScores,
            standard = std
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val weakAreaTopics: StateFlow<List<WeakAreaTopic>> = combine(
        unitProgressList,
        repository.allHistoricalScores,
        _selectedStd
    ) { progressList, historicalScores, std ->
        QuizRecommendationEngine.identifyWeakAreaTopics(progressList, historicalScores, std)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val categorySummaries: StateFlow<List<CategoryPerformanceSummary>> = combine(
        unitProgressList,
        _selectedStd
    ) { progressList, std ->
        QuizRecommendationEngine.calculateCategorySummaries(progressList, std)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Custom Language Settings Provider integration (English, Kannada, Hindi)
    val languageSettingsProvider: LanguageSettingsProvider = CustomLanguageSettingsProvider.getInstance(application)
    private val _currentLanguage = MutableStateFlow(
        appPrefs.getString("app_language", null) ?: languageSettingsProvider.currentLanguageName
    )
    val currentLanguage: StateFlow<String> = _currentLanguage.asStateFlow()

    // Global Theme Manager integration
    val themeManager: ThemeManager = ThemeManager.getInstance(application)
    val isDarkMode: StateFlow<Boolean> = themeManager.isDarkMode
    val themeMode: StateFlow<ThemeMode> = themeManager.themeMode

    fun toggleDarkMode() {
        themeManager.toggleTheme()
    }

    fun setDarkMode(isDark: Boolean) {
        themeManager.setDarkMode(isDark)
    }

    fun setThemeMode(mode: ThemeMode, isSystemInDark: Boolean = false) {
        themeManager.setThemeMode(mode, isSystemInDark)
    }

    // --- Active Quiz playing Engine State ---
    data class ActiveQuizState(
        val isPlaying: Boolean = false,
        val stdId: Int = 0,
        val subjectId: String = "",
        val unitId: Int = 0,
        val unitName: String = "",
        val questions: List<QuestionModel> = emptyList(),
        val currentIndex: Int = 0,
        val selectedAnswer: String = "", // user's tapped choice
        val userMatchState: Map<Int, Int> = emptyMap(), // For matchmaking question: LeftIndex -> RightIndex
        val isAnswerSubmitted: Boolean = false,
        val markedForReview: Set<Int> = emptySet(),
        val correctCount: Int = 0,
        val totalQuestions: Int = 0,
        val secondsRemaining: Int = 120, // timer
        val totalTimeLimitSeconds: Int = 120, // per-question countdown limit
        val isQuizFinished: Boolean = false,
        val earnedCoins: Int = 0,
        val earnedXP: Int = 0,
        val earnedStars: Int = 0,
        val totalScorePoints: Int = 0, // points earned accounting for speed bonuses & overtime deductions
        val totalTimeDeducted: Int = 0, // points lost for exceeding time thresholds
        val totalSpeedBonus: Int = 0, // bonus points gained for speedy answers
        val totalTimeTakenSeconds: Int = 0, // total seconds spent on questions
        val questionTimeStats: List<QuestionTimeStat> = emptyList(), // per-question timing breakdown
        val lastQuestionResult: QuestionScoreResult? = null, // breakdown for current question feedback
        val sessionAnswerReviews: List<SessionAnswerReview> = emptyList() // individual question reviews for end-of-quiz analysis
    ) {
        val incorrectReviewItems: List<SessionAnswerReview>
            get() = sessionAnswerReviews.filter { !it.isCorrect }

        val correctReviewItems: List<SessionAnswerReview>
            get() = sessionAnswerReviews.filter { it.isCorrect }
    }

    private val _activeQuizState = MutableStateFlow(ActiveQuizState())
    val activeQuizState: StateFlow<ActiveQuizState> = _activeQuizState.asStateFlow()

    private var timerJob: Job? = null
    private var autoAdvanceJob: Job? = null

    // --- Flashcard Revision Deck State ---
    data class FlashcardState(
        val isActive: Boolean = false,
        val stdId: Int = 0,
        val subjectId: String = "",
        val unitId: Int = 0,
        val unitName: String = "",
        val cards: List<QuestionModel> = emptyList(),
        val currentIndex: Int = 0,
        val isFlipped: Boolean = false,
        val masteredCardIds: Set<String> = emptySet(),
        val needsReviewCardIds: Set<String> = emptySet(),
        val isCompleted: Boolean = false
    )

    private val _flashcardState = MutableStateFlow(FlashcardState())
    val flashcardState: StateFlow<FlashcardState> = _flashcardState.asStateFlow()

    // --- Daily Challenge State ---
    data class DailyChallengeState(
        val isActive: Boolean = false,
        val questions: List<QuestionModel> = emptyList(),
        val currentIndex: Int = 0,
        val selectedAnswer: String = "",
        val isAnswerSubmitted: Boolean = false,
        val correctCount: Int = 0,
        val secondsRemaining: Int = 30,
        val isFinished: Boolean = false,
        val earnedCoins: Int = 0,
        val earnedXP: Int = 0
    )

    private val _dailyChallengeState = MutableStateFlow(DailyChallengeState())
    val dailyChallengeState: StateFlow<DailyChallengeState> = _dailyChallengeState.asStateFlow()
    private var dailyChallengeTimerJob: Job? = null
    private var dailyChallengeAutoAdvanceJob: Job? = null

    // --- Study Focus Timer State ---
    data class FocusTimerState(
        val isRunning: Boolean = false,
        val selectedMinutes: Int = 25,
        val secondsRemaining: Int = 25 * 60,
        val completedSessions: Int = 0,
        val isBreak: Boolean = false
    )

    private val _focusTimerState = MutableStateFlow(FocusTimerState())
    val focusTimerState: StateFlow<FocusTimerState> = _focusTimerState.asStateFlow()
    private var focusTimerJob: Job? = null

    // --- 1vs1 Battle Arena State ---
    private val onlineBattleManager = RealOnlineBattleManager.getInstance(application)
    private val _battleArenaState = MutableStateFlow(BattleArenaState())
    val battleArenaState: StateFlow<BattleArenaState> = _battleArenaState.asStateFlow()
    private var battleTimerJob: Job? = null
    private var opponentResponseJob: Job? = null
    private var onlineMatchmakingTimerJob: Job? = null

    // --- 60-Second Quiz Blitz State ---
    data class BlitzState(
        val isActive: Boolean = false,
        val stdId: Int = 6,
        val secondsRemaining: Int = 60,
        val questions: List<QuestionModel> = emptyList(),
        val currentIndex: Int = 0,
        val score: Int = 0,
        val correctCount: Int = 0,
        val wrongCount: Int = 0,
        val currentStreakCombo: Int = 0,
        val highestStreakCombo: Int = 0,
        val isFinished: Boolean = false,
        val earnedXP: Int = 0,
        val earnedCoins: Int = 0,
        val isNewHighScore: Boolean = false
    )

    private val _blitzState = MutableStateFlow(BlitzState())
    val blitzState: StateFlow<BlitzState> = _blitzState.asStateFlow()
    private var blitzTimerJob: Job? = null

    // --- Mistake Vault State ---
    private val mistakeManager = MistakeManager.getInstance(application)
    private val _mistakesList = MutableStateFlow(mistakeManager.getMistakes())
    val mistakesList: StateFlow<List<MistakeItem>> = _mistakesList.asStateFlow()

    // --- Daily Study Target State ---
    private val _dailyGoalTarget = MutableStateFlow(appPrefs.getInt("daily_goal_target", 3))
    val dailyGoalTarget: StateFlow<Int> = _dailyGoalTarget.asStateFlow()

    private val _dailyGoalCompleted = MutableStateFlow(appPrefs.getInt("daily_goal_completed", 0))
    val dailyGoalCompleted: StateFlow<Int> = _dailyGoalCompleted.asStateFlow()

    private val _isDailyGoalClaimed = MutableStateFlow(appPrefs.getBoolean("daily_goal_claimed", false))
    val isDailyGoalClaimed: StateFlow<Boolean> = _isDailyGoalClaimed.asStateFlow()

    // --- Firebase Authentication Manager ---
    private val firebaseAuthManager = FirebaseAuthManager.getInstance(application)
    val authUiState: StateFlow<AuthUiState> = firebaseAuthManager.uiState
    val isFirebaseConfigured: StateFlow<Boolean> = firebaseAuthManager.isFirebaseConfigured
    val currentUserRole: StateFlow<UserRole> = authUiState.map { state ->
        (state as? AuthUiState.Authenticated)?.user?.role ?: UserRole.STUDENT
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UserRole.STUDENT)

    fun isTeacherOrAdmin(): Boolean {
        val user = (authUiState.value as? AuthUiState.Authenticated)?.user
        return user?.role?.isPrivileged == true
    }

    fun updateUserRole(role: UserRole) {
        val user = (authUiState.value as? AuthUiState.Authenticated)?.user ?: return
        firebaseAuthManager.saveUserRole(user.uid, role)
    }

    // --- Firebase Cloud Sync Manager (Firestore & Storage) ---
    private val cloudSyncManager = FirebaseCloudSyncManager.getInstance(application)
    val cloudSyncState: StateFlow<CloudSyncState> = cloudSyncManager.syncState
    val isCloudSyncAvailable: StateFlow<Boolean> = cloudSyncManager.isCloudAvailable
    val isFirestoreOffline: StateFlow<Boolean> = cloudSyncManager.isFirestoreOffline
    val isFirestorePersistenceActive: StateFlow<Boolean> = cloudSyncManager.firestorePersistenceActive
    val isForcedOfflineMode: StateFlow<Boolean> = cloudSyncManager.isForcedOffline

    fun setFirestoreOfflineMode(offline: Boolean) {
        viewModelScope.launch {
            cloudSyncManager.setFirestoreOfflineMode(offline)
        }
    }

    fun toggleFirestoreOfflineMode() {
        viewModelScope.launch {
            cloudSyncManager.toggleFirestoreOfflineMode()
        }
    }

    // --- Automatic Firestore Progress & History Sync Service ---
    val quizDataSyncService = com.example.sync.QuizDataSyncService.getInstance(application)
    val firestoreSyncStatus: StateFlow<com.example.sync.SyncStatus> = quizDataSyncService.syncStatus
    val lastFirestoreSyncTime: StateFlow<Long> = quizDataSyncService.lastSyncTimestamp

    // --- Bookmarked / Saved Questions backed by Room Database ---
    val bookmarkedQuestions: StateFlow<List<QuestionModel>> = repository.bookmarkedQuestions
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private fun loadBookmarksFromPrefs(): List<QuestionModel> {
        val rawJson = appPrefs.getString("bookmarked_questions_json", null) ?: return emptyList()
        return try {
            val array = JSONArray(rawJson)
            val list = mutableListOf<QuestionModel>()
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                val optionsArr = obj.getJSONArray("options")
                val optionsList = mutableListOf<String>()
                for (j in 0 until optionsArr.length()) {
                    optionsList.add(optionsArr.getString(j))
                }
                list.add(
                    QuestionModel(
                        id = obj.getString("id"),
                        stdId = obj.getInt("stdId"),
                        subjectId = obj.getString("subjectId"),
                        unitId = obj.getInt("unitId"),
                        type = obj.getString("type"),
                        questionText = obj.getString("questionText"),
                        options = optionsList,
                        correctAnswer = obj.getString("correctAnswer"),
                        explanation = obj.getString("explanation"),
                        mediaRes = obj.optString("mediaRes", "")
                    )
                )
            }
            list
        } catch (e: Exception) {
            emptyList()
        }
    }

    init {
        // Synchronize initial locale from saved preference
        try {
            LocaleManager.updateConfiguration(application, AppLanguage.from(_currentLanguage.value))
        } catch (ignored: Exception) {}

        // Listen for language toggles from custom language settings provider
        languageSettingsProvider.addOnLanguageChangeListener { newLang ->
            if (_currentLanguage.value != newLang.displayName) {
                _currentLanguage.value = newLang.displayName
                viewModelScope.launch {
                    repository.changeLanguage(newLang.displayName)
                }
            }
        }

        // Migrate legacy SharedPreferences bookmarks to Room database table
        viewModelScope.launch {
            try {
                val legacy = loadBookmarksFromPrefs()
                if (legacy.isNotEmpty()) {
                    legacy.forEach { q ->
                        repository.bookmarkQuestion(q)
                    }
                    appPrefs.edit().remove("bookmarked_questions_json").apply()
                }
            } catch (ignored: Exception) {}
        }

        // Static curriculum questions are already in memory via QuizStaticData.
        // Room table is reserved for custom questions and offline packages to prevent CursorWindow overflow.

        // Auto-cache active standard curriculum in Room database for 100% offline access
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val std = _selectedStd.value
                repository.cacheAllQuizzesForStandard(std)
            } catch (ignored: Exception) {}
        }

        // Collect user profile standard when loaded to initialize selectedStd
        viewModelScope.launch {
            userProfile.collect { profile ->
                if (profile != null) {
                    val safeStd = if (profile.standard < 6) 6 else profile.standard
                    if (!appPrefs.contains(PREF_SELECTED_STANDARD)) {
                        _selectedStd.value = safeStd
                        appPrefs.edit().putInt(PREF_SELECTED_STANDARD, safeStd).apply()
                    }
                    if (profile.language.isNotBlank() && !appPrefs.contains("app_language")) {
                        val appLang = AppLanguage.from(profile.language)
                        _currentLanguage.value = appLang.displayName
                        try {
                            LocaleManager.updateConfiguration(getApplication(), appLang)
                        } catch (ignored: Exception) {}
                    }
                    if (profile.standard < 6) {
                        repository.changeSelectedStd(safeStd)
                    }
                }
            }
        }

        // Initialize and schedule automatic Firestore quiz progress and history sync
        try {
            com.example.sync.QuizDataSyncWorker.schedulePeriodic(application)
            quizDataSyncService.triggerAutoSync()
        } catch (ignored: Exception) {}

        // Upload and verify 6th Standard unitwise Kannada questions in Firestore
        viewModelScope.launch {
            try {
                // Clear old cached questions for Unit 1..Unit 14 to ensure only current questions exist
                for (u in 1..14) {
                    repository.deleteQuestionsForUnit(6, "kannada", u)
                }

                // Seed into local Room DB with Kannada unit names
                val kannadaEntities = com.example.data.Std6KannadaQuestionBank.questions.map { q ->
                    q.toQuizQuestionEntity(
                        unitName = com.example.data.Std6KannadaQuestionBank.units.find { it.id == q.unitId }?.name ?: "Unit ${q.unitId}",
                        difficulty = "Medium",
                        hint = "ಪಾಠದ ಪ್ರಮುಖ ಅಂಶಗಳನ್ನು ಗಮನಿಸಿ",
                        points = 10,
                        isCustom = false
                    )
                }
                repository.saveQuizQuestions(kannadaEntities)

                // Sync to Cloud Firestore
                com.example.data.Std6KannadaQuestionBank.uploadToFirestore(cloudSyncManager)
            } catch (ignored: Exception) {}
        }
    }

    fun uploadStd6KannadaQuestionsToFirestore(onResult: ((Int) -> Unit)? = null) {
        viewModelScope.launch {
            val result = com.example.data.Std6KannadaQuestionBank.uploadToFirestore(cloudSyncManager)
            if (result.isSuccess) {
                onResult?.invoke(result.getOrDefault(com.example.data.Std6KannadaQuestionBank.questions.size))
            } else {
                onResult?.invoke(-1)
            }
        }
    }

    fun uploadStd8MathsQuestionsToFirestore(onResult: ((Int) -> Unit)? = null) {
        viewModelScope.launch {
            val result = com.example.data.Std8MathsQuestionBank.uploadToFirestore(cloudSyncManager)
            if (result.isSuccess) {
                onResult?.invoke(result.getOrDefault(com.example.data.Std8MathsQuestionBank.questions.size))
            } else {
                onResult?.invoke(-1)
            }
        }
    }

    // --- Actions ---

    fun changeStandard(std: Int) {
        _selectedStd.value = std
        appPrefs.edit().putInt(PREF_SELECTED_STANDARD, std).apply()
        // If current subject filter is not valid for new standard, fall back to first subject or keep if valid
        val subjects = QuizStaticData.standardsList.find { it.std == std }?.subjects ?: emptyList()
        val currentSub = _selectedSubjectFilter.value
        if (currentSub != "all" && subjects.none { it.id.equals(currentSub, ignoreCase = true) }) {
            val firstSubjId = subjects.firstOrNull()?.id ?: "math"
            _selectedSubjectId.value = firstSubjId
            _selectedSubjectFilter.value = firstSubjId
            appPrefs.edit().putString(PREF_SELECTED_SUBJECT, firstSubjId).apply()
        }
        viewModelScope.launch {
            repository.changeSelectedStd(std)
            try {
                repository.cacheAllQuizzesForStandard(std)
            } catch (ignored: Exception) {}
        }
    }

    fun setSubjectFilter(subjectId: String) {
        _selectedSubjectFilter.value = subjectId
        if (subjectId != "all") {
            _selectedSubjectId.value = subjectId
        }
        appPrefs.edit().putString(PREF_SELECTED_SUBJECT, subjectId).apply()
    }

    fun selectSubject(subjectId: String) {
        setSubjectFilter(subjectId)
    }

    fun startNextUnitQuiz() {
        val state = _activeQuizState.value
        val nextInfo = QuizStaticData.getNextUnit(state.stdId, state.subjectId, state.unitId)
        if (nextInfo != null) {
            val (subject, unit) = nextInfo
            _selectedStd.value = state.stdId
            _selectedSubjectId.value = subject.id
            _selectedSubjectFilter.value = subject.id
            appPrefs.edit()
                .putInt(PREF_SELECTED_STANDARD, state.stdId)
                .putString(PREF_SELECTED_SUBJECT, subject.id)
                .apply()
            startQuiz(
                stdId = state.stdId,
                subjectId = subject.id,
                unitId = unit.id,
                unitName = unit.name
            )
        }
    }

    fun switchLanguage(lang: String) {
        val appLang = AppLanguage.from(lang)
        val canonicalName = appLang.displayName
        _currentLanguage.value = canonicalName
        languageSettingsProvider.setLanguage(appLang)
        appPrefs.edit().putString("app_language", canonicalName).apply()
        try {
            LocaleManager.updateConfiguration(getApplication(), appLang)
        } catch (ignored: Exception) {}
        viewModelScope.launch {
            repository.changeLanguage(canonicalName)
        }
    }

    fun toggleNextLanguage(): AppLanguage {
        val next = languageSettingsProvider.toggleNextLanguage()
        switchLanguage(next.displayName)
        return next
    }

    fun claimDailyAttendanceReward() {
        viewModelScope.launch {
            repository.claimDailyReward()
        }
    }

    // --- Quiz Controls ---

    fun startQuiz(stdId: Int, subjectId: String, unitId: Int, unitName: String) {
        _selectedStd.value = stdId
        _selectedSubjectId.value = subjectId
        _selectedSubjectFilter.value = subjectId
        appPrefs.edit()
            .putInt(PREF_SELECTED_STANDARD, stdId)
            .putString(PREF_SELECTED_SUBJECT, subjectId)
            .apply()
        viewModelScope.launch {
            val questions = repository.getQuestionsForUnit(stdId, subjectId, unitId)
            _activeQuizState.value = ActiveQuizState(
                isPlaying = true,
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                unitName = unitName,
                questions = questions,
                currentIndex = 0,
                selectedAnswer = "",
                userMatchState = emptyMap(),
                isAnswerSubmitted = false,
                markedForReview = emptySet(),
                correctCount = 0,
                totalQuestions = questions.size,
                secondsRemaining = 120, // 120 seconds per question
                totalTimeLimitSeconds = 120,
                isQuizFinished = false,
                totalScorePoints = 0,
                totalTimeDeducted = 0,
                totalSpeedBonus = 0,
                totalTimeTakenSeconds = 0,
                questionTimeStats = emptyList(),
                lastQuestionResult = null,
                sessionAnswerReviews = emptyList()
            )
            startTimer()
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_activeQuizState.value.isPlaying && !_activeQuizState.value.isQuizFinished) {
                delay(1000)
                val curSecs = _activeQuizState.value.secondsRemaining
                if (curSecs > 1) {
                    _activeQuizState.value = _activeQuizState.value.copy(secondsRemaining = curSecs - 1)
                } else {
                    // Time up! Auto-submit
                    submitQuizAnswer("TIMED_OUT")
                }
            }
        }
    }

    fun selectQuizAnswer(answer: String) {
        if (_activeQuizState.value.isAnswerSubmitted) return
        if (answer.isEmpty()) {
            _activeQuizState.value = _activeQuizState.value.copy(selectedAnswer = "")
            return
        }
        // When answer is clicked, immediately submit and evaluate
        submitQuizAnswer(forcedAnswer = answer)
    }

    fun selectMatchItem(leftIndex: Int, rightIndex: Int) {
        if (_activeQuizState.value.isAnswerSubmitted) return
        val currentMatch = _activeQuizState.value.userMatchState.toMutableMap()
        currentMatch[leftIndex] = rightIndex
        _activeQuizState.value = _activeQuizState.value.copy(userMatchState = currentMatch)
    }

    fun clearMatchItem(leftIndex: Int) {
        if (_activeQuizState.value.isAnswerSubmitted) return
        val currentMatch = _activeQuizState.value.userMatchState.toMutableMap()
        currentMatch.remove(leftIndex)
        _activeQuizState.value = _activeQuizState.value.copy(userMatchState = currentMatch)
    }

    fun submitQuizAnswer(forcedAnswer: String? = null) {
        val currState = _activeQuizState.value
        if (currState.isAnswerSubmitted) return

        timerJob?.cancel()

        val answerToSubmit = forcedAnswer ?: currState.selectedAnswer
        val currentQuestion = currState.questions.getOrNull(currState.currentIndex) ?: return
        val isTimedOut = (answerToSubmit == "TIMED_OUT")
        val isSkipped = (answerToSubmit == "SKIPPED")

        var isCorrect = false
        if (currentQuestion.type == "MATCH") {
            // Check matching correctness
            val expected = currentQuestion.correctAnswer.split(",").associate {
                val split = it.split("=")
                split[0].toInt() to split[1].toInt()
            }
            isCorrect = (currState.userMatchState == expected)
        } else {
            isCorrect = !isTimedOut && !isSkipped && answerToSubmit.trim().equals(currentQuestion.correctAnswer.trim(), ignoreCase = true)
        }

        // Calculate time taken per question and point deductions/bonuses
        val timeTakenSeconds = (currState.totalTimeLimitSeconds - currState.secondsRemaining).coerceIn(1, currState.totalTimeLimitSeconds)
        val scoreResult = TimeThresholdZone.calculateScore(
            isCorrect = isCorrect,
            elapsedSecs = timeTakenSeconds,
            isTimedOut = isTimedOut,
            basePoints = 100
        )

        val stat = QuestionTimeStat(
            questionIndex = currState.currentIndex,
            questionId = currentQuestion.id,
            questionText = currentQuestion.questionText,
            timeTakenSeconds = timeTakenSeconds,
            totalTimeLimitSeconds = currState.totalTimeLimitSeconds,
            basePoints = scoreResult.basePoints,
            speedBonus = scoreResult.speedBonus,
            penaltyDeduction = scoreResult.penaltyDeduction,
            finalPoints = scoreResult.finalPoints,
            isCorrect = isCorrect,
            isTimedOut = isTimedOut,
            zone = scoreResult.zone
        )

        val newCorrectCount = if (isCorrect) currState.correctCount + 1 else currState.correctCount
        val updatedStats = currState.questionTimeStats + stat

        val reviewItem = SessionAnswerReview(
            questionIndex = currState.currentIndex,
            question = currentQuestion,
            studentAnswer = if (currentQuestion.type == "MATCH") {
                currState.userMatchState.entries.joinToString(", ") { "${it.key + 1} ➔ ${it.value + 1}" }
            } else {
                answerToSubmit
            },
            isCorrect = isCorrect,
            isTimedOut = isTimedOut,
            isSkipped = isSkipped,
            timeTakenSeconds = timeTakenSeconds,
            penaltyDeduction = scoreResult.penaltyDeduction,
            speedBonus = scoreResult.speedBonus,
            finalPoints = scoreResult.finalPoints
        )

        // Update Mistake Vault
        if (isCorrect) {
            mistakeManager.removeMistake(currentQuestion.id)
            _mistakesList.value = mistakeManager.getMistakes()
        } else {
            mistakeManager.addMistake(currentQuestion, answerToSubmit)
            _mistakesList.value = mistakeManager.getMistakes()
        }

        _activeQuizState.value = currState.copy(
            isAnswerSubmitted = true,
            selectedAnswer = answerToSubmit,
            correctCount = newCorrectCount,
            totalScorePoints = currState.totalScorePoints + scoreResult.finalPoints,
            totalTimeDeducted = currState.totalTimeDeducted + scoreResult.penaltyDeduction,
            totalSpeedBonus = currState.totalSpeedBonus + scoreResult.speedBonus,
            totalTimeTakenSeconds = currState.totalTimeTakenSeconds + timeTakenSeconds,
            questionTimeStats = updatedStats,
            lastQuestionResult = scoreResult,
            sessionAnswerReviews = currState.sessionAnswerReviews + reviewItem
        )

        // When correct answer clicked/submitted: automatically advance to next question
        // instead of making the student manually click 'Next Question' button!
        if (isCorrect) {
            autoAdvanceJob?.cancel()
            autoAdvanceJob = viewModelScope.launch {
                delay(650)
                goToNextQuestion()
            }
        }
    }

    fun toggleMarkForReview() {
        val currState = _activeQuizState.value
        val curIndex = currState.currentIndex
        val newMarked = currState.markedForReview.toMutableSet()
        if (newMarked.contains(curIndex)) {
            newMarked.remove(curIndex)
        } else {
            newMarked.add(curIndex)
        }
        _activeQuizState.value = currState.copy(markedForReview = newMarked)
    }

    fun goToNextQuestion() {
        autoAdvanceJob?.cancel()
        autoAdvanceJob = null
        val currState = _activeQuizState.value
        val nextIndex = currState.currentIndex + 1

        if (nextIndex < currState.totalQuestions) {
            _activeQuizState.value = currState.copy(
                currentIndex = nextIndex,
                selectedAnswer = "",
                userMatchState = emptyMap(),
                isAnswerSubmitted = false,
                secondsRemaining = currState.totalTimeLimitSeconds,
                lastQuestionResult = null
            )
            startTimer()
        } else {
            // Quiz completed! Calculate persistence values
            finishAndSaveQuiz()
        }
    }

    fun skipCurrentQuestion() {
        submitQuizAnswer("SKIPPED")
    }

    private fun finishAndSaveQuiz() {
        val currState = _activeQuizState.value
        timerJob?.cancel()

        val score = currState.correctCount
        val total = currState.totalQuestions

        // Persist achievements with time threshold points factored in
        viewModelScope.launch {
            // XP corresponds to earned quiz score points (XP for every correct answer + speed bonus)
            val xpWon = (score * StudentLevelSystem.XP_PER_CORRECT_ANSWER) +
                (if (score == total && total > 0) StudentLevelSystem.XP_PERFECT_SCORE_BONUS else 0) +
                (currState.totalSpeedBonus / 4)

            repository.handleQuizCompletion(
                stdId = currState.stdId,
                subjectId = currState.subjectId,
                unitId = currState.unitId,
                score = score,
                total = total,
                xpEarnedOverride = xpWon
            )

            // Automatically synchronize completed quiz progress & attempt history with Firestore
            try {
                quizDataSyncService.triggerAutoSync()
            } catch (ignored: Exception) {}

            // Calculate local awards displayed on final summary dialog
            val coinsWon = score * 5 + (if (score == total && total > 0) 50 else 0)
            val starsWon = score * 2

            // Increment daily completed goal count
            val newCompleted = _dailyGoalCompleted.value + 1
            _dailyGoalCompleted.value = newCompleted
            appPrefs.edit().putInt("daily_goal_completed", newCompleted).apply()

            _activeQuizState.value = currState.copy(
                isQuizFinished = true,
                earnedCoins = coinsWon,
                earnedXP = xpWon,
                earnedStars = starsWon
            )
        }
    }

    fun exitQuiz() {
        autoAdvanceJob?.cancel()
        autoAdvanceJob = null
        timerJob?.cancel()
        _activeQuizState.value = ActiveQuizState(isPlaying = false)
    }

    // --- Admin Operations ---

    fun createCustomQuestion(stdId: Int, subjectId: String, unitId: Int, type: String, text: String, optionsStr: String, answer: String, expl: String) {
        viewModelScope.launch {
            repository.addCustomQuestion(
                CustomQuestion(
                    stdId = stdId,
                    subjectId = subjectId,
                    unitId = unitId,
                    type = type,
                    questionText = text,
                    optionsString = optionsStr,
                    correctAnswer = answer,
                    explanation = expl
                )
            )
        }
    }

    fun removeCustomQuestion(id: Int) {
        viewModelScope.launch {
            repository.deleteCustomQuestionById(id)
        }
    }

    fun createAdminAd(title: String, subtitle: String, imageTag: String) {
        viewModelScope.launch {
            repository.addAdvertisement(
                AdvertisementEntity(
                    title = title,
                    subtitle = subtitle,
                    imageUrl = imageTag,
                    isActive = true
                )
            )
        }
    }

    fun removeAd(id: Int) {
        viewModelScope.launch {
            repository.deleteAdvertisementById(id)
        }
    }

    fun createAdminNotification(title: String, desc: String, category: String) {
        viewModelScope.launch {
            repository.addNotification(title, desc, category)
        }
    }

    fun removeNotification(id: Int) {
        viewModelScope.launch {
            repository.deleteNotificationById(id)
        }
    }

    // ==========================================
    // --- FLASHCARD REVISION STUDIO ACTIONS ---
    // ==========================================

    fun startFlashcards(stdId: Int, subjectId: String, unitId: Int, unitName: String) {
        _flashcardState.value = FlashcardState(
            isActive = true,
            stdId = stdId,
            subjectId = subjectId,
            unitId = unitId,
            unitName = unitName
        )
        viewModelScope.launch {
            val cards = repository.getQuestionsForUnit(stdId, subjectId, unitId)
            _flashcardState.value = _flashcardState.value.copy(
                cards = cards,
                currentIndex = 0,
                isFlipped = false,
                masteredCardIds = emptySet(),
                needsReviewCardIds = emptySet(),
                isCompleted = false
            )
        }
    }

    fun flipFlashcard() {
        val curr = _flashcardState.value
        _flashcardState.value = curr.copy(isFlipped = !curr.isFlipped)
    }

    fun markFlashcardMastered() {
        val curr = _flashcardState.value
        val card = curr.cards.getOrNull(curr.currentIndex) ?: return
        val mastered = curr.masteredCardIds + card.id
        val needs = curr.needsReviewCardIds - card.id
        val nextIdx = curr.currentIndex + 1
        if (nextIdx < curr.cards.size) {
            _flashcardState.value = curr.copy(
                currentIndex = nextIdx,
                isFlipped = false,
                masteredCardIds = mastered,
                needsReviewCardIds = needs
            )
        } else {
            _flashcardState.value = curr.copy(
                isCompleted = true,
                masteredCardIds = mastered,
                needsReviewCardIds = needs
            )
        }
    }

    fun markFlashcardNeedsReview() {
        val curr = _flashcardState.value
        val card = curr.cards.getOrNull(curr.currentIndex) ?: return
        val needs = curr.needsReviewCardIds + card.id
        val mastered = curr.masteredCardIds - card.id
        val nextIdx = curr.currentIndex + 1
        if (nextIdx < curr.cards.size) {
            _flashcardState.value = curr.copy(
                currentIndex = nextIdx,
                isFlipped = false,
                masteredCardIds = mastered,
                needsReviewCardIds = needs
            )
        } else {
            _flashcardState.value = curr.copy(
                isCompleted = true,
                masteredCardIds = mastered,
                needsReviewCardIds = needs
            )
        }
    }

    fun nextFlashcard() {
        val curr = _flashcardState.value
        if (curr.currentIndex + 1 < curr.cards.size) {
            _flashcardState.value = curr.copy(currentIndex = curr.currentIndex + 1, isFlipped = false)
        }
    }

    fun previousFlashcard() {
        val curr = _flashcardState.value
        if (curr.currentIndex > 0) {
            _flashcardState.value = curr.copy(currentIndex = curr.currentIndex - 1, isFlipped = false)
        }
    }

    fun restartFlashcards(weakOnly: Boolean = false) {
        val curr = _flashcardState.value
        val cardsToUse = if (weakOnly && curr.needsReviewCardIds.isNotEmpty()) {
            curr.cards.filter { curr.needsReviewCardIds.contains(it.id) }
        } else {
            curr.cards
        }
        _flashcardState.value = curr.copy(
            cards = cardsToUse,
            currentIndex = 0,
            isFlipped = false,
            masteredCardIds = emptySet(),
            needsReviewCardIds = emptySet(),
            isCompleted = false
        )
    }

    fun exitFlashcards() {
        _flashcardState.value = FlashcardState(isActive = false)
    }

    // ==========================================
    // --- DAILY CHALLENGE MODE ACTIONS ---
    // ==========================================

    fun startDailyChallenge() {
        dailyChallengeTimerJob?.cancel()
        _dailyChallengeState.value = DailyChallengeState(isActive = true)
        viewModelScope.launch {
            val std = _selectedStd.value
            val subjects = QuizStaticData.standardsList.find { it.std == std }?.subjects ?: emptyList()
            val allQuestions = mutableListOf<QuestionModel>()
            for (subj in subjects) {
                for (u in subj.units) {
                    allQuestions.addAll(repository.getQuestionsForUnit(std, subj.id, u.id))
                }
            }
            val sampled = if (allQuestions.size > 5) allQuestions.shuffled().take(5) else allQuestions
            _dailyChallengeState.value = _dailyChallengeState.value.copy(
                questions = sampled,
                currentIndex = 0,
                selectedAnswer = "",
                isAnswerSubmitted = false,
                correctCount = 0,
                secondsRemaining = 30,
                isFinished = false
            )
            startDailyChallengeTimer()
        }
    }

    private fun startDailyChallengeTimer() {
        dailyChallengeTimerJob?.cancel()
        dailyChallengeTimerJob = viewModelScope.launch {
            while (_dailyChallengeState.value.isActive && !_dailyChallengeState.value.isFinished) {
                delay(1000)
                val secs = _dailyChallengeState.value.secondsRemaining
                if (secs > 1) {
                    _dailyChallengeState.value = _dailyChallengeState.value.copy(secondsRemaining = secs - 1)
                } else {
                    submitDailyChallengeAnswer("TIMED_OUT")
                }
            }
        }
    }

    fun selectDailyChallengeAnswer(answer: String) {
        val curr = _dailyChallengeState.value
        if (curr.isAnswerSubmitted) return
        _dailyChallengeState.value = curr.copy(selectedAnswer = answer)
        if (answer.isEmpty()) return
        submitDailyChallengeAnswer(forcedAnswer = answer)
    }

    fun submitDailyChallengeAnswer(forcedAnswer: String? = null) {
        val curr = _dailyChallengeState.value
        if (curr.isAnswerSubmitted) return
        dailyChallengeTimerJob?.cancel()

        val answer = forcedAnswer ?: curr.selectedAnswer
        val question = curr.questions.getOrNull(curr.currentIndex)
        val isCorrect = question != null && answer.trim().equals(question.correctAnswer.trim(), ignoreCase = true)
        val newCorrect = if (isCorrect) curr.correctCount + 1 else curr.correctCount

        _dailyChallengeState.value = curr.copy(
            isAnswerSubmitted = true,
            selectedAnswer = answer,
            correctCount = newCorrect
        )

        // When correct answer clicked/submitted, move to next question automatically!
        if (isCorrect) {
            dailyChallengeAutoAdvanceJob?.cancel()
            dailyChallengeAutoAdvanceJob = viewModelScope.launch {
                delay(650)
                nextDailyChallengeQuestion()
            }
        }
    }

    fun nextDailyChallengeQuestion() {
        dailyChallengeAutoAdvanceJob?.cancel()
        dailyChallengeAutoAdvanceJob = null
        val curr = _dailyChallengeState.value
        val nextIdx = curr.currentIndex + 1
        if (nextIdx < curr.questions.size) {
            _dailyChallengeState.value = curr.copy(
                currentIndex = nextIdx,
                selectedAnswer = "",
                isAnswerSubmitted = false,
                secondsRemaining = 30
            )
            startDailyChallengeTimer()
        } else {
            finishDailyChallenge()
        }
    }

    private fun finishDailyChallenge() {
        dailyChallengeTimerJob?.cancel()
        val curr = _dailyChallengeState.value
        val earnedCoins = 30 + (curr.correctCount * 10)
        val earnedXP = 100 + (curr.correctCount * 25)

        viewModelScope.launch {
            val profile = repository.userProfile.firstOrNull() ?: UserProfile()
            val newProfile = profile.copy(
                coins = profile.coins + earnedCoins,
                xp = profile.xp + earnedXP,
                attendanceStreak = profile.attendanceStreak + 1
            )
            repository.handleQuizCompletion(
                stdId = _selectedStd.value,
                subjectId = "general",
                unitId = 0,
                score = curr.correctCount,
                total = curr.questions.size
            )
            try {
                quizDataSyncService.triggerAutoSync()
            } catch (ignored: Exception) {}
            repository.addNotification(
                title = "🎯 Daily Challenge Mastered!",
                desc = "You scored ${curr.correctCount}/${curr.questions.size} in Daily Quest! Earned +$earnedXP XP & +$earnedCoins Coins.",
                category = "Reward"
            )
        }

        _dailyChallengeState.value = curr.copy(
            isFinished = true,
            earnedCoins = earnedCoins,
            earnedXP = earnedXP
        )
    }

    fun exitDailyChallenge() {
        dailyChallengeAutoAdvanceJob?.cancel()
        dailyChallengeAutoAdvanceJob = null
        dailyChallengeTimerJob?.cancel()
        _dailyChallengeState.value = DailyChallengeState(isActive = false)
    }

    fun awardMilestoneBonus(points: Int, stars: Int) {
        viewModelScope.launch {
            val prof = repository.getUserProfileDirect() ?: UserProfile()
            val updated = prof.copy(
                totalPoints = prof.totalPoints + points,
                stars = prof.stars + stars,
                xp = prof.xp + (points * 2)
            )
            repository.saveUserProfile(updated)
            repository.addNotification(
                title = "🎉 Milestone Reward Claimed!",
                desc = "Congratulations! You claimed +$points Points and +$stars Stars for your achievement!",
                category = "Milestone"
            )
        }
    }

    // ==========================================
    // --- 60-SECOND QUIZ BLITZ ACTIONS ---
    // ==========================================

    fun startQuizBlitz(stdId: Int = _selectedStd.value) {
        blitzTimerJob?.cancel()
        _blitzState.value = BlitzState(isActive = true, stdId = stdId)
        viewModelScope.launch {
            val subjects = QuizStaticData.standardsList.find { it.std == stdId }?.subjects ?: emptyList()
            val allQuestions = mutableListOf<QuestionModel>()
            for (subj in subjects) {
                for (u in subj.units) {
                    allQuestions.addAll(repository.getQuestionsForUnit(stdId, subj.id, u.id))
                }
            }
            val shuffled = if (allQuestions.isNotEmpty()) allQuestions.shuffled().take(30) else emptyList()
            _blitzState.value = _blitzState.value.copy(
                questions = shuffled,
                currentIndex = 0,
                secondsRemaining = 60,
                score = 0,
                correctCount = 0,
                wrongCount = 0,
                currentStreakCombo = 0,
                highestStreakCombo = 0,
                isFinished = false
            )
            startBlitzTimer()
        }
    }

    private fun startBlitzTimer() {
        blitzTimerJob?.cancel()
        blitzTimerJob = viewModelScope.launch {
            while (_blitzState.value.isActive && !_blitzState.value.isFinished) {
                delay(1000)
                val secs = _blitzState.value.secondsRemaining
                if (secs > 1) {
                    _blitzState.value = _blitzState.value.copy(secondsRemaining = secs - 1)
                } else {
                    finishQuizBlitz()
                    break
                }
            }
        }
    }

    fun submitBlitzAnswer(answer: String) {
        val curr = _blitzState.value
        if (!curr.isActive || curr.isFinished) return
        val currentQ = curr.questions.getOrNull(curr.currentIndex) ?: return
        val isCorrect = answer.trim().equals(currentQ.correctAnswer.trim(), ignoreCase = true)

        val newStreak = if (isCorrect) curr.currentStreakCombo + 1 else 0
        val highest = maxOf(curr.highestStreakCombo, newStreak)
        val multiplier = when {
            newStreak >= 7 -> 4
            newStreak >= 5 -> 3
            newStreak >= 3 -> 2
            else -> 1
        }
        val pointsEarned = if (isCorrect) 100 * multiplier else 0
        val newScore = curr.score + pointsEarned
        val newSeconds = if (isCorrect) (curr.secondsRemaining + 3).coerceAtMost(90) else curr.secondsRemaining

        if (!isCorrect) {
            mistakeManager.addMistake(currentQ, answer)
            _mistakesList.value = mistakeManager.getMistakes()
        } else {
            mistakeManager.removeMistake(currentQ.id)
            _mistakesList.value = mistakeManager.getMistakes()
        }

        val nextIndex = (curr.currentIndex + 1) % curr.questions.size.coerceAtLeast(1)

        _blitzState.value = curr.copy(
            currentIndex = nextIndex,
            score = newScore,
            secondsRemaining = newSeconds,
            correctCount = if (isCorrect) curr.correctCount + 1 else curr.correctCount,
            wrongCount = if (!isCorrect) curr.wrongCount + 1 else curr.wrongCount,
            currentStreakCombo = newStreak,
            highestStreakCombo = highest
        )
    }

    private fun finishQuizBlitz() {
        blitzTimerJob?.cancel()
        val curr = _blitzState.value
        val xpWon = (curr.score / 5).coerceAtLeast(25)
        val coinsWon = (curr.score / 20).coerceAtLeast(5)

        val bestKey = "blitz_high_score_${curr.stdId}"
        val prevBest = appPrefs.getInt(bestKey, 0)
        val isNewBest = curr.score > prevBest && curr.score > 0
        if (isNewBest) {
            appPrefs.edit().putInt(bestKey, curr.score).apply()
        }

        viewModelScope.launch {
            userProfile.value?.let { profile ->
                val newCoins = profile.coins + coinsWon
                val newXP = profile.xp + xpWon
                repository.saveUserProfile(profile.copy(coins = newCoins, xp = newXP))
            }
        }

        _blitzState.value = curr.copy(
            isFinished = true,
            earnedXP = xpWon,
            earnedCoins = coinsWon,
            isNewHighScore = isNewBest
        )
    }

    fun exitQuizBlitz() {
        blitzTimerJob?.cancel()
        _blitzState.value = BlitzState(isActive = false)
    }

    // ==========================================
    // --- MISTAKE VAULT ACTIONS ---
    // ==========================================

    fun removeMistake(questionId: String) {
        mistakeManager.removeMistake(questionId)
        _mistakesList.value = mistakeManager.getMistakes()
    }

    fun clearAllMistakes() {
        mistakeManager.clearAll()
        _mistakesList.value = emptyList()
    }

    fun startMistakePracticeQuiz() {
        val mistakes = _mistakesList.value
        if (mistakes.isEmpty()) return
        val questions = mistakes.map { it.question }
        val firstQ = questions.first()
        _activeQuizState.value = ActiveQuizState(
            isPlaying = true,
            stdId = firstQ.stdId,
            subjectId = firstQ.subjectId,
            unitId = firstQ.unitId,
            unitName = "🧠 Mistake Vault Drill",
            questions = questions,
            currentIndex = 0,
            selectedAnswer = "",
            userMatchState = emptyMap(),
            isAnswerSubmitted = false,
            markedForReview = emptySet(),
            correctCount = 0,
            totalQuestions = questions.size,
            secondsRemaining = 45,
            totalTimeLimitSeconds = 45,
            isQuizFinished = false,
            totalScorePoints = 0,
            totalTimeDeducted = 0,
            totalSpeedBonus = 0,
            totalTimeTakenSeconds = 0,
            questionTimeStats = emptyList(),
            lastQuestionResult = null
        )
        startTimer()
    }

    /**
     * Immediately retries all questions answered incorrectly during the current/recent quiz session.
     */
    fun retrySessionMistakes() {
        val curr = _activeQuizState.value
        val mistakes = curr.incorrectReviewItems.map { it.question }
        if (mistakes.isEmpty()) return

        autoAdvanceJob?.cancel()
        autoAdvanceJob = null
        timerJob?.cancel()

        val firstQ = mistakes.first()
        _activeQuizState.value = ActiveQuizState(
            isPlaying = true,
            stdId = curr.stdId,
            subjectId = curr.subjectId,
            unitId = curr.unitId,
            unitName = "${curr.unitName} (Review Mistakes)",
            questions = mistakes,
            currentIndex = 0,
            selectedAnswer = "",
            userMatchState = emptyMap(),
            isAnswerSubmitted = false,
            markedForReview = emptySet(),
            correctCount = 0,
            totalQuestions = mistakes.size,
            secondsRemaining = 120,
            totalTimeLimitSeconds = 120,
            isQuizFinished = false,
            totalScorePoints = 0,
            totalTimeDeducted = 0,
            totalSpeedBonus = 0,
            totalTimeTakenSeconds = 0,
            questionTimeStats = emptyList(),
            lastQuestionResult = null,
            sessionAnswerReviews = emptyList()
        )
        startTimer()
    }

    // ==========================================
    // --- DAILY STUDY GOAL ACTIONS ---
    // ==========================================

    fun setDailyGoalTarget(target: Int) {
        _dailyGoalTarget.value = target
        appPrefs.edit().putInt("daily_goal_target", target).apply()
    }

    fun claimDailyGoalReward() {
        if (_isDailyGoalClaimed.value) return
        _isDailyGoalClaimed.value = true
        appPrefs.edit().putBoolean("daily_goal_claimed", true).apply()
        viewModelScope.launch {
            userProfile.value?.let { profile ->
                repository.saveUserProfile(
                    profile.copy(
                        xp = profile.xp + 100,
                        coins = profile.coins + 20
                    )
                )
            }
        }
    }

    // ==========================================
    // --- OFFLINE QUIZ DOWNLOAD ACTIONS (ROOM DATABASE) ---
    // ==========================================

    fun isUnitDownloaded(stdId: Int, subjectId: String, unitId: Int): Boolean {
        return downloadedQuizzes.value.any { it.stdId == stdId && it.subjectId == subjectId && it.unitId == unitId }
    }

    fun isUnitDownloading(stdId: Int, subjectId: String, unitId: Int): Boolean {
        val key = "${stdId}_${subjectId}_${unitId}"
        return _downloadingUnits.value.contains(key)
    }

    fun downloadQuizForOffline(
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String,
        onComplete: ((Boolean) -> Unit)? = null
    ) {
        val key = "${stdId}_${subjectId}_${unitId}"
        if (_downloadingUnits.value.contains(key)) return

        _downloadingUnits.value = _downloadingUnits.value + key
        viewModelScope.launch {
            try {
                delay(300) // Brief smooth delay for tactile feedback
                val count = repository.downloadQuizForOffline(stdId, subjectId, unitId, unitName)
                _downloadingUnits.value = _downloadingUnits.value - key
                onComplete?.invoke(count > 0)
            } catch (e: Exception) {
                _downloadingUnits.value = _downloadingUnits.value - key
                onComplete?.invoke(false)
            }
        }
    }

    fun removeDownloadedQuiz(stdId: Int, subjectId: String, unitId: Int) {
        viewModelScope.launch {
            repository.removeDownloadedQuiz(stdId, subjectId, unitId)
        }
    }

    fun clearAllDownloadedQuizzes() {
        viewModelScope.launch {
            repository.clearAllDownloadedQuizzes()
        }
    }

    fun claimDailyStreakBonus(bonusPts: Int, bonusStars: Int) {
        viewModelScope.launch {
            userProfile.value?.let { profile ->
                val newXP = profile.xp + bonusPts
                val newStars = profile.stars + bonusStars
                val newCoins = profile.coins + (bonusPts / 2)
                val newTotalPoints = profile.totalPoints + bonusPts
                repository.saveUserProfile(
                    profile.copy(
                        xp = newXP,
                        stars = newStars,
                        coins = newCoins,
                        totalPoints = newTotalPoints
                    )
                )
            }
        }
    }

    fun downloadAllQuizzesForSubject(stdId: Int, subjectId: String, onComplete: ((Int) -> Unit)? = null) {
        viewModelScope.launch {
            val total = repository.downloadAllQuizzesForSubject(stdId, subjectId)
            onComplete?.invoke(total)
        }
    }

    fun cacheAllQuizzesForStandard(stdId: Int, onComplete: ((Int) -> Unit)? = null) {
        if (_isPreloadingCache.value) return
        _isPreloadingCache.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val total = repository.cacheAllQuizzesForStandard(stdId)
                _isPreloadingCache.value = false
                onComplete?.invoke(total)
            } catch (e: Exception) {
                _isPreloadingCache.value = false
                onComplete?.invoke(0)
            }
        }
    }

    // ==========================================
    // --- BOOKMARKS & VAULT ACTIONS (ROOM DATABASE) ---
    // ==========================================

    fun toggleBookmark(question: QuestionModel) {
        viewModelScope.launch {
            repository.toggleBookmark(question)
        }
    }

    fun isBookmarked(questionId: String): Boolean {
        return bookmarkedQuestions.value.any { it.id == questionId }
    }

    fun removeBookmark(questionId: String) {
        viewModelScope.launch {
            repository.removeBookmark(questionId)
        }
    }

    fun bookmarkQuestion(question: QuestionModel) {
        viewModelScope.launch {
            repository.bookmarkQuestion(question)
        }
    }

    fun clearAllBookmarks() {
        viewModelScope.launch {
            repository.clearAllBookmarks()
        }
    }

    // ==========================================
    // --- STUDY FOCUS TIMER ACTIONS ---
    // ==========================================

    fun setFocusTimerDuration(minutes: Int) {
        focusTimerJob?.cancel()
        _focusTimerState.value = _focusTimerState.value.copy(
            isRunning = false,
            selectedMinutes = minutes,
            secondsRemaining = minutes * 60,
            isBreak = false
        )
    }

    fun toggleFocusTimer() {
        val curr = _focusTimerState.value
        if (curr.isRunning) {
            focusTimerJob?.cancel()
            _focusTimerState.value = curr.copy(isRunning = false)
        } else {
            _focusTimerState.value = curr.copy(isRunning = true)
            startFocusTimerTicks()
        }
    }

    private fun startFocusTimerTicks() {
        focusTimerJob?.cancel()
        focusTimerJob = viewModelScope.launch {
            while (_focusTimerState.value.isRunning && _focusTimerState.value.secondsRemaining > 0) {
                delay(1000)
                val secs = _focusTimerState.value.secondsRemaining - 1
                if (secs <= 0) {
                    val curr = _focusTimerState.value
                    val wasBreak = curr.isBreak
                    val newSessions = if (!wasBreak) curr.completedSessions + 1 else curr.completedSessions
                    val nextBreak = !wasBreak
                    val nextMinutes = if (nextBreak) 5 else curr.selectedMinutes
                    _focusTimerState.value = curr.copy(
                        isRunning = false,
                        secondsRemaining = nextMinutes * 60,
                        completedSessions = newSessions,
                        isBreak = nextBreak
                    )
                    repository.addNotification(
                        title = if (nextBreak) "⏰ Study Session Complete!" else "🔔 Break Over!",
                        desc = if (nextBreak) "Great focus! Take a 5-minute breather." else "Ready for another high-yield study sprint!",
                        category = "General"
                    )
                } else {
                    _focusTimerState.value = _focusTimerState.value.copy(secondsRemaining = secs)
                }
            }
        }
    }

    fun resetFocusTimer() {
        focusTimerJob?.cancel()
        val curr = _focusTimerState.value
        _focusTimerState.value = curr.copy(
            isRunning = false,
            secondsRemaining = curr.selectedMinutes * 60,
            isBreak = false
        )
    }

    // ==========================================
    // --- FIREBASE AUTHENTICATION ACTIONS ---
    // ==========================================

    val isStartupAuthCompleted: StateFlow<Boolean> = firebaseAuthManager.isStartupAuthCompletedFlow

    fun signOutFromApp() {
        firebaseAuthManager.signOut()
    }

    fun isStartupAuthCompleted(): Boolean = firebaseAuthManager.isStartupAuthCompleted()

    fun signInWithFirebase(
        email: String,
        pass: String,
        explicitRole: UserRole? = null,
        onSuccess: (() -> Unit)? = null
    ) {
        viewModelScope.launch {
            val result = firebaseAuthManager.signInWithEmail(email, pass, explicitRole)
            result.onSuccess { user ->
                val profile = repository.getUserProfileDirect() ?: UserProfile()
                val name = user.displayName ?: email.substringBefore("@")
                val updated = profile.copy(name = name)
                repository.saveUserProfile(updated)
                cloudSyncManager.saveUserDoc(user.uid, user.email, name, user.role, updated.standard)
                cloudSyncManager.syncProfileToCloud(user.uid, updated)
                onSuccess?.invoke()
            }
        }
    }

    fun signUpWithFirebase(
        email: String,
        pass: String,
        displayName: String,
        role: UserRole = UserRole.STUDENT,
        standard: Int = 6,
        onSuccess: (() -> Unit)? = null
    ) {
        viewModelScope.launch {
            val result = firebaseAuthManager.signUpWithEmail(email, pass, displayName, role, standard)
            result.onSuccess { user ->
                val profile = repository.getUserProfileDirect() ?: UserProfile()
                val nameToUse = user.displayName ?: displayName.ifBlank {
                    if (role.isPrivileged) "Faculty User" else "Student"
                }
                val updated = profile.copy(name = nameToUse, standard = standard)
                repository.saveUserProfile(updated)
                _selectedStd.value = standard
                cloudSyncManager.saveUserDoc(user.uid, user.email, nameToUse, role, standard)
                cloudSyncManager.syncProfileToCloud(user.uid, updated)
                onSuccess?.invoke()
            }
        }
    }

    fun signInDemoTeacher() {
        viewModelScope.launch {
            val result = firebaseAuthManager.signInDemoTeacher()
            result.onSuccess { user ->
                val profile = repository.getUserProfileDirect()
                if (profile != null) {
                    repository.saveUserProfile(profile.copy(name = user.displayName ?: "Teacher Mrs. Sharma"))
                }
            }
        }
    }

    fun signInDemoAdmin() {
        viewModelScope.launch {
            val result = firebaseAuthManager.signInDemoAdmin()
            result.onSuccess { user ->
                val profile = repository.getUserProfileDirect()
                if (profile != null) {
                    repository.saveUserProfile(profile.copy(name = user.displayName ?: "Principal Administrator"))
                }
            }
        }
    }

    fun signInDemoStudent() {
        viewModelScope.launch {
            val result = firebaseAuthManager.signInDemoStudent()
            result.onSuccess { user ->
                val profile = repository.getUserProfileDirect()
                if (profile != null) {
                    repository.saveUserProfile(profile.copy(name = user.displayName ?: "Aarav Patel"))
                }
            }
        }
    }

    fun signInAnonymously() {
        viewModelScope.launch {
            firebaseAuthManager.signInAnonymously()
        }
    }

    fun signOut() {
        firebaseAuthManager.signOut()
    }

    // ==========================================
    // --- FIREBASE FIRESTORE & STORAGE ACTIONS ---
    // ==========================================

    fun syncWithFirestore() {
        viewModelScope.launch {
            val user = (authUiState.value as? AuthUiState.Authenticated)?.user
            val uid = user?.uid ?: quizDataSyncService.resolveCurrentUserId()
            val profile = repository.getUserProfileDirect()
            if (profile != null) {
                cloudSyncManager.syncProfileToCloud(uid, profile)
            }
            val progress = unitProgressList.value
            if (progress.isNotEmpty()) {
                cloudSyncManager.syncProgressToCloud(uid, progress)
            }
            // Synchronize questions for Firestore persistent offline caching
            val questions = repository.getAllCustomQuestions().firstOrNull() ?: emptyList()
            if (questions.isNotEmpty()) {
                cloudSyncManager.syncQuestionsToCloud(questions)
            }
            // Synchronize progress and quiz history across devices
            quizDataSyncService.syncAll(uid)
        }
    }

    fun restoreFromFirestore() {
        viewModelScope.launch {
            val user = (authUiState.value as? AuthUiState.Authenticated)?.user
            val uid = user?.uid ?: "local_student"
            val result = cloudSyncManager.fetchProfileFromCloud(uid)
            result.onSuccess { restoredProfile ->
                if (restoredProfile != null) {
                    repository.saveUserProfile(restoredProfile)
                }
            }
            // Restore quiz questions from Firestore persistent cache
            val questionsResult = cloudSyncManager.fetchQuestionsFromCloud()
            questionsResult.onSuccess { cloudQuestions ->
                cloudQuestions.forEach { q ->
                    repository.addCustomQuestion(q)
                }
            }
        }
    }

    fun syncQuestionsToFirestore(questions: List<CustomQuestion>) {
        viewModelScope.launch {
            cloudSyncManager.syncQuestionsToCloud(questions)
        }
    }

    fun fetchCachedQuestionsFromFirestore(
        stdId: Int? = null,
        subjectId: String? = null,
        unitId: Int? = null,
        onResult: (List<CustomQuestion>) -> Unit = {}
    ) {
        viewModelScope.launch {
            val res = cloudSyncManager.fetchQuestionsFromCloud(stdId, subjectId, unitId)
            res.onSuccess { list ->
                onResult(list)
            }
        }
    }

    private val _isAvatarUploading = MutableStateFlow(false)
    val isAvatarUploading: StateFlow<Boolean> = _isAvatarUploading.asStateFlow()

    fun uploadStudentAvatar(bytes: ByteArray, onResult: ((Result<String>) -> Unit)? = null) {
        viewModelScope.launch {
            _isAvatarUploading.value = true
            val user = (authUiState.value as? AuthUiState.Authenticated)?.user
            val uid = user?.uid ?: "student_1"
            val result = cloudSyncManager.uploadAvatarToStorage(uid, bytes)
            _isAvatarUploading.value = false
            result.onSuccess { downloadUrl ->
                val current = userProfile.value ?: UserProfile()
                val updated = current.copy(avatar = downloadUrl)
                repository.saveUserProfile(updated)
                cloudSyncManager.syncProfileToCloud(uid, updated)
                _profileUpdateStatus.value = "Photo uploaded to Firebase Storage & saved!"
            }.onFailure { err ->
                _profileUpdateStatus.value = "Upload note: ${err.localizedMessage}"
            }
            onResult?.invoke(result)
        }
    }

    fun updateStudentNameAndGrade(name: String, standard: Int) {
        viewModelScope.launch {
            val current = userProfile.value ?: UserProfile()
            val trimmedName = name.trim().ifEmpty { current.name }
            val updated = current.copy(name = trimmedName, standard = standard)
            repository.saveUserProfile(updated)
            changeStandard(standard)
            val user = (authUiState.value as? AuthUiState.Authenticated)?.user
            val uid = user?.uid ?: "student_${current.id}"
            cloudSyncManager.syncProfileToCloud(uid, updated)
            _profileUpdateStatus.value = "Profile updated & synced to Firestore!"
        }
    }

    // ==========================================
    // --- 1 VS 1 BATTLE ARENA ACTIONS ---
    // ==========================================

    private val sampleOpponents = listOf(
        BattleOpponent(
            id = "opp_1",
            name = "Rohan M.",
            school = "Bishop Cotton Boys, Bangalore",
            avatar = "⚡",
            standard = 6,
            winRate = 78,
            accuracy = 0.80f,
            responseSpeedRangeMs = 2800L..5500L
        ),
        BattleOpponent(
            id = "opp_2",
            name = "Priya Rao",
            school = "Kendriya Vidyalaya, Mysore",
            avatar = "🎓",
            standard = 7,
            winRate = 84,
            accuracy = 0.85f,
            responseSpeedRangeMs = 3200L..6200L
        ),
        BattleOpponent(
            id = "opp_3",
            name = "Aditi K.",
            school = "National Public School, Hubli",
            avatar = "🔥",
            standard = 8,
            winRate = 72,
            accuracy = 0.75f,
            responseSpeedRangeMs = 3500L..7000L
        ),
        BattleOpponent(
            id = "opp_4",
            name = "Kavya S.",
            school = "Govt Model School, Mangalore",
            avatar = "🌟",
            standard = 9,
            winRate = 90,
            accuracy = 0.90f,
            responseSpeedRangeMs = 2200L..4800L
        ),
        BattleOpponent(
            id = "opp_5",
            name = "Arjun Patil",
            school = "Jain Heritage School, Belagavi",
            avatar = "🦁",
            standard = 10,
            winRate = 80,
            accuracy = 0.82f,
            responseSpeedRangeMs = 2600L..5800L
        )
    )

    fun startBattleArena() {
        battleTimerJob?.cancel()
        opponentResponseJob?.cancel()
        _battleArenaState.value = BattleArenaState(
            isActive = true,
            stage = BattleStage.LOBBY
        )
    }

    fun selectBattleSubject(subjectId: String) {
        _battleArenaState.value = _battleArenaState.value.copy(selectedSubject = subjectId)
    }

    fun findBattleMatch(roomCode: String = "") {
        battleTimerJob?.cancel()
        opponentResponseJob?.cancel()
        onlineMatchmakingTimerJob?.cancel()

        _battleArenaState.value = _battleArenaState.value.copy(
            isActive = true,
            stage = BattleStage.MATCHMAKING,
            isSearchingMatch = true,
            roomCode = roomCode,
            statusMessage = if (roomCode.isNotBlank()) "Connecting to room $roomCode..." else "Searching for online student in Karnataka...",
            matchmakingSeconds = 0
        )

        // Elapsed matchmaking counter for UI
        onlineMatchmakingTimerJob = viewModelScope.launch {
            var elapsed = 0
            while (_battleArenaState.value.stage == BattleStage.MATCHMAKING) {
                delay(1000)
                elapsed++
                _battleArenaState.value = _battleArenaState.value.copy(matchmakingSeconds = elapsed)
            }
        }

        viewModelScope.launch {
            val profile = repository.getUserProfileDirect() ?: UserProfile()
            val std = _selectedStd.value
            val subjectFilter = _battleArenaState.value.selectedSubject

            // Candidate questions from real curriculum
            val subjects = QuizStaticData.standardsList.find { it.std == std }?.subjects ?: emptyList()
            val candidateQuestions = mutableListOf<QuestionModel>()
            for (subj in subjects) {
                if (subjectFilter == "mixed" || subj.id.equals(subjectFilter, ignoreCase = true)) {
                    for (u in subj.units) {
                        candidateQuestions.addAll(repository.getQuestionsForUnit(std, subj.id, u.id))
                    }
                }
            }
            if (candidateQuestions.isEmpty()) {
                if (subjectFilter == "mental_ability") {
                    candidateQuestions.addAll(com.example.data.MentalAbilityData.asQuestionModels)
                } else {
                    val staticMatching = QuizStaticData.staticQuestions.filter { 
                        it.subjectId.equals(subjectFilter, ignoreCase = true) 
                    }
                    if (staticMatching.isNotEmpty()) {
                        candidateQuestions.addAll(staticMatching)
                    } else {
                        candidateQuestions.addAll(QuizStaticData.staticQuestions)
                    }
                }
            }

            if (roomCode.isNotBlank()) {
                // 1. Duel via Room Code
                val result = onlineBattleManager.joinByRoomCode(profile, roomCode)
                result.onSuccess { roomId ->
                    _battleArenaState.value = _battleArenaState.value.copy(
                        roomId = roomId,
                        roomCode = roomCode,
                        isOnlineMatch = true,
                        isHost = false,
                        statusMessage = "Joined duel room! Synchronizing arena..."
                    )
                    attachToOnlineBattleRoom(roomId, isHost = false)
                }.onFailure { err ->
                    _battleArenaState.value = _battleArenaState.value.copy(
                        stage = BattleStage.LOBBY,
                        isSearchingMatch = false,
                        statusMessage = "Duel error: ${err.message}"
                    )
                }
            } else {
                // 2. Quick Matchmaking via Firestore
                try {
                    val (roomId, code, isHost) = onlineBattleManager.findOrCreateMatch(
                        user = profile,
                        subjectId = subjectFilter,
                        candidateQuestions = candidateQuestions
                    )

                    _battleArenaState.value = _battleArenaState.value.copy(
                        roomId = roomId,
                        roomCode = code,
                        isOnlineMatch = true,
                        isHost = isHost,
                        isWaitingForOnlinePlayer = isHost,
                        statusMessage = if (isHost) "Room created ($code). Waiting for an online classmate to join..." else "Matched with an online classmate! Entering battle..."
                    )

                    attachToOnlineBattleRoom(roomId, isHost)
                } catch (e: Exception) {
                    // Fallback to instant challenger if offline
                    startAiBattleChallenger(candidateQuestions)
                }
            }
        }
    }

    fun createPrivateBattleRoom() {
        battleTimerJob?.cancel()
        opponentResponseJob?.cancel()
        onlineMatchmakingTimerJob?.cancel()

        viewModelScope.launch {
            val profile = repository.getUserProfileDirect() ?: UserProfile()
            val std = _selectedStd.value
            val subjectFilter = _battleArenaState.value.selectedSubject

            val subjects = QuizStaticData.standardsList.find { it.std == std }?.subjects ?: emptyList()
            val candidateQuestions = mutableListOf<QuestionModel>()
            for (subj in subjects) {
                if (subjectFilter == "mixed" || subj.id.equals(subjectFilter, ignoreCase = true)) {
                    for (u in subj.units) {
                        candidateQuestions.addAll(repository.getQuestionsForUnit(std, subj.id, u.id))
                    }
                }
            }
            if (candidateQuestions.isEmpty()) {
                candidateQuestions.addAll(QuizStaticData.staticQuestions)
            }

            try {
                val (roomId, code) = onlineBattleManager.createPrivateRoom(profile, subjectFilter, candidateQuestions)
                _battleArenaState.value = _battleArenaState.value.copy(
                    isActive = true,
                    stage = BattleStage.MATCHMAKING,
                    isSearchingMatch = true,
                    isOnlineMatch = true,
                    roomId = roomId,
                    roomCode = code,
                    isHost = true,
                    isWaitingForOnlinePlayer = true,
                    statusMessage = "Share Room Code: $code with your friend to duel!"
                )
                attachToOnlineBattleRoom(roomId, isHost = true)
            } catch (e: Exception) {
                _battleArenaState.value = _battleArenaState.value.copy(
                    statusMessage = "Could not create online room: ${e.message}"
                )
            }
        }
    }

    private fun attachToOnlineBattleRoom(roomId: String, isHost: Boolean) {
        onlineBattleManager.attachRoomListener(roomId) { roomData ->
            handleOnlineRoomUpdate(roomData, isHost)
        }
    }

    private fun handleOnlineRoomUpdate(room: OnlineRoomData, isHost: Boolean) {
        val currState = _battleArenaState.value

        when (room.status) {
            "WAITING" -> {
                _battleArenaState.value = currState.copy(
                    stage = BattleStage.MATCHMAKING,
                    roomCode = room.roomCode,
                    isWaitingForOnlinePlayer = true,
                    statusMessage = if (isHost) "Room Code: ${room.roomCode}. Waiting for student to connect..." else "Connecting..."
                )
            }
            "IN_PROGRESS" -> {
                val myPlayer = if (isHost) room.player1 else room.player2
                val oppPlayer = if (isHost) room.player2 else room.player1

                val opponentModel = oppPlayer?.let {
                    BattleOpponent(
                        id = it.uid,
                        name = it.name,
                        school = it.school,
                        avatar = it.avatar,
                        standard = it.standard,
                        winRate = 78,
                        accuracy = 0.84f
                    )
                } ?: currState.opponent

                val questionsList = if (room.questions.isNotEmpty()) room.questions else currState.questions
                val isRoundChanged = currState.currentRoundIndex != room.currentRound || currState.stage != BattleStage.IN_PROGRESS

                _battleArenaState.value = currState.copy(
                    stage = BattleStage.IN_PROGRESS,
                    isSearchingMatch = false,
                    isWaitingForOnlinePlayer = false,
                    questions = questionsList,
                    currentRoundIndex = room.currentRound,
                    opponent = opponentModel,
                    userScore = myPlayer?.score ?: currState.userScore,
                    opponentScore = oppPlayer?.score ?: currState.opponentScore,
                    opponentAnswerLocked = oppPlayer?.currentAnswer?.isNotEmpty() == true,
                    statusMessage = "Battle Active • Round ${room.currentRound + 1} of 5"
                )

                if (isRoundChanged) {
                    startOnlineBattleRoundTimer()
                }

                // If host detects both players have answered, trigger round evaluation
                if (isHost && currState.stage == BattleStage.IN_PROGRESS) {
                    val p1Ans = room.player1.currentAnswer
                    val p2Ans = room.player2?.currentAnswer ?: ""
                    if (p1Ans.isNotEmpty() && p2Ans.isNotEmpty()) {
                        evaluateOnlineRound(room)
                    }
                }
            }
            "ROUND_REVEAL" -> {
                battleTimerJob?.cancel()
                val myPlayer = if (isHost) room.player1 else room.player2
                val oppPlayer = if (isHost) room.player2 else room.player1

                val currQ = room.questions.getOrNull(room.currentRound) ?: currState.currentQuestion
                val userAns = myPlayer?.currentAnswer ?: currState.userSelectedAnswer
                val oppAns = oppPlayer?.currentAnswer ?: currState.opponentSelectedAnswer

                val userCorrect = currQ != null && userAns.trim().equals(currQ.correctAnswer.trim(), ignoreCase = true)
                val oppCorrect = currQ != null && oppAns.trim().equals(currQ.correctAnswer.trim(), ignoreCase = true)

                val roundRes = if (currQ != null) {
                    BattleRoundResult(
                        roundNumber = room.currentRound + 1,
                        question = currQ,
                        userSelectedAnswer = userAns,
                        opponentSelectedAnswer = oppAns,
                        userCorrect = userCorrect,
                        opponentCorrect = oppCorrect,
                        userRoundScore = if (userCorrect) 10 else 0,
                        opponentRoundScore = if (oppCorrect) 10 else 0
                    )
                } else null

                val updatedResults = if (roundRes != null && currState.roundResults.none { it.roundNumber == roundRes.roundNumber }) {
                    currState.roundResults + roundRes
                } else currState.roundResults

                _battleArenaState.value = currState.copy(
                    stage = BattleStage.ROUND_REVEAL,
                    userSelectedAnswer = userAns,
                    opponentSelectedAnswer = oppAns,
                    userScore = myPlayer?.score ?: currState.userScore,
                    opponentScore = oppPlayer?.score ?: currState.opponentScore,
                    roundResults = updatedResults,
                    statusMessage = "Round ${room.currentRound + 1} Result Revealed"
                )

                // Host advances round after 2.4 seconds
                if (isHost) {
                    viewModelScope.launch {
                        delay(2400)
                        val nextRound = room.currentRound + 1
                        val isOver = nextRound >= 5
                        val winnerUid = if (isOver) {
                            val p1Sc = myPlayer?.score ?: 0
                            val p2Sc = oppPlayer?.score ?: 0
                            if (p1Sc > p2Sc) room.player1.uid
                            else if (p2Sc > p1Sc) room.player2?.uid
                            else "TIE"
                        } else null
                        onlineBattleManager.advanceToNextRound(room.roomId, nextRound, isOver, winnerUid)
                    }
                }
            }
            "COMPLETED" -> {
                battleTimerJob?.cancel()
                val myPlayer = if (isHost) room.player1 else room.player2
                val oppPlayer = if (isHost) room.player2 else room.player1
                val won = (myPlayer?.score ?: 0) > (oppPlayer?.score ?: 0)

                viewModelScope.launch {
                    val profile = repository.getUserProfileDirect()
                    if (profile != null) {
                        val addCoins = if (won) 60 else 20
                        val addXP = if (won) 150 else 50
                        val addStars = if (won) 3 else 1
                        repository.saveUserProfile(
                            profile.copy(
                                coins = profile.coins + addCoins,
                                stars = profile.stars + addStars,
                                xp = profile.xp + addXP
                            )
                        )
                    }
                }

                _battleArenaState.value = currState.copy(
                    stage = BattleStage.GAME_OVER,
                    userScore = myPlayer?.score ?: currState.userScore,
                    opponentScore = oppPlayer?.score ?: currState.opponentScore,
                    statusMessage = if (won) "🏆 VICTORY! You won the 1 vs 1 duel!" else "Battle Finished!"
                )
            }
            "CANCELLED" -> {
                _battleArenaState.value = BattleArenaState(isActive = false)
            }
        }
    }

    private fun startOnlineBattleRoundTimer() {
        battleTimerJob?.cancel()
        _battleArenaState.value = _battleArenaState.value.copy(
            roundSecondsRemaining = 15,
            userSelectedAnswer = "",
            opponentSelectedAnswer = "",
            opponentAnswerLocked = false
        )

        battleTimerJob = viewModelScope.launch {
            while (_battleArenaState.value.stage == BattleStage.IN_PROGRESS) {
                delay(1000)
                val secs = _battleArenaState.value.roundSecondsRemaining
                if (secs > 1) {
                    _battleArenaState.value = _battleArenaState.value.copy(roundSecondsRemaining = secs - 1)
                } else {
                    _battleArenaState.value = _battleArenaState.value.copy(roundSecondsRemaining = 0)
                    // If host, auto-evaluate timed out round
                    val state = _battleArenaState.value
                    if (state.isHost && state.isOnlineMatch) {
                        evaluateOnlineRoundTimeout()
                    }
                    break
                }
            }
        }
    }

    private fun evaluateOnlineRound(room: OnlineRoomData) {
        val currQ = room.questions.getOrNull(room.currentRound) ?: return
        val p1Ans = room.player1.currentAnswer
        val p2Ans = room.player2?.currentAnswer ?: ""

        val p1Correct = p1Ans.trim().equals(currQ.correctAnswer.trim(), ignoreCase = true)
        val p2Correct = p2Ans.trim().equals(currQ.correctAnswer.trim(), ignoreCase = true)

        val p1Points = if (p1Correct) 10 else 0
        val p2Points = if (p2Correct) 10 else 0

        val newP1Score = room.player1.score + p1Points
        val newP2Score = (room.player2?.score ?: 0) + p2Points

        viewModelScope.launch {
            onlineBattleManager.revealRound(
                roomId = room.roomId,
                p1Score = newP1Score,
                p2Score = newP2Score,
                p1Streak = if (p1Correct) room.player1.streak + 1 else 0,
                p2Streak = if (p2Correct) (room.player2?.streak ?: 0) + 1 else 0
            )
        }
    }

    private fun evaluateOnlineRoundTimeout() {
        val state = _battleArenaState.value
        val roomId = state.roomId
        if (roomId.isEmpty()) return

        val currQ = state.currentQuestion ?: return
        val userAns = state.userSelectedAnswer
        val userCorrect = userAns.trim().equals(currQ.correctAnswer.trim(), ignoreCase = true)
        val userPts = if (userCorrect) 10 else 0

        viewModelScope.launch {
            onlineBattleManager.revealRound(
                roomId = roomId,
                p1Score = state.userScore + userPts,
                p2Score = state.opponentScore,
                p1Streak = if (userCorrect) state.userStreak + 1 else 0,
                p2Streak = 0
            )
        }
    }

    fun startAiBattleChallenger(candidateQuestionsList: List<QuestionModel>? = null) {
        battleTimerJob?.cancel()
        opponentResponseJob?.cancel()
        onlineMatchmakingTimerJob?.cancel()
        onlineBattleManager.detachListener()

        viewModelScope.launch {
            val std = _selectedStd.value
            val subjectFilter = _battleArenaState.value.selectedSubject
            val candidateQuestions = candidateQuestionsList ?: run {
                val subjects = QuizStaticData.standardsList.find { it.std == std }?.subjects ?: emptyList()
                val list = mutableListOf<QuestionModel>()
                for (subj in subjects) {
                    if (subjectFilter == "mixed" || subj.id.equals(subjectFilter, ignoreCase = true)) {
                        for (u in subj.units) {
                            list.addAll(repository.getQuestionsForUnit(std, subj.id, u.id))
                        }
                    }
                }
                if (list.isEmpty()) QuizStaticData.staticQuestions else list
            }

            val battleQuestions = candidateQuestions.shuffled().take(5)
            val matchedOpponent = sampleOpponents.shuffled().first()

            _battleArenaState.value = _battleArenaState.value.copy(
                isActive = true,
                isOnlineMatch = false,
                isSearchingMatch = false,
                stage = BattleStage.IN_PROGRESS,
                opponent = matchedOpponent,
                questions = battleQuestions,
                currentRoundIndex = 0,
                userScore = 0,
                opponentScore = 0,
                userSelectedAnswer = "",
                opponentSelectedAnswer = "",
                roundResults = emptyList(),
                statusMessage = "Challenging ${matchedOpponent.name} (${matchedOpponent.school})"
            )

            startLocalBattleRound()
        }
    }

    private fun startLocalBattleRound() {
        battleTimerJob?.cancel()
        opponentResponseJob?.cancel()

        _battleArenaState.value = _battleArenaState.value.copy(
            stage = BattleStage.IN_PROGRESS,
            roundSecondsRemaining = 15,
            userSelectedAnswer = "",
            opponentSelectedAnswer = ""
        )

        val currQuestion = _battleArenaState.value.currentQuestion ?: return
        val opponent = _battleArenaState.value.opponent

        opponent?.let { opp ->
            opponentResponseJob = viewModelScope.launch {
                val delayTime = (opp.responseSpeedRangeMs.first..opp.responseSpeedRangeMs.last).random()
                delay(delayTime)

                if (_battleArenaState.value.stage == BattleStage.IN_PROGRESS && _battleArenaState.value.opponentSelectedAnswer.isEmpty()) {
                    val willBeCorrect = Math.random() < opp.accuracy
                    val oppAnswer = if (willBeCorrect) {
                        currQuestion.correctAnswer
                    } else {
                        currQuestion.options.filter { !it.equals(currQuestion.correctAnswer, ignoreCase = true) }.randomOrNull() ?: currQuestion.correctAnswer
                    }
                    _battleArenaState.value = _battleArenaState.value.copy(opponentSelectedAnswer = oppAnswer)

                    if (_battleArenaState.value.userSelectedAnswer.isNotEmpty()) {
                        evaluateLocalBattleRound()
                    }
                }
            }
        }

        battleTimerJob = viewModelScope.launch {
            while (_battleArenaState.value.stage == BattleStage.IN_PROGRESS) {
                delay(1000)
                val secs = _battleArenaState.value.roundSecondsRemaining
                if (secs > 1) {
                    _battleArenaState.value = _battleArenaState.value.copy(roundSecondsRemaining = secs - 1)
                } else {
                    _battleArenaState.value = _battleArenaState.value.copy(roundSecondsRemaining = 0)
                    evaluateLocalBattleRound()
                    break
                }
            }
        }
    }

    fun submitBattleAnswer(answer: String) {
        val curr = _battleArenaState.value
        if (curr.userSelectedAnswer.isNotEmpty() || curr.stage != BattleStage.IN_PROGRESS) return

        _battleArenaState.value = curr.copy(userSelectedAnswer = answer)

        if (curr.isOnlineMatch) {
            val currQ = curr.currentQuestion
            val isCorrect = currQ != null && answer.trim().equals(currQ.correctAnswer.trim(), ignoreCase = true)
            val scoreDelta = if (isCorrect) 10 else 0

            viewModelScope.launch {
                onlineBattleManager.submitPlayerAnswer(
                    roomId = curr.roomId,
                    isHost = curr.isHost,
                    answer = answer,
                    scoreDelta = scoreDelta
                )
            }
        } else {
            // Local bot opponent
            if (curr.opponentSelectedAnswer.isNotEmpty()) {
                evaluateLocalBattleRound()
            }
        }
    }

    private fun evaluateLocalBattleRound() {
        battleTimerJob?.cancel()
        opponentResponseJob?.cancel()

        val curr = _battleArenaState.value
        val question = curr.currentQuestion ?: return

        val userAns = curr.userSelectedAnswer
        var oppAns = curr.opponentSelectedAnswer
        if (oppAns.isEmpty()) {
            val willBeCorrect = Math.random() < (curr.opponent?.accuracy ?: 0.75f)
            oppAns = if (willBeCorrect) question.correctAnswer else question.options.random()
        }

        val userCorrect = userAns.trim().equals(question.correctAnswer.trim(), ignoreCase = true)
        val oppCorrect = oppAns.trim().equals(question.correctAnswer.trim(), ignoreCase = true)

        val userPts = if (userCorrect) 10 + (if (curr.roundSecondsRemaining >= 8) 10 else 5) else 0
        val oppPts = if (oppCorrect) 10 + (if (curr.roundSecondsRemaining >= 5) 10 else 5) else 0

        val newUserScore = curr.userScore + userPts
        val newOppScore = curr.opponentScore + oppPts

        val roundResult = BattleRoundResult(
            roundNumber = curr.currentRoundIndex + 1,
            question = question,
            userSelectedAnswer = userAns,
            opponentSelectedAnswer = oppAns,
            userCorrect = userCorrect,
            opponentCorrect = oppCorrect,
            userRoundScore = userPts,
            opponentRoundScore = oppPts
        )

        _battleArenaState.value = curr.copy(
            stage = BattleStage.ROUND_REVEAL,
            userScore = newUserScore,
            opponentScore = newOppScore,
            opponentSelectedAnswer = oppAns,
            roundResults = curr.roundResults + roundResult
        )

        viewModelScope.launch {
            delay(2200)
            val nextIdx = curr.currentRoundIndex + 1
            if (nextIdx < curr.totalRounds) {
                _battleArenaState.value = _battleArenaState.value.copy(currentRoundIndex = nextIdx)
                startLocalBattleRound()
            } else {
                val finalWin = newUserScore > newOppScore
                val profile = repository.getUserProfileDirect()
                if (profile != null) {
                    val addCoins = if (finalWin) 50 else 15
                    val addXP = if (finalWin) 120 else 40
                    val addStars = if (finalWin) 2 else 0
                    repository.saveUserProfile(
                        profile.copy(
                            coins = profile.coins + addCoins,
                            stars = profile.stars + addStars,
                            xp = profile.xp + addXP
                        )
                    )
                }

                _battleArenaState.value = _battleArenaState.value.copy(stage = BattleStage.GAME_OVER)
            }
        }
    }

    // --- Student Profile Customization & Firestore Persistence ---
    private val _profileUpdateStatus = MutableStateFlow<String?>(null)
    val profileUpdateStatus: StateFlow<String?> = _profileUpdateStatus.asStateFlow()

    fun clearProfileUpdateStatus() {
        _profileUpdateStatus.value = null
    }

    fun updateStudentProfile(avatarId: String, customNickname: String) {
        viewModelScope.launch {
            val current = userProfile.value ?: UserProfile()
            val trimmedNickname = customNickname.trim().ifEmpty { current.nickname }
            val updated = current.copy(
                avatar = avatarId,
                nickname = trimmedNickname
            )

            // 1. Update local Room database
            repository.saveUserProfile(updated)

            // 2. Persist to Cloud Firestore
            val result = cloudSyncManager.updateAvatarAndNickname(
                userId = "student_${current.id}",
                avatar = avatarId,
                nickname = trimmedNickname
            )

            if (result.isSuccess) {
                _profileUpdateStatus.value = "Avatar & nickname synced to Firestore!"
            } else {
                _profileUpdateStatus.value = "Saved locally (Firestore cache active)"
            }
        }
    }

    fun exitBattleArena() {
        battleTimerJob?.cancel()
        opponentResponseJob?.cancel()
        onlineMatchmakingTimerJob?.cancel()
        val roomId = _battleArenaState.value.roomId
        if (roomId.isNotEmpty()) {
            viewModelScope.launch {
                onlineBattleManager.cancelRoom(roomId)
            }
        }
        onlineBattleManager.detachListener()
        _battleArenaState.value = BattleArenaState(isActive = false)
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

    // Room Database Quiz Questions CRUD Operations
    fun insertRoomQuestion(question: QuizQuestionEntity) {
        viewModelScope.launch {
            repository.saveQuizQuestion(question)
        }
    }

    fun updateRoomQuestion(question: QuizQuestionEntity) {
        viewModelScope.launch {
            repository.updateQuizQuestion(question)
        }
    }

    fun deleteRoomQuestion(id: String) {
        viewModelScope.launch {
            repository.deleteQuizQuestionById(id)
        }
    }

    fun insertBulkRoomQuestions(questions: List<QuizQuestionEntity>, onComplete: ((Int) -> Unit)? = null) {
        viewModelScope.launch {
            repository.saveQuizQuestions(questions)
            onComplete?.invoke(questions.size)
        }
    }

    // --- Central Cloud Pool (Firestore) Synchronization Operations ---
    private val _isCentralPoolSyncing = MutableStateFlow(false)
    val isCentralPoolSyncing: StateFlow<Boolean> = _isCentralPoolSyncing.asStateFlow()

    // --- Firestore Bulk Import Operations ---
    private val _firestoreBulkProgress = MutableStateFlow<Pair<Int, Int>?>(null) // (current, total)
    val firestoreBulkProgress: StateFlow<Pair<Int, Int>?> = _firestoreBulkProgress.asStateFlow()

    private val _isBulkImportingToFirestore = MutableStateFlow(false)
    val isBulkImportingToFirestore: StateFlow<Boolean> = _isBulkImportingToFirestore.asStateFlow()

    fun bulkImportQuestionsToFirestore(
        questions: List<QuizQuestionEntity>,
        saveToLocalRoom: Boolean = true,
        onProgress: ((Int, Int) -> Unit)? = null,
        onComplete: ((Int, Boolean, String) -> Unit)? = null
    ) {
        viewModelScope.launch {
            _isBulkImportingToFirestore.value = true
            _firestoreBulkProgress.value = Pair(0, questions.size)
            try {
                // 1. If requested, cache locally in Room DB as well
                if (saveToLocalRoom) {
                    repository.saveQuizQuestions(questions)
                }

                // 2. Map to QuestionModel
                val models = questions.map { it.toQuestionModel() }

                // 3. Batch upload with progress tracking
                val result = cloudSyncManager.syncQuestionModelsWithProgress(models) { current, total ->
                    _firestoreBulkProgress.value = Pair(current, total)
                    onProgress?.invoke(current, total)
                }

                _isBulkImportingToFirestore.value = false
                _firestoreBulkProgress.value = null

                if (result.isSuccess) {
                    val count = result.getOrDefault(questions.size)
                    onComplete?.invoke(count, true, "Successfully uploaded $count questions to Firestore!")
                } else {
                    val msg = result.exceptionOrNull()?.localizedMessage ?: "Firestore upload failed"
                    onComplete?.invoke(0, false, msg)
                }
            } catch (e: Exception) {
                _isBulkImportingToFirestore.value = false
                _firestoreBulkProgress.value = null
                onComplete?.invoke(0, false, e.localizedMessage ?: "Unknown error occurred")
            }
        }
    }

    fun deleteFirestoreQuestion(questionId: String, onComplete: ((Boolean) -> Unit)? = null) {
        viewModelScope.launch {
            val res = cloudSyncManager.deleteQuestionFromCloud(questionId)
            onComplete?.invoke(res.isSuccess)
        }
    }

    fun syncAllRoomQuestionsToCloud(onComplete: ((Int, Boolean) -> Unit)? = null) {
        viewModelScope.launch {
            _isCentralPoolSyncing.value = true
            try {
                val entities = repository.allRoomQuestions.first()
                val models = entities.map { it.toQuestionModel() }
                val result = cloudSyncManager.syncQuestionModelsToCloud(models)
                _isCentralPoolSyncing.value = false
                if (result.isSuccess) {
                    onComplete?.invoke(result.getOrDefault(models.size), true)
                } else {
                    onComplete?.invoke(0, false)
                }
            } catch (e: Exception) {
                _isCentralPoolSyncing.value = false
                onComplete?.invoke(0, false)
            }
        }
    }

    fun fetchAndImportCentralQuestionsFromCloud(
        stdId: Int? = null,
        subjectId: String? = null,
        onComplete: ((Int, Boolean) -> Unit)? = null
    ) {
        viewModelScope.launch {
            _isCentralPoolSyncing.value = true
            try {
                val result = cloudSyncManager.fetchQuestionModelsFromCloud(stdId, subjectId)
                if (result.isSuccess) {
                    val models = result.getOrDefault(emptyList())
                    val entities = models.map { m ->
                        m.toQuizQuestionEntity(
                            unitName = "Unit ${m.unitId}",
                            difficulty = "Medium",
                            hint = "",
                            points = 10,
                            isCustom = true
                        )
                    }
                    if (entities.isNotEmpty()) {
                        repository.saveQuizQuestions(entities)
                    }
                    _isCentralPoolSyncing.value = false
                    onComplete?.invoke(entities.size, true)
                } else {
                    _isCentralPoolSyncing.value = false
                    onComplete?.invoke(0, false)
                }
            } catch (e: Exception) {
                _isCentralPoolSyncing.value = false
                onComplete?.invoke(0, false)
            }
        }
    }

    fun resetQuestionBankToCurriculum(onComplete: ((Int) -> Unit)? = null) {
        viewModelScope.launch {
            try {
                val defaultEntities = QuizStaticData.staticQuestions.map { qModel ->
                    qModel.toQuizQuestionEntity(
                        unitName = "Unit ${qModel.unitId}",
                        difficulty = "Medium",
                        hint = "",
                        points = 10,
                        isCustom = false
                    )
                }
                repository.saveQuizQuestions(defaultEntities)
                onComplete?.invoke(defaultEntities.size)
            } catch (e: Exception) {
                onComplete?.invoke(0)
            }
        }
    }
}

class QuizViewModelFactory(
    private val application: Application,
    private val repository: QuizRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuizViewModel(application, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

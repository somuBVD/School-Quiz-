package com.example.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.math.roundToInt

class QuizRepository(
    private val quizDao: QuizDao,
    private val quizQuestionDao: QuizQuestionDao? = null,
    private val downloadedQuizDao: DownloadedQuizDao? = null,
    private val studentProgressDao: StudentProgressDao? = null,
    private val historicalScoreDao: HistoricalScoreDao? = null,
    private val studentPointDao: StudentPointDao? = null
) {

    val userProfile: Flow<UserProfile?> = quizDao.getUserProfile()
    val activeAds: Flow<List<AdvertisementEntity>> = quizDao.getActiveAdvertisements()
    val notifications: Flow<List<NotificationEntity>> = quizDao.getAllNotifications()
    val leaderboard: Flow<List<LeaderboardUser>> = quizDao.getLeaderboard()
    val bookmarkedQuestions: Flow<List<QuestionModel>> = quizDao.getAllBookmarkedQuestions().map { entities ->
        entities.map { it.toQuestionModel() }
    }
    val allDownloadedQuizzes: Flow<List<DownloadedQuizEntity>> =
        downloadedQuizDao?.getAllDownloadedQuizzes() ?: flow { emit(emptyList()) }
    val downloadedQuizCount: Flow<Int> =
        downloadedQuizDao?.getDownloadedQuizCount() ?: flow { emit(0) }
    val allHistoricalScores: Flow<List<HistoricalScoreEntity>> =
        historicalScoreDao?.getAllHistoricalScores() ?: flow { emit(emptyList()) }
    val totalPointsFlow: Flow<Int> = studentPointDao?.getTotalPointsFlow()?.map { it ?: 0 }
        ?: userProfile.map { it?.totalPoints ?: 0 }
    val recentPointRecords: Flow<List<StudentPointEntity>> =
        studentPointDao?.getRecentPointRecords(10) ?: flow { emit(emptyList()) }

    fun getAllUnitProgress(): Flow<List<UnitProgress>> =
        studentProgressDao?.getAllUnitProgress() ?: quizDao.getAllUnitProgress()

    fun getProgressForStandard(stdId: Int): Flow<List<UnitProgress>> =
        studentProgressDao?.getProgressForStandard(stdId) ?: quizDao.getProgressForStandard(stdId)

    fun getProgressForSubject(stdId: Int, subjectId: String): Flow<List<UnitProgress>> =
        studentProgressDao?.getProgressForSubject(stdId, subjectId) ?: quizDao.getProgressForSubject(stdId, subjectId)

    fun getHistoricalScoresForStandard(stdId: Int): Flow<List<HistoricalScoreEntity>> =
        historicalScoreDao?.getHistoricalScoresForStandard(stdId) ?: flow { emit(emptyList()) }

    fun getHistoricalScoresForSubject(stdId: Int, subjectId: String): Flow<List<HistoricalScoreEntity>> =
        historicalScoreDao?.getHistoricalScoresForSubject(stdId, subjectId) ?: flow { emit(emptyList()) }

    suspend fun recordHistoricalScore(score: HistoricalScoreEntity): Long =
        historicalScoreDao?.insertHistoricalScore(score) ?: -1L

    suspend fun deleteHistoricalScoreById(id: Long) {
        historicalScoreDao?.deleteHistoricalScoreById(id)
    }

    suspend fun clearHistoricalScores() {
        historicalScoreDao?.clearAllHistoricalScores()
    }

    // Local Quiz Questions from Room
    val allRoomQuestions: Flow<List<QuizQuestionEntity>> =
        quizQuestionDao?.getAllQuestions() ?: flow { emit(emptyList()) }

    val totalCachedQuestionsCount: Flow<Int> =
        quizQuestionDao?.getAllQuestionsCountFlow() ?: flow { emit(0) }

    fun getLocalQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int): Flow<List<QuizQuestionEntity>> =
        quizQuestionDao?.getQuestionsForUnit(stdId, subjectId, unitId) ?: flow { emit(emptyList()) }

    suspend fun getLocalQuestionsForUnitDirect(stdId: Int, subjectId: String, unitId: Int): List<QuizQuestionEntity> =
        quizQuestionDao?.getQuestionsForUnitDirect(stdId, subjectId, unitId) ?: emptyList()

    suspend fun saveQuizQuestions(questions: List<QuizQuestionEntity>) {
        quizQuestionDao?.insertQuestions(questions)
    }

    suspend fun saveQuizQuestion(question: QuizQuestionEntity) {
        quizQuestionDao?.insertQuestion(question)
    }

    suspend fun updateQuizQuestion(question: QuizQuestionEntity) {
        quizQuestionDao?.updateQuestion(question)
    }

    suspend fun deleteQuizQuestionById(id: String) {
        quizQuestionDao?.deleteQuestionById(id)
    }

    suspend fun deleteQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int) {
        quizQuestionDao?.deleteQuestionsForUnit(stdId, subjectId, unitId)
    }

    fun getDownloadedQuizzesForStandard(stdId: Int): Flow<List<DownloadedQuizEntity>> =
        downloadedQuizDao?.getDownloadedQuizzesForStandard(stdId) ?: flow { emit(emptyList()) }

    suspend fun isQuizDownloaded(stdId: Int, subjectId: String, unitId: Int): Boolean =
        downloadedQuizDao?.isQuizDownloaded(stdId, subjectId, unitId) ?: false

    suspend fun downloadQuizForOffline(
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String
    ): Int {
        // 1. Gather all questions for this unit from QuizStaticData and custom questions
        val custom = quizDao.getCustomQuestionsForUnit(stdId, subjectId, unitId)
        val questions = QuizStaticData.getQuestionsForUnit(stdId, subjectId, unitId, custom)

        if (questions.isEmpty()) return 0

        // 2. Convert to QuizQuestionEntity and save into Room database table
        val entities = questions.map { q ->
            q.toQuizQuestionEntity(
                unitName = unitName,
                difficulty = "Medium"
            )
        }
        quizQuestionDao?.insertQuestions(entities)

        // 3. Register the downloaded unit package in DownloadedQuizDao
        val downloadedPkg = DownloadedQuizEntity(
            stdId = stdId,
            subjectId = subjectId,
            unitId = unitId,
            unitName = unitName,
            questionCount = questions.size,
            downloadedAt = System.currentTimeMillis(),
            sizeBytes = (questions.size * 320L),
            isDownloaded = true
        )
        downloadedQuizDao?.insertDownloadedQuiz(downloadedPkg)

        return questions.size
    }

    suspend fun removeDownloadedQuiz(stdId: Int, subjectId: String, unitId: Int) {
        // Delete downloaded package entry
        downloadedQuizDao?.deleteDownloadedQuiz(stdId, subjectId, unitId)
        // Also delete saved questions from quiz_questions table for this unit
        quizQuestionDao?.deleteQuestionsForUnit(stdId, subjectId, unitId)
    }

    suspend fun clearAllDownloadedQuizzes() {
        downloadedQuizDao?.deleteAllDownloadedQuizzes()
        quizQuestionDao?.clearAllQuestions()
    }

    suspend fun downloadAllQuizzesForSubject(stdId: Int, subjectId: String): Int {
        val standard = QuizStaticData.standardsList.find { it.std == stdId }
        val subject = standard?.subjects?.find { it.id == subjectId } ?: return 0
        var totalDownloaded = 0
        for (unit in subject.units) {
            totalDownloaded += downloadQuizForOffline(stdId, subjectId, unit.id, unit.name)
        }
        return totalDownloaded
    }

    suspend fun getQuizQuestionById(id: String): QuizQuestionEntity? =
        quizQuestionDao?.getQuestionById(id)

    suspend fun cacheAllQuizzesForStandard(stdId: Int): Int {
        val standard = QuizStaticData.standardsList.find { it.std == stdId } ?: return 0
        var totalCached = 0
        for (subject in standard.subjects) {
            for (unit in subject.units) {
                totalCached += downloadQuizForOffline(stdId, subject.id, unit.id, unit.name)
            }
        }
        return totalCached
    }

    suspend fun getQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int): List<QuestionModel> {
        // First check locally persisted Room quiz questions
        val localRoomQuestions = quizQuestionDao?.getQuestionsForUnitDirect(stdId, subjectId, unitId) ?: emptyList()
        if (localRoomQuestions.isNotEmpty()) {
            return localRoomQuestions.map { it.toQuestionModel() }
        }
        val custom = quizDao.getCustomQuestionsForUnit(stdId, subjectId, unitId)
        val questions = QuizStaticData.getQuestionsForUnit(stdId, subjectId, unitId, custom)

        // Automatically cache into Room database for instant offline access when internet connection drops
        if (questions.isNotEmpty()) {
            try {
                val entities = questions.map { q ->
                    q.toQuizQuestionEntity(
                        unitName = "Unit $unitId",
                        difficulty = "Medium"
                    )
                }
                quizQuestionDao?.insertQuestions(entities)
                downloadedQuizDao?.insertDownloadedQuiz(
                    DownloadedQuizEntity(
                        stdId = stdId,
                        subjectId = subjectId,
                        unitId = unitId,
                        unitName = "Unit $unitId",
                        questionCount = questions.size,
                        downloadedAt = System.currentTimeMillis(),
                        sizeBytes = questions.size * 320L,
                        isDownloaded = true
                    )
                )
            } catch (_: Exception) {
                // Ignore caching errors to ensure questions still display
            }
        }

        return questions
    }

    suspend fun getUserProfileDirect(): UserProfile? = quizDao.getUserProfileDirect()

    suspend fun saveUserProfile(profile: UserProfile) {
        quizDao.insertUserProfile(profile)
    }

    suspend fun handleQuizCompletion(
        stdId: Int,
        subjectId: String,
        unitId: Int,
        score: Int,
        total: Int,
        xpEarnedOverride: Int? = null
    ) {
        val accuracy = if (total > 0) (score.toFloat() / total * 100).roundToInt() else 0
        
        // 1. Calculate Rewards & Points (10 pts per correct answer + 50 pts perfect score bonus)
        val pointsPerCorrect = 10
        val basePointsEarned = score * pointsPerCorrect
        val bonusPoints = if (score == total && total > 0) 50 else 0
        val totalPointsAwarded = basePointsEarned + bonusPoints

        val xpEarned = xpEarnedOverride ?: (score * StudentLevelSystem.XP_PER_CORRECT_ANSWER + if (score == total && total > 0) StudentLevelSystem.XP_PERFECT_SCORE_BONUS else 0)
        val starsEarned = score * 2
        val coinsEarned = score * 5 + (if (score == total && total > 0) 50 else 0) // Bonus 50 coins for perfect score
        
        // 2. Load and Update User Profile
        val currentProfile = quizDao.getUserProfileDirect() ?: UserProfile()
        val newXp = currentProfile.xp + xpEarned
        val newStars = currentProfile.stars + starsEarned
        val newCoins = currentProfile.coins + coinsEarned
        val newPoints = currentProfile.totalPoints + totalPointsAwarded
        
        val updatedProfile = currentProfile.copy(
            xp = newXp,
            stars = newStars,
            coins = newCoins,
            totalPoints = newPoints
        )
        quizDao.insertUserProfile(updatedProfile)

        // 2b. Record Points in Room Database
        if (totalPointsAwarded > 0) {
            val pointRecord = StudentPointEntity(
                points = totalPointsAwarded,
                source = if (bonusPoints > 0) "PERFECT_SCORE_BONUS" else "CORRECT_ANSWER",
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                correctAnswersCount = score,
                description = "Solved $score questions correctly (+$basePointsEarned pts)${if (bonusPoints > 0) " + $bonusPoints pts perfect score bonus!" else ""}"
            )
            studentPointDao?.insertPointRecord(pointRecord)
        }

        // 3. Update Unit Play Progress Record
        val existingProgress = studentProgressDao?.getUnitProgressDirect(stdId, subjectId, unitId)
            ?: quizDao.getProgressForUnitDirect(stdId, subjectId, unitId)
        val finalProgressPercent = maxOf(existingProgress?.progress ?: 0, accuracy)
        val updatedProgress = UnitProgress(
            stdId = stdId,
            subjectId = subjectId,
            unitId = unitId,
            progress = finalProgressPercent,
            completedQuestions = maxOf(existingProgress?.completedQuestions ?: 0, score),
            totalQuestions = total,
            difficulty = existingProgress?.difficulty ?: "Medium"
        )
        quizDao.insertUnitProgress(updatedProgress)
        studentProgressDao?.insertUnitProgress(updatedProgress)

        // 3b. Store Historical Score Locally on Device
        historicalScoreDao?.insertHistoricalScore(
            HistoricalScoreEntity(
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                unitName = "Unit $unitId",
                score = score,
                totalQuestions = total,
                accuracyPercentage = accuracy,
                earnedCoins = coinsEarned,
                earnedXP = xpEarned,
                earnedStars = starsEarned,
                isPassed = accuracy >= 50,
                completedAt = System.currentTimeMillis()
            )
        )

        // 4. Record Achievement Notifications
        if (score == total && total > 0) {
            quizDao.insertNotification(
                NotificationEntity(
                    title = "🏆 Perfect Score Badge!",
                    description = "You scored $score/$total in $subjectId (Unit $unitId). Received 50 bonus coins!",
                    category = "Reward"
                )
            )
        } else if (accuracy >= 80) {
            quizDao.insertNotification(
                NotificationEntity(
                    title = "🌟 Academic Honor Star",
                    description = "Excellent job! You finished with $accuracy% accuracy in Chapter $unitId.",
                    category = "Reward"
                )
            )
        }

        // 5. Re-evaluate Leaderboard Standings
        // Fetch all leaderboard members, update user's score, sort, and update ranks
        val myName = currentProfile.name
        val allLeaderboard = mutableListOf<LeaderboardUser>()
        
        // Create standard default users if database flow has none
        val defaults = listOf(
            LeaderboardUser("Prajwal K.", 320, 68, 1750, isMe = false),
            LeaderboardUser("Sneha Rao", 290, 55, 1420, isMe = false),
            LeaderboardUser(myName, newCoins, newStars, newXp, isMe = true),
            LeaderboardUser("Akshay N.", 180, 31, 1100, isMe = false),
            LeaderboardUser("Tejas Gowda", 150, 24, 980, isMe = false),
            LeaderboardUser("Kavya S.", 110, 18, 820, isMe = false)
        )

        val updatedDefaults = defaults.map { user ->
            if (user.isMe || user.name == myName) {
                user.copy(coins = newCoins, stars = newStars, xp = newXp)
            } else {
                user
            }
        }.sortedByDescending { it.xp }

        val rankedList = updatedDefaults.mapIndexed { index, user ->
            user.copy(rank = index + 1)
        }
        quizDao.insertLeaderboardUsers(rankedList)
    }

    suspend fun claimDailyReward(): Boolean {
        val currentProfile = quizDao.getUserProfileDirect() ?: return false
        val now = System.currentTimeMillis()
        val oneDayMillis = 24 * 60 * 60 * 1000
        
        // Safety check to ensure daily claims are restricted correctly
        val claimedRecently = (now - currentProfile.lastClaimedTimestamp) < oneDayMillis
        
        if (claimedRecently) {
            // Give 50 coins even if already claimed, but don't increase attendance streak (for demo playability)
            val updated = currentProfile.copy(
                coins = currentProfile.coins + 25,
                lastClaimedTimestamp = now
            )
            quizDao.insertUserProfile(updated)
            quizDao.insertNotification(
                NotificationEntity(
                    title = "🎁 Reward Claimed!",
                    description = "Demo replay reward: Credited 25 bonus coins to your user profile.",
                    category = "Reward"
                )
            )
            return true
        }

        val nextStreak = currentProfile.attendanceStreak + 1
        val updated = currentProfile.copy(
            coins = currentProfile.coins + 100,
            attendanceStreak = nextStreak,
            lastClaimedTimestamp = now
        )
        quizDao.insertUserProfile(updated)

        quizDao.insertNotification(
            NotificationEntity(
                title = "🔥 Daily Reward Claimed!",
                description = "Claimed +100 Coins! Standard streak is now at $nextStreak days.",
                category = "Reward"
            )
        )
        return true
    }

    suspend fun changeLanguage(lang: String) {
        val profile = quizDao.getUserProfileDirect() ?: return
        quizDao.insertUserProfile(profile.copy(language = lang))
    }

    suspend fun changeSelectedStd(std: Int) {
        val profile = quizDao.getUserProfileDirect() ?: return
        quizDao.insertUserProfile(profile.copy(standard = std))
    }

    suspend fun addCustomQuestion(question: CustomQuestion) {
        quizDao.insertCustomQuestion(question)
        quizDao.insertNotification(
            NotificationEntity(
                title = "📝 Custom Question Added",
                description = "Admin added a new ${question.type} question in Subject '${question.subjectId}', Unit ${question.unitId}.",
                category = "System"
            )
        )
    }

    suspend fun deleteCustomQuestionById(id: Int) {
        quizDao.deleteCustomQuestionById(id)
    }

    fun getAllCustomQuestions(): Flow<List<CustomQuestion>> =
        quizDao.getAllCustomQuestions()

    suspend fun addNotification(title: String, desc: String, category: String) {
        quizDao.insertNotification(NotificationEntity(title = title, description = desc, category = category))
    }

    suspend fun deleteNotificationById(id: Int) {
        quizDao.deleteNotificationById(id)
    }

    suspend fun addAdvertisement(ad: AdvertisementEntity) {
        quizDao.insertAdvertisement(ad)
    }

    suspend fun deleteAdvertisementById(id: Int) {
        quizDao.deleteAdvertisementById(id)
    }

    // --- Bookmarked / Saved Questions Actions ---
    suspend fun toggleBookmark(question: QuestionModel): Boolean {
        val exists = quizDao.isQuestionBookmarked(question.id)
        if (exists) {
            quizDao.deleteBookmarkedQuestion(question.id)
            return false
        } else {
            quizDao.insertBookmarkedQuestion(question.toBookmarkedEntity())
            return true
        }
    }

    suspend fun bookmarkQuestion(question: QuestionModel) {
        quizDao.insertBookmarkedQuestion(question.toBookmarkedEntity())
    }

    suspend fun removeBookmark(questionId: String) {
        quizDao.deleteBookmarkedQuestion(questionId)
    }

    suspend fun isQuestionBookmarked(questionId: String): Boolean {
        return quizDao.isQuestionBookmarked(questionId)
    }

    fun isQuestionBookmarkedFlow(questionId: String): Flow<Boolean> {
        return quizDao.isQuestionBookmarkedFlow(questionId)
    }

    suspend fun clearAllBookmarks() {
        quizDao.clearAllBookmarkedQuestions()
    }
}

package com.example.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {

    // --- User Profile ---
    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    fun getUserProfile(): Flow<UserProfile?>

    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    suspend fun getUserProfileDirect(): UserProfile?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProfile(profile: UserProfile)

    @Update
    suspend fun updateUserProfile(profile: UserProfile)


    // --- Unit Progress ---
    @Query("SELECT * FROM unit_progress")
    fun getAllUnitProgress(): Flow<List<UnitProgress>>

    @Query("SELECT * FROM unit_progress WHERE stdId = :stdId")
    fun getProgressForStandard(stdId: Int): Flow<List<UnitProgress>>

    @Query("SELECT * FROM unit_progress WHERE stdId = :stdId AND subjectId = :subjectId")
    fun getProgressForSubject(stdId: Int, subjectId: String): Flow<List<UnitProgress>>

    @Query("SELECT * FROM unit_progress WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId LIMIT 1")
    suspend fun getProgressForUnitDirect(stdId: Int, subjectId: String, unitId: Int): UnitProgress?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnitProgress(progress: UnitProgress)


    // --- Custom Questions ---
    @Query("SELECT * FROM custom_questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun getCustomQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int): List<CustomQuestion>

    @Query("SELECT * FROM custom_questions")
    fun getAllCustomQuestions(): Flow<List<CustomQuestion>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomQuestion(question: CustomQuestion)

    @Query("DELETE FROM custom_questions WHERE id = :id")
    suspend fun deleteCustomQuestionById(id: Int)


    // --- Leaderboard ---
    @Query("SELECT * FROM leaderboard ORDER BY xp DESC")
    fun getLeaderboard(): Flow<List<LeaderboardUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeaderboardUsers(users: List<LeaderboardUser>)

    @Query("SELECT * FROM leaderboard WHERE isMe = 1 LIMIT 1")
    suspend fun getMyLeaderboardEntry(): LeaderboardUser?

    @Update
    suspend fun updateLeaderboardUser(user: LeaderboardUser)


    // --- Notifications ---
    @Query("SELECT * FROM notifications ORDER BY timestamp DESC")
    fun getAllNotifications(): Flow<List<NotificationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotification(notification: NotificationEntity)

    @Query("DELETE FROM notifications WHERE id = :id")
    suspend fun deleteNotificationById(id: Int)

    @Query("UPDATE notifications SET isRead = 1 WHERE id = :id")
    suspend fun markNotificationAsRead(id: Int)


    // --- Advertisements ---
    @Query("SELECT * FROM advertisements WHERE isActive = 1")
    fun getActiveAdvertisements(): Flow<List<AdvertisementEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdvertisement(ad: AdvertisementEntity)

    @Query("DELETE FROM advertisements WHERE id = :id")
    suspend fun deleteAdvertisementById(id: Int)


    // --- Bookmarked / Saved Questions ---
    @Query("SELECT * FROM bookmarked_questions ORDER BY bookmarkedAt DESC")
    fun getAllBookmarkedQuestions(): Flow<List<BookmarkedQuestionEntity>>

    @Query("SELECT * FROM bookmarked_questions WHERE stdId = :stdId ORDER BY bookmarkedAt DESC")
    fun getBookmarkedQuestionsForStandard(stdId: Int): Flow<List<BookmarkedQuestionEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarked_questions WHERE questionId = :questionId)")
    fun isQuestionBookmarkedFlow(questionId: String): Flow<Boolean>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarked_questions WHERE questionId = :questionId)")
    suspend fun isQuestionBookmarked(questionId: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmarkedQuestion(question: BookmarkedQuestionEntity)

    @Query("DELETE FROM bookmarked_questions WHERE questionId = :questionId")
    suspend fun deleteBookmarkedQuestion(questionId: String)

    @Query("DELETE FROM bookmarked_questions")
    suspend fun clearAllBookmarkedQuestions()
}

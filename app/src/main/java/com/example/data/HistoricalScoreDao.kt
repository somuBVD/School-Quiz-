package com.example.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for local historical scores and performance records.
 */
@Dao
interface HistoricalScoreDao {

    @Query("SELECT * FROM historical_scores ORDER BY completedAt DESC")
    fun getAllHistoricalScores(): Flow<List<HistoricalScoreEntity>>

    @Query("SELECT * FROM historical_scores ORDER BY completedAt DESC")
    suspend fun getAllHistoricalScoresList(): List<HistoricalScoreEntity>

    @Query("SELECT * FROM historical_scores WHERE completedAt = :completedAt LIMIT 1")
    suspend fun getScoreByCompletedAt(completedAt: Long): HistoricalScoreEntity?

    @Query("SELECT * FROM historical_scores WHERE stdId = :stdId ORDER BY completedAt DESC")
    fun getHistoricalScoresForStandard(stdId: Int): Flow<List<HistoricalScoreEntity>>

    @Query("SELECT * FROM historical_scores WHERE stdId = :stdId AND subjectId = :subjectId ORDER BY completedAt DESC")
    fun getHistoricalScoresForSubject(stdId: Int, subjectId: String): Flow<List<HistoricalScoreEntity>>

    @Query("SELECT * FROM historical_scores WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId ORDER BY completedAt DESC")
    fun getHistoricalScoresForUnit(stdId: Int, subjectId: String, unitId: Int): Flow<List<HistoricalScoreEntity>>

    @Query("SELECT * FROM historical_scores ORDER BY completedAt DESC LIMIT :limit")
    fun getRecentScores(limit: Int = 10): Flow<List<HistoricalScoreEntity>>

    @Query("SELECT MAX(score) FROM historical_scores WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun getHighScoreForUnit(stdId: Int, subjectId: String, unitId: Int): Int?

    @Query("SELECT AVG(accuracyPercentage) FROM historical_scores")
    fun getOverallAverageAccuracy(): Flow<Double?>

    @Query("SELECT AVG(accuracyPercentage) FROM historical_scores WHERE stdId = :stdId")
    fun getAverageAccuracyForStandard(stdId: Int): Flow<Double?>

    @Query("SELECT COUNT(*) FROM historical_scores")
    fun getTotalQuizzesTaken(): Flow<Int>

    @Query("SELECT SUM(earnedXP) FROM historical_scores")
    fun getTotalHistoricalXP(): Flow<Int?>

    @Query("SELECT SUM(earnedCoins) FROM historical_scores")
    fun getTotalHistoricalCoins(): Flow<Int?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoricalScore(score: HistoricalScoreEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoricalScores(scores: List<HistoricalScoreEntity>)

    @Delete
    suspend fun deleteHistoricalScore(score: HistoricalScoreEntity)

    @Query("DELETE FROM historical_scores WHERE id = :id")
    suspend fun deleteHistoricalScoreById(id: Long)

    @Query("DELETE FROM historical_scores")
    suspend fun clearAllHistoricalScores()
}

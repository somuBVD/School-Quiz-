package com.example.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for local student unit progress tracking.
 */
@Dao
interface StudentProgressDao {

    @Query("SELECT * FROM unit_progress WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId LIMIT 1")
    fun getUnitProgress(stdId: Int, subjectId: String, unitId: Int): Flow<UnitProgress?>

    @Query("SELECT * FROM unit_progress WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId LIMIT 1")
    suspend fun getUnitProgressDirect(stdId: Int, subjectId: String, unitId: Int): UnitProgress?

    @Query("SELECT * FROM unit_progress WHERE stdId = :stdId ORDER BY subjectId ASC, unitId ASC")
    fun getProgressForStandard(stdId: Int): Flow<List<UnitProgress>>

    @Query("SELECT * FROM unit_progress WHERE stdId = :stdId AND subjectId = :subjectId ORDER BY unitId ASC")
    fun getProgressForSubject(stdId: Int, subjectId: String): Flow<List<UnitProgress>>

    @Query("SELECT * FROM unit_progress ORDER BY stdId ASC, subjectId ASC, unitId ASC")
    fun getAllUnitProgress(): Flow<List<UnitProgress>>

    @Query("SELECT * FROM unit_progress ORDER BY stdId ASC, subjectId ASC, unitId ASC")
    suspend fun getAllUnitProgressList(): List<UnitProgress>

    @Query("SELECT COUNT(*) FROM unit_progress WHERE stdId = :stdId AND progress >= 100")
    fun getCompletedUnitsCount(stdId: Int): Flow<Int>

    @Query("SELECT AVG(progress) FROM unit_progress WHERE stdId = :stdId")
    fun getAverageProgressForStandard(stdId: Int): Flow<Double?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnitProgress(progress: UnitProgress)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUnitProgress(progressList: List<UnitProgress>)

    @Update
    suspend fun updateUnitProgress(progress: UnitProgress)

    @Query("UPDATE unit_progress SET progress = :progress, completedQuestions = :completed WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun updateProgressValues(stdId: Int, subjectId: String, unitId: Int, progress: Int, completed: Int)

    @Delete
    suspend fun deleteUnitProgress(progress: UnitProgress)

    @Query("DELETE FROM unit_progress WHERE stdId = :stdId")
    suspend fun clearProgressForStandard(stdId: Int)

    @Query("DELETE FROM unit_progress")
    suspend fun clearAllUnitProgress()
}

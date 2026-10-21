package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for local student points table in Room database.
 */
@Dao
interface StudentPointDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPointRecord(record: StudentPointEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPointRecords(records: List<StudentPointEntity>)

    @Query("SELECT SUM(points) FROM student_points")
    fun getTotalPointsFlow(): Flow<Int?>

    @Query("SELECT SUM(points) FROM student_points")
    suspend fun getTotalPointsDirect(): Int?

    @Query("SELECT * FROM student_points ORDER BY timestamp DESC")
    fun getAllPointRecords(): Flow<List<StudentPointEntity>>

    @Query("SELECT * FROM student_points ORDER BY timestamp DESC LIMIT :limit")
    fun getRecentPointRecords(limit: Int): Flow<List<StudentPointEntity>>

    @Query("SELECT SUM(points) FROM student_points WHERE subjectId = :subjectId")
    fun getPointsForSubject(subjectId: String): Flow<Int?>

    @Query("SELECT SUM(points) FROM student_points WHERE stdId = :stdId")
    fun getPointsForStandard(stdId: Int): Flow<Int?>

    @Query("DELETE FROM student_points")
    suspend fun clearAllPoints()
}

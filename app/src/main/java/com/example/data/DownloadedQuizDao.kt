package com.example.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for managing downloaded offline quizzes in Room.
 */
@Dao
interface DownloadedQuizDao {

    @Query("SELECT * FROM downloaded_quizzes ORDER BY downloadedAt DESC")
    fun getAllDownloadedQuizzes(): Flow<List<DownloadedQuizEntity>>

    @Query("SELECT * FROM downloaded_quizzes WHERE stdId = :stdId ORDER BY subjectId ASC, unitId ASC")
    fun getDownloadedQuizzesForStandard(stdId: Int): Flow<List<DownloadedQuizEntity>>

    @Query("SELECT * FROM downloaded_quizzes WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId LIMIT 1")
    suspend fun getDownloadedQuiz(stdId: Int, subjectId: String, unitId: Int): DownloadedQuizEntity?

    @Query("SELECT COUNT(*) > 0 FROM downloaded_quizzes WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun isQuizDownloaded(stdId: Int, subjectId: String, unitId: Int): Boolean

    @Query("SELECT COUNT(*) FROM downloaded_quizzes")
    fun getDownloadedQuizCount(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDownloadedQuiz(quiz: DownloadedQuizEntity)

    @Query("DELETE FROM downloaded_quizzes WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun deleteDownloadedQuiz(stdId: Int, subjectId: String, unitId: Int)

    @Query("DELETE FROM downloaded_quizzes")
    suspend fun deleteAllDownloadedQuizzes()
}

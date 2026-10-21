package com.example.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for offline persistence of quiz questions.
 */
@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions WHERE id = :id LIMIT 1")
    suspend fun getQuestionById(id: String): Question?

    @Query("SELECT * FROM questions ORDER BY stdId ASC, subjectId ASC, unitId ASC, id ASC")
    fun getAllQuestions(): Flow<List<Question>>

    @Query("SELECT * FROM questions ORDER BY stdId ASC, subjectId ASC, unitId ASC, id ASC")
    suspend fun getAllQuestionsList(): List<Question>

    @Query("SELECT * FROM questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId ORDER BY id ASC")
    fun getQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int): Flow<List<Question>>

    @Query("SELECT * FROM questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId ORDER BY id ASC")
    suspend fun getQuestionsForUnitDirect(stdId: Int, subjectId: String, unitId: Int): List<Question>

    @Query("SELECT * FROM questions WHERE stdId = :stdId AND subjectId = :subjectId ORDER BY unitId ASC, id ASC")
    fun getQuestionsForSubject(stdId: Int, subjectId: String): Flow<List<Question>>

    @Query("SELECT * FROM questions WHERE stdId = :stdId ORDER BY subjectId ASC, unitId ASC, id ASC")
    fun getQuestionsForStandard(stdId: Int): Flow<List<Question>>

    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getQuestionCount(): Int

    @Query("SELECT COUNT(*) FROM questions")
    fun getQuestionCountFlow(): Flow<Int>

    @Query("SELECT COUNT(*) FROM questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun getQuestionCountForUnit(stdId: Int, subjectId: String, unitId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<Question>)

    @Update
    suspend fun updateQuestion(question: Question)

    @Delete
    suspend fun deleteQuestion(question: Question)

    @Query("DELETE FROM questions WHERE id = :id")
    suspend fun deleteQuestionById(id: String)

    @Query("DELETE FROM questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun deleteQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int)

    @Query("DELETE FROM questions WHERE isCustom = 1")
    suspend fun deleteCustomQuestions()

    @Query("DELETE FROM questions")
    suspend fun clearAllQuestions()
}

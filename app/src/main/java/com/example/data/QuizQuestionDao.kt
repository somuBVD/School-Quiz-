package com.example.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for local quiz questions table.
 */
@Dao
interface QuizQuestionDao {

    @Query("SELECT * FROM quiz_questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId ORDER BY id ASC")
    fun getQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int): Flow<List<QuizQuestionEntity>>

    @Query("SELECT * FROM quiz_questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId ORDER BY id ASC")
    suspend fun getQuestionsForUnitDirect(stdId: Int, subjectId: String, unitId: Int): List<QuizQuestionEntity>

    @Query("SELECT * FROM quiz_questions WHERE stdId = :stdId AND subjectId = :subjectId ORDER BY unitId ASC, id ASC")
    fun getQuestionsForSubject(stdId: Int, subjectId: String): Flow<List<QuizQuestionEntity>>

    @Query("SELECT * FROM quiz_questions WHERE stdId = :stdId ORDER BY subjectId ASC, unitId ASC")
    fun getQuestionsForStandard(stdId: Int): Flow<List<QuizQuestionEntity>>

    @Query("SELECT * FROM quiz_questions WHERE id = :id LIMIT 1")
    suspend fun getQuestionById(id: String): QuizQuestionEntity?

    @Query("SELECT * FROM quiz_questions ORDER BY id ASC LIMIT 500")
    fun getAllQuestions(): Flow<List<QuizQuestionEntity>>

    @Query("SELECT COUNT(*) FROM quiz_questions")
    suspend fun getQuestionCount(): Int

    @Query("SELECT COUNT(*) FROM quiz_questions")
    fun getAllQuestionsCountFlow(): Flow<Int>

    @Query("SELECT COUNT(*) FROM quiz_questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun getQuestionCountForUnit(stdId: Int, subjectId: String, unitId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuizQuestionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuizQuestionEntity>)

    @Update
    suspend fun updateQuestion(question: QuizQuestionEntity)

    @Delete
    suspend fun deleteQuestion(question: QuizQuestionEntity)

    @Query("DELETE FROM quiz_questions WHERE id = :id")
    suspend fun deleteQuestionById(id: String)

    @Query("DELETE FROM quiz_questions WHERE stdId = :stdId AND subjectId = :subjectId AND unitId = :unitId")
    suspend fun deleteQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int)

    @Query("DELETE FROM quiz_questions WHERE isCustom = 1")
    suspend fun deleteCustomQuestions()

    @Query("DELETE FROM quiz_questions")
    suspend fun clearAllQuestions()
}

package com.example.data

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

data class MistakeItem(
    val question: QuestionModel,
    val studentWrongAnswer: String,
    val timestamp: Long = System.currentTimeMillis()
)

class MistakeManager(context: Context) {
    private val prefs = context.getSharedPreferences("student_mistake_vault", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_MISTAKES = "saved_mistakes_json"
        @Volatile
        private var instance: MistakeManager? = null

        fun getInstance(context: Context): MistakeManager {
            return instance ?: synchronized(this) {
                instance ?: MistakeManager(context.applicationContext).also { instance = it }
            }
        }
    }

    fun getMistakes(): List<MistakeItem> {
        val jsonStr = prefs.getString(KEY_MISTAKES, null) ?: return emptyList()
        val list = mutableListOf<MistakeItem>()
        try {
            val jsonArray = JSONArray(jsonStr)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val qObj = obj.getJSONObject("question")
                val optArray = qObj.getJSONArray("options")
                val options = mutableListOf<String>()
                for (j in 0 until optArray.length()) {
                    options.add(optArray.getString(j))
                }

                val question = QuestionModel(
                    id = qObj.getString("id"),
                    stdId = qObj.getInt("stdId"),
                    subjectId = qObj.getString("subjectId"),
                    unitId = qObj.getInt("unitId"),
                    type = qObj.getString("type"),
                    questionText = qObj.getString("questionText"),
                    options = options,
                    correctAnswer = qObj.getString("correctAnswer"),
                    explanation = qObj.optString("explanation", ""),
                    mediaRes = qObj.optString("mediaRes", "")
                )

                list.add(
                    MistakeItem(
                        question = question,
                        studentWrongAnswer = obj.optString("studentWrongAnswer", ""),
                        timestamp = obj.optLong("timestamp", System.currentTimeMillis())
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    fun addMistake(question: QuestionModel, wrongAnswer: String) {
        val current = getMistakes().toMutableList()
        // Replace if already exists with latest attempt
        current.removeAll { it.question.id == question.id }
        current.add(0, MistakeItem(question = question, studentWrongAnswer = wrongAnswer))
        saveMistakes(current)
    }

    fun removeMistake(questionId: String) {
        val current = getMistakes().toMutableList()
        val removed = current.removeAll { it.question.id == questionId }
        if (removed) {
            saveMistakes(current)
        }
    }

    fun clearAll() {
        prefs.edit().remove(KEY_MISTAKES).apply()
    }

    private fun saveMistakes(items: List<MistakeItem>) {
        try {
            val jsonArray = JSONArray()
            items.take(100).forEach { item ->
                val obj = JSONObject()
                obj.put("studentWrongAnswer", item.studentWrongAnswer)
                obj.put("timestamp", item.timestamp)

                val qObj = JSONObject()
                qObj.put("id", item.question.id)
                qObj.put("stdId", item.question.stdId)
                qObj.put("subjectId", item.question.subjectId)
                qObj.put("unitId", item.question.unitId)
                qObj.put("type", item.question.type)
                qObj.put("questionText", item.question.questionText)
                qObj.put("correctAnswer", item.question.correctAnswer)
                qObj.put("explanation", item.question.explanation)
                qObj.put("mediaRes", item.question.mediaRes)

                val optArray = JSONArray()
                item.question.options.forEach { optArray.put(it) }
                qObj.put("options", optArray)

                obj.put("question", qObj)
                jsonArray.put(obj)
            }
            prefs.edit().putString(KEY_MISTAKES, jsonArray.toString()).apply()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

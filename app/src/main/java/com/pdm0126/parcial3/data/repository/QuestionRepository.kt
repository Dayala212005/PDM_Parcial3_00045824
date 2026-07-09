package com.pdm0126.parcial3.data.repository

import com.pdm0126.parcial3.data.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestions(): Flow<List<Question>>
    suspend fun addQuestion(title: String, id: Int)
}
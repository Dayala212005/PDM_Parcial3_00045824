package com.pdm0126.parcial3.data.repository

import com.pdm0126.parcial3.data.local.DAOs.QuestionDao
import com.pdm0126.parcial3.data.local.Entity.QuestionEntity
import com.pdm0126.parcial3.data.local.Entity.toModel
import com.pdm0126.parcial3.data.model.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(
    private val questionDao: QuestionDao
) : QuestionRepository {

    override fun getQuestions(): Flow<List<Question>> {
        return questionDao.getQuestionsWithOptions().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun addQuestion(title: String, id: Int) {
        questionDao.insertQuestion(QuestionEntity(id = id, title = title))
    }

}
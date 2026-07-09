package com.pdm0126.parcial3.data.repository

import com.pdm0126.parcial3.data.model.Option
import kotlinx.coroutines.flow.Flow


interface OptionRepository {
    fun getOptions(questionId: Int): Flow<List<Option>>
    suspend fun addOption(id: Int, name: String, imageUrl: String, questionId: Int, votes: Int)
}
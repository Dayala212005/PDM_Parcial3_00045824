package com.pdm0126.parcial3.data.repository

import com.pdm0126.parcial3.data.local.DAOs.OptionDao
import com.pdm0126.parcial3.data.local.Entity.toEntity
import com.pdm0126.parcial3.data.local.Entity.toModel
import com.pdm0126.parcial3.data.model.Option
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl(
    private val optionDao: OptionDao
) : OptionRepository {

    override fun getOptions(questionId: Int): Flow<List<Option>> {
        return optionDao.getOptionsForQuestion(questionId).map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(id: Int, name: String, imageUrl: String, questionId: Int, votes: Int) {
        val option = Option(id = id, name = name, imageUrl = imageUrl, questionId = questionId, votes = votes)
        optionDao.insertOption(option.toEntity())
    }

}
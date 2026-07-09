package com.pdm0126.parcial3.data

import android.content.Context
import com.pdm0126.parcial3.data.local.AppDatabase
import com.pdm0126.parcial3.data.repository.OptionRepository
import com.pdm0126.parcial3.data.repository.OptionRepositoryImpl
import com.pdm0126.parcial3.data.repository.QuestionRepository
import com.pdm0126.parcial3.data.repository.QuestionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)

    private val questionDao = appDatabase.questionDao()
    private val optionDao = appDatabase.optionDao()

    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }

}
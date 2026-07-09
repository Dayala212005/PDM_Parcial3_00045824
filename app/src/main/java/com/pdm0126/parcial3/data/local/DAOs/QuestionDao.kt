package com.pdm0126.parcial3.data.local.DAOs

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.pdm0126.parcial3.data.local.Entity.QuestionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {

    @Transaction
    @Query("SELECT * FROM questions")
    fun getQuestionsWithOptions(): Flow<List<QuestionEntity>>

    @Upsert
    suspend fun insertQuestion(question: QuestionEntity)

}
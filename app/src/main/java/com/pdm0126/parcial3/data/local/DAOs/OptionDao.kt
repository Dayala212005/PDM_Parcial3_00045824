package com.pdm0126.parcial3.data.local.DAOs

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.pdm0126.parcial3.data.local.Entity.OptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionDao {

    @Transaction
    @Query("SELECT * FROM options WHERE questionId = :questionId")
    fun getOptionsForQuestion(questionId: Int): Flow<List<OptionEntity>>

    @Upsert
    suspend fun insertOption(option: OptionEntity)

}
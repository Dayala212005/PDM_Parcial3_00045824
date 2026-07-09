package com.pdm0126.parcial3.data.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pdm0126.parcial3.data.model.Question

@Entity(tableName = "questions")
data class QuestionEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String
)

fun QuestionEntity.toModel(): Question {
    return Question(
        id = id,
        title = title
    )
}

fun Question.toEntity(): QuestionEntity {
    return QuestionEntity(
        id = id,
        title = title
    )
}
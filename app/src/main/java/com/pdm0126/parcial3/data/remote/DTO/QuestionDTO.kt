package com.pdm0126.parcial3.data.remote.DTO

import com.pdm0126.parcial3.data.model.Question
import kotlinx.serialization.Serializable

@Serializable
data class QuestionDTO(
    val id: Int,
    val title: String
)

fun QuestionDTO.toModel(): Question {
    return Question(
        id = id,
        title = title
    )
}


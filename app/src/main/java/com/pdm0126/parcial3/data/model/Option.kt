package com.pdm0126.parcial3.data.model

data class Option (
    val id: Int,
    val name: String,
    val imageUrl: String,
    val votes: Int,
    val questionId: Int
)
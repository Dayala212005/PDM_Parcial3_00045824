package com.pdm0126.parcial3.data.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pdm0126.parcial3.data.model.Option

@Entity(tableName = "options")
data class OptionEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val imageUrl: String,
    val votes: Int,
    val questionId: Int
)

fun OptionEntity.toModel(): Option {
    return Option(
        id = id,
        name = name,
        imageUrl = imageUrl,
        votes = votes,
        questionId = questionId
    )
}

fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        votes = votes,
        questionId = questionId
    )
}
package com.example.foodrecipeapp.Model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodrecipeapp.util.Constants.TASTY_IMAGE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TASTY_IMAGE_TABLE)
data class TastyItem(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    @Embedded
    val thumbnail_url: String,
    @Embedded
    val video_url: String
)

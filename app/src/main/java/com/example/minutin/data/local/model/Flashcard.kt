package com.example.minutin.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flashcards")
data class Flashcard(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val question: String,
    val answer: String,
    val subject: String,

    val createdAt: Long = System.currentTimeMillis()
)

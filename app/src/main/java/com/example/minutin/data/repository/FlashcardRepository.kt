package com.example.minutin.data.repository

import com.example.minutin.data.local.model.Flashcard

interface FlashcardRepository {
    suspend fun insert(flashcard: Flashcard)
    suspend fun getAll(): List<Flashcard>
}


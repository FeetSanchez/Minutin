package com.example.minutin.data.repository

import com.example.minutin.data.local.model.Flashcard
import kotlinx.coroutines.flow.Flow

interface FlashcardRepository {
    suspend fun insert(flashcard: Flashcard)
    fun getAll(): Flow<List<Flashcard>>
    suspend fun insertMockData()
}

package com.example.minutin.data.repository.impl

import com.example.minutin.data.local.db.MinutinDatabase
import com.example.minutin.data.local.model.Flashcard
import com.example.minutin.data.repository.FlashcardRepository

class FlashcardRepositoryImpl(private val db: MinutinDatabase) : FlashcardRepository {
    override suspend fun insert(flashcard: Flashcard) {
        db.flashcardDao().insert(flashcard)
    }
    override suspend fun getAll(): List<Flashcard> {
        return db.flashcardDao().getAll()
    }
}


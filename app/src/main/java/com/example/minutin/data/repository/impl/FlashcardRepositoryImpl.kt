package com.example.minutin.data.repository.impl

import com.example.minutin.data.local.db.MinutinDatabase
import com.example.minutin.data.local.model.Flashcard
import com.example.minutin.data.repository.FlashcardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FlashcardRepositoryImpl(private val db: MinutinDatabase) : FlashcardRepository {
    override suspend fun insert(flashcard: Flashcard) {
        db.flashcardDao().insert(flashcard)
    }
    override fun getAll(): Flow<List<Flashcard>> {
        return db.flashcardDao().getAll().map { it }
    }

    override suspend fun insertMockData() {
        val mocks = listOf(
            Flashcard(question = "What is Kotlin?", answer = "A modern programming language.", subject = "Dev"),
            Flashcard(question = "Capital of Brazil?", answer = "Brasília", subject = "Geography"),
            Flashcard(question = "Meaning of OOP?", answer = "Object Oriented Programming.", subject = "Tech")
        )
        mocks.forEach { db.flashcardDao().insert(it) }
    }

}

package com.example.minutin.domain.usecase

import com.example.minutin.core.flashcards.FlashcardGenerator
import com.example.minutin.data.local.model.Flashcard
import javax.inject.Inject

class GenerateFlashcardsUseCase @Inject constructor(private val generator: FlashcardGenerator) {
    suspend operator fun invoke(text: String, subject: String): List<Flashcard> {
        return generator.generateFromText(text, subject)
    }
}


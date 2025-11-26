package com.example.minutin.core.flashcards
}
    }
        }
            Flashcard(subject = subject, question = parts.getOrNull(0) ?: "", answer = parts.getOrNull(1) ?: "")
            val parts = it.split("|").map { p -> p.trim() }
        return lines.map {
        val lines = response.lines().filter { it.contains("|") }
    private fun parseFlashcardsFromResponse(response: String, subject: String): List<Flashcard> {

    }
        return "Crie até 10 flashcards (pergunta | resposta) a partir do texto abaixo:\n\n$text"
    private fun buildPromptForFlashcards(text: String): String {

    }
        return parseFlashcardsFromResponse(response, subject)
        val response = llm.generateText(prompt)
        val prompt = buildPromptForFlashcards(text)
    suspend fun generateFromText(text: String, subject: String): List<Flashcard> {

    }
        return generateFromText(text, subject)
        val text = ocr.processImage(inputImage)
    suspend fun generateFromImage(inputImage: InputImage, subject: String): List<Flashcard> {
class FlashcardGenerator(private val ocr: OCRManager, private val llm: LLMApiService) {

import com.google.mlkit.vision.common.InputImage
import com.example.minutin.data.local.model.Flashcard
import com.example.minutin.data.remote.llm.LLMApiService
import com.example.minutin.core.ml.OCRManager



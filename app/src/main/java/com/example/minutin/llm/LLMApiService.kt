package com.example.minutin.llm

/**
 * Simple contract for an on-device / remote LLM service.
 * Implementations should perform text generation/summarization.
 * This is a placeholder interface used across the codebase.
 */
interface LLMApiService {
    suspend fun generate(text: String): String
}


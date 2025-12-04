package com.example.minutin.llm

import javax.inject.Inject

/**
 * Mock implementation used for development and previews.
 * Returns a deterministic mock response; replace with real client later.
 */
class LLMApiServiceImpl @Inject constructor() : LLMApiService {
    override suspend fun generate(text: String): String {
        return "Mock response for: $text"
    }
}


package com.example.minutin.core.ml

class LocalSummarizer {
    fun summarize(text: String, maxSentences: Int = 3): String {

        return text.lines().take(maxSentences).joinToString("\n")

    }

}




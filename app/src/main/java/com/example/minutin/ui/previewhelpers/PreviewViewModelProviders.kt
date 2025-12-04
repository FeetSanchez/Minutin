package com.example.minutin.ui.previewhelpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.minutin.data.local.model.Flashcard

/**
 * Lightweight preview dependency holder. This file intentionally avoids
 * using Android context, Hilt, or Room. Use in @Preview composables.
 */

// Simple container for preview data/dependencies.
data class PreviewDeps(
    val sampleFlashcards: List<Flashcard> = listOf()
)

// CompositionLocal to provide preview deps inside previews.
val LocalPreviewDeps = staticCompositionLocalOf { PreviewDeps() }

/**
 * PreviewHost wraps preview content and provides fake dependencies via composition.
 * Use this to render screens without Hilt or real ViewModels.
 */
@Composable
fun PreviewHost(content: @Composable (PreviewDeps) -> Unit) {
    // Create fake data for previews
    val deps = remember {
        PreviewDeps(
            sampleFlashcards = listOf(
                Flashcard(question = "What is AI?", answer = "Artificial Intelligence", subject = "Tech"),
                Flashcard(question = "Capital of France?", answer = "Paris", subject = "Geography")
            )
        )
    }

    androidx.compose.runtime.CompositionLocalProvider(LocalPreviewDeps provides deps) {
        content(deps)
    }
}

/**
 * Generic helper to create/remember fake ViewModel-like objects in preview.
 * It accepts a factory lambda and uses remember to hold the instance.
 */
@Composable
fun <T> PreviewViewModelProvider(factory: () -> T): T = remember(factory) { factory() }


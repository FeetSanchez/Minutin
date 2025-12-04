package com.example.minutin.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.minutin.data.local.model.Flashcard
import com.example.minutin.ui.previewhelpers.PreviewHost

/**
 * Lightweight preview of flashcards list that doesn't use DB or DI.
 */
@Composable
fun FlashcardListScreen(flashcards: List<Flashcard>) {
    LazyColumn {
        items(flashcards) { card ->
            Column {
                Text(card.question)
                Text(card.answer)
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlashcardPreviewScreen() {
    PreviewHost { deps ->
        FlashcardListScreen(flashcards = deps.sampleFlashcards)
    }
}


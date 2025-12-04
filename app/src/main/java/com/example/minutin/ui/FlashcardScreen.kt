package com.example.minutin.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.minutin.data.local.model.Flashcard
import com.example.minutin.viewmodel.FlashcardViewModel

@Composable
fun FlashcardScreen(vm: FlashcardViewModel = hiltViewModel()) {
    val cards by vm.flashcards.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { vm.insertMock() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Insert Mock Data")
        }

        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(cards) { card: Flashcard ->
                Column(modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(text = card.question, style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold))
                    Text(text = card.answer, style = MaterialTheme.typography.body1)
                    Text(text = "Subject: ${card.subject}", style = MaterialTheme.typography.caption)
                    Divider(modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
    }
}


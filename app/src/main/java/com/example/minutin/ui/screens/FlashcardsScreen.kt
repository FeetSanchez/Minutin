package com.example.minutin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FlashcardsScreen(onReview: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Flashcards", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))
        Text("Lista de assuntos e cartões (agrupados por assunto)")
        Spacer(Modifier.height(12.dp))
        Button(onClick = onReview) { Text("Revisar antigos") }
    }
}


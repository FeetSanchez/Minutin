package com.example.minutin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onStudy: () -> Unit,
    onFlashcards: () -> Unit,
    onTasks: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Bem-vindo, Usuário", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Resumo da semana")
                Text("Tempo total: 0 min")
                LinearProgressIndicator(progress = 0.3f, modifier = Modifier.fillMaxWidth().height(8.dp))
            }
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = onStudy, modifier = Modifier.fillMaxWidth()) {
            Text("STUDY")
        }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onFlashcards, modifier = Modifier.fillMaxWidth()) {
            Text("Flashcards")
        }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onTasks, modifier = Modifier.fillMaxWidth()) {
            Text("Tarefas / Assuntos")
        }
    }
}


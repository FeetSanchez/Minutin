package com.example.minutin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskAssignmentScreen(onDone: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Selecionar assuntos a estudar", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))
        Column {
            Row { Checkbox(checked = false, onCheckedChange = {}) ; Text("Matemática") }
            Row { Checkbox(checked = false, onCheckedChange = {}) ; Text("História") }
            Row { Checkbox(checked = false, onCheckedChange = {}) ; Text("Línguas") }
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = onDone, modifier = Modifier.fillMaxWidth()) { Text("Salvar") }
    }
}


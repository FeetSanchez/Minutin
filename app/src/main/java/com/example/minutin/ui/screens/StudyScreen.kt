package com.example.minutin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudyScreen(onOpenChat: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Study", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))
        var message by remember { mutableStateOf("") }
        OutlinedTextField(value = message, onValueChange = { message = it }, modifier = Modifier.fillMaxWidth(), label = { Text("Enviar mensagem") })
        Spacer(Modifier.height(8.dp))
        Row {
            Button(onClick = onOpenChat) { Text("Abrir Chat Completo") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { /* abrir modal upload arquivos */ }) { Text("Enviar arquivo") }
        }
        Spacer(Modifier.height(12.dp))
        Text("Selecione seu humor (reset diário):")
        Row {
            Button(onClick = { /* motivado */ }) { Text("Motivado") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { /* neutro */ }) { Text("Neutro") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { /* cansado */ }) { Text("Cansado") }
        }
    }
}


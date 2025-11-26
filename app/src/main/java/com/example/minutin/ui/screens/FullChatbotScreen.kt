package com.example.minutin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FullChatbotScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Chatbot Multimodal", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))
        Text("Integração de texto, voz e upload de arquivos. (LLM remoto placeholder)")
        Spacer(Modifier.height(12.dp))
        Button(onClick = { /* iniciar STT */ }) { Text("Ativar voz") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = { /* iniciar TTS leitura */ }) { Text("Ler resposta") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = { /* enviar arquivos */ }) { Text("Enviar arquivo") }
    }
}


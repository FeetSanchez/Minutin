package com.example.minutin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Bem-vindo ao Minutin", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))
        Text("Insira seus horários ocupados (ex.: 09:00-12:00)")
        var busyTimes by remember { mutableStateOf("") }
        OutlinedTextField(value = busyTimes, onValueChange = { busyTimes = it }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(12.dp))
        Button(onClick = { onFinished() }, modifier = Modifier.fillMaxWidth()) {
            Text("Continuar")
        }
    }
}


package com.example.minutin.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColors = lightColors()
private val DarkColors = darkColors()

@Composable
fun MinutinTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = LightColors) {
        content()
    }
}


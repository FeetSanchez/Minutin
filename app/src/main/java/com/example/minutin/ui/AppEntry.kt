package com.example.minutin.ui

import androidx.compose.runtime.Composable
import com.example.minutin.ui.navigation.MinutinNavGraph
import com.example.minutin.ui.theme.MinutinTheme

@Composable
fun AppEntry() {
    MinutinTheme {
        MinutinNavGraph()
    }
}


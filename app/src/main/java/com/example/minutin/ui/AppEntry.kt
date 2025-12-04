package com.example.minutin.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.minutin.ui.navigation.MinutinNavGraph
import com.example.minutin.ui.navigation.Destinations
import com.example.minutin.ui.theme.MinutinTheme
import androidx.compose.material.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun AppEntry() {
    MinutinTheme {
        val navController = rememberNavController()
        Box(modifier = Modifier.fillMaxSize()) {
            // Render the app navigation with an externally provided NavController
            MinutinNavGraph(startDestination = Destinations.Home.route, navController = navController)

            // Debug floating navigation menu — visible overlay so you can jump to any screen
            var menuOpen by remember { mutableStateOf(false) }

            FloatingActionButton(
                onClick = { menuOpen = !menuOpen },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(Icons.Default.Menu, contentDescription = "Debug Menu")
            }

            if (menuOpen) {
                Popup(
                    alignment = Alignment.BottomEnd,
                    properties = PopupProperties(focusable = true)
                ) {
                    Surface(elevation = 8.dp) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Destinations::class.java // keep reference
                            // Buttons to navigate to each destination
                            TextButtonNav(navController, Destinations.Home.route, "Home")
                            Spacer(Modifier.height(8.dp))
                            TextButtonNav(navController, Destinations.Study.route, "Study")
                            Spacer(Modifier.height(8.dp))
                            TextButtonNav(navController, Destinations.Flashcards.route, "Flashcards")
                            Spacer(Modifier.height(8.dp))
                            TextButtonNav(navController, Destinations.FullChatbot.route, "Chatbot")
                            Spacer(Modifier.height(8.dp))
                            TextButtonNav(navController, Destinations.TaskAssignment.route, "Tasks")
                            Spacer(Modifier.height(8.dp))
                            TextButtonNav(navController, Destinations.Onboarding.route, "Onboarding")
                            Spacer(Modifier.height(8.dp))
                            TextButtonNav(navController, Destinations.Login.route, "Login")
                            Spacer(Modifier.height(8.dp))
                            TextButtonNav(navController, Destinations.SignUp.route, "SignUp")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TextButtonNav(navController: androidx.navigation.NavHostController, route: String, label: String) {
    androidx.compose.material.TextButton(onClick = { navController.navigate(route) }) {
        Text(label)
    }
}

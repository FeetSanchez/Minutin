package com.example.minutin.ui.navigation

sealed class Destinations(val route: String) {
    object Onboarding : Destinations("onboarding")
    object Login : Destinations("login")
    object SignUp : Destinations("signup")
    object Home : Destinations("home")
    object Study : Destinations("study")
    object Flashcards : Destinations("flashcards")
    object FullChatbot : Destinations("full_chatbot")
    object TaskAssignment : Destinations("tasks")
}


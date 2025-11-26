package com.example.minutin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.minutin.ui.screens.*

@Composable
fun MinutinNavGraph(startDestination: String = Destinations.Onboarding.route) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Destinations.Onboarding.route) {
            OnboardingScreen(onFinished = { navController.navigate(Destinations.Home.route) })
        }
        composable(Destinations.Login.route) {
            LoginScreen(onLoginSuccess = { navController.navigate(Destinations.Home.route) })
        }
        composable(Destinations.SignUp.route) {
            SignUpScreen(onSignUpSuccess = { navController.navigate(Destinations.Home.route) })
        }
        composable(Destinations.Home.route) {
            HomeScreen(onStudy = { navController.navigate(Destinations.Study.route) },
                onFlashcards = { navController.navigate(Destinations.Flashcards.route) },
                onTasks = { navController.navigate(Destinations.TaskAssignment.route) })
        }
        composable(Destinations.Study.route) {
            StudyScreen(onOpenChat = { navController.navigate(Destinations.FullChatbot.route) })
        }
        composable(Destinations.Flashcards.route) {
            FlashcardsScreen(onReview = { /* navegar para revisão */ })
        }
        composable(Destinations.FullChatbot.route) {
            FullChatbotScreen()
        }
        composable(Destinations.TaskAssignment.route) {
            TaskAssignmentScreen(onDone = { navController.popBackStack() })
        }
    }
}


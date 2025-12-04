package com.example.minutin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minutin.ui.screens.*

@Composable
fun MinutinNavGraph(
    startDestination: String = Destinations.Onboarding.route,
    navController: NavHostController? = null
) {
    val controller = navController ?: rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(navController = controller, startDestination = startDestination) {
            composable(Destinations.Onboarding.route) {
                OnboardingScreen(onFinished = { controller.navigate(Destinations.Home.route) })
            }
            composable(Destinations.Login.route) {
                LoginScreen(onLoginSuccess = { controller.navigate(Destinations.Home.route) })
            }
            composable(Destinations.SignUp.route) {
                SignUpScreen(onSignUpSuccess = { controller.navigate(Destinations.Home.route) })
            }
            composable(Destinations.Home.route) {
                HomeScreen(onStudy = { controller.navigate(Destinations.Study.route) },
                    onFlashcards = { controller.navigate(Destinations.Flashcards.route) },
                    onTasks = { controller.navigate(Destinations.TaskAssignment.route) })
            }
            composable(Destinations.Study.route) {
                StudyScreen(onOpenChat = { controller.navigate(Destinations.FullChatbot.route) })
            }
            composable(Destinations.Flashcards.route) {
                FlashcardsScreen(onReview = { /* navegar para revisão */ })
            }
            composable(Destinations.FullChatbot.route) {
                FullChatbotScreen()
            }
            composable(Destinations.TaskAssignment.route) {
                TaskAssignmentScreen(onDone = { controller.popBackStack() })
            }
        }
    }
}

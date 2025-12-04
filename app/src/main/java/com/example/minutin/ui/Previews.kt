package com.example.minutin.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.minutin.ui.previewhelpers.PreviewHost
import com.example.minutin.ui.screens.*
import com.example.minutin.ui.theme.MinutinTheme

// Create isolated previews for each screen using fake callbacks and mock state where needed.

@Preview(showBackground = true, name = "HomeScreen Preview")
@Composable
fun PreviewHomeScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            // Use fake telemetry via deps for previews if your HomeScreen accepts it.
            HomeScreen(onStudy = {}, onFlashcards = {}, onTasks = {})
        }
    }
}

@Preview(showBackground = true, name = "StudyScreen Preview")
@Composable
fun PreviewStudyScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            // Show StudyScreen with fake chat repo
            StudyScreen(onOpenChat = {})
        }
    }
}

@Preview(showBackground = true, name = "FlashcardsScreen Preview")
@Composable
fun PreviewFlashcardsScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            FlashcardsScreen(onReview = {})
        }
    }
}

@Preview(showBackground = true, name = "FullChatbotScreen Preview")
@Composable
fun PreviewFullChatbotScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            FullChatbotScreen()
        }
    }
}

@Preview(showBackground = true, name = "LoginScreen Preview")
@Composable
fun PreviewLoginScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            LoginScreen(onLoginSuccess = {})
        }
    }
}

@Preview(showBackground = true, name = "SignUpScreen Preview")
@Composable
fun PreviewSignUpScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            SignUpScreen(onSignUpSuccess = {})
        }
    }
}

@Preview(showBackground = true, name = "OnboardingScreen Preview")
@Composable
fun PreviewOnboardingScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            OnboardingScreen(onFinished = {})
        }
    }
}

@Preview(showBackground = true, name = "TaskAssignmentScreen Preview")
@Composable
fun PreviewTaskAssignmentScreen() {
    MinutinTheme {
        PreviewHost { deps ->
            TaskAssignmentScreen(onDone = {})
        }
    }
}

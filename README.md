Minutin - Study optimization app (Kotlin, Jetpack Compose, MVVM)

This repository contains a starter skeleton for Minutin with:
- Jetpack Compose UI
- Hilt DI
- Room database
- DataStore (preferences)
- ML Kit OCR integration stub
- STT/TTS stubs
- Flashcard generation pipeline (OCR -> LLM stub)

How to build:
1. Install Android SDK and set up environment for Gradle.
2. Open in Android Studio and let it download dependencies.
3. Add required external model files (TFLite) or libraries (MediaPipe) as noted in code comments.
4. Replace LLM API placeholder in `LLMApiService.kt` with a Retrofit implementation and your API key.

Notes:
- Google Sign-In and One Tap require configuration in Google Console.
- MediaPipe native libs and models (gesture) must be added manually.
- To run the project via CLI: `./gradlew assembleDebug` (on Windows use the gradlew.bat script).


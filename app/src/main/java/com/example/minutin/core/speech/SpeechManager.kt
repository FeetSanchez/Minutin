package com.example.minutin.core.speech

import android.content.Context
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import java.util.Locale

class SpeechManager(private val context: Context) {

    // Initialize TextToSpeech lazily to avoid initialization-time issues
    private var tts: TextToSpeech? = null

    private fun ensureTtsInitialized() {
        if (tts == null) {
            tts = TextToSpeech(context) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    tts?.language = Locale.getDefault()
                }
            }
        }
    }

    /**
     * Text-to-Speech
     */
    fun speak(text: String) {
        ensureTtsInitialized()
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "minutin_tts")
    }

    fun stopSpeaking() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.shutdown()
        tts = null
    }

    /**
     * Speech-to-Text
     */
    fun createSpeechRecognizer(): SpeechRecognizer {
        return SpeechRecognizer.createSpeechRecognizer(context)
    }
}

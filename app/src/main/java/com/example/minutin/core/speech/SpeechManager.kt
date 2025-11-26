package com.example.minutin.core.speech
}
    fun shutdown() { tts.shutdown() }

    }
        return SpeechRecognizer.createSpeechRecognizer(context)
    fun createSpeechRecognizer(): SpeechRecognizer {

    fun stopSpeaking() { tts.stop() }

    }
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "minutin_tts")
    fun speak(text: String) {

    }
        }
            tts.language = Locale.getDefault()
        if (status == TextToSpeech.SUCCESS) {
    private val tts: TextToSpeech = TextToSpeech(context) { status ->
class SpeechManager(private val context: Context) {

import java.util.Locale
import android.speech.tts.TextToSpeech
import android.speech.SpeechRecognizer
import android.content.Context



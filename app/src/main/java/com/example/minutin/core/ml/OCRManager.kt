package com.example.minutin.core.ml

import com.google.mlkit.vision.common.InputImage
import android.content.Context

class OCRManager(private val context: Context) {

    suspend fun processImage(image: InputImage): String {
        // ML Kit is optional for documentation mode. Return a safe fallback text so
        // UI and pipelines can continue without requiring ML model files.
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    }
}

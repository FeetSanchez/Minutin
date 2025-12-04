package com.example.minutin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MinutinApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Global initializations (Telemetry, model loaders) can be added here.
    }
}

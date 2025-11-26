package com.example.minutin.domain.usecase

import com.example.minutin.core.analytics.TelemetryManager
import javax.inject.Inject

class TrackStudySessionUseCase @Inject constructor(private val telemetry: TelemetryManager) {
    suspend operator fun invoke(subject: String, minutes: Int) {
        telemetry.trackStudySession(subject, minutes)
    }
}


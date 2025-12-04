package com.example.minutin.core.analytics

import com.example.minutin.data.local.dao.AnalyticsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Lightweight telemetry manager used for local analytics.
 * This implementation uses Room's AnalyticsDao and provides simple helpers.
 */
class TelemetryManager(private val analyticsDao: AnalyticsDao) {

    suspend fun getWeeklyMinutes(): Int = withContext(Dispatchers.IO) {
        analyticsDao.getTotalMinutesForWeek()
    }

    suspend fun trackStudySession(subject: String, minutes: Int) = withContext(Dispatchers.IO) {
        analyticsDao.insertSession(com.example.minutin.data.local.model.StudySession(subject = subject, durationMinutes = minutes))
    }
}


package com.example.minutin.core.analytics

import com.example.minutin.data.local.dao.AnalyticsDao
import com.example.minutin.data.local.model.StudySession

class TelemetryManager(private val analyticsDao: AnalyticsDao) {
    suspend fun trackStudySession(subject: String, minutes: Int) {
        val session = StudySession(subject = subject, durationMinutes = minutes)
        analyticsDao.insertSession(session)
    }

    suspend fun getWeeklyMinutes(): Int {
        return analyticsDao.getTotalMinutesForWeek()
    }
}


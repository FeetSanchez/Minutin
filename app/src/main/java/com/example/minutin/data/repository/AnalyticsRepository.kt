package com.example.minutin.data.repository

import com.example.minutin.data.local.model.StudySession

interface AnalyticsRepository {
    suspend fun insertSession(session: StudySession)
    suspend fun getWeeklyMinutes(): Int
}


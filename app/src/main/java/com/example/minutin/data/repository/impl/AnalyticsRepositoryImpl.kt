package com.example.minutin.data.repository.impl

import com.example.minutin.data.local.db.MinutinDatabase
import com.example.minutin.data.local.model.StudySession
import com.example.minutin.data.repository.AnalyticsRepository

class AnalyticsRepositoryImpl(private val db: MinutinDatabase) : AnalyticsRepository {
    override suspend fun insertSession(session: StudySession) {
        db.analyticsDao().insertSession(session)
    }
    override suspend fun getWeeklyMinutes(): Int {
        return db.analyticsDao().getTotalMinutesForWeek()
    }
}


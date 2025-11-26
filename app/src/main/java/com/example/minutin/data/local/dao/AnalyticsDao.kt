package com.example.minutin.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.minutin.data.local.model.StudySession

@Dao
interface AnalyticsDao {
    @Insert
    suspend fun insertSession(session: StudySession)

    @Query("SELECT IFNULL(SUM(durationMinutes), 0) FROM StudySession WHERE timestamp >= :since")
    suspend fun getTotalMinutesSince(since: Long): Int

    // helper for weekly summary (simple)
    suspend fun getTotalMinutesForWeek(): Int {
        val weekStart = System.currentTimeMillis() - 7L * 24 * 3600 * 1000
        return getTotalMinutesSince(weekStart)
    }
}


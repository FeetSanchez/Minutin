package com.example.minutin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.minutin.data.local.dao.AnalyticsDao
import com.example.minutin.data.local.dao.FlashcardDao
import com.example.minutin.data.local.model.StudySession
import com.example.minutin.data.local.model.Flashcard

@Database(entities = [StudySession::class, Flashcard::class], version = 1, exportSchema = false)
abstract class MinutinDatabase : RoomDatabase() {
    abstract fun analyticsDao(): AnalyticsDao
    abstract fun flashcardDao(): FlashcardDao
}


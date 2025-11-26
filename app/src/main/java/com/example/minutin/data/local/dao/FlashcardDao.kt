package com.example.minutin.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.minutin.data.local.model.Flashcard

@Dao
interface FlashcardDao {
    @Insert
    suspend fun insert(flashcard: Flashcard)

    @Query("SELECT * FROM Flashcard")
    suspend fun getAll(): List<Flashcard>
}


package com.example.minutin.di

import android.content.Context
import androidx.room.Room
import com.example.minutin.data.local.db.MinutinDatabase
import com.example.minutin.data.local.dao.FlashcardDao
import com.example.minutin.core.prefs.UserPrefsManager
import com.example.minutin.core.speech.SpeechManager
import com.example.minutin.core.ml.OCRManager
import com.example.minutin.core.flashcards.FlashcardGenerator
import com.example.minutin.core.analytics.TelemetryManager
import com.example.minutin.data.repository.AnalyticsRepository
import com.example.minutin.data.repository.FlashcardRepository
import com.example.minutin.data.repository.impl.AnalyticsRepositoryImpl
import com.example.minutin.data.repository.impl.FlashcardRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext ctx: Context): MinutinDatabase {
        return Room.databaseBuilder(ctx, MinutinDatabase::class.java, "minutin.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserPrefs(@ApplicationContext ctx: Context): UserPrefsManager = UserPrefsManager(ctx)

    @Provides
    @Singleton
    fun provideSpeechManager(@ApplicationContext ctx: Context) = SpeechManager(ctx)

    @Provides
    @Singleton
    fun provideOCRManager(@ApplicationContext ctx: Context) = OCRManager(ctx)

    @Provides
    @Singleton
    fun provideLLMService(): com.example.minutin.llm.LLMApiService = com.example.minutin.llm.LLMApiServiceImpl()

    @Provides
    @Singleton
    fun provideFlashcardGenerator(ocr: OCRManager, llm: com.example.minutin.llm.LLMApiService) = FlashcardGenerator(ocr, llm)

    @Provides
    @Singleton
    fun provideTelemetryManager(db: MinutinDatabase) = TelemetryManager(db.analyticsDao())

    @Provides
    @Singleton
    fun provideAnalyticsRepository(db: MinutinDatabase): AnalyticsRepository = AnalyticsRepositoryImpl(db)

    @Provides
    @Singleton
    fun provideFlashcardRepository(db: MinutinDatabase): FlashcardRepository = FlashcardRepositoryImpl(db)

    // Provide FlashcardDao directly for convenience (used by some components)
    @Provides
    @Singleton
    fun provideFlashcardDao(db: MinutinDatabase): FlashcardDao = db.flashcardDao()
}

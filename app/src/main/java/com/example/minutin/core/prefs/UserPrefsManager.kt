package com.example.minutin.core.prefs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPrefsManager(context: Context) {
    private val dataStore: DataStore<Preferences> = PreferenceDataStoreFactory.create { context.preferencesDataStoreFile("user_prefs") }

    companion object {
        val KEY_ONBOARDED = booleanPreferencesKey("onboarded")
        val KEY_USERNAME = stringPreferencesKey("username")
        val KEY_MOOD = stringPreferencesKey("mood")
    }

    val isOnboarded: Flow<Boolean> = dataStore.data.map { it[KEY_ONBOARDED] ?: false }
    val username: Flow<String> = dataStore.data.map { it[KEY_USERNAME] ?: "Usuário" }
    val mood: Flow<String> = dataStore.data.map { it[KEY_MOOD] ?: "Neutral" }

    suspend fun setOnboarded(value: Boolean) {
        dataStore.edit { prefs -> prefs[KEY_ONBOARDED] = value }
    }

    suspend fun setUsername(name: String) {
        dataStore.edit { prefs -> prefs[KEY_USERNAME] = name }
    }

    suspend fun setMood(mood: String) {
        dataStore.edit { prefs -> prefs[KEY_MOOD] = mood }
    }
}

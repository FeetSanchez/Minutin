package com.example.minutin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minutin.core.analytics.TelemetryManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val telemetry: TelemetryManager) : ViewModel() {
    private val _weeklyMinutes = MutableStateFlow(0)
    val weeklyMinutes: StateFlow<Int> = _weeklyMinutes.asStateFlow()

    init {
        // Load initial telemetry safely
        viewModelScope.launch {
            try {
                val minutes = telemetry.getWeeklyMinutes()
                _weeklyMinutes.value = minutes
            } catch (e: Exception) {
                // swallow for now; in real app log or expose error state
                _weeklyMinutes.value = 0
            }
        }
    }
}

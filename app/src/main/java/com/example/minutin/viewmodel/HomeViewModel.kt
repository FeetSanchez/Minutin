package com.example.minutin.viewmodel
}
    }
        }
            _weeklyMinutes.value = telemetry.getWeeklyMinutes()
        viewModelScope.launch {
    init {

    val weeklyMinutes: StateFlow<Int> = _weeklyMinutes.asStateFlow()
    private val _weeklyMinutes = MutableStateFlow(0)
class HomeViewModel @Inject constructor(private val telemetry: TelemetryManager) : ViewModel() {
@HiltViewModel

import javax.inject.Inject
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.minutin.core.analytics.TelemetryManager
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel



package com.example.minutin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minutin.domain.usecase.CalculateAvailableGapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OnboardingUiState(val busySchedule: String = "", val gaps: List<String> = emptyList(), val loading: Boolean = false)

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val calculateGaps: CalculateAvailableGapsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun saveBusySchedule(text: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }
            val gaps = calculateGaps.invoke(text)
            _uiState.update { it.copy(busySchedule = text, gaps = gaps, loading = false) }
            // persist via UserPrefsManager (injected in real impl)
        }
    }
}


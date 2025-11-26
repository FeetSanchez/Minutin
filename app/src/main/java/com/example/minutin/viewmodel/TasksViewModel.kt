package com.example.minutin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minutin.core.prefs.UserPrefsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(private val prefs: UserPrefsManager) : ViewModel() {
    private val _mappedSubjects = MutableStateFlow<List<String>>(emptyList())
    val mappedSubjects: StateFlow<List<String>> = _mappedSubjects.asStateFlow()

    fun saveSubjects(subjects: List<String>) {
        _mappedSubjects.value = subjects
        // Persist to DB or prefs as needed
    }
}


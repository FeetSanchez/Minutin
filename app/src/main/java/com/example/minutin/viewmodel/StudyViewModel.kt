package com.example.minutin.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StudyViewModel @Inject constructor() : ViewModel() {
    private val _chatMessages = MutableStateFlow<List<String>>(emptyList())
    val chatMessages: StateFlow<List<String>> = _chatMessages.asStateFlow()

    fun sendMessage(msg: String) {
        _chatMessages.value = _chatMessages.value + msg
        // Should call Chatbot usecase to get reply
    }
}


package com.example.minutin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minutin.data.remote.llm.LLMApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatbotViewModel @Inject constructor(private val llm: LLMApiService) : ViewModel() {
    private val _messages = MutableStateFlow<List<String>>(emptyList())
    val messages: StateFlow<List<String>> = _messages.asStateFlow()

    fun sendUserMessage(msg: String) {
        _messages.value = _messages.value + "You: $msg"
        viewModelScope.launch {
            val reply = llm.generateText(msg)
            _messages.value = _messages.value + "Bot: $reply"
        }
    }
}


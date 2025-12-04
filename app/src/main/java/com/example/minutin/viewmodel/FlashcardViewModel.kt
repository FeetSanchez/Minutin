package com.example.minutin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minutin.data.local.model.Flashcard
import com.example.minutin.data.repository.FlashcardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashcardViewModel @Inject constructor(
    private val repo: FlashcardRepository
) : ViewModel() {

    val flashcards = MutableStateFlow<List<Flashcard>>(emptyList())

    init {
        viewModelScope.launch {
            repo.getAll().collect { flashcards.value = it }
        }
    }

    fun insertMock() {
        viewModelScope.launch {
            repo.insertMockData()
        }
    }
}


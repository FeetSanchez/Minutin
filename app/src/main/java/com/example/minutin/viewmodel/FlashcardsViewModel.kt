package com.example.minutin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minutin.data.repository.FlashcardRepository
import com.example.minutin.data.local.model.Flashcard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashcardsViewModel @Inject constructor(private val repo: FlashcardRepository) : ViewModel() {
    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> = _flashcards.asStateFlow()

    fun loadFlashcards() {
        viewModelScope.launch {
            // Collect the Flow returned by the repository and update StateFlow
            repo.getAll().collect { list ->
                _flashcards.value = list
            }
        }
    }

    fun addFlashcard(flashcard: Flashcard) {
        viewModelScope.launch {
            repo.insert(flashcard)
            loadFlashcards()
        }
    }
}

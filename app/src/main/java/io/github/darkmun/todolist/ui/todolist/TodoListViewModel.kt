package io.github.darkmun.todolist.ui.todolist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TodoListUiState())
    val uiState = _uiState.asStateFlow()
}
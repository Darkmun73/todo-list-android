package io.github.darkmun.todolist.ui.todolist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TodoListUiState())
    val uiState = _uiState.asStateFlow()

    fun selectList(listType: TodoListType) {
        _uiState.update { current ->
            current.copy (
                selectedList = listType
            )
        }
    }
}
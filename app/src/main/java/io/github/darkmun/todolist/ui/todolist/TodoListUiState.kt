package io.github.darkmun.todolist.ui.todolist

enum class TodoListType {
    ALL,
    NEW,
    IN_PROGRESS,
    DONE
}

data class TodoListUiState(var selectedList: TodoListType = TodoListType.ALL)
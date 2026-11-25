package io.github.darkmun.todolist.ui.todolist

enum class TodoListType(val label: String) {
    ALL("Все"),
    NEW("Новые"),
    IN_PROGRESS("В работе"),
    DONE("Готово")
}

data class TodoListUiState(var selectedList: TodoListType = TodoListType.ALL)
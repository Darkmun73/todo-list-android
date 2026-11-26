package io.github.darkmun.todolist.ui.todolist

import androidx.annotation.StringRes
import io.github.darkmun.todolist.R

enum class TodoListType {
    ALL,
    NEW,
    IN_PROGRESS,
    DONE
}

@StringRes
fun TodoListType.getLabelResourceId(): Int = when (this) {
    TodoListType.ALL -> R.string.all_tab
    TodoListType.NEW -> R.string.new_tab
    TodoListType.IN_PROGRESS -> R.string.in_progress_tab
    TodoListType.DONE -> R.string.done_tab
}
package io.github.darkmun.todolist.ui.todolist

import io.github.darkmun.todolist.domain.model.TaskStatus

data class TaskUiState(
    val status: TaskStatus,
    val shortDescription: String,
    val dateTime: String
)
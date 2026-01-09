package com.butterchickenstudios.todo.presentation.screen.todo.action

import com.butterchickenstudios.todo.domain.model.Todo

sealed interface TodoAction {
    data class AddTodo(val todo: Todo) : TodoAction
    data class OnToggleTodo(val id: Int, val isCompleted: Boolean) : TodoAction
}
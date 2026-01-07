package com.butterchickenstudios.todo.domain.usecase

import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.domain.repository.TodoRepository
import javax.inject.Inject

class AddTodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) {
        repository.insertTodo(todo)
    }
}
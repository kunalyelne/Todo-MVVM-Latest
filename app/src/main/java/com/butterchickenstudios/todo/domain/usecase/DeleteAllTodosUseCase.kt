package com.butterchickenstudios.todo.domain.usecase

import com.butterchickenstudios.todo.domain.repository.TodoRepository
import javax.inject.Inject

class DeleteAllTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke() {
        repository.deleteAllTodos()
    }
}
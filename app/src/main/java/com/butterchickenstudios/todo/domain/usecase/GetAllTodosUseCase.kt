package com.butterchickenstudios.todo.domain.usecase

import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<Todo>> =
        repository.getAllTodos()
}
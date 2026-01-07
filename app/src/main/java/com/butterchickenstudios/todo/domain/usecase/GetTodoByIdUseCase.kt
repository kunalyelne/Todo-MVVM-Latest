package com.butterchickenstudios.todo.domain.usecase

import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodoByIdUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(id: Int): Flow<Todo?> =
        repository.getTodoById(id)
}
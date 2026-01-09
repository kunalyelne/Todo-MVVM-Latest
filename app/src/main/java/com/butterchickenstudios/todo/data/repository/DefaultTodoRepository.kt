package com.butterchickenstudios.todo.data.repository

import com.butterchickenstudios.todo.data.local.dao.TodoDao
import com.butterchickenstudios.todo.data.mappers.toDomain
import com.butterchickenstudios.todo.data.mappers.toEntity
import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultTodoRepository @Inject constructor(
    private val dao: TodoDao
) : TodoRepository  {
    override fun getAllTodos(): Flow<List<Todo>> =
        dao.getAllTodos().map { list -> list.map { it.toDomain() } }

    override fun getTodoById(id: Int): Flow<Todo?> =
        dao.getTodoByIdFlow(id).map { it?.toDomain() }

    override fun getCompletedTodos(): Flow<List<Todo>> =
        dao.getCompletedTodos().map { list -> list.map { it.toDomain() } }

    override fun getPendingTodos(): Flow<List<Todo>> =
        dao.getPendingTodos().map { list -> list.map { it.toDomain() } }

    override suspend fun insertTodo(todo: Todo): Long =
        dao.insertTodo(todo.toEntity())

    override suspend fun updateTodo(todo: Todo) =
        dao.updateTodo(todo.toEntity())

    override suspend fun updateTodoCompletionById(id: Int, isCompleted: Boolean) {
        dao.updateTodoCompletionById(id, isCompleted)
    }

    override suspend fun deleteTodo(todo: Todo) =
        dao.deleteTodo(todo.toEntity())

    override suspend fun deleteCompletedTodos() =
        dao.deleteCompletedTodos()

    override suspend fun deleteAllTodos() =
        dao.deleteAllTodos()
}
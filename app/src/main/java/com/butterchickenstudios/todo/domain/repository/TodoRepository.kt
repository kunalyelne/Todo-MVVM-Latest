package com.butterchickenstudios.todo.domain.repository

import com.butterchickenstudios.todo.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getAllTodos(): Flow<List<Todo>>

    fun getTodoById(id: Int): Flow<Todo?>

    fun getCompletedTodos(): Flow<List<Todo>>

    fun getPendingTodos(): Flow<List<Todo>>

    suspend fun insertTodo(todo: Todo): Long

    suspend fun updateTodo(todo: Todo)

    suspend fun updateTodoCompletionById(id: Int, isCompleted: Boolean)

    suspend fun deleteTodo(todo: Todo)

    suspend fun deleteCompletedTodos()

    suspend fun deleteAllTodos()
}
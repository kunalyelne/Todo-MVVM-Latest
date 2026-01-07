package com.butterchickenstudios.todo.data.mappers

import com.butterchickenstudios.todo.data.local.entity.TodoEntity
import com.butterchickenstudios.todo.domain.model.Todo

/**
 * Maps a [TodoEntity] data object to a [Todo] domain model.
 *
 * This extension function converts the database representation of a Todo item
 * into the domain model used by the UI and business logic layers.
 * It handles the conversion of the priority string to the corresponding [Todo.Priority] enum.
 *
 * @return A [Todo] object containing the data from this entity.
 */
fun TodoEntity.toDomain() = Todo(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted,
    createdAt = createdAt,
    priority = Todo.Priority.valueOf(priority)
)

/**
 * Extension function to map the [Todo] domain model to a [TodoEntity].
 *
 * This function converts the domain representation of a todo item into its
 * corresponding entity format suitable for database storage. It handles the
 * conversion of complex types, such as mapping the [Todo.Priority] enum to its string name.
 *
 * @return A [TodoEntity] populated with data from this [Todo] instance.
 */
fun Todo.toEntity() = TodoEntity(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted,
    createdAt = createdAt,
    priority = priority.name
)
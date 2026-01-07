package com.butterchickenstudios.todo.domain.model

/**
 * Domain entity representing a Todo item.
 */
data class Todo(
    val id: Int = 0,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val priority: Priority = Priority.MEDIUM
) {
    /**
     * Priority levels for todos
     */
    enum class Priority {
        LOW,
        MEDIUM,
        HIGH
    }
}

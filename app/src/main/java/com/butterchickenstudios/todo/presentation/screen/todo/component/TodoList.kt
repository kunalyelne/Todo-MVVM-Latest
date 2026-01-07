package com.butterchickenstudios.todo.presentation.screen.todo.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.butterchickenstudios.todo.domain.model.Todo

@Composable
fun TodoList(
    todos: List<Todo>,
    onToggle: (Todo) -> Unit,
    onTodoClick: (Int) -> Unit
) {
    LazyColumn {
        items(todos) { todo ->
            TodoItem(
                todo = todo,
                onToggle = onToggle,
                onClick = onTodoClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoListPreview() {
    TodoList(
        todos = listOf(
            Todo(id = 1, title = "Todo 1", description = "Halo android", isCompleted = true),
            Todo(id = 2, title = "Todo 2", isCompleted = false),
            Todo(id = 3, title = "Todo 3", isCompleted = false)
        ),
        onToggle = {},
        onTodoClick = {}
    )
}
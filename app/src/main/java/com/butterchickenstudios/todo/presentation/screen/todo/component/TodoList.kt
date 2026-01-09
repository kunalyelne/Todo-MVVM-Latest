package com.butterchickenstudios.todo.presentation.screen.todo.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.presentation.navigation.event.NavigationEvent
import com.butterchickenstudios.todo.presentation.screen.todo.action.TodoAction

@Composable
fun TodoList(
    todos: List<Todo>,
    onAction: (TodoAction) -> Unit,
    onNavigationEvent: (NavigationEvent) -> Unit
) {
    LazyColumn {
        items(todos) { todo ->
            TodoItem(
                todo = todo,
                onAction = onAction,
                onNavigationEvent = onNavigationEvent
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
        onAction = {},
        onNavigationEvent = {}
    )
}
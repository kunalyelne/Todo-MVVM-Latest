package com.butterchickenstudios.todo.presentation.screen.todo.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.presentation.navigation.event.NavigationEvent
import com.butterchickenstudios.todo.presentation.navigation.screen.Screen
import com.butterchickenstudios.todo.presentation.screen.todo.action.TodoAction

@Composable
fun TodoItem(
    todo: Todo,
    onAction: (TodoAction) -> Unit,
    onNavigationEvent: (NavigationEvent) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onNavigationEvent(NavigationEvent.OnNavigateToScreen(Screen.TodoDetails(todo.id))) }
            .padding(8.dp)
    ) {
        Checkbox(
            checked = todo.isCompleted,
            onCheckedChange = { onAction(TodoAction.OnToggleTodo(todo.id, !todo.isCompleted)) },
            modifier = Modifier.padding(top = 1.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(todo.title)
    }
}


@Preview(showBackground = true)
@Composable
fun TodoItemPreview() {
    TodoItem(
        todo = Todo(id = 1, title = "Todo 1", description = "Halo android", isCompleted = true),
        onAction = {},
        onNavigationEvent = {}
    )
}
package com.butterchickenstudios.todo.presentation.screen.todo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.butterchickenstudios.todo.core.ui.util.UiState
import com.butterchickenstudios.todo.core.ui.components.LoadingIndicator
import com.butterchickenstudios.todo.presentation.navigation.event.NavigationEvent
import com.butterchickenstudios.todo.presentation.navigation.screen.Screen
import com.butterchickenstudios.todo.presentation.screen.todo.component.AddTodoBottomSheet
import com.butterchickenstudios.todo.presentation.screen.todo.component.TodoList

@Composable
fun TodoScreen(
    onNavigationEvent: (NavigationEvent) -> Unit,
    viewModel: TodoViewModel = hiltViewModel()
) {
    val state by viewModel.todosState.collectAsStateWithLifecycle()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showBottomSheet = true }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Todo")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            when (val state = state) {
                is UiState.Loading -> {
                    LoadingIndicator()
                }
                is UiState.Success -> {
                    TodoList(
                        todos = state.data,
                        onAction = viewModel::onAction,
                        onNavigationEvent = onNavigationEvent
                    )
                }
                is UiState.Error -> {
                    Text(
                        state.message
                    )
                }
            }
        }

        if (showBottomSheet) {
            AddTodoBottomSheet(
                onDismiss = { showBottomSheet = false },
                onSave = { todo ->
                    viewModel.addTodo(todo)
                    showBottomSheet = false
                }
            )
        }
    }
}
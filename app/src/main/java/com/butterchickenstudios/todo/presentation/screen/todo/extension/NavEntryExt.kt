package com.butterchickenstudios.todo.presentation.screen.todo.extension

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import com.butterchickenstudios.todo.presentation.navigation.NavigationViewModel
import com.butterchickenstudios.todo.presentation.navigation.event.NavigationEvent
import com.butterchickenstudios.todo.presentation.navigation.screen.Screen
import com.butterchickenstudios.todo.presentation.screen.todo.TodoScreen

@Composable
fun EntryProviderScope<Screen>.TodoEntry(
    onNavigationEvent: (NavigationEvent) -> Unit
) {
    entry<Screen.Todo> {
        TodoScreen(onNavigationEvent)
    }
}
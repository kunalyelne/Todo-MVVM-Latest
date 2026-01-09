package com.butterchickenstudios.todo.presentation.screen.details.extension

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.butterchickenstudios.todo.presentation.navigation.event.NavigationEvent
import com.butterchickenstudios.todo.presentation.navigation.screen.Screen
import com.butterchickenstudios.todo.presentation.screen.details.DetailsScreen

@Composable
fun EntryProviderScope<Screen>.TodoDetailsEntry(
    onNavigationEvent: (NavigationEvent) -> Unit
) {
    entry<Screen.TodoDetails> {
        DetailsScreen(
            key = it,
            onNavigationEvent = onNavigationEvent
        )
    }
}
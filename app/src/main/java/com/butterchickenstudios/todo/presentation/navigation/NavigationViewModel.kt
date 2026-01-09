package com.butterchickenstudios.todo.presentation.navigation

import androidx.compose.runtime.mutableStateListOf
import com.butterchickenstudios.todo.core.base.BaseViewModel
import com.butterchickenstudios.todo.presentation.navigation.event.NavigationEvent
import com.butterchickenstudios.todo.presentation.navigation.screen.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(

): BaseViewModel() {
    val backStack = mutableStateListOf<Screen>(Screen.Todo)
    fun onEvent(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.OnBack -> {
                backStack.removeLastOrNull()
            }
            is NavigationEvent.OnNavigateToScreen -> {
                backStack.add(event.screen)
            }
        }
    }
}
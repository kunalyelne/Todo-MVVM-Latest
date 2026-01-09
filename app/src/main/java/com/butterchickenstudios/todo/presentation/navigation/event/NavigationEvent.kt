package com.butterchickenstudios.todo.presentation.navigation.event

import com.butterchickenstudios.todo.presentation.navigation.screen.Screen

sealed interface NavigationEvent {
    data object OnBack : NavigationEvent
    data class OnNavigateToScreen(val screen: Screen) : NavigationEvent
}
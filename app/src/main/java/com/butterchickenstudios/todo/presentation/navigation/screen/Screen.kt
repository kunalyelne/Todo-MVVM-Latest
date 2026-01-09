package com.butterchickenstudios.todo.presentation.navigation.screen

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen: NavKey {
    @Serializable
    data object Todo: Screen, NavKey

    @Serializable
    data class TodoDetails(val id: Int): Screen
}
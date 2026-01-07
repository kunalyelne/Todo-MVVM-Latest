package com.butterchickenstudios.todo.core.ui.util

sealed interface UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent
}
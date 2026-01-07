package com.butterchickenstudios.todo.presentation.navigation

sealed class NavRoute(val route: String) {
    object Todo : NavRoute("todo")
    object Details : NavRoute("details/{todoId}") {
        fun create(todoId: Int) = "details/$todoId"
    }
}
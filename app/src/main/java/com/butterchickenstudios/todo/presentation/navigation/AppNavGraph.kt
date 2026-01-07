package com.butterchickenstudios.todo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.butterchickenstudios.todo.presentation.screen.details.DetailsScreen
import com.butterchickenstudios.todo.presentation.screen.todo.TodoScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Todo.route,
        modifier = modifier
    ) {
        composable(NavRoute.Todo.route) {
            TodoScreen(
                onTodoClick = { todoId ->
                    navController.navigate(NavRoute.Details.create(todoId))
                }
            )
        }

        composable(
            route = NavRoute.Details.route,
            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
        ) {
            DetailsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
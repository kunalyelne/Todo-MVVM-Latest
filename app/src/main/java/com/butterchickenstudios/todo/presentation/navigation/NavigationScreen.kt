package com.butterchickenstudios.todo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.butterchickenstudios.todo.presentation.screen.details.extension.TodoDetailsEntry
import com.butterchickenstudios.todo.presentation.screen.todo.extension.TodoEntry

@Composable
fun RootContainer(
    modifier: Modifier = Modifier,
    viewModel: NavigationViewModel = hiltViewModel()
) {
    NavDisplay(
        backStack = viewModel.backStack,
        onBack = { viewModel.backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            // Scope the ViewModel to NavKey's entry in backstack rather than to the Activity's Scope
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            TodoEntry(viewModel::onEvent)
            TodoDetailsEntry(viewModel::onEvent)
        }
    )
}
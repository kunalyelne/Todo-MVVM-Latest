package com.butterchickenstudios.todo.presentation.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.butterchickenstudios.todo.core.base.BaseViewModel
import com.butterchickenstudios.todo.core.dispatcher.DispatcherProvider
import com.butterchickenstudios.todo.core.extension.collectLatestIn
import com.butterchickenstudios.todo.core.ui.util.UiState
import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.domain.usecase.GetTodoByIdUseCase
import com.butterchickenstudios.todo.domain.usecase.ToggleTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getTodoByIdUseCase: GetTodoByIdUseCase,
    private val toggleTodo: ToggleTodoUseCase,
    private val dispatchers: DispatcherProvider
) : BaseViewModel() {
    private val _todosState = MutableStateFlow<UiState<Todo>>(UiState.Loading)
    val todosState: StateFlow<UiState<Todo>> = _todosState.asStateFlow()

    private val todoId: Int? = savedStateHandle["todoId"]

    init {
        if (todoId != null) {
            observeTodo(todoId)
        } else {
            _todosState.value = UiState.Error("Invalid Todo ID")
        }
    }

    private fun observeTodo(todoId: Int) {
        getTodoByIdUseCase(todoId)
            .flowOn(dispatchers.io)
            .onStart {
                _todosState.value = UiState.Loading
            }
            .catch { throwable ->
                _todosState.value =
                    UiState.Error(throwable.message ?: "Something went wrong")
            }
            .collectLatestIn(viewModelScope) { todo ->
                if (todo == null) {
                    _todosState.value = UiState.Error("Todo not found")
                } else {
                    _todosState.value = UiState.Success(todo)
                }
            }
    }

    fun onToggleTodo(todo: Todo) {
        viewModelScope.launch(dispatchers.io) {
            toggleTodo.invoke(todo)
        }
    }
}

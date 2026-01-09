package com.butterchickenstudios.todo.presentation.screen.todo

import androidx.lifecycle.viewModelScope
import com.butterchickenstudios.todo.core.base.BaseViewModel
import com.butterchickenstudios.todo.core.dispatcher.DispatcherProvider
import com.butterchickenstudios.todo.core.extension.collectLatestIn
import com.butterchickenstudios.todo.core.ui.util.UiState
import com.butterchickenstudios.todo.domain.model.Todo
import com.butterchickenstudios.todo.domain.usecase.AddTodoUseCase
import com.butterchickenstudios.todo.domain.usecase.GetAllTodosUseCase
import com.butterchickenstudios.todo.domain.usecase.ToggleTodoUseCase
import com.butterchickenstudios.todo.presentation.screen.todo.action.TodoAction
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
class TodoViewModel @Inject constructor (
    private val getAllTodos: GetAllTodosUseCase,
    private val addTodo: AddTodoUseCase,
    private val toggleTodo: ToggleTodoUseCase,
    private val dispatchers: DispatcherProvider
) : BaseViewModel() {

    private val _todosState = MutableStateFlow<UiState<List<Todo>>>(UiState.Loading)
    val todosState: StateFlow<UiState<List<Todo>>> = _todosState.asStateFlow()

    init {
        observeTodos()
    }

    private fun observeTodos() {
        getAllTodos()
            .flowOn(dispatchers.io)
            .onStart {
                _todosState.value = UiState.Loading
            }
            .catch { throwable ->
                _todosState.value =
                    UiState.Error(throwable.message ?: "Something went wrong")
            }
            .collectLatestIn(viewModelScope) { todos ->
                _todosState.value = UiState.Success(todos)
            }
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch(dispatchers.io) {
            addTodo.invoke(todo)
        }
    }

    fun toggleTodo(id: Int, isCompleted: Boolean) {
        viewModelScope.launch(dispatchers.io) {
            toggleTodo.invoke(id, isCompleted)
        }
    }

    fun onAction(action: TodoAction) {
        when (action) {
            is TodoAction.AddTodo -> addTodo(action.todo)
            is TodoAction.OnToggleTodo -> toggleTodo(action.id, action.isCompleted)
        }
    }
}
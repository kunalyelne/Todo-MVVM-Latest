package com.butterchickenstudios.todo.core.extension

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T> Flow<T>.collectLatestIn(
    scope: CoroutineScope,
    block: suspend (T) -> Unit
) = scope.launch {
    collectLatest(block)
}
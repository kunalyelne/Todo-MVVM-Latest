package com.butterchickenstudios.todo.core.di

import com.butterchickenstudios.todo.data.repository.DefaultTodoRepository
import com.butterchickenstudios.todo.domain.repository.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTodoRepository(
        impl: DefaultTodoRepository
    ): TodoRepository
}



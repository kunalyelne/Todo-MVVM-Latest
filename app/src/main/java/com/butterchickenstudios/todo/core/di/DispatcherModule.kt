package com.butterchickenstudios.todo.core.di

import com.butterchickenstudios.todo.core.dispatcher.DefaultDispatcherProvider
import com.butterchickenstudios.todo.core.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }
}

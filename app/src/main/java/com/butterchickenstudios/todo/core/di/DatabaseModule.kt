package com.butterchickenstudios.todo.core.di

import android.content.Context
import androidx.room.Room
import com.butterchickenstudios.todo.data.local.dao.TodoDao
import com.butterchickenstudios.todo.data.local.database.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TodoDatabase =
        Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo.db"
        ).build()

    @Provides
    fun provideTodoDao(db: TodoDatabase): TodoDao =
        db.todoDao()
}
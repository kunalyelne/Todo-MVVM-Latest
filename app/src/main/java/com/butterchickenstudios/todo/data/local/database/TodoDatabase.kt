package com.butterchickenstudios.todo.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.butterchickenstudios.todo.data.local.dao.TodoDao
import com.butterchickenstudios.todo.data.local.entity.TodoEntity


@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
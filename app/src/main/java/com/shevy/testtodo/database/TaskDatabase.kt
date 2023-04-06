package com.shevy.testtodo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao

    companion object {
        @Volatile
        private var database: TaskDatabase? = null

        @Synchronized
        fun getInstance(context: Context): TaskDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, TaskDatabase::class.java, "db")
                    .fallbackToDestructiveMigration()
                    .build()
                database as TaskDatabase
            } else {
                database as TaskDatabase
            }
        }
    }
}
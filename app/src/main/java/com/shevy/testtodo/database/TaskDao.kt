package com.shevy.testtodo.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTasks(taskEntity: TaskEntity)

    @Delete
    suspend fun delete(taskEntity: TaskEntity)

    @Update
    suspend fun update(taskEntity: TaskEntity)

    @Query("DELETE FROM task_database")
    suspend fun deleteAll()

    @Query("SELECT * FROM task_database ORDER BY timestamp DESC")
    suspend fun getAllTasks(): LiveData<List<TaskEntity>>
}
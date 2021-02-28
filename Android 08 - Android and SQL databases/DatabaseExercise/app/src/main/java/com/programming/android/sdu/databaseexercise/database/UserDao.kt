package com.programming.android.sdu.databaseexercise.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */
@Dao
interface UserDao {
    @get:Query("SELECT * FROM user where uid = 1")
    val user: User?

    @Update
    fun update(user: User?): Int

    @Insert
    fun insert(user: User?)

    @Query("SELECT COUNT(*) from user")
    fun countUsers(): Int
}
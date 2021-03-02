package com.programming.android.sdu.databaseexercise.repositories

import android.content.Context
import androidx.room.Room
import com.programming.android.sdu.databaseexercise.database.AppDatabase
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.database.UserDao

// Pass the UserDao only, as we do not need to access the whole database
class UserRepository(private val userDao: UserDao) {

    fun getUser(): User {
        return userDao.getUser()
    }

    fun insert(user: User) {
        userDao.insert(user)
    }

    fun count(): Int {
        return userDao.countUsers()
    }

    fun update(user: User) {
        userDao.update(user)
    }

}
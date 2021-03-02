package com.programming.android.sdu.databaseexercise

import android.app.Application
import com.programming.android.sdu.databaseexercise.database.AppDatabase
import com.programming.android.sdu.databaseexercise.repositories.UserRepository

class UserApplication : Application() {

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getAppDatabase(this) }
    val repository by lazy { UserRepository(database!!.userDao()) }

}
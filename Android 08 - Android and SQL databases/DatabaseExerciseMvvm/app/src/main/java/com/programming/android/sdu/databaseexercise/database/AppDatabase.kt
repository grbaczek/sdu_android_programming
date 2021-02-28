package com.programming.android.sdu.databaseexercise.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        // Singleton to prevent multiple instances from existing
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "user-database") // allow queries on the main thread.
                        // Don't do this on a real app!
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }
}
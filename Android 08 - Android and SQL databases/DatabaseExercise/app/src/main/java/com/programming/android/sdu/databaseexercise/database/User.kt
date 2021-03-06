package com.programming.android.sdu.databaseexercise.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */
@Entity(tableName = "user")
data class User (
    @PrimaryKey
    val uid: Int,
    val name: String,
    val address: String,
    val dateOfBirth: Long = 0
)
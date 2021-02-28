package com.programming.android.sdu.databaseexercise.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */
@Entity(tableName = "user")
class User {
    @PrimaryKey
    var uid = 0
    var name: String? = null
    var address: String? = null
    var dateOfBirth: Long = 0
}
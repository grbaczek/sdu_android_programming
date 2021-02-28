package com.programming.android.sdu.databaseexercise.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */
@Entity(tableName = "user")
class User {
    @JvmField
    @PrimaryKey
    var uid = 0
    @JvmField
    var name: String? = null
    @JvmField
    var address: String? = null
    @JvmField
    var dateOfBirth: Long = 0
}
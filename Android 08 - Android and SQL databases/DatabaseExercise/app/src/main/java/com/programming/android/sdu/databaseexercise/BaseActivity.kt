package com.programming.android.sdu.databaseexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.programming.android.sdu.databaseexercise.database.AppDatabase
import com.programming.android.sdu.databaseexercise.database.User

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */
open class BaseActivity : AppCompatActivity() {

    protected lateinit var db: AppDatabase
    protected lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AppDatabase.getAppDatabase(this)!!
        if (db.userDao().countUsers() == 0) {
            currentUser = User()
            currentUser.uid = 1
            currentUser.address = ""
            currentUser.dateOfBirth = 0
            currentUser.name = ""
            db.userDao().insert(currentUser)
        } else {
            currentUser = db.userDao().user!!
        }
    }

}
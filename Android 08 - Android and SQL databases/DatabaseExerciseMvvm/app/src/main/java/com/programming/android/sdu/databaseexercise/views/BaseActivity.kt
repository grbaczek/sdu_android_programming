package com.programming.android.sdu.databaseexercise.views

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.programming.android.sdu.databaseexercise.UserApplication
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.viewmodels.UserViewModel

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */
open class BaseActivity : AppCompatActivity() {

    protected val userViewModel: UserViewModel by viewModels()

    //protected var db: AppDatabase? = null
    protected var currentUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


     //  val db = AppDatabase.getAppDatabase(this)
   //     val repository = UserRepository(db!!.userDao())
   //     userViewModel.repository = repository

        userViewModel.repository = (application as UserApplication).repository

        if (userViewModel.count() == 0) {
            Log.i("BaseActivity", "ViewModel count = 0")
            currentUser = User()
            currentUser!!.uid = 1
            currentUser!!.address = ""
            currentUser!!.dateOfBirth = 0
            currentUser!!.name = ""
            userViewModel.insert(currentUser!!)
        } else {
            Log.i("BaseActivity", "ViewModel != 0")
            currentUser = userViewModel.getUser()
        }

    }

}
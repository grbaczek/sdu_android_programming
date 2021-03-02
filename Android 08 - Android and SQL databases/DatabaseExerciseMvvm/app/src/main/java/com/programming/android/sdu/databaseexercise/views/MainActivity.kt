package com.programming.android.sdu.databaseexercise.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.programming.android.sdu.databaseexercise.R
import com.programming.android.sdu.databaseexercise.UserApplication
import com.programming.android.sdu.databaseexercise.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel.repository = (application as UserApplication).repository
        setContentView(R.layout.activity_main)
    }
}
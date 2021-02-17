package com.example.mvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.mvvm.R
import com.example.mvvm.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {

    // Create the view model which provides data for the view
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            userViewModel.randomJoke()
        }

        // Observe the LiveData and update the view on change
        userViewModel.getJoke().observe(this, {  joke ->
            textView.text = joke.text
        })
    }

}
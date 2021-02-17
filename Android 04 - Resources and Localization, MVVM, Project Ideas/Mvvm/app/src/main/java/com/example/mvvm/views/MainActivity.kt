package com.example.mvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm.R
import com.example.mvvm.models.Joke
import com.example.mvvm.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the view model which provides data for the view
        val userViewModel: UserViewModel by viewModels()

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            userViewModel.randomJoke()
        }

        // Observe the LiveData and update the view on change
        userViewModel.joke.observe(this, {  joke ->
            textView.text = joke.text
        })
    }

}
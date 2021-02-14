package com.example.mvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
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
        val userViewModel = UserViewModel()

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            userViewModel.randomJoke()
        }

        // Code is called data change
        val jokeObserver = Observer<Joke> { joke ->
            // Update UI
            textView.text = joke.text
        }

        // Observe the LiveData. Passing this activity as the LifecycleOwner and the jokeObserver.
        userViewModel.joke.observe(this, jokeObserver)
    }

}
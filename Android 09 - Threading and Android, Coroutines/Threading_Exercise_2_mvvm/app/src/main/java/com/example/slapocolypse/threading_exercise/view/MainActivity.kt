package com.example.slapocolypse.threading_exercise.view

import android.os.Bundle
import android.widget.TextSwitcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.slapocolypse.threading_exercise.R
import com.example.slapocolypse.threading_exercise.viewmodel.JokeViewModel

class MainActivity : AppCompatActivity() {

    private val jokeViewModel: JokeViewModel by viewModels()
    //Example of using Butterknife in your application
    private lateinit var textSwitcher: TextSwitcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSwitcher = findViewById(R.id.joke_holder)
        //Declares standard animations for textSwitcher
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)

        jokeViewModel.joke.observe(this, { joke ->
            textSwitcher.post { textSwitcher.setText(joke) }
        })
    }

}
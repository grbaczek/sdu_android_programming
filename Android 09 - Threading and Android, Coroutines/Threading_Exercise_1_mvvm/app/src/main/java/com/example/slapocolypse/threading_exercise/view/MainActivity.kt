package com.example.slapocolypse.threading_exercise.view

import android.os.Bundle
import android.widget.TextSwitcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.slapocolypse.threading_exercise.R
import com.example.slapocolypse.threading_exercise.viewmodel.RandomViewModel

class MainActivity : AppCompatActivity() {

    private val randomViewModel: RandomViewModel by viewModels()
    private lateinit var textSwitcher: TextSwitcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSwitcher = findViewById(R.id.joke_holder)
        // Declares standard animations for textSwitcher
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)

        randomViewModel.randomString.observe(this, { randomString ->
            textSwitcher.post { textSwitcher.setText(randomString) }
        })
    }

}
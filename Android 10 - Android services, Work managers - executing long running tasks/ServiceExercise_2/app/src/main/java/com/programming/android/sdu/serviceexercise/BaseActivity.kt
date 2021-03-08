package com.programming.android.sdu.serviceexercise

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

/**
 * Created by grzegorzbaczek on 18/03/2018.
 */
open class BaseActivity : AppCompatActivity() {

    lateinit var textSwitcher: TextSwitcher
    private lateinit var tvJokeCounter: TextView

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val bundle = intent.extras
            if (bundle != null) {
                val joke = bundle.getString(JokeAndroidService.JOKE_TEXT)
                val jokeCounter = bundle.getLong(JokeAndroidService.JOKE_COUNTER)
                textSwitcher.setText(joke)
                tvJokeCounter.text = jokeCounter.toString()
            }
        }
    }

    protected fun initViews() {
        textSwitcher = findViewById(R.id.joke_holder)
        tvJokeCounter = findViewById(R.id.tvJokeCounter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, JokeAndroidService::class.java)
        startService(intent)
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, IntentFilter(
                JokeAndroidService.NOTIFICATION))
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver)
    }

}
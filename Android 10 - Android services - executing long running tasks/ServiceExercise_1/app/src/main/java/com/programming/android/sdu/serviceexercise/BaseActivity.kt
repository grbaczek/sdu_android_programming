package com.programming.android.sdu.serviceexercise

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.programming.android.sdu.serviceexercise.JokeAndroidService.JokeAndroidServiceBinder

/**
 * Created by grzegorzbaczek on 18/03/2018.
 */
open class BaseActivity : AppCompatActivity() {

    lateinit var textSwitcher: TextSwitcher
    private lateinit var tvJokeCounter: TextView
    protected var jokeAndroidService: JokeAndroidService? = null
    protected var mBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, JokeAndroidService::class.java)
        bindService(intent, connection, BIND_AUTO_CREATE)
    }

    protected fun initViews() {
        textSwitcher = findViewById(R.id.joke_holder)
        tvJokeCounter = findViewById(R.id.tvJokeCounter)
        val btnUpdateCounter: Button = findViewById(R.id.btnUpdateCounter)
        btnUpdateCounter.setOnClickListener {
            if (mBound) {
                updateCounterClicked()
            }
        }
        val btnUpdateJoke: Button = findViewById(R.id.btnUpdateJoke)
        btnUpdateJoke.setOnClickListener {
            if (mBound) {
                updateJokeClicked()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }

    /** Defines callbacks for service binding, passed to bindService()  */
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            Log.i("service_exrecise", "ServiceConnection onServiceConnected- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)

            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder = service as JokeAndroidServiceBinder
            jokeAndroidService = binder.service
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    private fun updateCounterClicked() {
        if (mBound) {
            tvJokeCounter.text = jokeAndroidService!!.jokeCounter.toString()
        }
    }

    fun updateJokeClicked() {
        if (mBound) {
            textSwitcher.setText(jokeAndroidService!!.newestJoke)
        }
    }
}
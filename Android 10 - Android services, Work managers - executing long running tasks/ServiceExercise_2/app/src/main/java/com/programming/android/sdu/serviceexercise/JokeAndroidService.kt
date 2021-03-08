package com.programming.android.sdu.serviceexercise

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.text.Html
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * Created by grzegorzbaczek on 18/03/2018.
 */
class JokeAndroidService : Service() {

    private var workerThread: Thread? = null
    private val url = "https://api.icndb.com/"

    @Volatile
    private var running = false
    private var jokeCounter: Long = 0
    override fun onCreate() {
        super.onCreate()
        Log.i("service_exrecise", "JokeAndroidService onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        jokeCounter = 0
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.i("service_exrecise", "JokeAndroidService onStartCommand- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        if (!running) {
            running = true
            val retrofit = Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            val jokeWebService = retrofit.create(JokeWebService::class.java)
            workerThread = Thread {
                while (running) {
                    val joke = jokeWebService.randomJoke()
                    try {
                        val joke_txt = Html.fromHtml(joke!!.execute().body()!!.value!!.joke).toString()
                        publishResults(joke_txt, ++jokeCounter)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                    try {
                        Thread.sleep(8000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
            workerThread!!.start()
        }
        return START_STICKY
    }

    private fun publishResults(jokeText: String, jokeCounter: Long) {
        val intent = Intent(NOTIFICATION)
        intent.putExtra(JOKE_TEXT, jokeText)
        intent.putExtra(JOKE_COUNTER, jokeCounter)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    override fun onDestroy() {
        Log.i("service_exrecise", "JokeAndroidService onDestroy- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        running = false
        try {
            workerThread!!.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    companion object {
        const val NOTIFICATION = "com.programming.android.sdu.serviceexercise.receiver"
        const val JOKE_TEXT = "JOKE_TEXT_KEY"
        const val JOKE_COUNTER = "JOKE_COUNTER_KEY"
    }
}
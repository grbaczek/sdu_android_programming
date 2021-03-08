package com.programming.android.sdu.serviceexercise

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.text.Html
import android.util.Log
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
    var jokeCounter: Long = 0
        private set
    var newestJoke: String? = null
        private set

    // Binder given to clients
    private val binder: IBinder = JokeAndroidServiceBinder()

    override fun onCreate() {
        super.onCreate()
        Log.i("service_exrecise", "JokeAndroidService onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        jokeCounter = 0
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
                    newestJoke = joke_txt
                    jokeCounter++
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                try {
                    Thread.sleep(3000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        workerThread!!.start()
    }

    override fun onBind(intent: Intent): IBinder {
        Log.i("service_exrecise", "JokeAndroidService onBind- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        return binder
    }

    inner class JokeAndroidServiceBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        val service: JokeAndroidService
            get() =// Return this instance of LocalService so clients can call public methods
                this@JokeAndroidService
    }

    override fun onDestroy() {
        running = false
        try {
            workerThread!!.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        Log.i("service_exrecise", "JokeAndroidService onDestroy- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        super.onDestroy()
    }

}
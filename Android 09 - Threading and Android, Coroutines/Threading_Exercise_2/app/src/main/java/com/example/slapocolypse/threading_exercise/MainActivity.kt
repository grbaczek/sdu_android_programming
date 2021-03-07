package com.example.slapocolypse.threading_exercise

import android.os.Bundle
import android.text.Html
import android.widget.TextSwitcher
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val url = "https://api.icndb.com/"
    private lateinit var textSwitcher: TextSwitcher
    private var workerThread: Thread? = null
    // Semaphore for keeping track of thread
    @Volatile
    var running = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSwitcher = findViewById(R.id.joke_holder)

        // Declares standard animations for textSwitcher
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)

        // Instantiates Retrofit
        val retrofit = Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Create retrofit instance of JokeService
        val jokeService = retrofit.create(JokeService::class.java)

        // Create a thread
        workerThread = Thread {
            // Make sure the thread is still supposed to run.
            while (running) {
                // Use jokeService to get a joke
                val joke = jokeService.randomJoke()
                try {
                    // Convert joke to string, formatting it, avoiding html escape characters
                    val currentJoke = joke!!.execute().body()
                    val jokeString = Html.fromHtml(currentJoke!!.value!!.joke).toString()

                    // New runnable for changing text in textswitcher
                    textSwitcher.post(Runnable { textSwitcher.setText(jokeString) })
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                // Make the thread sleep for 5 seconds (5.000 ms)
                try {
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

        // Start the thread
        workerThread!!.start()
    }

    override fun onDestroy() {
        // Stop running the thread
        running = false
        super.onDestroy()
        try {
            workerThread!!.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
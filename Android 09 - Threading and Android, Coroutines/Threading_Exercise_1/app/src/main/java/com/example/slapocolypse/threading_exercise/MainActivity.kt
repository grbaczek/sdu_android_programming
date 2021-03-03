package com.example.slapocolypse.threading_exercise

import android.os.Bundle
import android.widget.TextSwitcher
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var textSwitcher: TextSwitcher

    //Thread Stuff
    private lateinit var workerThread: Thread

    //Semaphore for keeping track of thread
    @Volatile
    var running = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSwitcher = findViewById(R.id.joke_holder)
        //Declares standard animations for textSwitcher
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)

        //Create a thread
        workerThread = Thread {
            //Make sure the thread is still supposed to run.
            while (running) {
                val randomString = random()
                //new runnable for changing text in textSwitcher
                textSwitcher.post { textSwitcher.setText(randomString) }

                //Have thread sleep for 5 seconds (5000 ms)
                try {
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

        //start the thread
        workerThread.start()
    }

    override fun onDestroy() {
        // Stop running the thread
        running = false
        super.onDestroy()
        try {
            workerThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    private fun random(): String {
        val generator = Random()
        val randomStringBuilder = StringBuilder()
        val randomLength = generator.nextInt(100)
        var tempChar: Char
        for (i in 0 until randomLength) {
            tempChar = (generator.nextInt(96) + 32).toChar()
            randomStringBuilder.append(tempChar)
        }
        return randomStringBuilder.toString()
    }

}
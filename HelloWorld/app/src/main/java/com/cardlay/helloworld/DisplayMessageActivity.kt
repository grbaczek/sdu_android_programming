package com.cardlay.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(MainActivity.Companion.EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = message
        Log.i(TAG, "DisplayMessageActivity onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "DisplayMessageActivity onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "DisplayMessageActivity onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "DisplayMessageActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "DisplayMessageActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "DisplayMessageActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "DisplayMessageActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "DisplayMessageActivity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "DisplayMessageActivity onRestart")
    }

    companion object {
        const val TAG = "activities_events"
    }
}
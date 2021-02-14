package com.cardlay.helloworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "MainActivity onCreate")
    }

    /** Called when the user taps the Send button  */
    fun sendMessage(view: View?) {
        val intent = Intent(this, DisplayMessageActivity::class.java)
        val editText = findViewById<View>(R.id.editText) as EditText
        val message = editText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "MainActivity onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "MainActivity onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "MainActivity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "MainActivity onRestart")
    }

    companion object {
        const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
        const val TAG = "activities_events"
    }
}
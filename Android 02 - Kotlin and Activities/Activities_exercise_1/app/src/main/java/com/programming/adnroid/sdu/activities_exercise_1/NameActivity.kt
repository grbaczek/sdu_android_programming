package com.programming.adnroid.sdu.activities_exercise_1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {

    private lateinit var etYourName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        etYourName = findViewById(R.id.etYourName)
        val btnNext: Button = findViewById(R.id.btnNext)
        btnNext.setOnClickListener { redirectToNextActivity() }
        Log.i(Constants.TAG, "NameActivity onCreate ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(Constants.TAG, "NameActivity onSaveInstanceState ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(Constants.TAG, "NameActivity onRestoreInstanceState ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Constants.TAG, "NameActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Constants.TAG, "NameActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Constants.TAG, "NameActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Constants.TAG, "NameActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        this.apply { }
        Log.i(Constants.TAG, "NameActivity onDestroy")
    }

    private fun redirectToNextActivity() {
        if (!TextUtils.isEmpty(etYourName.text)) {
            val intent = Intent(this, AddressActivity::class.java)
            intent.putExtra(Constants.NAME_KEY, etYourName.text.toString())
            startActivity(intent)
        }
    }

}
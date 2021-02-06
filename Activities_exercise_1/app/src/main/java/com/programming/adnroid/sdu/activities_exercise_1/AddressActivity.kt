package com.programming.adnroid.sdu.activities_exercise_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class AddressActivity : AppCompatActivity() {
    private var etYourAddress: EditText? = null
    private var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        name = intent.getStringExtra(Constants.NAME_KEY)
        etYourAddress = findViewById(R.id.etYourAddress)
        /*((Button) findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToNextActivity();
            }
        });*/(findViewById<View>(R.id.btnBack) as Button).setOnClickListener { finishActivity() }
    }

    override fun onStart() {
        super.onStart()
        Log.i(Constants.TAG, "AddressActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Constants.TAG, "AddressActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Constants.TAG, "AddressActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Constants.TAG, "AddressActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Constants.TAG, "AddressActivity onDestroy")
    }

    fun redirectToNextActivity(v: View?) {
        if (!TextUtils.isEmpty(etYourAddress!!.text)) {
            val intent = Intent(this, DateOfBirthActivity::class.java)
            intent.putExtra(Constants.ADDRESS_KEY, etYourAddress!!.text.toString())
            intent.putExtra(Constants.NAME_KEY, name)
            startActivity(intent)
        }
    }

    private fun finishActivity() {
        finish()
    }
}
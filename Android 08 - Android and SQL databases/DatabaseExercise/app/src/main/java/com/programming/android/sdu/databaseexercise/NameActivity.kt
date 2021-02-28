package com.programming.android.sdu.databaseexercise

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class NameActivity : BaseActivity() {
    private var etYourName: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        Log.i(Constants.TAG, "NameActivity onCreate")
        Log.i(Constants.TAG_THREADING, "NameActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        etYourName = findViewById<View>(R.id.etYourName) as EditText
        (findViewById<View>(R.id.btnNext) as Button).setOnClickListener { redirectToNextActivity() }
        if (!TextUtils.isEmpty(currentUser!!.name)) {
            etYourName!!.setText(currentUser!!.name)
        }
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
        Log.i(Constants.TAG, "NameActivity onDestroy")
    }

    private fun redirectToNextActivity() {
        if (!TextUtils.isEmpty(etYourName!!.text)) {
            val intent = Intent(this, AddressActivity::class.java)
            intent.putExtra(Constants.NAME_KEY, etYourName!!.text.toString())
            currentUser!!.name = etYourName!!.text.toString()
            db!!.userDao().update(currentUser)
            startActivity(intent)
        }
    }

    private fun finishActivity() {
        finish()
    }
}
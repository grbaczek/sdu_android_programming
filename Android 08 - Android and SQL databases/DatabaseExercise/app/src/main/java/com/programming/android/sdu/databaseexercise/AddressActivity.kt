package com.programming.android.sdu.databaseexercise

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class AddressActivity : BaseActivity() {
    private var etYourAddress: EditText? = null
    private var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        val i = intent
        name = i.getStringExtra(Constants.NAME_KEY)
        Log.i(Constants.TAG, "AddressActivity onCreate")
        Log.i(Constants.TAG_THREADING, "AddressActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        etYourAddress = findViewById<View>(R.id.etYourAddress) as EditText
        (findViewById<View>(R.id.btnNext) as Button).setOnClickListener { redirectToNextActivity() }
        (findViewById<View>(R.id.btnBack) as Button).setOnClickListener { finishActivity() }
        if (!TextUtils.isEmpty(currentUser!!.address)) {
            etYourAddress!!.setText(currentUser!!.address)
        }
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

    private fun redirectToNextActivity() {
        if (!TextUtils.isEmpty(etYourAddress!!.text)) {
            val intent = Intent(this, DateOfBirthActivity::class.java)
            intent.putExtra(Constants.ADDRESS_KEY, etYourAddress!!.text.toString())
            intent.putExtra(Constants.NAME_KEY, name)
            currentUser!!.address = etYourAddress!!.text.toString()
            db!!.userDao().update(currentUser)
            startActivity(intent)
        }
    }

    private fun finishActivity() {
        finish()
    }
}
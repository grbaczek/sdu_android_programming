package com.programming.android.sdu.databaseexercise

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.programming.android.sdu.databaseexercise.database.User

class NameActivity : BaseActivity() {

    private lateinit var etYourName: EditText
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        etYourName = findViewById(R.id.etYourName)
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener { redirectToNextActivity() }

        if (!TextUtils.isEmpty(currentUser.name)) {
            etYourName.setText(currentUser.name)
        }

        Log.i(Constants.TAG, "NameActivity onCreate")
        Log.i(Constants.TAG_THREADING, "NameActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
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
        if (!TextUtils.isEmpty(etYourName.text)) {
            val intent = Intent(this, AddressActivity::class.java)
            intent.putExtra(Constants.NAME_KEY, etYourName.text.toString())

            val updatedUser = User(
                    uid = currentUser.uid,
                    address = currentUser.address,
                    dateOfBirth = currentUser.dateOfBirth,
                    name = etYourName.text.toString()
            )
            db.userDao().update(updatedUser)
            startActivity(intent)
        }
    }

}
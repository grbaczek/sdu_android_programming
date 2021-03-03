package com.programming.android.sdu.databaseexercise

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.programming.android.sdu.databaseexercise.database.User

class AddressActivity : BaseActivity() {

    private lateinit var etYourAddress: EditText
    private lateinit var btnNext: Button
    private lateinit var btnBack: Button
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        val i = intent
        name = i.getStringExtra(Constants.NAME_KEY)

        etYourAddress = findViewById(R.id.etYourAddress)
        btnNext = findViewById(R.id.btnNext)
        btnBack = findViewById(R.id.btnBack)
        btnNext.setOnClickListener { redirectToNextActivity() }
        btnBack.setOnClickListener { finishActivity() }

        if (!TextUtils.isEmpty(currentUser.address)) {
            etYourAddress.setText(currentUser.address)
        }

        Log.i(Constants.TAG, "AddressActivity onCreate")
        Log.i(Constants.TAG_THREADING, "AddressActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
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
        if (!TextUtils.isEmpty(etYourAddress.text)) {
            val intent = Intent(this, DateOfBirthActivity::class.java)
            intent.putExtra(Constants.ADDRESS_KEY, etYourAddress.text.toString())
            intent.putExtra(Constants.NAME_KEY, name)
            val updatedUser = User(
                    uid = currentUser.uid,
                    address =  etYourAddress.text.toString(),
                    dateOfBirth = currentUser.dateOfBirth,
                    name = currentUser.name
            )
            db.userDao().update(updatedUser)
            startActivity(intent)
        }
    }

    private fun finishActivity() {
        finish()
    }
}
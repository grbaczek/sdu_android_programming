package com.programming.android.sdu.databaseexercise

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import com.programming.android.sdu.databaseexercise.databinding.ActivityAddressBinding
import com.programming.android.sdu.databaseexercise.views.BaseActivity

class AddressActivity : BaseActivity() {

    private lateinit var etYourAddress: EditText
    private lateinit var name: String
    private lateinit var binding: ActivityAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        name = i.getStringExtra(Constants.NAME_KEY)
        Log.i(Constants.TAG, "AddressActivity onCreate")
        Log.i(Constants.TAG_THREADING, "AddressActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)

        etYourAddress = binding.etYourAddress
        binding.btnNext.setOnClickListener { redirectToNextActivity() }
        binding.btnBack.setOnClickListener { finishActivity() }

        if (!TextUtils.isEmpty(currentUser!!.address)) {
            etYourAddress.setText(currentUser!!.address)
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
        if (!TextUtils.isEmpty(etYourAddress.text)) {
            val intent = Intent(this, DateOfBirthActivity::class.java)
            intent.putExtra(Constants.ADDRESS_KEY, etYourAddress.text.toString())
            intent.putExtra(Constants.NAME_KEY, name)
            currentUser!!.address = etYourAddress.text.toString()
            userViewModel.update(currentUser!!)
            startActivity(intent)
        }
    }

    private fun finishActivity() {
        finish()
    }
}
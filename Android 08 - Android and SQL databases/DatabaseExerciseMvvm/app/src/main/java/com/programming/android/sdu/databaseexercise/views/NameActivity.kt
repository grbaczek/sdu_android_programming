package com.programming.android.sdu.databaseexercise.views

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import com.programming.android.sdu.databaseexercise.AddressActivity
import com.programming.android.sdu.databaseexercise.Constants
import com.programming.android.sdu.databaseexercise.databinding.ActivityNameBinding

class NameActivity : BaseActivity() {

    private lateinit var etYourName: EditText
    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(Constants.TAG, "NameActivity onCreate")
        Log.i(Constants.TAG_THREADING, "NameActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)

        etYourName = binding.etYourName
        binding.btnNext.setOnClickListener { redirectToNextActivity() }
        if (!TextUtils.isEmpty(currentUser!!.name)) {
            etYourName.setText(currentUser!!.name)
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
        if (!TextUtils.isEmpty(etYourName.text)) {
            val intent = Intent(this, AddressActivity::class.java)
            intent.putExtra(Constants.NAME_KEY, etYourName.text.toString())
            currentUser!!.name = etYourName.text.toString()
            userViewModel.update(currentUser!!)
            startActivity(intent)
        }
    }

}
package com.programming.android.sdu.databaseexercise.views

import android.os.Bundle
import android.util.Log
import com.programming.android.sdu.databaseexercise.Constants
import com.programming.android.sdu.databaseexercise.databinding.ActivitySummaryBinding

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */
class SummaryActivity : BaseActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        binding.tvName.text = intent.getStringExtra(Constants.NAME_KEY)
        binding.tvAddress.text = intent.getStringExtra(Constants.ADDRESS_KEY)
        binding.tvDateOfBirth.text = intent.getStringExtra(Constants.DATE_OF_BIRTH_KEY)
        binding.btnBack.setOnClickListener { finishActivity() }
        Log.i(Constants.TAG, "SummaryActivity onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Constants.TAG, "SummaryActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Constants.TAG, "SummaryActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Constants.TAG, "SummaryActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Constants.TAG, "SummaryActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Constants.TAG, "SummaryActivity onDestroy")
    }

    private fun finishActivity() {
        finish()
    }
}
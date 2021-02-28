package com.programming.android.sdu.databaseexercise

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */
class SummaryActivity : BaseActivity() {
    lateinit var tvName: TextView
    lateinit var tvAddress: TextView
    lateinit var tvDate: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvDate = findViewById(R.id.tvDateOfBirth)
        val intent = intent
        tvName.setText(intent.getStringExtra(Constants.NAME_KEY))
        tvAddress.setText(intent.getStringExtra(Constants.ADDRESS_KEY))
        tvDate.setText(intent.getStringExtra(Constants.DATE_OF_BIRTH_KEY))
        Log.i(Constants.TAG, "SummaryActivity onCreate")
        (findViewById<View>(R.id.btnBack) as Button).setOnClickListener { finishActivity() }
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
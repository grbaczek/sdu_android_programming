package com.programming.android.sdu.databaseexercise

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */
class SummaryActivity : BaseActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvDate: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvDate = findViewById(R.id.tvDateOfBirth)

        val intent = intent
        tvName.text = intent.getStringExtra(Constants.NAME_KEY)
        tvAddress.text = intent.getStringExtra(Constants.ADDRESS_KEY)
        tvDate.text = intent.getStringExtra(Constants.DATE_OF_BIRTH_KEY)

        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener { finishActivity() }

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
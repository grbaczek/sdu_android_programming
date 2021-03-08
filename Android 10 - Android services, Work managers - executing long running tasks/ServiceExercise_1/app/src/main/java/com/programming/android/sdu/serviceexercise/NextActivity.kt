package com.programming.android.sdu.serviceexercise

import android.os.Bundle
import android.util.Log
import android.widget.Button

class NextActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.next_activity)
        initViews()
        Log.i("service_exrecise", "NextActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)
        val btnBack : Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener { finish() }
    }

}
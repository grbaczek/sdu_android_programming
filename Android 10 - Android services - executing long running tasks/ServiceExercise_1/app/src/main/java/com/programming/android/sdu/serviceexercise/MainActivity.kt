package com.programming.android.sdu.serviceexercise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        Log.i("service_exrecise", "MainActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)
        val btnNext : Button = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            val i = Intent(baseContext, NextActivity::class.java)
            startActivity(i)
        }
    }

}
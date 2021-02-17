package com.cardlay.fragmentexercise1noappbar

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment, WhiteFragment()) //.addToBackStack(null)
                .commit()
        }
        val btnWhite = findViewById<Button>(R.id.btnWhite)
        btnWhite.setOnClickListener { updateFragment(WhiteFragment()) }
        val btnBlue = findViewById<Button>(R.id.btnBlue)
        btnBlue.setOnClickListener { updateFragment(BlueFragment()) }
        val btnGreen = findViewById<Button>(R.id.btnGreen)
        btnGreen.setOnClickListener { updateFragment(GreenFragment()) }
        val btnRed = findViewById<Button>(R.id.btnRed)
        btnRed.setOnClickListener { updateFragment(RedFragment()) }
        btnGreen.setOnClickListener { updateFragment(GreenFragment()) }
    }

    private fun updateFragment(currentFragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_fragment, currentFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}
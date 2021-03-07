package com.programming.adnroid.sdu.activities_exercise_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */
class DateOfBirthActivity : AppCompatActivity() {

    private lateinit var dpDateOfBirth: DatePicker
    private var name: String? = null
    private var address: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_of_birth)
        val i = intent
        name = i.getStringExtra(Constants.NAME_KEY)
        address = i.getStringExtra(Constants.ADDRESS_KEY)
        dpDateOfBirth = findViewById(R.id.dateOfBirthPicker)
        dpDateOfBirth.updateDate(1986, 4, 14)
        val btnNext: Button = findViewById(R.id.btnNext)
        btnNext.setOnClickListener { redirectToNextActivity() }
        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener { finishActivity() }
        Log.i(Constants.TAG, "DateOfBirthActivity onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Constants.TAG, "DateOfBirthActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Constants.TAG, "DateOfBirthActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Constants.TAG, "DateOfBirthActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Constants.TAG, "DateOfBirthActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Constants.TAG, "DateOfBirthActivity onDestroy")
    }

    private fun redirectToNextActivity() {
        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra(Constants.ADDRESS_KEY, address)
        intent.putExtra(Constants.NAME_KEY, name)
        val day = dpDateOfBirth.dayOfMonth
        val month = dpDateOfBirth.month
        val year = dpDateOfBirth.year
        val calendar = Calendar.getInstance()
        calendar[year, month] = day
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formattedDate = sdf.format(calendar.time)
        intent.putExtra(Constants.DATE_OF_BIRTH_KEY, formattedDate)
        startActivity(intent)
    }

    private fun finishActivity() {
        finish()
    }
}
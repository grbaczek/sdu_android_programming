package com.programming.android.sdu.databaseexercise

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */
class DateOfBirthActivity : BaseActivity() {
    private var dpDateOfBirth: DatePicker? = null
    private var name: String? = null
    private var address: String? = null
    private lateinit var btnNext: Button
    private lateinit var btnPrevious: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_of_birth)
        val i = intent
        name = i.getStringExtra(Constants.NAME_KEY)
        address = i.getStringExtra(Constants.ADDRESS_KEY)
        dpDateOfBirth = findViewById<View>(R.id.dateOfBirthPicker) as DatePicker
        dpDateOfBirth!!.updateDate(1986, 4, 14)
        Log.i(Constants.TAG, "DateOfBirthActivity onCreate")
        Log.i(Constants.TAG_THREADING, "DateOfBirthActivity onCreate- Current Thread ID- " + Thread.currentThread().id + " For Thread- " + Thread.currentThread().name)
        btnNext = findViewById(R.id.btnNext)
        btnPrevious = findViewById(R.id.btnBack)
        btnNext.setOnClickListener(View.OnClickListener { redirectToNextActivity() })
        btnPrevious.setOnClickListener(View.OnClickListener { finishActivity() })
        if (currentUser!!.dateOfBirth != 0L) {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = currentUser!!.dateOfBirth * 1000
            dpDateOfBirth!!.updateDate(calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH])
        }
        //DONT DO IT LIKE THIS!!!!!!!
        Thread {
            try {
                Thread.sleep(6000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            Log.i(Constants.TAG_THREADING, "DateOfBirthActivity setting the new date")
            dpDateOfBirth!!.updateDate(1990, 0, 1)
        }.start()
        // throw new RuntimeException();
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
        val day = dpDateOfBirth!!.dayOfMonth
        val month = dpDateOfBirth!!.month
        val year = dpDateOfBirth!!.year
        val calendar = Calendar.getInstance()
        calendar[year, month] = day
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formatedDate = sdf.format(calendar.time)
        intent.putExtra(Constants.DATE_OF_BIRTH_KEY, formatedDate)
        currentUser!!.dateOfBirth = calendar.timeInMillis / 1000
        db!!.userDao().update(currentUser)
        startActivity(intent)
    }

    private fun finishActivity() {
        finish()
    }
}
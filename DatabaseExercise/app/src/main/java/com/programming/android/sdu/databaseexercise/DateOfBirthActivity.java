package com.programming.android.sdu.databaseexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */

public class DateOfBirthActivity extends BaseActivity {

    private DatePicker dpDateOfBirth;
    private String name;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_of_birth);
        Intent i = getIntent();
        name = i.getStringExtra(Constants.NAME_KEY);
        address = i.getStringExtra(Constants.ADDRESS_KEY);
        dpDateOfBirth = (DatePicker) findViewById(R.id.dateOfBirthPicker);
        dpDateOfBirth.updateDate(1986, 4, 14);
        Log.i(Constants.TAG, "DateOfBirthActivity onCreate");
        ((Button) findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToNextActivity();
            }
        });
        ((Button) findViewById(R.id.btnBack)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
        if(currentUser.dateOfBirth != 0){
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentUser.dateOfBirth * 1000);
            dpDateOfBirth.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }
       // throw new RuntimeException();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Constants.TAG, "DateOfBirthActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Constants.TAG, "DateOfBirthActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Constants.TAG, "DateOfBirthActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Constants.TAG, "DateOfBirthActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Constants.TAG, "DateOfBirthActivity onDestroy");
    }


    private void redirectToNextActivity() {
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra(Constants.ADDRESS_KEY, address);
        intent.putExtra(Constants.NAME_KEY, name);

        int   day  = dpDateOfBirth.getDayOfMonth();
        int   month= dpDateOfBirth.getMonth();
        int   year = dpDateOfBirth.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = sdf.format(calendar.getTime());
        intent.putExtra(Constants.DATE_OF_BIRTH_KEY, formatedDate);
        currentUser.dateOfBirth = calendar.getTimeInMillis() / 1000;
        db.userDao().update(currentUser);
        startActivity(intent);
    }

    private void finishActivity() {
        finish();
    }

}

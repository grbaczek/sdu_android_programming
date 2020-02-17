package com.programming.android.sdu.databaseexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */

public class SummaryActivity  extends BaseActivity {

    TextView tvName;
    TextView tvAddress;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvName = findViewById(R.id.tvName);
        tvAddress = findViewById(R.id.tvAddress);
        tvDate = findViewById(R.id.tvDateOfBirth);

        Intent intent = getIntent();

        tvName.setText(intent.getStringExtra(Constants.NAME_KEY));
        tvAddress.setText(intent.getStringExtra(Constants.ADDRESS_KEY));
        tvDate.setText(intent.getStringExtra(Constants.DATE_OF_BIRTH_KEY));

        Log.i(Constants.TAG, "SummaryActivity onCreate");

        ((Button) findViewById(R.id.btnBack)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Constants.TAG, "SummaryActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Constants.TAG, "SummaryActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Constants.TAG, "SummaryActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Constants.TAG, "SummaryActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Constants.TAG, "SummaryActivity onDestroy");
    }


    private void finishActivity() {
        finish();
    }
}


package com.programming.adnroid.sdu.activities_exercise_1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    private EditText etYourAddress;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        name = getIntent().getStringExtra(Constants.NAME_KEY);
        etYourAddress = findViewById(R.id.etYourAddress);
        /*((Button) findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToNextActivity();
            }
        });*/
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
        Log.i(Constants.TAG, "AddressActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Constants.TAG, "AddressActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Constants.TAG, "AddressActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Constants.TAG, "AddressActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Constants.TAG, "AddressActivity onDestroy");
    }


    public void redirectToNextActivity(View v){
        if(!TextUtils.isEmpty(etYourAddress.getText())) {
            Intent intent = new Intent(this, DateOfBirthActivity.class);
            intent.putExtra(Constants.ADDRESS_KEY, etYourAddress.getText().toString());
            intent.putExtra(Constants.NAME_KEY, name);
            startActivity(intent);
        }
    }

    private void finishActivity(){
        finish();
    }



}


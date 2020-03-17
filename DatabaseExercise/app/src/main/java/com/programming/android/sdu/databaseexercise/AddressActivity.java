package com.programming.android.sdu.databaseexercise;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends BaseActivity {

    private EditText etYourAddress;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Intent i = getIntent();
        name = i.getStringExtra(Constants.NAME_KEY);
        Log.i(Constants.TAG, "AddressActivity onCreate");
        Log.i(Constants.TAG_THREADING, "AddressActivity onCreate- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());
        etYourAddress = (EditText)findViewById(R.id.etYourAddress);

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

        if(!TextUtils.isEmpty(currentUser.address)){
            etYourAddress.setText(currentUser.address);
        }
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


    private void redirectToNextActivity(){
        if(!TextUtils.isEmpty(etYourAddress.getText())) {
            Intent intent = new Intent(this, DateOfBirthActivity.class);
            intent.putExtra(Constants.ADDRESS_KEY, etYourAddress.getText().toString());
            intent.putExtra(Constants.NAME_KEY, name);
            currentUser.address = etYourAddress.getText().toString();
            db.userDao().update(currentUser);
            startActivity(intent);
        }
    }

    private void finishActivity(){
        finish();
    }



}


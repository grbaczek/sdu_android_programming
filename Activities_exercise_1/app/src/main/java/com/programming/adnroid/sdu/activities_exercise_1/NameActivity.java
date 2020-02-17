package com.programming.adnroid.sdu.activities_exercise_1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private EditText etYourName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Log.i(Constants.TAG, "NameActivity onCreate");
        etYourName = (EditText)findViewById(R.id.etYourName);

        ((Button) findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToNextActivity();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(Constants.TAG, "NameActivity onSaveInstanceState ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(Constants.TAG, "NameActivity onRestoreInstanceState ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Constants.TAG, "NameActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Constants.TAG, "NameActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Constants.TAG, "NameActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Constants.TAG, "NameActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Constants.TAG, "NameActivity onDestroy");
    }

    private void redirectToNextActivity(){
        if(!TextUtils.isEmpty(etYourName.getText())) {
            Intent intent = new Intent(this, AddressActivity.class);
            intent.putExtra(Constants.NAME_KEY, etYourName.getText().toString());
            startActivity(intent);
        }
    }

    private void finishActivity(){
        finish();
    }



}

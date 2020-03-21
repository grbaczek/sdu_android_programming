package com.programming.android.sdu.serviceexercise;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class NextActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);
        initViews();
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

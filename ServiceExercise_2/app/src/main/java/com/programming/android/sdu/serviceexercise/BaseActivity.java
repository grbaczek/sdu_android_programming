package com.programming.android.sdu.serviceexercise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;

/**
 * Created by grzegorzbaczek on 18/03/2018.
 */

public class BaseActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;
    TextView tvJokeCounter;


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String joke = bundle.getString(JokeAndroidService.JOKE_TEXT);
                long jokeCounter = bundle.getLong(JokeAndroidService.JOKE_COUNTER);
                textSwitcher.setText(joke);
                tvJokeCounter.setText(String.valueOf(jokeCounter));
            }
        }
    };

    protected void initViews(){
        textSwitcher = findViewById(R.id.joke_holder);
        tvJokeCounter = findViewById(R.id.tvJokeCounter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, JokeAndroidService.class);
        startService(intent);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(
                JokeAndroidService.NOTIFICATION));
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
}

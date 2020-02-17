package com.programming.android.sdu.serviceexercise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextSwitcher;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by grzegorzbaczek on 18/03/2018.
 */

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.joke_holder)
    TextSwitcher textSwitcher;
    @BindView(R.id.tvJokeCounter)
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerReceiver(receiver, new IntentFilter(
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
        unregisterReceiver(receiver);
    }
}

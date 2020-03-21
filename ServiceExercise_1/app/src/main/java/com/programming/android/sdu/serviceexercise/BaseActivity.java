package com.programming.android.sdu.serviceexercise;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
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

    protected JokeAndroidService jokeAndroidService;
    protected boolean mBound;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, JokeAndroidService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    protected void initViews(){
        textSwitcher = findViewById(R.id.joke_holder);
        tvJokeCounter = findViewById(R.id.tvJokeCounter);

        findViewById(R.id.btnUpdateCounter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound){
                    tvJokeCounter.setText(String.valueOf(jokeAndroidService.getJokeCounter()));
                }
            }
        });
        findViewById(R.id.btnUpdateJoke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound){
                    textSwitcher.setText(jokeAndroidService.getNewestJoke());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            JokeAndroidService.JokeAndroidServiceBinder binder = (JokeAndroidService.JokeAndroidServiceBinder) service;
            jokeAndroidService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };


    public void updateCounterClicked(){
        if(mBound){
            tvJokeCounter.setText(String.valueOf(jokeAndroidService.getJokeCounter()));
        }
    }

    public void updateJokeClicked(){
        if(mBound){
            textSwitcher.setText(jokeAndroidService.getNewestJoke());
        }
    }




}

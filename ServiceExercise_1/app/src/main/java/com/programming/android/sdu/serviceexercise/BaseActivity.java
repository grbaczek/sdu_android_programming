package com.programming.android.sdu.serviceexercise;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextSwitcher;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by grzegorzbaczek on 18/03/2018.
 */

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.joke_holder)
    TextSwitcher textSwitcher;
    @BindView(R.id.tvJokeCounter)
    TextView tvJokeCounter;

    protected JokeAndroidService jokeAndroidService;
    protected boolean mBound;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, JokeAndroidService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
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

    @OnClick(R.id.btnUpdateCounter)
    public void updateCounterClicked(){
        if(mBound){
            tvJokeCounter.setText(String.valueOf(jokeAndroidService.getJokeCounter()));
        }
    }

    @OnClick(R.id.btnUpdateJoke)
    public void updateJokeClicked(){
        if(mBound){
            textSwitcher.setText(jokeAndroidService.getNewestJoke());
        }
    }




}

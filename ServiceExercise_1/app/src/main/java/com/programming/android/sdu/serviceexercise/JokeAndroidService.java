package com.programming.android.sdu.serviceexercise;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.text.Html;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by grzegorzbaczek on 18/03/2018.
 */

public class JokeAndroidService extends Service {

    private static final String url = "http://api.icndb.com/";

    private Thread workerThread;
    private JokeWebService jokeWebService;
    private volatile boolean running;
    private long jokeCounter;
    private String newestJoke;
    // Binder given to clients
    private final IBinder binder = new JokeAndroidServiceBinder();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("service_exrecise", "JokeAndroidService onCreate- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());
        jokeCounter = 0;
        running = true;
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jokeWebService = retrofit.create(JokeWebService.class);
        workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    Call<Joke> joke = jokeWebService.randomJoke();
                    try {
                        String joke_txt = Html.fromHtml(joke.execute().body().getValue().getJoke()).toString();
                        newestJoke = joke_txt;
                        jokeCounter++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        workerThread.start();

    }

    public String getNewestJoke(){
        return newestJoke;
    }

    public Long getJokeCounter(){
        return jokeCounter;
    }

    public IBinder onBind(Intent intent) {
        Log.i("service_exrecise", "JokeAndroidService onBind- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());
        return binder;
    }

    public class JokeAndroidServiceBinder extends Binder {
        JokeAndroidService getService() {
            // Return this instance of LocalService so clients can call public methods
            return JokeAndroidService.this;
        }
    }

    @Override
    public void onDestroy() {
        running = false;
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("service_exrecise", "JokeAndroidService onDestroy- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());
        super.onDestroy();

    }
}

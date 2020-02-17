package com.programming.android.sdu.serviceexercise;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
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

    public static final String NOTIFICATION = "com.programming.android.sdu.serviceexercise.receiver";
    public static final String JOKE_TEXT = "JOKE_TEXT_KEY";
    public static final String JOKE_COUNTER = "JOKE_COUNTER_KEY";

    private static final String url = "http://api.icndb.com/";

    private Thread workerThread;
    private JokeWebService jokeWebService;
    private volatile boolean running;
    private long jokeCounter;


    @Override
    public void onCreate() {
        super.onCreate();
        jokeCounter = 0;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!running) {
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
                            publishResults(joke_txt, ++jokeCounter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(8000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            workerThread.start();
        }
        return START_STICKY;
    }

    private void publishResults(String jokeText, long jokeCounter) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(JOKE_TEXT, jokeText);
        intent.putExtra(JOKE_COUNTER, jokeCounter);
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        running = false;
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

package com.example.slapocolypse.threading_exercise;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //Example of using Butterknife in your application

    final String url = "http://api.icndb.com/";
    TextSwitcher textSwitcher;
    //Retrofit stuff
    Retrofit retrofit;
    JokeService jokeService;

    //Thread Stuff
    Thread workerThread;

    //Semaphore for keeping track of thread
    volatile boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSwitcher = findViewById(R.id.joke_holder);

        //Declares standard animations for textSwitcher
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

        //Instantiates Retrofrit
        retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create retrofit instance of JokeService
        jokeService = retrofit.create(JokeService.class);


        /*try {
            jokeService.randomJoke().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //Create a thread
        workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Make sure the thread is still supposed to run.
                while (running) {
                    //Use jokeservice to get a joke
                    Call<Joke> joke = jokeService.randomJoke();
                    try {
                        //Convert joke to string, formatting it, avoiding html escape characters
                        final Joke current_joke = joke.execute().body();
                        final String joke_txt = Html.fromHtml(current_joke.value.joke).toString();

                        //new runnable for changing text in textswitcher
                        textSwitcher.post(new Runnable() {
                            @Override
                            public void run() {
                                textSwitcher.setText(joke_txt);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Have thread sleep for 10 seconds (10.000 ms)
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //start the thread
        workerThread.start();
    }

    @Override
    protected void onDestroy() {
        // Stop running the thread
        running = false;
        super.onDestroy();
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

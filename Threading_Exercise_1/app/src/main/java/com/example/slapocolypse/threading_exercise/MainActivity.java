package com.example.slapocolypse.threading_exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextSwitcher;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //Example of using Butterknife in your application
    @BindView(R.id.joke_holder)
    TextSwitcher textSwitcher;
    final String url = "http://api.icndb.com/";

    //Thread Stuff
    Thread workerThread;

    //Semaphore for keeping track of thread
    volatile boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activate butterknife, binding to this activity
        ButterKnife.bind(this);

        //Declares standard animations for textSwitcher
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);


        //Create a thread
        workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Make sure the thread is still supposed to run.
                while (running) {


                    final String randomString = random();
                    //new runnable for changing text in textswitcher
                    textSwitcher.post(new Runnable() {
                        @Override
                        public void run() {
                            textSwitcher.setText(randomString);
                        }
                    });

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

    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(100);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}

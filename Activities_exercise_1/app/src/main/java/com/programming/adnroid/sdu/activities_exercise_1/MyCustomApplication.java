package com.programming.adnroid.sdu.activities_exercise_1;

/**
 * Created by grzegorzbaczek on 19/02/2018.
 */

import android.app.Application;
import android.content.res.Configuration;

public class MyCustomApplication extends Application {
    // Called when the application is starting, before any other application objects have been created.
    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!
    }

    // Called by the system when the device configuration changes while your component is running.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}

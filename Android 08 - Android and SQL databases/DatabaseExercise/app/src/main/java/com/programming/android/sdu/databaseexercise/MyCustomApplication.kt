package com.programming.android.sdu.databaseexercise

import android.app.Application
import android.content.res.Configuration

/**
 * Created by grzegorzbaczek on 19/02/2018.
 */
class MyCustomApplication : Application() {
    // Called when the application is starting, before any other application objects have been created.
    override fun onCreate() {
        super.onCreate()
        // Required initialization logic here!
    }

    // Called by the system when the device configuration changes while your component is running.
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    override fun onLowMemory() {
        super.onLowMemory()
    }
}
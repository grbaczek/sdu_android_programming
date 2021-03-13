package com.programming.android.sdu.contentproviderexercise

import android.app.Application

class ContactApplication : Application() {

    val contactContentProvider by lazy { ContactContentProvider() }

}
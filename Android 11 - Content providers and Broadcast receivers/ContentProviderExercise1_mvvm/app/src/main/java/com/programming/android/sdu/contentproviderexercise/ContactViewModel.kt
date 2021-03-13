package com.programming.android.sdu.contentproviderexercise

import android.net.Uri
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel()  {

    lateinit var contactContentProvider: IContactContentProvider

    fun getDisplayName(): String {
        return contactContentProvider.getDisplayName()
    }

    fun getID(): String {
        return contactContentProvider.getID()
    }

    fun getLookupKey(): String {
        return contactContentProvider.getLookupKey()
    }

    fun getContentURI(): Uri {
        return contactContentProvider.getContentURI()
    }

}
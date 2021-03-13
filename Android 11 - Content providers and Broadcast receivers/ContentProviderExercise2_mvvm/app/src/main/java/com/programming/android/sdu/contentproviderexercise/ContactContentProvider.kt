package com.programming.android.sdu.contentproviderexercise

import android.net.Uri
import android.provider.ContactsContract

class ContactContentProvider : IContactContentProvider {

    override fun getDisplayName(): String {
        return ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
    }

    override fun getID(): String {
        return ContactsContract.Contacts._ID
    }

    override fun getLookupKey(): String {
        return ContactsContract.Contacts.LOOKUP_KEY
    }

    override fun getContentURI(): Uri {
        return ContactsContract.Contacts.CONTENT_URI
    }

}
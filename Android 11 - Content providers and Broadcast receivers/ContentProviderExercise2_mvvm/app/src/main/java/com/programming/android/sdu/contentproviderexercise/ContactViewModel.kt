package com.programming.android.sdu.contentproviderexercise

import android.net.Uri
import androidx.lifecycle.ViewModel
import java.util.*

class ContactViewModel : ViewModel() {

    private val contacts: MutableList<ContactPerson> = ArrayList()
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

    fun getContacts(): List<ContactPerson> {
        return contacts
    }

    fun addContact(id: String?, lookupKey: String?, displayName: String?) {
        val contact = ContactPerson(id, lookupKey, displayName)
        contacts.add(contact)
    }

}
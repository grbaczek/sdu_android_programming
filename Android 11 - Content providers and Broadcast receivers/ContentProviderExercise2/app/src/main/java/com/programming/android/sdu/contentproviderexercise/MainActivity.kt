package com.programming.android.sdu.contentproviderexercise

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var contactsRecyclerView: RecyclerView
    private var contactsRetriever: ContactsRetriever? = null

    private fun showContacts() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), PERMISSIONS_REQUEST_READ_CONTACTS)
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            loadContacts()
            // Android version is lesser than 6.0 or the permission is already granted.
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                showContacts()
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactsRecyclerView = findViewById(R.id.contactsLst)
        val layoutManager = LinearLayoutManager(this)
        contactsRecyclerView.layoutManager = layoutManager
        showContacts()
    }

    private fun loadContacts() {
        stopContactsRetriever()
        contactsRetriever = ContactsRetriever()
        contactsRetriever!!.execute()
    }

    private fun stopContactsRetriever() {
        if (contactsRetriever != null) {
            contactsRetriever!!.cancel(false)
        }
    }

    inner class ContactsRetriever : AsyncTask<Void?, Void?, List<ContactPerson>>() {

        override fun doInBackground(vararg params: Void?): List<ContactPerson> {
            val contactLst: MutableList<ContactPerson> = ArrayList()
            var cursor: Cursor? = null
            val cr = contentResolver
            val mProjection = arrayOf(
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.LOOKUP_KEY,
                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
            )
            val uri = ContactsContract.Contacts.CONTENT_URI
            cursor = cr.query(uri, mProjection, null, null, null)
            while (cursor.moveToNext()) {
                val person = ContactPerson()
                person.id = cursor.getString(0)
                person.lookupKey = cursor.getString(1)
                person.displayName = cursor.getString(2)
                contactLst.add(person)
            }
            return contactLst
        }

        override fun onPostExecute(contactPeople: List<ContactPerson>) {
            contactsRecyclerView.adapter = ContactsAdapter(contactPeople)
        }

    }

    companion object {
        private const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }
}
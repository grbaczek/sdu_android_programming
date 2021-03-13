package com.programming.android.sdu.contentproviderexercise

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val contactViewModel: ContactViewModel by viewModels()
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
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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
        contactViewModel.contactContentProvider = (application as ContactApplication).contactContentProvider
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

    inner class ContactsRetriever : AsyncTask<Void?, Void?, Void?>() {

        override fun doInBackground(vararg params: Void?): Void? {
            var cursor: Cursor? = null
            val cr = contentResolver
            val mProjection = arrayOf(
                    contactViewModel.getID(),
                    contactViewModel.getLookupKey(),
                    contactViewModel.getDisplayName()
            )
            val uri = contactViewModel.getContentURI()
            cursor = cr.query(uri, mProjection, null, null, null)
            while (cursor.moveToNext()) {
                val id = cursor.getString(0)
                val lookupKey = cursor.getString(1)
                val displayName = cursor.getString(2)
                contactViewModel.addContact(id, lookupKey, displayName)
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            contactsRecyclerView.adapter = ContactsAdapter(contactViewModel.getContacts())
        }

    }

    companion object {
        private const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }
}
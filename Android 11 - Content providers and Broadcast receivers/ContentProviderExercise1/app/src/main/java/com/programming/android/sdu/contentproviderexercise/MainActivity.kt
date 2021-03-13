package com.programming.android.sdu.contentproviderexercise

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cursoradapter.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var contactsList: ListView
    private var dataRetriever: DataRetriever? = null

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
        contactsList = findViewById(R.id.contactsLst)
        showContacts()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopDataReriever()
    }

    private fun stopDataReriever() {
        if (dataRetriever != null) {
            dataRetriever!!.cancel(false)
        }
    }

    private fun loadContacts() {
        stopDataReriever()
        dataRetriever = DataRetriever()
        dataRetriever!!.execute()
    }

    inner class DataRetriever : AsyncTask<Void?, Void?, Cursor>() {

        override fun doInBackground(vararg params: Void?): Cursor {
            val cr = contentResolver
            val mProjection = arrayOf(
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.LOOKUP_KEY,
                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
            )
            val uri = ContactsContract.Contacts.CONTENT_URI
            return cr.query(uri, mProjection, null, null, null)!!
        }

        override fun onPostExecute(cursor: Cursor) {
            val cursorColumns = arrayOf(
                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.LOOKUP_KEY)
            val viewIds = intArrayOf(R.id.tvColumn1, R.id.tvColumn2, R.id.tvColumn3)
            val simpleCursorAdapter = SimpleCursorAdapter(
                    this@MainActivity,
                    R.layout.contact_list_item,
                    cursor,
                    cursorColumns,
                    viewIds,
                    0)
            contactsList.adapter = simpleCursorAdapter
        }

    }

    companion object {
        private const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }
}
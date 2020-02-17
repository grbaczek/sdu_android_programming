package com.programming.android.sdu.contentproviderexercise;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView contactsList;
    DataRetriever dataRetriever;

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    private void showContacts() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            loadContacts();
            // Android version is lesser than 6.0 or the permission is already granted.
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                showContacts();
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsList = findViewById(R.id.contactsLst);
        showContacts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopDataReriever();
    }

    private void stopDataReriever() {
        if (dataRetriever != null) {
            dataRetriever.cancel(false);
        }
    }

    private void loadContacts() {
        stopDataReriever();
        dataRetriever = new DataRetriever();
        dataRetriever.execute();
    }

    class DataRetriever extends AsyncTask<Void,Void, Cursor>{
        @Override
        protected Cursor doInBackground(Void... voids) {
            Cursor cur = null;
            ContentResolver cr = getContentResolver();

            String[] mProjection =
                    {
                            ContactsContract.Contacts._ID,
                            ContactsContract.Contacts.LOOKUP_KEY,
                            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
                    };

            Uri uri = ContactsContract.Contacts.CONTENT_URI;


            return cr.query(uri, mProjection, null, null, null);

        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            String[] cursorColumns =
                    {
                            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
                            ContactsContract.Contacts._ID,
                            ContactsContract.Contacts.LOOKUP_KEY,
                    };

            int[] viewIds = {R.id.tvColumn1, R.id.tvColumn2, R.id.tvColumn3};
            SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(
                    MainActivity.this,
                    R.layout.contact_list_item,
                    cursor,
                    cursorColumns,
                    viewIds,
                    0);

            contactsList.setAdapter(simpleCursorAdapter);
        }
    }
}

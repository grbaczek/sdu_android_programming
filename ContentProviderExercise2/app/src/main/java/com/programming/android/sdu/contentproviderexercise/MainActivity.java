package com.programming.android.sdu.contentproviderexercise;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.ContactsContract;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactsRecyclerView;
    contactsRetriever contactsRetriever;

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
        contactsRecyclerView = findViewById(R.id.contactsLst);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        contactsRecyclerView.setLayoutManager(layoutManager);

        showContacts();
    }

    private void loadContacts() {
        stopContactsRetriever();
        contactsRetriever = new contactsRetriever();
        contactsRetriever.execute();
    }

    private void stopContactsRetriever(){
        if(contactsRetriever != null){
            contactsRetriever.cancel(false);
        }
    }

    class contactsRetriever extends AsyncTask<Void, Void, List<ContactPerson>>{
        @Override
        protected List<ContactPerson> doInBackground(Void... voids) {
            List<ContactPerson> contactLst  = new ArrayList<>();
            Cursor cursor = null;
            ContentResolver cr = getContentResolver();

            String[] mProjection =
                    {
                            ContactsContract.Contacts._ID,
                            ContactsContract.Contacts.LOOKUP_KEY,
                            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
                    };

            Uri uri = ContactsContract.Contacts.CONTENT_URI;


            cursor = cr.query(uri, mProjection, null, null, null);




            while (cursor.moveToNext()){
                ContactPerson person = new ContactPerson();
                person.id = cursor.getString(0);
                person.lookupKey = cursor.getString(1);
                person.displayName = cursor.getString(2);
                contactLst.add(person);
            }

            return contactLst;
        }

        @Override
        protected void onPostExecute(List<ContactPerson> contactPeople) {
            contactsRecyclerView.setAdapter(new ContactsAdapter(contactPeople));
        }
    }
}

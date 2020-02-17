package com.programming.android.sdu.databaseexercise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.programming.android.sdu.databaseexercise.database.AppDatabase;
import com.programming.android.sdu.databaseexercise.database.User;

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */

public class BaseActivity extends AppCompatActivity {

    protected  AppDatabase db;
    protected User currentUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = AppDatabase.getAppDatabase(this);
        if(db.userDao().countUsers() == 0){
            currentUser = new User();
            currentUser.uid = 1;
            currentUser.address = "";
            currentUser.dateOfBirth = 0;
            currentUser.name = "";
            db.userDao().insert(currentUser);
        }
        else{
            currentUser = db.userDao().getUser();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

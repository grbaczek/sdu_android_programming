package com.programming.android.sdu.databaseexercise.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */

@Entity(tableName = "user")
public class User {
    @PrimaryKey
    public int uid;
    public String name;
    public String address;
    public long dateOfBirth;

}

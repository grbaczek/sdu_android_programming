package com.programming.android.sdu.databaseexercise.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by grzegorzbaczek on 10/03/2018.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user where uid = 1")
    User getUser();

    @Update
    int update(User user);

    @Insert
    void insert(User user);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

}

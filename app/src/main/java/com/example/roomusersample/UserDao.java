package com.example.roomusersample;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(User user);

    @Query("DELETE FROM user_table")
    void deleteAllUser();

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();
}

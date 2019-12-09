package com.example.roomusersample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    private String mUsername;

    public User(@NonNull String mUsername){
        this.mUsername = mUsername;
    }

    public String getUsername(){return  mUsername;}

}

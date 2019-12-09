package com.example.roomusersample;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {
    private UserDao mUserDao;
    private LiveData<List<User>> allUsers;

    UserRepository(Application application){
        UserRoomDatabase db = UserRoomDatabase.getUserRoomDatabase(application);
        mUserDao = db.userDao();
        allUsers = mUserDao.getAllUsers();
    }

    LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public void insert(User user){
        new insertAsyncTask(mUserDao).execute(user);
    }

    public static class insertAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao mAsyncTasKDao;

        insertAsyncTask(UserDao dao){
            mAsyncTasKDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params){
            mAsyncTasKDao.insertUser(params[0]);
            return null;
        }
    }
}

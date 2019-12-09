package com.example.roomusersample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {User.class} ,version = 1 ,exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase
{
    public abstract UserDao userDao();
    private static UserRoomDatabase INSTANCE;

    static UserRoomDatabase getUserRoomDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (UserRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class,"user_table")
                            .fallbackToDestructiveMigration()
                            .build();


                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao mDao;
        String[] users = {"dolphin", "crocodile", "cobra"};

        PopulateDbAsync(UserRoomDatabase db) {
            mDao = db.userDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            mDao.deleteAllUser();

            for (int i = 0; i <= users.length - 1; i++) {
                User user = new User(users[i]);
                mDao.insertUser(user);
            }
            return null;
        }
    }

}

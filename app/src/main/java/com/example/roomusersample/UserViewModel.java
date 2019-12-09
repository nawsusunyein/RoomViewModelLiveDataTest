package com.example.roomusersample;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UserViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;
    private LiveData<List<User>> allUserList;

    public UserViewModel(Application application){
        super(application);
        mUserRepository = new UserRepository(application);
        allUserList = mUserRepository.getAllUsers();

    }

    LiveData<List<User>> getAllUserList(){return  allUserList;}

    public void insert(User user){
        mUserRepository.insert(user);
    }
}

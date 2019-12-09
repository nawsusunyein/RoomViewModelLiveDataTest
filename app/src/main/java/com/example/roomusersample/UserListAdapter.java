package com.example.roomusersample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder>{

    private final LayoutInflater mInflater;
    List<User> userList;

    UserListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycler_view_item,parent,false);
        return new UserListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        if(userList != null){
            User current = userList.get(position);
            holder.textUserView.setText(current.getUsername());
        }else{
            holder.textUserView.setText("No user list");
        }
    }

    void setUserList(List<User> users){
        userList = users;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(userList != null){
            return userList.size();
        }
        return 0;

    }

    class UserListViewHolder extends RecyclerView.ViewHolder {

        private final TextView textUserView;

        private UserListViewHolder(View itemView){
            super(itemView);
            textUserView = itemView.findViewById(R.id.textUserName);
        }
    }
}

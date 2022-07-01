package com.example.freetrip.databean;

import androidx.annotation.Nullable;

public class UserWrapper {
    private User user;
    private static UserWrapper instance=new UserWrapper();

    public static UserWrapper getInstance(){
        return instance;
    }

    @Nullable
    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }
}

package com.example.freetrip.ui.login.model;

import com.example.freetrip.databean.User;

public interface DataSource {

    interface LoadLoginCallBack{
        void onLoginLoded();

        void onDataNotAvailable();

        void onFailure();
    }

    void getLoginStatus(User user, LoadLoginCallBack loadLoginCallBack);

    void getRegisterStatus(User user, LoadLoginCallBack loadLoginCallBack);
}

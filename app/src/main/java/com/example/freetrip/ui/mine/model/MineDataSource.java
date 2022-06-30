package com.example.freetrip.ui.mine.model;

import com.example.freetrip.ui.login.model.databean.User;

public interface MineDataSource {

    interface LoadLoginCallBack{
        void onLoginLoded(String data);

        void onDataNotAvailable();

        void onFailure();
    }

    void getPraStatus(User user, LoadLoginCallBack loadLoginCallBack);

}

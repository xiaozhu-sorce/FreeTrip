package com.example.freetrip.ui.mine.model;


import com.example.freetrip.net.NetUtil;
import com.example.freetrip.ui.login.model.DataSource;
import com.example.freetrip.ui.login.model.databean.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MineRemoteRepository implements MineDataSource {
    private static MineRemoteRepository INSTANCE;

    public static MineRemoteRepository getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MineRemoteRepository();
        }
        return INSTANCE;
    }


    @Override
    public void getPraStatus(User user, LoadLoginCallBack loadLoginCallBack) {
        NetUtil.getInstance().getApi().getMyPra(String.valueOf(user.getId())).enqueue(new Callback<MyPraResponse>() {
            @Override
            public void onResponse(Call<MyPraResponse> call, Response<MyPraResponse> response) {
                if (response.body().getCode().equals("200")) loadLoginCallBack.onLoginLoded(response.body().getData());
                else loadLoginCallBack.onDataNotAvailable();
            }

            @Override
            public void onFailure(Call<MyPraResponse> call, Throwable t) {
                loadLoginCallBack.onFailure();
            }
        });
    }
}

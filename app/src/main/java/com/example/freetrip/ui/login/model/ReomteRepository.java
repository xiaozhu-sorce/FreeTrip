package com.example.freetrip.ui.login.model;

import com.example.freetrip.net.NetUtil;
import com.example.freetrip.ui.login.model.databean.LoginResponse;
import com.example.freetrip.ui.login.model.databean.RegisterResponse;
import com.example.freetrip.ui.login.model.databean.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReomteRepository implements DataSource {
    private static ReomteRepository INSTANCE;

    public static ReomteRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new ReomteRepository();
        }
        return INSTANCE;
    }


    @Override
    public void getLoginStatus(User user, LoadLoginCallBack loadLoginCallBack) {
        NetUtil.getInstance().getApi().login(user).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getMsg().equals("ok")){
                    loadLoginCallBack.onLoginLoded();
                }else{
                    loadLoginCallBack.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loadLoginCallBack.onFailure();
            }
        });
    }

    @Override
    public void getRegisterStatus(User user, LoadLoginCallBack loadLoginCallBack) {
        NetUtil.getInstance().getApi().register(user).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body().getCode().equals("200")){
                    loadLoginCallBack.onLoginLoded();
                }else{
                    loadLoginCallBack.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                loadLoginCallBack.onFailure();
            }
        });
    }
}

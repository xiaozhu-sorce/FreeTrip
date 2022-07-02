package com.example.freetrip.ui.mine.model;


import com.example.freetrip.databean.BlogResponse;
import com.example.freetrip.net.NetUtil;
import com.example.freetrip.ui.login.model.databean.RegisterResponse;
import com.example.freetrip.databean.User;

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
    public void getPraStatus(User user, LoadPraCallBack loadLoginCallBack) {
        NetUtil.getInstance().getApi().getMyPra(String.valueOf(user.getId())).enqueue(new Callback<MyPraResponse>() {
            @Override
            public void onResponse(Call<MyPraResponse> call, Response<MyPraResponse> response) {
                assert response.body() != null;
                if (response.body().getCode() == 200)
                    loadLoginCallBack.onLoginLoded(response.body().getData());
                else loadLoginCallBack.onDataNotAvailable();
            }

            @Override
            public void onFailure(Call<MyPraResponse> call, Throwable t) {
                loadLoginCallBack.onFailure();
            }
        });
    }

    @Override
    public void setNameStatus(User user, LoadCallBack loadCallBack) {
        NetUtil.getInstance().getApi().setName(user).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body() != null && response.body().getCode() == 200)
                    loadCallBack.onLoginLoded();
                else loadCallBack.onDataNotAvailable();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                loadCallBack.onFailure();
            }
        });
    }

    @Override
    public void getMyBlogListStatus(User user, MyBlogListCallBack callBack) {
        NetUtil.getInstance().getApi().getMyBlogList(user).enqueue(new Callback<BlogResponse>() {
            @Override
            public void onResponse(Call<BlogResponse> call, Response<BlogResponse> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    callBack.setList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteUserStatus(String id, DeleteUserCallBack callBack){
        NetUtil.getInstance().getApi().writeOff(id).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body()!=null && response.body().getCode() == 200){
                    callBack.jump();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleBolgStatus(String id,DeleteBlogCallback callback) {
        NetUtil.getInstance().getApi().deleteBlog(id).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body()!=null && response.body().getCode() == 200){
                    callback.notice();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }
}

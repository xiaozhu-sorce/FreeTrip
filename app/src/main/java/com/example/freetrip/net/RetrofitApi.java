package com.example.freetrip.net;

import com.example.freetrip.ui.login.model.databean.LoginResponse;
import com.example.freetrip.ui.login.model.databean.RegisterResponse;
import com.example.freetrip.ui.login.model.databean.User;
import com.example.freetrip.ui.mine.model.MyPraResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApi {

    @POST("user/login")
    Call<LoginResponse> login(@Body User user);

    @POST("user/register")
    Call<RegisterResponse> register(@Body User user);

    @GET("user/pra/{id}")
    Call<MyPraResponse> getMyPra(@Path("id") String id);
}

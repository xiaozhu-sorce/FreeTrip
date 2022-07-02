package com.example.freetrip.net;

import com.example.freetrip.databean.Blog;
import com.example.freetrip.databean.BlogResponse;
import com.example.freetrip.databean.RouteResponse;
import com.example.freetrip.databean.User;
import com.example.freetrip.ui.login.model.databean.LoginResponse;
import com.example.freetrip.ui.login.model.databean.RegisterResponse;
import com.example.freetrip.ui.mine.model.MyPraResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApi {

    @POST("user/login")
    Call<LoginResponse> login(@Body User user);

    @POST("user/register")
    Call<RegisterResponse> register(@Body User user);

    @DELETE("user/delete/{id}")
    Call<RegisterResponse> writeOff(@Path("id") String id);

    @GET("user/pra/{id}")
    Call<MyPraResponse> getMyPra(@Path("id") String id);

    @POST("user/setname")
    Call<RegisterResponse> setName(@Body User user);

    @POST("myblog/search")
    Call<BlogResponse> getMyBlogList(@Body User user);

    @GET("tour/list")
    Call<BlogResponse> getBlogList();

    @POST("tour/blog/add")
    Call<RegisterResponse> addBlog(@Body Blog blog);

    @POST("tour/blog/pra")
    Call<RegisterResponse> thumbUp(@Body Blog blog);

    @DELETE("myblog/delete/{id}")
    Call<RegisterResponse> deleteBlog(@Path("id") String id);

    @GET("home/search/{city}")
    Call<RouteResponse> getRouteList(@Path("city") String city);
}

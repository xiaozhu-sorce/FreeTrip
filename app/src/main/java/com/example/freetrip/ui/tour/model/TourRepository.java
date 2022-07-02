package com.example.freetrip.ui.tour.model;

import com.example.freetrip.databean.Blog;
import com.example.freetrip.databean.BlogResponse;
import com.example.freetrip.net.NetUtil;
import com.example.freetrip.ui.login.model.databean.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TourRepository implements TourDataSource {
    private static TourRepository INSTANCE;

    public static TourRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new TourRepository();
        return INSTANCE;
    }

    @Override
    public void getBlogStatus(AllBlogCallBack getBlogCallBack) {
        NetUtil.getInstance().getApi().getBlogList().enqueue(new Callback<BlogResponse>() {
            @Override
            public void onResponse(Call<BlogResponse> call, Response<BlogResponse> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    getBlogCallBack.setBolg(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void addBlogStatus(Blog blog, AddBlogCallBack callBack) {
        NetUtil.getInstance().getApi().addBlog(blog).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    callBack.add();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void thumbUpStatus(Blog blog, PraCallBack praCallBack) {
        NetUtil.getInstance().getApi().thumbUp(blog).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    praCallBack.thumb();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }

}

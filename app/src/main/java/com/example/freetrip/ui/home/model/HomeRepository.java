package com.example.freetrip.ui.home.model;

import com.example.freetrip.databean.RouteResponse;
import com.example.freetrip.net.NetUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository implements HomeDataSource {
    private static HomeRepository INSTANCE;

    public static HomeRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new HomeRepository();
        return INSTANCE;
    }


    @Override
    public void getRouteStatus(String city, RouteCallBack callBack) {
        NetUtil.getInstance().getApi().getRouteList(city).enqueue(new Callback<RouteResponse>() {
            @Override
            public void onResponse(Call<RouteResponse> call, Response<RouteResponse> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    callBack.getRoute(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<RouteResponse> call, Throwable t) {

            }
        });
    }
}

package com.example.freetrip.ui.home.model;

import com.example.freetrip.databean.Route;

import java.util.List;

public interface HomeDataSource {
    interface RouteCallBack{
        void getRoute(List<Route> routeList);
    }
    void getRouteStatus(String city,RouteCallBack callBack);
}

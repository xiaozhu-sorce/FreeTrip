package com.example.freetrip.ui.home.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freetrip.databean.Route;
import com.example.freetrip.ui.home.model.HomeDataSource;
import com.example.freetrip.ui.home.model.HomeRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteViewModel extends ViewModel {
    private HomeRepository repository;
    private final MutableLiveData<List<Route>> routeLiveData;
    private List<Route> routeList = new ArrayList<>();

    public RouteViewModel() {
        repository = HomeRepository.getINSTANCE();
        routeLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Route>> getRouteLiveData() {
        return routeLiveData;
    }

    public void populateList(String city){
        repository.getRouteStatus(city, new HomeDataSource.RouteCallBack() {
            @Override
            public void getRoute(List<Route> routeList1) {
                routeList = routeList1;
                routeLiveData.postValue(routeList);
            }
        });
    }
}

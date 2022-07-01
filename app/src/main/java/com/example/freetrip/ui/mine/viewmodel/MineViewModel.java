package com.example.freetrip.ui.mine.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.freetrip.databean.UserWrapper;
import com.example.freetrip.ui.mine.model.MineDataSource;
import com.example.freetrip.ui.mine.model.MineRemoteRepository;


public class MineViewModel extends ViewModel {
    private MineRemoteRepository repository;
    private final MutableLiveData<String> myPra;

    public MineViewModel() {
        myPra = new MutableLiveData<>();
        repository = MineRemoteRepository.getINSTANCE();
    }

    public MutableLiveData<String> getMyPra() {
        return myPra;
    }

    public void getPra() {
        repository.getPraStatus(UserWrapper.getInstance().getUser(), new MineDataSource.LoadPraCallBack() {
            @Override
            public void onLoginLoded(String data) {
                myPra.setValue(data);
            }

            @Override
            public void onDataNotAvailable() {

            }

            @Override
            public void onFailure() {

            }
        });
    }

    public void setName(Context context) {
        repository.setNameStatus(UserWrapper.getInstance().getUser(), new MineDataSource.LoadCallBack() {
            @Override
            public void onLoginLoded() {
                Toast.makeText(context, "改名成功！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDataNotAvailable() {

            }

            @Override
            public void onFailure() {

            }
        });
    }
}
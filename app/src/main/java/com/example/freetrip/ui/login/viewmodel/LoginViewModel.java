package com.example.freetrip.ui.login.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.freetrip.ui.login.model.DataSource;
import com.example.freetrip.ui.login.model.ReomteRepository;
import com.example.freetrip.databean.User;

public class LoginViewModel extends AndroidViewModel {

    private ReomteRepository repository;
    private MutableLiveData<User> userData;
    private Context mContext;
    private User user;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getApplicationContext();
        userData = new MutableLiveData<>();
        repository = ReomteRepository.getINSTANCE();
    }

    public MutableLiveData<User> getUserData() {
        return userData;
    }


    public void signIn(String name , String password){
        repository.getLoginStatus(user = new User(name,password), new DataSource.LoadLoginCallBack() {
            @Override
            public void onLoginLoded() {
                userData.postValue(user);
            }

            @Override
            public void onDataNotAvailable() {
                Toast.makeText(mContext,"账号或密码错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(mContext,"请检查网络设置", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sighUp(String name,String passwprd){
        repository.getRegisterStatus(user = new User(name, passwprd), new DataSource.LoadLoginCallBack() {
            @Override
            public void onLoginLoded() {
                userData.postValue(user);
                Toast.makeText(mContext,"注册成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDataNotAvailable() {
                Toast.makeText(mContext,"注册失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(mContext,"请检查网络设置", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

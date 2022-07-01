package com.example.freetrip.ui.mine.model;

import com.example.freetrip.databean.Blog;
import com.example.freetrip.databean.User;
import com.example.freetrip.ui.tour.model.TourDataSource;

import java.util.List;

public interface MineDataSource {

    interface LoadPraCallBack {
        void onLoginLoded(String data);

        void onDataNotAvailable();

        void onFailure();
    }

    interface LoadCallBack {
        void onLoginLoded();

        void onDataNotAvailable();

        void onFailure();
    }

    interface MyBlogListCallBack{
        void setList(List<Blog> blogList);
    }

    interface DeleteUserCallBack {
        void jump();
    }

    interface DeleteBlogCallback{
        void notice();
    }


    void getPraStatus(User user, LoadPraCallBack loadLoginCallBack);

    void setNameStatus(User user, LoadCallBack loadNameCallBack);

    void getMyBlogListStatus(User user,MyBlogListCallBack callBack);

    void deleteUserStatus(String id, DeleteUserCallBack callBack);

    void deleBolgStatus(String id,DeleteBlogCallback callback);
}

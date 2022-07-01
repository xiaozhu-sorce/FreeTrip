package com.example.freetrip.ui.tour.model;

import com.example.freetrip.databean.Blog;

import java.util.List;

public interface TourDataSource {
    interface AllBlogCallBack {
        void setBolg(List<Blog> blogList);
    }

    interface AddBlogCallBack {
        void add();
    }

    interface PraCallBack {
        void thumb();
    }

    void getBlogStatus(AllBlogCallBack getBlogCallBack);

    void addBlogStatus(Blog blog, AddBlogCallBack callBack);

    void thumbUpStatus(Blog blog,PraCallBack praCallBack);
}

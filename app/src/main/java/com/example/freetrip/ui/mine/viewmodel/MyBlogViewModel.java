package com.example.freetrip.ui.mine.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freetrip.databean.Blog;
import com.example.freetrip.databean.UserWrapper;
import com.example.freetrip.ui.mine.model.MineDataSource;
import com.example.freetrip.ui.mine.model.MineRemoteRepository;
import com.example.freetrip.ui.mine.view.myblog.MyBlogAdapterCallBack;

import java.util.ArrayList;
import java.util.List;

public class MyBlogViewModel extends ViewModel implements MyBlogAdapterCallBack {
    private MineRemoteRepository repository;

    private final MutableLiveData<List<Blog>> blogLiveData;

    private List<Blog> blogArrayList = new ArrayList<>();

    public MyBlogViewModel() {
        blogLiveData = new MutableLiveData<List<Blog>>();
        repository = MineRemoteRepository.getINSTANCE();
    }

    public MutableLiveData<List<Blog>> getBlogLiveData() {
        return blogLiveData;
    }


    public void populateList() {
        repository.getMyBlogListStatus(UserWrapper.getInstance().getUser(), new MineDataSource.MyBlogListCallBack() {
            @Override
            public void setList(List<Blog> blogList) {
                blogArrayList = blogList;
                blogLiveData.postValue(blogArrayList);
            }
        });
    }

    @Override
    public void deleleBlog(String id) {
        repository.deleBolgStatus(id, new MineDataSource.DeleteBlogCallback() {
            @Override
            public void notice() {
                populateList();
            }
        });
    }
}

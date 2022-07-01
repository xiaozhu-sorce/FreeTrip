package com.example.freetrip.ui.tour.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.freetrip.databean.Blog;
import com.example.freetrip.ui.tour.model.TourDataSource;
import com.example.freetrip.ui.tour.model.TourRepository;
import com.example.freetrip.ui.tour.view.AdapterCallBack;

import java.util.ArrayList;
import java.util.List;

public class TourViewModel extends AndroidViewModel implements AdapterCallBack {
    private TourRepository repository;

    private final MutableLiveData<List<Blog>> blogLiveData;

    private Context context;

    private List<Blog> blogArrayList = new ArrayList<>();

    public TourViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        repository = TourRepository.getINSTANCE();
        blogLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Blog>> getBlogLiveData() {
        return blogLiveData;
    }

    public void populateList() {
        repository.getBlogStatus(new TourDataSource.AllBlogCallBack() {
            @Override
            public void setBolg(List<Blog> blogList) {
                blogArrayList = blogList;
                blogLiveData.postValue(blogArrayList);
            }
        });
    }

    @Override
    public void dianzan(int id) {
        repository.thumbUpStatus(new Blog(id), new TourDataSource.PraCallBack() {
            @Override
            public void thumb() {
                Toast.makeText(context,"点赞成功！",Toast.LENGTH_LONG).show();
            }
        });
    }
}
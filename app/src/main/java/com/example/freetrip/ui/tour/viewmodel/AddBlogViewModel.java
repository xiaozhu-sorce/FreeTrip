package com.example.freetrip.ui.tour.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freetrip.databean.Blog;
import com.example.freetrip.databean.UserWrapper;
import com.example.freetrip.ui.tour.model.TourDataSource;
import com.example.freetrip.ui.tour.model.TourRepository;

public class AddBlogViewModel extends ViewModel {

    private MutableLiveData<String> content;
    private TourRepository repository;

    public AddBlogViewModel(){
        content = new MutableLiveData<>();
        repository = TourRepository.getINSTANCE();
    }

    public MutableLiveData<String> getContent() {
        return content;
    }

    public void send(String content, Context mContext){
        repository.addBlogStatus(new Blog(content, UserWrapper.getInstance().getUser().getId()), new TourDataSource.AddBlogCallBack() {
            @Override
            public void add() {
                Toast.makeText(mContext,"添加成功", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

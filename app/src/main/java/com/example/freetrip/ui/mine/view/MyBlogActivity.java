package com.example.freetrip.ui.mine.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.R;
import com.example.freetrip.databinding.ActivityAddblogBinding;
import com.example.freetrip.databinding.ActivityMineBlogBinding;
import com.example.freetrip.ui.mine.viewmodel.MineViewModel;
import com.example.freetrip.ui.tour.view.BlogRecyclerViewAdapter;

public class MyBlogActivity extends AppCompatActivity {

    private ActivityMineBlogBinding binding;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MineViewModel mineViewModel = new ViewModelProvider(this).get(MineViewModel.class);

        binding = ActivityMineBlogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = binding.rvMyblogs;

        recyclerViewAdapter = new RecyclerViewAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);

        mineViewModel.getBlogLiveData().observe(this,recyclerViewAdapter::updateBlogList);

        this.getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}

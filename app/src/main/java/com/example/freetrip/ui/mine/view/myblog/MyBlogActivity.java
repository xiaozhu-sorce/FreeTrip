package com.example.freetrip.ui.mine.view.myblog;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.databean.UserWrapper;
import com.example.freetrip.databinding.ActivityMineBlogBinding;
import com.example.freetrip.ui.mine.viewmodel.MyBlogViewModel;

public class MyBlogActivity extends AppCompatActivity {

    private ActivityMineBlogBinding binding;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyBlogViewModel viewModel = new ViewModelProvider(this).get(MyBlogViewModel.class);

        binding = ActivityMineBlogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        name = binding.textName;
        name.setText(UserWrapper.getInstance().getUser().getName());

        recyclerView = binding.rvMyblogs;

        recyclerViewAdapter = new RecyclerViewAdapter(viewModel);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);

        viewModel.populateList();
        viewModel.getBlogLiveData().observe(this,recyclerViewAdapter::updateBlogList);

        this.getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}

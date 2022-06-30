package com.example.freetrip.ui.tour.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.databinding.FragmentTourBinding;
import com.example.freetrip.ui.mine.view.SettingActivity;
import com.example.freetrip.ui.tour.viewmodel.TourViewModel;


public class TourFragment extends Fragment {

    private FragmentTourBinding binding;
    private RecyclerView recyclerView;
    private BlogRecyclerViewAdapter recyclerViewAdapter;
    private ImageView addBlog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TourViewModel tourViewModel =
                new ViewModelProvider(this).get(TourViewModel.class);

        binding = FragmentTourBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.rvBlogs;
        addBlog = binding.btnAddBlog;
        addBlog.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AddBlogActivity.class));
        });
        recyclerViewAdapter = new BlogRecyclerViewAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);

        tourViewModel.getBlogLiveData().observe(getViewLifecycleOwner(),recyclerViewAdapter::updateBlogList);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
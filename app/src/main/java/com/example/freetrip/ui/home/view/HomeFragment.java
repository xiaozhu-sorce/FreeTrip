package com.example.freetrip.ui.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.freetrip.databinding.FragmentHomeBinding;
import com.example.freetrip.ui.home.viewmodel.HomeViewModel;
import com.example.freetrip.ui.home.model.BannerBean;
import com.youth.banner.Banner;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Banner banner;
    private Button travel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        banner = binding.homeBanner;
        banner.setAdapter(new BannerAdapter(BannerBean.getDefaultBanners()));

        travel = binding.btnTour;
        travel.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(),TravelActivity.class));
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
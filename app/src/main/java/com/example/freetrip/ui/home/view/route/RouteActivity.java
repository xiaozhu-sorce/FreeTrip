package com.example.freetrip.ui.home.view.route;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.databinding.ActivityRouteBinding;
import com.example.freetrip.ui.home.viewmodel.RouteViewModel;

public class RouteActivity extends AppCompatActivity {

    private ActivityRouteBinding binding;
    private RouteViewModel viewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private TextView locate;
    private String city;
    private ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RouteViewModel.class);

        binding = ActivityRouteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        back = binding.routeBack;
        back.setOnClickListener(v -> finish());

        Intent intent = getIntent();
        city = intent.getStringExtra("city");

        recyclerView = binding.rvRoutes;
        locate = binding.textLocate;
        locate.setText(city);

        adapter = new RecyclerViewAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        viewModel.populateList(city);
        viewModel.getRouteLiveData().observe(this, adapter::updateRouteList);

        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}

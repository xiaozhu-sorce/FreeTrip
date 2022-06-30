package com.example.freetrip.ui.home.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freetrip.databinding.ActivityTourRouteBinding;

public class TravelActivity extends AppCompatActivity {
    private ActivityTourRouteBinding binding;
    private Button beijing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTourRouteBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        beijing = binding.beijing;

        beijing.setOnClickListener(v -> {
            startActivity(new Intent(this,RouteActivity.class));
        });

        this.getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}

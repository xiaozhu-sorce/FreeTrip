package com.example.freetrip.ui.mine.view.travel;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freetrip.R;
import com.example.freetrip.databinding.ActivityMineTravelBinding;

public class MyTravelActivity extends AppCompatActivity {
    private ActivityMineTravelBinding binding;
    private CollectionDemoFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMineTravelBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        if(fragment == null)
            fragment = new CollectionDemoFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, fragment, "mainFragment")
                .commit();

        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}

package com.example.freetrip.ui.home.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freetrip.R;
import com.example.freetrip.databinding.ActivityTourRouteBinding;
import com.example.freetrip.ui.home.view.route.RouteActivity;

public class TravelActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityTourRouteBinding binding;
    private Button beijing, wuhan, chongqing, shanghai, chengdu, nanjing, xizang, dunhuang;
    private ImageButton back;
    String s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTourRouteBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        back = binding.travelRouteBack;

        beijing = binding.beijing;
        wuhan = binding.wuhan;
        chongqing = binding.chongqing;
        shanghai = binding.shanghai;
        chengdu = binding.chengdu;
        nanjing = binding.nanjing;
        xizang = binding.xizang;
        dunhuang = binding.dunhuang;

        back.setOnClickListener(this);
        beijing.setOnClickListener(this);
        wuhan.setOnClickListener(this);
        chongqing.setOnClickListener(this);
        shanghai.setOnClickListener(this);
        chengdu.setOnClickListener(this);
        nanjing.setOnClickListener(this);
        xizang.setOnClickListener(this);
        dunhuang.setOnClickListener(this);


        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.travel_route_back) {
            finish();
        } else {
            Button button = findViewById(view.getId());
            s = button.getText().toString();
            Intent intent = new Intent(TravelActivity.this, RouteActivity.class);
            intent.putExtra("city", s);
            startActivity(intent);
        }
    }
}

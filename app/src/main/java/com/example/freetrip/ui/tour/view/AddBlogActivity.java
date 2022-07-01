package com.example.freetrip.ui.tour.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.freetrip.databinding.ActivityAddblogBinding;
import com.example.freetrip.ui.tour.viewmodel.AddBlogViewModel;

public class AddBlogActivity extends AppCompatActivity {

    private EditText editText;
    private ActivityAddblogBinding binding;
    private AddBlogViewModel viewModel;
    private ImageButton mSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(AddBlogViewModel.class);
        binding = ActivityAddblogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mSend = binding.btnCheck;
        editText = binding.editBlog;

        mSend.setOnClickListener(v -> {
            viewModel.send(editText.getText().toString(),getApplicationContext());
        });

        this.getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }
}

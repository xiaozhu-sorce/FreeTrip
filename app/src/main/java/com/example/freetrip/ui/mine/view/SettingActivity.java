package com.example.freetrip.ui.mine.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freetrip.R;
import com.example.freetrip.databean.UserWrapper;
import com.example.freetrip.ui.login.views.LoginActivity;
import com.example.freetrip.ui.mine.model.MineDataSource;
import com.example.freetrip.ui.mine.model.MineRemoteRepository;

public class SettingActivity extends AppCompatActivity {
    private Button signOut,writeoff;
    private MineRemoteRepository repository = MineRemoteRepository.getINSTANCE();
    private ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        back = findViewById(R.id.set_back);
        back.setOnClickListener(v -> finish());

        signOut = findViewById(R.id.login_out);
        writeoff = findViewById(R.id.writeOff);

        signOut.setOnClickListener(view -> {
            UserWrapper.getInstance().setUser(null);
            startActivity(new Intent(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        writeoff.setOnClickListener(view -> {
            repository.deleteUserStatus(String.valueOf(UserWrapper.getInstance().getUser().getId()), new MineDataSource.DeleteUserCallBack() {
                @Override
                public void jump() {
                    Toast.makeText(getApplicationContext(),"注销成功",Toast.LENGTH_LONG);
                }
            });
            startActivity(new Intent(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            UserWrapper.getInstance().setUser(null);
        });

        this.getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().
                    setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}

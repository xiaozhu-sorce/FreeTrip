package com.example.freetrip.ui.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.freetrip.R;
import com.example.freetrip.databinding.FragmentMineBinding;
import com.example.freetrip.ui.mine.view.travel.MyTravelActivity;
import com.example.freetrip.ui.mine.viewmodel.MineViewModel;

public class MineFragment extends Fragment {

    private FragmentMineBinding binding;
    private TextView name;
    private TextView pra;
    private TextView setting;
    private TextView myblogs;
    private TextView mytravels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MineViewModel mineViewModel =
                new ViewModelProvider(this).get(MineViewModel.class);

        binding = FragmentMineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        name = binding.textName;
        pra = binding.textPranum;
        setting = binding.textSetting;
        myblogs = binding.textMyBlog;
        mytravels = binding.textMyTravel;


        name.setOnClickListener(v -> {
            showInputDialog();
        });

        setting.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), SettingActivity.class));
        });

        myblogs.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), MyBlogActivity.class));
        });

        mytravels.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), MyTravelActivity.class));
        });

        mineViewModel.getPra();
        mineViewModel.getMyPra().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                pra.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showInputDialog() {
        /*@setView 装入一个EditView
         */
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_modify_name, null, false);
        final PopupWindow popupWindow = new PopupWindow(v, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //参数为1.View 2.宽度 3.高度
        popupWindow.setOutsideTouchable(true);//设置点击外部区域可以取消popupWindow
        popupWindow.setFocusable(true);
        backgroundAlpha(0.5f);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });


        EditText editView = v.findViewById(R.id.username);
        Button button1 = v.findViewById(R.id.changeName_button1);
        Button button2 = v.findViewById(R.id.changeName_button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundAlpha(1.0f);
                popupWindow.dismiss();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editView.getText().toString().length() == 0 ) {
                    Toast.makeText(getActivity(),"名称不可以为空哦！",Toast.LENGTH_SHORT).show();
                }else{
                    name.setText(editView.getText().toString());
                    String name = editView.getText().toString();
                    //mUser.setName(name);
                    backgroundAlpha(1.0f);
                    popupWindow.dismiss();
                }

            }

        });

        popupWindow.showAtLocation(getActivity().getWindow().getDecorView(), Gravity.CENTER, 0, 0);

    }


    public void backgroundAlpha(float v) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = v; //0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }
}
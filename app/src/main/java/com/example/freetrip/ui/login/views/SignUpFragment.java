package com.example.freetrip.ui.login.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.freetrip.R;
import com.example.freetrip.databinding.FragmentSignUpBinding;
import com.example.freetrip.databean.User;
import com.example.freetrip.ui.login.viewmodel.LoginViewModel;


public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;
    private LoginViewModel loginViewModel;
    private EditText nameEdit, passEdit;
    private Button signUpBtn;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginViewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(LoginViewModel.class);

        loginViewModel.getUserData().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user!=null){
                    navController.navigate(R.id.action_signUpFragment_to_signInFragment);
                }
            }
        });

        binding = FragmentSignUpBinding.inflate(inflater, container, false);

        nameEdit = binding.etUsername;
        passEdit = binding.etPassword;
        signUpBtn = binding.btRegister;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        signUpBtn.setOnClickListener( v -> {
            String name = nameEdit.getText().toString();
            String pass = passEdit.getText().toString();

            if (!name.isEmpty() && !pass.isEmpty()){
                loginViewModel.sighUp(name , pass);
            }
        });

    }
}
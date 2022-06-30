package com.example.freetrip.ui.login.views;

import android.content.Intent;
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
import android.widget.TextView;

import com.example.freetrip.MainActivity;
import com.example.freetrip.R;
import com.example.freetrip.databinding.FragmentSignInBinding;
import com.example.freetrip.ui.login.model.databean.User;
import com.example.freetrip.ui.login.viewmodel.LoginViewModel;

public class SignInFragment extends Fragment {

    private FragmentSignInBinding binding;
    private LoginViewModel loginViewModel;
    private EditText nameEdit, passEdit;
    private Button signInBtn;
    private TextView signUpText;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginViewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(LoginViewModel.class);

        loginViewModel.getUserData().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user!=null){
                    startActivity(new Intent(getActivity(), MainActivity.class));
                }
            }
        });

        binding = FragmentSignInBinding.inflate(inflater, container, false);

        nameEdit = binding.etUsername;
        passEdit = binding.etPassword;
        signInBtn = binding.btLogin;
        signUpText = binding.textSignup;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        signUpText.setOnClickListener( v -> {
            navController.navigate(R.id.action_signInFragment_to_signUpFragment);
        });

        signInBtn.setOnClickListener( v -> {
            String name = nameEdit.getText().toString();
            String pass = passEdit.getText().toString();

            if (!name.isEmpty() && !pass.isEmpty()){
                loginViewModel.signIn(name , pass);
            }
        });

    }
}
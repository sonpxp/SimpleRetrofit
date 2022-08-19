package com.cloudxanh.simpleretrofit.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.cloudxanh.simpleretrofit.R;
import com.cloudxanh.simpleretrofit.databinding.FragmentLoginBinding;
import com.cloudxanh.simpleretrofit.ui.activity.MainActivity;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        handleView();
        return binding.getRoot();
    }

    private void handleView() {
        binding.btnLogin.setOnClickListener(view -> {
            String email = String.valueOf(binding.etEmail.getText());
            String pass = String.valueOf(binding.etEmail.getText());
            if (email.equals("admin") || pass.equals("admin")) {
                navigateToMain();
            } else {
                Toast.makeText(requireActivity(), "Nhập sai account, tk = admin, mk = admin", Toast.LENGTH_LONG).show();
            }
        });

        binding.btnSignup.setOnClickListener(view -> {
            navigateToSignUp();
        });

        binding.tvForgotPassword.setOnClickListener(view -> {
            navigateToForgotPassword();
        });
    }

    private void navigateToMain() {
        Intent intent = new Intent(requireActivity(), MainActivity.class);
        startActivity(intent);
    }

    private void navigateToSignUp() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.to_signUpFragment);
    }

    private void navigateToForgotPassword() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.to_forgotPasswordFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
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
import com.cloudxanh.simpleretrofit.data.model.User;
import com.cloudxanh.simpleretrofit.databinding.FragmentLoginBinding;
import com.cloudxanh.simpleretrofit.ui.activity.MainActivity;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        // initial navController
        navController = NavHostFragment.findNavController(this);
        handleView();
        return binding.getRoot();
    }

    private void handleView() {
        binding.btnLogin.setOnClickListener(view -> {
            String email = String.valueOf(binding.etEmail.getText());
            String pass = String.valueOf(binding.etPassword.getText());
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
            // navigateToForgotPassword();

            // test pass data object
            String email = String.valueOf(binding.etEmail.getText());
            String pass = String.valueOf(binding.etPassword.getText());
            passObjectUserToForgotPassword(email, pass);
        });
    }

    private void navigateToMain() {
        Intent intent = new Intent(requireActivity(), MainActivity.class);
        startActivity(intent);
    }

    private void navigateToSignUp() {
        navController.navigate(R.id.to_signUpFragment);
    }

    private void navigateToForgotPassword() {
        // get email text
        String email = binding.etEmail.getText().toString().trim();

        // using bundle
        // The first way
        /*Bundle bundle = new Bundle();
        bundle.putString("email", email);
        Navigation.findNavController(view).navigate(R.id.to_forgotPasswordFragment, bundle);*/

        // using set an argument
        // 2nd way
        LoginFragmentDirections.ToForgotPasswordFragment action =
                LoginFragmentDirections.toForgotPasswordFragment();
        //action.setEmailArg(email);
        navController.navigate(action);
    }

    private void passObjectUserToForgotPassword(String email, String pass) {
        User user = new User(email, pass);
        LoginFragmentDirections.ToForgotPasswordFragment action =
                LoginFragmentDirections.toForgotPasswordFragment();
        action.setUser(user);
        navController.navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
package com.cloudxanh.simpleretrofit.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudxanh.simpleretrofit.R;
import com.cloudxanh.simpleretrofit.data.model.User;
import com.cloudxanh.simpleretrofit.databinding.FragmentForgotPasswordBinding;
import com.cloudxanh.simpleretrofit.databinding.FragmentLoginBinding;


public class ForgotPasswordFragment extends Fragment {

    private FragmentForgotPasswordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false);
        initialView();
        return binding.getRoot();
    }

    private void initialView(){
        // getDataFromBundle();
        getObjectUser();
    }

    private void getDataFromBundle() {
        // using get bundle
        // The first way
        if (getArguments() != null) {
            String emailBundle = getArguments().getString("email");
        }

        // using Args, getString
        // 2nd way
        // String email = ForgotPasswordFragmentArgs.fromBundle(getArguments()).getEmailArg();

        // update data to ui
        // binding.etEmail.setText(email);
    }

    private void getObjectUser(){
        User user = ForgotPasswordFragmentArgs.fromBundle(getArguments()).getUser();
        binding.tvEmailDetail.setText(user.getEmail());
        binding.tvPasswordDetail.setText(user.getPassword());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
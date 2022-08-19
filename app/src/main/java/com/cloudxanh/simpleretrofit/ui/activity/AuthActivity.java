package com.cloudxanh.simpleretrofit.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.cloudxanh.simpleretrofit.R;
import com.cloudxanh.simpleretrofit.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    private ActivityAuthBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupNavigationController();
    }

    private void setupNavigationController() {
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.auth_nav_host_container);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }
}
package com.cloudxanh.simpleretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cloudxanh.simpleretrofit.R;
import com.cloudxanh.simpleretrofit.databinding.ActivityDetailBinding;
import com.cloudxanh.simpleretrofit.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private PostViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        doInitialization(id);
    }

    private void doInitialization(int id) {
        binding.progressCircular.setVisibility(View.VISIBLE);
        if (id == -1) return;
        viewModel = new ViewModelProvider(this).get(PostViewModel.class);
        viewModel.getPost(id).observe(this, post -> {
            if (post != null) {
                // show loading
                binding.progressCircular.setVisibility(View.GONE);
                binding.llContainer.setVisibility(View.VISIBLE);
                // set data to ui
                binding.tvUserId.setText(String.valueOf(post.getUserId()));
                binding.tvId.setText(String.valueOf(post.getId()));
                binding.tvTitle.setText(post.getTitle());
                binding.tvBody.setText(post.getBody());
                binding.tvIdDetail.setText(String.valueOf(id));
            }
        });
    }
}
package com.cloudxanh.simpleretrofit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.cloudxanh.simpleretrofit.R;
import com.cloudxanh.simpleretrofit.data.model.Post;
import com.cloudxanh.simpleretrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PostViewModel viewModel;
    private PostAdapter postAdapter;
    ItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        doInitialization();
    }

    private void doInitialization() {
        viewModel = new ViewModelProvider(this).get(PostViewModel.class);
        viewModel.getListPost().observe(this, listPost -> {
            if (listPost != null) {
                Log.e("msg", listPost.toString());
                doInitialRecycleView(listPost);
            }
        });
    }

    private void doInitialRecycleView(List<Post> list) {
        postAdapter = new PostAdapter(list, this, handlerView());
        binding.rvPost.setHasFixedSize(true);
        binding.rvPost.setAdapter(postAdapter);
        binding.rvPost.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private ItemClickListener handlerView() {
        // TODO: initial java core
        // TODO: The first way
        listener = new ItemClickListener() {
            @Override
            public void onClickItemPost(int id) {
                // do something
            }
        };

        // TODO: merger lambda expression
        // TODO: 2nd way
        listener = id -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        };
        return listener;
    }
}
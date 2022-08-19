package com.cloudxanh.simpleretrofit.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.cloudxanh.simpleretrofit.R;
import com.cloudxanh.simpleretrofit.data.model.Post;
import com.cloudxanh.simpleretrofit.databinding.ActivityMainBinding;
import com.cloudxanh.simpleretrofit.ui.adapter.PostAdapter;
import com.cloudxanh.simpleretrofit.ui.listener.ItemClickListener;
import com.cloudxanh.simpleretrofit.ui.viewmodel.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        doInitialization();
    }

    private void doInitialization() {
        PostViewModel viewModel = new ViewModelProvider(this).get(PostViewModel.class);
        viewModel.getListPost().observe(this, listPost -> {
            if (listPost != null) {
                Log.e("msg", listPost.toString());
                doInitialRecycleView(listPost);
            }
        });
    }

    private void doInitialRecycleView(List<Post> list) {
        PostAdapter postAdapter = new PostAdapter(list, this, handlerView());
        binding.rvPost.setHasFixedSize(true);
        binding.rvPost.setAdapter(postAdapter);
        binding.rvPost.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private ItemClickListener handlerView() {
        // TODO: merger lambda expression
        // TODO: 2nd way
        ItemClickListener listener = id -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        };
        return listener;
    }
}
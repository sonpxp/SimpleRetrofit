package com.cloudxanh.simpleretrofit.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudxanh.simpleretrofit.data.model.Post;
import com.cloudxanh.simpleretrofit.databinding.ItemPostBinding;

import java.util.List;

/**
 * Created by sonpxp on 8/19/2022.
 * Email: sonmob202@gmail.com
 */

interface ItemClickListener {
    void onClickItemPost(int id);
}

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> listPost;
    private Context context;
    private ItemClickListener listener;

    public PostAdapter(List<Post> listPost, Context context, ItemClickListener listener) {
        this.listPost = listPost;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        Post post = listPost.get(position);
        // should not concatenate strings like this example
        holder.binding.tvUserId.setText("User ID: "+String.valueOf(post.getUserId()));
        holder.binding.tvId.setText("ID: "+String.valueOf(post.getId()));
        holder.binding.tvTitle.setText("Title: "+post.getTitle());
        holder.binding.tvBody.setText("Body: "+post.getBody());
        holder.binding.getRoot().setOnClickListener(view -> {
            listener.onClickItemPost(post.getId());
        });
    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding;

        public PostViewHolder(ItemPostBinding bindView) {
            super(bindView.getRoot());
            binding = bindView;
        }
    }
}


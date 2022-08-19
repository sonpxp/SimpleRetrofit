package com.cloudxanh.simpleretrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cloudxanh.simpleretrofit.data.model.Post;
import com.cloudxanh.simpleretrofit.data.repository.PostRepository;

import java.util.List;

/**
 * Created by sonpxp on 8/19/2022.
 * Email: sonmob202@gmail.com
 */
public class PostViewModel extends ViewModel {

    private final PostRepository postRepository;

    public PostViewModel() {
        postRepository = new PostRepository();
    }

    public LiveData<List<Post>> getListPost() {
        return postRepository.getListPost();
    }

    public LiveData<Post> getPost(int id) {
        return postRepository.getPost(id);
    }
}

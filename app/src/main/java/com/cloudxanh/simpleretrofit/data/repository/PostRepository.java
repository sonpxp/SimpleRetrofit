package com.cloudxanh.simpleretrofit.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cloudxanh.simpleretrofit.data.api.ApiClient;
import com.cloudxanh.simpleretrofit.data.api.ApiService;
import com.cloudxanh.simpleretrofit.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sonpxp on 8/19/2022.
 * Email: sonmob202@gmail.com
 */
public class PostRepository {

    private final ApiService apiService;
    MutableLiveData<List<Post>> listPostLiveData = new MutableLiveData<>();
    MutableLiveData<Post> postLiveData = new MutableLiveData<>();

    public PostRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    // get all post
    public LiveData<List<Post>> getListPost() {
        apiService.getListPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    listPostLiveData.setValue(response.body());
                } else {
                    listPostLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, Throwable t) {
                listPostLiveData.setValue(null);
            }
        });
        return listPostLiveData;
    }

    // get 1 post by id
    public LiveData<Post> getPost(int id) {
        apiService.getPost(id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    postLiveData.setValue(response.body());
                } else {
                    postLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                postLiveData.setValue(null);
            }
        });
        return postLiveData;
    }
}

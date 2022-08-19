package com.cloudxanh.simpleretrofit.data.api;

import com.cloudxanh.simpleretrofit.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sonpxp on 8/19/2022.
 * Email: sonmob202@gmail.com
 */
public interface ApiService {

    @GET("posts")
    Call<List<Post>> getListPost();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int id);
}

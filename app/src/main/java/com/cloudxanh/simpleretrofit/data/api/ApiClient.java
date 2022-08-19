package com.cloudxanh.simpleretrofit.data.api;

import com.cloudxanh.simpleretrofit.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sonpxp on 8/19/2022.
 * Email: sonmob202@gmail.com
 */
public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

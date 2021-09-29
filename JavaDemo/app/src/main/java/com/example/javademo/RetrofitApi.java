package com.example.javademo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static RetrofitApi apiInstance = null;
    private final PostApi postApi;

    private RetrofitApi() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(PostApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postApi = retrofit.create(PostApi.class);
    }

    public static RetrofitApi getApiInstance() {
        if (apiInstance == null) {
            apiInstance = new RetrofitApi();
        }
        return apiInstance;
    }

    public PostApi getPostApi() {
        return this.postApi;
    }
}

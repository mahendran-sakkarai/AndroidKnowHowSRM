package com.example.kotlindemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private var postApi: PostApi

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(PostApi.Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postApi = retrofit.create(PostApi::class.java)
    }

    fun getPostApi() : PostApi {
        return postApi
    }
}
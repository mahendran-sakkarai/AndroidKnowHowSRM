package com.example.kotlindemo

import retrofit2.Call
import retrofit2.http.GET

interface PostApi {
    object Const {
        val BASE_URL: String
            get() = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    fun getPosts(): Call<List<Post>>
}
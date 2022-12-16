package com.example.exam.model.api

import com.example.exam.model.database.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}
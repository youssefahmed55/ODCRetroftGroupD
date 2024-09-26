package com.example.odcretroftgroupd

import com.example.odcretroftgroupd.pojo.PostModelResonseItem
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApi {
    @GET("posts")
    suspend fun getPosts(): List<PostModelResonseItem>

    @GET("posts/{id}")
    suspend fun getPostsById(@Path("id") id : Int) : PostModelResonseItem
}
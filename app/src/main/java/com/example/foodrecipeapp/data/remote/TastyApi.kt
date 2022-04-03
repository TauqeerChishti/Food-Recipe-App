package com.example.foodrecipeapp.data.remote

import com.example.foodrecipeapp.Model.TastyItem
import retrofit2.http.GET
import retrofit2.http.Query

interface TastyApi {
    @GET("https://tasty.p.rapidapi.com/recipes/list")
    suspend fun searchrecipe(
        @Query(value = "from", encoded = true) from: Int,
        @Query(value = "size", encoded = true) size: Int
    ):List<TastyItem>
}


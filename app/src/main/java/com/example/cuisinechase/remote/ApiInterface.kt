package com.example.cuisinechase.remote

import com.example.cuisinechase.model.RecipeData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterfaces {

    @GET("recipes")
    fun getData(): Call<RecipeData>
}
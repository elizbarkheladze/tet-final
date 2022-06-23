package com.example.food_app_for_final.retrofit

import com.example.food_app_for_final.pojo.MealX
import com.example.food_app_for_final.pojo.meal
import retrofit2.Call
import retrofit2.http.GET

interface MealApi {

    @GET("random.php")
    fun gerRandomMeal():retrofit2.Call<meal>
}
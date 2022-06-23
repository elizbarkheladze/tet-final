package com.example.food_app_for_final.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food_app_for_final.pojo.MealX
import com.example.food_app_for_final.pojo.meal
import com.example.food_app_for_final.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
    private var randomMealLiveData = MutableLiveData<MealX>()
class HomeViewModel:ViewModel() {
    fun getRandomMeal(){
        RetrofitInstance.api.gerRandomMeal().enqueue(object : Callback<meal> {
            override fun onResponse(call: Call<meal>, response: Response<meal>) {
                if(response.body() !=null){
                    val randomMeal: MealX = response.body()!!.meals[0]
                    randomMealLiveData.value = randomMeal
                }else{

                }
            }

            override fun onFailure(call: Call<meal>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun observeRandomMealData():LiveData<MealX>{
        return randomMealLiveData
    }

}
package com.example.food_app_for_final.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food_app_for_final.R
import com.example.food_app_for_final.databinding.ActivityMainBinding
import com.example.food_app_for_final.databinding.FragmentHomeBinding
import com.example.food_app_for_final.fragments.HomeFragment

class MealActivity : AppCompatActivity() {
    private lateinit var mealid : String
    private lateinit var mealname : String
    private lateinit var mealthumb : String
    private  lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        getmealinfofromIntent()

    }

//    private fun getmealinfofromIntent() {
//        val intent = intent
//        mealid = intent.getStringExtra(HomeFragment.MEAL_ID)!!
//        mealname = intent.getStringExtra(HomeFragment.MEAL_NAME)!!
//        mealthumb = intent.getStringExtra(HomeFragment.MEAL_THUMB)!!
//    }
}
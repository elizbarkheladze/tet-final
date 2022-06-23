package com.example.food_app_for_final.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentHostCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.food_app_for_final.R
import com.example.food_app_for_final.activities.MealActivity
import com.example.food_app_for_final.databinding.FragmentHomeBinding
import com.example.food_app_for_final.pojo.MealX
import com.example.food_app_for_final.pojo.meal
import com.example.food_app_for_final.retrofit.RetrofitInstance
import com.example.food_app_for_final.retrofit.RetrofitInstance.api
import com.example.food_app_for_final.viewModel.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var homeMvvm:HomeViewModel
    private lateinit var randomeMeal:MealX

    companion object{
        const val MEAL_ID = "com.example.food_app_for_final.fragments.idMeal"
        const val MEAL_NAME = "com.example.food_app_for_final.fragments.nameMeal"
        const val MEAL_THUMB = "com.example.food_app_for_final.fragments.thumbMeal"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeMvvm = ViewModelProviders.of(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeMvvm.getRandomMeal()
        observeRandomMeal()
        onRandomMealClick()


    }
    private fun onRandomMealClick(){
        binding.randMealCard.setOnClickListener {
            val intent = Intent(activity,MealActivity::class.java)
            intent.putExtra(MEAL_ID,randomeMeal.idMeal)
            intent.putExtra(MEAL_NAME,randomeMeal.strMeal)
            intent.putExtra(MEAL_THUMB,randomeMeal.strMealThumb)
            startActivity(intent)
        }
    }
    private fun observeRandomMeal() {
        homeMvvm.observeRandomMealData().observe(viewLifecycleOwner,object : Observer<MealX>{
            override fun onChanged(t: MealX?) {
                Glide.with(this@HomeFragment)
                    .load(t!!.strMealThumb)
                    .into(binding.imageRandMeal)

                randomeMeal = t
            }
        })


    }
}
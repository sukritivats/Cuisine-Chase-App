package com.example.cuisinechase.Views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cuisinechase.R
import com.example.cuisinechase.adapter.RvRecipeAdapter
import com.example.cuisinechase.databinding.FragmentHomeBinding
import com.example.cuisinechase.model.Recipe
import com.example.cuisinechase.model.RecipeData
import com.example.cuisinechase.remote.ApiInterfaces
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    private val retrofitBuilder= Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterfaces::class.java)

    private val data = retrofitBuilder.getData()
    private val favoriteRecipes = mutableListOf<Recipe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickHandler()
        initRvAdapter()
    }
    private fun initRvAdapter() {
        val data = retrofitBuilder.getData()  // Create a new instance of the call
        data.enqueue(object : Callback<RecipeData?> {
            override fun onResponse(call: Call<RecipeData?>, response: Response<RecipeData?>) {
                val responseBody = response.body()
                val recipeList = responseBody?.recipes ?: emptyList()
                val myAdapter = RvRecipeAdapter(
                    recipeList,
                    { recipe ->
                        if (recipe.isFavorite) {
                            favoriteRecipes.add(recipe)
                        } else {
                            favoriteRecipes.remove(recipe)
                        }
                    },
                    { recipe -> // Handle item click
                        val action = HomeFragmentDirections.actionHomeFragmentToRecipeFragment(recipe)
                        findNavController().navigate(action)
                    }
                )
                binding.rvImage.adapter = myAdapter
                binding.rvImage.layoutManager = GridLayoutManager(requireContext(), 2)
            }

            override fun onFailure(call: Call<RecipeData?>, t: Throwable) {
                Log.d("Fragment1", "onFailure: " + t.message)
            }
        })
    }


//    private fun initRvAdapter() {
//        data.enqueue(object : Callback<RecipeData?> {
//            override fun onResponse(call: Call<RecipeData?>, response: Response<RecipeData?>) {
//
//                val responseBody = response.body()
//                val recipeList = responseBody?.recipes ?: emptyList()
//                val myAdapter = RvRecipeAdapter(recipeList,
//                { recipe ->
//                    if (recipe.isFavorite) {
//                        favoriteRecipes.add(recipe)
//                    } else {
//                        favoriteRecipes.remove(recipe)
//                    }
//                },
//                { recipe -> // Handle item click
//                    val action = HomeFragmentDirections.actionHomeFragmentToRecipeFragment(recipe)
//                    findNavController().navigate(action)
//                }
//                )
//                binding.rvImage.adapter=myAdapter
//                binding.rvImage.layoutManager= GridLayoutManager(requireContext(),2)
//            }
//
//            override fun onFailure(call: Call<RecipeData?>, t: Throwable) {
//                Log.d("Fragment1","onFailure: "+t.message)
//            }
//        })
//    }

    private fun clickHandler() {
        binding.ivArScreen.setOnClickListener{
//            findNavController().navigate(R.id.action_homeFragment_to_ARFragment)
        }
    }

}
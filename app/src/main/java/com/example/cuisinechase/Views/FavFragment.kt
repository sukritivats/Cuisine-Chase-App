package com.example.cuisinechase.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cuisinechase.R
import com.example.cuisinechase.adapter.RvRecipeAdapter
import com.example.cuisinechase.databinding.FragmentFavBinding
import com.example.cuisinechase.model.Recipe

class FavFragment : Fragment() {

    private val binding by lazy { FragmentFavBinding.inflate(layoutInflater) }
    private val favoriteRecipes = mutableListOf<Recipe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init() {
//        val myAdapter = RvRecipeAdapter(favoriteRecipes) { recipe ->
//            // Handle click event if needed
//        }
//        binding.rvFavorite.adapter = myAdapter
//        binding.rvFavorite.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    // Method to update the favorite list
    fun updateFavoriteList(newFavorites: List<Recipe>) {
        favoriteRecipes.clear()
        favoriteRecipes.addAll(newFavorites)
        binding.rvFavorite.adapter?.notifyDataSetChanged()
    }


}
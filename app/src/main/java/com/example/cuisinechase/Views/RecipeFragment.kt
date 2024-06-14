package com.example.cuisinechase.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cuisinechase.R
import com.example.cuisinechase.databinding.FragmentARBinding
import com.example.cuisinechase.databinding.FragmentRecipeBinding
import com.example.cuisinechase.model.Recipe
import com.squareup.picasso.Picasso

class RecipeFragment : Fragment() {

    private val binding by lazy { FragmentRecipeBinding.inflate(layoutInflater) }
    private val args by navArgs<RecipeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        backPress()
        clickHandler()
    }

    private fun clickHandler() {
        binding.ivBack.setOnClickListener {
            backPress()
        }
    }

    private fun backPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })
    }

    private fun init() {
        val recipe: Recipe? = arguments?.getParcelable("recipe")
        recipe?.let {
            binding.tvName.text = "Menu: ${it.name}"
            Picasso.get()
                .load(it.image)
                .into(binding.ivMenu)
            binding.tvCuisine.text= "Cuisine: ${it.cuisine}"
            binding.tvIngredient.text= it.ingredients.joinToString("\n")
            binding.tvInstructions.text= it.instructions.joinToString ("\n")
        }

    }


}
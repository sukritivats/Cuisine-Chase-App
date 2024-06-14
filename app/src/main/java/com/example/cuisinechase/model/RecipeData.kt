package com.example.cuisinechase.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeData(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
) : Parcelable
package com.example.cuisinechase.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val caloriesPerServing: Int,
    val cookTimeMinutes: Int,
    val cuisine: String,
    val difficulty: String,
    val id: Int,
    val image: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val mealType: List<String>,
    val name: String,
    val prepTimeMinutes: Int,
    val rating: Double,
    val reviewCount: Int,
    val servings: Int,
    val tags: List<String>,
    val userId: Int,
    var isFavorite: Boolean = false
) : Parcelable
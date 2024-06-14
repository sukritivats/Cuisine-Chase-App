package com.example.cuisinechase.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cuisinechase.R
import com.example.cuisinechase.model.Recipe
import com.squareup.picasso.Picasso

class RvRecipeAdapter(val recipeArrayList: List<Recipe>,
                      private val onFavoriteClick: (Recipe) -> Unit,
                      private val onItemClick: (Recipe) -> Unit)
    :RecyclerView.Adapter<RvRecipeAdapter.MyViewHolder>()
{
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var hMenu:TextView = itemView.findViewById(R.id.tvName)
        var hImage:ImageView = itemView.findViewById(R.id.ivMenu)
        val hFav: ImageView = itemView.findViewById(R.id.ivfav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.each_item_rv,parent,false))
    }

    override fun getItemCount(): Int {
        return recipeArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=recipeArrayList[position]
        holder.hMenu.text=currentItem.name
//        holder.hImage.setImageResource()
        Picasso.get().load(currentItem.image).into(holder.hImage)

        holder.hFav.setOnClickListener {
            it.isSelected = !it.isSelected
        }
        holder.hFav.isSelected = currentItem.isFavorite

        // Handle the favorite icon click
        holder.hFav.setOnClickListener {
            currentItem.isFavorite = !currentItem.isFavorite
            holder.hFav.isSelected = currentItem.isFavorite
            onFavoriteClick(currentItem) // Notify the fragment/activity about the favorite status change
        }

        holder.itemView.setOnClickListener {
            onItemClick(currentItem) // Notify the fragment/activity about the item click
        }
    }

}
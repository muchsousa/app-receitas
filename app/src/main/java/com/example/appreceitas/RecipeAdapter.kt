package com.example.appreceitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Recipe(val name: String)

class RecipeAdapter(private val listRecipe : List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeItemHolder>(){
    class RecipeItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recipeName : TextView = itemView.findViewById(R.id.tvRecipeName)
        var recipeImage : ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_receita,parent, false)
        return RecipeItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    override fun onBindViewHolder(holder: RecipeItemHolder, position: Int) {
        val recipe = listRecipe[position]
        holder.recipeName.text = recipe.name
//        holder.recipeImage.setImageResource(recipe.imageResourceId)
    }
}
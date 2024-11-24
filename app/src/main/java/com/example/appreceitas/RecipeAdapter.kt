package com.example.appreceitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import android.util.Log

class RecipeAdapter(
    private val listRecipeItem : List<Recipe>,
    private val onItemClicked: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeItemHolder>(){

    class RecipeItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recipeName : TextView = itemView.findViewById(R.id.tvRecipeName)
        var recipeImage : ImageView = itemView.findViewById(R.id.imageView)

        val recipeId: TextView = itemView.findViewById(R.id.tvRecipeId)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_receita,parent, false)
        return RecipeItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listRecipeItem.size
    }

    override fun onBindViewHolder(holder: RecipeItemHolder, position: Int) {
        val recipe = listRecipeItem[position]
        holder.recipeName.text = recipe.name
        holder.recipeId.text = recipe.id.toString()
//        holder.recipeImage.setImageResource(recipe.imageResourceId)

        holder.itemView.setOnClickListener { onItemClicked(recipe) }

    }


}
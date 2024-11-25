package com.example.appreceitas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.appreceitas.databinding.FragmentShowRecipeBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ShowRecipeFragment : Fragment() {

    private var _binding: FragmentShowRecipeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShowRecipeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val applicationContext = requireContext()
        val recipeDBHelper = RecipeDBHelper(applicationContext)

        val recipeId = getArguments()?.getInt("recipeId")
        Log.d("ShowRecipeFragment - recipeId", recipeId.toString())

        if (recipeId == null) {
            return;
        }

        val recipe = recipeDBHelper.getRecipeById(recipeId)

        // Change title in toolbar
        (activity as Home).supportActionBar?.setTitle(recipe.name)

        val recipeDescription : TextView = view.findViewById(R.id.tv_descriptionText)
        recipeDescription.text = recipe.description

        val recipeIngredients : TextView = view.findViewById(R.id.tv_ingredientsText)
        recipeIngredients.text = recipe.ingredients

        val recipePrepareMode : TextView = view.findViewById(R.id.tv_prepareModeText)
        recipePrepareMode.text = recipe.prepare
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
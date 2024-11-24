package com.example.appreceitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.appreceitas.databinding.FragmentShowRecipeBinding

import com.example.appreceitas.Home


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

//        (activity as Home).setSupportActionBar(view.findViewById(R.id.toolbar))
//        (activity as Home).supportActionBar?.title = "xalala"


//        setSupportActionBar(view.findViewById(R.id.toolbar))
//        supportActionBar!!.title = "new title of toolbar"
//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_ShowRecipe_to_ListRecipes)
//        }

        val applicationContext = requireContext()
        val recipeDBHelper = RecipeDBHelper(applicationContext)

        val recipeId = 6
        val recipe = recipeDBHelper.getRecipeById(recipeId)

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
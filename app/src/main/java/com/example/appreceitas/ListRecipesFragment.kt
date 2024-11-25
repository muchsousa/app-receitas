package com.example.appreceitas

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appreceitas.databinding.FragmentListRecipesBinding
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListRecipesFragment : Fragment() {
    private var _binding: FragmentListRecipesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val applicationContext = requireContext()
        val recipeDBHelper = RecipeDBHelper(applicationContext)
        val recipeList = recipeDBHelper.getAllRecipes()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(context)

        val recipeAdapter = RecipeAdapter(recipeList, this::onSelectRecipe)
        recyclerView.adapter = recipeAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onSelectRecipe(recipe: Recipe) {
        val bundle = bundleOf("recipeId" to recipe.id)
        findNavController().navigate(R.id.action_ListRecipes_to_ShowRecipe, bundle)
//        findNavController().navigate(R.id.action_ListRecipes_to_ShowRecipe)

        Log.d("onSelectRecipe", recipe.id.toString())
    }

}
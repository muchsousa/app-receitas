package com.example.appreceitas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appreceitas.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_home)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)




//        val recipeDBHelper = RecipeDBHelper(applicationContext)
//        val recipeList = recipeDBHelper.getAllRecipes()
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val recipeAdapter = RecipeAdapter(recipeList, this::onSelectRecipe)
//        recyclerView.adapter = recipeAdapter


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


//    private fun onSelectRecipe(recipe: Recipe) {
//        val intent = Intent(applicationContext, ShowRecipeActivity::class.java)
//        startActivity(intent)
//
//        intent.putExtra("", recipe.id)
//        startActivity(intent)
//    }
//
//    fun loadRecipes() {
//        val recipeDBHelper = RecipeDBHelper(applicationContext)
//
//        recipeDBHelper.insertRecipe(
//            "Massa Carbonara",
//            "",
//            "massa;bacon;ovo",
//            "cozinhe a massa",
//            "Massa carbonara"
//        )
//        recipeDBHelper.insertRecipe(
//            "Pão com ovo",
//            "",
//            "pão;ovo",
//            "frite o ovo e coloque no pão",
//            ""
//        )
//    }
}
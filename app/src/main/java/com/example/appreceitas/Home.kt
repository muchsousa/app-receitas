package com.example.appreceitas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.appreceitas.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_home)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

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
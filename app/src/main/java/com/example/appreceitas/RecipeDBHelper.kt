package com.example.appreceitas

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import java.io.ByteArrayOutputStream


class RecipeDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "recipes.db"
        const val DATABASE_VERSION = 1
        const val TABLE_RECIPES = "recipes"

        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_IMAGE = "image"
        const val COLUMN_INGREDIENTS = "ingredients"
        const val COLUMN_PREPARE = "prepare_method"
        const val COLUMN_DESCRIPTION = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_RECIPES (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_IMAGE BLOB, " +
                "$COLUMN_INGREDIENTS TEXT, " +
                "$COLUMN_PREPARE TEXT, " +
                "$COLUMN_DESCRIPTION TEXT)"

        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_RECIPES")
        onCreate(db)
    }

    fun deleteAll() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_RECIPES")
    }

    fun insertRecipe(name: String, image: Bitmap, ingredients: String, prepare: String, description: String): Long {
        val db = this.writableDatabase

        val stream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 70, stream)
        val blobImage = stream.toByteArray()

        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_IMAGE, blobImage)
            put(COLUMN_INGREDIENTS, ingredients)
            put(COLUMN_PREPARE, prepare)
            put(COLUMN_DESCRIPTION, description)
        }

        return db.insert(TABLE_RECIPES, null, values)
    }

    fun getAllRecipes(): List<Recipe> {
        val db = this.readableDatabase
        val projection = arrayOf(
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_IMAGE,
            COLUMN_INGREDIENTS,
            COLUMN_PREPARE,
            COLUMN_DESCRIPTION
        )

        val cursor = db.query(
            TABLE_RECIPES,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val recipeItems = mutableListOf<Recipe>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(COLUMN_ID))
                val name = getString(getColumnIndexOrThrow(COLUMN_NAME))
                val image = getBlob(getColumnIndexOrThrow(COLUMN_IMAGE))
                val ingredients = getString(getColumnIndexOrThrow(COLUMN_INGREDIENTS))
                val prepare = getString(getColumnIndexOrThrow(COLUMN_PREPARE))
                val description = getString(getColumnIndexOrThrow(COLUMN_DESCRIPTION))

                val imageBitmap = BitmapFactory.decodeByteArray(image, 0, image.size)

                recipeItems.add(
                    Recipe(id, name, imageBitmap, ingredients, prepare, description)
                )
            }
        }
        cursor.close()
        return recipeItems
    }

    fun getRecipeById(recipeId: Int): Recipe {
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM $TABLE_RECIPES WHERE $COLUMN_ID = ?", arrayOf(recipeId.toString())
        )

        var recipe: Recipe;
        with(cursor) {
            moveToFirst()

            val id = getInt(getColumnIndexOrThrow(COLUMN_ID))
            val name = getString(getColumnIndexOrThrow(COLUMN_NAME))
            val image = getBlob(getColumnIndexOrThrow(COLUMN_IMAGE))
            val ingredients = getString(getColumnIndexOrThrow(COLUMN_INGREDIENTS))
            val prepare = getString(getColumnIndexOrThrow(COLUMN_PREPARE))
            val description = getString(getColumnIndexOrThrow(COLUMN_DESCRIPTION))

            val imageBitmap = BitmapFactory.decodeByteArray(image, 0, image.size)

            recipe = Recipe(id, name, imageBitmap, ingredients, prepare, description)
        }
        cursor.close()
        return recipe
    }

}
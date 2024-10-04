import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class RecipeDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "recipes.db"
        const val DATABASE_VERSION = 1
        const val TABLE_RECIPES = "recipes"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DESCRIPTION = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_RECIPES (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_DESCRIPTION TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_RECIPES")
        onCreate(db)
    }

    fun insertRecipe(recipeName: String, recipeDescription: String): Long {
        // Acessar o banco de dados em modo de escrita
        val db = this.writableDatabase

        // Criar um ContentValues para armazenar os dados
        val values = ContentValues().apply {
            put(COLUMN_NAME, recipeName)
            put(COLUMN_DESCRIPTION, recipeDescription)
        }

        // Inserir os dados na tabela e retornar o ID da nova linha inserida
        return db.insert(TABLE_RECIPES, null, values)
    }

    fun getAllRecipes(): List<String> {
        val db = this.readableDatabase
        val projection = arrayOf(RecipeDBHelper.COLUMN_NAME, RecipeDBHelper.COLUMN_DESCRIPTION)

        val cursor = db.query(
            RecipeDBHelper.TABLE_RECIPES,  // Tabela
            projection,                          // Colunas a serem retornadas
            null,                                // Sem condição WHERE
            null,                                // Sem valores para condição WHERE
            null,                                // Sem agrupamento
            null,                                // Sem condição HAVING
            null                                 // Ordem
        )

        val recipes = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val name = getString(getColumnIndexOrThrow(RecipeDBHelper.COLUMN_NAME))
                val description = getString(getColumnIndexOrThrow(RecipeDBHelper.COLUMN_DESCRIPTION))
                recipes.add("$name: $description")
            }
        }
        cursor.close()

        return recipes
    }

}
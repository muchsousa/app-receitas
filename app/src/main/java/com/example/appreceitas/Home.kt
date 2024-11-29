package com.example.appreceitas

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.appreceitas.databinding.ActivityHomeBinding
import java.io.IOException


class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        loadRecipes()

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

    fun loadRecipes() {
        val recipeDBHelper = RecipeDBHelper(applicationContext)

        // clean database
//        recipeDBHelper.deleteAll()

        // insert recipes
        recipeDBHelper.insertRecipe(
            "Massa Carbonara",
            getBitmapFromAssets("massa_carbonara.jpg"),
            "- 200 g de macarrão espaguete (ou outra massa longa de grano duro)\n- ½ xícara (chá) de bacon em cubos (75 g)\n- ¼ de xícara (chá) de vinho branco\n- 2 ovos\n- 2 gemas\n- ½ xícara (chá) de queijo parmesão ralado\n- sal\n- pimenta-do-reino moída na hora a gosto",
            "Leve uma panela média com cerca de 3 litros de água ao fogo alto. Quando ferver, adicione 1½ colher (sopa) de sal, junte o macarrão e deixe cozinhar pelo tempo indicado na embalagem, ou até ficar al dente, mexendo de vez em quando para que os fios não grudem um no outro.\nEnquanto o macarrão cozinha, separe os outros ingredientes. Numa tigela pequena, quebre um ovo de cada vez e transfira para outra tigela (lembre-se: são 2 ovos inteiros e 2 gemas; você pode reservar as claras na geladeira ou no congelador para outras receitas). Junte o queijo parmesão e misture bem com um garfo.\nLeve uma frigideira grande ao fogo médio para aquecer. Adicione o bacon e deixe dourar por cerca de 5 minutos, mexendo de vez em quando. Abaixe o fogo, regue com o vinho branco, com cuidado para não espirrar, misture bem e desligue.\nAssim que o macarrão estiver cozido, reserve 1 xícara (chá) da água do cozimento.\nAgora você vai precisar fazer tudo bem rapidinho: escorra a água, transfira o macarrão para a frigideira com o bacon quente, junte os ovos e misture bem — a ideia é que o calor da massa cozinhe os ovos, formando um creme. Caso necessário, volte a frigideira ao fogo baixo e vá adicionando aos poucos a água do cozimento reservada, mexendo com uma espátula por alguns minutinhos até formar um molho espesso. Cuidado para não cozinhar os ovos! Sirva a seguir com pimenta-do-reino a gosto e telha de parmesão (opcional, veja a receita abaixo).",
            "Massa carbonara é rápida e fácil."
        )

        recipeDBHelper.insertRecipe(
            "Pudim",
            getBitmapFromAssets("pudim.jpg"),
            "- 1 lata de leite condensado\n- 2 ovos\n- 1 xícara (chá) de leite\n- ⅓ de xícara (chá) de tahine (pasta de gergelim)\n",
            "Numa tigela pequena, quebre um ovo de cada vez e transfira para uma tigela maior. Mexa com o batedor de arame para misturar as claras com as gemas. Junte o leite condensado e o tahine e misture bem.\n\nAcrescente o leite aos poucos, mexendo delicadamente com o batedor — evite fazer movimentos bruscos para não incorporar ar. Deixe a massa do pudim descansar enquanto prepara o caramelo — essa pausa é essencial para eliminar possíveis bolhas de ar e garantir um pudim lisinho.",
            "Receita de Pudim"
        )

        recipeDBHelper.insertRecipe(
            "Risoto de queijo brie com damasco na pressão",
            getBitmapFromAssets("risoto.jpg"),
            "- 2 xícaras (chá) de arroz para risoto (arbóreo)\n- 1 xícara (chá) de queijo brie francês cortado em cubos de 1,5 cm\n- ½ xícara (chá) de damasco seco\n- 1 cebola\n- 1 cenoura\n- 1 talo de salsão (com as folhas)\n- 3 colheres (sopa) de azeite\n- 2 colheres (sopa) de manteiga\n- ½ xícara (chá) de vinho branco\n- 1 litro de água\n- raspas de 1 limão\n- 1 folha de louro\n- 2 cravos-da-índia\n- sal\n- pimenta-do-reino moída na hora a gosto\n- cubos de queijo brie a gosto para servir\n- damasco seco fatiado a gosto para servir\n- picles de salsão a gosto para servir\n- folhas de salsinha a gosto para servir\n",
            "Descasque e corte a cebola ao meio. Numa das metades, prenda a folha de louro espetando os cravos; pique fino a outra metade. Lave, descasque e passe a cenoura na parte fina do ralador. Lave o salsão, reserve uma folha e pique o talo em cubinhos. Corte o damasco em pedaços de cerca de 1 cm.\n\nLeve a panela de pressão (sem a tampa) ao fogo médio. Quando aquecer, regue com 2 colheres (sopa) de azeite, adicione a cebola picada, tempere com uma pitada de sal e refogue até murchar. Junte a cenoura, o salsão e refogue por mais 2 minutos.\n\nAcrescente o restante do azeite, junte o arroz e misture bem. Regue com o vinho e mexa até secar. Junte a água, a folha de salsão, a cebola cravejada, tempere com 1 colher (chá) de sal e pimenta a gosto; misture, tampe a panela e aumente o fogo.\n\nAssim que a panela começar a apitar, diminua o fogo para médio e conte 3 minutos — esse é o tempo exato para o risoto não passar do ponto. Enquanto isso, leve uma chaleira com 1 xícara (chá) de água ao fogo alto para ferver.\n\nApós os 3 minutos, desligue o fogo e, com cuidado, leve a panela para esfriar sob água corrente até parar de sair vapor pela válvula. Atenção: a água não deve entrar em contato com nenhuma das válvulas, apenas com a superfície lisa da tampa.\n\nAbra a panela e, com uma pinça, pesque a folha de salsão e a cebola cravejada. Adicione o queijo brie, volte a panela ao fogo médio e mexa por cerca de 1 minuto, até o risoto ficar cremoso e al dente — se necessário, vá regando com a água fervente para manter o risoto bem úmido.\n\nDesligue o fogo, acrescente a manteiga e misture bem. Por último, misture o damasco picado e as raspas de limão. Sirva a seguir com cubos de queijo brie, fatias de damasco, picles de salsão e folhas de salsinha a gosto.",
            "O preparo deste risoto é pá-pum, e o resultado surpreende. Pra começar, a estrela principal: o tradicional queijo brie. É ele o responsável por deixar o risoto amanteigado e bem cremoso. O damasco picado e raspas de limão completam o time. São muitas camadas de sabor num prato só, mon amour!\n\nhttps://panelinha.com.br/receita/risoto-de-queijo-brie-com-damasco-na-pressao"
        )

    }

    @Throws(IOException::class)
    fun getBitmapFromAssets(fileName: String?): Bitmap {
        val assetManager = assets

        val istr = assetManager.open(fileName!!)
        val bitmap = BitmapFactory.decodeStream(istr)
        istr.close()

        return bitmap
    }
}
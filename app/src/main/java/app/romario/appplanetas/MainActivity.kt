package app.romario.appplanetas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.romario.appplanetas.models.Planetas
import app.romario.appplanetas.ui.theme.AppPlanetasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPlanetasTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "TelaInicial") {
                        composable("TelaInicial") { TelaInicial(navController) }
                        composable("TelaDetalhes"){
                            val planeta = navController.previousBackStackEntry?.arguments?.getParcelable<Planetas>("planeta")
                            planeta?.let{
                                PlanetaDetails(navigation = navController, planeta = it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TelaInicial(navHostController: NavHostController){

    LazyColumn(){
        itemsIndexed(Planetas.getTodos()){
            index, item ->
            meuCard(navHostController, item)
        }
    }

}

@Composable
fun meuCard(navHostController: NavHostController, planeta: Planetas) {
    Card(elevation = 4.dp,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, color= Color.Gray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(120.dp)
            .clickable {
                navHostController.currentBackStackEntry?.arguments = Bundle().apply {
                    putParcelable("planeta", planeta)
                }
                navHostController.navigate("TelaDetalhes")
            }
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)) {
            Image(painterResource(id = planeta.imagem), contentDescription = planeta.nome,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp))
            Text( text = planeta.nome,
                  style= TextStyle(fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
                  modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
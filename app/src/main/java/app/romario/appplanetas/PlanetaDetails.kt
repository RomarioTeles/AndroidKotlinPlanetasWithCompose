package app.romario.appplanetas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import app.romario.appplanetas.models.Planetas


@Composable
fun PlanetaDetails(navigation: NavHostController,planeta: Planetas){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)) {
        Image(
            painterResource(id = planeta.imagem), contentDescription = planeta.nome,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .width(100.dp))

            Text( text = planeta.nome,
                style= TextStyle(fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )
            Text( text = planeta.descricao,
                style= TextStyle(textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navigation.popBackStack()
                }) {
                Text(text = "voltar")
            }

    }
}
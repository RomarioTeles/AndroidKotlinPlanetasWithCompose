package app.romario.appplanetas.models

import android.os.Parcelable
import app.romario.appplanetas.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planetas(val nome: String, val descricao: String, val imagem: Int) : Parcelable{


    companion object {
        fun getTodos(): List<Planetas>{
            return listOf<Planetas>(
                Planetas("Mercurio", "1º Planeta do sistema solar", R.drawable.mercurio),
                Planetas("Venus", "2º Planeta do sistema solar", R.drawable.venus),
                Planetas("Terra", "3º Planeta do sistema solar", R.drawable.terra),
                Planetas("Marte", "4º Planeta do sistema solar", R.drawable.marte),
                Planetas("Jupiter", "5º Planeta do sistema solar", R.drawable.jupiter),
                Planetas("Saturno", "6º Planeta do sistema solar", R.drawable.saturno),
                Planetas("Urano", "7º Planeta do sistema solar", R.drawable.urano),
                Planetas("Neturno", "8º Planeta do sistema solar", R.drawable.neturno),
            )
        }
    }

}
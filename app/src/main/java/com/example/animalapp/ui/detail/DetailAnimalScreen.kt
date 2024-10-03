package com.example.animalapp.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animalapp.data.remote.Animal
import com.example.animalapp.presentation.AnimalViewModel
import com.example.animalapp.ui.component.AnimalText
import com.example.animalapp.ui.component.DetailAnimalImage
import com.example.animalapp.ui.component.NavTopBar
import com.example.animalapp.ui.component.ToggleHeart


@Composable
fun DetailAnimalScreen(
    viewModel: AnimalViewModel,
    animal: Animal,
    navigateUp: () -> Unit,
) {
    val isFavorite by viewModel.isFavorite.collectAsState()
    println("isFavorite: ${isFavorite}")

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NavTopBar(
                title = "Detalle Animal",
                canNavigateBack = true,
                navigateUp = { navigateUp() },
            )
        },
    ) { innerPadding ->
        DetailAnimalContent(viewModel, Modifier.padding(innerPadding), animal, isFavorite)
    }
}

@Composable
fun DetailAnimalContent(
    viewModel: AnimalViewModel,
    modifier: Modifier,
    animal: Animal,
    isFavorite: Boolean,

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 4.dp, bottom = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            println("favorite selected1 ${isFavorite}")
            var selected by remember { mutableStateOf(isFavorite) }
            println("favorite selected2 ${selected}")


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AnimalText(name = animal.name, fontsize = 18)
                ToggleHeart(
                    checked = selected,
                    onCheckedChange = { favoriteSelected ->
                        if (favoriteSelected) {
                            viewModel.saveAnimalFavorite(animal.id, true)
                        } else {
                            viewModel.saveAnimalFavorite(animal.id, false)
                        }
                        selected = favoriteSelected
                    }
                )
            }
            DetailAnimalImage(animal.imageResource)
        }
        AnimalAbility(animal.abilities)
    }

}

@Composable
fun AnimalAbility(abilities: List<String>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
            .verticalScroll(rememberScrollState()),
    ) {

        Text(
            text = "Habilidades",
            fontWeight = FontWeight.Black,
            color = Color.Black,
            style = typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
        )

        Spacer(modifier = Modifier.size(8.dp))

        for (abilitie in abilities) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = abilitie,
                    fontWeight = FontWeight.Black,
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 18.sp
                )
            }
        }
    }
}


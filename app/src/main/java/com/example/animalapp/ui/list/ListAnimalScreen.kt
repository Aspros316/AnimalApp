package com.example.animalapp.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animalapp.data.remote.Animal
import com.example.animalapp.data.remote.animalList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListAnimalScreen(
    navToDetail: (Animal) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Animales") }
            )
        },

        ) { innerPadding ->

        AnimalColumnList(
            navToDetail = navToDetail,
            modifier = Modifier.padding(innerPadding),
            recipeList = animalList
        )
    }
}

@Composable
private fun AnimalColumnList(
    navToDetail: (Animal) -> Unit,
    modifier: Modifier = Modifier,
    recipeList: List<Animal>
) {
    LazyColumn(
        modifier = modifier.
        fillMaxSize()
    ) {
        items(recipeList) { animal ->
            AnimalCard(animal = animal, navToDetail = navToDetail)

        }
    }
}


@Composable
private fun AnimalCard(
    animal: Animal,
    navToDetail: (Animal) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier
            .clickable { navToDetail(animal) }
            .clip(shape = RoundedCornerShape(8.dp))
    ) {

        Spacer(modifier = Modifier.size(4.dp))

        AnimalText(animal.name)

        Image(
            painter = painterResource(id = animal.imageResource),
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            contentScale = ContentScale.Crop,
            contentDescription = "Foto Animal"
        )

    }
}

@Composable
fun AnimalText(name: String) {
    Text(
        text = name,
        fontWeight = FontWeight.Black,
        color = Color.Black,
        fontSize = 21.sp,
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier.padding(8.dp)
    )
}
package com.example.animalapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailAnimalImage(image: Int) {
    Image(
        contentScale = ContentScale.Fit,
        painter = painterResource(image),
        modifier = Modifier
            .fillMaxWidth()
            .size(250.dp),
        contentDescription = "Background Image",
    )
}
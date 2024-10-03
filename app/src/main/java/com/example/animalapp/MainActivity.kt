package com.example.animalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.animalapp.presentation.AnimalViewModel
import com.example.animalapp.ui.navigation.NavGraph
import com.example.animalapp.ui.theme.AnimalAppTheme
import dagger.hilt.android.AndroidEntryPoint





@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalAppTheme {
                val viewModel = hiltViewModel<AnimalViewModel>()
                val navController = rememberNavController()
                NavGraph(navController, viewModel)
            }
        }
    }
}


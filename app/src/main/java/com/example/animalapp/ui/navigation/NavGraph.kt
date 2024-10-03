package com.example.animalapp.ui.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.animalapp.data.remote.Animal
import com.example.animalapp.presentation.AnimalViewModel
import com.example.animalapp.ui.detail.DetailAnimalScreen
import com.example.animalapp.ui.list.ListAnimalScreen
import com.google.gson.Gson
import kotlinx.coroutines.delay
import java.lang.Thread.sleep

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: AnimalViewModel
) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.ListScreen.route,
    ) {

        composable(route = AppScreen.ListScreen.route) {
            ListAnimalScreen(
                navToDetail = { animal ->
                    val animalJson = Gson().toJson(animal)
                    navController.navigate(AppScreen.ListScreen.route+"/$animalJson")
                    viewModel.isAnimalFavorite(animal.id)
                    sleep(500)
                }
            )
        }

        composable(
            AppScreen.ListScreen.route+"/{animal}",
            arguments = listOf(
                navArgument("animal") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val context = LocalContext.current
            backStackEntry.arguments?.getString("animal")?.let { json ->
                val user = Gson().fromJson(json, Animal::class.java)
                DetailAnimalScreen(
                    viewModel = viewModel,
                    animal = user,
                    navigateUp = {
                        navController.navigateUp()
                        sleep(300)
                        Toast.makeText(context, "Saliendo de Detalles", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }


    }
}
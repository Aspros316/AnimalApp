package com.example.animalapp.ui.navigation

sealed class AppScreen(val route: String) {
    object ListScreen : AppScreen(ConstantAppScreenName.LIST_SCREEN)
    object DetailsScreen : AppScreen(ConstantAppScreenName.DETAIL_SCREEN)
}

object ConstantAppScreenName {
    const val LIST_SCREEN = "list_screen"
    const val DETAIL_SCREEN = "detail_screen"

}
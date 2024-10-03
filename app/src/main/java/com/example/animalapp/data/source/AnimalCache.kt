package com.example.animalapp.data.source

import kotlinx.coroutines.flow.Flow

interface AnimalCache {
    suspend fun saveFavorite(id: Int, isFavorite: Boolean)
    fun isAnimalFavorite(id: Int): Flow<Boolean>

}
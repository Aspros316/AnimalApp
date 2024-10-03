package com.example.animalapp.data.source

import com.example.animalapp.data.remote.Animal
import kotlinx.coroutines.flow.Flow

interface AnimalRepository {
    suspend fun getAnimalList():List<Animal>
    suspend fun saveFavorite(id: Int, isValid: Boolean)
    suspend fun isAnimalFavorite(id: Int): Flow<Boolean>

}
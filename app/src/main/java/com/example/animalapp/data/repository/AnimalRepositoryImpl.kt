package com.example.animalapp.data.repository

import com.example.animalapp.data.remote.Animal
import com.example.animalapp.data.remote.animalList
import com.example.animalapp.data.source.AnimalCache
import com.example.animalapp.data.source.AnimalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AnimalRepositoryImpl @Inject constructor(
    private val cache: AnimalCache
) : AnimalRepository {
    override suspend fun getAnimalList(): List<Animal> {
        return animalList
    }

    override suspend fun saveFavorite(id: Int, isValid: Boolean) {
        cache.saveFavorite(id, isValid)
    }

    override suspend fun isAnimalFavorite(id: Int): Flow<Boolean>  = runBlocking {
        cache.isAnimalFavorite(id)
    }


}
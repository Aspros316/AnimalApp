package com.example.animalapp.data.cache

import com.example.animalapp.data.cache.datastore.AnimalDataStore
import com.example.animalapp.data.source.AnimalCache
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AnimalCacheImpl  @Inject constructor(
    private val dataStore: AnimalDataStore
): AnimalCache {
    override suspend fun saveFavorite(id: Int, isFavorite: Boolean) {
        dataStore.saveFavorite(id, isFavorite)
    }

    override fun isAnimalFavorite(id: Int): Flow<Boolean> = runBlocking {
        dataStore.isFavorite(id)
    }
}
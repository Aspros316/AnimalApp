package com.example.animalapp.data.cache.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.animalapp.data.cache.datastore.config.AnimalDataStoreBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AnimalDataStore @Inject constructor(
    private val animalDataStoreBuilder: AnimalDataStoreBuilder
) {

    // Clave para guardar favoritos
    private val FAVORITE_KEY = booleanPreferencesKey("favorite_")

    // Función para obtener si un ítem es favorito o no
    fun isFavorite(id: Int): Flow<Boolean> = with(animalDataStoreBuilder) {
        getDataStore.data.map { preferences ->
            preferences[booleanPreferencesKey(FAVORITE_KEY.name + id)] ?: false
        }
    }

    // Función para guardar el estado favorito
    suspend fun saveFavorite(id: Int, isFavorite: Boolean) {
        with(animalDataStoreBuilder) {
            getDataStore.edit { preferences ->
                preferences[booleanPreferencesKey(FAVORITE_KEY.name + id)] = isFavorite
            }
        }
    }
}
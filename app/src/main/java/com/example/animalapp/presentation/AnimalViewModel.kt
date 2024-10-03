package com.example.animalapp.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalapp.data.source.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalViewModel @Inject constructor(
    private val repository: AnimalRepository
) : ViewModel() {

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite


    fun saveAnimalFavorite(animalId: Int, isActive: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveFavorite(animalId, isActive)
        }
    }

    fun isAnimalFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.isAnimalFavorite(id).map { isFavorite ->
                _isFavorite.value = isFavorite
            }.stateIn(this)

        }
    }


}
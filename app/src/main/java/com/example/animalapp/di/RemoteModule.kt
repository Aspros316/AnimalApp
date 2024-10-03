package com.example.animalapp.di

import com.example.animalapp.data.repository.AnimalRepositoryImpl
import com.example.animalapp.data.source.AnimalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {
    @Binds
    abstract fun bindPokedexRemote(remote: AnimalRepositoryImpl): AnimalRepository

}
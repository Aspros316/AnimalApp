package com.example.animalapp.di

import com.example.animalapp.data.cache.AnimalCacheImpl
import com.example.animalapp.data.source.AnimalCache
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun bindPokemonCache(cache: AnimalCacheImpl): AnimalCache

}
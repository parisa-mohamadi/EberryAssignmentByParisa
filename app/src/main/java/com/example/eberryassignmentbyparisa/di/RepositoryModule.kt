package com.example.eberryassignmentbyparisa.di

import com.example.eberryassignmentbyparisa.data.repository.Repository
import com.example.eberryassignmentbyparisa.domain.use_cases.GetTvShowsUseCase
import com.example.eberryassignmentbyparisa.domain.use_cases.MultiSearchUseCase
import com.example.eberryassignmentbyparisa.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesUseCases(repository: Repository): UseCases {
        return UseCases(
            multiSearchUseCase = MultiSearchUseCase(repository),
            getTvShowsUseCase = GetTvShowsUseCase(repository)
        )
    }
}
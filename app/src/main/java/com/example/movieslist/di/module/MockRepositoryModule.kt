package com.example.movieslist.di.module

import com.example.movieslist.network.IMovieRepository
import com.example.movieslist.network.mock.MockMovieRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
object MockRepositoryModule {

    @Reusable
    @JvmStatic
    @Provides
    internal fun provideMockRepository(): IMovieRepository {
        return MockMovieRepository()
    }
}
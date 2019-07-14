package com.example.movieslist.di.module

import com.example.movieslist.network.IMovieRepository
import com.example.movieslist.network.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
object RepositoryModule {

    @Reusable
    @JvmStatic
    @Provides
    internal fun provideRepository(): IMovieRepository {
        return MovieRepository()
    }

    /*@Reusable
    @JvmStatic
    @Named("Mock")
    @Provides
    internal fun provideMockRepository(): IMovieRepository {
        return MockMovieRepository()
    }*/
}
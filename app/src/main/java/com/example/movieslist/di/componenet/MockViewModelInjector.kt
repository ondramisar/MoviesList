package com.example.movieslist.di.componenet

import com.example.movieslist.di.module.MockRepositoryModule
import com.example.movieslist.ui.MovieListViewModel
import com.example.movieslist.ui.MovieViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(MockRepositoryModule::class)])
interface MockViewModelInjector {

    fun inject(postListViewModel: MovieListViewModel)

    fun inject(postViewModel: MovieViewModel)

    @Component.Builder
    interface Builder {
        fun build(): MockViewModelInjector

        fun repositoryModule(repositoryModule: MockRepositoryModule): Builder
    }
}
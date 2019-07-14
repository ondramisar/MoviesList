package com.example.movieslist.base

import androidx.lifecycle.ViewModel
import com.example.movieslist.di.componenet.DaggerMockViewModelInjector
import com.example.movieslist.di.componenet.DaggerViewModelInjector
import com.example.movieslist.di.componenet.MockViewModelInjector
import com.example.movieslist.di.componenet.ViewModelInjector
import com.example.movieslist.di.module.MockRepositoryModule
import com.example.movieslist.di.module.RepositoryModule
import com.example.movieslist.ui.MovieListViewModel
import com.example.movieslist.ui.MovieViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .repositoryModule(RepositoryModule)
        .build()

    private val injectorMock: MockViewModelInjector = DaggerMockViewModelInjector
        .builder()
        .repositoryModule(MockRepositoryModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MovieListViewModel -> injector.inject(this)
            is MovieViewModel -> injector.inject(this)
        }
    }
}
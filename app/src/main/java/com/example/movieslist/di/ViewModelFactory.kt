package com.example.movieslist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieslist.ui.MovieListViewModel
import com.example.movieslist.ui.MovieViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieListViewModel() as T
        }
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
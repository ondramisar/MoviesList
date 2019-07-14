package com.example.movieslist.network.mock

import androidx.paging.DataSource
import com.example.movieslist.db.models.Movie

class MockMovieDataSourceFactory() : DataSource.Factory<Int, Movie>() {
    override fun create(): DataSource<Int, Movie> {
        return MockMovieDataSource()
    }
}
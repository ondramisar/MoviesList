package com.example.movieslist.network

import androidx.paging.DataSource
import com.example.movieslist.db.models.Movie

class MovieDataSourceFactory(private val api:NetworkApi) : DataSource.Factory<Int, Movie>() {
    override fun create(): DataSource<Int, Movie> {
        return MovieDataSource(api)
    }
}
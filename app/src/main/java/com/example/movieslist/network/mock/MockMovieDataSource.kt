package com.example.movieslist.network.mock

import androidx.paging.PageKeyedDataSource
import com.example.movieslist.db.models.Movie

class MockMovieDataSource : PageKeyedDataSource<Int, Movie>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        val list = arrayListOf<Movie>()
        list.add(Movie(1, "TITLE", "OVERVIEW", ""))
        list.add(Movie(2, "TITLE", "OVERVIEW", ""))
        list.add(Movie(3, "TITLE", "OVERVIEW", ""))
        val nextPage = 2
        callback.onResult(list, null, nextPage)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val list = arrayListOf<Movie>()
        list.add(Movie(1, "TITLE", "OVERVIEW", ""))
        list.add(Movie(2, "TITLE", "OVERVIEW", ""))
        list.add(Movie(3, "TITLE", "OVERVIEW", ""))
        val key = if (5 > params.key) {
            params.key + 1
        } else {
            null
        }
        callback.onResult(list, key)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val list = arrayListOf<Movie>()
        list.add(Movie(1, "TITLE", "OVERVIEW", ""))
        list.add(Movie(2, "TITLE", "OVERVIEW", ""))
        list.add(Movie(3, "TITLE", "OVERVIEW", ""))
        val key = if (params.key > 0) {
            params.key - 1
        } else {
            null
        }
        callback.onResult(list, key)
    }
}
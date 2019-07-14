package com.example.movieslist.network

import androidx.paging.PagedList
import com.example.movieslist.db.models.Movie
import com.example.movieslist.db.models.MovieDetail
import io.reactivex.Flowable

interface IMovieRepository {
    fun getMovies(): Flowable<PagedList<Movie>>
    fun getMovieDetail(id: Int): Flowable<MovieDetail>
}

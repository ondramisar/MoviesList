package com.example.movieslist.network

import com.example.movieslist.db.models.MovieDetail
import com.example.movieslist.db.models.Response
import com.example.movieslist.utils.API_KEY
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApi {

    @GET("discover/movie?api_key=$API_KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false")
    fun getMovies(@Query(value = "page", encoded = true) page: Int): Flowable<Response>

    @GET("movie/{id}?api_key=$API_KEY&language=en-US")
    fun getMovieDetail(@Path(value = "id", encoded = true) id: Int): Flowable<MovieDetail>
}
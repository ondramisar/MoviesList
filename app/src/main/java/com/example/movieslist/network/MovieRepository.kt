package com.example.movieslist.network

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.movieslist.base.BaseRepository
import com.example.movieslist.db.models.Movie
import com.example.movieslist.db.models.MovieDetail
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import javax.inject.Inject

class MovieRepository : BaseRepository(), IMovieRepository {
    @Inject
    lateinit var postApi: NetworkApi

    override fun getMovies(): Flowable<PagedList<Movie>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(50)
            .setPageSize(50)
            .build()

        return RxPagedListBuilder(MovieDataSourceFactory(postApi), pagedListConfig).buildFlowable(
            BackpressureStrategy.DROP
        )
    }

    override fun getMovieDetail(id: Int): Flowable<MovieDetail> {
        return postApi.getMovieDetail(id)
    }
}
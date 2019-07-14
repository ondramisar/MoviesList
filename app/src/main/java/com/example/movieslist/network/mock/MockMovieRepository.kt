package com.example.movieslist.network.mock

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.movieslist.db.models.Movie
import com.example.movieslist.db.models.MovieDetail
import com.example.movieslist.network.IMovieRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

class MockMovieRepository : IMovieRepository {
    override fun getMovies(): Flowable<PagedList<Movie>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(50)
            .setPageSize(50)
            .build()

        return RxPagedListBuilder(MockMovieDataSourceFactory(), pagedListConfig).buildFlowable(
            BackpressureStrategy.DROP
        )
    }

    override fun getMovieDetail(id: Int): Flowable<MovieDetail> {
        return Flowable.just(MovieDetail(1, "TITLE", "OVERVIEW", "", "1999-10-12", arrayListOf(), arrayListOf()))
    }
}

package com.example.movieslist.network

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.movieslist.db.models.Movie
import com.example.movieslist.db.models.Response
import io.reactivex.subscribers.DisposableSubscriber

@SuppressLint("CheckResult")
class MovieDataSource(val api: NetworkApi) :
    PageKeyedDataSource<Int, Movie>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        api.getMovies(1)
            .doOnSubscribe { Log.d("DATASourceMaine", it.toString()) }
            .doOnTerminate { Log.d("DATASourceMaine", "TERMINATE") }
            .subscribeWith(object : DisposableSubscriber<Response>() {
                override fun onComplete() {
                    this.dispose()
                }

                override fun onNext(t: Response) {
                    val nextPage = 2
                    callback.onResult(t.results, null, nextPage)
                    this.dispose()
                }

                override fun onError(t: Throwable?) {
                    Log.d("DATASourceMaine", t?.message)
                    this.dispose()
                }
            })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        api.getMovies(params.key)
            .doOnSubscribe { Log.d("DATASourceMaine", it.toString()) }
            .doOnTerminate { Log.d("DATASourceMaine", "TERMINATE") }
            .subscribeWith(object : DisposableSubscriber<Response>() {
                override fun onComplete() {
                    this.dispose()
                }

                override fun onNext(t: Response) {
                    val key = if (t.total_pages > params.key) {
                        params.key + 1
                    } else {
                        null
                    }
                    callback.onResult(t.results, key)
                    this.dispose()
                }

                override fun onError(t: Throwable?) {
                    Log.d("DATASourceMaine", t?.message)
                    this.dispose()
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        api.getMovies(params.key)
            .doOnSubscribe { Log.d("DATASourceMaine", it.toString()) }
            .doOnTerminate { Log.d("DATASourceMaine", "TERMINATE") }
            .subscribeWith(object : DisposableSubscriber<Response>() {
            override fun onComplete() {
                this.dispose()
            }

            override fun onNext(t: Response) {
                val key = if (params.key > 0) {
                    params.key - 1
                } else {
                    null
                }
                callback.onResult(t.results, key)
                this.dispose()
            }

            override fun onError(t: Throwable?) {
                Log.d("DATASourceMaine", t?.message)
                this.dispose()
            }
        })
    }

    /*  @SuppressLint("CheckResult")
      override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Movie>) {
   //       api.getMovies("changes?api_key=$API_KEY&page=${params.startPosition}")
          api.getMovies("discover/movie?api_key=$API_KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&${params.startPosition}")
              .doOnSubscribe { Log.d("DATASourceMaine", it.toString()) }
              .doOnTerminate { Log.d("DATASourceMaine", "TERMINATE") }
              .subscribe(
                  { result ->
                    /*  val list = arrayListOf<Movie>()
                      result.results.forEach {
                          api.getMovieDetail("${it.id}?api_key=$API_KEY&language=en-US")
                              .subscribeOn(Schedulers.io())
                              .observeOn(AndroidSchedulers.mainThread())
                              .doOnSubscribe { Log.d("DATASourceMaine", it.toString()) }
                              .doOnTerminate { Log.d("DATASourceMaine", "TERMINATE") }
                              .subscribe(
                                  { result -> list.add(result)},
                                  {
                                      Log.d("DATASourceMaine", it.message)
                                  }
                              )
                      }*/
                      callback.onResult(result.results)
                  },
                  {
                      Log.d("DATASourceMaine", it.message)
                  }
              )
      }

      override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Movie>) {
          api.getMovies("discover/movie?api_key=$API_KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
              .doOnSubscribe { Log.d("DATASourceMaine", it.toString()) }
              .doOnTerminate { Log.d("DATASourceMaine", "TERMINATE") }
              .subscribe(
                  { result ->
                      /*val list = arrayListOf<Movie>()
                      result.results.forEach {
                          api.getMovieDetail("${it.id}?api_key=$API_KEY&language=en-US")
                              .subscribeOn(Schedulers.io())
                              .observeOn(AndroidSchedulers.mainThread())
                              .doOnSubscribe { Log.d("DATASourceMaine", it.toString()) }
                              .doOnTerminate { Log.d("DATASourceMaine", "TERMINATE") }
                              .subscribe(
                                  { result -> list.add(result)},
                                  {
                                      Log.d("DATASourceMaine", it.message)
                                  }
                              )
                      }*/
                      callback.onResult(result.results, params.requestedStartPosition, 20)
                  },
                  {
                      Log.d("DATASourceMaine", it.message)
                  }
              )
      }*/
}
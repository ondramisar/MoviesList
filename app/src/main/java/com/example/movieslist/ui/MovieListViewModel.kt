package com.example.movieslist.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.movieslist.base.BaseViewModel
import com.example.movieslist.db.models.Movie
import com.example.movieslist.network.IMovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieListViewModel : BaseViewModel() {
    @Inject
    lateinit var repository: IMovieRepository

    val loadingVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val loadedData: MutableLiveData<PagedList<Movie>> = MutableLiveData()

    val retryClick = View.OnClickListener {
        loadPosts()
    }

    private lateinit var subscription: Disposable

    init {
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts() {
        subscription = repository.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError(it.message) }
            )

    }

    private fun onRetrievePostListStart() {
        loadingVisibility.postValue(true)
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.postValue(false)
    }

    private fun onRetrievePostListSuccess(postList: PagedList<Movie>) {
        loadingVisibility.postValue(false)
        loadedData.postValue(postList)
    }

    private fun onRetrievePostListError(message: String?) {
        errorMessage.value = message
    }
}
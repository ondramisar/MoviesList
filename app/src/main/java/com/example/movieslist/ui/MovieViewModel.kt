package com.example.movieslist.ui

import androidx.lifecycle.MutableLiveData
import com.example.movieslist.base.BaseViewModel
import com.example.movieslist.db.models.MovieDetail
import com.example.movieslist.network.IMovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieViewModel : BaseViewModel() {
    @Inject
    lateinit var repository: IMovieRepository

    val loadingVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val loadedData: MutableLiveData<MovieDetail> = MutableLiveData()

    private lateinit var subscription: Disposable

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun getMovieDetail(id: Int) {
        subscription = repository.getMovieDetail(id)
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

    private fun onRetrievePostListSuccess(postList: MovieDetail) {
        loadedData.postValue(postList)
    }

    private fun onRetrievePostListError(message: String?) {
        errorMessage.value = message
    }
}
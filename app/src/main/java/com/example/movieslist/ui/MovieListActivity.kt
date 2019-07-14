package com.example.movieslist.ui


import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslist.R
import com.example.movieslist.di.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {

    val TAG = "MovieListActivity"

    private lateinit var viewModel: MovieListViewModel
    private lateinit var errorSnackBar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val isLargeLayout = resources.getBoolean(R.bool.isLargeLayout)
        if (isLargeLayout) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            recycler.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        } else {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            recycler.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        }

        toolbar.title = resources.getString(R.string.movies)
        setSupportActionBar(toolbar)

        errorSnackBar = Snackbar.make(content, R.string.loading, Snackbar.LENGTH_INDEFINITE)

        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(MovieListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError() else hideError()
        })
        viewModel.loadingVisibility.observe(this, Observer { loading ->
            if (loading) {
                content.visibility = View.GONE
                progress_bar.visibility = View.VISIBLE
            } else {
                content.visibility = View.VISIBLE
                progress_bar.visibility = View.GONE
            }
        })

        val adapter = MovieListAdapter()
        recycler.adapter = adapter
        viewModel.loadedData.observe(this, Observer {
            Log.d(TAG, "Movies loaded")
            adapter.submitList(it)
        })

    }

    private fun showError() {
        error_text.visibility = View.VISIBLE
        error_text.text = resources.getString(R.string.loading_text)
        errorSnackBar.setAction(R.string.retry, viewModel.retryClick)
        errorSnackBar.show()
    }

    private fun hideError() {
        error_text.visibility = View.GONE
        errorSnackBar.dismiss()
    }
}

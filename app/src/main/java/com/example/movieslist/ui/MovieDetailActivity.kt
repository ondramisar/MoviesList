package com.example.movieslist.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movieslist.R
import com.example.movieslist.di.ViewModelFactory
import com.example.movieslist.utils.IMAGE_URL
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movie_detail.*
import java.text.SimpleDateFormat


class MovieDetailActivity : AppCompatActivity() {

    val TAG = "MovieDetailActivity"

    private lateinit var viewModel: MovieViewModel
    private lateinit var errorSnackBar: Snackbar
    private var id: Int = 0

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val isLargeLayout = resources.getBoolean(R.bool.isLargeLayout)
        requestedOrientation = if (isLargeLayout) {
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        errorSnackBar = Snackbar.make(main_container, R.string.loading, Snackbar.LENGTH_INDEFINITE)

        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(MovieViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError() else hideError()
        })
        viewModel.loadingVisibility.observe(this, Observer { loading ->
            if (loading) {
                movie_detail_container.visibility = View.GONE
                progress_bar_detail.visibility = View.VISIBLE
            } else {
                movie_detail_container.visibility = View.VISIBLE
                progress_bar_detail.visibility = View.GONE
            }
        })

        id = intent.getIntExtra("ID", 0)

        viewModel.getMovieDetail(id)

        viewModel.loadedData.observe(this, Observer {
            Log.d(TAG, "Movie detail loaded")

            Glide
                .with(this)
                .load(IMAGE_URL + it.backdrop_path)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image_detail)

            title_detail.text = it.title

            overview.text = it.overview

            var format = SimpleDateFormat("yyyy-MM-dd")
            val newDate = format.parse(it.release_date)
            format = SimpleDateFormat("dd MMM yyyy ")
            val date = format.format(newDate)
            release_date.text = String.format(resources.getString(R.string.release_date), date)


            language.text = String.format(resources.getString(R.string.language), it.spoken_languages[0].name)

            val string = StringBuilder()
            string.append(resources.getString(R.string.genres))
            it.genres.forEachIndexed { index, genre ->
                string.append(" ")
                string.append(genre.name)
                if (index != it.genres.size - 1)
                    string.append(",")
            }
            genre.text = string

            supportActionBar?.title = it.title
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showError() {
        error_text_detail.visibility = View.VISIBLE
        error_text_detail.text = resources.getString(R.string.loading_text)
        errorSnackBar.setAction(R.string.retry) {
            viewModel.getMovieDetail(id)
        }
        errorSnackBar.show()
    }

    private fun hideError() {
        error_text_detail.visibility = View.GONE
        errorSnackBar.dismiss()
    }
}

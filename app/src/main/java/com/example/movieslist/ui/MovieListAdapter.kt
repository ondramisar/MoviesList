package com.example.movieslist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.movieslist.R
import com.example.movieslist.base.BaseViewHolder
import com.example.movieslist.db.models.Movie

class MovieListAdapter : PagedListAdapter<Movie, BaseViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldConcert: Movie, newConcert: Movie) = oldConcert.id == newConcert.id

            override fun areContentsTheSame(oldConcert: Movie, newConcert: Movie) = oldConcert == newConcert
        }
    }
}
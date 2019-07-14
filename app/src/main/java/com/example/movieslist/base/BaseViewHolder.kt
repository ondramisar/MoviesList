package com.example.movieslist.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslist.db.models.Movie

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(movie: Movie)
}
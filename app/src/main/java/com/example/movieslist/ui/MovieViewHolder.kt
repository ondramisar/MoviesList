package com.example.movieslist.ui

import android.content.Intent
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movieslist.base.BaseViewHolder
import com.example.movieslist.db.models.Movie
import com.example.movieslist.utils.IMAGE_URL
import com.example.movieslist.utils.extencion.getParentActivity
import kotlinx.android.synthetic.main.movie_item_list.view.*

class MovieViewHolder(itemView: View) : BaseViewHolder(itemView) {

    override fun bind(movie: Movie) {
        itemView.text.text = movie.title

        Glide
            .with(itemView.context)
            .load(IMAGE_URL + movie.backdrop_path)
            //   .placeholder(R.drawable.place_holder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(itemView.image)

        itemView.setOnClickListener {
            val i = Intent(itemView.getParentActivity(), MovieDetailActivity::class.java)
            i.putExtra("ID", movie.id)
            itemView.getParentActivity()?.startActivity(i)
        }
    }
}
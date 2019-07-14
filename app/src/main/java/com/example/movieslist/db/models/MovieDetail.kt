package com.example.movieslist.db.models



data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val backdrop_path: String,
    val release_date: String,
    val genres: List<Genre>,
    val spoken_languages: List<Language>
)
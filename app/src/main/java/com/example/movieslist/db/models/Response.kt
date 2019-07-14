package com.example.movieslist.db.models

data class Response(val results: List<Movie>, val page: Int, val total_results: Int, val total_pages: Int)
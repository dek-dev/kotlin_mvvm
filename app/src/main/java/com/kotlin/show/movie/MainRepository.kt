package com.kotlin.show.movie

import com.kotlin.show.movie.movie.MovieService

class MainRepository constructor(private val movieService: MovieService) {

    suspend fun getAllMovies() = movieService.getAllMovies()
}
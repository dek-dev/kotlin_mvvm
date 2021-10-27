package com.kotlin.show.movie.movie

import com.google.gson.annotations.SerializedName

data class MovieModel(

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)

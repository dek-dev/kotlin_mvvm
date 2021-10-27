package com.kotlin.show.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.kotlin.show.movie.databinding.AdapterMovieBinding
import com.kotlin.show.movie.movie.MovieModel

class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var movieList = mutableListOf<MovieModel>()

    fun setMovies(movies: List<MovieModel>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context)
            .load(movie.imageUrl)
            .apply {
                    override(768, 1024)
                    placeholder(progressDrawable(holder.itemView.context))
                    skipMemoryCache(true)
            }.into(holder.binding.imageview)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    private fun progressDrawable(context: Context): CircularProgressDrawable? {
        val circularProgressDrawable = CircularProgressDrawable(context);
        circularProgressDrawable.strokeWidth = 7f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.setColorSchemeColors(context.getColor(R.color.purple_200))
        circularProgressDrawable.start()
        return circularProgressDrawable
    }
}



class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}
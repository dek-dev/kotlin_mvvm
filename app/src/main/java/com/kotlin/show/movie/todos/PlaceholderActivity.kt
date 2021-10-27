package com.kotlin.show.movie.todos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.kotlin.show.movie.MainRepository
import com.kotlin.show.movie.MainViewModel
import com.kotlin.show.movie.MyViewModelFactory
import com.kotlin.show.movie.databinding.ActivityPlaceholderBinding
import com.kotlin.show.movie.movie.MovieService
import com.kotlin.show.movie.todos.service.TodosService

class PlaceholderActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlaceholderBinding
    lateinit var todosViewModel: TodosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceholderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainRepository = TodosRepository(TodosService.getInstance())

        todosViewModel = ViewModelProvider(this, TodosViewModelFactory(mainRepository)).get(TodosViewModel::class.java)
        todosViewModel.getAllTodos()

        todosViewModel.todosModel.observe(this, {
            Log.d("ininxzczxc", Gson().toJson(it))
        })

    }

}
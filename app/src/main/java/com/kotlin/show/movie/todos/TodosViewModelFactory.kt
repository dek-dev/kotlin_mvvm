package com.kotlin.show.movie.todos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TodosViewModelFactory constructor(private val todosRepository: TodosRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TodosViewModel::class.java)) {
            TodosViewModel(this.todosRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
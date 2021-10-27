package com.kotlin.show.movie.todos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.show.movie.movie.MovieModel
import com.kotlin.show.movie.todos.service.TodosModel
import kotlinx.coroutines.*

class TodosViewModel constructor(private val todosRepository: TodosRepository) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val todosModel = MutableLiveData<List<TodosModel>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllTodos() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = todosRepository.getAllTodos()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    todosModel.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
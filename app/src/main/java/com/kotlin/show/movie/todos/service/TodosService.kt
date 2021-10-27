package com.kotlin.show.movie.todos.service

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TodosService {

    @GET("todos")
    suspend fun getAllTodos() : Response<List<TodosModel>>

    companion object {
        var retrofitService: TodosService? = null
        fun getInstance() : TodosService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(TodosService::class.java)
            }
            return retrofitService!!
        }

    }
}
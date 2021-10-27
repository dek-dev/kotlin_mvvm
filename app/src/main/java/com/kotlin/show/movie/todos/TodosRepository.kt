package com.kotlin.show.movie.todos

import com.kotlin.show.movie.todos.service.TodosService

class TodosRepository constructor(private val todosService: TodosService) {
    suspend fun getAllTodos() = todosService.getAllTodos()
}
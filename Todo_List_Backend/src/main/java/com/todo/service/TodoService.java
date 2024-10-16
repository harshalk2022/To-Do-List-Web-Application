package com.todo.service;

import java.util.List;

import com.todo.model.Todo;

//Abstract method for performing CRUD on entity Todo
public interface TodoService {

	// Method to save Todo Details
	Todo saveTodo(Todo todo);

	// Method to fetch All Todo
	List<Todo> getAllTodos();

	// Method to fetch Todo details using Id
	Todo getTodoById(long id);

	// Method to update Todo details based on id
	Todo updateTodoById(Todo todo, long id);

	// Method to delete Todo based on id
	void deleteTodoById(long id);

}

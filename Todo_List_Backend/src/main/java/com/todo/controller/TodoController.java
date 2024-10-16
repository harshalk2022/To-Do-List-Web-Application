package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Todo;
import com.todo.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
//Rest controller to handle all incoming request using REST API
public class TodoController {

	@Autowired
	private TodoService todoService;


	//gsfds
	// Saving Todo details using Post Mapping
	@PostMapping("/todos")
	public ResponseEntity<Todo> saveTodo(@Valid @RequestBody Todo todo) {
		return new ResponseEntity<Todo>(todoService.saveTodo(todo), HttpStatus.CREATED);
	}

	// fetching All Todo details using Get Mapping
	@GetMapping("/todos")
	public List<Todo> getAllTodo() {
		return todoService.getAllTodos();
	}

	// fetching Todo details by Id using Get Mapping
	@GetMapping("/todos/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable("id") long id) {
		return new ResponseEntity<Todo>(todoService.getTodoById(id), HttpStatus.OK);
	}

	// Updating Todo details by id using put mapping
	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") long id, @RequestBody Todo todo) {
		return new ResponseEntity<Todo>(todoService.updateTodoById(todo, id), HttpStatus.OK);
	}

	// Deleting Todo details by id using Delete Mapping
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable("id") long id) {
		todoService.deleteTodoById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
}

package com.todo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.exception.TodoNotFoundException;
import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoService;

@Service
//Implement all CRUD methods, all business logic
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	// Saving Todo details into table using save() of JPA Repository
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	// fetching all Todos from table
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	// fetching Todo details from table based on id, if not found then throw
	public Todo getTodoById(long id) {
		return todoRepository.findById(id)
				.orElseThrow(() -> new TodoNotFoundException("Entered Todo Id dose not exits" + id));
	}

	@Override
	// Updating Todo details based on id from table using save()
	public Todo updateTodoById(Todo todo, long id) {
		Todo newTodo = todoRepository.findById(id)
				.orElseThrow(() -> new TodoNotFoundException("Entered Todo Id dose not exits" + id));

		// Set new values
		newTodo.setTitle(todo.getTitle());
		newTodo.setDescription(todo.getDescription());
		newTodo.setisCompleted(todo.getisCompleted());

		// Saving updated Todo Details
		todoRepository.save(newTodo);
		return newTodo;

	}

	@Override
	// Delete Todo Based on Id using deleteById()
	public void deleteTodoById(long id) {
		todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Entered Todo Id dose not exits" + id));
		todoRepository.deleteById(id);

	}

}

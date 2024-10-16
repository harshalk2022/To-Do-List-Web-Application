import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css'],
})
export class TodoListComponent implements OnInit {
  // todos!: Todo[];

  todos: Todo[] = [];

  constructor(
    private todoService: TodoService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.getTodos();
  }

  private getTodos() {
    this.todoService.getTodosList().subscribe((data) => {
      this.todos = data;
    });
  }

  todoDetails(id: number) {
    this.router.navigate(['todo-details', id]);
  }

  updateTodo(id: number) {
    this.router.navigate(['update-todo', id]);
  }

  deleteTodo(id: number) {
    this.todoService.deleteTodo(id).subscribe((data) => {
      console.log(data);
    });
    this.todos = this.todos.filter((item) => item.id != id);
  }
}

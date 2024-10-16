import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from './todo';
import { map } from 'rxjs/operators'; // Import map operator
import { environment } from '../env';

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  // Access environment variables
  private baseURl = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  getTodosList(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(`${this.baseURl}`).pipe(
      map((todos) =>
        todos.map((todo) => ({
          ...todo,
          createdAt: new Date(todo.createdAt), // Convert string to Date object
        })),
      ),
    );
  }

  createTodo(todo: Todo): Observable<object> {
    return this.httpClient.post(`${this.baseURl}`, todo);
  }

  getTodoById(id: number): Observable<Todo> {
    return this.httpClient.get<Todo>(`${this.baseURl}/${id}`);
  }

  updateTodo(id: number, todo: Todo): Observable<Object> {
    return this.httpClient.put(`${this.baseURl}/${id}`, todo);
  }

  deleteTodo(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURl}/${id}`, {
      responseType: 'text',
    });
  }
}

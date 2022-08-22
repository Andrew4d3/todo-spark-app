package app.repository;

import app.entities.Todo;

import java.util.ArrayList;

public interface TodoRepository {
    void addTodo(Todo todo);
    Todo getTodo(String id);
    ArrayList<Todo> getTodos();
    void deleteTodo(String id) throws Exception;
    public Todo updateTodo(Todo todo);
}

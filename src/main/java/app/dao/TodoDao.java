package app.dao;

import app.dto.TodoPayload;
import app.entities.Todo;
import app.repository.TodoRepository;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.UUID;

public class TodoDao {
    private final TodoRepository repo;

    public TodoDao(TodoRepository repo) {
        this.repo = repo;
    }

    public Todo createTodo(TodoPayload todoPayload) {
        Todo todo = Todo.createTodoFromPayload(todoPayload);
        repo.addTodo(todo);

        return todo;
    }

    public Todo getTodo(String id) {
        return repo.getTodo(id);
    }

    public ArrayList<Todo> listTodos() {
        return repo.getTodos();
    }

    public void deleteTodo(String id) throws Exception {
        Todo todo = repo.getTodo(id);
        if (todo == null) {
            throw new Exception("Todo not found");
        }

        repo.deleteTodo(id);
    }

    public Todo updateTodo(String id, JSONObject jsonInput) throws Exception {
        Todo todo = repo.getTodo(id);
        if (todo == null) {
            throw new Exception("Todo not found");
        }

        Todo newTodo = repo.updateTodo(todo.mergeWithJSON(jsonInput));

        return newTodo;
    }
}

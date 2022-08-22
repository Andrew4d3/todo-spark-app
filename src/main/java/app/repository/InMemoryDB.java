package app.repository;

import app.entities.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDB implements TodoRepository {
    private static InMemoryDB db;
    private final HashMap<String, Todo> todos;

    private InMemoryDB() {
        this.todos = new HashMap<String, Todo>();
    }

    public static InMemoryDB getDb() {
        if (db == null) {
            db = new InMemoryDB();
        }

        return db;
    }

    public Todo updateTodo(Todo todo) {
        addTodo(todo);
        return todo;
    }

    public void addTodo(Todo todo) {
        db.todos.put(todo.getId(), todo);
    }

    public Todo getTodo(String id) {
        return todos.get(id);
    }

    public ArrayList<Todo> getTodos() {
        ArrayList<Todo> todoList = new ArrayList<>();

        for (Map.Entry<String, Todo> set : todos.entrySet()) {
            todoList.add(set.getValue());
        }

        return todoList;
    }

    public void deleteTodo(String id) {
        todos.remove(id);
    }
}

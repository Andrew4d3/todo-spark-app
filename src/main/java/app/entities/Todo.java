package app.entities;

import app.dto.TodoPayload;
import app.repository.jooq_repo.tables.records.TodosRecord;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.UUID;

public class Todo {
    private String id;

    private String description;

    private boolean done;

    public static Todo createTodoFromPayload(TodoPayload todoPayload) {
        Todo todo = new Todo();
        todo.id = UUID.randomUUID().toString();
        todo.description = todoPayload.description;
        todo.done = todoPayload.done;

        return todo;
    }

    public static Todo creteTodoFromRecord(TodosRecord todosRecord) {
        Todo todo = new Todo();
        todo.id = todosRecord.getId();
        todo.description = todosRecord.getDescription();
        todo.done = todosRecord.getDone() == 1;

        return todo;
    }

    public Todo mergeWithJSON(JSONObject jsonInput) {
        Todo newTodo = new Todo();

        newTodo.id = id;
        newTodo.description = jsonInput.has("description") ? jsonInput.getString("description") : description;
        newTodo.done = jsonInput.has("done") ? jsonInput.getBoolean("done") : done;

        return newTodo;
    }

    public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public boolean getDone() {
        return done;
    }
}

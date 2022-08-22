package app;
import app.controllers.TodoController;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import test.generated.tables.Author;

import java.sql.Connection;
import java.sql.DriverManager;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");

        get("/todos/:id", TodoController.getTodo);
        get("/todos", TodoController.listTodos);
        post("/todos", TodoController.createTodo);
        put("/todos/:id", TodoController.updateTodo);
        delete("/todos/:id", TodoController.removeTodo);
    }
}

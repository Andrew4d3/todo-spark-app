package app.controllers;

import app.dao.TodoDao;
import app.dto.TodoPayload;
import app.entities.Todo;
import app.repository.InMemoryDB;
import app.repository.MySQLDB;
import com.google.gson.Gson;
import org.jooq.exception.DataAccessException;
import org.json.JSONObject;
import spark.*;

import java.util.ArrayList;

public class TodoController {

    private static String buildJSON(Response res, int statusCode, Object object) {
        res.status(statusCode);
        res.type("application/json");
        return new Gson().toJson(object);
    }

    private static String returnNotFound(Response res) {
        res.status(404);
        return "No todo found";
    }

    private static String returnServerError(Response res, String msg) {
        res.status(500);
        return "Internal Server Error: " + msg;
    }
    public static Route createTodo = (Request req, Response res) -> {
        try {
            TodoPayload todoPayload = new Gson().fromJson(req.body(), TodoPayload.class);

            TodoDao todoDao = new TodoDao(MySQLDB.getDb());
            Todo todo = todoDao.createTodo(todoPayload);


            return buildJSON(res, 201, todo);
        } catch (Exception e) {
            return returnServerError(res, e.toString());
        }
    };

    public static Route getTodo = (Request req, Response res) -> {
        try {
            String todoId = req.params("id");

            TodoDao todoDao = new TodoDao(MySQLDB.getDb());
            Todo todo = todoDao.getTodo(todoId);

            if (todo == null) {
                return returnNotFound(res);
            }

            return buildJSON(res, 200, todo);

        } catch (Exception e) {
            return returnServerError(res, e.toString());
        }
    };

    public static Route listTodos = (Request req, Response res) -> {
        try {
            TodoDao todoDao = new TodoDao(MySQLDB.getDb());
            ArrayList<Todo> allTodos = todoDao.listTodos();

            return buildJSON(res, 200, allTodos);
        } catch (Exception e) {
            return returnServerError(res, e.toString());
        }
    };

    public static Route removeTodo = (Request req, Response res) -> {
        String todoId = req.params("id");

        try {
            TodoDao todoDao = new TodoDao(MySQLDB.getDb());
            todoDao.deleteTodo(todoId);

            res.status(204);
            return "";
        } catch (Exception e) {
            if (e instanceof DataAccessException) {
                return returnServerError(res, e.toString());
            }
            return returnNotFound(res);
        }
    };

    public static Route updateTodo = (Request req, Response res) -> {
        String todoId = req.params("id");
        JSONObject jsonInput = new JSONObject(req.body());

        try {
            TodoDao todoDao = new TodoDao(MySQLDB.getDb());
            Todo todo = todoDao.updateTodo(todoId, jsonInput);
            return buildJSON(res, 200, todo);
        } catch (Exception e) {
            if (e instanceof DataAccessException) {
                return returnServerError(res, e.toString());
            }
            return returnNotFound(res);
        }
    };
}

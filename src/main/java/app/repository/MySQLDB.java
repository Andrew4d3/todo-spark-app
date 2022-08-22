package app.repository;

import app.entities.Todo;
import app.repository.jooq_repo.TodoDb;
import app.repository.jooq_repo.tables.Todos;
import app.repository.jooq_repo.tables.records.TodosRecord;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDB implements TodoRepository{
    private static MySQLDB db;

    private final DSLContext dslContext;
    private final Todos TODOS = Todos.TODOS;

    private MySQLDB(DSLContext dslContext) {
        this.dslContext = dslContext;
    }


    public static MySQLDB getDb() throws SQLException {
        if (db == null) {
            db = new MySQLDB(TodoDb.createDslContext());
        }
        return db;
    }

    @Override
    public void addTodo(Todo todo) throws DataAccessException {
        dslContext.insertInto(this.TODOS, this.TODOS.ID, this.TODOS.DESCRIPTION, this.TODOS.DONE)
                .values(todo.getId(), todo.getDescription(), (byte) (todo.getDone() ? 1:0)).execute();

    }

    @Override
    public Todo getTodo(String id) throws DataAccessException {
        TodosRecord todosRecord = dslContext.selectFrom(this.TODOS).where(this.TODOS.ID.eq(id)).fetchOne();

        if (todosRecord != null) {
            return Todo.creteTodoFromRecord(todosRecord);
        }

        return null;
    }

    @Override
    public ArrayList<Todo> getTodos() throws DataAccessException {
        Result<TodosRecord> result = dslContext.selectFrom(this.TODOS).fetch();
        List<TodosRecord> todosRecordList = result.stream().toList();

        ArrayList<Todo> todoArrayList = new ArrayList<>();

        for (TodosRecord todosRecord : todosRecordList ) {
            todoArrayList.add(Todo.creteTodoFromRecord(todosRecord));
        }

        return todoArrayList;
    }

    @Override
    public void deleteTodo(String id) throws DataAccessException {
        dslContext.delete(this.TODOS).where(this.TODOS.ID.eq(id)).execute();
    }

    public Todo updateTodo(Todo todo) throws DataAccessException {
        dslContext.update(this.TODOS)
                .set(this.TODOS.DESCRIPTION, todo.getDescription())
                .set(this.TODOS.DONE, (byte) (todo.getDone() ? 1 : 0))
                .where(this.TODOS.ID.eq(todo.getId()))
                .execute();

        return todo;
    }
}

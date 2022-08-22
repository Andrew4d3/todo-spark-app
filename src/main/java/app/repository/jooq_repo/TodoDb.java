/*
 * This file is generated by jOOQ.
 */
package app.repository.jooq_repo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import app.repository.MySQLDB;
import org.jooq.Catalog;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.impl.SchemaImpl;

import app.repository.jooq_repo.tables.Todos;
import org.jooq.meta.derby.sys.Sys;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TodoDb extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>todo-db</code>
     */
    public static final TodoDb TODO_DB = new TodoDb();

    /**
     * The table <code>todo-db.todos</code>.
     */
    public final Todos TODOS = Todos.TODOS;

    /**
     * No further instances allowed
     */
    private TodoDb() {
        super("todo-db", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Todos.TODOS
        );
    }

    public static DSLContext createDslContext() throws SQLException {
        String userName = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        String url = System.getenv("DB_URI");

        Connection conn = DriverManager.getConnection(url, userName, password);
        DSLContext dslContext = DSL.using(conn, SQLDialect.MYSQL);
        return dslContext;
    }
}

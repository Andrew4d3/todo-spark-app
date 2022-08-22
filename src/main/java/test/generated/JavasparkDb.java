/*
 * This file is generated by jOOQ.
 */
package test.generated;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import test.generated.tables.Author;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JavasparkDb extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>javaspark-db</code>
     */
    public static final JavasparkDb JAVASPARK_DB = new JavasparkDb();

    /**
     * The table <code>javaspark-db.author</code>.
     */
    public final Author AUTHOR = Author.AUTHOR;

    /**
     * No further instances allowed
     */
    private JavasparkDb() {
        super("javaspark-db", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Author.AUTHOR
        );
    }
}

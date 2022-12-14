/*
 * This file is generated by jOOQ.
 */
package app.repository.jooq_repo.tables.records;


import app.entities.Todo;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;

import app.repository.jooq_repo.tables.Todos;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TodosRecord extends TableRecordImpl<TodosRecord> implements Record3<String, String, Byte> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>todo-db.todos.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>todo-db.todos.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>todo-db.todos.description</code>.
     */
    public void setDescription(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>todo-db.todos.description</code>.
     */
    public String getDescription() {
        return (String) get(1);
    }

    /**
     * Setter for <code>todo-db.todos.done</code>.
     */
    public void setDone(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>todo-db.todos.done</code>.
     */
    public Byte getDone() {
        return (Byte) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, Byte> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, Byte> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Todos.TODOS.ID;
    }

    @Override
    public Field<String> field2() {
        return Todos.TODOS.DESCRIPTION;
    }

    @Override
    public Field<Byte> field3() {
        return Todos.TODOS.DONE;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getDescription();
    }

    @Override
    public Byte component3() {
        return getDone();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getDescription();
    }

    @Override
    public Byte value3() {
        return getDone();
    }

    @Override
    public TodosRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public TodosRecord value2(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public TodosRecord value3(Byte value) {
        setDone(value);
        return this;
    }

    @Override
    public TodosRecord values(String value1, String value2, Byte value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TodosRecord
     */
    public TodosRecord() {
        super(Todos.TODOS);
    }

    /**
     * Create a detached, initialised TodosRecord
     */
    public TodosRecord(String id, String description, Byte done) {
        super(Todos.TODOS);

        setId(id);
        setDescription(description);
        setDone(done);
    }
}

package com.tt1.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DBStubTest {
    @Test
    void DBStubTestEjercicio() {
        DBStub db = new DBStub();
        ToDo todo = new ToDo();
        assertThrows(UnsupportedOperationException.class, () -> db.crearToDo(todo));
    }
}
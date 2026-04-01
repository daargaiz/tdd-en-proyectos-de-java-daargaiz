package com.tt1.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DBStubTest {
    /*@Test
    void DBStubTestEjercicio() {
        DBStub db = new DBStub();
        ToDo todo = new ToDo();
        assertThrows(UnsupportedOperationException.class, () -> db.crearToDo(todo));
    }

     */
    @Test
    void creaYRecuperaToDos() {
        DBStub db = new DBStub();
        ToDo todo = new ToDo("Tarea1", "Desc", 100L, false);

        db.crearToDo(todo);

        assertEquals(todo, db.obtenerToDoPorNombre("Tarea1"));
        assertEquals(1, db.obtenerTodosLosToDos().size());
    }

    @Test
    void guardaYRecuperaEmails() {
        DBStub db = new DBStub();

        db.guardarEmail("prueba@test.com");

        assertEquals(1, db.obtenerEmails().size());
        assertEquals("prueba@test.com", db.obtenerEmails().getFirst());
    }

}
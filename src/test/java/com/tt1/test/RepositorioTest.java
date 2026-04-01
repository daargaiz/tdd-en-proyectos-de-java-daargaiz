package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {
    @Test
    void RepositorioTestEjercicio() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);

        assertThrows(UnsupportedOperationException.class, () -> repositorio.encontrarToDo("Tarea1"));
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void guardaYEncuentraToDo() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        ToDo todo = new ToDo("Tarea1", "Desc", 123L, false);

        repositorio.guardarToDo(todo);

        assertEquals(todo, repositorio.encontrarToDo("Tarea1"));
    }

    @Test
    void marcaComoCompletadoUnaTarea() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        repositorio.guardarToDo(new ToDo("Tarea1", "Desc", 123L, false));

        repositorio.marcarComoCompletado("Tarea1");

        assertTrue(repositorio.encontrarToDo("Tarea1").isCompletado());
    }

    @Test
    void guardaEmailEnLaBaseDeDatos() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);

        repositorio.guardarEmail("correo@test.com");

        assertEquals(1, repositorio.obtenerEmails().size());
    }
}
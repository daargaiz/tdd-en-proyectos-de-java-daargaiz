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
    void encontrarToDo() {
    }

    @Test
    void marcarComoCompletado() {
    }

    @Test
    void guardarToDo() {
    }

    @Test
    void guardarEmail() {
    }
}
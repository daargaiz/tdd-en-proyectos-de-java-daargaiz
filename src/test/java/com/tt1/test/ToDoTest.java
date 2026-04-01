package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {
    /*@Test
    void toDoTestEjercicio() {
        ToDo todo = new ToDo();
        assertThrows(UnsupportedOperationException.class, todo::getNombre);
    }
    */

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void constructorYGettersFuncionan() {
        ToDo todo = new ToDo("Tarea1", "Descripcion", 123L, false);

        assertEquals("Tarea1", todo.getNombre());
        assertEquals("Descripcion", todo.getDescripcion());
        assertEquals(123L, todo.getFechaLimite());
        assertFalse(todo.isCompletado());
    }

    @Test
    void settersActualizanValores() {
        ToDo todo = new ToDo();

        todo.setNombre("NuevaTarea");
        todo.setDescripcion("NuevaDescripcion");
        todo.setFechaLimite(999L);
        todo.setCompletado(true);

        assertEquals("NuevaTarea", todo.getNombre());
        assertEquals("NuevaDescripcion", todo.getDescripcion());
        assertEquals(999L, todo.getFechaLimite());
        assertTrue(todo.isCompletado());
    }
}
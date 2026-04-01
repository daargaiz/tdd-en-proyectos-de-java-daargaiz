package com.tt1.test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestIntegracion {
    /*@Test
    void repositorioYDBStubFuncionanJuntos() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        ToDo todo = new ToDo("Tarea1", "Desc", 123L, false);

        repositorio.guardarToDo(todo);

        assertEquals(todo, db.obtenerToDoPorNombre("Tarea1"));
    }

     */

    @Test
    void servicioRepositorioYMailerFuncionanJuntos() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);

        servicio.crearToDo("Tarea1", System.currentTimeMillis() - 1000);
        servicio.agregarDireccionEmail("correo@test.com");
        servicio.consultarToDosSinCompletar();

        assertEquals(1, repositorio.obtenerEmails().size());
        assertNotNull(repositorio.encontrarToDo("Tarea1"));
        assertFalse(mailer.getCorreosEnviados().isEmpty());
    }
}

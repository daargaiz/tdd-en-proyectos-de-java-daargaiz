package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    /*@Test
    void ServicioTestEjercicio() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);

        assertThrows(UnsupportedOperationException.class, servicio::consultarToDosSinCompletar);
    }
    
     */

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void crearToDoLoAlmacena() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);

        servicio.crearToDo("Tarea1", 123456789L);

        assertNotNull(repositorio.encontrarToDo("Tarea1"));
    }

    @Test
    void agregarDireccionEmailLaGuarda() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);

        servicio.agregarDireccionEmail("correo@test.com");

        assertEquals(1, repositorio.obtenerEmails().size());
    }

    @Test
    void marcarTareaComoFinalizadaLaCompleta() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);
        servicio.crearToDo("Tarea1", System.currentTimeMillis() + 5000);

        servicio.marcarTareaComoFinalizada("Tarea1");

        assertTrue(repositorio.encontrarToDo("Tarea1").isCompletado());
    }

    @Test
    void consultarToDosSinCompletarDevuelveSoloPendientes() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);
        servicio.crearToDo("Pendiente", System.currentTimeMillis() + 10000);
        servicio.crearToDo("Hecha", System.currentTimeMillis() + 10000);
        servicio.marcarTareaComoFinalizada("Hecha");

        List<ToDo> pendientes = servicio.consultarToDosSinCompletar();

        assertEquals(1, pendientes.size());
        assertEquals("Pendiente", pendientes.getFirst().getNombre());
    }

    @Test
    void enviarAlertasCuandoHayTareasVencidas() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);

        servicio.crearToDo("Vencida", System.currentTimeMillis() - 1000);
        servicio.agregarDireccionEmail("correo@test.com");
        servicio.consultarToDosSinCompletar();

        assertFalse(mailer.getCorreosEnviados().isEmpty());
        assertTrue(mailer.getCorreosEnviados().getFirst().contains("correo@test.com"));
        assertTrue(mailer.getCorreosEnviados().getFirst().contains("Vencida"));
    }
}
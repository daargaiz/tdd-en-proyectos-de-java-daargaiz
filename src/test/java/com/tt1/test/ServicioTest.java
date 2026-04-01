package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    @Test
    void ServicioTestEjercicio() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);

        assertThrows(UnsupportedOperationException.class, servicio::consultarToDosSinCompletar);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void crearToDo() {
    }

    @Test
    void agregarDireccionEmail() {
    }

    @Test
    void marcarTareaComoFinalizada() {
    }

    @Test
    void consultarToDosSinCompletar() {
    }
}
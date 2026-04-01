package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailerStubTest {

    @Test
    void MailerStubTestEjercicio() {
        MailerStub mailer = new MailerStub();

        assertThrows(UnsupportedOperationException.class, () -> mailer.enviarCorreo("prueva@test.com", "hola"));
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void enviarCorreoDevuelveTrueYLoRegistra() {
        MailerStub mailer = new MailerStub();

        boolean enviado = mailer.enviarCorreo("prueba@test.com", "hola");

        assertTrue(enviado);
        assertEquals(1, mailer.getCorreosEnviados().size());
        assertTrue(mailer.getCorreosEnviados().getFirst().contains("prueba@test.com"));
    }
}
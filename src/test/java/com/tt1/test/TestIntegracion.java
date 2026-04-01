package com.tt1.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestIntegracion {
    @Test
    void TestDependencia2() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        ToDo todo = new ToDo();

        assertThrows(UnsupportedOperationException.class, () -> repositorio.guardarToDo(todo));
    }

    @Test
    void TestDependecia1() {
        DBStub db = new DBStub();
        Repositorio repositorio = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repositorio, mailer);

        assertThrows(UnsupportedOperationException.class,
            () -> servicio.crearToDo("Tarea1", 123456789L));
    }
}

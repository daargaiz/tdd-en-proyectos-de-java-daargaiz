package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class MailerStub {

    private final List<String> correosEnviados;

    public MailerStub() {
        this.correosEnviados = new ArrayList<>();
    }

    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando correo a: " + direccion);
        System.out.println("Mensaje: " + mensaje);
        correosEnviados.add(direccion + "|" + mensaje);
        return true;
    }

    public List<String> getCorreosEnviados() {
        return new ArrayList<>(correosEnviados);
    }
}
package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Simula el envío de correos electrónicos.
 */
public class MailerStub {

    private final List<String> correosEnviados;

    /**
     * Crea un mailer vacío.
     */
    public MailerStub() {
        this.correosEnviados = new ArrayList<>();
    }

    /**
     * Simula el envío de un correo.
     *
     * @param direccion dirección de destino
     * @param mensaje contenido del mensaje
     * @return true si el envío se realiza
     */
    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando correo a: " + direccion);
        System.out.println("Mensaje: " + mensaje);
        correosEnviados.add(direccion + "|" + mensaje);
        return true;
    }

    /**
     * Devuelve los correos enviados.
     *
     * @return lista de correos enviados
     */
    public List<String> getCorreosEnviados() {
        return new ArrayList<>(correosEnviados);
    }
}
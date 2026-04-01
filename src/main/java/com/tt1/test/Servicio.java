package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private final Repositorio repositorio;
    private final MailerStub mailerStub;

    public Servicio(Repositorio repositorio, MailerStub mailerStub) {
        if (repositorio == null || mailerStub == null) {
            throw new IllegalArgumentException("Las dependencias no pueden ser nulas");
        }
        this.repositorio = repositorio;
        this.mailerStub = mailerStub;
    }

    public void crearToDo(String nombre, Long fechaLimite) {
        validarNombre(nombre);
        if (fechaLimite == null) {
            throw new IllegalArgumentException("La fecha límite es obligatoria");
        }

        repositorio.guardarToDo(new ToDo(nombre, "", fechaLimite, false));
        comprobarYEnviarAlertas();
    }

    public void agregarDireccionEmail(String email) {
        validarEmail(email);
        repositorio.guardarEmail(email);
        comprobarYEnviarAlertas();
    }

    public void marcarTareaComoFinalizada(String nombre) {
        validarNombre(nombre);
        repositorio.marcarComoCompletado(nombre);
        comprobarYEnviarAlertas();
    }

    public List<ToDo> consultarToDosSinCompletar() {
        comprobarYEnviarAlertas();
        List<ToDo> pendientes = new ArrayList<>();
        for (ToDo toDo : repositorio.obtenerTodosLosToDos()) {
            if (!toDo.isCompletado()) {
                pendientes.add(toDo);
            }
        }
        return pendientes;
    }

    private void comprobarYEnviarAlertas() {
        long ahora = System.currentTimeMillis();
        List<ToDo> vencidos = new ArrayList<>();

        for (ToDo toDo : repositorio.obtenerTodosLosToDos()) {
            if (!toDo.isCompletado() && toDo.getFechaLimite() < ahora) {
                vencidos.add(toDo);
            }
        }

        if (vencidos.isEmpty()) {
            return;
        }

        String mensaje = construirMensaje(vencidos);
        for (String email : repositorio.obtenerEmails()) {
            mailerStub.enviarCorreo(email, mensaje);
        }
    }

    private String construirMensaje(List<ToDo> vencidos) {
        StringBuilder builder = new StringBuilder("Tareas pendientes vencidas: ");
        for (int i = 0; i < vencidos.size(); i++) {
            builder.append(vencidos.get(i).getNombre());
            if (i < vencidos.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private void validarEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@") || email.startsWith("@")
            || email.endsWith("@")) {
            throw new IllegalArgumentException("Email no válido");
        }
    }
}
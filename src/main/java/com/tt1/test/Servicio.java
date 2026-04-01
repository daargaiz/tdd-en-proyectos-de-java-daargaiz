package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la lógica principal de la aplicación.
 */
public class Servicio {
    private final Repositorio repositorio;
    private final MailerStub mailerStub;

    /**
     * Crea un servicio con sus dependencias.
     *
     * @param repositorio repositorio usado para guardar y consultar datos
     * @param mailerStub objeto usado para enviar avisos por correo
     * @throws IllegalArgumentException si alguna dependencia es nula
     */
    public Servicio(Repositorio repositorio, MailerStub mailerStub) {
        if (repositorio == null || mailerStub == null) {
            throw new IllegalArgumentException("Las dependencias no pueden ser nulas");
        }
        this.repositorio = repositorio;
        this.mailerStub = mailerStub;
    }

    /**
     * Crea una nueva tarea pendiente.
     *
     * @param nombre nombre de la tarea
     * @param fechaLimite fecha límite de la tarea
     * @throws IllegalArgumentException si el nombre o la fecha no son válidos
     */
    public void crearToDo(String nombre, Long fechaLimite) {
        validarNombre(nombre);
        if (fechaLimite == null) {
            throw new IllegalArgumentException("La fecha límite es obligatoria");
        }

        repositorio.guardarToDo(new ToDo(nombre, "", fechaLimite, false));
        comprobarYEnviarAlertas();
    }

    /**
     * Guarda una dirección de correo en la agenda.
     *
     * @param email dirección de correo a guardar
     * @throws IllegalArgumentException si el correo no es válido
     */
    public void agregarDireccionEmail(String email) {
        validarEmail(email);
        repositorio.guardarEmail(email);
        comprobarYEnviarAlertas();
    }

    /**
     * Marca una tarea como completada.
     *
     * @param nombre nombre de la tarea
     * @throws IllegalArgumentException si el nombre no es válido
     */
    public void marcarTareaComoFinalizada(String nombre) {
        validarNombre(nombre);
        repositorio.marcarComoCompletado(nombre);
        comprobarYEnviarAlertas();
    }

    /**
     * Devuelve las tareas que siguen pendientes.
     *
     * @return lista de tareas no completadas
     */
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

    /**
     * Comprueba si hay tareas vencidas y envía avisos.
     */
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

    /**
     * Construye el mensaje de aviso para las tareas vencidas.
     *
     * @param vencidos lista de tareas vencidas
     * @return texto del aviso
     */
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

    /**
     * Comprueba si un nombre de tarea es válido.
     *
     * @param nombre nombre a validar
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    /**
     * Comprueba si un correo electrónico es válido.
     *
     * @param email correo a validar
     * @throws IllegalArgumentException si el correo no es válido
     */
    private void validarEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@") || email.startsWith("@")
            || email.endsWith("@")) {
            throw new IllegalArgumentException("Email no válido");
        }
    }
}
package com.tt1.test;

import java.util.List;

/**
 * Gestiona el acceso a los datos de la aplicación.
 */
public class Repositorio {
    private final DBStub dbStub;

    /**
     * Crea un repositorio con una base de datos en memoria.
     *
     * @param dbStub base de datos usada por el repositorio
     * @throws IllegalArgumentException si la base de datos es nula
     */
    public Repositorio(DBStub dbStub) {
        if (dbStub == null) {
            throw new IllegalArgumentException("La base de datos no puede ser nula");
        }
        this.dbStub = dbStub;
    }

    /**
     * Busca una tarea por su nombre.
     *
     * @param nombre nombre de la tarea
     * @return tarea encontrada o null si no existe
     */
    public ToDo encontrarToDo(String nombre) {
        return dbStub.obtenerToDoPorNombre(nombre);
    }

    /**
     * Marca una tarea como completada.
     *
     * @param nombre nombre de la tarea
     * @throws IllegalArgumentException si la tarea no existe
     */
    public void marcarComoCompletado(String nombre) {
        ToDo toDo = dbStub.obtenerToDoPorNombre(nombre);
        if (toDo == null) {
            throw new IllegalArgumentException("No existe la tarea");
        }
        toDo.setCompletado(true);
        dbStub.actualizarToDo(toDo);
    }

    /**
     * Guarda una tarea nueva.
     *
     * @param toDo tarea que se quiere guardar
     */
    public void guardarToDo(ToDo toDo) {
        dbStub.crearToDo(toDo);
    }

    /**
     * Guarda una dirección de correo.
     *
     * @param email dirección de correo a guardar
     */
    public void guardarEmail(String email) {
        dbStub.guardarEmail(email);
    }

    /**
     * Devuelve todas las tareas guardadas.
     *
     * @return lista de tareas
     */
    public List<ToDo> obtenerTodosLosToDos() {
        return dbStub.obtenerTodosLosToDos();
    }

    /**
     * Devuelve todas las direcciones de correo guardadas.
     *
     * @return lista de correos
     */
    public List<String> obtenerEmails() {
        return dbStub.obtenerEmails();
    }
}
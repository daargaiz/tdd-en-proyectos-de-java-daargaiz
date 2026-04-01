package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Emula una base de datos en memoria para el proyecto.
 */
public class DBStub {
    private final List<ToDo> toDos;
    private final List<String> emails;

    /**
     * Crea una base de datos vacía en memoria.
     */
    public DBStub() {
        this.toDos = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    /**
     * Guarda una nueva tarea.
     *
     * @param toDo tarea que se quiere guardar
     * @throws IllegalArgumentException si la tarea es nula o ya existe
     */
    public void crearToDo(ToDo toDo) {
        if (toDo == null) {
            throw new IllegalArgumentException("El ToDo no puede ser nulo");
        }
        if (obtenerToDoPorNombre(toDo.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe una tarea con ese nombre");
        }
        toDos.add(toDo);
    }

    /**
     * Busca una tarea por su nombre.
     *
     * @param nombre nombre de la tarea
     * @return la tarea encontrada o null si no existe
     */
    public ToDo obtenerToDoPorNombre(String nombre) {
        for (ToDo toDo : toDos) {
            if (toDo.getNombre().equals(nombre)) {
                return toDo;
            }
        }
        return null;
    }

    /**
     * Devuelve todas las tareas guardadas.
     *
     * @return lista con todas las tareas
     */
    public List<ToDo> obtenerTodosLosToDos() {
        return new ArrayList<>(toDos);
    }

    /**
     * Actualiza una tarea ya existente.
     *
     * @param toDo tarea con los nuevos datos
     * @throws IllegalArgumentException si la tarea es nula o no existe
     */
    public void actualizarToDo(ToDo toDo) {
        if (toDo == null) {
            throw new IllegalArgumentException("El ToDo no puede ser nulo");
        }
        for (int i = 0; i < toDos.size(); i++) {
            if (toDos.get(i).getNombre().equals(toDo.getNombre())) {
                toDos.set(i, toDo);
                return;
            }
        }
        throw new IllegalArgumentException("No existe la tarea a actualizar");
    }

    /**
     * Elimina una tarea por su nombre.
     *
     * @param nombre nombre de la tarea a eliminar
     */
    public void eliminarToDo(String nombre) {
        toDos.removeIf(toDo -> toDo.getNombre().equals(nombre));
    }

    /**
     * Guarda una dirección de correo.
     *
     * @param email dirección de correo a guardar
     * @throws IllegalArgumentException si el correo es nulo o vacío
     */
    public void guardarEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!emails.contains(email)) {
            emails.add(email);
        }
    }

    /**
     * Devuelve todas las direcciones de correo guardadas.
     *
     * @return lista de correos
     */
    public List<String> obtenerEmails() {
        return new ArrayList<>(emails);
    }
}
package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub {
    private final List<ToDo> toDos;
    private final List<String> emails;

    public DBStub() {
        this.toDos = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public void crearToDo(ToDo toDo) {
        if (toDo == null) {
            throw new IllegalArgumentException("El ToDo no puede ser nulo");
        }
        if (obtenerToDoPorNombre(toDo.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe una tarea con ese nombre");
        }
        toDos.add(toDo);
    }

    public ToDo obtenerToDoPorNombre(String nombre) {
        for (ToDo toDo : toDos) {
            if (toDo.getNombre().equals(nombre)) {
                return toDo;
            }
        }
        return null;
    }

    public List<ToDo> obtenerTodosLosToDos() {
        return new ArrayList<>(toDos);
    }

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

    public void eliminarToDo(String nombre) {
        toDos.removeIf(toDo -> toDo.getNombre().equals(nombre));
    }

    public void guardarEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!emails.contains(email)) {
            emails.add(email);
        }
    }

    public List<String> obtenerEmails() {
        return new ArrayList<>(emails);
    }
}

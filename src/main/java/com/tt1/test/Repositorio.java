package com.tt1.test;

import java.util.List;

public class Repositorio {
    private final DBStub dbStub;

    public Repositorio(DBStub dbStub) {
        if (dbStub == null) {
            throw new IllegalArgumentException("La base de datos no puede ser nula");
        }
        this.dbStub = dbStub;
    }

    public ToDo encontrarToDo(String nombre) {
        return dbStub.obtenerToDoPorNombre(nombre);
    }

    public void marcarComoCompletado(String nombre) {
        ToDo toDo = dbStub.obtenerToDoPorNombre(nombre);
        if (toDo == null) {
            throw new IllegalArgumentException("No existe la tarea");
        }
        toDo.setCompletado(true);
        dbStub.actualizarToDo(toDo);
    }

    public void guardarToDo(ToDo toDo) {
        dbStub.crearToDo(toDo);
    }

    public void guardarEmail(String email) {
        dbStub.guardarEmail(email);
    }

    public List<ToDo> obtenerTodosLosToDos() {
        return dbStub.obtenerTodosLosToDos();
    }

    public List<String> obtenerEmails() {
        return dbStub.obtenerEmails();
    }
}
package com.tt1.test;

import java.io.Serializable;
import java.util.Objects;

public class ToDo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String descripcion;
    private long fechaLimite;
    private boolean completado;

    public ToDo() {
        this("", "", 0, false);
    }

    public ToDo(String nombre, String descripcion, long fechaLimite, boolean completado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = completado;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(long fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ToDo toDo)) {
            return false;
        }
        return Objects.equals(nombre, toDo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
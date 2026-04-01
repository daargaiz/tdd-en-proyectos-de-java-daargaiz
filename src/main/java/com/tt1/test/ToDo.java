package com.tt1.test;

import java.io.Serializable;

public class ToDo implements Serializable {
    private static final long serialVersionUID = 1L;

    private char nombre;
    private char descripcion;
    private long fechaLimite;
    private boolean completado;

    public ToDo() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public ToDo(char nombre, char descripcion, long fechaLimite, boolean completado) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public char getNombre() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setNombre(char nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public char getDescripcion() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setDescripcion(char descripcion) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public long getFechaLimite() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setFechaLimite(long fechaLimite) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public boolean isCompletado() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setCompletado(boolean completado) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
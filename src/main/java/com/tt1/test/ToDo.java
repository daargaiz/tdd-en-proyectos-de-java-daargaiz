package com.tt1.test;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa una tarea pendiente del sistema.
 */
public class ToDo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String descripcion;
    private long fechaLimite;
    private boolean completado;

    /**
     * Crea una tarea vacía.
     */
    public ToDo() {
        this("", "", 0, false);
    }

    /**
     * Crea una tarea con todos sus datos.
     *
     * @param nombre nombre de la tarea
     * @param descripcion descripción de la tarea
     * @param fechaLimite fecha límite de la tarea
     * @param completado indica si la tarea está completada
     */
    public ToDo(String nombre, String descripcion, long fechaLimite, boolean completado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = completado;
    }

    /**
     * Devuelve el nombre de la tarea.
     *
     * @return nombre de la tarea
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre de la tarea.
     *
     * @param nombre nuevo nombre de la tarea
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción de la tarea.
     *
     * @return descripción de la tarea
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripción de la tarea.
     *
     * @param descripcion nueva descripción de la tarea
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la fecha límite de la tarea.
     *
     * @return fecha límite de la tarea
     */
    public long getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Cambia la fecha límite de la tarea.
     *
     * @param fechaLimite nueva fecha límite de la tarea
     */
    public void setFechaLimite(long fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * Indica si la tarea está completada.
     *
     * @return true si la tarea está completada
     */
    public boolean isCompletado() {
        return completado;
    }

    /**
     * Cambia el estado de la tarea.
     *
     * @param completado nuevo estado de la tarea
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    /**
     * Compara esta tarea con otro objeto.
     *
     * @param o objeto a comparar
     * @return true si ambos objetos representan la misma tarea
     */
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

    /**
     * Devuelve el hash de la tarea.
     *
     * @return hash calculado a partir del nombre
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
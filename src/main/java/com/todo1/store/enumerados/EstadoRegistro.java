package com.todo1.store.enumerados;

/**
 * @author holger.morales
 */
public enum EstadoRegistro {
    ACTIVO("A"),
    ELIMINADO("X");

    private String estado;

    private EstadoRegistro(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    @Override
    public String toString() {
        return this.estado;
    }
}

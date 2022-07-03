package com.todo1.store.enumerados;

/**
 * @author holger.morales
 */
public enum TipoMensaje {
    EXITO("exito"),
    ERROR("error"),
    ADVERTENCIA("advertencia"),
    INFORMACION("informacion");

    private String tipo;

    private TipoMensaje(String tipo) {
        this.tipo = tipo;
    }

    public String ggetTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}

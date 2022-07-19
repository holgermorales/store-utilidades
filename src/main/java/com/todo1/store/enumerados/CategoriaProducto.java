package com.todo1.store.enumerados;

/**
 * @author holger.morales
 */
public enum CategoriaProducto {

    TODOS("TODO");

    private String categoria;

    private CategoriaProducto(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

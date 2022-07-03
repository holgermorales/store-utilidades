package com.todo1.store.enumerados;

/**
 * @author holger.morales
 */
public enum VisibleRegistro {
    VISIBLE("S"),
    NO_VISIBLE("N");

    private String visible;

    private VisibleRegistro(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return this.visible;
    }

    @Override
    public String toString() {
        return this.visible;
    }
}

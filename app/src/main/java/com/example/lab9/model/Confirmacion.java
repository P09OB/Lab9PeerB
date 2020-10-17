package com.example.lab9.model;

public class Confirmacion {

    private String type = "Confirmacion";
    private boolean isConfirm;

    public Confirmacion() {
    }

    public Confirmacion(String type, boolean isConfirm) {
        this.type = type;
        this.isConfirm = isConfirm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }
}

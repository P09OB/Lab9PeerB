package com.example.lab9.model;

public class Sandwitch {

    private String type = "Sandwitch";
    String id;
    String producto;
    String hora;
    String ip;

    public Sandwitch() {
    }

    public Sandwitch(String producto, String hora, String id, String ip) {
        this.producto = producto;
        this.id = id;
        this.hora = hora;
        this.ip = ip;

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

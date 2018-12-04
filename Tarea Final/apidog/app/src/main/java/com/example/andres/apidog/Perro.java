package com.example.andres.apidog;

import java.io.Serializable;

public class Perro implements Serializable {

    private String raza;
    private String[] imagenes;
    private String[] subrazas;

    public Perro() {
        this.raza = "Sin raza";
        this.imagenes = new String[100];
        this.subrazas = new String[100];
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(String[] imagenes) {
        this.imagenes = imagenes;
    }

    public String[] getSubrazas() {
        return subrazas;
    }

    public void setSubrazas(String[] subrazas) {
        this.subrazas = subrazas;
    }
}

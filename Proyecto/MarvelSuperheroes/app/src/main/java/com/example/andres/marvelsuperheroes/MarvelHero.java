package com.example.andres.marvelsuperheroes;

import android.graphics.drawable.Drawable;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MarvelHero implements Serializable{

    private String nombre;
    private String origen;
    private String habilidades;
    private ArrayList<String> villanos;
    private Drawable imagen;

    public MarvelHero(){
        super();
        this.nombre = "Superhéroe desconocido";
        this.origen = "Origen desconocido";
        this.habilidades = "Habilidades desconocidas";
        this.villanos = new ArrayList<String>();
    }

    public MarvelHero(String nombre, String origen, String habilidades, ArrayList<String> villanos, Drawable imagen){
        super();
        this.nombre=nombre;
        this.origen= origen;
        this.habilidades= habilidades;
        this.villanos =villanos;
        this.imagen =imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public ArrayList<String> getVillanos() {
        return villanos;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public void setVillanos(ArrayList<String> villanos) {
        this.villanos = villanos;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}

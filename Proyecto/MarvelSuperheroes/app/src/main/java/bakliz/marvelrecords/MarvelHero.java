package bakliz.marvelrecords;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MarvelHero implements Serializable{

    private String nombre;
    private String origen;
    private String habilidades;
    private int imagen;

    public MarvelHero(){
        super();
        this.nombre = "Superhéroe desconocido";
        this.origen = "Origen desconocido";
        this.habilidades = "Habilidades desconocidas";
    }

    public MarvelHero(String nombre, String origen, String habilidades, int imagen){
        super();
        this.nombre = nombre;
        this.origen = origen;
        this.habilidades = habilidades;
        this.imagen = imagen;
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


    public int getImagen() {
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

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

package bakliz.marvelrecords;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MarvelHero implements Serializable{

    private String nombre;
    private String origen;
    private String apariciones;
    private String imagen;

    public MarvelHero(){
        super();
        this.nombre = "Superhéroe desconocido";
        this.origen = "There isn't a description on Marvel's API";
        this.apariciones = "There ain't series registered on Marvel's API";
    }

    public MarvelHero(String nombre, String origen, String apariciones, String imagen){
        super();
        this.nombre = nombre;
        this.origen = origen;
        this.apariciones = apariciones;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getApariciones() {
        return apariciones;
    }


    public String getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setApariciones(String apariciones) {
        this.apariciones = apariciones;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

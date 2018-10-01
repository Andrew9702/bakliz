package bakliz.tarea02;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cancion implements Serializable{

    private String nombre;
    private String artista;
    private Drawable imagen;

    public Cancion(){
        super();
        this.nombre = "Pista Desconocida";
        this.artista = "Artista Desconocido";
    }

    public Cancion(String nombre, String artista, Drawable imagen){
        super();
        this.nombre = nombre;
        this.artista = artista;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}

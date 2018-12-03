package bakliz.tarea02;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cancion implements Serializable{

    private String nombre;
    private String artista;
    private int imagen;

    public Cancion(){
        super();
        this.nombre = "Pista Desconocida";
        this.artista = "Artista Desconocido";
    }

    public Cancion(String nombre, String artista, int imagen){
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

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

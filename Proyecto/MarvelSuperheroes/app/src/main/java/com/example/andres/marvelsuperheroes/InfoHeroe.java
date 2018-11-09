package com.example.andres.marvelsuperheroes;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoHeroe extends AppCompatActivity{

    TextView nombre, origen, habilidades;
    ImageView imagen;
    MarvelHero heroe_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setupActioBar();

        //Obtenemos la información de la canción que escogió el usuario
        heroe_item = (MarvelHero) getIntent().getSerializableExtra("objetoData");

        nombre = (TextView) findViewById(R.id.nombre);
        imagen = (ImageView) findViewById(R.id.imagen);
        origen = (TextView) findViewById(R.id.origen);
        habilidades = (TextView) findViewById(R.id.habilidades);

        //Actualizamos la pantalla con la información de la canción escogida por el usuario
        nombre.setText(heroe_item.getNombre());
        imagen.setImageResource(heroe_item.getImagen());
        origen.setText(heroe_item.getOrigen());
        habilidades.setText(heroe_item.getHabilidades());
    }

    /*
     * Botón de regreso
     */
    private void setupActioBar(){
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Info Marvel");
        }
    }
}

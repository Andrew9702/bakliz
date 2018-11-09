package com.example.andres.marvelsuperheroes;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoHeroe extends AppCompatActivity{

    TextView nombre, origen, habilidades;
    ImageView imagen;
    MarvelHero heroe_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Obtenemos la información de la canción que escogió el usuario
        heroe_item = (MarvelHero) getIntent().getSerializableExtra("objetoData");

        //Actualizamos la pantalla con la información de la canción escogida por el usuario
        nombre = (TextView) findViewById(R.id.nombre);
        //imagen = (ImageView) findViewById(R.id.imagen);
        origen = (TextView) findViewById(R.id.origen);
        habilidades = (TextView) findViewById(R.id.habilidades);

        nombre.setText(heroe_item.getNombre());
        //imagen.setImageResource(heroe_item.getImagen().getAlpha());
        origen.setText(heroe_item.getOrigen());
        habilidades.setText(heroe_item.getHabilidades());

    }
}

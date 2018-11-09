package com.example.andres.marvelsuperheroes;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InfoHeroe extends AppCompatActivity{

    TextView nombre, origen, habilidades;
    String nombre_heroe, origen_heroe, habilidades_heroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Obtenemos la información de la canción que escogió el usuario
        Bundle datos = this.getIntent().getExtras();
        nombre_heroe = datos.getString("nombre");
        origen_heroe = datos.getString("origen");
        habilidades_heroe = datos.getString("habilidades");

        //Actualizamos la pantalla con la información de la canción escogida por el usuario
        nombre = (TextView) findViewById(R.id.nombre);
        origen = (TextView) findViewById(R.id.origen);
        habilidades = (TextView) findViewById(R.id.habilidades);
        nombre.setText(nombre_heroe);
        origen.setText(origen_heroe);
        habilidades.setText(habilidades_heroe);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onRestart(){
        super.onRestart();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}

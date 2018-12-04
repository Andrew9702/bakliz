package com.example.andres.apidog;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPerro extends AppCompatActivity {

    TextView raza;
    ImageView imagen;
    Perro perro_item;

    Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setupActionBar();

        perro_item = (Perro) getIntent().getSerializableExtra("objetoData");

        raza = (TextView) findViewById(R.id.raza);
        imagen = (ImageView) findViewById(R.id.imagen);

        String archivo = perro_item.getImagenes()[0];
        DownloadImageWithURLTask downloadTask = new DownloadImageWithURLTask(imagen);
        downloadTask.execute(archivo);

        raza.setText(perro_item.getRaza());
    }

    /*
     * Botón de regreso
     */
    private void setupActionBar(){
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Info Marvel");
        }
    }
}

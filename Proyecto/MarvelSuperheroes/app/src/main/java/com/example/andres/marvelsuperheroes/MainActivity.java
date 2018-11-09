package com.example.andres.marvelsuperheroes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MarvelHero> heroes;
    private AdapterItem adapter;
    private ListView lvHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHeroes = (ListView) findViewById(R.id.lvHeroes);
        heroes = new ArrayList<MarvelHero>();
        cargarHeroes();
        adapter= new AdapterItem(this, heroes);
        lvHeroes.setAdapter(adapter);

        lvHeroes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cargarInfo(position);
            }
        });
    }

    private void cargarHeroes(){
        Drawable ad = getResources().getDrawable(R.drawable.marvel_logo);
        ArrayList<String> villanos_spidey = new ArrayList<String>();
        villanos_spidey.add("El duende verde");
        villanos_spidey.add("Venom");
        heroes.add(new MarvelHero("Spiderman", "Picadura de araña radioactiva", "Fuerza sobrehumana,sentido arácnido, trepar paredes", villanos_spidey, ad));
    }

    private void cargarInfo(int position){
        Intent intent = new Intent(getApplicationContext(), InfoHeroe.class);
        intent.putExtra("heroe", heroes.get(position).getNombre());
        intent.putExtra("origen", heroes.get(position).getOrigen());
        intent.putExtra("habilidades", heroes.get(position).getOrigen());
        startActivity(intent);
    }
}

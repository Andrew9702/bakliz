package bakliz.tarea02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cancion> canciones;
    AdapterItem adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        canciones = new ArrayList<Cancion>();
        cargarCanciones();
        adapter = new AdapterItem(this, canciones);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                reproducir(position);
            }
        });
    }

    private void cargarCanciones(){
        canciones.add(new Cancion("Beauty in the Mundane","Bird of figment ft. Cody Francis", R.drawable.albumdesconocido));
        canciones.add(new Cancion("A Heavy Load","Sven Karlsson ft. Johan Wendt", R.drawable.rocksounds));
        canciones.add(new Cancion("Lost You","Tape Machines", R.drawable.tapemachines));
    }

    private void reproducir(int position){
        Intent intent = new Intent(getApplicationContext(), Reproductor.class);
        intent.putExtra("cancion", canciones.get(position).getNombre());
        intent.putExtra("artista", canciones.get(position).getArtista());
        intent.putExtra("imagen", canciones.get(position).getImagen());
        startActivity(intent);
    }
}

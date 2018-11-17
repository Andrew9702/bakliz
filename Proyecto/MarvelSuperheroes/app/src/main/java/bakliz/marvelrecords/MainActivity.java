package bakliz.marvelrecords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    ArrayList<MarvelHero> heroes;
    private AdaptadorLista adapter;
    private ListView lvHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHeroes = (ListView) findViewById(R.id.lvHeroes);
        heroes = new ArrayList<MarvelHero>();
        cargarHeroes();
        adapter= new AdaptadorLista(this, heroes);
        lvHeroes.setAdapter(adapter);

        lvHeroes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InfoHeroe.class);
                intent.putExtra("objetoData", heroes.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_search:
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void cargarHeroes(){
        heroes.add(new MarvelHero("Spiderman",
                "Picadura de araña radioactiva",
                "Fuerza sobrehumana,sentido arácnido, trepar paredes",
                R.drawable.spidey));

        heroes.add(new MarvelHero("Dr. Strange",
                "Aprendizaje y entrenamiento en las artes místicas",
                "Poderes Místicos",
                R.drawable.dr_strange));

        heroes.add(new MarvelHero("Iron Man",
                "Construcción de un traje mientras estaba secuestrado",
                "Inteligencia, emanación de energía, Psi-Escudos",
                R.drawable.iron_man));
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}

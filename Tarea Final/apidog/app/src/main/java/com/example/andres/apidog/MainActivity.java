package com.example.andres.apidog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    ArrayList<Perro> perros;
    RecyclerView lvPerros;
    AdaptadorRecycler adaptador;

    ProgressDialog progreso;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    long ts = new Date().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPerros = findViewById(R.id.perros);
        lvPerros.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        perros = new ArrayList<Perro>();

        request = Volley.newRequestQueue(this);

        cargarWebService();

        lvPerros.addOnItemTouchListener(
                new RecyclerItemClickListener(this, lvPerros ,new RecyclerItemClickListener.OnItemClickListener() {
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this, InfoPerro.class);
                        intent.putExtra("objetoData", perros.get(position));
                        startActivity(intent);
                    }
                })
        );
    }

    private void cargarWebService() {
        progreso = new ProgressDialog(this);
        progreso.setMessage("Consultando...");
        progreso.show();

        String url = "https://dog.ceo/api/breeds/list";

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Falló la conexión con el servidor" + " " + error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());
        progreso.hide();
    }

    public void onResponse(JSONObject response) {
        Perro item = null;
        try {
            JSONArray json = response.optJSONArray("message");

            for(int i = 0; i < json.length(); i++) {

                item = new Perro();
                item.setRaza(json.getString(i));
                perros.add(item);
            }
            progreso.hide();
            adaptador = new AdaptadorRecycler(perros);
            lvPerros.setAdapter(adaptador);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "No hubo conexion con el servidor" + " " + response, Toast.LENGTH_LONG).show();
            progreso.hide();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.id_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adaptador.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return  super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

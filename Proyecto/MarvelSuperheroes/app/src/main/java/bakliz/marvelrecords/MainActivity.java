package bakliz.marvelrecords;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    ArrayList<MarvelHero> heroes;
    RecyclerView lvHeroes;

    String llave_publica = "19d9b8c329b60b431fa6ea00a320adf6";
    String llave_privada = "8edc72e50911111123451ee0901a4611a99385b8";

    ProgressDialog progreso;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    long ts = new Date().getTime();

    String hash =  getMD5("1" + llave_privada + llave_publica);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvHeroes = findViewById(R.id.losHeroes);
        lvHeroes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        heroes = new ArrayList<MarvelHero>();

        request = Volley.newRequestQueue(this);

        cargarWebService();

        lvHeroes.addOnItemTouchListener(
                new RecyclerItemClickListener(this, lvHeroes ,new RecyclerItemClickListener.OnItemClickListener() {
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this, InfoHeroe.class);
                        intent.putExtra("objetoData", heroes.get(position));
                        startActivity(intent);
                    }
                })
        );
    }

    private void cargarWebService() {
        progreso = new ProgressDialog(this);
        progreso.setMessage("Consultando...");
        progreso.show();

        String url = "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=19d9b8c329b60b431fa6ea00a320adf6&hash=b12fd8a28a1900f7f5af647fc540f4e5";

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
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

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se pudo hacer conexion" + " " + error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());
        progreso.hide();
    }

    @Override
    public void onResponse(JSONObject response) {
        MarvelHero item = null;
        String apariciones = "";
        try {
            JSONObject lol = response.getJSONObject("data");
            JSONArray json = lol.optJSONArray("results");
            for(int i = 0; i < json.length(); i++) {

                item = new MarvelHero();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);
                item.setNombre(jsonObject.optString("name"));
                item.setOrigen(jsonObject.optString("description"));

                JSONObject obj_imagen = jsonObject.getJSONObject("thumbnail");
                String ruta_imagen = obj_imagen.optString("path");
                ruta_imagen = ruta_imagen + "/portrait_xlarge.jpg";
                item.setImagen(ruta_imagen);

                if(jsonObject.optString("description").equals("")){
                    item.setOrigen("There isn't a description on Marvel's API");
                }
                JSONObject comics = jsonObject.getJSONObject("series");
                JSONArray json_2 = comics.optJSONArray("items");
                for(int j = 0; j < json_2.length(); j++) {
                    JSONObject jsonObject_2 = null;
                    jsonObject_2 = json_2.getJSONObject(j);
                    apariciones = apariciones + jsonObject_2.optString("name") + "\n";
                    item.setApariciones(apariciones);
                }
                ruta_imagen = "";
                apariciones = "";
                heroes.add(item);
            }
            progreso.hide();
            AdaptadorRecycler adaptador = new AdaptadorRecycler(heroes);
            lvHeroes.setAdapter(adaptador);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "No hubo conexion con el servidor" + " " + response, Toast.LENGTH_LONG).show();
            progreso.hide();
        }
    }
}

package bakliz.marvelrecords;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class InfoHeroe extends AppCompatActivity{

    TextView nombre, origen, apariciones;
    ImageView imagen;
    MarvelHero heroe_item;

    Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setupActioBar();

        heroe_item = (MarvelHero) getIntent().getSerializableExtra("objetoData");

        nombre = (TextView) findViewById(R.id.nombre);
        imagen = (ImageView) findViewById(R.id.imagen);
        origen = (TextView) findViewById(R.id.origen);
        apariciones = (TextView) findViewById(R.id.apariciones);

        String archivo = heroe_item.getImagen();
        DownloadImageWithURLTask downloadTask = new DownloadImageWithURLTask(imagen);
        downloadTask.execute(archivo);

        nombre.setText(heroe_item.getNombre());
        origen.setText(heroe_item.getOrigen());
        apariciones.setText(heroe_item.getApariciones());
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

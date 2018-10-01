package bakliz.tarea02;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Reproductor extends AppCompatActivity {

    MediaPlayer mp;
    Button play, pause, stop;
    TextView nombre, artista;

    Cancion cancion;
    String nombre_cancion, artista_cancion;
    int pausa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);

        //Obtenemos la información de la canción que escogió el usuario
        Bundle datos = this.getIntent().getExtras();
        nombre_cancion = datos.getString("cancion");
        artista_cancion = datos.getString("artista");

        //Actualizamos la pantalla con la información de la canción escogida por el usuario
        nombre = (TextView) findViewById(R.id.cancion);
        artista = (TextView) findViewById(R.id.artista);
        nombre.setText(nombre_cancion);
        artista.setText(artista_cancion);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause(v);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();

        if(mp == null){
            if(nombre_cancion.equals("Beauty in the Mundane"))
                mp = MediaPlayer.create(this, R.raw.beautyinthemundane);
            else if(nombre_cancion.equals("A Heavy Load"))
                mp = MediaPlayer.create(this, R.raw.aheavyload);
            else
                mp = MediaPlayer.create(this, R.raw.lostyou);
        }else if(!mp.isPlaying()){
            mp.seekTo(pausa);
        }

        mp.start();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        onStart();
    }

    @Override
    public void onPause(){
        super.onPause();
        mp.pause();
        onResume();
    }

    @Override
    public void onStop(){
        super.onStop();
        mp.stop();
        onRestart();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mp.stop();
        mp.release();
        mp = null;
    }

    public void play(View view){

        if(mp == null){
            if(nombre_cancion.equals("Beauty in the Mundane"))
                mp = MediaPlayer.create(this, R.raw.beautyinthemundane);
            else if(nombre_cancion.equals("A Heavy Load"))
                mp = MediaPlayer.create(this, R.raw.aheavyload);
            else
                mp = MediaPlayer.create(this, R.raw.lostyou);
        }else if(!mp.isPlaying()){
            mp.seekTo(pausa);
        }

        mp.start();
        Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
    }

    public void pause(View view){
        if(mp != null){
            mp.pause();
            pausa = mp.getCurrentPosition();
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view){
        mp.stop();
        mp = null;
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }
}
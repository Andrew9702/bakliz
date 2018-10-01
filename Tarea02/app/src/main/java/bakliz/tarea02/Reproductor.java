package bakliz.tarea02;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Reproductor extends AppCompatActivity {

    MediaPlayer mp;
    Button play, pause, stop;
    int pausa;
    String nom_can;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);

        Bundle datos = this.getIntent().getExtras();
        nom_can = datos.getString("cancion");

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

    public void play(View view){

        if(mp == null){
            if(nom_can.equals("Beauty in the Mundane"))
                mp = MediaPlayer.create(this, R.raw.beautyinthemundane);
            else if(nom_can.equals("A Heavy Load"))
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
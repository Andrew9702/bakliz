package com.example.andres.practica1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Practica1 extends AppCompatActivity implements View.OnClickListener {

    /*Definimos los views que haran referencia a los definidos en el xml*/
    private Button boton_1;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica1);
        Log.w("OnCreate: ", "Acabo de entrar al metodo onCreate, ¡Saludos!");

        /*Asignamos los views a las variables de la clase*/
        boton_1 = (Button) findViewById(R.id.button3);
        texto = findViewById(R.id.textView);

        /*Agregamos el listener al textView mediante la palabre reservada this
        * Este listener sera llamado por el metodo onClick despues.*/
        texto.setOnClickListener(this);

        /*setteamos el listener para el boton*/
        boton_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Cambia el texto del textView*/
                texto.setText("Presionaste el boton :O");
            }
        });

    }

    /*Este metodo se llama justo antes de hacer visible la aplicacion, solo se llama si se necesita
    * modificar o actualizar algun valor antes de que la app sea visible al usuario*/
    @Override
    protected void onStart()
    {
        /*Llamamos al metodo OnStart y luego mandamos el mensaje*/
        super.onStart();
        Log.w("OnStart: ", "Acabo de entrar al metodo onStart, ¡Saludos!");
        Toast.makeText(Practica1.this, "Estoy en OnStart", Toast.LENGTH_SHORT).show();
    }

    /*Se llama antes de poner la actividad en background, las actividades deben llmar este metodo
    * para saber si necesitan confirmar datos no guardados, destruir o limpiar objetos, la actividad
    * se puede destruir solo luego de llamar a onPause*/
    @Override
    protected void onPause() {
        /*Llamamos al metodo OnStart y luego mandamos el mensaje*/
        super.onPause();
        Log.w("OnPause: ", "Acabo de entrar al metodo onPause, ¡Saludos!");
        Toast.makeText(Practica1.this, "Estoy en OnPause", Toast.LENGTH_SHORT).show();
    }

    /*Este metodo se llama cuando la actividad empieza a interactuar con el usuario despues de haber estado en pausa
    * cuando se llama este metodo la actividad esta al tope de la pila*/
    @Override
    protected void onResume() {
        /*Llamamos al metodo OnResume y luego mandamos el mensaje*/
        super.onResume();
        Log.w("OnResume: ", "Acabo de entrar al metodo onResume, ¡Saludos!");
        Toast.makeText(Practica1.this, "Estoy en OnResume", Toast.LENGTH_SHORT).show();
    }

    /*Este metodo se llama cuando la actividad ya no es visible para el usuario ya que otra
    * actividad esta eclipsando a esta.
    * Puede suceder cuando la actividad termina, porque el sistema la destruya para ahorrar recursos
    * o por un cambio de orientacion en el dispositivo, se llama para realizar sus tareas pendientes
    * antes de ser destruida.*/
    @Override
    protected void onStop() {
        /*Llamamos al metodo onStop y luego mandamos el mensaje*/
        super.onStop();
        Log.w("OnStop: ", "Acabo de entrar al metodo onStop, ¡Saludos!");
        Toast.makeText(Practica1.this, "Estoy en OnStop", Toast.LENGTH_SHORT).show();
    }

    /*Este metodo se llama cuando la actividad se detuvo, antes de que se reinicie
    * es seguido por onStart, se llama solo si es necesario realizar las tareas antes
    * de llamar a onStart*/
    @Override
    protected void onRestart() {
        /*Llamamos al metodo onStop y luego mandamos el mensaje*/
        super.onRestart();
        Log.w("OnRestart: ", "Acabo de entrar al metodo onRestart, ¡Saludos!");
        Toast.makeText(Practica1.this, "Estoy en OnRestart", Toast.LENGTH_SHORT).show();
    }

    /*Este metodo se llama justo antes de que la actividad sea destruida, despues
    * de llamarlo la actividad morira y sera purgada de los recursos del sistema*/
    @Override
    protected void onDestroy() {
        /*Llamamos al metodo onDestroy y luego mandamos el mensaje*/
        super.onDestroy();
        Log.w("OnDestroy: ", "Acabo de entrar al metodo onDestroy, ¡Saludos!");
    }

    /*
     * Método onClick que se ejecuta cuando se clickea
     * un view, que seria lo mismo que implementar la interfaz de OnClickListener
     */
    @Override
    public void onClick(View view) {
        /*Switch que verificara que view presionamos*/
        switch (view.getId()){

            /*Caso para el texto*/
            case R.id.textView:
                //Notificamos a nuestro user que el texto fue clickeado
                Toast.makeText(Practica1.this, "¡Tocaste un texto!", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    /*Este metodo se llama desde el onclick del imageView del xml*/
    public void toque(View view) {
        Toast.makeText(Practica1.this, "presionaste una imagen", Toast.LENGTH_SHORT).show();
    }
}

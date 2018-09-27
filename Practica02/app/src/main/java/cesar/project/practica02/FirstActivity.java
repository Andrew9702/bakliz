package cesar.project.practica02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    ArrayList<String> lista;
    EditText campo_texto;
    Button agregar;
    Button ver_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        campo_texto = (EditText) findViewById(R.id.campo_texto);
        agregar = (Button) findViewById(R.id.agregar);
        ver_lista = (Button) findViewById(R.id.ver_lista);
        lista = new ArrayList<String>();

        //Botón que agrega elementos a la lista de la app
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String elemento = campo_texto.getText().toString();

                //Verificamos que el usuario ingrese elementos no vacíos.
                if(elemento.trim().isEmpty()){
                    Toast msj = Toast.makeText(getApplicationContext(),
                            "No ingresaste nada :P", Toast.LENGTH_SHORT);
                    msj.show();
                }else{
                    agregarLista(elemento);
                    Toast msj = Toast.makeText(getApplicationContext(),
                            "Elemento agregado :D", Toast.LENGTH_SHORT);
                    msj.show();
                }
            }
        });

        //Botón que muestra los elementos de la lista de la app
        ver_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verLista(lista);
            }
        });
    }

    /**
     * Agregará un elemento a la lista de la app.
     * @param elemento el elemento que se agregará a la lista.
     */
    public void agregarLista(String elemento){
        lista.add(elemento);
    }

    /**
     * Mostrará los elementos de una lista en @SecondActivity
     * @param l una lista con elementos que se mostrarán
     */
    public void verLista(ArrayList<String> l){
        Intent intent = new Intent (this, SecondActivity.class);
        intent.putStringArrayListExtra("list", l);
        startActivity ( intent ) ;
    }
}
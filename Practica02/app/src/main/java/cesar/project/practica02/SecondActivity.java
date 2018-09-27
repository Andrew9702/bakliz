package cesar.project.practica02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ArrayList<String> lista;
    ArrayAdapter<String> adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView) findViewById(R.id.lv);
        lista = (ArrayList<String>) getIntent().getStringArrayListExtra("list");

        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom, lista);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String posicion = "Item #" + position;
                Toast msj = Toast.makeText(getApplicationContext(), posicion, Toast.LENGTH_SHORT);
                msj.show();
            }
        });
    }
}

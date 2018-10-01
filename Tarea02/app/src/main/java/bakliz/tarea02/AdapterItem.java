package bakliz.tarea02;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterItem extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Cancion> items;

    public AdapterItem (Activity activity, ArrayList<Cancion> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Cancion> cancion) {
        for (int i = 0; i < cancion.size(); i++) {
            items.add(cancion.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_cancion, null);
        }

        Cancion c = items.get(position);

        TextView cancion = (TextView) v.findViewById(R.id.cancion);
        cancion.setText(c.getNombre());

        TextView artista = (TextView) v.findViewById(R.id.artista);
        artista.setText(c.getArtista());

        ImageView imagen = (ImageView) v.findViewById(R.id.image_album);
        imagen.setImageDrawable(c.getImagen());

        return v;
    }
}
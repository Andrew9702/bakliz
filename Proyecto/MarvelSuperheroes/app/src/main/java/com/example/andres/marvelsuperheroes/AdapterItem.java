package com.example.andres.marvelsuperheroes;

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
    protected ArrayList<MarvelHero> items;

    public AdapterItem (Activity activity, ArrayList<MarvelHero> items) {
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

    public void addAll(ArrayList<MarvelHero> heroe) {
        for (int i = 0; i < heroe.size(); i++) {
            items.add(heroe.get(i));
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
            v = inf.inflate(R.layout.item, null);
        }

        MarvelHero mh = items.get(position);

        TextView heroe = (TextView) v.findViewById(R.id.heroe);
        heroe.setText(mh.getNombre());

        ImageView imagen = (ImageView) v.findViewById(R.id.image_heroe);
        imagen.setImageDrawable(mh.getImagen());

        return v;
    }
}

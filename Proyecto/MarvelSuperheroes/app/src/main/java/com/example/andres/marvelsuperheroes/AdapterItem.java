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


    private Context context;
    protected Activity activity;
    protected ArrayList<MarvelHero> items;

    public AdapterItem (Context context, ArrayList<MarvelHero> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    /*public void addAll(ArrayList<MarvelHero> heroe) {
        for (int i = 0; i < heroe.size(); i++) {
            items.add(heroe.get(i));
        }
    }*/

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
        MarvelHero hero = (MarvelHero) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

        TextView heroe = (TextView) convertView.findViewById(R.id.heroe);
        ImageView imagen = (ImageView) convertView.findViewById(R.id.image_heroe);
        imagen.setImageResource(hero.getImagen());
        heroe.setText(hero.getNombre());

        return convertView;
    }
}

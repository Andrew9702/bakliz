package com.example.andres.apidog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.PerrosHolder> implements Filterable {

    public class PerrosHolder extends RecyclerView.ViewHolder {

        TextView perro;
        ImageView imagen;

        public PerrosHolder(View itemView) {
            super(itemView);
            perro = (TextView) itemView.findViewById(R.id.perro);
            imagen = (ImageView) itemView.findViewById(R.id.image_perro);
        }

        public void asignarDatos(Perro perro_1) {
            perro.setText(perro_1.getRaza());
            String archivo = perro_1.getImagenes()[0];
            DownloadImageWithURLTask downloadTask = new DownloadImageWithURLTask(imagen);
            downloadTask.execute(archivo);
        }

    }

    ArrayList<Perro> items;
    private ArrayList<Perro> perrosList;
    private ArrayList<Perro> perrosListFull;

    public AdaptadorRecycler(ArrayList<Perro> items) {
        this.items = items;
        perrosList = items;
        perrosListFull = new ArrayList<>(items);
    }

    @Override
    public PerrosHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
        return new PerrosHolder(view);
    }

    @Override
    public void onBindViewHolder(PerrosHolder perrosHolder, int i) {
        perrosHolder.asignarDatos(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /* Parte de búsqueda de la app */

    /**
     * Filtro para encontrar superhéroes
     * @return lista de superhéroes buscados
     */
    @Override
    public Filter getFilter() {
        return heroesFilter;
    }

    private Filter heroesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Perro> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filteredList.addAll(perrosListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(Perro perro : perrosListFull){
                    if(perro.getRaza().toLowerCase().contains(filterPattern)){
                        filteredList.add(perro);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            perrosListFull.clear();
            perrosList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}


package bakliz.marvelrecords;

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

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HeroesHolder> implements Filterable {

    public class HeroesHolder extends RecyclerView.ViewHolder {

        TextView heroe;
        ImageView imagen;

        public HeroesHolder(View itemView) {
            super(itemView);
            heroe = (TextView) itemView.findViewById(R.id.heroe);
            imagen = (ImageView) itemView.findViewById(R.id.image_heroe);
        }

        public void asignarDatos(MarvelHero marvelHero) {
            heroe.setText(marvelHero.getNombre());
            String archivo = marvelHero.getImagen();
            DownloadImageWithURLTask downloadTask = new DownloadImageWithURLTask(imagen);
            downloadTask.execute(archivo);
        }

    }

    ArrayList<MarvelHero> items;
    private ArrayList<MarvelHero> heroesList;
    private ArrayList<MarvelHero> heroesListFull;

    public AdaptadorRecycler(ArrayList<MarvelHero> items) {
        this.items = items;
        heroesList = items;
        heroesListFull = new ArrayList<>(items);
    }

    @Override
    public HeroesHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
        return new HeroesHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroesHolder heroesHolder, int i) {
        heroesHolder.asignarDatos(items.get(i));
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
            ArrayList<MarvelHero> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filteredList.addAll(heroesListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(MarvelHero hero : heroesListFull){
                    if(hero.getNombre().toLowerCase().contains(filterPattern)){
                        filteredList.add(hero);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            heroesList.clear();
            heroesList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

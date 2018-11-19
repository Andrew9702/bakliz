package bakliz.marvelrecords;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HeroesHolder> {

    ArrayList<MarvelHero> items;

    public AdaptadorRecycler(ArrayList<MarvelHero> items) {
        this.items = items;
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
}

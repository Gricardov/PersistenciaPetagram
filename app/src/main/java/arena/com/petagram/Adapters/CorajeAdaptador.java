package arena.com.petagram.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import arena.com.petagram.Pollo.Coraje;
import arena.com.petagram.R;

public class CorajeAdaptador extends RecyclerView.Adapter<CorajeAdaptador.CorajeViewHolder>
{

    ArrayList<Coraje> corajes;
    Activity activity;

    public CorajeAdaptador(ArrayList<Coraje> corajes, Activity activity){this.corajes=corajes; this.activity=activity; }

    @Override
    public CorajeAdaptador.CorajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewperfil, parent, false);

    return new CorajeViewHolder(v);

    }

    @Override
    public void onBindViewHolder(CorajeAdaptador.CorajeViewHolder holder, int position) {

        Coraje coraje = corajes.get(position);

        holder.likesCoraje.setText(String.valueOf(coraje.getLikes()));

        holder.fotoCoraje.setImageResource(coraje.getFoto());


    }

    @Override
    public int getItemCount() {
        return corajes.size();
    }

    public static class CorajeViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoCoraje;
        private TextView likesCoraje;

        public CorajeViewHolder(View itemView) {
            super(itemView);

            fotoCoraje = (ImageView) itemView.findViewById(R.id.imagencoraje);
            likesCoraje = (TextView) itemView.findViewById(R.id.likescoraje);

        }
    }
}
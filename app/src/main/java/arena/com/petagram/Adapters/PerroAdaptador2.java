package arena.com.petagram.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import arena.com.petagram.Pollo.Perro;
import arena.com.petagram.R;


/**
 * Created by PC-1 on 19/08/2016.
 */
public class PerroAdaptador2 extends RecyclerView.Adapter<PerroAdaptador2.PerroViewHolder2> {

    private ArrayList<Perro> perros;
 //   private ArrayList<Integer> likes;
    private Activity activity;

    public PerroAdaptador2(ArrayList<Perro> perros, Activity activity)
    {
        this.perros=perros;
        this.activity=activity;
      // this.likes=likes;
    }

    @Override
    public PerroViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2, parent, false);

        return new PerroViewHolder2(v);


    }

    @Override
    public void onBindViewHolder(PerroViewHolder2 holder, int position) {

        Perro perro = perros.get(position);


        holder.imagenPerro2.setImageResource(perro.getImagen());

        holder.numeroDeLikes.setText(String.valueOf(perro.getNombre())+" tiene "+perro.getLikes()+" likes");






    }


    @Override
    public int getItemCount() {
        return perros.size();
    }


    public static class PerroViewHolder2 extends RecyclerView.ViewHolder
    {
        private ImageView imagenPerro2;


        private TextView numeroDeLikes;



        public PerroViewHolder2(View itemView)
        {
            super(itemView);

            imagenPerro2 = (ImageView) itemView.findViewById(R.id.imagenPerro2);
           numeroDeLikes = (TextView) itemView.findViewById(R.id.numeroLikes2);



        }
    }
}

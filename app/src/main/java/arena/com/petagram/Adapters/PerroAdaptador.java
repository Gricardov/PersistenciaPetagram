package arena.com.petagram.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import arena.com.petagram.DataBase.ConstructorDB;
import arena.com.petagram.Pollo.Perro;
import arena.com.petagram.R;


/**
 * Created by PC-1 on 19/08/2016.
 */
public class PerroAdaptador extends RecyclerView.Adapter<PerroAdaptador.PerroViewHolder> {

    private ArrayList<Perro> perros;
    private Activity activity;


    public PerroAdaptador(ArrayList<Perro> perros, Activity activity)
    {
        this.perros=perros;
        this.activity=activity;
    }

    @Override
    public PerroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new PerroViewHolder(v);


    }

    @Override
    public void onBindViewHolder(final PerroViewHolder holder, final int position) {

        final Perro perro = perros.get(position);

        holder.nombrePerro.setText(perro.getNombre());
        holder.imagenPerro.setImageResource(perro.getImagen());



        holder.likesPerro.setText(String.valueOf(perro.getLikes()));

        holder.imagenHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            ConstructorDB constructorDB= new ConstructorDB(activity);

                constructorDB.darLikePerro(perro);
            holder.likesPerro.setText(Integer.toString(constructorDB.obtenerLikesPerro(perro)));
                // perros.get(position).aumentarLikes();

               // holder.likesPerro.setText(String.valueOf(perros.get(position).getLikes()));

                Toast.makeText(activity, "Le diste like a "+perros.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return perros.size();
    }


    public static class PerroViewHolder extends RecyclerView.ViewHolder
    {
    private ImageView imagenPerro;
    private ImageView imagenHueso;
        private TextView nombrePerro;
        private TextView likesPerro;



    public PerroViewHolder(View itemView)
    {
        super(itemView);

        imagenPerro = (ImageView) itemView.findViewById(R.id.imagenPerro);
        imagenHueso = (ImageView) itemView.findViewById(R.id.imagenHueso);

        nombrePerro = (TextView) itemView.findViewById(R.id.nombrePerro);
        likesPerro =  (TextView) itemView.findViewById(R.id.likesPerro);



    }
    }
}

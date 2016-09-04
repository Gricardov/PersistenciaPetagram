package arena.com.petagram.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import arena.com.petagram.Adapters.CorajeAdaptador;
import arena.com.petagram.Pollo.Coraje;
import arena.com.petagram.R;


public class CorajeFragment extends Fragment {

    ArrayList<Coraje> corajes;
RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerviewperfil);



colocarLayoutManager();
       inicializarDatos();
        colocarAdaptador();

       return v;
    }


    public void colocarLayoutManager(){
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

    }



public void inicializarDatos()
{
corajes = new ArrayList<Coraje>();
    corajes.add(new Coraje(R.drawable.coraje, 7));
    corajes.add(new Coraje(R.drawable.coraje2, 4));
    corajes.add(new Coraje(R.drawable.coraje3, 4));
    corajes.add(new Coraje(R.drawable.coraje4,3));
    corajes.add(new Coraje(R.drawable.coraje5, 5));
    corajes.add(new Coraje(R.drawable.coraje6, 4));
    corajes.add(new Coraje(R.drawable.coraje1, 3));


}


    public void colocarAdaptador()
    {
        CorajeAdaptador corajeAdaptador = new CorajeAdaptador(corajes, (Activity) getContext());
        recyclerView.setAdapter(corajeAdaptador);

    }

}


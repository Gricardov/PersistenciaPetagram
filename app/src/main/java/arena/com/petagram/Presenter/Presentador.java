package arena.com.petagram.Presenter;

import android.content.Context;

import java.util.ArrayList;

import arena.com.petagram.DataBase.ConstructorDB;
import arena.com.petagram.DataBase.DataBase;
import arena.com.petagram.Fragments.RecyclerViewFragment;
import arena.com.petagram.Pollo.Perro;

/**
 * Created by PC-1 on 02/09/2016.
 */
public class Presentador {
    private RecyclerViewFragment rvf;
    private Context context;
    private ConstructorDB constructorDB;
    private ArrayList<Perro> perros;
private DataBase db= new DataBase(context);

    public Presentador(RecyclerViewFragment rvf, Context context) {
        this.rvf=rvf;
        this.context = context;
        obtenerPerros();
    }


   public void obtenerPerros() {

        constructorDB = new ConstructorDB(context);
        perros = constructorDB.obtenerPerros();


        mostrarPerros();
    }



    public void mostrarPerros() {
        rvf.inicializarLLM();
        rvf.inicializarAdaptador(perros);

    }




}

package arena.com.petagram.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import arena.com.petagram.Adapters.PerroAdaptador2;
import arena.com.petagram.DataBase.DataBase;
import arena.com.petagram.Pollo.Perro;
import arena.com.petagram.R;

public class Favoritos extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayoutManager linearLayoutManager2;
    RecyclerView recyclerView2;
    ArrayList<Perro> listaPerros2;
    ArrayList<Integer> likes;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        //definimos la toolbar como actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //habilitar flecha arriba
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quitamos el título
        getSupportActionBar().setTitle(null);

        //recibimos los extra (numero de likes)

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            likes = extras.getIntegerArrayList(getResources().getString(R.string.idLikesPerros));
        }


        //colocamos el layoutmanager para el recycler view
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        //inicializamos los datos
        inicializarDatos();

        //ordenamos los datos con likes de mayor a menor
        ordenarDatos();

        //colocamos el adaptador para nuestro recycler view2
        colocarAdaptador();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    public void ordenarDatos() {


        Perro perroAux;
   // ArrayList<Perro> listaOrdenada = new ArrayList<Perro>();

for(int k=0; k<listaPerros2.size()-1; k++ ){

        for (int i = 0; i < listaPerros2.size()-1; i++) {

            //hallo el perro con mayor cantidad de likes
            if (listaPerros2.get(i).getLikes() < listaPerros2.get(i + 1).getLikes()) {

                perroAux = listaPerros2.get(i + 1);

                listaPerros2.set(i + 1, listaPerros2.get(i));

                listaPerros2.set(i, perroAux);


            }
        }

        }


    }


    //Inicializo aquí de nuevo porque al final la posicion no cambia
    public void inicializarDatos() {
        DataBase db = new DataBase(this);
        listaPerros2 = db.obtenerTodosLosPerros();

       /* listaPerros2 = new ArrayList<Perro>();

        listaPerros2.add(new Perro("Coraje", R.drawable.coraje));
        listaPerros2.add(new Perro("Pichula",R.drawable.pichula));
        listaPerros2.add(new Perro("Brako", R.drawable.brako));
        listaPerros2.add(new Perro("Pechocho", R.drawable.perroprecioso));
        listaPerros2.add(new Perro("Pendejo", R.drawable.verga));
*/
    }

    public void colocarAdaptador() {
        PerroAdaptador2 adaptador = new PerroAdaptador2(listaPerros2, this);
        recyclerView2.setAdapter(adaptador);


    }

}



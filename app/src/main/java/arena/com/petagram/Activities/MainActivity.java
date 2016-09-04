package arena.com.petagram.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import arena.com.petagram.Adapters.ViewPagerAdapter;
import arena.com.petagram.Fragments.CorajeFragment;
import arena.com.petagram.Fragments.RecyclerViewFragment;
import arena.com.petagram.Pollo.Perro;
import arena.com.petagram.R;

public class MainActivity extends AppCompatActivity {


    ArrayList<Perro> listaPerros;

    Toolbar toolbar;
    Toolbar toolbartabbed;
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;

    RecyclerViewFragment recyclerViewFragment;
    CorajeFragment corajeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
      //  toolbartabbed = (Toolbar) findViewById(R.id.toolbartabbed);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);


        //añadir perros a la lista

            listaPerros = new ArrayList<Perro>();

            listaPerros.add(new Perro("Coraje", R.drawable.coraje7));
            listaPerros.add(new Perro("Pichula", R.drawable.pichula));
            listaPerros.add(new Perro("Brako", R.drawable.brako));
            listaPerros.add(new Perro("Pechocho", R.drawable.perroprecioso));
            listaPerros.add(new Perro("Verga", R.drawable.verga));



        //definir la toolbar como actionbar
             if (toolbar!=null)  {setSupportActionBar(toolbar);}

        //quitamos el título
        getSupportActionBar().setTitle(null);

        //creando arraylist de fragments para el adaptador
        fragments=new ArrayList<Fragment>();
      recyclerViewFragment= new RecyclerViewFragment();
        corajeFragment = new CorajeFragment();

        //aquí le paso la lista de perros a mi fragment
       // recyclerViewFragment.setListaPerros(listaPerros);

        //agrego los fragments a su array
        fragments.add(recyclerViewFragment);
        fragments.add(corajeFragment);

        //le ponemos adaptador al view pager y le pasamos el array de fragments

       viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));

        //asociamos el tablayout con el viewpager

     tabLayout.setupWithViewPager(viewPager);





        //le colocamos nombres a las pestassas
      tabLayout.getTabAt(0).setText("Perros");
        tabLayout.getTabAt(1).setText("Perfil");

    }



    //inflo el menu para esta activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return  super.onCreateOptionsMenu(menu);

    }

    //coloco un "listener" de los elementos del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.menuFavoritos:
                abrirFavoritos();
                return true;

            case R.id.menuMasInformacion:
                abrirInformacion();
                return true;

            case R.id.menuContacto:
                abrirContacto();
                return true;

            case R.id.menuAcercaDe:
                abrirAcercaDe();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);

        }

    }

    private void abrirAcercaDe() {

        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent);
    }

    private void abrirContacto() {

        Intent intent = new Intent(this, Contacto.class);
        startActivity(intent);
    }

    public void abrirFavoritos()
    {


        Intent intent = new Intent(this, Favoritos.class);
        /*ArrayList<Integer> likes = new ArrayList<Integer>();
        ArrayList<Perro> perros = recyclerViewFragment.getListaPerros();

        for(Perro perro: perros)
        {
            likes.add(perro.getLikes());
        }

        intent.putExtra(getResources().getString(R.string.idLikesPerros), likes);
          */
          startActivity(intent);
    }

    public void abrirInformacion()
    {
        Intent intent = new Intent(this, Informacion.class);
        startActivity(intent);
    }





}

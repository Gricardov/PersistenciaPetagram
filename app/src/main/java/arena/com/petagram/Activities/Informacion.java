package arena.com.petagram.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import arena.com.petagram.R;

public class Informacion extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        //definimos la toolbar como actionbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //habilitar flecha arriba
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quitamos el título
        getSupportActionBar().setTitle(null);


    }
}

package arena.com.petagram.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import arena.com.petagram.GMailSender;
import arena.com.petagram.R;

public class Contacto extends AppCompatActivity {
Toolbar toolbar;
    EditText et_nombre;
    EditText et_mensaje;
    EditText et_correo;
    Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        //definimos la toolbar como actionbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //habilitar flecha arriba
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quitamos el título
        getSupportActionBar().setTitle(null);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        et_nombre = (EditText) findViewById(R.id.input_name);
        et_correo = (EditText) findViewById(R.id.input_email);
        et_mensaje= (EditText) findViewById(R.id.input_message);



    }

    public void enviarMensaje(View v)
    {
        Toast.makeText(this, "Enviando correo", Toast.LENGTH_SHORT).show();
        try {
            GMailSender sender = new GMailSender("tareacoursera@gmail.com", "anahisalgadoteamo");
            sender.sendMail("Mensaje de "+et_nombre.getText().toString(),
                    et_mensaje.getText().toString(),
                    "tareacoursera@gmail.com",
                    "gricardov@gmail.com");
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }

    }
}

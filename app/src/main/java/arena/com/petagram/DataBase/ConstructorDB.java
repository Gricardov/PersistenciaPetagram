package arena.com.petagram.DataBase;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import arena.com.petagram.Pollo.Perro;
import arena.com.petagram.R;

/**
 * Created by PC-1 on 02/09/2016.
 */
public class ConstructorDB {

    private static final int LIKE = 1;
    private Context context;
//private int contador=0;

    public ConstructorDB(Context context) {
        this.context = context;
    }


    public ArrayList<Perro> obtenerPerros() {
    DataBase db = new DataBase(context);

     //  contador++;
     //   Toast.makeText(context, "contador: "+contador, Toast.LENGTH_SHORT).show();
        insertarPerros(db);
        return  db.obtenerTodosLosPerros();
    }



    public void insertarPerros(DataBase db)   {

            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConstants.TABLE_PERROS_NOMBRE, "Coraje");
            contentValues.put(DBConstants.TABLE_PERROS_IMAGEN, R.drawable.coraje7);


            db.insertarPerro(contentValues);


        contentValues = new ContentValues();
        contentValues.put(DBConstants.TABLE_PERROS_NOMBRE, "Pichula");
        contentValues.put(DBConstants.TABLE_PERROS_IMAGEN, R.drawable.pichula);


        db.insertarPerro(contentValues);


        contentValues = new ContentValues();
        contentValues.put(DBConstants.TABLE_PERROS_NOMBRE, "Brasko");
        contentValues.put(DBConstants.TABLE_PERROS_IMAGEN, R.drawable.brako);


        db.insertarPerro(contentValues);


        contentValues = new ContentValues();
        contentValues.put(DBConstants.TABLE_PERROS_NOMBRE, "Pechocho");
        contentValues.put(DBConstants.TABLE_PERROS_IMAGEN, R.drawable.perroprecioso);


        db.insertarPerro(contentValues);


        contentValues = new ContentValues();
        contentValues.put(DBConstants.TABLE_PERROS_NOMBRE, "Pendejo");
        contentValues.put(DBConstants.TABLE_PERROS_IMAGEN, R.drawable.verga);


        db.insertarPerro(contentValues);

    }


    //es llamado por el listener. Este llama a la DataBase
    public void darLikePerro(Perro perro){
       DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.TABLE_LIKES_PERROS_ID_PERRO, perro.getId());
        contentValues.put(DBConstants.TABLE_LIKES_PERROS_LIKES, LIKE);
        db.insertarLikePerro(contentValues);
    }

    //es llamado por el listener. Este llama a la DataBase
    public int obtenerLikesPerro(Perro perro){
DataBase db = new DataBase(context);
        return db.obtenerLikesPerro(perro);
    }


}






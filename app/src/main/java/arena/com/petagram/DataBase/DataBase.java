package arena.com.petagram.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import arena.com.petagram.Pollo.Perro;

/**
 * Created by PC-1 on 02/09/2016.
 */
public class DataBase extends SQLiteOpenHelper {

        private Context context;

        public DataBase(Context context) {
            super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String queryCrearTablaPerros = "CREATE TABLE " + DBConstants.TABLE_PERROS + "(" +
                    DBConstants.TABLE_PERROS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DBConstants.TABLE_PERROS_NOMBRE + " TEXT, " +
                    DBConstants.TABLE_PERROS_IMAGEN + " INTEGER" +
                    ")";

            String queryCrearTablaLikesPerros = "CREATE TABLE " + DBConstants.TABLE_LIKE_PERROS + "(" +
                    DBConstants.TABLE_LIKES_PERROS_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DBConstants.TABLE_LIKES_PERROS_ID_PERRO + " INTEGER, " +
                    DBConstants.TABLE_LIKES_PERROS_LIKES + " INTEGER, " +
                    "FOREIGN KEY (" + DBConstants.TABLE_LIKES_PERROS_ID_PERRO + ") " +
                    "REFERENCES " + DBConstants.TABLE_PERROS + "(" + DBConstants.TABLE_PERROS_ID + ")" +
                    ")";

            db.execSQL(queryCrearTablaPerros);
            db.execSQL(queryCrearTablaLikesPerros);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXIST " + DBConstants.TABLE_PERROS);
            db.execSQL("DROP TABLE IF EXIST " + DBConstants.TABLE_LIKE_PERROS);
            onCreate(db);
        }


//Devuelvo ArrayList con todos los perros desde DB
        public ArrayList<Perro> obtenerTodosLosPerros() {
            ArrayList<Perro> perros = new ArrayList<>();

            String query = "SELECT * FROM " + DBConstants.TABLE_PERROS;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query, null);

            while (registros.moveToNext()){
                Perro perrito = new Perro();
                perrito.setId(registros.getInt(0));
                perrito.setNombre(registros.getString(1));
                perrito.setImagen(registros.getInt(2));

//Si el id coincide entonces asignar los likes
                String queryLikes = "SELECT COUNT("+DBConstants.TABLE_LIKES_PERROS_LIKES+") as likes " +
                        " FROM " + DBConstants.TABLE_LIKE_PERROS +
                        " WHERE " + DBConstants.TABLE_LIKES_PERROS_ID_PERRO + "=" + perrito.getId();

                Cursor registrosLikes = db.rawQuery(queryLikes, null);

              if (registrosLikes.moveToNext()){
                    perrito.setLikes(registrosLikes.getInt(0));
                }else {
                    perrito.setLikes(0);
                }

                perros.add(perrito);

            }

            db.close();

            return perros;
        }

//Para introducir los datos. Inidico en qué tabla y recibo ContentValues con la información.
        public void insertarPerro(ContentValues contentValues){
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(DBConstants.TABLE_PERROS, null, contentValues);
            db.close();
        }
//Es llamado por el listener de likes. Para introducir los datos. Indico en qué tabla y recibo ContentValues con la información.
        public void insertarLikePerro(ContentValues contentValues){
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(DBConstants.TABLE_LIKE_PERROS, null, contentValues);
            db.close();
        }


    //Es llamado por el listener de likes. Recibo un perro.
        public int obtenerLikesPerro(Perro perro){
            int likes = 0;

            String query = "SELECT COUNT("+DBConstants.TABLE_LIKES_PERROS_LIKES+")" +
                    " FROM " + DBConstants.TABLE_LIKE_PERROS +
                    " WHERE " + DBConstants.TABLE_LIKES_PERROS_ID_PERRO + "="+perro.getId();

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query, null);

           if (registros.moveToNext()){
                likes = registros.getInt(0);
            }

            db.close();

            return likes;
        }
    }







package arena.com.petagram.Pollo;

/**
 * Created by PC-1 on 19/08/2016.
 */
public class Perro {

   private String nombre;
   private int likes=0;
   private int imagen;
    private int id;

    public Perro(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Perro(){}

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {this.likes=likes;}


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;}

        public int getId(){return this.id;}
    }

    // public void aumentarLikes(){       likes++;    }


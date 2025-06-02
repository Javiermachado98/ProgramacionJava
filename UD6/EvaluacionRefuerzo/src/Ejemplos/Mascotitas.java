package Ejemplos;
import java.util.ArrayList;


public class Mascotitas {



    private String nombre;
    private String tipo;

    public Mascotitas(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Mascotitas{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public static void main(String[] args) {

        ArrayList<Mascotitas> arrayListMascotita = new ArrayList();
        arrayListMascotita.add(new Mascotitas("shiro","gato"));
        arrayListMascotita.add((new Mascotitas("drako", "perro")));
        arrayListMascotita.add((new Mascotitas("timon", "venado")));

        for (int i= 0; i < arrayListMascotita.size(); i++){
            System.out.println(arrayListMascotita.get(i));
        }
    }
}

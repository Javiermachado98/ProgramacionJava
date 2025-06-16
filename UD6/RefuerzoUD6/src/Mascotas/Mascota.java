package Mascotas;

public class Mascota {

    protected String nombre;
    protected String tipo;
    protected String raza;

    //este es el constructor que siempre es el llamado cuando hago una clase
    public Mascota(String nombre, String tipo, String raza) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
    }

    public void mostrarMascota(){
        System.out.println("hola soy: " + nombre + " soy " + tipo + " de raza " + raza);
    }

    public void hacerSonido(){
        System.out.println("Hacer sonido");
    }


    public static void main(String[] args) {
        //aqui es donde creo mi primer objeto de la clase, que se va a llamar mi mascota, pero puedo crear cualquier mascota
        Mascota mymascota = new Mascota("Firulais", "Perro", "Labrador");
        mymascota.mostrarMascota();


    }
}

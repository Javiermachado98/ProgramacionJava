package p061MenusUD9;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Plato {
    
    protected String nombre;
    protected double precio;
    protected int nCalorias;
    protected ListaAlergenos listaAlergenosPlato;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getnCalorias() {
        return nCalorias;
    }

    public void setnCalorias(int nCalorias) {
        this.nCalorias = nCalorias;
    }



    public Plato() {
        this.listaAlergenosPlato = new ListaAlergenos();
    }

    public Plato(String nombre, double precio, int nCalorias) {
        this.nombre = nombre;
        this.precio = precio;
        this.nCalorias = nCalorias;
        this.listaAlergenosPlato = new ListaAlergenos();
    }

    public void pideNuevoAlergeno() {

        tipoAlergeno nuevo = tipoAlergeno.NINGUNO;
        nuevo.validaAlergeno();
        nuevo = nuevo.validaAlergeno();
        listaAlergenosPlato.anadirAlergeno(nuevo);

    }
    
    public void anadeAlergeno(tipoAlergeno nuevoAlergeno) {
        listaAlergenosPlato.anadirAlergeno(nuevoAlergeno);
    }
    
    public void alta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Precios: ");
        precio = sc.nextDouble();
        System.out.print("´Número de calorías: ");
        nCalorias = sc.nextInt();

        char opcion = 's';
        do {
            System.out.println("¿Quieres añadir un alérgeno?(S/N)");
            opcion = sc.next().toLowerCase().charAt(0);
            if (opcion == 's') {
                pideNuevoAlergeno();
            }
        } while (opcion == 's');
    }

    @Override
    public String toString() {
        return "Plato{" + "nombre=" + nombre + ", precio=" + precio + ", nCalorias=" + nCalorias + ", listaAlergenosPlato=" + listaAlergenosPlato + '}';
    }
    
    
    

}

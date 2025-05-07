package p01Nominas;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * DAW1. Ejemplo Gestión Nóminas
 */

/**
 * Clase para gestionar una lista de empleados
 */
public class ListaEmpleados implements Serializable{

    private ArrayList<Empleado> lista;

    /**
     * Constructor
     */
    public ListaEmpleados() {
        lista = new ArrayList();
    }

    /**
     * Añade el empleado que se le pasa como parámetro a la lista
     * @param e
     */
    public void anadirEmpleado(Empleado e) {
        lista.add(e);
    }

    /**
     * Muestra todos los empleados de la lista, junto con su número de orden (comenzando en 1)
     */
    public void mostrarEmpleados() {
        int contador = 1;   
        for (Empleado e : lista) {
            System.out.println(contador + " " + e);
            contador++;
        }

    }

    /**
     * Devuelve el número de empleados de la lista
     * @return
     */
    public int numeroEmpleados() {
        return (lista.size());
    }
    
    /**
     * Devuelve el empleado que se encuentra en la posición que se le pasa como parámetro
     * @param i
     * @return
     */
    public Empleado empleadoPosicionI(int i) {
        return lista.get(i);
    }
    
    /** 
     * Muestra todas las nóminas de los empleados cuyo importe es superior al parámetro
     * @param importe
     */
    public void muestraNominasEmpleadosMayores(double importe) {
        for (Empleado emp : lista) {
            System.out.println("Empleado: " + emp.getNombre() + " "  + emp.getApellidos());
            emp.muestraNominasMayoresImporte(importe);
        }
    }
    
}
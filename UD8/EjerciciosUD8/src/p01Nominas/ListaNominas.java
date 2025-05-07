package p01Nominas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/*
 * DAW1. Ejemplo Gestión Nóminas
 */

/**
 * daLista de nóminas
 */
public class ListaNominas implements Serializable{

    private ArrayList<Nomina> lista;

    /**
     * Contructor
     */
    public ListaNominas() {
        lista = new ArrayList();
    }

    /**
     * Añade la nómina que se le pasa como  parámetro a la lista de nominas
     * @param e
     */
    public void anadirNomina(Nomina e) {
        lista.add(e);
    }

    /**
     * Muestra las nóminas de la lista
     */
    public void mostrarNominas() {
        for (Nomina e : lista) {
            System.out.println(e);
        }

    }

    /**
     * Devuelve el número de nóminas de la lista
     * @return
     */
    public int numeroNominas() {
        return (lista.size());
    }
    
    /**
     * Devuelve la nómina que se encuentra en la posición que se le pasa como parámetro
     * @param i
     * @return
     */
    public Nomina nominaPosicionI(int i) {
        return lista.get(i);
    }
    
    /** 
     * Muestra las nóminas de la lista cuyo importe es superior al parámetro
     * @param importe
     */
    public void muestraNomminasMayoresImporte(double importe) {
        for (Nomina n: lista) {
            if (n.getImporte() > importe) {
                System.out.println(n);
            }
        }
    }
    
}
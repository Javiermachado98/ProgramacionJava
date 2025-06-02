package Controller;

import Model.Infraccion;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * DAW1. Ejemplo Gestión Multas
 */

/**
 * Clase para gestionar una lista de infracciones
 */
@XmlRootElement(name = "infracciones")
@XmlType(propOrder = {"lista"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaInfracciones implements Serializable{
    @XmlElement(name = "infracciones")

    private ArrayList<Infraccion> lista = new ArrayList<>();

    /**
     * Constructor
     */
    public ListaInfracciones() {
        lista = new ArrayList();
    }

    /**
     * Añade el infraccion que se le pasa como parámetro a la lista
     * @param e
     */
    public void anadirInfraccion(Infraccion e) {
        lista.add(e);
    }


    /**
     * Muestra todos los infraccions de la lista, junto con su número de orden (comenzando en 1)
     */
    public void mostrarInfracciones() {
        int contador = 1;
        for (Infraccion e : lista) {
            System.out.println(contador + " " + e);
            contador++;
        }

    }

    /**
     * Devuelve el número de infraccions de la lista
     * @return
     */
    public int numeroInfracciones() {
        return (lista.size());
    }

    /**
     * Devuelve el infraccion que se encuentra en la posición que se le pasa como parámetro
     * @param i
     * @return
     */
    public Infraccion infraccionPosicionI(int i) {
        return lista.get(i);
    }

}
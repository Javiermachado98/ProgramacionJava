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
@XmlType(propOrder = {"listaInfracciones"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaInfracciones implements Serializable {
    @XmlElement(name = "Infraccion")

    private ArrayList<Infraccion> listaInfracciones = new ArrayList<>();

    /**
     * Constructor
     */
    public ListaInfracciones() {
    }

    /**
     * Añade el infraccion que se le pasa como parámetro a la lista
     *
     * @param e
     */
    public void anadirInfraccion(Infraccion e) {
        listaInfracciones.add(e);
    }


    /**
     * Muestra todos los infraccions de la lista, junto con su número de orden (comenzando en 1)
     */
    public void mostrarInfracciones() {
        int contador = 1;
        for (Infraccion e : listaInfracciones) {
            System.out.println(contador + " " + e);
            contador++;
        }

    }

    public void setListaInfracciones(ArrayList<Infraccion> listaInfracciones) {
        this.listaInfracciones = listaInfracciones;
    }

    public ArrayList<Infraccion> getListaInfracciones() {
        return listaInfracciones;
    }

    /**
     * Devuelve el número de infraccions de la lista
     *
     * @return
     */
    public int numeroInfracciones() {
        return (listaInfracciones.size());
    }

    /**
     * Devuelve el infraccion que se encuentra en la posición que se le pasa como parámetro
     *
     * @param i
     * @return
     */
    public Infraccion infraccionPosicionI(int i) {
        return listaInfracciones.get(i);
    }

    @Override
    public String toString() {
        return "ListaInfracciones{" +
                "listaInfracciones=" + listaInfracciones +
                '}';
    }
}
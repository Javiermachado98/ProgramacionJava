package Controller;

import Model.Agente;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * DAW1. Ejemplo Gestión Multas
 */

/**
 * Clase para gestionar una lista de agentes
 */
public class ListaAgentes implements Serializable {

    private ArrayList<Agente> lista = new ArrayList<>();

    /**
     * Constructor
     */
    public ListaAgentes() {
        lista = new ArrayList();
    }

    /**
     * Añade el agente que se le pasa como parámetro a la lista
     *
     * @param e
     */
    public void anadirAgente(Agente e) {
        lista.add(e);
    }

    /**
     * Muestra todos los agentes de la lista, junto con su número de orden (comenzando en 1)
     */
    public void mostrarAgentes() {
        int contador = 1;
        for (Agente e : lista) {
            System.out.println(contador + " " + e);
            contador++;
        }

    }

    /**
     * Devuelve el número de agentes de la lista
     *
     * @return
     */
    public int numeroAgentes() {
        return (lista.size());
    }

    /**
     * Devuelve el agente que se encuentra en la posición que se le pasa como parámetro
     *
     * @param i
     * @return
     */
    public Agente agentePosicionI(int i) {
        return lista.get(i);
    }

}
package Controller;

import Model.Agente;
import Model.Infraccion;

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

    public ArrayList<Agente> getLista() {
        return lista;
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

    public void mostrarInfraccionesAgente(String placa){

        Boolean agenteEncontrado = false;

        for (Agente agente : lista) {
            if ((agente.getIdPlaca().equals(placa))) {
                agenteEncontrado = true;
                System.out.println("El agente con placa: " + placa + " ha realizado estas infracciones: ");
                System.out.println(agente.getInfraccionesEmitidas());

            }
        }

        if (!agenteEncontrado) {
            System.out.println("Esta placa no existe en nuestro sistema, revisala por favor");
        }

    }

    public double recaudacionesAgente(String placa){

        double recaudaciones = 0;
        Boolean agenteEncontrado = false;

        for (Agente agente : lista){
            if (agente.getIdPlaca().equals(placa)){
                for (Infraccion myinfraccion : agente.getInfraccionesEmitidas().getListaInfracciones()){
                    recaudaciones = recaudaciones + myinfraccion.getSancion();
                }
                agenteEncontrado = true;
            }
        }
        if (!agenteEncontrado) {
            System.out.println("Esta placa no existe en nuestro sistema, revisala por favor");
        }
        System.out.println("La recaudacion del agente: " + placa + " es " + recaudaciones);

        return recaudaciones;
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

    @Override
    public String toString() {
        return "ListaAgentes{" +
                "lista=" + lista +
                '}';
    }
}
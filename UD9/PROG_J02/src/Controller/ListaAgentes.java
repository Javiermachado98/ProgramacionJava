package Controller;

import Model.Agente;
import Model.Infraccion;

import javax.xml.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * DAW1. Ejemplo Gestión Multas
 */

/**
 * Clase para gestionar una lista de agentes
 */

@XmlRootElement(name = "Agentes")
@XmlType(propOrder = {"lista"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaAgentes implements Serializable {
    @XmlElement(name = "Agente")

    private ArrayList<Agente> lista = new ArrayList<>();

    public ArrayList<Agente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Agente> lista) {
        this.lista = lista;
    }

    /**
     * Constructor
     */
    public ListaAgentes() {
        lista = new ArrayList();
    }

    public ArrayList<Agente> getListaAgentes() {
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

    public Agente buscarAgentePorPlaca(String placa) {
        for (Agente a : lista) {
            if (a.getIdPlaca().equals(placa)) {
                return a;
            }
        }
        return null;
    }

    public void mostrarInfraccionesAgente(String placa) {

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

    public double recaudacionesAgente(String placa) {

        double recaudaciones = 0;
        Boolean agenteEncontrado = false;

        for (Agente agente : lista) {
            if (agente.getIdPlaca().equals(placa)) {
                for (Infraccion myinfraccion : agente.getInfraccionesEmitidas().getListaInfracciones()) {
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


    public void mostrarAgenteConMasMultas() {
        if (lista.isEmpty()) {
            System.out.println("No hay agentes en la lista.");
            return;
        }

        Agente agenteMax = lista.get(0);
        int maxMultas = agenteMax.getInfraccionesEmitidas().getListaInfracciones().size();

        for (Agente agente : lista) {
            int numMultas = agente.getInfraccionesEmitidas().getListaInfracciones().size();
            if (numMultas > maxMultas) {
                maxMultas = numMultas;
                agenteMax = agente;
            }
        }

        System.out.println("El agente con más multas es:");
        System.out.println("Placa: " + agenteMax.getIdPlaca());
        System.out.println("Rango: " + agenteMax.getRango());
        System.out.println("Municipio: " + agenteMax.getMunicipio());
        System.out.println("Número de multas: " + maxMultas);
        System.out.println("Multas: " + agenteMax.getInfraccionesEmitidas().getListaInfracciones());
    }

    public void exportarCSV(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            String encabezado = "idPlaca;Rango;Municipio";
            pw.println(encabezado);

            for (Agente a : lista) {
                if (!a.getInfraccionesEmitidas().getListaInfracciones().isEmpty()) {
                    pw.println(a.getIdPlaca() + ";" + a.getRango() + ";" + a.getMunicipio());
                }
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo el fichero CSV: " + e.getMessage());
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

    @Override
    public String toString() {
        return "ListaAgentes{" +
                "lista=" + lista +
                '}';
    }
}
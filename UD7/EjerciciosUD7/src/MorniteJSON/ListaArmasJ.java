package MorniteJSON;

import MorniteP.ArmaP;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaArmasJ implements Serializable {
    private ArrayList<ArmaP> ListaArmas;

    //CONSTRUCTOR CON EL ARRAY
    public ListaArmasJ() {
        ListaArmas = new ArrayList<>();
    }

    //metodo get

    public ArrayList<ArmaP> getListaArmas() {
        return ListaArmas;
    }

    //metodos set
    public void setListaArmas(ArrayList<ArmaP> listaArmas) {
        ListaArmas = listaArmas;
    }

    /// MOSTRAR EL NUMERO DE ARMAS EN LA LISTA
    public int nArmas() {
        return ListaArmas.size();

    }

    /// ANADIR ARMA A A LA LISTA
    public void anadirArma() {
        ArmaP P = new ArmaP();
        P.AltaArma();
        ListaArmas.add(P);
        System.out.println("arma añadidda con exito ");

    }

    /// ACCEDER A LA POSICION DE UNA ARMA
    public ArmaP armaPosicion(int posicion) {
        return ListaArmas.get(posicion);
    }

    /// MOSTRAR ARMAS CON SU NUMERO DE ORDENEN LA LISTA
    public void mostrarArmasOrden() {
        if (ListaArmas.isEmpty()) {
            System.out.println("no hay armas almacenadas");
        } else {
            for (int i = 0; i < ListaArmas.size(); i++) {
                System.out.println("arma posicion : " + (i + 1) + "Nombre" + ListaArmas.get(i).getNombre() + " " + ListaArmas.get(i).getDannio());
            }
        }
    }

    /// además una operación sumaDaños que
    /// devolverá una suma de los daños de todas las armas de la lista de armas.
    public int SumaDanos() {
        int suma = 0;
        if (ListaArmas.isEmpty()) {
            System.out.println("no hay armas almacenadas");
        } else {
            for (int i = 0; i < ListaArmas.size(); i++) {
                suma += ListaArmas.get(i).getDannio();
            }
        }
        return suma;
    }




}

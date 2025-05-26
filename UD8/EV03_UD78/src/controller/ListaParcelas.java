package controller;

import model.Parcela;

import java.util.ArrayList;
import java.util.List;

public class ListaParcelas {

    List<Parcela> arrayListParcelas = new ArrayList();

    /**
     * Crea una lista de Parcelas
     */
    public ListaParcelas() {

    }

    /**
     *
     * @return el número de Parcelas de la lista
     */
    public int nParcelas() {
        return arrayListParcelas.size();
    }

    /**
     * Añadimos un Parcela al final de la lista
     *
     * @param p
     */
    public void anadirParcela(Parcela p) {
        arrayListParcelas.add(p);
    }

    /**
     *
     * @param posicion
     * @return El Parcela que está en la posición posicion
     */
    public Parcela parcelaPosicion(int posicion) {
        boolean vacio = false;
        int contador = 1;
        for (Parcela p : arrayListParcelas){
            System.out.println("Posicion parcela" + p);
            contador++;
            vacio = true;

        }
        return arrayListParcelas.get(posicion - 1 );
    }



    /**
     * Muestra todos los Parcelas de la lista
     */
    public void mostrarLista() {
        for (int i = 0; i < arrayListParcelas.size(); i++) {
            System.out.println("" + (i+1) + " " + arrayListParcelas.get(i));
        }
    }
    
}

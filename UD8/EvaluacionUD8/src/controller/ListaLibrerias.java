package controller;

import model.Libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaLibrerias {

    List<Libreria> arrayListLibrerias = new ArrayList();

    /**
     * Crea una lista de Librerias
     */
    public ListaLibrerias() {

    }

    /**
     *
     * @return el número de Librerias de la lista
     */
    public int nLibrerias() {
        return arrayListLibrerias.size();
    }

    /**
     * Pedimos los datos y añadimos un Libreria al final de la lista
     *
     */
    public void anadirLibreria() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nDatos de la librería=====");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("CIF: ");
        String cif = sc.nextLine();
        System.out.print("Calle y número: ");
        String calle = sc.nextLine();
        System.out.print("Código Postal: ");
        String cp = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();

        Libreria l = new Libreria(nombre, cif, calle, cp, tel);
        this.anadirLibreria(l);

    }

    /**
     * Añadimos un Libreria al final de la lista
     *
     * @param p
     */
    public void anadirLibreria(Libreria p) {
        arrayListLibrerias.add(p);
    }

    /**
     *
     * @param posicion
     * @return El Libreria que está en la posición posicion
     */
    public Libreria LibreriaPosicion(int posicion) {
        return arrayListLibrerias.get(posicion);
    }

    /**
     * Muestra todos los Librerias de la lista
     */
    public void mostrarLista() {
        for (int i = 0; i < arrayListLibrerias.size(); i++) {
            System.out.println(arrayListLibrerias.get(i));
        }
    }

}

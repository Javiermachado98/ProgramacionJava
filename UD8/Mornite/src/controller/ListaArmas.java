import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que representa una lista de armas.
 * 
 * El autor de esta clase es "teacher DAW 1 Mor".
 */
public class ListaArmas {

    // Atributo de la clase ListaArmas
    private ArrayList<Arma> arrayListArmas = new ArrayList();

    /**
     * Método para añadir un arma a la lista.
     * 
     * @param p El arma a añadir.
     */
    public void anadirArma(Arma p) {
        arrayListArmas.add(p);
    }

    /**
     * Método para imprimir la lista de armas.
     */
    public void listarArmas() {
        int contador = 1;
        for (Arma p : arrayListArmas) {
            System.out.println("" + contador + " " + p);
            contador++;
        }
    }

    /**
     * @return El número de armas en la lista.
     */
    public int numeroArmas() {
        return arrayListArmas.size();
    }

    /**
     * @param posicion La posición del arma en la lista.
     * @return El arma en la posición dada.
     */
    public Arma armaPosicion(int posicion) {
        return arrayListArmas.get(posicion);
    }

    /**
     * @return Una representación de cadena de la clase ListaArmas.
     */
    @Override
    public String toString() {
        return "ListaArmas{" + "arrayListArmas=" + arrayListArmas + '}';
    }

    /**
     * @return La suma de los daños de todas las armas en la lista.
     */
    public int sumaDaños() {
        int suma = 0;
        for (Arma p : arrayListArmas) {
            suma += p.getDaño();
        }
        return suma;
    }
}

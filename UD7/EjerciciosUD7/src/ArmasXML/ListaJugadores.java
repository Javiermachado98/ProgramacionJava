package ArmasXML;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase que representa una lista de jugadores.
 * 
 * El autor de esta clase es "teacher DAW 1 Mor".
 */
public class ListaJugadores {

    // Atributo de la clase ListaJugadores
    private ArrayList<Jugador> arrayListJugadores = new ArrayList();

    /**
     * M�todo para a�adir un jugador a la lista.
     * 
     * @param p El jugador a a�adir.
     */
    public void anadirJugador(Jugador p) {
        arrayListJugadores.add(p);
    }

    /**
     * M�todo para imprimir la lista de jugadores.
     */
    public void listarJugadores() {
        int contador = 1;
        for (Jugador p : arrayListJugadores) {
            System.out.println("" + contador + " " + p);
            contador++;
        }
    }

    /**
     * M�todo para mostrar el da�o de cada jugador.
     */
    public void muestraDanioJugadores() {
        Iterator<Jugador> it = arrayListJugadores.iterator();
        while (it.hasNext()) {
            Jugador j = it.next();
            System.out.println("Jugador: " + j.getNombre() + " Da�o: " + j.danio());
        }
    }

    /**
     * @return El n�mero de jugadores en la lista.
     */
    public int numeroJugadores() {
        return arrayListJugadores.size();
    }

    /**
     * @param posicion La posici�n del jugador en la lista.
     * @return El jugador en la posici�n dada.
     */
    public Jugador jugadorPosicion(int posicion) {
        return arrayListJugadores.get(posicion);
    }

    /**
     * M�todo para ordenar la lista de jugadores por experiencia de forma descendente.
     */
    public void ordenaLista() {
        Collections.sort(arrayListJugadores, (p1, p2) -> p2.getExperiencia() - p1.getExperiencia());
    }

    /**
     * M�todo para simular un combate entre dos jugadores seleccionados por el usuario.
     */
    public void combate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona un jugador de la lista: ");
        this.listarJugadores();
        int nJugador = sc.nextInt();
        if (nJugador > 0 && nJugador <= this.numeroJugadores()) {
            System.out.println("Selecciona otro jugador de la lista: ");
            this.listarJugadores();
            int nJugador2 = sc.nextInt();
            if (nJugador2 > 0 && nJugador2 <= this.numeroJugadores()) {
                Jugador j = this.jugadorPosicion(nJugador - 1);
                Jugador j2 = this.jugadorPosicion(nJugador2 - 1);
                j.combate(j2);
            }
        }
    }

    /**
     * M�todo para a�adir un arma a un jugador seleccionado por el usuario desde una lista de armas.
     * 
     * @param miListaArmas La lista de armas disponible.
     */
    public void anadirArmaJugador(ListaArmas miListaArmas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona un jugador de la lista: ");
        this.listarJugadores();
        int nJugador = sc.nextInt();
        if (nJugador > 0 && nJugador <= this.numeroJugadores()) {
            miListaArmas.listarArmas();
            System.out.print("Selecciona un arma de la lista de armas: ");
            int nArma = sc.nextInt();
            if (nArma > 0 && nArma <= miListaArmas.numeroArmas()) {
                Jugador j = this.jugadorPosicion(nJugador - 1);
                Arma a = miListaArmas.armaPosicion(nArma - 1);
                j.anadirArma(a);
            } else {
                System.out.println("N�mero de arma no v�lido.");
            }
        } else {
            System.out.println("N�mero de jugador no v�lido.");
        }
    }
}

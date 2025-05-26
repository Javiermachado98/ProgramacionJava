package MorniteP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaJugadores implements Serializable {

    private ArrayList<JugadorP> ArrayJugadores;

    /// CONSTRUCTOR CON EL ARRAY
    public ListaJugadores() {
        ArrayJugadores = new ArrayList<>();
    }

    /**
     * IMPLEMENTAMOS LOS METOSO PARA GUARDAR Y CARGAR  LA LISTA DE JUGADORES
     */






    /// metodo para agregar a un jugador
    public void agregarJugador() {
        JugadorP j = new JugadorP();
        j.AltaJugador();
        ArrayJugadores.add(j);
        ///la comporbacion no la voy a ahcer por no tenr suficiente tiempo
    }

    public int nJugadores() {
        int nJugadoresT;
        nJugadoresT = ArrayJugadores.size();
        System.out.println("cantidad jugadores:");
        return nJugadoresT;
    }

    /// acceder a un a posicion del jugador//me tiene que devolver a un jugador con su posicion
    public JugadorP JugadorPosicion(int posicion) {
        return ArrayJugadores.get(posicion);


    }

    /// MOSTRAR UGADORES CON SUN NUMERO DE ORDEN EN LA LISTA
    public void mostrarJugadores() {
        if (ArrayJugadores.isEmpty()) {
            System.out.println("no hay jugadores en la lista ");
        } else {
            for (int i = 0; i < ArrayJugadores.size(); i++) {
                System.out.println("jugador " + (i + 1) + ": " + ArrayJugadores.get(i).getNombre());
            }
        }
    }


    /// ordenar la lista descendientemente
    /// METODO COLLECTIONS PARA ORDENADR DESCENDIENTEMENTE
    public void ordenarListaJugadoresPorExperiencia() {
        Collections.sort(ArrayJugadores, (j1, j2) ->
                Integer.compare(j2.getNivelExperiencia(), j1.getNivelExperiencia()));
    }

}

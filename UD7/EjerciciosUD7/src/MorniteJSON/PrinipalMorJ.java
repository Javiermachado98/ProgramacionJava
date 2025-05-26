package MorniteJSON;

import MorniteP.ArmaP;
import MorniteP.JugadorP;
import MorniteP.ListaArmasP;
import MorniteP.ListaJugadores;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class PrinipalMorJ implements Serializable {
    public static final int OPCION_ANADE_ARMA = 1;
    public static final int OPCION_MUESTRA_ARMAS = 2;
    public static final int OPCION_ANADE_JUGADOR = 3;
    public static final int OPCION_MUESTRA_JUGADORES = 4;
    public static final int OPCION_AÑADE_ARMA_JUGADOR = 5;
    public static final int OPCION_MUESTRA_DAÑO_JUGADORES = 6;
    public static final int OPCION_ORDENA_JUGADORES_EXPERIENCIA = 7;
    public static final int OPCION_COMBATE = 8;
    public static final int OPCION_SALIR = 9;

    /// AQUI  INSTANCIAMOS LOS OBJETOS QUE QUEREMOS  GUARDAR  Y USAR EN EOL FUTURO USO DEL PROYECTO


    public static ListaArmasJ ListaJason;
    //PASAMOS LA RUTA DEL ARCHIBVO JSON
    public static String FILE_RUTA = "src" + File.separator + "MorniteJSON" + File.separator + "jason.txt";

    public static void guardarJason() {
        ObjectMapper guardarObjeto = new ObjectMapper();
        try {
            guardarObjeto.writeValue(new File(FILE_RUTA), ListaJason);
            System.out.println("LISTA GUARDAD EN: " + FILE_RUTA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cargarJason() {
        ObjectMapper cargarLista = new ObjectMapper();
        try {
            ListaJason = (ListaArmasJ) cargarLista.readValue(new FileReader(FILE_RUTA), ListaArmasJ.class);
            if (ListaJason == null) {
                ListaJason = new ListaArmasJ();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        //METODO PARA EL GUARDADO DE LA LISTA DE ARMAS


        ///CREAMOS LA INSTANCIA DE DOS ARRAYS AQUI
        ///para el futuro tenlo en cuenta maksm HAY QUE CREAR ESTOS OBJETOS FUERA DEL BUCLE DO-WHILE
        ListaJugadores listPlayerPrincipal = new ListaJugadores();
        ListaJason = new ListaArmasJ();
        cargarJason();


        int opcion;

        //cargamos  la lista de los jugadores y la lista de armas

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("==================================================");
            System.out.println("     MORTNITE ");
            System.out.println("==================================================");
            System.out.println("1.-  Añade arma");
            System.out.println("2.-  Muestra armas");
            System.out.println("3.-  Añade jugador");
            System.out.println("4.-  Muestra jugadores");
            System.out.println("5.-  Añade arma jugador");
            System.out.println("6.-  Muestra daño jugadores");
            System.out.println("7.-  Ordena jugadores experiencia");
            System.out.println("8.-  Combate");
            System.out.println("9.-  Salir");
            System.out.println("==================================================");
            System.out.print("  Introduce una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case OPCION_ANADE_ARMA:
                    ListaJason.anadirArma();
                    break;
                case OPCION_MUESTRA_ARMAS:
                    ListaJason.mostrarArmasOrden();
                    break;
                case OPCION_ANADE_JUGADOR:
                    listPlayerPrincipal.agregarJugador();
                    break;
                case OPCION_MUESTRA_JUGADORES:
                    listPlayerPrincipal.mostrarJugadores();
                    break;
                case OPCION_AÑADE_ARMA_JUGADOR:
                    /**
                     * entiende Maksym , para asignarle algo a un jugador hay que seguir la regla PREGUNTAR-MOSTRAR-ASIGNAR
                     */
                    ///1
                    System.out.println("lista de jugadores");
                    listPlayerPrincipal.mostrarJugadores();
                    ///2 preguntar la posicion del jugaador deseado
                    System.out.print("introduce la posicion del jugador: ");
                    int posicionJugador = sc.nextInt() - 1;
                    ///3 mostrar la lista de todas las armas
                    ListaJason.mostrarArmasOrden();
                    ///4
                    System.out.println("introduce la posicion del arma: ");
                    int posicionArma = sc.nextInt() - 1;
                    ///
                    JugadorP p = listPlayerPrincipal.JugadorPosicion(posicionJugador);
                    ArmaP r = ListaJason.armaPosicion(posicionArma);
                    ///5 FINAL-----anadir arma al jugador
                    p.anadirArma(r);
                    break;
                case OPCION_MUESTRA_DAÑO_JUGADORES:
                    ///mostramos el dano  total de sus armas

                    /// for(int i=0;i<listPlayerPrincipal.nJugadores();i++){
                    ///manera (1)  System.out.println(listPlayerPrincipal.JugadorPosicion(i).sumaDanos());
                    for (int i = 0; i < listPlayerPrincipal.nJugadores(); i++) {
                        //accedemos a distintas posiciones de los jugadores
                        JugadorP j = listPlayerPrincipal.JugadorPosicion(i);
                        if (j != null) {
                            System.out.println("el dano del jugador " + (i + 1) + " Nombre " + j.getNombre() + j.sumaDanos());
                        } else {
                            System.out.println("el jugador de la posicion" + (i) + "no encontrado");
                        }
                    }
                    break;
                case OPCION_ORDENA_JUGADORES_EXPERIENCIA:
                    listPlayerPrincipal.ordenarListaJugadoresPorExperiencia();
                    //mostramos la lista despues de haberla ordenado
                    listPlayerPrincipal.mostrarJugadores();
                    break;
                case OPCION_COMBATE:

                    ///implementacion de la mimsa logiga que en el anadir el arma a un jugador
                    //pide posicion y asignala a un jugador nuevo
                    Scanner sc1 = new Scanner(System.in);
                    //mostramos la lista de los jugadores con su suspuesto orden
                    System.out.println("lista de jugadores");
                    System.out.println("===================================================");
                    listPlayerPrincipal.mostrarJugadores();
                    System.out.print("introduce la posicion del primer jugador: ");
                    int posicionJugador1 = sc1.nextInt() - 1;
                    //lo mismo con el segundo  jugador
                    System.out.print("introduce la posicion del contrincante: ");
                    int posicionContrincante = sc1.nextInt() - 1;
                    ///ALMACENAMOS SUS POSICIONES EN DOS OBJETOS Y LOS PASAMOS AL METODO DE COMBATE
                    JugadorP jugador1 = listPlayerPrincipal.JugadorPosicion(posicionJugador1);
                    JugadorP JugadorContrincante = listPlayerPrincipal.JugadorPosicion(posicionContrincante);
                    ///pasamos a los dos jugadores al metodo del combate
                    jugador1.combate(JugadorContrincante);
                    break;
                case OPCION_SALIR:
                    guardarJason();
                    System.out.println("hasta la proxima ");
            }


        } while (opcion != 9);

    }
}

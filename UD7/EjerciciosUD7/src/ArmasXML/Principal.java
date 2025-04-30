package ArmasXML;
import java.util.Scanner;

/**
 * Clase principal que contiene el menu y la logica principal del programa.
 * 
 * El autor de esta clase es "teacher DAW 1 Mor".
 */
public class Principal {

    // Constantes para las opciones del menu
    public static final int OPCION_ANADE_ARMA = 1;
    public static final int OPCION_MUESTRA_ARMAS = 2;
    public static final int OPCION_ANADE_JUGADOR = 3;
    public static final int OPCION_MUESTRA_JUGADORES = 4;
    public static final int OPCION_ANADE_ARMA_JUGADOR = 5;
    public static final int OPCION_MUESTRA_DANO_JUGADORES = 6;
    public static final int OPCION_ORDENA_JUGADORES_EXPERIENCIA = 7;
    public static final int OPCION_COMBATE = 8;
    public static final int OPCION_SALIR = 9;

    /**
     * Metodo que muestra el menu del programa.
     */
    public static void mostrarMenu() {
        System.out.println("==============================================");
        System.out.println("     MORTNITE ");
        System.out.println("==============================================");
        System.out.println("   1.-  Anade arma");
        System.out.println("   2.-  Muestra armas");
        System.out.println("   3.-  Anade jugador");
        System.out.println("   4.-  Muestra jugadores");
        System.out.println("   5.-  Anade arma jugador");
        System.out.println("   6.-  Muestra dano jugadores");
        System.out.println("   7.-  Ordena jugadores experiencia");
        System.out.println("   8.-  Combate");
        System.out.println("   9.-  Salir");
        System.out.println("==============================================");
        System.out.print("  Introduce una opcion: ");
    }

    /**
     * Metodo principal del programa.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc;
        int opcion;

        // Crear instancias de las listas de armas y jugadores
        ListaArmas miListaArmas = new ListaArmas();
        ListaJugadores miListaJugadores = new ListaJugadores();

        do {
            // Mostrar el men�
            mostrarMenu();

            // Obtener la opcion seleccionada por el usuario
            sc = new Scanner(System.in);
            opcion = sc.nextInt();

            // Realizar acciones segun la opcion seleccionada
            switch (opcion) {
                case OPCION_ANADE_ARMA -> {
                    // Solicita los datos de un arma y la a�ade a la lista de armas                   
                    System.out.println("Alta de arma: ");
                    Arma a = new Arma();
                    a.alta();
                    miListaArmas.anadirArma(a);
                }
                case OPCION_MUESTRA_ARMAS -> {
                    System.out.println("Listado de armas: ");
                    // Muestra todas las armas de la lista de armas
                    miListaArmas.listarArmas();
                }
                case OPCION_ANADE_JUGADOR -> {
                    System.out.println("Alta de jugador: ");
                    // Solicita los datos de un jugador y lo a�ade a la lista de jugadores
                    Jugador j = new Jugador();
                    j.alta();
                    miListaJugadores.anadirJugador(j);
                }
                case OPCION_MUESTRA_JUGADORES -> {
                    System.out.println("Listado de jugadores: ");
                    // Muestra todos los jugadores
                    miListaJugadores.listarJugadores();
                }
                case OPCION_ANADE_ARMA_JUGADOR -> {
                    System.out.println("A�adir un arma a un jugador: ");
                    // Muestra la lista de jugadores y ofrece seleccionar uno
                    // Muestra la lista de armas y ofrece seleccionar una
                    // Anade al jugador seleccionado el arma seleccionada (lo anade a la lista de armas del jugador)
                    miListaJugadores.anadirArmaJugador(miListaArmas);
                }
                case OPCION_MUESTRA_DANO_JUGADORES -> {
                    System.out.println("Muestra dano jugadores");
                    // Muestra todos los jugadores junto con su nivel de dano (suma del dano de sus armas)
                    // SE DEBE USAR UN ITERADOR
                    miListaJugadores.muestraDanioJugadores();
                }
                case OPCION_ORDENA_JUGADORES_EXPERIENCIA -> {
                    System.out.println("Jugadores ordenados por experiencia: ");
                    // Ordena todos los jugadores de la lista segun su experiencia de forma decreciente
                    miListaJugadores.ordenaLista();
                    miListaJugadores.listarJugadores();
                }
                case OPCION_COMBATE -> {
                    System.out.println("Combate entre dos jugadores: ");
                    // Permite seleccionar dos jugadores de la lista de jugadores y los somete a un combate.                    
                    // Anade al jugador seleccionado el arma seleccionada (lo anade a la lista de armas del jugador)
                    miListaJugadores.combate();
                }
                case OPCION_SALIR -> {
                    // Mensaje de despedida al salir del programa
                    System.out.println("Fin del programa. Espero que te haya gustado MORTNITE");
                }
                default -> {
                    // Mensaje de error si la opcion ingresada no es valida
                    System.out.println("Introduce una opcion valida");
                }
            }

        } while (opcion != OPCION_SALIR);

    }

}

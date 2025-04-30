package ArmasXML;
import java.util.Scanner;

/**
 * Clase que representa a un jugador.
 * 
 * El autor de esta clase es "teacher DAW 1 Mor".
 */
public class Jugador {

    // Constantes de la clase Jugador
    private static final int VIDA_INICIAL = 100;
    private static final int MIN_EXPERIENCIA = 1;
    private static final int MAX_EXPERIENCIA = 5;
    private static final int RESTA_VIDA = 20;

    // Atributos de la clase Jugador
    private String nombre;
    private int experiencia;
    private String estilo;
    private int vida = VIDA_INICIAL;
    private ListaArmas listaArmasJugador = new ListaArmas();

    /**
     * M�todo para ingresar informaci�n sobre el jugador.
     */
    public void alta() {
        Scanner sc = new Scanner(System.in);

        // Solicitar y establecer el nombre del jugador.
        System.out.print("Introduce un nombre: ");
        this.nombre = sc.next();

        // Solicitar y establecer el estilo del jugador.
        System.out.print("Introduce un estilo: ");
        this.estilo = sc.next();

        // Solicitar y establecer la experiencia del jugador.
        System.out.print("Introduce una experiencia (n�mero entre 1 y 5): ");
        this.experiencia = sc.nextInt();

        // Validar que la experiencia est� en el rango correcto.
        while (this.experiencia < MIN_EXPERIENCIA || this.experiencia > MAX_EXPERIENCIA) {
            System.out.print("Introduce un valor para experiencia valido (numero entre 1 y 5): ");
            this.experiencia = sc.nextInt();
        }

        // Establecer la vida inicial del jugador.
        this.vida = VIDA_INICIAL;

    }

    /**
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return La experiencia del jugador.
     */
    public int getExperiencia() {
        return this.experiencia;
    }

    /**
     * @return Una representacion de cadena de la clase Jugador.
     */
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", experiencia=" + experiencia + ", estilo=" + estilo + ", vida=" + vida
                + ", listaArmasJugador=" + listaArmasJugador + '}';
    }

    /**
     * M�todo para a�adir un arma a la lista de armas del jugador.
     * 
     * @param a El arma a a�adir.
     */
    public void anadirArma(Arma a) {
        listaArmasJugador.anadirArma(a);
    }

    /**
     * @return La suma de los da�os de las armas del jugador.
     */
    public int danio() {
        return listaArmasJugador.sumaDanios();
    }

    /**
     * M�todo para reducir la vida del jugador.
     * 
     * @param valor La cantidad de vida a restar.
     */
    public void restaVida(int valor) {
        this.vida = this.vida - valor;
    }

    /**
     * M�todo para simular un combate entre dos jugadores.
     * 
     * @param contrincante El jugador contra el que se va a combatir.
     */
    public void combate(Jugador contrincante) {
        if (this.danio() > contrincante.danio()) {
            contrincante.restaVida(RESTA_VIDA);
            System.out.println("Ha ganado " + this.nombre);
        } else if (this.danio() < contrincante.danio()) {
            this.restaVida(RESTA_VIDA);
            System.out.println("Ha ganado " + contrincante.nombre);
        } else {
            System.out.println("Han empatado");
        }
    }
}

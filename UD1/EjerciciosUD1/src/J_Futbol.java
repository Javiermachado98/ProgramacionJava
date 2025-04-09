package EjerciciosUD1;
import java.util.Scanner;

public class J_Futbol {
    public static void main(String[] args) {

        int numeroPartidosGanados, numeroPartidosPerdidos, numeroPartidosEmpatados, totalPuntos, bonoPorJugador;

        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el numero de partidos ganados: ");
        numeroPartidosGanados = sc.nextInt();
        System.out.println("Ingrese el numero de partidos empatados: ");
        numeroPartidosEmpatados = sc.nextInt();
        System.out.println("Ingrese el numero de partidos perdidos: ");
        numeroPartidosPerdidos = sc.nextInt();

        totalPuntos = (numeroPartidosGanados * 3 ) + numeroPartidosEmpatados;
        System.out.println("Numero total de puntos actualmente en la liga: " + totalPuntos);

        bonoPorJugador = ((numeroPartidosGanados * 150) + (numeroPartidosEmpatados * 50)) - (numeroPartidosPerdidos * 75);
        bonoPorJugador = Math.max(0, bonoPorJugador);
        System.out.println("Valor total del bonus para el jugador: " + bonoPorJugador);

    }
}




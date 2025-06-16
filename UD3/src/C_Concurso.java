import java.util.Scanner;

public class C_Concurso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int concursantes = 10;
        int rondas = 6;
        int[] puntos = new int[concursantes]; // Array para guardar puntos de los concursantes
        // Inicialmente todos con 0 puntos (por defecto en Java)

        boolean salir = false;

        while (!salir) {
            // Mostrar menú
            System.out.println("\n--- MENÚ CONCURSO ---");
            System.out.println("1. Añadir puntos a un concursante");
            System.out.println("2. Mostrar puntos de todos los concursantes");
            System.out.println("3. Penalizar a un concursante (-5 puntos)");
            System.out.println("4. Mostrar concursante ganador");
            System.out.println("5. Mostrar podio (3 mejores)");
            System.out.println("6. Robo de puntos entre concursantes");
            System.out.println("7. Salir");
            System.out.print("Elige opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Añadir puntos
                    System.out.print("Número de concursante (1-10): ");
                    int numConc1 = sc.nextInt();
                    if (numConc1 < 1 || numConc1 > concursantes) {
                        System.out.println("Número inválido.");
                        break;
                    }
                    System.out.print("Puntos a añadir (7-12): ");
                    int puntosAñadir = sc.nextInt();
                    if (puntosAñadir < 7 || puntosAñadir > 12) {
                        System.out.println("Puntos fuera de rango.");
                        break;
                    }
                    puntos[numConc1 - 1] += puntosAñadir;
                    System.out.println("Puntos añadidos correctamente.");
                    break;

                case 2:
                    // Mostrar puntos
                    System.out.println("Puntos actuales de los concursantes:");
                    for (int i = 0; i < concursantes; i++) {
                        System.out.println("Concursante " + (i + 1) + ": " + puntos[i]);
                    }
                    break;

                case 3:
                    // Penalizar concursante
                    System.out.print("Número de concursante a penalizar (1-10): ");
                    int numConcPenal = sc.nextInt();
                    if (numConcPenal < 1 || numConcPenal > concursantes) {
                        System.out.println("Número inválido.");
                        break;
                    }
                    puntos[numConcPenal - 1] -= 5;
                    System.out.println("Concursante penalizado con -5 puntos.");
                    break;

                case 4:
                    // Mostrar ganador
                    int maxPuntos = puntos[0];
                    int ganador = 1;
                    for (int i = 1; i < concursantes; i++) {
                        if (puntos[i] > maxPuntos) {
                            maxPuntos = puntos[i];
                            ganador = i + 1;
                        }
                    }
                    System.out.println("El ganador es el concursante " + ganador + " con " + maxPuntos + " puntos.");
                    break;

                case 5:
                    // Mostrar podio (3 mejores)
                    // Copiar puntos en array auxiliar para ordenar
                    int[] puntosAux = new int[concursantes];
                    int[] indices = new int[concursantes];
                    for (int i = 0; i < concursantes; i++) {
                        puntosAux[i] = puntos[i];
                        indices[i] = i;
                    }
                    // Ordenar puntosAux y mantener indices con burbuja (porque no se usa Arrays.sort para mantener estilo)
                    for (int i = 0; i < concursantes - 1; i++) {
                        for (int j = 0; j < concursantes - 1 - i; j++) {
                            if (puntosAux[j] < puntosAux[j + 1]) {
                                int temp = puntosAux[j];
                                puntosAux[j] = puntosAux[j + 1];
                                puntosAux[j + 1] = temp;

                                int tempIdx = indices[j];
                                indices[j] = indices[j + 1];
                                indices[j + 1] = tempIdx;
                            }
                        }
                    }
                    System.out.println("Podio (3 mejores concursantes):");
                    for (int i = 0; i < 3; i++) {
                        System.out.println((i + 1) + "º: Concursante " + (indices[i] + 1) + " con " + puntosAux[i] + " puntos");
                    }
                    break;

                case 6:
                    // Robo de puntos
                    System.out.print("Número de concursante que roba (1-10): ");
                    int roba = sc.nextInt();
                    System.out.print("Número de concursante a robar (1-10): ");
                    int robado = sc.nextInt();
                    System.out.print("Número de puntos a robar: ");
                    int puntosRobar = sc.nextInt();

                    // Validaciones
                    if (roba < 1 || roba > concursantes || robado < 1 || robado > concursantes) {
                        System.out.println("Número de concursantes inválidos.");
                        break;
                    }
                    if (puntosRobar <= 0) {
                        System.out.println("Puntos a robar deben ser positivos.");
                        break;
                    }
                    if (puntos[robado - 1] < puntosRobar) {
                        System.out.println("El concursante a robar no tiene suficientes puntos.");
                        break;
                    }
                    // Realizar robo
                    puntos[robado - 1] -= puntosRobar;
                    puntos[roba - 1] += puntosRobar;
                    System.out.println("Robo realizado correctamente.");
                    break;

                case 7:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        sc.close();
    }
}

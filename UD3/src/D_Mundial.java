/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d_mundial;

import java.util.Scanner;

public class D_Mundial {
    // Constantes para las opciones del menú
    public static final int OPCION_INTRODUCIR_RESULTADO = 1;
    public static final int OPCION_MOSTRAR_TABLA = 2;
    public static final int OPCION_PRIMERO_GRUPO = 3;
    public static final int OPCION_ESTADISTICAS = 4;
    public static final int OPCION_SALIR = 5;
    
    // Scanner con codificación ISO-8859-1 para caracteres especiales
    public static Scanner sc = new Scanner(System.in, "ISO-8859-1");
    
    // Nombres de los equipos del grupo
    public static final String[] EQUIPOS = {"España", "Japón", "Alemania", "CostaRica"};
    public static final int NUM_EQUIPOS = 4;
    
    // Estructura para almacenar los datos de cada equipo
    // [0] Puntos, [1] PJ, [2] PG, [3] PP, [4] PE, [5] GF, [6] GC, [7] GD
    public static int[][] datosEquipos = new int[NUM_EQUIPOS][8];
    
    public static void main(String[] args) {
        inicializarDatos();
        int opcion;
        
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            
            switch(opcion) {
                case OPCION_INTRODUCIR_RESULTADO:
                    introducirResultado();
                    break;
                case OPCION_MOSTRAR_TABLA:
                    mostrarTabla();
                    break;
                case OPCION_PRIMERO_GRUPO:
                    mostrarPrimeroGrupo();
                    break;
                case OPCION_ESTADISTICAS:
                    mostrarEstadisticas();
                    break;
                case OPCION_SALIR:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != OPCION_SALIR);
    }
    
    public static void mostrarMenu() {
        System.out.println("\n==================================================");
        System.out.println(" Gestión de Grupo Mundial  ");
        System.out.println("==================================================");
        System.out.println("1.- Introducir resultado de un partido");
        System.out.println("2.- Mostrar tabla del grupo");
        System.out.println("3.- Primero de grupo");
        System.out.println("4.- Estadísticas");
        System.out.println("5.- Salir");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }
    
    public static void inicializarDatos() {
        // Inicializar todos los datos a 0
        for(int i = 0; i < NUM_EQUIPOS; i++) {
            for(int j = 0; j < 8; j++) {
                datosEquipos[i][j] = 0;
            }
        }
    }
    
    public static void introducirResultado() {
        System.out.println("\nIntroduce el nombre del primer equipo:");
        String equipo1 = sc.nextLine();
        System.out.println("Introduce los goles del primer equipo:");
        int goles1 = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        
        System.out.println("Introduce el nombre del segundo equipo:");
        String equipo2 = sc.nextLine();
        System.out.println("Introduce los goles del segundo equipo:");
        int goles2 = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        
        // Validar equipos
        int index1 = -1, index2 = -1;
        for(int i = 0; i < NUM_EQUIPOS; i++) {
            if(EQUIPOS[i].equalsIgnoreCase(equipo1)) index1 = i;
            if(EQUIPOS[i].equalsIgnoreCase(equipo2)) index2 = i;
        }
        
        if(index1 == -1 || index2 == -1) {
            System.out.println("Error: Uno o ambos equipos no pertenecen al grupo.");
            return;
        }
        
        if(goles1 < 0 || goles2 < 0) {
            System.out.println("Error: Los goles deben ser números positivos.");
            return;
        }
        
        if(index1 == index2) {
            System.out.println("Error: Un equipo no puede jugar contra sí mismo.");
            return;
        }
        
        // Actualizar datos de los equipos
        actualizarDatosPartido(index1, index2, goles1, goles2);
        System.out.println("Resultado registrado correctamente.");
    }
    
    public static void actualizarDatosPartido(int index1, int index2, int goles1, int goles2) {
        // Incrementar partidos jugados para ambos equipos
        datosEquipos[index1][1]++;
        datosEquipos[index2][1]++;
        
        // Actualizar goles a favor y en contra
        datosEquipos[index1][5] += goles1;
        datosEquipos[index1][6] += goles2;
        datosEquipos[index2][5] += goles2;
        datosEquipos[index2][6] += goles1;
        
        // Calcular diferencia de goles
        datosEquipos[index1][7] = datosEquipos[index1][5] - datosEquipos[index1][6];
        datosEquipos[index2][7] = datosEquipos[index2][5] - datosEquipos[index2][6];
        
        // Determinar resultado del partido
        if(goles1 > goles2) {
            // Equipo 1 gana
            datosEquipos[index1][2]++; // PG equipo1
            datosEquipos[index2][3]++; // PP equipo2
            datosEquipos[index1][0] += 3; // Puntos equipo1
        } else if(goles2 > goles1) {
            // Equipo 2 gana
            datosEquipos[index2][2]++; // PG equipo2
            datosEquipos[index1][3]++; // PP equipo1
            datosEquipos[index2][0] += 3; // Puntos equipo2
        } else {
            // Empate
            datosEquipos[index1][4]++; // PE equipo1
            datosEquipos[index2][4]++; // PE equipo2
            datosEquipos[index1][0] += 1; // Puntos equipo1
            datosEquipos[index2][0] += 1; // Puntos equipo2
        }
    }
    
    public static void mostrarTabla() {
        System.out.println("\n====================================================");
        System.out.println("PAIS      | P | PJ | PG | PP | PE | GF | GC | GD |");
        System.out.println("====================================================");
        
        for(int i = 0; i < NUM_EQUIPOS; i++) {
            System.out.printf("%-9s | %d | %2d | %2d | %2d | %2d | %2d | %2d | %2d |\n",
                EQUIPOS[i],
                datosEquipos[i][0], // Puntos
                datosEquipos[i][1], // PJ
                datosEquipos[i][2], // PG
                datosEquipos[i][3], // PP
                datosEquipos[i][4], // PE
                datosEquipos[i][5], // GF
                datosEquipos[i][6], // GC
                datosEquipos[i][7]  // GD
            );
        }
        
        System.out.println("====================================================");
    }
    
    public static void mostrarPrimeroGrupo() {
        int maxPuntos = -1;
        int indicePrimero = 0;
        
        for(int i = 0; i < NUM_EQUIPOS; i++) {
            if(datosEquipos[i][0] > maxPuntos) {
                maxPuntos = datosEquipos[i][0];
                indicePrimero = i;
            }
        }
        
        System.out.println("\nEl primero del grupo es: " + EQUIPOS[indicePrimero] + 
                         " con " + maxPuntos + " puntos.");
    }
    
    public static void mostrarEstadisticas() {
        int totalPartidos = 0;
        int totalGoles = 0;
        
        for(int i = 0; i < NUM_EQUIPOS; i++) {
            totalPartidos += datosEquipos[i][1];
            totalGoles += datosEquipos[i][5];
        }
        
        if(totalPartidos == 0) {
            System.out.println("\nNo se han jugado partidos todavía.");
            return;
        }
        
        double mediaGoles = (double)totalGoles / totalPartidos;
        System.out.printf("\nEstadísticas del grupo:\n");
        System.out.printf("Total partidos jugados: %d\n", totalPartidos);
        System.out.printf("Total goles marcados: %d\n", totalGoles);
        System.out.printf("Media de goles por partido: %.2f\n", mediaGoles);
    }
}
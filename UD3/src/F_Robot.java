/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_robot;

/**
 *
 * @author cartu
 */
import java.util.Scanner;

public class F_Robot {
    // Constantes para el tablero
    public static final int FILAS = 8;
    public static final int COLUMNAS = 8;
    public static final char LIBRE = '.';
    public static final char OBSTACULO = 'O';
    public static final char TORNILLO = 'T';
    public static final char ROBOT = 'R';
    
    // Scanner para entrada de usuario
    public static Scanner sc = new Scanner(System.in);
    
    // Posiciones iniciales
    public static int robotFila = 0;
    public static int robotColumna = 0;
    public static int tornilloFila = 7;
    public static int tornilloColumna = 7;
    
    // Tablero de juego
    public static char[][] tablero = new char[FILAS][COLUMNAS];
    
    public static void main(String[] args) {
        inicializarTablero();
        boolean juegoTerminado = false;
        
        System.out.println("¡BIENVENIDO AL JUEGO DEL ROBOT BUSCADOR!");
        System.out.println("Objetivo: Llevar el robot (R) al tornillo (T)");
        System.out.println("Obstáculos: (O) - No puedes pasar por ellos");
        System.out.println("Movimientos: W (Arriba), S (Abajo), A (Izquierda), D (Derecha)");
        
        while(!juegoTerminado) {
            dibujarTablero();
            System.out.print("Introduce movimiento (W/A/S/D): ");
            char movimiento = sc.next().toUpperCase().charAt(0);
            
            switch(movimiento) {
                case 'W':
                    juegoTerminado = moverRobot(-1, 0);
                    break;
                case 'S':
                    juegoTerminado = moverRobot(1, 0);
                    break;
                case 'A':
                    juegoTerminado = moverRobot(0, -1);
                    break;
                case 'D':
                    juegoTerminado = moverRobot(0, 1);
                    break;
                default:
                    System.out.println("Movimiento no válido. Usa W, A, S o D.");
            }
            
            if(juegoTerminado) {
                dibujarTablero();
                System.out.println("¡FELICIDADES! Has encontrado el tornillo.");
            }
        }
    }
    
    public static void inicializarTablero() {
        // Inicializar todo el tablero como libre
        for(int i = 0; i < FILAS; i++) {
            for(int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = LIBRE;
            }
        }
        
        // Colocar 8 obstáculos en posiciones fijas
        tablero[1][2] = OBSTACULO;
        tablero[2][5] = OBSTACULO;
        tablero[3][1] = OBSTACULO;
        tablero[3][6] = OBSTACULO;
        tablero[4][3] = OBSTACULO;
        tablero[5][0] = OBSTACULO;
        tablero[6][4] = OBSTACULO;
        tablero[7][2] = OBSTACULO;
        
        // Colocar el tornillo en posición fija
        tablero[tornilloFila][tornilloColumna] = TORNILLO;
        
        // Colocar el robot en la posición inicial
        tablero[robotFila][robotColumna] = ROBOT;
    }
    
    public static void dibujarTablero() {
        System.out.println("\n  TABLERO DEL JUEGO");
        System.out.print("  ");
        for(int j = 0; j < COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        
        for(int i = 0; i < FILAS; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean moverRobot(int deltaFila, int deltaColumna) {
        int nuevaFila = robotFila + deltaFila;
        int nuevaColumna = robotColumna + deltaColumna;
        
        // Verificar límites del tablero
        if(nuevaFila < 0 || nuevaFila >= FILAS || nuevaColumna < 0 || nuevaColumna >= COLUMNAS) {
            System.out.println("¡No puedes salir del tablero!");
            return false;
        }
        
        // Verificar obstáculos
        if(tablero[nuevaFila][nuevaColumna] == OBSTACULO) {
            System.out.println("¡Hay un obstáculo en ese camino!");
            return false;
        }
        
        // Verificar si encontramos el tornillo
        if(tablero[nuevaFila][nuevaColumna] == TORNILLO) {
            // Actualizar posición del robot
            tablero[robotFila][robotColumna] = LIBRE;
            robotFila = nuevaFila;
            robotColumna = nuevaColumna;
            tablero[robotFila][robotColumna] = ROBOT;
            return true;
        }
        
        // Mover el robot
        tablero[robotFila][robotColumna] = LIBRE;
        robotFila = nuevaFila;
        robotColumna = nuevaColumna;
        tablero[robotFila][robotColumna] = ROBOT;
        
        return false;
    }
}
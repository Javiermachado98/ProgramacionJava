/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e_robot;

import java.util.Scanner;

public class E_Robot {
    // Constantes para el tamaño del tablero
    public static final int FILAS = 8;
    public static final int COLUMNAS = 8;
    
    // Símbolos para representar el tablero
    public static final char CASILLA_VACIA = '·';
    public static final char ROBOT = 'R';
    public static final char BORDE_HORIZONTAL = '-';
    public static final char BORDE_VERTICAL = '|';
    public static final char ESQUINA = '+';
    
    // Scanner para entrada de usuario
    public static Scanner sc = new Scanner(System.in);
    
    // Posición y estado del robot
    public static int posX = 0;
    public static int posY = 0;
    public static int distanciaRecorrida = 0;
    
    public static void main(String[] args) {
        System.out.println("SIMULADOR DE MOVIMIENTO DE ROBOT");
        System.out.println("Instrucciones:");
        System.out.println("N - Mover Norte | S - Mover Sur");
        System.out.println("E - Mover Este  | O - Mover Oeste");
        System.out.println("F - Finalizar programa\n");
        
        boolean finalizado = false;
        
        do {
            dibujarTablero();
            mostrarEstado();
            System.out.print("Introduce movimiento (N/S/E/O/F): ");
            char movimiento = sc.next().toUpperCase().charAt(0);
            
            switch(movimiento) {
                case 'N':
                    moverRobot(0, -1);
                    break;
                case 'S':
                    moverRobot(0, 1);
                    break;
                case 'E':
                    moverRobot(1, 0);
                    break;
                case 'O':
                    moverRobot(-1, 0);
                    break;
                case 'F':
                    finalizado = true;
                    break;
                default:
                    System.out.println("¡Movimiento no válido! Use N, S, E, O o F.");
            }
            
        } while(!finalizado);
        
        System.out.println("\n--- PROGRAMA FINALIZADO ---");
        dibujarTablero();
        mostrarEstado();
    }
    
    public static void moverRobot(int deltaX, int deltaY) {
        int nuevaX = posX + deltaX;
        int nuevaY = posY + deltaY;
        
        if(nuevaX >= 0 && nuevaX < COLUMNAS && nuevaY >= 0 && nuevaY < FILAS) {
            posX = nuevaX;
            posY = nuevaY;
            distanciaRecorrida++;
        } else {
            System.out.println("¡Movimiento inválido! No puedes salir del tablero.");
        }
    }
    
    public static void dibujarTablero() {
        // Dibujar encabezado con coordenadas
        System.out.print("  ");
        for (int x = 0; x < COLUMNAS; x++) {
            System.out.print(" " + x + " ");
        }
        System.out.println();
        
        // Dibujar borde superior
        System.out.print("  " + ESQUINA);
        for (int x = 0; x < COLUMNAS; x++) {
            System.out.print("" + BORDE_HORIZONTAL + BORDE_HORIZONTAL + BORDE_HORIZONTAL + ESQUINA);
        }
        System.out.println();
        
        // Dibujar filas
        for (int y = 0; y < FILAS; y++) {
            System.out.print(y + " " + BORDE_VERTICAL);
            for (int x = 0; x < COLUMNAS; x++) {
                if (x == posX && y == posY) {
                    System.out.print(" " + ROBOT + " ");
                } else {
                    System.out.print(" " + CASILLA_VACIA + " ");
                }
                System.out.print(BORDE_VERTICAL);
            }
            System.out.println();
            
            // Dibujar líneas horizontales entre filas
            System.out.print("  " + ESQUINA);
            for (int x = 0; x < COLUMNAS; x++) {
                System.out.print("" + BORDE_HORIZONTAL + BORDE_HORIZONTAL + BORDE_HORIZONTAL + ESQUINA);
            }
            System.out.println();
        }
    }
    
    public static void mostrarEstado() {
        System.out.printf("\nPosición actual: (%d, %d)\n", posX, posY);
        System.out.printf("Distancia recorrida: %d metros\n\n", distanciaRecorrida);
    }
}
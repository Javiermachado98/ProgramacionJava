import java.util.Scanner;

public class B_OperacionesVectores {

    public static void main(String[] args) {
        // Inicializamos el vector con los valores dados
        int[] vector = {50, 30, 5, 9, 15, 21, 14, 35, 3, 10};

        System.out.println("Vector original:");
        mostrarVector(vector);

        // 1.- Mostrar elementos múltiplos de 3
        System.out.println("\nElementos múltiplos de 3:");
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 3 == 0) {
                System.out.print(vector[i] + " ");
            }
        }

        // 2.- Mostrar elementos en posiciones impares
        System.out.println("\n\nElementos en posiciones impares:");
        for (int i = 1; i < vector.length; i += 2) {
            System.out.print(vector[i] + " ");
        }

        // 3.- Sumar elementos mayores que 20
        int sumaMayores20 = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > 20) {
                sumaMayores20 += vector[i];
            }
        }
        System.out.println("\n\nSuma de elementos mayores que 20: " + sumaMayores20);

        // 4.- Valor mínimo y posición
        int minValor = vector[0];
        int posMin = 0;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < minValor) {
                minValor = vector[i];
                posMin = i;
            }
        }
        System.out.println("\nValor mínimo: " + minValor + ", posición: " + posMin);

        // 5.- Vector nuevo con suma acumulada
        int[] vectorAcumulado = new int[vector.length];
        int sumaParcial = 0;
        for (int i = 0; i < vector.length; i++) {
            sumaParcial += vector[i];
            vectorAcumulado[i] = sumaParcial;
        }

        System.out.println("\nVector acumulado (posición i = suma de 0..i):");
        mostrarVector(vectorAcumulado);
    }

    // Método auxiliar para mostrar el vector en línea
    public static void mostrarVector(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }
        System.out.println();
    }
}

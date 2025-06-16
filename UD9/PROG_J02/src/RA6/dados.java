package RA6;

import java.util.Arrays;
import java.util.Random;

public class dados {


    public static void rellanarNotas(int[] arreglo) {
        int numerosNotas = 10;
        int repetidoMayor = 0;
        int mayor = 0;
        int repetidoMenor = 100;
        int menor = 0;

        for (int contadorVeces = 0; contadorVeces < 100; contadorVeces++) {

            Random myrandom = new Random();
            int numeroRandom = myrandom.nextInt(1, 11);
            arreglo[numeroRandom - 1] += 1;

        }

        for (int contador = 0; contador < numerosNotas; contador++) {
            if (arreglo[contador] > repetidoMayor) {
                repetidoMayor = arreglo[contador];
            }

            if (arreglo[contador] < repetidoMenor) {
                repetidoMenor = arreglo[contador];
            }
        }
        for (int contadorFrecuencia = 0; contadorFrecuencia < numerosNotas; contadorFrecuencia++) {
            if (arreglo[contadorFrecuencia] == repetidoMayor) {
                System.out.println("El numero con mas apariciones es: " + (contadorFrecuencia + 1) + " con " + repetidoMayor + " apariciones");
            }
            if (arreglo[contadorFrecuencia] == repetidoMenor){
                System.out.println("El numero con menos apariciones es: " + (contadorFrecuencia + 1) + " con " + repetidoMenor + " apariciones");
            }
        }

        System.out.println(Arrays.toString(arreglo));

    }

    public static void main(String[] args) {
        int cantidad = 10;

        int[] misNotas = new int[cantidad];
        rellanarNotas(misNotas);


    }


}






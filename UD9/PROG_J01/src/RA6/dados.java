package RA6;

import java.util.Arrays;
import java.util.Random;

public class dados {


    public static void rellanarNotas(int[] arreglo) {
        int numerosNotas = 10;
        int repetido = 0;
        int numRepetido = 0;
        int numNoRepetido = 100;
        int mayor = 0;



        for (int contadorVeces = 0; contadorVeces < 100; contadorVeces++){

            Random myrandom = new Random();
            int numeroRandom = myrandom.nextInt(1, 11);
            arreglo[numeroRandom - 1]+=1;

        }

        for (int contador = 0; contador < numerosNotas; contador++){
            if (arreglo[contador] > repetido){
                repetido = arreglo[contador];
                numRepetido = contador + 1;
            }

            if (arreglo[contador] < numNoRepetido){
                numNoRepetido = arreglo[contador];
            }
        }

        System.out.println("El numero con mas apariciones es: " + numRepetido + " con " + repetido + " apariciones");
        System.out.println("El numero con menos apariciones es: " + numNoRepetido + " con " + numNoRepetido + " apariciones");

        System.out.println(Arrays.toString(arreglo));

    }

    public static void main(String[] args) {
        int cantidad = 10;

        int [] misNotas = new int[cantidad];
        rellanarNotas(misNotas);



    }


}






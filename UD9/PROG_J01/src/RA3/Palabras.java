package RA3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Palabras {
    public static void main(String[] args) {


        String palabra;
        int valorSumatoria = 0;

        do {
            valorSumatoria = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("ingrese la palabra: ");
            palabra = sc.next();


            for (int recorrer = 0; recorrer < palabra.length(); recorrer++) {
                palabra = palabra.toUpperCase();
                int valor = palabra.charAt(recorrer);
                int valorChar = valor - 'A' + 1;

                valorSumatoria = valorSumatoria + valorChar;

            }
            if (valorSumatoria != 100) {
                System.out.println("La palabra " + palabra + " suma un total de : " + valorSumatoria);
                System.out.println("Debes lograr una palabra de 100");
            }

        } while (valorSumatoria != 100);

        System.out.println("La palabra " + palabra + " tiene un puntaje de " + valorSumatoria);
    }
}

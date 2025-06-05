package RA3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class sralobo {
    public static void main(String[] args) {
        int numero;
        int suma = 0;
        String[] palabras2 = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
        Scanner sc = new Scanner(System.in);

        while (suma <= 15) {
            System.out.println();
            System.out.println("Ingrese un numero del 1 al 10: ");
            numero = sc.nextInt();

            if (numero >= 1 && numero <= 10) {
                for (int i = 0; i < numero; i++) {
                    System.out.print(palabras2[i] + " ");
                }
                suma = suma + numero;

                if (suma > 15){
                    System.out.println();
                    System.out.println("Es la hora de merendar");
                }
            }else {
                System.out.println("Numero incorrecto, debe ser entre el 1 y el 10");
            }

        }
    }
}
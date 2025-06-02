package RA3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class sralobo {
    public static void main(String[] args) {
        int numero;
        int contadorFinal = 0;
        int contadorNumeros = 0;
        boolean salir = false;


        do {

            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el un numero del 1 al 10");
            numero = sc.nextInt();

            if (numero >= 1 && numero <= 10){

                if (numero == 1){
                    System.out.println("uno");
                    contadorFinal = 1;

                }else if (numero == 2){
                    System.out.println("uno dos");
                    contadorFinal = 2;

                }else if (numero == 3){
                    System.out.println("uno dos tres");
                    contadorFinal = 3;

                }else if (numero == 4){
                    System.out.println("uno dos tres cuatro");
                    contadorFinal = 4;

                }else if (numero == 5){
                    System.out.println("uno dos tres cuatro cinco");
                    contadorFinal = 5;

                }else if (numero == 6){
                    System.out.println("uno dos uno dos tres cuatro cinco seis");
                    contadorFinal = 6;

                }else if (numero == 7){
                    System.out.println("uno dos uno dos tres cuatro cinco seis siete");
                    contadorFinal = 7;

                }else if (numero == 8){
                    System.out.println("uno dos uno dos tres cuatro cinco seis siete ocho");
                    contadorFinal = 8;

                }else if (numero == 9){
                    System.out.println("uno dos uno dos tres cuatro cinco seis siete ocho nueve");
                    contadorFinal = 9;

                }else if (numero == 10){
                    System.out.println("uno dos uno dos tres cuatro cinco seis siete ocho nueve diez");
                    contadorFinal = 10;
                }

                contadorNumeros = contadorNumeros + contadorFinal;
                if (contadorNumeros == 15){
                    salir = true;
                    System.out.println("Es la hora de merendar");
                }

            }else {
                System.out.println("El numero" + numero + " no es valido, ingrese otro numero: ");
            }


        } while (salir != true);


    }
}

//- el ordenador solicitará un número al usuario (el número de pasos). Ese número de pasos
//deberá ser un número entre 1 y 10, si no cumple ese rango, el ordenador le dirá que no es
//correcto. Si cumple ese rango, el ordenador escribirá en letra los números correspondientes al
//número de pasos que debe dar el usuario (por ejemplo, si el usuario dice el tres, el ordenador
//escribirá uno dos tres
//- el ordenador llevará la cuenta del número de pasos que ha introducido el usuario hasta el
//momento. En el momento que el número de pasos sea superior a 15, el ordenador dirá “Es la
//hora de merendar” y finalizará el juego.
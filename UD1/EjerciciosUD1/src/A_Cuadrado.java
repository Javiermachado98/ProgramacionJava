package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class A_Cuadrado {
    public static void main(String[] args) {

        int numero;
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese un numero: ");
        numero = sc.nextInt();
        System.out.println("numero impreso: " + numero);

        int numerofinal = (numero*numero);
        System.out.println("El numero: " + numero + " Multiplicado por si mismo es: " + numerofinal);

    }
}


//Realizar un programa que solicite al usuario un número y le devuelva el cuadrado del mismo (el número multiplicado por sí mismo)
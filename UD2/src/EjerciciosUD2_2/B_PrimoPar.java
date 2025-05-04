package EjerciciosUD2_2;
import java.util.Scanner;

public class B_PrimoPar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = sc.nextInt();

        if (numero / numero == 1 && numero % numero == 0){
            System.out.println("prueba");
        }

        if (esPrimo(numero)) {
            System.out.println("El número " + numero + " es primo.");
        } else {
            System.out.println("El número " + numero + " no es primo.");
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; // Números menores o iguales a 1 no son primos
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Si es divisible por otro número, no es primo
            }
        }

        return true; // Si no fue divisible por ningún número, es primo
    }
}


//Repetir el ejercicio primopar de las actividades previas pero con una función que se llame esPrimo
//que reciba un número como parámetro y devuelva un
//valor booleano que indique si un número es primo o no.
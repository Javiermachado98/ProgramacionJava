package EjerciciosUD2;

import java.util.Locale;
import java.util.Scanner;

public class J_Factorial {

    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Digite el número por favor: ");
        numero = sc.nextInt();

        int sumatoria = 1;
        for (int numeroSumatorio = 1; numeroSumatorio <= numero; numeroSumatorio++) {
            sumatoria = sumatoria * numeroSumatorio;
        }

        System.out.println("La multiplicacion de todos los números hasta " + numero + " es: " + sumatoria);
    }

}

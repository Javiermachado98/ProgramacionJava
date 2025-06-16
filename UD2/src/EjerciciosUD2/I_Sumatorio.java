package EjerciciosUD2;

import java.util.Scanner;
import java.util.Locale;

public class I_Sumatorio {

    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Digite el número por favor: ");
        numero = sc.nextInt();

        int sumatoria = 0;
        for (int numeroSumatorio = 1; numeroSumatorio <= numero; numeroSumatorio++) {
            sumatoria = sumatoria + numeroSumatorio;
        }

        System.out.println("La suma de todos los números hasta " + numero + " es: " + sumatoria);
    }
}

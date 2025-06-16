package EjerciciosUD2;

import java.util.Scanner;
import java.util.Locale;

public class K_Contadores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double consumo;
        double mayorConsumo = 0; // igualo a 0 para partir de ahi importante
        int viviendaMayorConsumo = 0;

        System.out.println("Por favor, introduzca los consumos del bloque:");

        for (int contadorViviendas = 1; contadorViviendas <= 10; contadorViviendas++) {
            System.out.print("Consumo de la vivienda " + contadorViviendas + " (Kw): ");
            consumo = sc.nextDouble();

            if (consumo > mayorConsumo) {
                mayorConsumo = consumo;
                viviendaMayorConsumo = contadorViviendas;
            }
        }

        System.out.println("La vivienda que ha tenido un mayor consumo: (" + mayorConsumo + " Kw) es la numero: " + viviendaMayorConsumo);
    }
}

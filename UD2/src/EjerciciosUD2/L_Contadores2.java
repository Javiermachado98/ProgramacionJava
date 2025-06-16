package EjerciciosUD2;

import java.util.Scanner;
import java.util.Locale;

public class L_Contadores2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double consumo;
        double mayorConsumo = 0; // igualo a 0 para partir de ahi importante
        int viviendaMayorConsumo = 0;
        int viviendaMenorConsumo = 0;

        System.out.println("Por favor, introduzca los consumos del bloque:");

        for (int contadorViviendas = 1; contadorViviendas <= 10; contadorViviendas++) {
            System.out.print("Consumo de la vivienda " + contadorViviendas + " (Kw): ");
            consumo = sc.nextDouble();

            if (consumo > mayorConsumo) {
                mayorConsumo = consumo;
                viviendaMayorConsumo = contadorViviendas;
            }
            if (consumo < 20){
                viviendaMenorConsumo = viviendaMenorConsumo + 1;
            }
        }

        System.out.println("La vivienda que ha tenido un mayor consumo: (" + mayorConsumo + " Kw) es la numero: " + viviendaMayorConsumo);
        System.out.println("Número de viviendas que han consumido menos de 20 Kw: " + viviendaMenorConsumo + " viviendas ");

    }
}

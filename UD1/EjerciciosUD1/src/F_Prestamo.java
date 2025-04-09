package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class F_Prestamo {
    public static void main(String[] args) {
        int nPlazos;
        double importeTotal;
        double importe;
        double importePlazos;

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("ingresa el importe: ");
        importe = sc.nextInt();
        System.out.println("ingresa el numero de plazos: ");
        nPlazos = sc.nextInt();
        System.out.println("ingresa el importe por plazo: ");
        importePlazos = sc.nextInt();
        importeTotal = importe + (nPlazos * importePlazos);
        System.out.println("El importe total es: " + importeTotal);

    }
}
//Realiza un programa que calcule el importe total de un préstamo a partir del importe de la entrada,
// del número de plazos y del importe de cada plazo. Estos tres valores se los debemos solicitar al usuario
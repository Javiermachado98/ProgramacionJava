package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class I_Taquilla {
    public static void main(String[] args) {

        double importeTotal;
        double numeroAdultos;
        double numeroMenores;


        Scanner sc = new Scanner (System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese el numero de adultos: ");
        numeroAdultos = sc.nextDouble();
        System.out.println("Ingrese el numero de niños: ");
        numeroMenores = sc.nextDouble();

        importeTotal = (numeroAdultos * 6) + (numeroMenores * 3);
        System.out.println("El valor del precio total es: " + importeTotal + " por un determinado de : " + numeroMenores + " Niños " + numeroAdultos + " Adultos");
    }
}

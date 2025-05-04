package EjerciciosUD2;
import java.util.Scanner;

public class E_LetrasDias {
    public static void main(String[] args) {

        System.out.println("Ingrese el numero del 1 al 7: ");
        int numero = new Scanner (System.in).nextInt();

        switch (numero) {
            case 1 -> System.out.println("1 = lunes tiene 5 letras");
            case 2 -> System.out.println("2 = martes tiene 5 letras");
            case 3 -> System.out.println("3 = miércoles tiene 9 letras");
            case 4 -> System.out.println("4 = jueves tiene 6 letras");
            case 5 -> System.out.println("5 = viernes tiene 7 letras");
            case 6 -> System.out.println("6 = sábado tiene 6 letras");
            case 7 -> System.out.println("7 = domingo tiene 7 letras");
        }
    }
}
//        System.out.println("Escriba un mes del 1 al 12: ");
//        int mes = new Scanner (System.in).nextInt();
package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class E_IVA {
    public static void main(String[] args) {

        double precioNeto;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese el precio sin impuestos: ");
        precioNeto = sc.nextDouble();
        double iva = precioNeto * 0.21;
        System.out.println("El precio con IVA es: " + iva);
    }
}

//Realiza un programa que pida al usuario el precio sin impuestos (neto) de un artículo y devuelva su precio con IVA
// (supondremos que es un IVA fijo del 21%
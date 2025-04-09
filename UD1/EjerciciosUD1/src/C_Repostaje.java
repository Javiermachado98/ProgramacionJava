package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class C_Repostaje {
    public static void main(String[] args) {
        float precioGasolina;
        float numeroLitros;
        float precioFinal;

        Scanner sc = new Scanner (System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese el numero de litros de gasolina: ");
        numeroLitros = sc.nextFloat();

        System.out.println("Ingrese el valor del precio del litro del combustible: ");
        precioGasolina = sc.nextFloat();

        precioFinal = numeroLitros * precioGasolina;
        System.out.println("El valor total de : " + numeroLitros + " Litros de gasolina es : " + precioFinal + " Euros");

    }
}

//Realizar un programa que calcule el importe del repostaje de gasolina. Se solicitará al usuario el precio del litro de combustible, y el número de litros y se
//devolverá el importe a pagar.
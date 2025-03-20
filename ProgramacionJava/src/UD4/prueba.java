package UD4;
import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        int numeroa, numerob, resultado;
        System.out.println("ingrese el numero a: ");
        Scanner sc = new Scanner (System.in);
        numeroa = sc.nextInt();
        System.out.println("ingrese el numero b");
        numerob = sc.nextInt();

        resultado = numeroa + numerob;
        System.out.println("su resultado es: " + resultado);

    }
}

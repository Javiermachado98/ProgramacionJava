package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class D_Promedio {
    public static void main(String[] args) {
        float numero1, numero2, numero3, promedio;

        Scanner sc = new Scanner (System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese el primer numero: ");
        numero1 = sc.nextFloat();
        System.out.println("Ingrese el segundo numero: ");
        numero2 = sc.nextFloat();
        System.out.println("Ingrese el tercer numero: ");
        numero3 = sc.nextFloat();

        promedio = (numero1+numero2+numero3)/3;
        System.out.println("El promedio de los numeros: " +  numero1 +  numero2 +  numero3 + " es " + promedio);


    }
}

//Escribe un programa que pida tres números y calcule el promedio de ellos
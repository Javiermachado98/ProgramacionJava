package EjerciciosUD2;
import java.util.Scanner;

public class MayorEdad {

    public static void main(String[] args) {
        int edad;

        Scanner sc = new Scanner (System.in);
        System.out.println("Ingresa tu edad: ");
        edad = sc.nextInt();

        if (edad < 18) {
            System.out.println("Eres menor de edad");
        }else if (edad == 18){
            System.out.println("Acabas de cumplir los 18 años");
        }else
            System.out.println("Eres mayor de edad");
    }
}

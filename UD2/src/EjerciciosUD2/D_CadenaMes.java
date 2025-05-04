package EjerciciosUD2;
import java.util.Scanner;

public class D_CadenaMes {
    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingresa el numero");
        numero = sc.nextInt();

        if (numero == 1){
            System.out.println("Enero");
        }else if (numero == 2){
            System.out.println("Febrero");
        }else if (numero == 3){
            System.out.println("Marzo");
        }else if (numero == 4){
            System.out.println("Abril");
        }else if (numero == 5){
            System.out.println("Mayo");
        }else if (numero == 6){
            System.out.println("Junio");
        }else if (numero == 7){
            System.out.println("Julio");
        }else if (numero == 8){
            System.out.println("Agosto");
        }else if (numero == 9){
            System.out.println("Septiembre");
        }else if (numero == 10){
            System.out.println("Octubre");
        }else if (numero == 11){
            System.out.println("Noviembre");
        }else if (numero == 12){
            System.out.println("Diciembre");
        }

    }
}

package EjerciciosUD2;
import java.util.Scanner;

public class MultiploYMenor {
    public static void main(String[] args) {
        int numero;

        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un numero");
        numero = sc.nextInt();

        if (((numero % 3) == 0) && (numero < 10)){
            System.out.println("Multiplo de 3 y menor que 10");
        }
        else if ((numero % 3) == 0){
            System.out.println("Es multiplo de 3 y es mayor de 10");
        }
        else {
            System.out.println("No es multiplo de 3 o mayor o igual que 10");
        }
    }
}

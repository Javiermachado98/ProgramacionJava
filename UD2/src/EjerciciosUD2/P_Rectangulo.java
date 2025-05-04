package EjerciciosUD2;
import java.util.Scanner;

public class P_Rectangulo {
    public static void main(String[] args) {
        rectangulo();
    }
    public static void rectangulo(){
        int base, altura;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la base: ");
        base = sc.nextInt();
        System.out.println("Ingrese la altura: ");
        altura = sc.nextInt();
        System.out.println("Este es tu rectangulo: ");

        for (int i = 1; i <= altura; i++){
            System.out.println("*");
            for (int j = 1; j < base; j++){
                System.out.print("*");
            }
        }
    }
}

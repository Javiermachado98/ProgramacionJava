package EjerciciosUD2;
import java.util.Scanner;

public class Q_Triangulo {
    public static void main(String[] args) {
        int triangulo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa TRIANGULO a la carta \nIntroduce el valor del lado : ");
        triangulo = sc.nextInt();
        for (int i = 1; i <= triangulo; i++) {
            for (int j = 1; j <= (triangulo - i); j++) {
                System.out.print("-");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}

package EjerciciosUD2;
import java.util.Scanner;

public class yieldEJ {
    public static void main(String[] args) {
        System.out.println("Escriba un mes del 1 al 12: ");
        int mes = new Scanner (System.in).nextInt();
        if (mes >0 && mes <=12) {

            int dias = switch (mes) {
                case 1,3,5,7,8,10,12 -> { yield 31;} // 31 días
                case 2 -> { yield 28;} // 28 días
                case 4,6,9,11 -> { yield 30;} // 30 días
                default -> { System.out.println("El mes no es correcto"); yield -1; } //error
            };

            System.out.println("El mes " + mes + " tiene " + dias + " días");
        }
    }
}

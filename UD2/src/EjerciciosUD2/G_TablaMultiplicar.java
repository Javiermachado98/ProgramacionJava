package EjerciciosUD2;
import java.util.Scanner;

public class G_TablaMultiplicar {
    public static void main(String[] args) {
        int numero, resultado;
        Scanner sc = new Scanner (System.in);
        System.out.println("ingresa el valor del numero: ");
        numero = sc.nextInt();
        int i = 1;
        while (i < 10){
            resultado = i * numero;
            System.out.println("Multiplacion: " + i + "*" + numero + " = " + resultado);
            i++;
        }
    }
}
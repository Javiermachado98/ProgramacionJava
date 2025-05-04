package EjerciciosUD2;
import java.util.Scanner;

public class M_TablaFor {
    public static void main(String[] args) {
        //Se llama la funcion:
        multiplicar();
    }
    public static void multiplicar (){
        //Declaro variables y las capturo
        int resultado, numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor del numero: ");
        numero = sc.nextInt();
        //Ciclo
        for (int i = 1 ; i < 11; i++){
            resultado = numero * i;
            System.out.println(numero + "*" + i + " = " + resultado);
        }

    }
}

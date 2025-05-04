package EjerciciosUD2;
import java.util.Scanner;

public class O_ImparesHasta {
    public static void main(String[] args) {
        //Llamar funcion
        impares();

    }
    public static void impares(){
        //Declarar variables

        int numero, resultado;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero: ");
        numero = sc.nextInt();

        //Ciclo
        for (int i = 0; i < numero; i++){
            resultado = i % 2;

            //Condicional
            if (resultado == 1){
                System.out.println("el numero es impar: " + i);
            }

        }
    }
}

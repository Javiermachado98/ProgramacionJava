import java.util.Scanner;
import java.util.Arrays;


public class A_Numeros {
    public static void main(String[] args) {
        numeros();
    }
    public static void numeros(){

        final int cantidad = 9;
        int [] frecuencia;
        int numero, pares = 0, impares = 0, repetido = 0;
        int numRepetido = 0, numNoRepetido = 10;

        frecuencia = new int [cantidad];
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los numeros en el arreglo de una sola cifra: ");

        for (int i = 0; i < cantidad; i++) {
            numero = sc.nextInt();

            if (numero >= 1 && numero <= 9) {
                frecuencia[numero - 1]+=1;
            }
            else {
                System.out.println("el numero es incorrecto ya que no esta entre el 1 y 9");
                break;
            }

        }
        for (int i = 1; i <= cantidad; i++) {
            if (frecuencia[i - 1] == 0) {
                System.out.println("El numero : " + i + " no se eligio");
            }else{
                System.out.println("El numero: " + i + " si aparecio " + frecuencia[i - 1] + " veces");
            }
        }
        for (int i = 0; i < cantidad; i++) {
            // Buscar el número más frecuente
            if (frecuencia[i] > repetido) {
                repetido = frecuencia[i];
                numRepetido = i + 1; // Guardar el número con más apariciones
            }
            // Buscar el número menos frecuente
            if (frecuencia[i] < numNoRepetido && frecuencia[i] > 0) {
                numNoRepetido = frecuencia[i];
            }
            // Contar pares e impares
            if (i % 2 == 0) {
                pares += frecuencia[i]; // Si el número es par (índices 0, 2, 4, ...)
            } else {
                impares += frecuencia[i]; // Si el número es impar (índices 1, 3, 5, ...)
            }
        }

        System.out.println("El número más frecuente es: " + numRepetido + " con " + repetido + " apariciones.");
        System.out.println("El número menos frecuente es: " + numNoRepetido + " con " + (numNoRepetido > 0 ? numNoRepetido : "ninguna aparición"));
        System.out.println("Cantidad de pares: " + pares);
        System.out.println("Cantidad de impares: " + impares);
        System.out.println(Arrays.toString(frecuencia));
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class numero1 {
    public static void main(String[] args) {

        int cantidad = 10;
        int numeroUsuario;
        double miMedia = 0;
        int mayor = 0, posicionMenor = 0, menor = 0;
        int frecuencia, frecuenciaFinal = 0;
        int pares = 0, impares = 0;
        double acomuladorApariciones = 0;
        int[] mylista = new int[cantidad];
        int valorTemporalDeLaPosicion = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Si desea salir ingrese 10\n" +
                    "Ingrese un numero de 0 a 9 para llenar la lista: ");
            numeroUsuario = sc.nextInt();
            if (numeroUsuario >= 0 && numeroUsuario <= 9) {
                valorTemporalDeLaPosicion = mylista[numeroUsuario];
                valorTemporalDeLaPosicion++;
                mylista[numeroUsuario] = valorTemporalDeLaPosicion;
                System.out.println("El numero se agregado " + mylista[numeroUsuario] + " Veces");
            } else if (numeroUsuario == 10) {
                System.out.println("Revisa el menu, para mas opciones");

            } else {
                System.out.println("El numero esta fuera de rango");
            }
        }
        while (numeroUsuario != 10);

        for (int noRepetidos = 0; noRepetidos < cantidad; noRepetidos++) {
            if (mylista[noRepetidos] == 0) {
                System.out.println("Estos son los numeros que no han aparecido: ");
                System.out.println("No Repetidos: " + noRepetidos);
            }
            if (mylista[noRepetidos] != 0) {
                System.out.println("Estos son los numeros que han aparecido: ");
                System.out.println("Repetidos: " + noRepetidos);
            }
            if (mylista[noRepetidos] >= mayor){
                mayor = mylista[noRepetidos];
            }
        }
        for (int repetidos = 0; repetidos < cantidad; repetidos++){
            if (mylista[repetidos] == mayor){
                System.out.println("Numeros con mayor frecuencia: " + repetidos);
            }
            if (mylista[repetidos] < mayor && mylista[repetidos] != 0){
                System.out.println("Numeros con menor frecuencia: " + repetidos);
            }

        }
        for (int modulo = 0; modulo < cantidad; modulo++){
            if (modulo % 2 == 0){
                pares = pares + mylista[modulo];
            }
            else {
                impares = impares + mylista[modulo];
            }
        }
        System.out.println("Total de numeros pares: " + pares);
        System.out.println("Total de numeros impares: " + impares);
        System.out.println(Arrays.toString(mylista));
        /*
        for (int contadorMedia = 0; contadorMedia < cantidad; contadorMedia++){
            acomuladorApariciones = acomuladorApariciones + mylista[contadorMedia];
        }
        for (int contadorDivisiones = 0; contadorDivisiones < cantidad; contadorDivisiones++){
            miMedia = mylista[contadorDivisiones] / acomuladorApariciones;
            System.out.println("la media de apariciones de la posicion " + contadorDivisiones + " es: " + miMedia);
        }*/
        System.out.println("la media total es: " + acomuladorApariciones);

    }
}

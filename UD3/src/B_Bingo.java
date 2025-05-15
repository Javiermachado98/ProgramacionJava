import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class B_Bingo {
    public static void main(String[] args) {
        int cantidad = 10, aciertos = 0;
        int numerosBingo = 30;
        int numeroUsuario;
        boolean repetido = false;
        int[] myBingo = new int[cantidad];
        int[] bingo = new int[numerosBingo];
        Scanner sc = new Scanner(System.in);
        Random r = new Random();


        for (int contadorBingo = 0; contadorBingo < cantidad; contadorBingo++) {
            System.out.println("Ingrese el numero para su carton: ");
            numeroUsuario = sc.nextInt();

            if (numeroUsuario >= 1 && numeroUsuario <= 100) {

                for (int contadorConfirmador = 0; contadorConfirmador < cantidad; contadorConfirmador++) {
                    if (myBingo[contadorConfirmador] == numeroUsuario) { // la posicion de mi bingo es igual al numero del teclado
                        System.out.println("El numero esta repetido: " + numeroUsuario);
                        repetido = true; // mi bandera, pasa a ser true y si siempre esta en true, no avanza
                        contadorBingo--; // le resto iteraciones a mi lista, para ue siempre se llene
                    }
                }
                if (!repetido) {
                    myBingo[contadorBingo] = numeroUsuario; // Aqui le digo, que si la bandera es falsa agrega el valor
                } else {
                    repetido = false; // si no, agrega el numero normal y avanza con el ciclo
                }

            } else {
                System.out.println("Numero fuera de rango");
                contadorBingo--;
            }

        }
        System.out.println(Arrays.toString(myBingo));

        int contadorRandom = 0;
        while (contadorRandom < numerosBingo){
            int numeroRandom = r.nextInt(1, 50);

            boolean repetidoBingo = false;
            for (int revisionRandom = 0; revisionRandom < contadorRandom; revisionRandom++) {
                if (bingo[revisionRandom] == numeroRandom) {
                    repetidoBingo = true;
                    break;
                }
            }
            if (!repetidoBingo) {
                bingo[contadorRandom] = numeroRandom;
                contadorRandom++;
            }

        }
        System.out.println(Arrays.toString(bingo));


    }
}
